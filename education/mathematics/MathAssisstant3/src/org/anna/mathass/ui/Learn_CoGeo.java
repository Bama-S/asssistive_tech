package org.anna.mathass.ui;

import javax.swing.*;

import org.anna.mathass.learn.CoGeo_Area;
import org.anna.mathass.learn.CoGeo_Centroid;
import org.anna.mathass.learn.CoGeo_Distance;
import org.anna.mathass.learn.CoGeo_External;
import org.anna.mathass.learn.CoGeo_Internal;
import org.anna.mathass.learn.CoGeo_Midpoint;
import org.anna.mathass.learn.CoGeo_Slope1;
import org.anna.mathass.learn.CoGeo_Slope2;
import org.anna.mathass.learn.MatrixAddition;
import org.anna.mathass.learn.MatrixMultiplication;
import org.anna.mathass.learn.MatrixSubtraction;
import org.anna.mathass.learn.Matrix_Equality;
import org.anna.mathass.learn.Matrix_Negative;
import org.anna.mathass.learn.Matrix_Scalar_Multiplication;
import org.anna.mathass.learn.Matrix_Transpose;

import java.awt.event.*;
import java.awt.*;

public class Learn_CoGeo extends JFrame implements MouseListener {
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
Main HomeScreen;
   JLabel Topic[],ScreenTitle;
   ScanThread st;
   UIStatus status;
   public Learn_CoGeo()
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
	   
	   ScreenTitle = new JLabel("COORDINATE GEOMETRY");
	   ScreenTitle.setBounds((x/2)-(800/2), 50, 800, 50);
	   //ScreenTitle.setBackground(Color.BLACK);
	   ScreenTitle.setOpaque(true);
	   //ScreenTitle.setForeground(Color.GRAY);
	   ScreenTitle.setFont(ft);
	   ScreenTitle.setHorizontalAlignment(SwingConstants.CENTER);
	   add(ScreenTitle);
	   
	   //Tipics
	   String tstr[]={"DISTANCE","MID POINT","CENTROID","INTERNAL SEGMENT","COGEO_HOME","AREA OF TRIANGLE","SLOPE USING ANGLE","SLOPE USING TWO POINTS","EXTERNAL SEGMENT","HOME"};
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
	   new CoGeo_Distance().setVisible(true);
	   status.Visible = false;
	   setVisible(false);
	   break;
   case 1:
	   new CoGeo_Midpoint().setVisible(true);
	   status.Visible = false;
	   setVisible(false);
	   break;
   case 2:
	   new CoGeo_Centroid().setVisible(true);
	   status.Visible = false;
	   setVisible(false);
	   break;
   case 3:
	   new CoGeo_Internal().setVisible(true);
	   status.Visible=false;
	   setVisible(false);
	   break;
	   
   case 4:
	   new CoGeoHome().setVisible(true);
	   status.Visible=false;
	   setVisible(false);
	   break;
   case 5:
	   new CoGeo_Area().setVisible(true);
	   status.Visible=false;
	   setVisible(false);
	   break;
   case 6:
	   new CoGeo_Slope1().setVisible(true);
	   status.Visible=false;
	   setVisible(false);
	   break;
   case 7:
	   new CoGeo_Slope2().setVisible(true);
	   status.Visible = false;
	   setVisible(false);
	   break;  
   case 8: 
	   new CoGeo_External().setVisible(true);
	   status.Visible=false;
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
public void mouseEntered(MouseEvent arg0) {}
@Override
public void mouseExited(MouseEvent arg0) {}
@Override
public void mousePressed(MouseEvent arg0) {}
@Override
public void mouseReleased(MouseEvent arg0) {}
}
