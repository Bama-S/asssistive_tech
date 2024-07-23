//package javaapplication2;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TrigonometryRatioChoice extends JPanel 
{     
    public static int width,height;
    public static Graphics g1;
    public static int topic=1;
    public static String s="CHOICE MENU";
    public static String s1="LEVEL-1";
    public static String s2="LEVEL-2";    
    public static boolean first = true;
    
    public static void clearTrigonometryRatioChoice()
    {
        topic = 1;
        first = true;
    }
    public static void restart()
    {
        Thread th=new Thread(new TrigonometryRatioThread());
        th.start();
    }
    public void paint(Graphics g)
    {  
    	super.paintComponent(g);        
        g1=getGraphics(); 
	width=getWidth();
	height=getHeight();     
        Font f=new Font("ARIAL",Font.BOLD,30);
        g.setFont(f);
        g.setColor(Color.MAGENTA);
        g.drawString(s,400,100);
        Font f1=new Font("ARIAL",Font.BOLD,30);
        g.setFont(f1);
        g.setColor(Color.BLUE);                
        g.drawString(s1,200,200);
        g.drawString(s2,200,300);        
        if(first)
        {
            first = false;
            TrigonometryRatioChoice.restart(); 
        }
    }           
    
}
