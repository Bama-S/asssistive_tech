package org.anna.mathass.learn;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Date;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import org.anna.mathass.res.DataInfo;
import org.anna.mathass.ui.Learn_Matrices;
import org.anna.mathass.ui.ScanThread;
import org.anna.mathass.ui.UISettings;
import org.anna.mathass.ui.UIStatus;

public class MatrixMultiplication extends JFrame implements MouseListener, Runnable {

	private static final long serialVersionUID = 1L;
	JLabel Topic[],ScreenTitle,Desc;
	   Boolean clicked = false;
	   int matA[][];
       int matB[][];
       JLabel matAl[][],matBl[][],matc[][];
       Dimension screenSize;
       boolean drawline = false;
       String directoryPath = DataInfo.MATRIX_LEARN_QUES_DIR; 
	 	String filePrefix = "mul";
	 	String fileName[];
       
		 int xs,ys,xe,ye;
	     int x1,x2,y1,y2;
	     
	     int r1,c1,r2,c2;
	     int fileCount;
	     File f;
	     
	   public MatrixMultiplication()
	   {
		   setUndecorated(true);
		   //loding matrix from file
		   loadMatrix();
		      screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		      setBounds(0,0,screenSize.width, screenSize.height);
		      //Hard Coded Value
		      
		   //Font purpos
		   JLabel jl = new JLabel();
		   Font ft= new Font(jl.getFont().getFontName(),Font.BOLD,jl.getFont().getSize()+UISettings.adFontSize);
		   
		   ScreenTitle = new JLabel("MULTIPLICATION OF MATRICES");
		   ScreenTitle.setSize( 800, 50);
		   ScreenTitle.setBackground(UISettings.WinBGColor);
		   ScreenTitle.setForeground(UISettings.TextColor);
		   //ScreenTitle.setBackground(Color.BLACK);
		   ScreenTitle.setOpaque(true);
		   //ScreenTitle.setForeground(Color.GRAY);
		   ScreenTitle.setFont(ft);
		   ScreenTitle.setHorizontalAlignment(SwingConstants.CENTER);
		   add(ScreenTitle, BorderLayout.NORTH);
		   Desc = new JLabel("<html>For matrix multiplication to work, the columns of the second matrix have to have the same number of entries as do the rows of the first matrix.<br/>The product matrix's dimensions are →(rows of first matrix) × (columns of the second matrix )</html>");
		   Desc.setSize( 800, 50);
		   Desc.setBackground(UISettings.WinBGColor);
		   Desc.setOpaque(true);
		   Desc.setForeground(UISettings.TextColor);
		   Desc.setFont(ft);
		   Desc.setHorizontalAlignment(SwingConstants.CENTER);
		   Desc.setBackground(UISettings.WinBGColor);
		   Desc.setForeground(UISettings.TextColor);
		   add(Desc, BorderLayout.CENTER);
           Thread t = new Thread(this);
           t.start();

		   	addMouseListener(this); 
		   	Desc.addMouseListener(this);
		   	ScreenTitle.addMouseListener(this);
		   	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   	repaint();	   
}
	   
