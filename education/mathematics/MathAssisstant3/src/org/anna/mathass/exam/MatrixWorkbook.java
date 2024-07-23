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
import org.anna.mathass.ui.MatricsHome;
import org.anna.mathass.ui.UISettings;
import org.anna.mathass.ui.UIStatus;

/**
 * @author Leyagath
 *
 */
public class MatrixWorkbook extends JFrame implements MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @param args
	 */
	UIStatus lstatus,sstatus,mstatus;

	JLabel ssLabel[],nsLabel,msg,question;
	String scanTexthl [] = {"A","B","C","D","E","=","+","-","X","/","INSERT MATRIX","NEXT LINE","DELETE","LINE DELETE","CLEAR ALL","SCROLL UP","SCROLL DOWN","DONE"};
	String matdimen [] = {"    1    ","2","3","4","5"};
	String matelement [] = {"1","2","3","4","5","6","7","8","9","0","(",")","-","+","DELETE","  OK  "};
	String qdirectory = "D:\\MathAssist\\matrix\\practice\\";
	String qfiles[] = {"q1.txt","q2.txt","q3.txt","q4.txt","q5.txt"};
	String studans,autoans = "<center><span style=\"font-size: 20pt\"><b>Auto generated answer</b></span></center>";
	int qno = 0;
	Stack<Integer> linest,compst;
	JTextPane workbook;
	JLabel scanTextLab [] , matdimenLab[], matelementLab[];
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
	JPanel north,south,east,westBlank,westMainScan,westMatScan,westMatDimScan,nscanLabel;
	public MatrixWorkbook(String Question, StringBuilder ans)
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
		   this.Question = Question;
		   this.ans =ans;
	      workbook = new JTextPane(); // creates an empty text pane
	      workbook.setContentType("text/html");                   
	      workbook.setText("<center><span style=\"font-size: 20pt\"><b>Matrix Work Sheet</b></span></center>"); 
	      workbook.setEditable(false);// sets its text
	      jsp = new JScrollPane();
	      jsp.getViewport().add(workbook);
          north = new JPanel(new GridLayout(1,2));
          north.setOpaque(true);
          north.setBackground(UISettings.WinBGColor);
          south = new JPanel(new GridLayout(1,4,100,10));
          question = new JLabel(this.Question);
          question.setForeground(UISettings.TextColor);
		  question.setFont(ft);
		  question.setHorizontalAlignment(SwingConstants.CENTER);
          north.add(question);
          nscanLabel = new JPanel(new GridLayout(1,2,0,5));
          vertical = jsp.getVerticalScrollBar();
          try {
			robot = new Robot();
		} catch (AWTException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
          
          String tstr[]={"PREV","NEXT","SOLVE","MATRIX HOME"};
   	   ssLabel = new JLabel[tstr.length];
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
   	   scanTextLab = new JLabel[scanTexthl.length];
   	   for(int i = 0; i < scanTexthl.length; i++)
   	   {
   		scanTextLab[i] = new JLabel(scanTexthl[i]);
   		scanTextLab[i].setOpaque(true);
   		scanTextLab[i].setFont(fc);
   		scanTextLab[i].setHorizontalAlignment(SwingConstants.CENTER);
   		scanTextLab[i].setBackground(UISettings.WinBGColor);
   		westMainScan.add(scanTextLab[i]);
   	   }
   	westMainScan.setOpaque(true);
   	westMainScan.setBackground(UISettings.WinBGColor);
   	
   	
   	westMatScan = new JPanel(new GridLayout(matelement.length,1));
   	matelementLab = new JLabel[matelement.length];
	   for(int i = 0; i < matelement.length; i++)
	   {
		   matelementLab[i] = new JLabel(matelement[i]);
		   matelementLab[i].setOpaque(true);
		   matelementLab[i].setFont(fc);
		   matelementLab[i].setHorizontalAlignment(SwingConstants.CENTER);
		   matelementLab[i].setBackground(UISettings.WinBGColor);
		westMatScan.add(matelementLab[i]);
	   }
	   westMatScan.setOpaque(true);
	   westMatScan.setBackground(UISettings.WinBGColor);
   	   
	   westMatDimScan = new JPanel(new GridLayout(matdimen.length,1));
	   	matdimenLab = new JLabel[matdimen.length];
		   for(int i = 0; i < matdimen.length; i++)
		   {
			   matdimenLab[i] = new JLabel(matdimen[i]);
			   matdimenLab[i].setOpaque(true);
			   matdimenLab[i].setFont(fc);
			   matdimenLab[i].setHorizontalAlignment(SwingConstants.CENTER);
			   matdimenLab[i].setBackground(UISettings.WinBGColor);
			   westMatDimScan.add(matdimenLab[i]);
		   }
		   westMatDimScan.setOpaque(true);
		   westMatDimScan.setBackground(UISettings.WinBGColor);
	   	   
	   
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
	   sstatus.Visible=true;
	   sstatus.focused=0; 
	   
   	   mstatus = new UIStatus();
	   mstatus.Visible=true;
	   mstatus.focused=0; 
	   
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
          loadQuestion(0);
          
          lst = new LabelScanThread(ssLabel,sstatus);
          lst.start();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //new MatrixWorkbook().setVisible(true);
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		robot.mouseMove(screenSize.width - 80, screenSize.height - 80);
		// TODO Auto-generated method stub
		 if(sstatus.Visible)
		{    boolean isContentChanged = false;
		     if(compst.empty())
		    	 compst.push(sb.toString().length());
		     if(linest.empty())
		    	 linest.push(sb.toString().length());
			switch(sstatus.focused)
			   {
			   case 10 :
				   mstatus.Visible = true;
				   sstatus.Visible = false;
				   msg.setText("<html></b>Enter Matrix Dimension. No. of Rows : </b></html>");
				   lst = new LabelScanThread(matdimenLab,mstatus);
			       lst.start();
			       remove(westMainScan);
			       add(westMatDimScan,BorderLayout.WEST);
			       validate();
			       repaint();
			       isContentChanged = true;
				   break;
			   case 6 :
				   sb.append("<td>+</td>"); 
				   isContentChanged = true; 
				   break;
			   case 7 :
				   sb.append("<td>-</td>");
				   isContentChanged = true; 
				   break;
			   case 8 :
				   sb.append("<td>X</td>");
				   isContentChanged = true; 
				   break;
               case 9 :
				   sb.append("<td>/</td>");
				   isContentChanged = true; 
				   break;
               case 5 :
            	   sb.append("<td>=</td>");
            	   isContentChanged = true; 
            	   break;
               case 0 :
            	   sb.append("<td>A</td>");
            	   isContentChanged = true; 
            	   break;
               case 1 :
            	   sb.append("<td>B</td>");
            	   isContentChanged = true; 
            	   break;
               case 2 :
            	   sb.append("<td>C</td>");
            	   isContentChanged = true; 
				   break;
               case 3 :
            	   sb.append("<td>D</td>");
            	   isContentChanged = true; 
            	   break;
               case 4 :
            	   sb.append("<td>E</td>");
            	   isContentChanged = true; 
            	   break;
               case 11 :
            	   linest.push(sb.toString().length());
            	   System.out.println("Pushed line End Index"+linest.peek());
            	   sb.append("</tr></tabel><tabel><tr>");
            	   isContentChanged = true;
            	   ++scramt;
            	   break;
               case 12: 
            	   try{
            	   int ind;
            	   compst.pop();
            	   ind = compst.peek();
            	   
            	   sb = new StringBuilder(sb.toString().substring(0,ind));
            	   workbook.setText(sb.toString()+"<td style=\"font-size: 30pt; color:"+UISettings.WorkCurColor+"; font-family:'Lucida Sans Unicode', 'Lucida Grande', sans-serif \" >"+blinkChar+"</td></tr></tabel></body>");
       			   workbook.requestFocus();
       			   robot.mouseWheel(scramt);
       			while(linest.peek()<compst.peek())
    				   linest.pop();
            	   System.out.println("Deleted");
            	   }
            	   catch (Exception e)
            	   {
            		  e.printStackTrace(); 
            	   }
            	   break;
               case 13:
            	   try{
            		   int ind;
            	   ind = linest.pop(); 
            	   //System.out.println("poped line End Index"+ind);
            	   if(!linest.empty())
            	   {
            	   sb = new StringBuilder(sb.toString().substring(0,ind));
            	   while(linest.peek()> compst.peek())
       				   compst.pop();
            	       linest.pop();
            	   }
            	   else
            	   {
            		   sb = new StringBuilder(initWbContent); 
            		   compst = new Stack<Integer>();
                	   linest = new Stack<Integer>(); 
            	   }
            	   workbook.setText(sb.toString()+"<td style=\"font-size: 30pt; color:"+UISettings.WorkCurColor+"; font-family:'Lucida Sans Unicode', 'Lucida Grande', sans-serif \" >"+blinkChar+"</td></tr></tabel></body>");
       			   workbook.requestFocus();
       			   robot.mouseWheel(scramt);
            	   //System.out.println("Line Deleted");
            	   }
            	   catch (Exception e)
            	   {
            		  e.printStackTrace(); 
            	   }

            	   break;
               case 14:
            	   sb = new StringBuilder(initWbContent); 
            	   compst = new Stack<Integer>();
            	   linest = new Stack<Integer>();
            	   isContentChanged = true;
            	   break;
               case 15:
            	   workbook.requestFocus();
            	   robot.mouseWheel(-1);
            	   break;
               case 16:
            	   workbook.requestFocus();
            	   robot.mouseWheel(1);
            	   break;
               case 17:
            	   lstatus.Visible = true;
            	   lstatus.focused = 0;
            	   lst = new LabelScanThread(ssLabel,lstatus);
                   lst.start();
                   sstatus.Visible = false;
                   try{
                	    
                	   // Create file 
               	        BufferedWriter out = new BufferedWriter(new FileWriter( new File("D:\\MathAssist\\matrix\\pracAns\\ans"+new Date().toString().replace(":", ".")+".html")));
                	    //BufferedReader br = new BufferedReader(new FileReader(new File("")));
               	        out.write(sb.toString()+"</td></tr></tabel></body>");
                	    out.flush();
                	    studans = sb.toString()+"</td></tr></tabel></body>";
                	    //Close the output stream
                	    out.close();
                	    }catch (Exception e){//Catch exception if any
                	      e.printStackTrace();
                	    }
            	   break;
			   }
			if(isContentChanged)
			{
			int sblen = sb.toString().length();
			compst.push(sblen);
			workbook.setText(sb.toString()+"<td style=\"font-size: 30pt; color:"+UISettings.WorkCurColor+"; font-family:'Lucida Sans Unicode', 'Lucida Grande', sans-serif \" >"+blinkChar+"</td></tr></tabel></body>");
			workbook.requestFocus();
			robot.mouseWheel(scramt);
			}
		   }
		else if(mstatus.Visible)
		{   
			if(!row)
			{
			  	r = mstatus.focused+1;
				row = true;
				msg.setText("<html><b>Enter Matrix Dimension. No. of Columns : </b></html>");
			}
			else if(!col)
			{
				c = mstatus.focused+1;
				col = true;
				matel = new String[r][c];
				matel[0][0]=""; 
				rt = 0; ct = 0;
				msg.setText("<html><b> Dimension "+r+"X"+c+" Enter matrix element A<sub>11</sub> : </b></html>");
				lst.jl = matelementLab;
				for(int i = 0; i < r; i++)
			    for(int j = 0; j < c; j++)
			    matel[i][j]="";
				
				   remove(westMatDimScan);
			       add(westMatScan,BorderLayout.WEST);
			       validate();
			       repaint();
			}
			else if(!element)
			{   String text,mat = "";
			    boolean finished = false;
				if((text = matelementLab[lst.status.focused].getText()).equals("  OK  "))
				{
					if(++ct == c)
					{ ct=0;
						if(++rt == r)
						{
						 finished = true;
						}
					}
					msg.setText("<html><b> Dimension "+r+"X"+c+" Enter matrix element A<sub>"+(rt+1)+(1+ct)+"</sub> : </b></html>");
				}
				else
				{
					if(text.equals("DELETE"))
					{	if(matel[rt][ct].length()> 0 )
							matel[rt][ct] = matel[rt][ct].substring(0,matel[rt][ct].length() - 1);
					}
					else
					matel[rt][ct] += text;
				}
				mat +="<td><table border=\"1\">";
				for(int i = 0; i < r; i++)
				{
					mat +="<tr>";
			    for(int j = 0; j < c; j++)
			    {
			    	mat +="<td>"+matel[i][j]+((i == rt && j == ct)?"CURS":"")+"</td>";
			    	//
			    }
			    mat +="</tr>";
				}
				mat +="</table></td>";
				if(!finished)
				{
				mat = mat.replace("CURS", "<span style=\"font-size: 30pt; color:"+UISettings.WorkCurColor+"; font-family:'Lucida Sans Unicode', 'Lucida Grande', sans-serif \" >"+blinkChar+"</span>");
				workbook.setText(sb.toString()+mat+"</tr></tabel></body>");
				}
				else
				{
					mat = mat.replace("CURS", "");
					sb.append(mat);
					compst.push(sb.toString().length());
					workbook.setText(sb.toString()+"<td style=\"font-size: 30pt; color:"+UISettings.WorkCurColor+"; font-family:'Lucida Sans Unicode', 'Lucida Grande', sans-serif \" >"+blinkChar+"</td></tr></tabel></body>");
				       mstatus.Visible=false;
				       sstatus.Visible = true;
				       remove(westMatScan);
				       add(westMainScan,BorderLayout.WEST);
				       validate();
				       repaint();
				       msg.setText("<html><b>Tap to select from the following</b><html>");
				    	   lst = new LabelScanThread(scanTextLab,sstatus);
				       lst.start();
				       row = col = false;
				}
			}
			else
			{
				
			}
			
			
		}
		
	}
	//Load Question and generate question
	private void loadQuestion(int qno)
	{
		File f = new File(qdirectory+qfiles[qno]);
		StringBuilder quest=  new StringBuilder();
		String line;
		try {
			//** load question and generate answer
			InputStreamReader in = new InputStreamReader(new FileInputStream(f));
			BufferedReader br = new BufferedReader(in);
			String op = br.readLine();
			quest.append("<html><body bgcolor='"+UISettings.WorkBKBGColor+"' color='"+UISettings.WorkTextColor+"' style=\"font-size:"+(fsize-10)+"; font-weight:bold;font-family:"+fname+";\"><table><tr>");
			//Addition
			if(op.equals("add"))
			{
				quest.append("<td>Add the following matrices. A = </td>");
				int r,c,matA[][],matB[][];
				r = Integer.parseInt(br.readLine());
				c = Integer.parseInt(br.readLine());
				matA = new int[r][c];
				matB = new int[r][c];
				//matrix 1
				quest.append("<td><table>");
				for(int i = 0; i < r; i++)
				{ quest.append("<tr>");
				  for(int j = 0; j < c; j++)
				  {
					  quest.append("<td>");
				  matA[i][j] = Integer.parseInt(br.readLine());
				  quest.append(matA[i][j]+"</td>");
				  }
				  quest.append("</tr>");
				}
				quest.append("</table></td>");
				quest.append("<td>B = </td>");
				
				//matrix 2
				quest.append("<td><table>");
				for(int i = 0; i < r; i++)
				{ quest.append("<tr>");
				  for(int j = 0; j < c; j++)
				  {
					  quest.append("<td>");
				  matB[i][j] = Integer.parseInt(br.readLine());
				  quest.append(matB[i][j]+"</td>");
				  }
				  quest.append("</tr>");
				}
				quest.append("</table></td>");
				quest.append("</tr></table></body></html>");
				
				//Answer generation
				StringBuilder ans = new StringBuilder();
				ans.append("<body bgcolor='"+UISettings.WorkBKBGColor+"' color='"+UISettings.WorkTextColor+"' style=\"font-size:"+(fsize-5)+"; font-weight:bold;font-family:"+fname+";\"><center><span style=\"font-size: "+(fsize-10)+"\"><b>Auto generated answer</b></span></center><table><tr>");
				ans.append("<td>A = </td>");
				ans.append("<td><table border='1'>");
				for(int i = 0; i < r; i++)
				{ ans.append("<tr>");
				  for(int j = 0; j < c; j++)
				  {
				  ans.append("<td>"+matA[i][j]+"</td>");
				  }
				  ans.append("</tr>");
				}
				ans.append("</table></td>");
				
				ans.append("<td>B = </td>");
				ans.append("<td><table border='1'>");
				for(int i = 0; i < r; i++)
				{ ans.append("<tr>");
				  for(int j = 0; j < c; j++)
				  {
				  ans.append("<td>"+matB[i][j]+"</td>");
				  }
				  ans.append("</tr>");
				}
				ans.append("</table></td>");
				ans.append("</tr></table>");
				
				ans.append("<table><tr>");
				ans.append("<td>A + B = C =<td>");
				ans.append("<td><table border='1'>");
				for(int i = 0; i < r; i++)
				{ ans.append("<tr>");
				  for(int j = 0; j < c; j++)
				  {
				  ans.append("<td>"+matA[i][j]+((matB[i][j]<0)?"-":"+")+matB[i][j]+"</td>");
				  }
				  ans.append("</tr>");
				}
				ans.append("</table></td>");
				ans.append("</tr></table>");
				
				ans.append("<table><tr>");
				ans.append("<td> C = <td>");
				ans.append("<td><table border='1'>");
				for(int i = 0; i < r; i++)
				{ ans.append("<tr>");
				  for(int j = 0; j < c; j++)
				  {
				  ans.append("<td>"+(matA[i][j]+matB[i][j])+"</td>");
				  }
				  ans.append("</tr>");
				}
				ans.append("</table></td>");
				ans.append("</tr></table></body>");
				autoans = ans.toString();
				
			}
			//Subtraction
			else if(op.equals("sub"))
			{
				quest.append("<td>Calculate A - B if A = </td>");
				int r,c,matA[][],matB[][];
				r = Integer.parseInt(br.readLine());
				c = Integer.parseInt(br.readLine());
				matA = new int[r][c];
				matB = new int[r][c];
				//matrix 1
				quest.append("<td><table>");
				for(int i = 0; i < r; i++)
				{ quest.append("<tr>");
				  for(int j = 0; j < c; j++)
				  {
					  quest.append("<td>");
				  matA[i][j] = Integer.parseInt(br.readLine());
				  quest.append(matA[i][j]+"</td>");
				  }
				  quest.append("</tr>");
				}
				quest.append("</table></td>");
				
				
				quest.append("<td>and B = </td>");
				
				//matrix 2
				quest.append("<td><table>");
				for(int i = 0; i < r; i++)
				{ quest.append("<tr>");
				  for(int j = 0; j < c; j++)
				  {
					  quest.append("<td>");
				  matB[i][j] = Integer.parseInt(br.readLine());
				  quest.append(matB[i][j]+"</td>");
				  }
				  quest.append("</tr>");
				}
				quest.append("</table></td>");
				
				quest.append("</tr></table></body></html>");
				
				//Answer generation
				StringBuilder ans = new StringBuilder();
				ans.append("<body bgcolor='"+UISettings.WorkBKBGColor+"' color='"+UISettings.WorkTextColor+"' style=\"font-size:"+(fsize-10)+"; font-weight:bold;font-family:"+fname+";\"><center><span style=\"font-size: "+(fsize-10)+"\"><b>Auto generated answer</b></span></center><table><tr>");
				ans.append("<td>A = </td>");
				ans.append("<td><table border='1'>");
				for(int i = 0; i < r; i++)
				{ ans.append("<tr>");
				  for(int j = 0; j < c; j++)
				  {
				  ans.append("<td>"+matA[i][j]+"</td>");
				  }
				  ans.append("</tr>");
				}
				ans.append("</table></td>");
				
				ans.append("<td>B = </td>");
				ans.append("<td><table border='1'>");
				for(int i = 0; i < r; i++)
				{ ans.append("<tr>");
				  for(int j = 0; j < c; j++)
				  {
				  ans.append("<td>"+matB[i][j]+"</td>");
				  }
				  ans.append("</tr>");
				}
				ans.append("</table></td>");
				ans.append("</tr></table>");
				
				ans.append("<table><tr>");
				ans.append("<td>A + B = C =<td>");
				ans.append("<td><table border='1'>");
				for(int i = 0; i < r; i++)
				{ ans.append("<tr>");
				  for(int j = 0; j < c; j++)
				  {
				  ans.append("<td>"+matA[i][j]+((matB[i][j]>0)?"-":"+")+matB[i][j]+"</td>");
				  }
				  ans.append("</tr>");
				}
				ans.append("</table></td>");
				ans.append("</tr></table>");
				
				ans.append("<table><tr>");
				ans.append("<td> C = <td>");
				ans.append("<td><table border='1'>");
				for(int i = 0; i < r; i++)
				{ ans.append("<tr>");
				  for(int j = 0; j < c; j++)
				  {
				  ans.append("<td>"+(matA[i][j]-matB[i][j])+"</td>");
				  }
				  ans.append("</tr>");
				}
				ans.append("</table></td>");
				ans.append("</tr></table></body>");
				autoans = ans.toString();
				
				
			}
			//Multiplication
			else if(op.equals("mul"))
			{}
			else
				;
			question.setText(quest.toString());
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
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
