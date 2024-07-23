//package javaapplication2;

import java.awt.*;
import java.io.*;
import java.applet.*;
import javax.swing.*;

public class CircleThread extends DrawTriangle implements Runnable
{   
    public Graphics2D g2,g3;
    public int xc=0,yc=0;
    public static int midx,midy;
    public static int r,mylength;   
    public static int startx,starty;
    public static int endx,endy;
    public static int index;
    
    public static void restart(int a,int b,int c)
    {
        midx = a;
        midy = b;
        r = c;     
        Thread th=new Thread(new CircleThread());
        th.start();        
    }
    
    public CircleThread() 
    {}
    
    public CircleThread(int midx,int midy,int r) 
    {       
        this.midx = midx;
        this.midy = midy;
        this.r = r;     
    }
    
    public void putpixel(int x1,int y1,int graphics)
    {
        if(graphics == 1)
            g2.drawLine(x1,y1,x1,y1);        
        else
            g3.drawLine(x1,y1,x1,y1);        
    }
    
    public void plotpoints(int x,int y,int index,int graphics)
    {
        switch(index)
        {
            case 1:                
                endx = xc+x+midx;
                endy = midy-yc-y;
                putpixel(xc+x+midx,midy-yc-y,graphics);  //(n=1)
                break;
            case 2:
                endx = midx+xc+y;
                endy = midy-yc-x;
                putpixel(midx+xc+y,midy-yc-x,graphics);  //(n=2)
                break;
            case 3:                
                endx = midx+xc+y;
                endy = midy-yc+x;
                putpixel(midx+xc+y,midy-yc+x,graphics);  //(n=3)
                break;
            case 4:
                endx = xc+x+midx;
                endy = midy-yc+y;
                putpixel(xc+x+midx,midy-yc+y,graphics);  //(n=4)
                break;
            case 5:
                endx = xc-x+midx;
                endy = midy-yc+y;
                putpixel(xc-x+midx,midy-yc+y,graphics);  //(n=5)
                break;
            case 6:
                endx = midx+xc-y;
                endy = midy-yc+x;
                putpixel(midx+xc-y,midy-yc+x,graphics);  //(n=6)        
                break;
            case 7:
                endx = midx+xc-y;
                endy = midy-yc-x;
                putpixel(midx+xc-y,midy-yc-x,graphics);  //(n=7)
                break;
            case 8:
                endx = midx+xc-x;
                endy = midy-yc-y;
                putpixel(midx+xc-x,midy-yc-y,graphics);  //(n=8)
                break;
        }        
    }
    
    public void circlePoints(int index,int graphics)
    {  
       int p; 
       int x,y;    
       x = 0;
       y = r;
       p = 1-r;
       
       switch(index)
        {
            case 1:
                startx = xc+x+midx;
                starty = midy-yc-y;
                break;
            case 2:
                startx = midx+xc+y;
                starty = midy-yc-x;
                break;
            case 3:                
                startx = midx+xc+y;
                starty = midy-yc+x;
                break;
            case 4:
                startx = xc+x+midx;
                starty = midy-yc+y;
                break;
            case 5:
                startx = xc-x+midx;
                starty = midy-yc+y;
                break;
            case 6:
                startx = midx+xc-y;
                starty = midy-yc+x;
                break;
            case 7:
                startx = midx+xc-y;
                starty = midy-yc-x;
                break;
            case 8:
                startx = midx+xc-x;
                starty = midy-yc-y;
                break;
        }               
       
       while(x < y)
       {
           if(p < 0)
           {
               x++;
               p=p+(2*x)+1;
           }
           else
           {
               x++;
               y--;
               p=p+2*(x-y)+1;
           }
           plotpoints(x,y,index,graphics);
       }
    }
    
    public void run()
    {
       g2 = (Graphics2D) g1.create();
       g2.setStroke(new BasicStroke(2.0f));
       g2.setColor(Color.BLACK);      
       
       g3 = (Graphics2D) g1.create();
       g3.setStroke(new BasicStroke(2.0f));
       g3.setColor(Color.WHITE);       
      
       index = 1;
       while(true)
       {
           if(index == 1)
               circlePoints(8,2);
           else
               circlePoints(index - 1,2);
           
           circlePoints(index,1);
           
           try
           {
               Thread.sleep(500);
           }
           catch(Exception e)
           {}           
           
           if(Main.flag)
           {
            Main.flag = false;
            break;
           }
           
           if(index == 8)
               index = 1;
           else
               index = index + 1;
       }       
       
    }
    
}
