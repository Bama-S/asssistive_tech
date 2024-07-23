//package javaapplication2;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class HorizontalMove extends DrawTriangle implements Runnable 
{  
      //public static int bluex;
      public void run()
      {       
        Graphics2D g2= (Graphics2D) g1.create();
        Graphics2D g3= (Graphics2D) g1.create();            
        
        g2.setStroke(new BasicStroke(5.0f));
        g3.setStroke(new BasicStroke(5.0f));
        
        g2.setColor(Color.BLACK);        
        g3.setColor(Color.WHITE);
        
        for(int y=0;bluex<=width&&y<=height;)
        {           
            if(bluex==0)
                g3.drawLine(width,0,width,height);
            else
                g3.drawLine(bluex-5,y,bluex-5,height);
            
            g2.drawLine(bluex,y,bluex,height);
            
            try{
            Thread.sleep(100);            
            }
            catch(Exception e){}        
           
	if(Main.flag)
        {
          Main.flag=false;
          break;
	}
	 if(bluex >= width-20)
             bluex=0;
         else
             bluex+=5;
        }
        
        Thread th=new Thread(new VerticalMove());
        th.start();
        
    }
    
}
