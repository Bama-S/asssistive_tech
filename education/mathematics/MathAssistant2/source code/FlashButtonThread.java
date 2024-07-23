//package javaapplication2;

import java.applet.*;
import java.awt.*;
import java.awt.event.*; 

public class FlashButtonThread implements Runnable
{    
    Button b0,b1,b2; 
    int i=-1;
    public FlashButtonThread(Button b0,Button b1,Button b2) 
    {
        this.b0=b0;
        this.b1=b1;        
        this.b2=b2;        
    }
    
    public void run()
    {
        while(true)
        {
            b0.setEnabled(false);
            b1.setEnabled(false);        
            b2.setEnabled(false);        
            i=(i+1)%3;
            if(i==0)
            b0.setEnabled(true);
            else if(i==1)
            b1.setEnabled(true);            
            else if(i==2)
            b2.setEnabled(true);            
            try
            {
                Thread.sleep(500);                
            }
            catch(Exception e){System.out.println(e);}
            if(Main.flag)
            {
	System.out.println(Main.flag);
                Main.flag = false;
                break;
            }
        }
        
        System.out.println("Hello");
        
            if(i==0)
            {}
            else if(i==1)
            {}
            else if(i==2)
            {}
        
    }
    
}