	   private void loadMatrix()
		{   extractFileName();
			if(fileCount > 0)
			{
			Random rand = new Random(new Date().getTime());
			int index = rand.nextInt()%fileName.length;
			index = (index < 0)? -index:index;
			//System.out.println("index"+index);
			f = new File(directoryPath+fileName[index]);
			InputStreamReader in;
			try {
				in = new InputStreamReader(new FileInputStream(f));
				BufferedReader br = new BufferedReader(in);
				r1 = Integer.parseInt(br.readLine());
				c1 = Integer.parseInt(br.readLine());
				r2 = Integer.parseInt(br.readLine());
				c2 = Integer.parseInt(br.readLine());
				matA = new int[r1][c1];
				matB = new int[r2][c2];
				
				for(int i = 0; i < r1; i++)
				for(int j = 0; j < c1; j++)
					matA[i][j] = Integer.parseInt(br.readLine());
				
				for(int i = 0; i < r2; i++)
					for(int j = 0; j < c2; j++)
						matB[i][j] = Integer.parseInt(br.readLine());
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			else
			{   
				BufferedWriter out;
				try{
					out = new BufferedWriter(new OutputStreamWriter( new FileOutputStream(new File(directoryPath+filePrefix+"q1.ma"))));
					out.write("3\n3\n3\n3\n12\n21\n22\n13\n9\n17\n25\n31\n33\n22\n11\n33\n25\n14\n30\n18\n27\n36\n");
					out.flush();
					out.close();
					
					out = new BufferedWriter(new OutputStreamWriter( new FileOutputStream(new File(directoryPath+filePrefix+"q2.ma"))));
					out.write("3\n2\n2\n3\n12\n21\n22\n13\n9\n17\n25\n33\n25\n14\n30\n18\n");
					out.flush();
					out.close();
					
					out = new BufferedWriter(new OutputStreamWriter( new FileOutputStream(new File(directoryPath+filePrefix+"q3.ma"))));
					out.write("2\n2\n2\n2\n22\n13\n9\n17\n33\n25\n14\n30\n");
					out.flush();
					out.close();
				}catch(Exception e)
				{
					e.printStackTrace();
				}
				loadMatrix();
			}
		}
		
   private void extractFileName()
   {
   	 if((f= new File(DataInfo.MATRIX_LEARN_QUES_DIR)).isDirectory())
	      {
				String[] files = f.list();
				fileCount = 0;
				for(String file : files)
					if(file.contains(filePrefix))
						++fileCount;
				if(fileCount > 0)
				{
				fileName = new String[fileCount];
               for(int i = 0, j =0; i< files.length; i++)
               if(files[i].contains(filePrefix))
              	fileName[j++] = files[i];
				}
		  }
   }

	public void paint(Graphics g) {
		super.paint(g);
       
		if(drawline)
			
        {
		Graphics2D g2 = (Graphics2D)g;
	    g2.setStroke(new BasicStroke(3));
	    g2.setColor(UISettings.TextColor);
	    
	    ys = (screenSize.height/3) - (screenSize.height/6) + 2;
		ye = (screenSize.height/3) - 8 ;
		xs = (screenSize.width/4) +2 ;
		xe = (screenSize.width/2) -2 ;
		// Lines for Matt a
		x1 = x2 = xs;
		y1 = ys;
		y2 = ye;
		g2.drawLine(x1,y1,x2,y2);
		g2.drawLine(x1, y1, x1+8, y1);
		g2.drawLine(x1, y2, x1+8, y2);
		x1 = x2 = xe;
		y1 = ys;
		y2 = ye;
    	g2.drawLine(x1,y1,x2,y2);
    	g2.drawLine(x1, y1, x1-8, y1);
		g2.drawLine(x1, y2, x1-8, y2);
		
		xs = (3*(screenSize.width)/4) +2 ;
		xe = (screenSize.width) -8 ;
		
		// lines for matt b
		
		x1 = x2 = xs;
		y1 = ys;
		y2 = ye;
		g2.drawLine(x1,y1,x2,y2);
		g2.drawLine(x1, y1, x1+8, y1);
		g2.drawLine(x1, y2, x1+8, y2);
		x1 = x2 = xe;
		y1 = ys;
		y2 = ye;
    	g2.drawLine(x1,y1,x2,y2);
    	g2.drawLine(x1, y1, x1-8, y1);
		g2.drawLine(x1, y2, x1-8, y2);
		
    	drawline = false;
    	
    	ys = 2*(screenSize.height/3)+ 4 ;
		ye = (screenSize.height) - (screenSize.height/6)-2;
		xs = (screenSize.width/3)  ;
		xe = 2*(screenSize.width/3) ;
		
		// lines for answer matrix
		
		x1 = x2 = xs;
		y1 = ys;
		y2 = ye;
		g2.drawLine(x1,y1,x2,y2);
		g2.drawLine(x1, y1, x1+8, y1);
		g2.drawLine(x1, y2, x1+8, y2);
		x1 = x2 = xe;
		y1 = ys;
		y2 = ye;
    	g2.drawLine(x1,y1,x2,y2);
    	g2.drawLine(x1, y1, x1-8, y1);
		g2.drawLine(x1, y2, x1-8, y2);
		
        }

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(!clicked){
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		clicked = false;
		drawline = true;
		this.remove(Desc);
		this.remove(ScreenTitle);
		JPanel np = new JPanel(new GridLayout(2,1));
		JPanel cp = new JPanel(new GridLayout(3,1));
		JPanel sp = new JPanel(new GridLayout(2,1));
		np.add(ScreenTitle);
		JPanel mqp =  new JPanel(new GridLayout(1,4));
		JPanel dp1,dp2,dp3;
		
		cp.setOpaque(true);
		cp.setBackground(UISettings.WinBGColor);
		cp.setForeground(UISettings.TextColor);
		
		JLabel matrixALabel[][] = new JLabel[matA.length][matA[0].length]; 
		JLabel matrixBLabel[][] = new JLabel[matB.length][matB[0].length]; 
		JLabel matrixCLabel[][] = new JLabel[matA.length][matB[0].length]; 
		
		JPanel mq1 = new JPanel(new GridLayout(matA.length,matA[0].length));
		JPanel mq2 = new JPanel(new GridLayout(matB.length,matB[0].length));
		JPanel mag = new JPanel( new GridLayout(matA.length,matB[0].length));
		
		JLabel num;
		JLabel jl = new JLabel();
		JLabel matl[] = new JLabel[3];
		matl[0] = new JLabel("\n Matrix A   = ");
		matl[1] = new JLabel("\n Matrix B   = ");
		matl[2] = new JLabel("Result Matrix A x B =");
		Font ft= new Font(jl.getFont().getFontName(),Font.BOLD,jl.getFont().getSize()+UISettings.adFontSize);
		
		matl[0].setFont(ft);
		matl[1].setFont(ft);
		matl[2].setFont(ft);
		
		matl[0].setForeground(UISettings.TextColor);
		matl[1].setForeground(UISettings.TextColor);
		matl[2].setForeground(UISettings.TextColor);
		
		matl[0].setBackground(UISettings.WinBGColor);
		matl[1].setBackground(UISettings.WinBGColor);
		matl[2].setBackground(UISettings.WinBGColor);
		
		matl[0].setHorizontalAlignment(SwingConstants.CENTER);
		matl[1].setHorizontalAlignment(SwingConstants.CENTER);
		matl[2].setHorizontalAlignment(SwingConstants.CENTER);
		
		dp1 =  new JPanel(new GridLayout(3,1));
		dp2 =  new JPanel(new GridLayout(3,1));
		//dp3 =  new JPanel();
		
		JLabel jld1,jld2,jld3;
		jld1 = new JLabel("");
		jld2 = new JLabel("");
		jld3 = new JLabel("");matl[0].setForeground(UISettings.TextColor);
		matl[1].setForeground(UISettings.TextColor);
		matl[2].setForeground(UISettings.TextColor);
		
		matl[0].setBackground(UISettings.WinBGColor);
		matl[1].setBackground(UISettings.WinBGColor);
		matl[2].setBackground(UISettings.WinBGColor);
		
		dp1.add(jld1);
		dp1.add(matl[0]);
		dp2.add(jld2);
		dp2.add(matl[1]);
		dp1.setBackground(UISettings.WinBGColor);
		dp2.setBackground(UISettings.WinBGColor);

		for(int i=0; i< matA.length ; i++)
			for(int j = 0; j<matA[0].length; j++)
			{   matrixALabel[i][j] = new JLabel(""+matA[i][j]);
			    matrixALabel[i][j].setOpaque(true);
			    matrixALabel[i][j].setFont(ft);
			    matrixALabel[i][j].setBackground(UISettings.WinBGColor);
			    matrixALabel[i][j].setForeground(UISettings.TextColor);
			    //num.setBorder(BorderFactory.createLineBorder(Color.black));
			    matrixALabel[i][j].setHorizontalAlignment(SwingConstants.CENTER);
			    mq1.add(matrixALabel[i][j]);
			}
		for(int i=0; i< matB.length ; i++)
			for(int j = 0; j<matB[0].length; j++)
			{
				matrixBLabel[i][j] = new JLabel(""+matB[i][j]);
			    matrixBLabel[i][j].setOpaque(true);
			    matrixBLabel[i][j].setFont(ft);
			    matrixBLabel[i][j].setBackground(UISettings.WinBGColor);
			    matrixBLabel[i][j].setForeground(UISettings.TextColor);
			    //num.setBorder(BorderFactory.createLineBorder(Color.black));
			    matrixBLabel[i][j].setHorizontalAlignment(SwingConstants.CENTER);
			    mq2.add(matrixBLabel[i][j]);
			}
		mqp.add(dp1);
		mqp.add(mq1);
		mqp.add(dp2);
		mqp.add(mq2);
		//mqp.add(dp3);
		np.add(mqp);
		
		cp.add(new JLabel());
		JLabel step = new JLabel();
		step.setBackground(UISettings.WinBGColor);
		step.setForeground(UISettings.TextColor);
		step.setOpaque(true);
		step.setFont(ft);
		step.setSize(400,50);
		cp.add(step);
		cp.add(new JLabel());
		
		JPanel map = new JPanel(new GridLayout(1,3));
		
		JPanel mal = new JPanel(new GridLayout(3,1));
		mal.setBackground(UISettings.WinBGColor);
		mal.add(new JLabel(""));
		mal.add(matl[2]);
		mal.add(new JLabel(""));
		
		    for(int i=0; i< matA.length ; i++)
			for(int j = 0; j<matB[0].length; j++)
			{
				matrixCLabel[i][j] = new JLabel("C"+(i+1)+(j+1));
			    matrixCLabel[i][j].setOpaque(true);
			    matrixCLabel[i][j].setFont(ft);
			    matrixCLabel[i][j].setBackground(UISettings.WinBGColor);
			    matrixCLabel[i][j].setForeground(UISettings.TextColor);
			    //num.setBorder(BorderFactory.createLineBorder(Color.black));
			    matrixCLabel[i][j].setHorizontalAlignment(SwingConstants.CENTER);
			    mag.add(matrixCLabel[i][j]);
			}
		
		JPanel spmat = new JPanel(new GridLayout(1,3));
		JPanel dp =new JPanel();
		dp.setBackground(UISettings.WinBGColor);
		spmat.add(mal);
		spmat.add(mag);
		spmat.add(dp);
		
		JLabel nextBack[] = new JLabel[2];
		nextBack[0] = new JLabel("BACK");
		nextBack[1] = new JLabel("NEXT STEP");
		nextBack[0].setFont(ft);
		nextBack[0].setSize(800,50);
		nextBack[0].setHorizontalAlignment(SwingConstants.CENTER);
		nextBack[0].setOpaque(true);
		nextBack[1].setFont(ft);
		nextBack[1].setSize(800,50);
		nextBack[1].setHorizontalAlignment(SwingConstants.CENTER);
		nextBack[1].setOpaque(true);
		nextBack[1].setForeground(UISettings.TextColor);
		nextBack[1].setBackground(UISettings.WinBGColor);
		JPanel nbpanel  = new JPanel( new GridLayout(3,6));
		nbpanel.setOpaque(true);
		nbpanel.setBackground(UISettings.WinBGColor);
		for(int i = 0;i < 3; i++)
		for(int j = 0;j < 6; j++)
		{
			if(i == 1 && j == 1)
				nbpanel.add(nextBack[0]);
			else if(i == 1 && j == 4)
				nbpanel.add(nextBack[1]);
			else
			nbpanel.add(new JLabel("  "));
			
		}
		UIStatus status = new UIStatus();
		status.Visible = true;
		status.focused = 0;
	    ScanThread scanthread = new ScanThread(nextBack, status);
		
	    sp.add(spmat);
		sp.add(nbpanel);
		scanthread.start();
		
		add(np, BorderLayout.NORTH);
		add(cp, BorderLayout.CENTER);
		add(sp, BorderLayout.SOUTH);
			
		validate();
		repaint();
		
		step.setText(" Cij = (Ai1 X B1j) + (Ai2 X B2j) + ...+(Ain X Bnj ) ");
		step.setHorizontalAlignment(SwingConstants.CENTER);
		
		while(!clicked){
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	    clicked = true;
	    if(status.focused == 0)
		{
			this.setVisible(false);
			new Learn_Matrices().setVisible(true);
			status.Visible = false;
			return;
		}
	    
		long sleeptime = UISettings.scanSpeed+200;
		StringBuilder sb,fsb;
		String equation;
		int element;
		try{
		for(int i=0; i< matA.length ; i++)
		for(int j = 0; j<matB[0].length; j++)
		{   
			sb = new StringBuilder();
		    fsb = new StringBuilder("C"+(i+1)+(j+1)+" = ");
		    
		    
		    element =  0;
		    nextBack[0].setVisible(true);
			nextBack[1].setVisible(true);
			
			while(!clicked){
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			clicked = false;
	
			if(status.focused == 0)
			{
				this.setVisible(false);
				new Learn_Matrices().setVisible(true);
				status.Visible = false;
				return;
			}
			
			nextBack[0].setVisible(false);
			nextBack[1].setVisible(false);
		    Color dimHighlight = new Color(UISettings.HighlightBGColor.getRed(),UISettings.HighlightBGColor.getGreen(),UISettings.HighlightBGColor.getBlue(),UISettings.HighlightBGColor.getAlpha()-100);
			for(int k = 0; k < matA[0].length; k++)
			{  
				fsb.append("( A"+(i+1)+(k+1)+" X B"+(k+1)+(j+1)+" )");
				matrixALabel[i][k].setBackground(dimHighlight);
				matrixALabel[i][k].setForeground(UISettings.HighlightTextColor);
				matrixBLabel[k][j].setBackground(dimHighlight);
				matrixBLabel[k][j].setForeground(UISettings.HighlightTextColor);
				if(k+1 < matA[0].length)
					fsb.append(" + ");
			}
			step.setText(equation = fsb.toString());
			matrixCLabel[i][j].setBackground(UISettings.HighlightBGColor);
			matrixCLabel[i][j].setForeground(UISettings.HighlightTextColor);
		    
		    Thread.sleep((long)(sleeptime*1.5));
		    
		for(int k = 0; k < matA[0].length; k++)
			{   
				element += matA[i][k] * matB[k][j];
			    Thread.sleep(sleeptime);
			    matrixALabel[i][k].setBackground(UISettings.HighlightBGColor);
				equation = equation.replace("A"+(i+1)+(k+1), ""+matA[i][k]);
				Thread.sleep(sleeptime);
				step.setText(equation);
				Thread.sleep(sleeptime);
				matrixBLabel[k][j].setBackground(UISettings.HighlightBGColor);
				Thread.sleep(sleeptime);
				equation = equation.replace("B"+(k+1)+(j+1), ""+matB[k][j]);
				step.setText(equation);
				matrixALabel[i][k].setBackground(dimHighlight);
				matrixBLabel[k][j].setBackground(dimHighlight);
				
				if(k+1 == matA[0].length)
				{
					fsb = new StringBuilder(equation);
					Thread.sleep(sleeptime);
					fsb.append(" = ");
					step.setText(fsb.toString());
					Thread.sleep(sleeptime);
					fsb.append(""+element);
					step.setText(fsb.toString());
					matrixCLabel[i][j].setText(""+element);
				}
			}
		
		Thread.sleep(sleeptime);
		
		for(int k = 0; k < matA[0].length; k++)
		{  
			matrixALabel[i][k].setBackground(UISettings.WinBGColor);
			matrixALabel[i][k].setForeground(UISettings.TextColor);
			matrixBLabel[k][j].setBackground(UISettings.WinBGColor);
			matrixBLabel[k][j].setForeground(UISettings.TextColor);
		}
		matrixCLabel[i][j].setBackground(UISettings.WinBGColor);
	    matrixCLabel[i][j].setForeground(UISettings.TextColor);
	    drawline = true;
		repaint();
	   // msg.setText("Tap to proceed next step...");
		 /* nextBack[0].setVisible(true);
			nextBack[1].setVisible(true);
		while(!clicked);
	    clicked = false;
	    if(status.focused == 0)
		{
			this.setVisible(false);
			new Learn_Matrices().setVisible(true);
			status.Visible = false;
			return;
		}
		
		nextBack[0].setVisible(false);
		nextBack[1].setVisible(false);
	    */
	
	//    msg.setText("");

		  }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		nextBack[1].setVisible(true);
		nextBack[1].setText("Done");
		status.Visible = false;
		nextBack[1].setBackground(UISettings.HighlightBGColor);
		nextBack[1].setForeground(UISettings.HighlightTextColor);
		while(!clicked){
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.setVisible(false);
		new Learn_Matrices().setVisible(true);

	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		clicked = true;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}
}
