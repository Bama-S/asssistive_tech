//package javaapplication2;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class AnalyticalThread extends AnalyticalChoice implements Runnable 
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
                    g3.drawString(s4,200,200);                    
                    g2.drawString(s3,200,500);        
                    break;
                    
                case 2:                         
                    g2.drawString(s4,200,200);
                    g3.drawString(s1,200,300);
                    break;
                    
                case 3:                                        
                    g2.drawString(s1,200,300);
                    g3.drawString(s2,200,400);        
                    break;                    
                case 4:                                        
                    g2.drawString(s2,200,400);
                    g3.drawString(s3,200,500);        
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
            
            topic=(topic%4)+1;            
        }   
        
            if(topic == 1)
            {
                Main.acho.setVisible(false);
                Main.ec.setVisible(true);
                Main.cnt.add(BorderLayout.CENTER,Main.ec);
            }
            else if(topic == 2)
            {                
                Main.acho.setVisible(false);
                Main.grh.setVisible(true);
                Main.cnt.add(BorderLayout.CENTER,Main.grh);                                                      
                KeyBoard.Linst.setVisible(true);
                KeyBoard.lpan.setVisible(true);
                KeyBoard.Linst.setText("DRAW A STRAIGHT LINE");
                Main.cnt.add(BorderLayout.SOUTH,KeyBoard.Linst);                    
                Main.cnt.add(BorderLayout.WEST,KeyBoard.lpan);                    
            }
            else if(topic == 3)
            {                
                Main.acho.setVisible(false);
                Main.rc.setVisible(true);            
                Main.rind.setVisible(true);
                Main.cnt.add(BorderLayout.CENTER,Main.rind);
                Main.cnt.add(BorderLayout.SOUTH,Main.rc);                
                ReflectionChoice.restart();                     
            }
            else if(topic == 4)
            {
                Main.acho.setVisible(false);
                Main.grh.setVisible(true);
                Main.cnt.add(BorderLayout.CENTER,Main.grh);     
                KeyBoard.lpan.setVisible(true);
                KeyBoard.Linst.setVisible(true);
                Main.cnt.add(BorderLayout.SOUTH,KeyBoard.Linst);                    
                Main.cnt.add(BorderLayout.WEST,KeyBoard.lpan);                    
                KeyBoard.Linst.setText("DRAW A TRIANGLE");
            }           
        
    }
}
