//package javaapplication2;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Index extends JPanel
{  
    public static Graphics g1;
    public static int topic=1;
    public static String s="MATHASSISTANT HOME PAGE";
    public static String s1="COURSE MATERIAL";
    public static String s2="PRACTICE";
    public static String s3="EXAM TOOL";
    public static boolean first = true;
    
    public static void clearIndex()
    {
        topic = 1;
        first = true;
    }
    
    public static void restart()
    {
        Thread th=new Thread(new IndexThread());
        th.start();
    }
       
    public void paint(Graphics g)
    {  
    	super.paintComponent(g);
        g1=getGraphics();
        Font f=new Font("ARIAL",Font.BOLD,36);
        g.setFont(f);
        g.setColor(Color.MAGENTA);        
        g.drawString(s,400,50);
        Font f1=new Font("ARIAL",Font.BOLD,30);
        g.setFont(f1);
        g.setColor(Color.BLUE);        
        
        g.drawString(s1,200,200);
        g.drawString(s2,200,300);
        g.drawString(s3,200,400);      
        if(first)
        {
            first = false;
            Index.restart(); 
        }
    }       
    
}
