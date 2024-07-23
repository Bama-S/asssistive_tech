//package javaapplication2;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Graph extends JPanel
{      
    public static Graphics g1=null;
    public static int rend;
    public static int lend;
    public static int tend;
    public static int bend;
    
    public static int rsize;
    public static int lsize;
    public static int tsize;
    public static int bsize;
    public static int px,py,t3,t4;
    public static int width,height;
    public static int axis;
    
    public static boolean topic=true;
    public static boolean first=true;    
    
    
    public static void clearGraph()
    {
        axis = 0;
        px = 0;
        py = 0;
        t3 = 0;
        t4 = 0;
        first = true;
        topic = true;
    }    
    
    public static void restart()
    {
       Thread th=new Thread(new Quadrant());
       th.start();                             
    }    
    
    
       
    public void paint(Graphics g)
    {      	
        super.paintComponent(g);
        g1 = getGraphics();         
	width=getWidth();
	height=getHeight();         
        
        rsize = (width/2)/11;
        lsize = (width/2)/11;
        tsize = (height/2)/6;
        bsize = (height/2)/6;   
        
        rend=(width/2-20)+11*rsize;
        lend=(width/2-20)-11*lsize;
        tend=(height/2+20)-6*tsize;
        bend=(height/2+20)+6*bsize;    
        g.setColor(Color.RED);
        
        for(int i=0;i<=width;i=i+rsize)
        {
            g.drawLine(i,0,i,height);
        }
        for(int i=0;i<=height;i=i+tsize)
        {
            g.drawLine(0,i,width,i);
        }
        
        g.setColor(Color.BLACK);        
        g.drawLine(width/2,0,width/2,height);
        g.drawLine(width/2+1,0,width/2+1,height);
        g.drawLine(width/2-1,0,width/2-1,height);
        g.drawLine(0,height/2,width,height/2);        
        g.drawLine(0,height/2+1,width,height/2+1);
        g.drawLine(0,height/2-1,width,height/2-1);
        
        
        
        Font f=new Font("ARIAL",Font.PLAIN,18);
        g.setFont(f);
        g.setColor(Color.DARK_GRAY);
        int n=0;
        for(int i=width/2-20;i<=width;i=i+rsize)
        {
            String str=String.valueOf(n);
            g.drawString(str,i,height/2+20);
            n++;
        }
        n=0;
        for(int i=height/2+20;i>=0;i=i-tsize)
        {
            String str=String.valueOf(n);
            g.drawString(str,width/2-20,i);
            n++;
        }
        n=0;
        for(int i=width/2-20;i>=0;i=i-lsize)
        {
            String str=String.valueOf(n);
            g.drawString(str,i,height/2+20);
            n--;
        }
        n=0;
        for(int i=height/2+20;i<=height;i=i+bsize)
        {
            String str=String.valueOf(n);
            if(n==0)
            g.drawString(str,width/2-20,i);
            else
            g.drawString(str,width/2-25,i);
            n--;
        }

        if(first)
        {
            first=false;
            Graph.restart();
        }
    }       
    
}
