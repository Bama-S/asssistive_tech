package org.anna.mathass.practice;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import org.anna.mathass.ui.MatricsHome;
import org.anna.mathass.ui.UISettings;
import org.anna.mathass.ui.UIStatus;

public class AnswerScreen extends JFrame implements MouseListener{
	/**
	 * 
	 */
    JLabel question , scanLabel[];
	String fname;
	boolean ismatrix;
	JTextPane studAns,autoAns;
	JScrollPane jsp;
	LabelScanThread lst;
	JScrollBar vertical;
	Robot robot;
	JPanel north,south,center,eastBlank,westBlank,anspanel;
	Dimension screenSize;
	String quest,studans,autoans;
	Font ft,fc;
	int fsize;
	static boolean flag = true;
	UIStatus status;
	AnswerScreen(String quest,String studans,String autoans)
	{
		  setUndecorated(true);
		  ismatrix = flag;
		  flag = true;
		  
	      screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	      setBounds(0,0,screenSize.width, screenSize.height);
	      JLabel jl = new JLabel();
	      String scanText [] = {"SCROLL UP","SCROLL DOWN","MATRIX PRACTICE"};
	      if(!ismatrix)
	    	  scanText[2]="Co-Geo practice";
	      ft= new Font(jl.getFont().getFontName(),Font.BOLD,jl.getFont().getSize()+UISettings.adFontSize);
		   fc= new Font(jl.getFont().getFontName(),Font.PLAIN,jl.getFont().getSize()+UISettings.adFontSize);
		   this.quest = quest;
		   this.studans = studans;
		   this.autoans = studans;
		   anspanel = new JPanel(new GridLayout(1,2,10,0));
		   fsize = jl.getFont().getSize()+UISettings.adFontSize;
		   fname = jl.getFont().getFontName();
		   studAns = new JTextPane(); 
		   studAns.setContentType("text/html");                   
		   studAns.setText(studans);
		   studAns.setEditable(false);
		   autoAns = new JTextPane(); 
		   autoAns.setContentType("text/html");                   
		   autoAns.setText(autoans);
		   autoAns.setEditable(false);
		   anspanel.add(studAns);
		   anspanel.add(autoAns);
		      jsp = new JScrollPane();
		      jsp.getViewport().add(anspanel);
		      north = new JPanel(new GridLayout(1,1));
	          south = new JPanel(new GridLayout(1,3,100,10));
	          question = new JLabel(quest);
	          question.setHorizontalAlignment(SwingConstants.CENTER); 
	          question.setFont(fc);
	          north.add(question);
	          vertical = jsp.getVerticalScrollBar();
	          try {
				robot = new Robot();
			} catch (AWTException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	          scanLabel = new JLabel[scanText.length];
	          for(int i=0;i<scanLabel.length;i++)
	      	   {
	        	  scanLabel[i] = new JLabel(scanText[i]);
	      		scanLabel[i].setBackground(UISettings.WinBGColor);
	      		scanLabel[i].setOpaque(true);
	      		scanLabel[i].setForeground(UISettings.TextColor);
	      		scanLabel[i].setFont(fc);
	      		scanLabel[i].setHorizontalAlignment(SwingConstants.CENTER);
	      	    south.add(scanLabel[i]);
	      	   }
	           westBlank = new JPanel();
	           westBlank.add(new JLabel("  "));
	           eastBlank = new JPanel();
	           eastBlank.add(new JLabel("  "));
	           add(north,BorderLayout.NORTH);
	      	   add(south,BorderLayout.SOUTH);
	      	   add(westBlank,BorderLayout.WEST);
	      	   add(eastBlank,BorderLayout.EAST);
	      	   add(jsp);
	      	 this.addMouseListener(this);
	          anspanel.addMouseListener(this);
	          studAns.addMouseListener(this);
	          autoAns.addMouseListener(this);
	          north.addMouseListener(this);
	          south.addMouseListener(this);
	          eastBlank.addMouseListener(this);
	          westBlank.addMouseListener(this);
	          jsp.addMouseListener(this);
	          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	          status = new UIStatus();
	          status.focused = 0;
	          status.Visible = true;
	          lst = new LabelScanThread(scanLabel,status);
	          lst.start();
	      
	}
	
	public static void main(String arg[])
	{
		new AnswerScreen("Question","<center><span style=\"font-size: 20pt\"><b>Your answer</b></span></center>","<center><span style=\"font-size: 20pt\"><b>Auto generated answer</b></span></center>").setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		robot.mouseMove(screenSize.width - 80, screenSize.height - 80);
		// TODO Auto-generated method stub
		if(status.Visible)
		{	
		 switch(status.focused)
		   {
		   case 0 :
			   jsp.requestFocus();
        	   robot.mouseWheel(-1);
			   break;
		   case 1 :
			   jsp.requestFocus();
        	   robot.mouseWheel(1);
			   break;
		   case 2 :
			   if(ismatrix)
			   new MatrixPractice().setVisible(true);
			   else
			   new CoGeoPractice().setVisible(true);	   
			   status.Visible=false;
			   setVisible(false);
			   break;
		   }
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
