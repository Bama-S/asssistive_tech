
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;
import javax.swing.border.*;
import java.awt.Robot;
import javax.swing.JButton;
                   
public class application extends Thread implements MouseListener,ActionListener
{  
	Font f1;
	JPanel p=new JPanel();
	JButton appOptionsBtnList[];
	int p0=0;
    JFrame f;
	h1 kb = null;
	static boolean threadCanRun1 = true;
	boolean frameCreated = false;
	public application(){}

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
		f.setTitle("Application");
     	f.getContentPane().add(p, BorderLayout.CENTER);
		f.setSize(600,350);
		f.setAlwaysOnTop(true);
	    p.setBackground(Color.BLACK);
		f.setVisible(true);
		f.setResizable(false);
		f.addMouseListener(this);
		appOptionsBtnList = new JButton[9];
	
		appOptionsBtnList[0] = new JButton("Notepad");
		p.add(appOptionsBtnList[0]);
		appOptionsBtnList[0].addActionListener(this);
		appOptionsBtnList[0].setBackground(Color.WHITE);
		
		appOptionsBtnList[1] = new JButton("Wordpad");
		p.add(appOptionsBtnList[1]);
		appOptionsBtnList[1].addActionListener(this);
		appOptionsBtnList[1].setBackground(Color.WHITE);
		
		appOptionsBtnList[2] = new JButton("Excel");
		p.add(appOptionsBtnList[2]);
		appOptionsBtnList[2].addActionListener(this);
		appOptionsBtnList[2].setBackground(Color.WHITE);

        appOptionsBtnList[3] = new JButton("Browser");
		p.add(appOptionsBtnList[3]);
		appOptionsBtnList[3].addActionListener(this);
		appOptionsBtnList[3].setBackground(Color.WHITE);

        appOptionsBtnList[4] = new JButton("Power Point");
		p.add(appOptionsBtnList[4]);
		appOptionsBtnList[4].addActionListener(this);
		appOptionsBtnList[4].setBackground(Color.WHITE);

        appOptionsBtnList[5] = new JButton("MS Word");
		p.add(appOptionsBtnList[5]);
		appOptionsBtnList[5].addActionListener(this);
		appOptionsBtnList[5].setBackground(Color.WHITE);

        appOptionsBtnList[6] = new JButton("Keyboard");
		p.add(appOptionsBtnList[6]);
		appOptionsBtnList[6].addActionListener(this);
		appOptionsBtnList[6].setBackground(Color.WHITE);

		Font f1=new Font("Calibre",Font.BOLD,30);
        for(int i=0;i<7;i++)
		{
		appOptionsBtnList[i].setFont(f1);
		}
		frameCreated = true;
	}

	public void startThread()
	{
	   Thread t1 = new Thread(this);
	   threadCanRun1=true;
	   t1.start();
	}
	
	private void stopThread()
	{
	    threadCanRun1 = false;
   	}

	public void run()
	{
			for(int i=0;i<30&&threadCanRun1;i++)
			{     	
			for (int j=0; j<7&&threadCanRun1;j++)
			{       
			appOptionsBtnList[j].setBackground(Color.YELLOW);
			p0=j;
			try{
			sleep(5000);
			}catch(Exception te)
			{}
			appOptionsBtnList[p0].setBackground(Color.WHITE);
			}
			}
	}
	
	public void toggleFrame() {
		this.stopThread();
		f.setVisible(false);
		kb.KeyBoard();
        kb.frame.setVisible(true);
		kb.startThread();
	}
	
	public void actionPerformed(ActionEvent e)
	{  
		 if(e.getSource()==appOptionsBtnList[0])
		{
                 try
                 {
                    Runtime.getRuntime().exec("cmd /c start notepad.exe");
     	         }
                 catch(Exception ae)
                 {}
		}
         else if(e.getSource()==appOptionsBtnList[1])
		{
            	try
                {
                  Runtime.getRuntime().exec("cmd /c start wordpad.exe");
	            }
                catch(Exception ae)
                {}	
        }
        else if(e.getSource()==appOptionsBtnList[2])
		{
                 try
                {
                    Runtime.getRuntime().exec("cmd /c start excel.exe");
	             }
                 catch(Exception ae)
                 {}
		 }
         else if(e.getSource()==appOptionsBtnList[3])
		{
       		      try
                  {
                    Runtime.getRuntime().exec("cmd /c start chrome.exe");
	              }
                 catch(Exception ae)
                 {}
		 }
        else if(e.getSource()==appOptionsBtnList[4])
		{
         	     try
                 {
                    Runtime.getRuntime().exec("cmd /c start powerpnt.exe");
	             }
                 catch(Exception ae)
                  {}
		 }
        else if(e.getSource()==appOptionsBtnList[5])
		{
         	     try
                 {
                    Runtime.getRuntime().exec("cmd /c start winword.exe");
	             }
                 catch(Exception ae)
                  {}
		 }
		 else if(e.getSource()==appOptionsBtnList[6])
		{
                 toggleFrame();
		}
    }

  public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
	

	public static void main(String s[])
	{
		application x=new application();
		h1 kb = new h1();
		x.setframe(kb);
	    x.startThread();
	}

	      
     public void mouseClicked (MouseEvent e)
	   {
		if(p0==0) 
		{
				   try
                   {
                    Runtime.getRuntime().exec("cmd /c start notepad.exe");
	               }
                   catch(Exception ae)
                   {}	
		}
		else if(p0==1)
		{
				   try
                   {
                    Runtime.getRuntime().exec("cmd /c start wordpad.exe");
			       }
                   catch(Exception ae)
                   {}	
		}
		else if(p0==2)
		{
					try
                   {
                    Runtime.getRuntime().exec("cmd /c start excel.exe");
				   }
				   catch(Exception ae)
                  {}	
		}
		else if(p0==3)
		{
					try
                   {
                    Runtime.getRuntime().exec("cmd /c start chrome.exe");
	               }
                   catch(Exception ae)
                  {}	
		}
		else if(p0==4)
		{
				    try
                   {
                    Runtime.getRuntime().exec("cmd /c start powerpnt.exe");
	                }
                    catch(Exception ae)
                  {}
		}
		else if(p0==5)
		{
                 try
                  {
                    Runtime.getRuntime().exec("cmd /c start winword.exe");
	              }
                 catch(Exception ae)
                  {}
		}
        else if(p0==6)
		{
                toggleFrame();
        }
    }
    public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
}


	






		
