//package javaapplication2;

import java.applet.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class RotationThread extends DrawTriangle implements Runnable
{ 
    Graphics2D g2,g3;
    Graphics g5;    
    public int xref,yref,length;
    public int xnew,ynew;
    public int r1,r2;        
    public double theta = 5.0;
    
    public void rotate(int x,int y,int xr,int yr,double theta)
    {
        theta = Math.toRadians(theta);
        int a = (int) ((x - xr) * Math.cos(theta) - (y - yr) * Math.sin(theta));
        int b = (int) ((x - xr) * Math.sin(theta) - (y - yr) * Math.cos(theta));
        xnew = xr + a;
        ynew = yr + b;
    }     
    
    public RotationThread(int x,int y,int length)
    {
        this.xref = x;
        this.yref = y;
        this.length = length; 
    }
    
    public void run()
    {
        g2 = (Graphics2D) g1.create();
        g3 = (Graphics2D) g1.create();        
        g5 = g1.create();
        
        g2.setStroke(new BasicStroke(3.0f));
        g3.setStroke(new BasicStroke(3.0f));
        
        g2.setColor(Color.BLACK);
        g3.setColor(Color.WHITE);
        
        int mylength=0;
        
        int xprev=xref+length,yprev=yref;
        int tempx = xprev,tempy = yprev;
        while(true)
        {
            rotate(xprev,yprev,xref,yref,theta);       
            
            g3.drawLine(xref,yref,tempx,tempy);
            
            g5.setColor(Color.BLUE);
            g5.fillOval(bluex-10,bluey-10,20,20) ;        
            
            g2.drawLine(xref,yref,xnew,ynew);
            
            tempx = xnew;
            tempy = ynew;
                        
            if(Main.flag)
            {
                Main.flag = false;
                break;
            }
            try
            {
                Thread.sleep(50);
            }
            catch(Exception e){}           
            if(theta >= 355)
            {
                theta = 0.0;
            }
            else
                theta += 5;
        }
        
        redx = xnew;
        redy = ynew;
        
        g5.setColor(Color.RED);
            g5.fillOval(xnew-10,ynew-10,20,20);              

         DrawArc da=new DrawArc();
        
/*        if(Main.triangletype == 1)   
        {    
            DrawArc da=new DrawArc();
        }
        else if(Main.triangletype == 2)
        {
            DrawArcAndAngle daaa = new DrawArcAndAngle();
        }
        else if(Main.triangletype == 3)
        {
                
        }*/
        
    }    
    
}
