

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;
import javax.swing.border.*;
import java.awt.Robot;
import javax.swing.JButton;
                   
public class custom extends Thread implements MouseListener,ActionListener
{  
	Font f1;
	JPanel p=new JPanel();
	JLabel l1,l2,l3,l4;
	JButton customOptionsBtnList[];
	int p0=0;
    public int scanSpeed=5000;
	public Color clr = Color.yellow;
	public int fntSize = 30;
	public int layoutVal = 0;
	JFrame f;
	h1 kb = null;
	static boolean threadCanRun2 = true;
	boolean frameCreated = false;
    public custom()
	{}

	public void setframe(h1 kb)
	{
		this.kb = kb;
		setframe();
	}

	public void setframe()
	{
		if (frameCreated) {
			f.setVisible(true);
			return;
		}
		f = new JFrame();
		f.setTitle("customization");
     	f.getContentPane().add(p, BorderLayout.CENTER);
		f.setSize(600,350);
		f.setAlwaysOnTop(false);
		f.setVisible(true);
		f.setResizable(false);
		f.addMouseListener(this);
        p.setBackground(Color.BLACK);
		customOptionsBtnList = new JButton[11];
		
    	Font f1=new Font("Calibre",Font.BOLD,30);
		l1=new JLabel("scan time");
		l1.setFont(f1);
        l1.setForeground(Color.yellow);
		p.add(l1);
		
		customOptionsBtnList[0] = new JButton("slow");
		p.add(customOptionsBtnList[0]);
		customOptionsBtnList[0].addActionListener(this);
		customOptionsBtnList[0].setBackground(Color.WHITE);
		
		customOptionsBtnList[1] = new JButton("medium");
		p.add(customOptionsBtnList[1]);
		customOptionsBtnList[1].addActionListener(this);
		customOptionsBtnList[1].setBackground(Color.WHITE);
		
		customOptionsBtnList[2] = new JButton("fast");
		p.add(customOptionsBtnList[2]);
		customOptionsBtnList[2].addActionListener(this);
		customOptionsBtnList[2].setBackground(Color.WHITE);
		
		l2=new JLabel("scan color");
		l2.setFont(f1);
        l2.setForeground(Color.yellow);
       	p.add(l2);
		
		customOptionsBtnList[3] = new JButton("pink");
		p.add(customOptionsBtnList[3]);
		customOptionsBtnList[3].addActionListener(this);
		customOptionsBtnList[3].setBackground(Color.WHITE);
		
		customOptionsBtnList[4] = new JButton("yellow");
		p.add(customOptionsBtnList[4]);
		customOptionsBtnList[4].addActionListener(this);
		customOptionsBtnList[4].setBackground(Color.WHITE);
		
		customOptionsBtnList[5] = new JButton("cyan");
		p.add(customOptionsBtnList[5]);
		customOptionsBtnList[5].addActionListener(this);
		customOptionsBtnList[5].setBackground(Color.WHITE);
		
		l3=new JLabel("font size");
		l3.setFont(f1);
        l3.setForeground(Color.yellow);
   		p.add(l3);

		customOptionsBtnList[6] = new JButton("small");
		p.add(customOptionsBtnList[6]);
		customOptionsBtnList[6].addActionListener(this);
		customOptionsBtnList[6].setBackground(Color.WHITE);
		
		customOptionsBtnList[7] = new JButton("medium");
		p.add(customOptionsBtnList[7]);
		customOptionsBtnList[7].addActionListener(this);	
		customOptionsBtnList[7].setBackground(Color.WHITE);
		
		customOptionsBtnList[8] = new JButton("large");
		p.add(customOptionsBtnList[8]);
		customOptionsBtnList[8].addActionListener(this);
		customOptionsBtnList[8].setBackground(Color.WHITE);
		
		l4=new JLabel("layout");
		l4.setFont(f1);
        l4.setForeground(Color.yellow);
   		p.add(l4);

		customOptionsBtnList[9] = new JButton("QWERTY");
		p.add(customOptionsBtnList[9]);
		customOptionsBtnList[9].addActionListener(this);
		customOptionsBtnList[9].setBackground(Color.WHITE);
		
		customOptionsBtnList[10] = new JButton("ABC");
		p.add(customOptionsBtnList[10]);
		customOptionsBtnList[10].addActionListener(this);
		customOptionsBtnList[10].setBackground(Color.WHITE);
	    
		for(int i=0;i<11;i++)
		{
		customOptionsBtnList[i].setFont(f1);
		}
		frameCreated = true;
	}

