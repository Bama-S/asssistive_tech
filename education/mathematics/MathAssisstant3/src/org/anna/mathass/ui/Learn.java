package org.anna.mathass.ui;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Learn extends JFrame implements MouseListener {
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
Main HomeScreen;
   JLabel Topic[],ScreenTitle;
   ScanThread st;
   UIStatus status;
   Learn()
   {
	   setUndecorated(true);
	      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	      setBounds(0,0,screenSize.width, screenSize.height);
	      Toolkit tk = Toolkit.getDefaultToolkit();  
	      int x = ((int) tk.getScreenSize().getWidth());
	   
	   //Font purpos
	   JLabel jl = new JLabel();
	   JLabel j2=new JLabel();
	   Font ft= new Font(jl.getFont().getFontName(),Font.BOLD,jl.getFont().getSize()+20);

	   
	   ScreenTitle = new JLabel("LEARNING POINT");
	   ScreenTitle.setBounds((x/2)-(800/2), 40, 800, 50);
	   //ScreenTitle.setBackground(Color.BLACK);
	   ScreenTitle.setOpaque(true);
	   //ScreenTitle.setForeground(Color.GRAY);
	   ScreenTitle.setFont(ft);
	   ScreenTitle.setHorizontalAlignment(SwingConstants.CENTER);
	   add(ScreenTitle);
	   j2.setBounds(20, 40, screenSize.width-40, screenSize.height-200);
	   j2.setOpaque(true);
	   j2.setBackground(Color.WHITE);
	   add(j2);
	   
	   //Tipics
	   /*String tstr[]={"MATRICES","COORDINATE GEOMETRY","ALGEBRA","EXIT"};
	   Topic = new JLabel[tstr.length];
	   int ypos=150;
	   for(int i=0;i<Topic.length;i++)
	   {
	   Topic[i] = new JLabel(tstr[i]);
	   Topic[i].setBounds((x/2)-(400/2), ypos, 400, 50);
	   ypos+=100;
	   Topic[i].setBackground(Color.WHITE);
	   Topic[i].setOpaque(true);
	   Topic[i].setForeground(Color.BLACK);
	   Topic[i].setFont(fc);
	   add(Topic[i]);
	   }
*/	   
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
	 new Learn().setVisible(true);
   }
@Override
public void mouseClicked(MouseEvent arg0) {

   switch(status.focused)
   {
   case 0 :
	   new MatricsHome().setVisible(true);
	   status.Visible=false;
	   setVisible(false);
	   break;
   case 1 :
	   new CoGeoHome().setVisible(true);
	   status.Visible=false;
	   setVisible(false);
	   break;
   case 2 :
	   new Algebra().setVisible(true);
	   status.Visible=false;
	   setVisible(false);
	   break;
   case 3 :
	   System.exit(0);
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
