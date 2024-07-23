package org.anna.mathass.faculty;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Login extends JFrame implements MouseListener {
 JLabel  ul,pl;
 JTextField uname;
 JPasswordField pwd;
 JButton login,cancel;
 JFrame parent,me;
 Robot r;
 Dimension dim;
 public Login(JFrame p)
 {   super("Login");
     parent = p;
	 dim = Toolkit.getDefaultToolkit().getScreenSize();
	 me = this;
	 this.setResizable(false);
	 this.setSize(dim.width/2, dim.height/3);
	 this.getContentPane().setLayout(new GridLayout(7,2));
	 JLabel jl = new JLabel();
	 Font fc= new Font(jl.getFont().getFontName(),Font.PLAIN,jl.getFont().getSize()+5);
	 Font fm= new Font(jl.getFont().getFontName(),Font.PLAIN,jl.getFont().getSize()+20);
	 ul = new JLabel("            User Name");
	 pl = new JLabel("            Password");
	 uname = new JTextField();
	 pwd = new JPasswordField();
	 login = new JButton("Login");
	 cancel = new JButton("Cancel");
	 JPanel lp = new JPanel(new BorderLayout());
	 JPanel cp = new JPanel(new BorderLayout());
	 lp.add(login,BorderLayout.CENTER);
	 lp.add(new JLabel("  "),BorderLayout.EAST);
	 lp.add(new JLabel("  "),BorderLayout.WEST);
	 cp.add(cancel,BorderLayout.CENTER);
	 cp.add(new JLabel("  "),BorderLayout.EAST);
	 cp.add(new JLabel("  "),BorderLayout.WEST);
	 ul.setFont(fc);
	 pl.setFont(fc);
	 uname.setFont(fc);
	 pwd.setFont(fc);
	 login.setFont(fc);
	 cancel.setFont(fc);
	 add(new JLabel(" "));
	 add(new JLabel(" "));
	 add(ul);
	 add(uname);
	 add(new JLabel(" "));
	 add(new JLabel(" "));
	 add(pl);
	 add(pwd);
	 add(new JLabel(" "));
	 add(new JLabel(" "));
	 add(lp);
	 add(cp);
	 JLabel msg1,msg2;
	 msg1 = new JLabel("Hit 3 times to close if");
	 msg2 = new JLabel("opened unintentionaly");
	 msg1.setFont(fm);
	 msg2.setFont(fm);
	 add(msg1);
	 add(msg2);
	 setLocationRelativeTo(null);
	 this.addWindowListener(new WindowAdapter() {
	      public void windowClosing(WindowEvent e) {
	    	  ((org.anna.mathass.ui.Main)parent).isFacultyOpen = false;
	      }
	      
	 });
	 
	 this.addWindowFocusListener(new WindowAdapter() {
		 public void windowLostFocus(WindowEvent e) {
	   	  me.requestFocus();
	     }
	      
	 });
	 login.addMouseListener(this);
	 cancel.addMouseListener(this);
	 try {
		r = new Robot();
		r.mouseMove(dim.width - 10,dim.height/2);
	} catch (AWTException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	 this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
 }
@Override
public void mouseClicked(MouseEvent e) {
	if(e.getSource().equals(login))
	{
		((org.anna.mathass.ui.Main)parent).status.Visible =  false;
		parent.setVisible(false);
		parent.dispose();
		new FacultyMain().setVisible(true);
		this.dispose();
	}
	else
	{   
		((org.anna.mathass.ui.Main)parent).isFacultyOpen = false;
		this.dispose();
	}
}
@Override
public void mouseEntered(MouseEvent e) {}
@Override
public void mouseExited(MouseEvent e) {}
@Override
public void mousePressed(MouseEvent e) {}
@Override
public void mouseReleased(MouseEvent e) {}

}