	public void startThread()
	{
	   Thread t2 = new Thread(this);
	   threadCanRun2=true;
	   t2.start();
	}
	
	private void stopThread()
	{
	    threadCanRun2 = false;
	 }
	
	public void run()
	{
		 		
		for(int i=0;i<30&&threadCanRun2;i++){
		for (int j=0; j<11&&threadCanRun2;j++){
		customOptionsBtnList[j].setBackground(Color.YELLOW);
		p0=j;
		try{
		sleep(5000);}
		catch(InterruptedException e) {
					e.printStackTrace();
		}
		customOptionsBtnList[p0].setBackground(Color.WHITE);
        }}
}

	public void toggleFrame() {
		this.stopThread();
		f.setVisible(false);  
		kb.frame.setVisible(true);
		kb.startThread();
	}
	
	public void toggleFrame1() {
		this.stopThread();
		f.setVisible(false);
	    kb.KeyBoard1();       
		kb.frame.setVisible(true);
		kb.startThread();
	}

	public void actionPerformed(ActionEvent e)
	{  
		 if(e.getSource()==customOptionsBtnList[0])
		{
            scanSpeed = 9000;
			toggleFrame();
		 }
         else if(e.getSource()==customOptionsBtnList[1])
		{
            scanSpeed = 6000;
			toggleFrame();
		 }
        else if(e.getSource()==customOptionsBtnList[2])
		{
            scanSpeed = 3000;
			toggleFrame();
		 }
         else if(e.getSource()==customOptionsBtnList[3])
		{
       		clr = Color.pink;
			toggleFrame();
		 }
        else if(e.getSource()==customOptionsBtnList[4])
		{
         	clr = Color.yellow;
			toggleFrame();
		 }
        else if(e.getSource()==customOptionsBtnList[5])
		{
         	clr = Color.cyan;
			toggleFrame();
		 }
		 else if(e.getSource()==customOptionsBtnList[6])
		{
            fntSize=20;
			toggleFrame();
		 }
        else if(e.getSource()==customOptionsBtnList[7])
		{
            fntSize=25;
			toggleFrame();
		 }
         else if(e.getSource()==customOptionsBtnList[8])
		{
            fntSize=30;
			toggleFrame();
		 }
        else if(e.getSource()==customOptionsBtnList[9])
		{
            layoutVal=1;
		    toggleFrame1();
		 }
        else if(e.getSource()==customOptionsBtnList[10])
		{
           layoutVal=0;
		   toggleFrame1();
		 }
	}
    public void windowClosing(WindowEvent e) {
		stopThread();
		System.exit(0);
	}
	public static void main(String s[])
	{
		custom x=new custom();
		h1 kb = new h1();
		kb.KeyBoard();
		x.setframe(kb);
	    x.startThread();
	}


	public void mouseClicked (MouseEvent e)
	{
		if(p0==0) 
		{
			scanSpeed = 9000;
			toggleFrame();
		}
		else if(p0==1)
		{
			scanSpeed=6000;
			toggleFrame();
		}
		else if(p0==2)
		{
			scanSpeed=3000;
			toggleFrame();
		}
		else if(p0==3)
		{
			clr = Color.pink;
			toggleFrame();
		}
		else if(p0==4)
		{
			clr=Color.yellow;
			toggleFrame();
		}
		else if(p0==5)
		{
			clr=Color.cyan;
     		toggleFrame();
		}
		else if(p0==6)
		{
			fntSize=20;
			toggleFrame();
		}
		else if(p0==7)
		{
			fntSize=25;
			toggleFrame();
		}
		else if(p0==8)
		{
			fntSize=30;
			toggleFrame();
		}
		else if(p0==9)
		{
			layoutVal=1;
			toggleFrame1();
		}
		else if(p0==10)
		{
			layoutVal=0;
			toggleFrame1();
		}
	}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
}




