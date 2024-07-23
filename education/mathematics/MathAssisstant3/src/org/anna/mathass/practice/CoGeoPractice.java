/**
 * 
 */
package org.anna.mathass.practice;

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
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import org.anna.mathass.res.DataInfo;
import org.anna.mathass.ui.CoGeoHome;
import org.anna.mathass.ui.Learn_CoGeo;
import org.anna.mathass.ui.MatricsHome;
import org.anna.mathass.ui.UISettings;
import org.anna.mathass.ui.UIStatus;

/**
 * @author Leyagath
 *
 */
public class CoGeoPractice extends JFrame implements MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @param args
	 */
	UIStatus nstatus,sstatus,ostatus,symstatus;

	JLabel ssLabel[],nsLabel,msg,question;
	String scanNum[] = {" 0  "," 1  "," 2  "," 3  "," 4  "," 5  "," 6  "," 7  "," 8  "," 9  ","DEL","NewLine","OPERATORS","SYMBOLS","DONE"};
	String scanOpt[] = {" =  "," +  "," -  "," X  "," /  "," (  "," )  "," \u221A  ","<html>N<sup>2</sup></html>","<html>N<sup>3</sup></html>","DEL","NewLine","NUMBERS","SYMBOLS","DONE"};
	String scanSym[] = {"X ","Y ","A ","B ","P ","Q ","l ","m ","<html>N<sub>1</sub></html>","<html>N<sub>2</sub></html>","<html>N<sub>3</sub></html>","<html>N<sub>4</su></html>","DEL","NewLine","NUMBERS","OPERATIONS","DONE"};
	String qdirectory = DataInfo.COORD_GEO_PRAC_QUES_DIR;
	String qfiles[];
	String studans,autoans = "<center><span style=\"font-size: 20pt\"><b>Auto generated answer</b></span></center>";
	int qno = 0;
	Stack<Integer> linest,compst;
	JTextPane workbook;
	JLabel scanTextLab [] , scanOptLab[], scanSymLab[];
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
	JPanel north,south,east,westBlank,westNumScan,westOptScan,westSymScan,nscanLabel;
	int fileCount;
 	File f;
 	String directoryPath = DataInfo.COORD_GEO_PRAC_QUES_DIR; 
 	String fileName[];
	public CoGeoPractice()
	{
		setUndecorated(true);
	      screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	      setBounds(0,0,screenSize.width, screenSize.height);
	      JLabel jl = new JLabel();
		   Font ft= new Font(jl.getFont().getFontName(),Font.BOLD,jl.getFont().getSize()+UISettings.adFontSize);
		   Font fc= new Font(jl.getFont().getFontName(),Font.PLAIN,jl.getFont().getSize()+UISettings.adFontSize);
		   fsize = jl.getFont().getSize()+UISettings.adFontSize;
		   fname = jl.getFont().getFontName();
		   initWbContent = "<body bgcolor='"+UISettings.WorkBKBGColor+"' color='"+UISettings.WorkTextColor+"' style=\"font-size:"+(fsize -5 )+"; font-weight:bold;font-family:"+fname+";\"><center><span style=\"font-size: "+(fsize - 10)+"\"><b>Your Answer</b></span></center><tabel><tr>";
		  sb = new StringBuilder();
		  sb.append("<center><span style=\"font-size: 20pt\"><b>Co-ordinate Geomatry Work Sheet</b></span></center>");
	      workbook = new JTextPane(); // creates an empty text pane
	      workbook.setContentType("text/html");                   
	      workbook.setText(sb.toString()); 
	      workbook.setEditable(false);// sets its text
	      jsp = new JScrollPane();
	      jsp.getViewport().add(workbook);
          north = new JPanel(new GridLayout(1,1));
          north.setOpaque(true);
          north.setBackground(UISettings.WinBGColor);
          south = new JPanel(new GridLayout(1,4,100,10));
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
          
       String tstr[]={"PREV","NEXT","SOLVE","CO-GEO HOME"};
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
   	   /*nscanLabel.add(msg);
   	   nscanLabel.add(nsLabel);
   	   north.add(nscanLabel);
   	   */
   	   westNumScan = new JPanel(new GridLayout(scanNum.length,1));
   	   westBlank = new JPanel();
   	   east = new JPanel();
   	   JLabel wl   = new JLabel("            ");
   	   westBlank.add(wl);
   	   westBlank.setOpaque(true);
   	   westBlank.setBackground(UISettings.WinBGColor);
   	   JLabel el   = new JLabel("            ");
   	   scanTextLab = new JLabel[scanNum.length];
   	   for(int i = 0; i < scanNum.length; i++)
   	   {
   		scanTextLab[i] = new JLabel(scanNum[i]);
   		scanTextLab[i].setOpaque(true);
   		scanTextLab[i].setFont(fc);
   		scanTextLab[i].setHorizontalAlignment(SwingConstants.CENTER);
   		scanTextLab[i].setBackground(UISettings.WinBGColor);
   		westNumScan.add(scanTextLab[i]);
   	   }
   	westNumScan.setOpaque(true);
   	westNumScan.setBackground(UISettings.WinBGColor);
   	
   	
   	westOptScan = new JPanel(new GridLayout(scanOpt.length,1));
   	scanOptLab = new JLabel[scanOpt.length];
	   for(int i = 0; i < scanOpt.length; i++)
	   {
		   scanOptLab[i] = new JLabel(scanOpt[i]);
		   scanOptLab[i].setOpaque(true);
		   scanOptLab[i].setFont(fc);
		   scanOptLab[i].setHorizontalAlignment(SwingConstants.CENTER);
		   scanOptLab[i].setBackground(UISettings.WinBGColor);
		westOptScan.add(scanOptLab[i]);
	   }
	   westOptScan.setOpaque(true);
	   westOptScan.setBackground(UISettings.WinBGColor);
   	   
	   westSymScan = new JPanel(new GridLayout(scanSym.length,1));
	   	scanSymLab = new JLabel[scanSym.length];
		   for(int i = 0; i < scanSym.length; i++)
		   {
			   scanSymLab[i] = new JLabel(scanSym[i]);
			   scanSymLab[i].setOpaque(true);
			   scanSymLab[i].setFont(fc);
			   scanSymLab[i].setHorizontalAlignment(SwingConstants.CENTER);
			   scanSymLab[i].setBackground(UISettings.WinBGColor);
			   westSymScan.add(scanSymLab[i]);
		   }
		   westSymScan.setOpaque(true);
		   westSymScan.setBackground(UISettings.WinBGColor);
	   	   
	   
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
	   
	   ostatus = new UIStatus();
	   ostatus.Visible=true;
	   ostatus.focused=0;
	   
	   	nstatus = new UIStatus();
	   	nstatus.Visible=true;
	   	nstatus.focused=0; 
	   	
	   	symstatus = new UIStatus();
	   	symstatus.Visible=true;
	   	symstatus.focused=0; 
	   
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
          loadQuestion(0);
          lst = new LabelScanThread(ssLabel,sstatus);
          lst.start();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new CoGeoPractice().setVisible(true);
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		robot.mouseMove(screenSize.width - 80, screenSize.height - 80);
		if(sstatus.Visible)
		{	
		
		 switch(sstatus.focused)
		   {
		   case 0 :
			   qno = (qno > 0)?(--qno):fileName.length - 1;
			  loadQuestion(qno);
			   break;
		   case 1 :
			   qno = (qno < fileName.length -1)?(++qno): 0;
			   loadQuestion(qno);
			   break;
		   case 2 :
			   sstatus.Visible = false;
			   nstatus.Visible = true;
			   sb = new StringBuilder(initWbContent); 
			   //msg.setText("<html><b>Tap to select from the following</b><html>");
			   lst = new LabelScanThread(scanTextLab,nstatus);
		       lst.start();
		       remove(westBlank);
		       add(westNumScan,BorderLayout.WEST);
		       validate();
		       repaint();
			   break;
		   case 3 :
			   new CoGeoHome().setVisible(true);
			   sstatus.Visible=false;
			   setVisible(false);
			   break; 
		   }
		}
		else if(nstatus.Visible)
		{
			 switch(nstatus.focused)
			   {
			   case 0 : case 1 : case 2 : case 3 : case 4 : 
			   case 5 : case 6 : case 7 : case 8 : case 9 : 
			   workbook.setText(sb.append(scanTextLab[nstatus.focused].getText().toString()).toString());
			   break;
			   case 10 : 
			   case 11 : 
			   workbook.setText(sb.append("<span style='font-size:2'><br/></span>").toString());
			   break;
			   case 12:
				   nstatus.Visible = false;
				   ostatus.Visible = true;
				   lst = new LabelScanThread(scanOptLab,ostatus);
			       lst.start();
			       remove(westNumScan);
			       add(westOptScan,BorderLayout.WEST);
			       validate();
			       repaint();
				   break;
			   case 13:
				   nstatus.Visible = false;
				   symstatus.Visible = true;
				   lst = new LabelScanThread(scanSymLab,symstatus);
			       lst.start();
			       remove(westNumScan);
			       add(westSymScan,BorderLayout.WEST);
			       validate();
			       repaint();
				   break;
			   case 14:
				   nstatus.Visible = false;
				   sstatus.Visible = false;
				   ostatus.Visible = false;
				   this.dispose();
				   AnswerScreen.flag = false;
				   new AnswerScreen(question.getText(),sb.toString(),autoans).setVisible(true);
				   break;
			   }
			
		}
		else if(ostatus.Visible)
		{
			
			switch(ostatus.focused)
			   {
			   case 0 : case 1 : case 2 : case 3 : 
			   case 4 : case 5 : case 6 : 
			   workbook.setText(sb.append(scanOptLab[ostatus.focused].getText().toString()).toString());
			   break;
			   case 7 : 
				   workbook.setText(sb.append("&radic;").toString());
				   break;
			   case 8 :
				   workbook.setText(sb.append("<sup>2</sup>").toString());
				   break;
			   case 9 : 
				   workbook.setText(sb.append("<sup>3</sup>").toString());
				   break;
			   case 10 : 
			   case 11 : 
			   workbook.setText(sb.append("<span style='font-size:2'><br/></span>").toString());
			   break;
			   case 12:
				   ostatus.Visible = false;
				   nstatus.Visible = true;
				   lst = new LabelScanThread(scanTextLab,nstatus);
			       lst.start();
			       remove(westOptScan);
			       add(westNumScan,BorderLayout.WEST);
			       validate();
			       repaint();
				   break;
			   case 13:
				   ostatus.Visible = false;
				   symstatus.Visible = true;
				   lst = new LabelScanThread(scanSymLab,symstatus);
			       lst.start();
			       remove(westOptScan);
			       add(westSymScan,BorderLayout.WEST);
			       validate();
			       repaint();
				   break;
			   case 14:
				   nstatus.Visible = false;
				   sstatus.Visible = false;
				   ostatus.Visible = false;
				   this.dispose();
				   AnswerScreen.flag = false;
				   new AnswerScreen(question.getText(),sb.toString(),autoans).setVisible(true);
				   break;
			   }
			 
		}
		else if(symstatus.Visible)
		{
			switch(symstatus.focused)
			   {
			   case 0 : case 1 : case 2 : case 3 : 
			   case 4 : case 5 : case 6 : case 7 : 
			   workbook.setText(sb.append(scanSymLab[symstatus.focused].getText().toString()).toString());
			   break;
			   case 8 : 
				   workbook.setText(sb.append("<sub>1</sub>").toString());
				   break;
			   case 9 :
				   workbook.setText(sb.append("<sub>2</sub>").toString());
				   break;
			   case 10 :
				   workbook.setText(sb.append("<sub>3</sub>").toString());
				   break;
			   case 11 :
				   workbook.setText(sb.append("<sub>4</sub>").toString());
				   break;
			   case 12 : 
			   case 13 :
			   workbook.setText(sb.append("<span style='font-size:2'><br/></span>").toString());
			   break;
			   case 14:
				   symstatus.Visible = false;
				   nstatus.Visible = true;
				   lst = new LabelScanThread(scanTextLab,nstatus);
			       lst.start();
			       remove(westSymScan);
			       add(westNumScan,BorderLayout.WEST);
			       validate();
			       repaint();
				   break;
			   case 15:
				   symstatus.Visible = false;
				   ostatus.Visible = true;
				   lst = new LabelScanThread(scanOptLab,ostatus);
			       lst.start();
			       remove(westSymScan);
			       add(westOptScan,BorderLayout.WEST);
			       validate();
			       repaint();
				   break;
			   case 16:
				   nstatus.Visible = false;
				   sstatus.Visible = false;
				   ostatus.Visible = false;
				   this.dispose();
				   AnswerScreen.flag = false;
				   new AnswerScreen(question.getText(),sb.toString(),autoans).setVisible(true);
				   break;
			   }
		}
		
	}
	//Load Question and generate question
	private void loadQuestion(int qno)
	{   
		File f = new File(directoryPath+fileName[qno]);
		StringBuilder quest=  new StringBuilder();
		try {
			//** load question and generate answer
			InputStreamReader in = new InputStreamReader(new FileInputStream(f));
			BufferedReader br = new BufferedReader(in);
			String op = br.readLine();
			quest.append("<html><body bgcolor='"+UISettings.WorkBKBGColor+"' color='"+UISettings.WorkTextColor+"' style=\"font-size:"+(fsize-10)+"; font-weight:bold;font-family:"+fname+";\">");
			//Addition
			if(op.equals("dist"))
			{
				
				int x1,x2,y1,y2;
				x1 = Integer.parseInt(br.readLine());
				y1 = Integer.parseInt(br.readLine());
				x2 = Integer.parseInt(br.readLine());
				y2 = Integer.parseInt(br.readLine());
				quest.append("Calculate the distance between the points A( "+x1+" , "+y1+" ) and B( "+x2+" , "+y2+" ) </body></html>");
				
				//Answer generation
				StringBuilder sb = new StringBuilder();
				sb.append("<body bgcolor='"+UISettings.WorkBKBGColor+"' color='"+UISettings.WorkTextColor+"' style=\"font-size:"+(fsize-5)+"; font-weight:bold;font-family:"+fname+";\"><center><span style=\"font-size: "+(fsize-10)+"\"><b>Auto generated answer</b></span></center><table><tr>");
				
				sb.append("Given : <br/> x<sub>1</sub> = "+x1+" y<sub>1</sub> = "+y1+" x<sub>2</sub> = "+x2+" y<sub>2</sub> = "+y2);
				
				sb.append("<br/>  Distance Between Two Points = &radic;((x<sub>2</sub> - x<sub>1</sub>)<sup>2</sup> + (y<sub>2</sub> - y<sub>1</sub>)<sup>2</sup>)");
				
			    sb.append("<br/>  Distance Between Two Points = &radic;((("+x2+") - ("+x1+"))<sup>2</sup> + (("+y2+") - ("+y1+"))<sup>2</sup>)");
			    
				sb.append("<br/>   = &radic;((("+(x2-x1)+"))<sup>2</sup> + (("+(y2-y1)+"))<sup>2</sup>)");
						
				sb.append("<br/>   = &radic;(("+((x2-x1)*(x2-x1))+") + ("+((y2-y1)*(y2-y1))+"))");
			
				sb.append("<br/>   = &radic;("+(((x2-x1)*(x2-x1))+((y2-y1)*(y2-y1)))+")");
					
				sb.append("<br/>  Distance Between Two Points = "+Math.sqrt((((x2-x1)*(x2-x1))+((y2-y1)*(y2-y1)))));

				autoans = sb.toString();
				
			}
			
			//Mid point
			else if(op.equals("midp"))
			{
				
				int x1,x2,y1,y2;
				x1 = Integer.parseInt(br.readLine());
				y1 = Integer.parseInt(br.readLine());
				x2 = Integer.parseInt(br.readLine());
				y2 = Integer.parseInt(br.readLine());
				quest.append("Calculate midpoint of  A( "+x1+" , "+y1+" ) and B( "+x2+" , "+y2+" ) </body></html>");
				
				//Answer generation
				StringBuilder ans = new StringBuilder();
				sb.append("<body bgcolor='"+UISettings.WorkBKBGColor+"' color='"+UISettings.WorkTextColor+"' style=\"font-size:"+(fsize-5)+"; font-weight:bold;font-family:"+fname+";\"><center><span style=\"font-size: "+(fsize-10)+"\"><b>Auto generated answer</b></span></center><table><tr>");
				sb.append("Given : <br/> x<sub>1</sub> = "+x1+" y<sub>1</sub> = "+y1+" x<sub>2</sub> = "+x2+" y<sub>2</sub> = "+y2).toString();
				sb.append("<br/>  Midpoint = ((x<sub>1</sub> + x<sub>2</sub>)/2 , (y<sub>1</sub> + y<sub>2</sub>)/2").toString();
				sb.append("<br/> Midpoint Between Two Points = ("+x1+" + "+x2+")/2, ("+y1+" + "+y2+")/2").toString();
				sb.append("<br/>   = ("+(x1+x2)+")/2 , ("+(y1+y2)+")/2").toString();
				sb.append("<br/>   = ("+((x1+x2)/2)+" , "+((y1+y2)/2)+")").toString();
				sb.append("<br/>  Midpoint Between Two Points = ("+((x1+x2)/2)+" , "+((y1+y2)/2)+")").toString();
					
				autoans = sb.toString();
				
			}
			else if(op.equals("cent"))
			{
				int x1,x2,x3,y1,y2,y3;
				x1 = Integer.parseInt(br.readLine());
				y1 = Integer.parseInt(br.readLine());
				x2 = Integer.parseInt(br.readLine());
				y2 = Integer.parseInt(br.readLine());
				x3 = Integer.parseInt(br.readLine());
				y3 = Integer.parseInt(br.readLine());
				quest.append("Find the centroid of  A( "+x1+" , "+y1+" ) , B( "+x2+" , "+y2+" )and C( "+x3+" , "+y3+" ) </body></html>");
				StringBuilder ans = new StringBuilder();
				sb.append("<body bgcolor='"+UISettings.WorkBKBGColor+"' color='"+UISettings.WorkTextColor+"' style=\"font-size:"+(fsize-5)+"; font-weight:bold;font-family:"+fname+";\"><center><span style=\"font-size: "+(fsize-10)+"\"><b>Auto generated answer</b></span></center><table><tr>");
				
				sb.append("Given : <br/> x<sub>1</sub> = "+x1+" y<sub>1</sub> = "+y1+" x<sub>2</sub> = "+x2+" y<sub>2</sub> = "+y2+" x<sub>3</sub> = "+x3+" y<sub>3</sub> = "+y3).toString();
				sb.append("<br/>  Centroid = ((x<sub>1</sub> + x<sub>2</sub> + x<sub>3</sub>)/3 , (y<sub>1</sub> + y<sub>2</sub> + y<sub>3</sub>)/3").toString();
				sb.append("<br/> Centroid between these points = ("+x1+" + "+x2+" + "+x3+")/3, ("+y1+" + "+y2+" + "+y3+")/3").toString();
				sb.append("<br/>   = ("+(x1+x2+x3)+")/3 , ("+(y1+y2+y3)+")/3").toString();
				sb.append("<br/>   = ("+((x1+x2+x3)/3)+" , "+((y1+y2+y3)/3)+")").toString();
				sb.append("<br/>  Centroid Between A,B,C = ("+((x1+x2+x3)/3)+" , "+((y1+y2+y3)/3)+")").toString();
				
				autoans = sb.toString();
				
			}
			
			else if(op.equals("intseg"))
			{
				int x1,x2,x3,y1,y2,l,m;
				x1 = Integer.parseInt(br.readLine());
				y1 = Integer.parseInt(br.readLine());
				x2 = Integer.parseInt(br.readLine());
				y2 = Integer.parseInt(br.readLine());
				l = Integer.parseInt(br.readLine());
				m = Integer.parseInt(br.readLine());
				quest.append("Find the point p internaly segmented of  A( "+x1+" , "+y1+" ) and B( "+x2+" , "+y2+" )in ratio ( "+l+" : "+m+" ) </body></html>");
				sb.append("<body bgcolor='"+UISettings.WorkBKBGColor+"' color='"+UISettings.WorkTextColor+"' style=\"font-size:"+(fsize-5)+"; font-weight:bold;font-family:"+fname+";\"><center><span style=\"font-size: "+(fsize-10)+"\"><b>Auto generated answer</b></span></center><table><tr>");
				StringBuilder ans = new StringBuilder();
				sb.append("Given : <br/> l = "+l+" m = "+m+" x<sub>1</sub> = "+x1+" y<sub>1</sub> = "+y1+" x<sub>2</sub> = "+x2+" y<sub>2</sub> = "+y2).toString();
				sb.append("<br/>  P(Internally Segmented) = ((l * x<sub>2</sub> + m * x<sub>1</sub>) / (l + m)) , ((l * y<sub>2</sub> + m * y<sub>1</sub>) / (l + m))").toString();
				sb.append("<br/> p = [("+l+" * "+x2+") + ("+m+" * "+x1+") / ("+l+" + "+m+")] , [("+l+" * "+y2+") + ("+m+" * "+y1+") / ("+l+" + "+m+")]").toString();
				sb.append("<br/>   = [("+((l*x2)+(m*x1))+") / "+(l+m)+"] , [("+((l*y2)+(m*y1))+") / "+(l+m)+"]").toString();
				sb.append("<br/> p, Internally Segmented  =  ("+(((l*x2)+(m*x1))/(l+m))+" , "+(((l*y2)+(m*y1))/(l+m))+")").toString();
				autoans = sb.toString();
			    
			}
			else if(op.equals("extseg"))
			{
				int x1,x2,x3,y1,y2,l,m;
				x1 = Integer.parseInt(br.readLine());
				y1 = Integer.parseInt(br.readLine());
				x2 = Integer.parseInt(br.readLine());
				y2 = Integer.parseInt(br.readLine());
				l = Integer.parseInt(br.readLine());
				m = Integer.parseInt(br.readLine());
				quest.append("Find the point p externaly segmented of  A( "+x1+" , "+y1+" ) and B( "+x2+" , "+y2+" )in ratio ( "+l+" : "+m+" ) </body></html>");
				sb.append("<body bgcolor='"+UISettings.WorkBKBGColor+"' color='"+UISettings.WorkTextColor+"' style=\"font-size:"+(fsize-5)+"; font-weight:bold;font-family:"+fname+";\"><center><span style=\"font-size: "+(fsize-10)+"\"><b>Auto generated answer</b></span></center><table><tr>");
				StringBuilder ans = new StringBuilder();
				sb.append("Given : <br/> l = "+l+" m = "+m+" x<sub>1</sub> = "+x1+" y<sub>1</sub> = "+y1+" x<sub>2</sub> = "+x2+" y<sub>2</sub> = "+y2).toString();
				sb.append("<br/>  P(Externally Segmented) = ((l * x<sub>2</sub> - m * x<sub>1</sub>) / (l - m)) , ((l * y<sub>2</sub> - m * y<sub>1</sub>) / (l - m))").toString();
				sb.append("<br/> p = [("+l+" * "+x2+") - ("+m+" * "+x1+") / ("+l+" - "+m+")] , [("+l+" * "+y2+") - ("+m+" * "+y1+") / ("+l+" - "+m+")]").toString();
				sb.append("<br/>   = [("+((l*x2)-(m*x1))+") / "+(l-m)+"] , [("+((l*y2)-(m*y1))+") / "+(l-m)+"]").toString();
				sb.append("<br/> p, Externally Segmented  =  ("+(((l*x2)-(m*x1))/(l-m))+" , "+(((l*y2)-(m*y1))/(l-m))+")").toString();
				autoans = sb.toString();
			    
			}
			else if(op.equals("area"))
			{
				int x1,x2,x3,y1,y2,y3;
				x1 = Integer.parseInt(br.readLine());
				y1 = Integer.parseInt(br.readLine());
				x2 = Integer.parseInt(br.readLine());
				y2 = Integer.parseInt(br.readLine());
				x3 = Integer.parseInt(br.readLine());
				y3 = Integer.parseInt(br.readLine());
				quest.append("Find the area of triangle ABC,   A( "+x1+" , "+y1+" ),B( "+x2+" , "+y2+" ) and C( "+x3+" , "+y3+" ) ) </body></html>");
				sb.append("<body bgcolor='"+UISettings.WorkBKBGColor+"' color='"+UISettings.WorkTextColor+"' style=\"font-size:"+(fsize-5)+"; font-weight:bold;font-family:"+fname+";\"><center><span style=\"font-size: "+(fsize-10)+"\"><b>Auto generated answer</b></span></center><table><tr>");
				StringBuilder ans = new StringBuilder();
				sb.append("Given : <br/> x<sub>1</sub> = "+x1+" y<sub>1</sub> = "+y1+" x<sub>2</sub> = "+x2+" y<sub>2</sub> = "+y2+" x<sub>3</sub> = "+x3+" y<sub>3</sub> = "+y3).toString();
				sb.append("<br/>  Area of Triangle ABC = ( x<sub>1</sub> *( y<sub>2</sub> - y<sub>3</sub> ) + x<sub>2</sub> *( y<sub>3</sub> - y<sub>1</sub> ) + x<sub>3</sub> *( y<sub>1</sub> - y<sub>2</sub> )) / 2").toString();
				sb.append("<br/> Area of Triangle  = ("+x1+" * ("+y2+"-"+y3+") + "+x2+" * ("+y3+"-"+y1+") + "+x3+" * ("+y1+"-"+y2+") ) /2").toString();
				sb.append("<br/>   = ("+x1+" * ("+(y2-y3)+") + "+x2+" * ("+(y3-y1)+") + "+x3+" * ("+(y1-y2)+") ) /2").toString();
				sb.append("<br/>   = ("+(x1 * (y2-y3))+" + "+(x2 * (y3-y1))+" + "+(x3 * (y1-y2))+" ) /2").toString();
				sb.append("<br/>   = ("+((x1 * (y2-y3)) + (x2 * (y3-y1)) + (x3 * (y1-y2)))+" ) /2").toString();
				sb.append("<br/>  Area of Triangle ABC = "+(((x1*(y2-y3))+(x2*(y3-y1))+(x3*(y1-y2)))/2)+"").toString();
				autoans = sb.toString();
						
				}
			else if(op.equals("slopeang"))
			{
				int degree;
				degree = Integer.parseInt(br.readLine());
				quest.append("Find the slope of line with angle = ( "+degree+" ) ) </body></html>");
				sb.append("<body bgcolor='"+UISettings.WorkBKBGColor+"' color='"+UISettings.WorkTextColor+"' style=\"font-size:"+(fsize-5)+"; font-weight:bold;font-family:"+fname+";\"><center><span style=\"font-size: "+(fsize-10)+"\"><b>Auto generated answer</b></span></center><table><tr>");
				StringBuilder ans = new StringBuilder();
				sb.append("Given : <br/> angle  = "+degree+" ").toString();
				sb.append("<br/>  Slope, m = tan Θ").toString();
				sb.append("<br/> Slope, m = tan("+degree+")").toString();
				if (degree == 0)
					
								sb.append("<br/>  slope, m = 0 ").toString();
					else if(degree == 30)
						
								sb.append("<br/>  slope, m = 1/&radic;3 ").toString();
					else if(degree == 45)
						
								sb.append("<br/>  slope, m = 1 ").toString();
					else if(degree == 60)
						
								sb.append("<br/>  slope, m = &radic;3 ").toString();
					else if(degree == 90)
						
								sb.append("<br/>  slope, m = ∞ ").toString();
					
	
				autoans = sb.toString();
				
				
			}
			else if(op.equals("slopetwopoint"))
			{
				int x1,x2,y1,y2;
				x1 = Integer.parseInt(br.readLine());
				y1 = Integer.parseInt(br.readLine());
				x2 = Integer.parseInt(br.readLine());
				y2 = Integer.parseInt(br.readLine());
				
				quest.append("Find the slope of line AB,   A( "+x1+" , "+y1+" )and B( "+x2+" , "+y2+" ) ) </body></html>");
				sb.append("<body bgcolor='"+UISettings.WorkBKBGColor+"' color='"+UISettings.WorkTextColor+"' style=\"font-size:"+(fsize-5)+"; font-weight:bold;font-family:"+fname+";\"><center><span style=\"font-size: "+(fsize-10)+"\"><b>Auto generated answer</b></span></center><table><tr>");
				StringBuilder ans = new StringBuilder();
				sb.append("Given : <br/> x<sub>1</sub> = "+x1+" y<sub>1</sub> = "+y1+" x<sub>2</sub> = "+x2+" y<sub>2</sub> = "+y2).toString();
				sb.append("<br/>  Slope = (y<sub>2</sub> - y<sub>1</sub>) / (x<sub>2</sub> - x<sub>1</sub>)").toString();
				sb.append("<br/> Slope of a Line = ("+y2+" - "+y1+") / ("+x2+" - "+x1+")").toString();
				sb.append("<br/>   = ("+(y2-y1)+" / "+(x2-x1)+")").toString();
				sb.append("<br/> Slope of the line AB  = ("+((y2-y1)/(x2-x1))+")").toString();
				
				autoans = sb.toString();
			}
			
			question.setText(quest.toString());
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
					if(fileCount > 0)
					{
					fileName = new String[fileCount];
	               for(int i = 0; i< files.length; i++)
	              	fileName[i] = files[i];
					}
					else
					{
					BufferedWriter out;
					try{
						System.out.print("\n New files created");
						out = new BufferedWriter(new OutputStreamWriter( new FileOutputStream(new File(directoryPath+"dist"+"q1.ma"))));
						out.write("dist\n3\n3\n12\n21\n");
						out.flush();
						out.close();
						
						out = new BufferedWriter(new OutputStreamWriter( new FileOutputStream(new File(directoryPath+"midp"+"q1.ma"))));
						out.write("midp\n10\n20\n30\n40\n");
						out.flush();
						out.close();
						
						out = new BufferedWriter(new OutputStreamWriter( new FileOutputStream(new File(directoryPath+"dist"+"q1.ma"))));
						out.write("dist\n50\n40\n30\n20\n");
						out.flush();
						out.close();
					}catch(Exception e)
					{
						e.printStackTrace();
					}
					extractFileName();
					}
			  }
	   }

	public void mouseEntered(MouseEvent arg0) {}
	public void mouseExited(MouseEvent arg0) {}
	public void mousePressed(MouseEvent arg0) {}
	public void mouseReleased(MouseEvent arg0) {}
}
