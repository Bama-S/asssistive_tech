/**
 * 
 */
package org.anna.mathass.exam;

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
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Stack;

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
import org.anna.mathass.ui.MatricsHome;
import org.anna.mathass.ui.UISettings;
import org.anna.mathass.ui.UIStatus;

/**
 * @author Leyagath
 *
 */
public class CoGeoWorkbook extends JFrame implements MouseListener {

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
	String quest[] = {
			"Question 1",
			"Question 2",
			"Question 3",
			"Question 4",
			"Question 5"
			};
	Stack<Integer> linest,compst;
	JTextPane workbook;
	JLabel scanTextLab [] , scanOptLab[], scanSymLab[];
	char blinkChar = 'I';
	JScrollPane jsp;
	//StringScanThread sst;
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
	String Question;
	StringBuilder ans;
	JPanel north,south,east,westBlank,westNumScan,westOptScan,westSymScan,nscanLabel;
	public CoGeoWorkbook(String Question, StringBuilder ans)
	{
		setUndecorated(true);
	      screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	      setBounds(0,0,screenSize.width, screenSize.height);
	      JLabel jl = new JLabel();
		   Font ft= new Font(jl.getFont().getFontName(),Font.BOLD,jl.getFont().getSize()+UISettings.adFontSize);
		   Font fc= new Font(jl.getFont().getFontName(),Font.PLAIN,jl.getFont().getSize()+UISettings.adFontSize);
		   fsize = jl.getFont().getSize()+UISettings.adFontSize;
		   fname = jl.getFont().getFontName();
		   initWbContent = "<body bgcolor='"+UISettings.WorkBKBGColor+"' color='"+UISettings.WorkTextColor+"' style=\"font-size:"+(fsize -5 )+"; font-weight:bold;font-family:"+fname+";\"><center><span style=\"font-size: "+(fsize - 10)+"\">";
		  this.Question = Question;
		  this.ans =ans;
		   sb = this.ans;
		   workbook = new JTextPane(); // creates an empty text pane
	      workbook.setContentType("text/html");                   
	      workbook.setText(sb.toString()); 
	      workbook.setEditable(false);// sets its text
	      jsp = new JScrollPane();
	      jsp.getViewport().add(workbook);
          north = new JPanel(new GridLayout(1,1));
          north.setOpaque(true);
          north.setBackground(UISettings.WinBGColor);
          //south = new JPanel(new GridLayout(1,4,100,10));
          question = new JLabel(this.Question);
          north.add(question);
          nscanLabel = new JPanel(new GridLayout(1,2,0,5));
          vertical = jsp.getVerticalScrollBar();
          try {
			robot = new Robot();
		} catch (AWTException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
   	   //add(south,BorderLayout.SOUTH);
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
          //south.addMouseListener(this);
          east.addMouseListener(this);
          westBlank.addMouseListener(this);
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          //loadQuestion(0);
          question.setForeground(UISettings.TextColor);
		  question.setFont(ft);
		  add(westNumScan,BorderLayout.WEST);
          lst = new LabelScanThread(scanTextLab,nstatus);
          lst.start();
          workbook.setText(initWbContent+sb.toString());
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //new CoGeoWorkbook().setVisible(true);
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		robot.mouseMove(screenSize.width - 80, screenSize.height - 80);
		
		 if(nstatus.Visible)
		{
			 switch(nstatus.focused)
			   {
			   case 0 : case 1 : case 2 : case 3 : case 4 : 
			   case 5 : case 6 : case 7 : case 8 : case 9 : 
			   workbook.setText(initWbContent+sb.append(scanTextLab[nstatus.focused].getText().toString()).toString());
			   break;
			   case 10 : 
			   case 11 : 
			   workbook.setText(initWbContent+sb.append("<span style='font-size:2'><br/></span>").toString());
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
				   this.dispose();
				   ExamMain.parent.resume();
				   break;
			   }
			
		}
		else if(ostatus.Visible)
		{
			
			switch(ostatus.focused)
			   {
			   case 0 : case 1 : case 2 : case 3 : 
			   case 4 : case 5 : case 6 : 
			   workbook.setText(initWbContent+sb.append(scanOptLab[ostatus.focused].getText().toString()).toString());
			   break;
			   case 7 : 
				   workbook.setText(initWbContent+sb.append("&radic;").toString());
				   break;
			   case 8 :
				   workbook.setText(initWbContent+sb.append("<sup>2</sup>").toString());
				   break;
			   case 9 : 
				   workbook.setText(initWbContent+sb.append("<sup>3</sup>").toString());
				   break;
			   case 10 : 
			   case 11 : 
			   workbook.setText(initWbContent+sb.append("<span style='font-size:2'><br/></span>").toString());
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
				   this.dispose();
				   ExamMain.parent.resume();
				   break;
			   }
			 
		}
		else if(symstatus.Visible)
		{
			switch(symstatus.focused)
			   {
			   case 0 : case 1 : case 2 : case 3 : 
			   case 4 : case 5 : case 6 : case 7 : 
			   workbook.setText(initWbContent+sb.append(scanSymLab[symstatus.focused].getText().toString()).toString());
			   break;
			   case 8 : 
				   workbook.setText(initWbContent+sb.append("<sub>1</sub>").toString());
				   break;
			   case 9 :
				   workbook.setText(initWbContent+sb.append("<sub>2</sub>").toString());
				   break;
			   case 10 :
				   workbook.setText(initWbContent+sb.append("<sub>3</sub>").toString());
				   break;
			   case 11 :
				   workbook.setText(initWbContent+sb.append("<sub>4</sub>").toString());
				   break;
			   case 12 : 
			   case 13 :
			   workbook.setText(initWbContent+sb.append("<span style='font-size:2'><br/></span>").toString());
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
				   this.dispose();
				   ExamMain.parent.resume();
				   break;
			   }
		}
		
	}
	//Load Question and generate question
	private void loadQuestion(int qno)
	{

			question.setText(quest[qno]);

	}
	public void mouseEntered(MouseEvent arg0) {}
	public void mouseExited(MouseEvent arg0) {}
	public void mousePressed(MouseEvent arg0) {}
	public void mouseReleased(MouseEvent arg0) {}
}
