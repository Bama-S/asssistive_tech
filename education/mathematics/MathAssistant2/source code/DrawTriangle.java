//package javaapplication2;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DrawTriangle extends JPanel
{      
    public static Graphics g1=null;
    public static int width,height;
    public static int redx,redy;
    public static int bluex,bluey;
    public static int greenx,greeny;
    public static int firstCirclex1,firstCircley1,firstCirclex2,firstCircley2;
    public static int secondCirclex1,secondCircley1,secondCirclex2,secondCircley2;  
    public static boolean first = true;
    public static void clearDrawTriangle()
   {
    first=true;
    redx = 0;
    redy=0;
    bluex=0;
    bluey=0;
    greenx=0;
greeny=0;
firstCirclex1=0;
firstCirclex2=0;
firstCircley1=0;
firstCircley2=0;
secondCirclex1=0;
secondCirclex2=0;
secondCircley1=0;
secondCircley2=0;
}
    

    
    public static void restart()
    {
       Thread th=new Thread(new HorizontalMove());
       th.start();                             
    }      
       
    public void paint(Graphics g)
    {      	
        super.paintComponent(g);
        setPreferredSize(new Dimension(2000,2000));
        g.clearRect(0,0,getWidth(),getHeight());
        g1 = getGraphics();     
	width=getWidth();
	height=getHeight();
                
        g.setColor(Color.BLACK);
        //g.drawLine(0,0,0,height);
        if(first)
        {
            first=false;
            DrawTriangle.restart();
        }
       
    }       
    
}
