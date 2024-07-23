package org.anna.mathass.exam;

import java.awt.AWTException;
import java.awt.BorderLayout;
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
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Date;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import org.anna.mathass.practice.AnswerScreen;
import org.anna.mathass.practice.LabelScanThread;
import org.anna.mathass.practice.MatrixPractice;
import org.anna.mathass.practice.StringScanThread;
import org.anna.mathass.res.DataInfo;
import org.anna.mathass.ui.Main;
import org.anna.mathass.ui.MatricsHome;
import org.anna.mathass.ui.UISettings;
import org.anna.mathass.ui.UIStatus;

public class ExamMain extends JFrame implements MouseListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @param args
	 */
	UIStatus lstatus,sstatus,mstatus;
	
	static ExamMain parent=null;

	JLabel ssLabel[],wbselec[],nsLabel,msg,question;
	String scanTexthl [] = {"A","B","C","D","E","=","+","-","X","/","INSERT MATRIX","NEXT LINE","DELETE","LINE DELETE","CLEAR ALL","SCROLL UP","SCROLL DOWN","DONE"};
	String matdimen [] = {"    1    ","2","3","4","5"};
	String matelement [] = {"1","2","3","4","5","6","7","8","9","0","(",")","-","+","DELETE","  OK  "};
	String qdirectory = "D:\\MathAssist\\matrix\\practice\\";
	String qfiles[] = {"q1.txt","q2.txt","q3.txt","q4.txt","q5.txt"};
	String studans,autoans = "<center><span style=\"font-size: 20pt\"><b>Auto generated answer</b></span></center>";
	int qno = 0;
	String quest[] = {
			"Question 1",
			"Question 2",
			"Question 3",
			"Question 4",
			"Question 5"
			};
	
	StringBuilder ans[];
	Stack<Integer> linest,compst;
	JTextPane workbook;
	JLabel scanTextLab [] , matdimenLab[], matelementLab[];
	char blinkChar = 'I';
	JScrollPane jsp;
	StringScanThread sst;
	LabelScanThread lst;
	JScrollBar vertical;
	int fsize;
	String fname;
	Robot robot;
	int scramt = 1;
	Dimension screenSize;
	int r = 0,c = 0, rt = 0, ct = 0;
	boolean row = false ,col = false, element = false;
	String matel[][];
	StringBuilder sb;
	String initWbContent;
	String cursContent;
	int fileCount;
 	File f;
 	String directoryPath = DataInfo.EXAM_QUES_DIR;
	JPanel north,south,south1,east,westBlank,westMainScan,westMatScan,westMatDimScan,nscanLabel;
	public ExamMain()
	{
		setUndecorated(true);
		parent = this;
	      screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	      setBounds(0,0,screenSize.width, screenSize.height);
	      JLabel jl = new JLabel();
		   Font ft= new Font(jl.getFont().getFontName(),Font.BOLD,jl.getFont().getSize()+UISettings.adFontSize);
		   Font fc= new Font(jl.getFont().getFontName(),Font.PLAIN,jl.getFont().getSize()+UISettings.adFontSize);
		   fsize = jl.getFont().getSize()+UISettings.adFontSize;
		   fname = jl.getFont().getFontName();
		   ans = new StringBuilder[quest.length];
		   initWbContent = "<body bgcolor='"+UISettings.WorkBKBGColor+"' color='"+UISettings.WorkTextColor+"' style=\"font-size:"+(fsize -5 )+"; font-weight:bold;font-family:"+fname+";\"><center><span style=\"font-size: "+(fsize - 10)+"\"><b>Your Answer</b></span></center><tabel><tr>";
		   
		   for (int i = 0; i<ans.length; i++)
			   ans [i] = new StringBuilder("Question No. "+(i+1)+")<br/>");
		 
		  workbook = new JTextPane(); // creates an empty text pane
	      workbook.setContentType("text/html");                   
	      workbook.setText("<center><span style=\"font-size: 20pt\"><b>Select Question</b></span></center>"); 
	      workbook.setEditable(false);// sets its text
	      jsp = new JScrollPane();
	      jsp.getViewport().add(workbook);
          north = new JPanel(new GridLayout(1,2));
          north.setOpaque(true);
          north.setBackground(UISettings.WinBGColor);
          south = new JPanel(new GridLayout(1,4,100,10));
          south1 = new JPanel(new GridLayout(1,4,100,10));
          question = new JLabel("Question Image");
          north.add(question);
          nscanLabel = new JPanel(new GridLayout(1,2,0,5));
          vertical = jsp.getVerticalScrollBar();
          try {
			robot = new Robot();
		} catch (AWTException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
          

   	   nsLabel = new JLabel("  ");
   	   msg     = new JLabel("  ");
   	nsLabel.setBackground(UISettings.WinBGColor);
   	nsLabel.setOpaque(true);
   	nsLabel.setForeground(UISettings.TextColor);
   	nsLabel.setFont(ft);
   	nsLabel.setHorizontalAlignment(SwingConstants.CENTER);
   	
   	msg.setBackground(UISettings.WinBGColor);
   	msg.setOpaque(true);
   	msg.setForeground(UISettings.TextColor);
   	msg.setFont(fc);
   	msg.setHorizontalAlignment(SwingConstants.CENTER);
    String tstr[]={"PREV","NEXT","SOLVE","DONE"};
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
   	String tstr1[]={"MATRIX","CO-GEO","BACK","DONE"};
   	wbselec = new JLabel[tstr1.length];
   	   for(int i=0;i<wbselec.length;i++)
   	   {
   		wbselec[i] = new JLabel(tstr1[i]);
   		wbselec[i].setBackground(UISettings.WinBGColor);
   		wbselec[i].setOpaque(true);
   		wbselec[i].setForeground(UISettings.TextColor);
   		wbselec[i].setFont(fc);
   		wbselec[i].setHorizontalAlignment(SwingConstants.CENTER);
   		south1.add(wbselec[i]);
   	   }
   	   //south.add(wbselec[i]);
   	   nscanLabel.add(msg);
   	   nscanLabel.add(nsLabel);
   	   north.add(nscanLabel);
   	   
   	   westMainScan = new JPanel(new GridLayout(scanTexthl.length,1));
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

	   lstatus = new UIStatus();
   	   lstatus.Visible=true;
   	   lstatus.focused=0; 
   	   
   	   sstatus = new UIStatus();
	   sstatus.Visible=false;
	   sstatus.focused=0;  
	   
	   question.setHorizontalAlignment(SwingConstants.CENTER);
   	      compst = new Stack<Integer>();
   	      linest = new Stack<Integer>();
          this.addMouseListener(this);
          workbook.addMouseListener(this);
          north.addMouseListener(this);
          south.addMouseListener(this);
          east.addMouseListener(this);
          westBlank.addMouseListener(this);
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

          extractFileName();
          loadQuestion(qno);

          question.setForeground(UISettings.TextColor);
		   question.setFont(ft);
          lst = new LabelScanThread(ssLabel,lstatus);
          lst.start();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new MatrixPractice().setVisible(true);
	}
	void resume()
	{
		   sstatus.Visible = true;
		   workbook.setText("<center><span style=\"font-size: 20pt\"><b>Select WorkSheet Type</b></span></center>"); 
		   lst = new LabelScanThread(wbselec,sstatus);
	       lst.start();
	       setVisible(true);
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		robot.mouseMove(screenSize.width - 80, screenSize.height - 80);
		// TODO Auto-generated method stub
		//boolean fromsolve = false;
		if(lstatus.Visible)
		{	
		
		 switch(lstatus.focused)
		   {
		   case 0 :
			   qno = (qno > 0)?(--qno):quest.length - 1;
		        //if(!fromsolve)
				loadQuestion(qno);
			
			   break;
		   case 1 :
			  // System.out.print("\nnext called");
			   qno = (qno < quest.length -1)?(++qno): 0;
			   loadQuestion(qno);
			   break;
		   case 2 :
			   lstatus.Visible = false;
			   sstatus.Visible = true;
			   workbook.setText("<center><span style=\"font-size: 20pt\"><b>Select WorkSheet Type</b></span></center>"); 
			   lst = new LabelScanThread(wbselec,sstatus);
		       lst.start();
		       remove(south);
		       add(south1,BorderLayout.SOUTH);
		       validate();
		       repaint();
		       //fromsolve = true;
		       lst = new LabelScanThread(wbselec,sstatus);
		       lst.start();
			   break;
			   
		   case 3 :

			   showAns();
			   break;
		   }
		}
		else if(sstatus.Visible)
		{	
		
		 switch(sstatus.focused)
		   {
		   case 0 :
			   new MatrixWorkbook(quest[qno],ans[qno]).setVisible(true);
			   sstatus.Visible=false;
			   setVisible(false);
			   break;
		   case 1 :
			   new CoGeoWorkbook(quest[qno],ans[qno]).setVisible(true);
			   sstatus.Visible=false;
			   setVisible(false);
			   break;
		   case 2 :
			   lstatus.Visible = true;
			   sstatus.Visible = false;
			   sb = new StringBuilder(initWbContent); 
			   workbook.setText("<center><span style=\"font-size: 20pt\"><b>Select Question</b></span></center>"); 
		       remove(south1);
		       add(south,BorderLayout.SOUTH);
		       validate();
		       repaint();
		       lst = new LabelScanThread(ssLabel,lstatus);
		       lst.start();
			   break;
		   case 3 :
			   showAns();
			   break;
			   
		   }
		}
			
	}
	private void showAns()
	{
		new Main().setVisible(true);
		   lstatus.Visible=false;
		   sstatus.Visible=false;
		   setVisible(false);
		   String filepath = DataInfo.EXAM_ANSWER_DIR+"ans"+new Date().getTime()+".html";
		   File f = new File(filepath);
		   System.out.println(f.getAbsolutePath());
		   try {
			BufferedWriter br = new BufferedWriter(new FileWriter( f));
			for(int i = 0; i < ans.length; i++)
			br.write(ans[i].toString());
			br.flush();
			br.close();
			Process p=Runtime.getRuntime().exec("cmd /c start "+f.getAbsolutePath());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
	//Load Question and generate question
	private void loadQuestion(int qno) //throws Exception
	{
		
		File f = new File(directoryPath+quest[qno]);
		StringBuilder quest=  new StringBuilder();
		try {
			//** load question and generate answer
			InputStreamReader in = new InputStreamReader(new FileInputStream(f));
			BufferedReader br = new BufferedReader(in);
			String line;
			while( (line = br.readLine())!= null )
				quest.append(line);
			question.setText(quest.toString());
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	private void extractFileName()
	   {
	   	 if((f= new File(directoryPath)).isDirectory())
		      {
					String[] files = f.list();
					fileCount = 0;
					for(String file : files)
							++fileCount;
			
					quest = new String[fileCount];
	               for(int i = 0; i< files.length; i++)
	              	quest[i] = files[i];
			}
	   }
	@Override
	public void mouseEntered(MouseEvent arg0) {
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub		
	}

}
