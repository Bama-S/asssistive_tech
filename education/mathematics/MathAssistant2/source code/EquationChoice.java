//package javaapplication2;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EquationChoice extends JPanel 
{     
    public static int width,height;
    public static Graphics g1;
    public static int topic=1;
    public static boolean first = true;
    public static String s="CHOICE MENU";
    public static String s1="SLOPE-INTERCEPT FORM";
    public static String s2="INTERCEPT FORM";
    //public static String s3="SLOPE-POINT FORM";
    
    public static void clearEquationChoice()
    {
        topic = 1;
        first = true;
    }
    
    public static void restart()
    {
        Thread th=new Thread(new EquationChoiceThread());
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
        g.drawString(s1,200,200);
        g.drawString(s2,200,300);
      //  g.drawString(s3,200,400);      
        
        if(first)
        {
            first = false;
            EquationChoiceThread.restart(); 
        }
    }           
    
}
