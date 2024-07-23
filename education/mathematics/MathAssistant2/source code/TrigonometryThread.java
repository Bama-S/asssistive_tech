//package javaapplication2;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class TrigonometryThread extends TrigonometryChoice implements Runnable 
{     
    public void run()
    {       
        Graphics g2= g1.create();
        Graphics g3= g1.create();       
        Font f=new Font("ARIAL",Font.BOLD,30);
        g2.setFont(f);
        g3.setFont(f);
        g2.setColor(Color.BLUE);        
        g3.setColor(Color.RED);        
        while(true)
        {
            switch(topic)
            {
                case 1:                    
                    g3.drawString(s1,200,200);                    
                    g2.drawString(s2,200,300);        
                    break;
                    
                case 2:                         
                    g2.drawString(s1,200,200);
                    g3.drawString(s2,200,300);
                    break;
                    
                case 3:                                        
                    //g2.drawString(s2,200,300);
                    //g3.drawString(s3,200,400);        
                    break;                    
            }
            
            try{
                Thread.sleep(500);                
            }
            catch(Exception e)
            {}
            
            if(Main.flag)
            {  
                Main.flag=false;
                break;
            }            
            
            topic=(topic%2)+1;            
        }   
        
            if(topic == 1)
            {                
                Main.tcho.setVisible(false);
                Main.ang.setVisible(true);
                Main.cnt.add(BorderLayout.CENTER,Main.ang);
                KeyBoard.Linst.setVisible(true);
                Main.cnt.add(BorderLayout.SOUTH,KeyBoard.Linst);
                KeyBoard.Linst.setText("ARRANGE THE ANGLES IN ASCENDING ORDER");
            }
            else if(topic == 2)
            {                
                Main.tcho.setVisible(false);
                Main.trc.setVisible(true);
                Main.cnt.add(BorderLayout.CENTER,Main.trc);                
            }
            else if(topic == 3)
            {
                
            }           
        
    }
}
