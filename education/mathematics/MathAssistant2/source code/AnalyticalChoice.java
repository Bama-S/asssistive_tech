//package javaapplication2;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AnalyticalChoice extends JPanel 
{     
    public static int width,height;
    public static Graphics g1;
    public static int topic=1;
    public static String s="CHOICE MENU";
    public static String s1="SLOPE OF A LINE";
    public static String s2="REFLECTIONS";
    public static String s3="TRANSLATIONS";
    public static String s4="EQUATION OF A LINE";
    public static boolean first = true;
    
    public static void clearAnalyticalChoice()
    {
        topic = 1;
        first = true;
    }
    
    public static void restart()
    {
        Thread th=new Thread(new AnalyticalThread());
        th.start();
    }
    public void paint(Graphics g)
    {  
    	super.paintComponent(g);        
        g1=getGraphics(); 
	width=getWidth();
	height=getHeight();     
        Font f=new Font("ARIAL",Font.BOLD,36);
        g.setFont(f);
        g.setColor(Color.MAGENTA);        
        g.drawString(s,500,100);
        Font f1=new Font("ARIAL",Font.BOLD,30);
        g.setFont(f1);
        g.setColor(Color.BLUE);        
        g.drawString(s4,200,200);
        g.drawString(s1,200,300);
        g.drawString(s2,200,400);      
        g.drawString(s3,200,500);
        if(first)
        {
            first = false;
            AnalyticalChoice.restart(); 
        }
    }           
    
}
