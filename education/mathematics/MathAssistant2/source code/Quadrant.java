//package javaapplication2;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Quadrant extends Graph implements Runnable 
{  
      public void run()
      {       
        Graphics g2= g1.create();
        Graphics g3= g1.create();           
        g2.setColor(Color.GREEN);        
        g3.setColor(Color.BLACK);
        for(int x=width/2,y=0;x<=width&&y<=height;)
        {            
            g2.drawLine(x+1,y+1,x+width/2-1,y+1);
            g2.drawLine(x+1,y+1,x+1,y+height/2-1);
            g2.drawLine(x+width/2-1,y+1,x+width/2-1,y+height/2-1);
            g2.drawLine(x+1,y+height/2-1,x+width/2-1,y+height/2-1);
            g2.drawLine(x+2,y+2,x+width/2-2,y+2);
            g2.drawLine(x+2,y+2,x+2,y+height/2-2);
            g2.drawLine(x+width/2-2,y+2,x+width/2-2,y+height/2-2);
            g2.drawLine(x+2,y+height/2-2,x+width/2-2,y+height/2-2);
            g2.drawLine(x+3,y+3,x+width/2-3,y+3);
            g2.drawLine(x+3,y+3,x+3,y+height/2-3);
            g2.drawLine(x+width/2-3,y+3,x+width/2-3,y+height/2-3);
            g2.drawLine(x+3,y+height/2-3,x+width/2-3,y+height/2-3);
            if(axis==1)
            {               
                    x=0;
                    y=0;               
                    g3.drawLine(width/2+1,height/2+1,width-1,height/2+1);
                    g3.drawLine(width/2+1,height/2+1,width/2+1,height-1);
                    g3.drawLine(width/2+1,height-1,width-1,height-1);
                    g3.drawLine(width-1,height/2+1,width-1,height-1);
                    g3.drawLine(width/2+2,height/2+2,width-2,height/2+2);
                    g3.drawLine(width/2+2,height/2+2,width/2+2,height-2);
                    g3.drawLine(width/2+2,height-2,width-2,height-2);
                    g3.drawLine(width-2,height/2+2,width-2,height-2);
                    g3.drawLine(width/2+3,height/2+3,width-3,height/2+3);
                    g3.drawLine(width/2+3,height/2+3,width/2+3,height-3);
                    g3.drawLine(width/2+3,height-3,width-3,height-3);
                    g3.drawLine(width-3,height/2+3,width-3,height-3);                         
                    
               }
                else if(axis==2)
                {
                    x=0;
                    y=height/2;                    
                    g3.drawLine(width/2+1,1,width-1,1);
                    g3.drawLine(width/2+1,1,width/2+1,height/2-1);
                    g3.drawLine(width/2+1,height/2-1,width-1,height/2-1);
                    g3.drawLine(width-1,1,width-1,height/2-1);
                    g3.drawLine(width/2+2,2,width-2,2);
                    g3.drawLine(width/2+2,2,width/2+2,height/2-2);
                    g3.drawLine(width/2+2,height/2-2,width-2,height/2-2);
                    g3.drawLine(width-2,2,width-2,height/2-2);
                    g3.drawLine(width/2+3,3,width-3,3);
                    g3.drawLine(width/2+3,3,width/2+3,height/2-3);
                    g3.drawLine(width/2+3,height/2-3,width-3,height/2-3);
                    g3.drawLine(width-3,3,width-3,height/2-3);
                  }
                else if(axis==3)
                 {                    
                    x=width/2;
                    y=height/2;                    
                    g3.drawLine(1,1,width/2-1,1);
                    g3.drawLine(1,1,1,height/2-1);
                    g3.drawLine(width/2-1,1,width/2-1,height/2-1);
                    g3.drawLine(1,height/2-1,width/2-1,height/2-1);
                    g3.drawLine(2,2,width/2-2,2);
                    g3.drawLine(2,2,2,height/2-2);
                    g3.drawLine(width/2-2,2,width/2-2,height/2-2);
                    g3.drawLine(2,height/2-2,width/2-2,height/2-2);
                    g3.drawLine(3,3,width/2-3,3);
                    g3.drawLine(3,3,3,height/2-3);
                    g3.drawLine(width/2-3,3,width/2-3,height/2-3);
                    g3.drawLine(3,height/2-3,width/2-3,height/2-3);                    
                    
	}

	else if(axis==4)
	{
                    g3.drawLine(1,height/2+1,width/2-1,height/2+1);
                    g3.drawLine(1,height/2+1,1,height-1);
                    g3.drawLine(width/2-1,height/2+1,width/2-1,height-1);
                    g3.drawLine(1,height-1,width/2-1,height-1);
                    g3.drawLine(2,height/2+2,width/2-2,height/2+2);
                    g3.drawLine(2,height/2+2,2,height-2);
                    g3.drawLine(width/2-2,height/2+2,width/2-2,height-2);
                    g3.drawLine(2,height-2,width/2-2,height-2);
                    g3.drawLine(3,height/2+3,width/2-3,height/2+3);
                    g3.drawLine(3,height/2+3,3,height-3);
                    g3.drawLine(width/2-3,height/2+3,width/2-3,height-3);
                    g3.drawLine(3,height-3,width/2-3,height-3);
                    x=width/2;
                    y=0;	
              }
            
            try{
            Thread.sleep(500);            
            }
            catch(Exception e){}        
           
	if(Main.flag)
        {
          Main.flag=false;
          break;
	}
	   axis=(axis%4)+1;            
        }
         if(axis==1)
	{            
	Thread th=new Thread(new Xpositive());
        th.start();
	}
         else if(axis==2)
	{
	Thread th=new Thread(new Xnegative());
                  th.start();
	}
         else if(axis==3)
	{
	Thread th=new Thread(new Xnegative());
                  th.start();
	}
        else if(axis==4)
	{
	Thread th=new Thread(new Xpositive());
                  th.start();
	}
    }
    
}
