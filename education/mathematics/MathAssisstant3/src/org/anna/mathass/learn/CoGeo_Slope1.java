package org.anna.mathass.learn;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Date;
import java.util.Random;
import java.util.Stack;
import java.lang.Math;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import org.anna.mathass.practice.LabelScanThread;
import org.anna.mathass.res.DataInfo;
import org.anna.mathass.ui.CoGeoHome;
import org.anna.mathass.ui.Learn_CoGeo;
import org.anna.mathass.ui.Learn_Matrices;
import org.anna.mathass.ui.MatricsHome;
import org.anna.mathass.ui.UISettings;
import org.anna.mathass.ui.UIStatus;

/**
 * @author Leyagath
 *
 */
public class CoGeo_Slope1 extends JFrame implements MouseListener , Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @param args
	 */
	UIStatus nstatus,sstatus,ostatus,symstatus;

	JLabel ssLabel[],nsLabel,question;
	
	JTextPane workbook;

	char blinkChar = 'I';
	boolean clicked = false;
	JScrollPane jsp;
	LabelScanThread lst;
	JScrollBar vertical;
	int fsize;
	String fname;
	Robot robot;
	Dimension screenSize;
    int degree = 30;
    double radians;
	StringBuilder sb;
	String initWbContent;
	String cursContent;
	JPanel north,south,east,westBlank,nscanLabel;
