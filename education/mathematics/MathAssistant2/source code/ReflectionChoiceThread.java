//package javaapplication2;

import java.applet.*;
import java.awt.*;
import java.awt.event.*; 

public class ReflectionChoiceThread implements Runnable
{    
    Button b0,b1; 
    int i=-1;
    public ReflectionChoiceThread(Button b0,Button b1) 
    {
        this.b0=b0;
        this.b1=b1;        
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
                Main.flag = false;
                break;
            }
            
        }
        
        
        
            if(i==0)
              Reflection.practice=1;
            else if(i==1)            
               Reflection.practice=2;                           
               Main.rind.setVisible(false);
               Main.rc.setVisible(false);
               Main.grh.setVisible(true);
               KeyBoard.Linst.setText("DRAW A TRIANGLE");
               KeyBoard.Linst.setVisible(true);
               KeyBoard.lpan.setVisible(true);
               Main.cnt.add(BorderLayout.CENTER,Main.grh);               
               Main.cnt.add(BorderLayout.WEST,KeyBoard.lpan);                    
               Main.cnt.add(BorderLayout.SOUTH,KeyBoard.Linst);                    
        
    }
    
}
