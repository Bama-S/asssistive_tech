//package javaapplication2;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Angle extends JPanel
{
    public static Graphics g1=null;
    public static int width,height;
    public int xnew,ynew;
    public Graphics2D g2;
    public static boolean first = true;
    public double a1=0.0,a2=0.0,a3=0.0,a4=0.0;
    public static double[] angle = new double[4];
    
    public static void clearAngle()
    {
        first = true;
        angle = new double[4];
        
    }
    
    public void rotate(int x,int y,int xr,int yr,double theta)
    {
        theta = Math.toRadians(theta);
        int a = (int) ((x - xr) * Math.cos(theta) - (y - yr) * Math.sin(theta));
        int b = (int) ((x - xr) * Math.sin(theta) - (y - yr) * Math.cos(theta));
        xnew = xr + a;
        ynew = yr + b;
    }  
    
    public static void restart()
    {
        Thread th = new Thread(new AngleThread());
        th.start();
    }
    
    public void AngleGeneration()
    {        
        while(true)
        {
            a1 =  Math.random() * 140;
            a2 =  Math.random() * 140;
            a3 =  Math.random() * 140;
            a4 =  Math.random() * 140;     
            if(Math.abs(a1-a2)>=20 && Math.abs(a2-a3)>=20 && Math.abs(a3-a4)>=20 && Math.abs(a4-a1)>=20 && Math.abs(a1-a3)>=20 && Math.abs(a2-a4)>=20 && a1>25 && a2>25 && a3>25 && a4>25)
            {
                  angle[0] = -a1;
                  angle[1] = -a2;
                  angle[2] = -a3;
                  angle[3] = -a4; 
                  break;
            }
        }
    }
    
    public void paint(Graphics g)
    {
        Main.classid = 6;
        super.paintComponent(g);
        g1=getGraphics();
	width=getWidth();
	height=getHeight();   
        
        if(first)            
            AngleGeneration();        
        
        g.setColor(Color.PINK);
        
        g.fillOval(50,80,200,150);
        g.fillOval(350,80,200,150);
        g.fillOval(650,80,200,150);
        g.fillOval(950,80,200,150);         
        
        g.setColor(Color.WHITE);
        
        g.fillOval(50,380,200,150);
        g.fillOval(350,380,200,150);
        g.fillOval(650,380,200,150);
        g.fillOval(950,380,200,150);       
        
        g.setColor(Color.BLACK);
        
        g.drawLine(125,200,225,200);
        rotate(225,200,125,200,angle[0]);
        g.drawLine(125,200,xnew,ynew);
        
        
        g.drawLine(425,200,525,200);
        rotate(525,200,425,200,angle[1]);
        g.drawLine(425,200,xnew,ynew);       
        
        g.drawLine(725,200,825,200);
        rotate(825,200,725,200,angle[2]);
        g.drawLine(725,200,xnew,ynew);        
        
        g.drawLine(1025,200,1125,200);
        rotate(1125,200,1025,200,angle[3]);
        g.drawLine(1025,200,xnew,ynew); 
        
        if(first)
        {
            first = false;
            Angle.restart();
        }
        
    }    
    
}
