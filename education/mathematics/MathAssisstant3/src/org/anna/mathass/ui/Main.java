package org.anna.mathass.ui;

import javax.swing.*;

import org.anna.mathass.exam.ExamMain;
import org.anna.mathass.faculty.Login;
import org.anna.mathass.res.DataInfo;

import java.awt.event.*;
import java.awt.*;
import java.io.File;

public class Main extends JFrame implements MouseListener {
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
   Main HomeScreen;
   JLabel Topic[],ScreenTitle;
   ScanThread st;
   public UIStatus status;
   JButton fac;
   int hitCount = 0;
   JFrame login;
   public Boolean isFacultyOpen = false;
   public Main()
   {
	      setUndecorated(true);
	      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	      setBounds(0,0,screenSize.width, screenSize.height);
	      Toolkit tk = Toolkit.getDefaultToolkit();  
	      int x = ((int) tk.getScreenSize().getWidth());
	   JLabel jl = new JLabel();
	   if(!isDataDirAvailable())
	   JOptionPane.showMessageDialog(this, "There is a problem with data directory hirarchy.\n The system may not work properly");
	   UISettings.loadSettings();
	   Font ft= new Font(jl.getFont().getFontName(),Font.BOLD,jl.getFont().getSize()+UISettings.adFontSize);
	   Font fc= new Font(jl.getFont().getFontName(),Font.PLAIN,jl.getFont().getSize()+UISettings.adFontSize);
	   fac = new JButton("Faculty");
	   JPanel south = new JPanel(new GridLayout(1,5));
	   south.addMouseListener(this);
	   fac.addMouseListener(this);
	   for(int i = 0; i < 4; i++)
	   {
		   south.add(new JLabel("  "));
	   }
	   south.add(fac);
	   ScreenTitle = new JLabel("MATH ASSIST");
	   ScreenTitle.setBounds((x/2)-(800/2), 50, 800, 50);
	   //ScreenTitle.setBackground(Color.BLACK);
	   ScreenTitle.setOpaque(true);
	   //ScreenTitle.setForeground(Color.GRAY);
	   ScreenTitle.setFont(ft);
	   ScreenTitle.setHorizontalAlignment(SwingConstants.CENTER);
	   add(ScreenTitle);
	   
	   //Tipics
	   String tstr[]={"MATRICES","COORDINATE GEOMETRY","TAKE EXAM","EXIT"};
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
	   	   add(south,BorderLayout.SOUTH);
	   	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   public static void main(String arg[])
   {
	 new Main().setVisible(true);
   }
@Override
public void mouseClicked(MouseEvent event) {
   if(event.getSource().equals(fac))
   {   
       if(!isFacultyOpen)
	   {
	   login  = new Login(this);
	   login.setVisible(true);
	   isFacultyOpen = true;
	   }
	   else
		   Toolkit.getDefaultToolkit().beep();

   }
   else if(!isFacultyOpen)
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
	   new ExamMain().setVisible(true);
	   status.Visible=false;
	   setVisible(false); 
	   break;
   case 3 :
	   System.exit(0);
	   break;
	   
   }
   else
   {  Toolkit.getDefaultToolkit().beep();
      ++hitCount;
      if(hitCount == 3)
      {
    	  isFacultyOpen = false;
    	  hitCount = 0;
    	  login.dispose();
      }
   }
	
}
private boolean isDataDirAvailable()
{   
	File f;
	if(!(f = new File(DataInfo.GLOBAL_PARA_DIR)).isDirectory())
	if(!f.mkdirs())
	return false;
    if(!(f = new File(DataInfo.EXAM_QUES_DIR)).isDirectory())
    if(!f.mkdirs())
	return false;
    if(!(f = new File(DataInfo.EXAM_ANSWER_DIR)).isDirectory())
    	if(!f.mkdirs())
    	return false;
    if(!(f = new File(DataInfo.MATRIX_LEARN_QUES_DIR)).isDirectory())
    	if(!f.mkdirs())
    	return false;
    if(!(f = new File(DataInfo.MATRIX_PRAC_ANS_DIR)).isDirectory())
    	if(!f.mkdirs())
    	return false;
    if(!(f = new File(DataInfo.MATRIX_PRAC_QUES_DIR)).isDirectory())
    	if(!f.mkdirs())
    	return false;
    if(!(f = new File(DataInfo.ALGEBRA_LEARN_QUES_DIR)).isDirectory())
    	if(!f.mkdirs())
    	return false;
    if(!(f = new File(DataInfo.ALGEBRA_PRAC_ANS_DIR)).isDirectory())
    	if(!f.mkdirs())
    	return false;
    if(!(f = new File(DataInfo.ALGEBRA_PRAC_QUES_DIR)).isDirectory())
    	if(!f.mkdirs())
    	return false;
    if(!(f = new File(DataInfo.COORD_GEO_LEARN_QUES_DIR)).isDirectory())
    	if(!f.mkdirs())
    	return false;
    if(!(f = new File(DataInfo.COORD_GEO_PRAC_ANS_DIR)).isDirectory())
    	if(!f.mkdirs())
    	return false;
    if(!(f = new File(DataInfo.COORD_GEO_PRAC_QUES_DIR)).isDirectory())
    	if(!f.mkdirs())
    	return false;
    return true;
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
