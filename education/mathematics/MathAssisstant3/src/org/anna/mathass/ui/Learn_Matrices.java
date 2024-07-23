package org.anna.mathass.ui;

import javax.swing.*;

import org.anna.mathass.learn.MatrixAddition;
import org.anna.mathass.learn.MatrixMultiplication;
import org.anna.mathass.learn.MatrixSubtraction;
import org.anna.mathass.learn.Matrix_Equality;
import org.anna.mathass.learn.Matrix_Negative;
import org.anna.mathass.learn.Matrix_Scalar_Multiplication;
import org.anna.mathass.learn.Matrix_Transpose;

import java.awt.event.*;
import java.awt.*;

public class Learn_Matrices extends JFrame implements MouseListener {
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
Main HomeScreen;
   JLabel Topic[],ScreenTitle;
   ScanThread st;
   UIStatus status;
   public Learn_Matrices()
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
	   
	   ScreenTitle = new JLabel("MATRICES");
	   ScreenTitle.setBounds((x/2)-(800/2), 50, 800, 50);
	   //ScreenTitle.setBackground(Color.BLACK);
	   ScreenTitle.setOpaque(true);
	   //ScreenTitle.setForeground(Color.GRAY);
	   ScreenTitle.setFont(ft);
	   ScreenTitle.setHorizontalAlignment(SwingConstants.CENTER);
	   add(ScreenTitle);
	   
	   //Tipics
	   String tstr[]={/*"MATRIX FORMATION","ELEMENT IDENTIFICATION",*/"MATRIX CONSTRUCTION","TRANSPOSE OF A MATRIX","EQUALITY OF MATRICES","ADDITION","MATRIX_HOME","SUBTRACTION","SCALAR MULTIPLICATION","MATRIX MULTIPLICATION","NEGATIVE OF MATRIX","HOME"};
	   Topic = new JLabel[tstr.length];
	   int ypos=150;
	   for(int i=0;i<Topic.length/2;i++)
	   {
	   Topic[i] = new JLabel(tstr[i]);
	   Topic[i].setBounds((x/2)-(1220/2), ypos, 600, 50);
	   ypos+=100;
	   Topic[i].setBackground(UISettings.WinBGColor);
	   Topic[i].setOpaque(true);
	   Topic[i].setForeground(UISettings.TextColor);
	   Topic[i].setFont(fc);
	   add(Topic[i]);
	   }
	   ypos=150;
	   for(int i=Topic.length/2;i<Topic.length;i++)
	   {
	   Topic[i] = new JLabel(tstr[i]);
	   Topic[i].setBounds((x/2), ypos, 600, 50);
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
   public static void main(String arg[])
   {
	 new Main().setVisible(true);
   }
@Override
public void mouseClicked(MouseEvent arg0) {

   switch(status.focused)
   {
   case 0:
   case 1:
	   new Matrix_Transpose().setVisible(true);
	   status.Visible = false;
	   setVisible(false);
	   break;
   case 2:
	   new Matrix_Equality().setVisible(true);
	   status.Visible = false;
	   setVisible(false);
	   break;
   case 3:
	   new MatrixAddition().setVisible(true);
	   status.Visible=false;
	   setVisible(false);
	   break;
	 
   case 4:
	   
	   new MatricsHome().setVisible(true);
	   status.Visible=false;
	   setVisible(false);
	   break;
   case 5:
	   new MatrixSubtraction().setVisible(true);
	   status.Visible = false;
	   setVisible(false);
	   break;
   case 6:
	   new Matrix_Scalar_Multiplication().setVisible(true);
	   status.Visible = false;
	   setVisible(false);
	   break;
   
	   
   case 7: 
	   new MatrixMultiplication().setVisible(true);
	   status.Visible = false;
	   setVisible(false);
	   break;
	   
   case 8:
	   new Matrix_Negative().setVisible(true);
	   status.Visible = false;
	   setVisible(false);
	   break;
   case 9:
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
