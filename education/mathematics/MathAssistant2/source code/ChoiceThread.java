//package javaapplication2;

import java.applet.*;
import java.awt.*;
import java.awt.event.*; 

public class ChoiceThread implements Runnable
{    
    Button b0,b1; 
    int i=-1;
    public ChoiceThread(Button b0,Button b1) 
    {
        this.b0=b0;
        this.b1=b1;
        Thread th=new Thread(this);
        th.start();        
    }
    
    public void run()
    {
        while(true)
        {
            b0.setEnabled(false);
            b1.setEnabled(false);        
            i=(i+1)%2;
            if(i==0)
            b0.setEnabled(true);
            else if(i==1)
            b1.setEnabled(true);            
            try
            {
                Thread.sleep(500);                
            }
            catch(Exception e){}
            if(Main.flag)
            {
                Main.flag=false;
                break;
            }
            
        }
        
        if(i==0)
            {             
               Main.practice.setVisible(false);               
               Main.cho.setVisible(false);                             
               Main.acho.setVisible(true);
               Main.cnt.add(BorderLayout.CENTER,Main.acho);
               //KeyBoard.Linst.setVisible(true);
               //Main.cnt.add(BorderLayout.SOUTH,KeyBoard.Linst);                    
               //Main.cnt.add(BorderLayout.WEST,KeyBoard.lpan);                    
            }
            else if(i==1)
            {             
               Main.practice.setVisible(false);
               Main.cho.setVisible(false);
               //KeyBoard.Linst.setVisible(true);
               Main.tcho.setVisible(true);
               Main.cnt.add(BorderLayout.CENTER,Main.tcho);               
               //Main.cnt.add(BorderLayout.SOUTH,KeyBoard.Linst);                    
               
             
            }
    }
    
}