String directoryPath = DataInfo.COORD_GEO_LEARN_QUES_DIR; 
	
	int fileCount;
 	File f; 
 	String filePrefix = "slopeang";
 	String fileName[];
	public CoGeo_Slope1()
	{
		setUndecorated(true);
	      screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	      setBounds(0,0,screenSize.width, screenSize.height);
	      loadQuestion();
	      JLabel jl = new JLabel();
		   Font ft= new Font(jl.getFont().getFontName(),Font.BOLD,jl.getFont().getSize()+UISettings.adFontSize);
		   Font fc= new Font(jl.getFont().getFontName(),Font.PLAIN,jl.getFont().getSize()+UISettings.adFontSize);
		   fsize = jl.getFont().getSize()+UISettings.adFontSize;
		   fname = jl.getFont().getFontName();
		   initWbContent = "<body bgcolor='"+UISettings.WorkBKBGColor+"' color='"+UISettings.WorkTextColor+"' style=\"font-size:"+(fsize -5 )+"; font-weight:bold;font-family:"+fname+";\"><center><span style=\"font-size: "+(fsize - 10)+"\"><b>Your Answer</b></span></center><tabel><tr>";
		  sb = new StringBuilder();
		  sb.append("<body bgcolor='"+UISettings.WorkBKBGColor+"' color='"+UISettings.WorkTextColor+"' style=\"font-size:"+(fsize -5 )+"; font-weight:bold;font-family:"+fname+";\"><center><span style=\"font-size: 20pt\"><b>Co-ordinate Geometry - Slope of a line (Angle form) </b></span></center>");
	      workbook = new JTextPane(); // creates an empty text pane
	      workbook.setContentType("text/html");                   
	      workbook.setText(sb.toString()); 
	      workbook.setEditable(false);// sets its text
	      jsp = new JScrollPane();
	      jsp.getViewport().add(workbook);
          north = new JPanel(new GridLayout(1,1));
          north.setOpaque(true);
          north.setBackground(UISettings.WinBGColor);
          south = new JPanel(new GridLayout(1,2,300,10));
          question = new JLabel("Find the slope of the line whose angle is ("+degree+")");
          question.setBackground(UISettings.WinBGColor);
          question.setForeground(UISettings.TextColor);
          question.setFont(fc);
          north.add(question);
          nscanLabel = new JPanel(new GridLayout(1,2,0,5));
          vertical = jsp.getVerticalScrollBar();
          try {
			robot = new Robot();
		} catch (AWTException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
          
       String tstr[]={"BACK","NEXT STEP"};
   	   ssLabel = new JLabel[tstr.length]; 
   	   for(int i=0;i<ssLabel.length;i++)
   	   {
   	ssLabel[i] = new JLabel(tstr[i]);
   	ssLabel[i].setBackground(UISettings.WinBGColor);
   	ssLabel[i].setOpaque(true);
   	ssLabel[i].setForeground(UISettings.TextColor);
   	ssLabel[i].setFont(fc);
   	ssLabel[i].setHorizontalAlignment(SwingConstants.CENTER);
   	south.add(ssLabel[i]);
   	   }
   	   westBlank = new JPanel();
   	   east = new JPanel();
   	   JLabel wl   = new JLabel("            ");
   	   westBlank.add(wl);
   	   westBlank.setOpaque(true);
   	   westBlank.setBackground(UISettings.WinBGColor);
   	   JLabel el   = new JLabel("            ");	
   	   east.setOpaque(true);
   	   east.setBackground(UISettings.WinBGColor);
   	   east.add(el);
   	   add(north,BorderLayout.NORTH);
   	   add(south,BorderLayout.SOUTH);
   	   add(westBlank,BorderLayout.WEST);
   	   add(east,BorderLayout.EAST);
   	   add(jsp);
   	   
   	   sstatus = new UIStatus();
	   sstatus.Visible=true;
	   sstatus.focused=0; 

	   
	      question.setHorizontalAlignment(SwingConstants.CENTER);
          this.addMouseListener(this);
          workbook.addMouseListener(this);
          north.addMouseListener(this);
          south.addMouseListener(this);
          east.addMouseListener(this);
          westBlank.addMouseListener(this);
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          //loadQuestion(0);
          new Thread(this).start();
          lst = new LabelScanThread(ssLabel,sstatus);
          lst.start();
	}
	
	@Override
	public void run() {
		try {
		while(!clicked)
		Thread.sleep(50);
	
		clicked = false;
		if(sstatus.focused == 0)
		{
			this.setVisible(false);
			new Learn_CoGeo().setVisible(true);
			sstatus.Visible = false;
			return;
		}
		ssLabel[0].setVisible(false);
		ssLabel[1].setVisible(false);
		Thread.sleep(UISettings.scanSpeed);
		workbook.setText(
		sb.append("Given : <br/> angle  = "+degree+" ").toString());
			
		Thread.sleep(UISettings.scanSpeed);
		//radians =Math.toRadians(degree);

		workbook.setText(
		sb.append("<br/>  Slope, m = tan Θ").toString());
		
			Thread.sleep(UISettings.scanSpeed);
	
		ssLabel[0].setVisible(true);
		ssLabel[1].setVisible(true);
		
		while(!clicked)
		Thread.sleep(50);
		
		while(!clicked)
			Thread.sleep(50);
			clicked = false;
			if(sstatus.focused == 0)
			{
				this.setVisible(false);
				new Learn_CoGeo().setVisible(true);
				sstatus.Visible = false;
				return;
			}
			ssLabel[0].setVisible(false);
			ssLabel[1].setVisible(false);
			Thread.sleep(UISettings.scanSpeed);
				workbook.setText(
				sb.append("<br/> Slope, m = tan("+degree+")").toString());
				Thread.sleep(UISettings.scanSpeed);
				if (degree == 0)
				workbook.setText(
							sb.append("<br/>  slope, m = 0 ").toString());
				else if(degree == 30)
					workbook.setText(
							sb.append("<br/>  slope, m = 1/&radic;3 ").toString());
				else if(degree == 45)
					workbook.setText(
							sb.append("<br/>  slope, m = 1 ").toString());
				else if(degree == 60)
					workbook.setText(
							sb.append("<br/>  slope, m = &radic;3 ").toString());
				else if(degree == 90)
					workbook.setText(
							sb.append("<br/>  slope, m = ∞ ").toString());
				
				Thread.sleep(UISettings.scanSpeed);
				ssLabel[0].setVisible(true);
				ssLabel[1].setVisible(true);
				while(!clicked)
					Thread.sleep(50);
					clicked = false;
					if(sstatus.focused == 0)
					{
						this.setVisible(false);
						new Learn_CoGeo().setVisible(true);
						sstatus.Visible = false;
						return;
					}
					ssLabel[0].setVisible(false);
					ssLabel[1].setVisible(false);
					Thread.sleep(UISettings.scanSpeed);
					 Thread.sleep(UISettings.scanSpeed);
				  //  workbook.setText(
					//		sb.append("<br/>   = &radic;("+(((x2-x1)*(x2-x1))+((y2-y1)*(y2-y1)))+")").toString());
				    Thread.sleep(UISettings.scanSpeed);
				    ssLabel[0].setVisible(true);
					ssLabel[1].setVisible(true);
					while(!clicked)
						Thread.sleep(50);
						clicked = false;
						if(sstatus.focused == 0)
						{
							this.setVisible(false);
							new Learn_CoGeo().setVisible(true);
							sstatus.Visible = false;
							return;
						}
						ssLabel[0].setVisible(false);
						ssLabel[1].setVisible(false);
						Thread.sleep(UISettings.scanSpeed);
						Thread.sleep(UISettings.scanSpeed);		
								ssLabel[1].setVisible(true);
								ssLabel[1].setText("DONE");
								while(!clicked)
									Thread.sleep(50);
								sstatus.Visible = false;
								this.setVisible(false);
								new Learn_CoGeo().setVisible(true);
								
	   }catch(Exception e)
	   {
		   e.printStackTrace();
	   }
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		           robot.mouseMove(screenSize.width - 80, screenSize.height - 80);
		           clicked = true;
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new CoGeo_Distance().setVisible(true);
	}

	//Load Question and generate question
	private void loadQuestion()
	{

		extractFileName();
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
			degree = Integer.parseInt(br.readLine());
			


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
				out.write("30\n");
				out.flush();
				out.close();
				
				out = new BufferedWriter(new OutputStreamWriter( new FileOutputStream(new File(directoryPath+filePrefix+"q2.ma"))));
				out.write("45\n");
				out.flush();
				out.close();
				
				out = new BufferedWriter(new OutputStreamWriter( new FileOutputStream(new File(directoryPath+filePrefix+"q3.ma"))));
				out.write("90\n");
				out.flush();
				out.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			loadQuestion();
		}
	}
	
	 private void extractFileName()
	   {
	   	 if((f= new File(directoryPath)).isDirectory())
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

	public void mouseEntered(MouseEvent arg0) {}
	public void mouseExited(MouseEvent arg0) {}
	public void mousePressed(MouseEvent arg0) {}
	public void mouseReleased(MouseEvent arg0) {}
}
