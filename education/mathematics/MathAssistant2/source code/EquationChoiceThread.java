//package javaapplication2;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class EquationChoiceThread extends EquationChoice implements Runnable
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
                    
                /*case 3:                                        
                    g2.drawString(s2,200,300);
                    g3.drawString(s3,200,400);        
                    break;*/
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
                Main.ec.setVisible(false);
                Main.grh.setVisible(true);
                Main.cnt.add(BorderLayout.CENTER,Main.grh);
                KeyBoard.Linst.setText("DRAW A STRAIGHT LINE");
                KeyBoard.Linst.setVisible(true);
                KeyBoard.lpan.setVisible(true);
                Main.cnt.add(BorderLayout.SOUTH,KeyBoard.Linst);
                Main.cnt.add(BorderLayout.WEST,KeyBoard.lpan);
            }
            else if(topic == 2)
            {                
                Main.ec.setVisible(false);
                Main.grh.setVisible(true);
                Main.cnt.add(BorderLayout.CENTER,Main.grh);                                                      
                KeyBoard.Linst.setText("DRAW A STRAIGHT LINE");
                KeyBoard.Linst.setVisible(true);
                KeyBoard.lpan.setVisible(true);
                Main.cnt.add(BorderLayout.SOUTH,KeyBoard.Linst);                    
                Main.cnt.add(BorderLayout.WEST,KeyBoard.lpan);                    
            }
            /*else if(topic == 3)
            {
                Main.ec.setVisible(false);
                Main.grh.setVisible(true);
                Main.cnt.add(BorderLayout.CENTER,Main.grh);                                                      
                KeyBoard.Linst.setVisible(true);
                KeyBoard.lpan.setVisible(true);
                Main.cnt.add(BorderLayout.SOUTH,KeyBoard.Linst);                    
                Main.cnt.add(BorderLayout.WEST,KeyBoard.lpan);                    
            } */          
        
    }
}
