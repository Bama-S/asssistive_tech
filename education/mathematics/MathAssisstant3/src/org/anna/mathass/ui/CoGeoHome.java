package org.anna.mathass.ui;

import javax.swing.*;

import org.anna.mathass.practice.CoGeoPractice;
import org.anna.mathass.practice.MatrixPractice;

import java.awt.event.*;
import java.awt.*;

public class CoGeoHome extends JFrame implements MouseListener {
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
   CoGeoHome HomeScreen;
   JLabel Topic[],ScreenTitle;
   ScanThread st;
   UIStatus status;
   public CoGeoHome()
   {
	   setUndecorated(true);
	      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	      setBounds(0,0,screenSize.width, screenSize.height);
	      Toolkit tk = Toolkit.getDefaultToolkit();  
	      int x = ((int) tk.getScreenSize().getWidth());
	   //Font purpos
	   JLabel jl = new JLabel();
	   Font ft= new Font(jl.getFont().getFontName(),Font.BOLD,jl.getFont().getSize()+UISettings.adFontSize);
	   Font fc= new Font(jl.getFont().getFontName(),Font.PLAIN,jl.getFont().getSize()+UISettings.adFontSize);
	   
	   ScreenTitle = new JLabel("MATH ASSIST - COORDINATE GEOMETRY");
	   ScreenTitle.setBounds((x/2)-(800/2), 50, 800, 50);
	   //ScreenTitle.setBackground(Color.BLACK);
	   ScreenTitle.setOpaque(true);
	   //ScreenTitle.setForeground(Color.GRAY);
	   ScreenTitle.setFont(ft);
	   ScreenTitle.setHorizontalAlignment(SwingConstants.CENTER);
	   add(ScreenTitle);
	   
	   //Topics
	   String tstr[]={"LEARN","PRACTICE",/*"EVALUVATE",*/"HOME"};
	   Topic = new JLabel[tstr.length];
	   int ypos=150;
	   for(int i=0;i<Topic.length;i++)
	   {
	   Topic[i] = new JLabel(tstr[i]);
	   Topic[i].setBounds((x/2)-(700/2), ypos, 700, 50);
	   ypos+=100;
	   Topic[i].setBackground(UISettings.WinBGColor);
	   Topic[i].setOpaque(true);
	   Topic[i].setForeground(UISettings.TextColor);
	   Topic[i].setFont(fc);
	   add(Topic[i]);
	   }
	   
	   	   add(jl);
	   	   status = new UIStatus();
	   	   status.Visible=true;
	   	   status.focused=0;
	   	   this.addMouseListener(this);
	   	   st= new ScanThread(Topic, status);
	   	   st.start();
	   	   
	   	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

@Override
public void mouseClicked(MouseEvent arg0) {
	switch(status.focused)
	   {
	   case 0 :
		   new Learn_CoGeo().setVisible(true);
		   status.Visible=false;
		   setVisible(false);
		   break;
	   case 1 :
		   new CoGeoPractice().setVisible(true);
		   status.Visible=false;
		   setVisible(false);
		   break;

	   case 2 :
		   new Main().setVisible(true);
		   status.Visible=false;
		   setVisible(false);
		   break;
		   
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
