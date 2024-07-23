//package javaapplication2;

import java.applet.*;
import java.awt.*;
import java.awt.event.*; 

public class FinalChoiceThread implements Runnable
{    
    Button b0,b1; 
    int i=-1;
    public FinalChoiceThread(Button b0,Button b1) 
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
                Main.clearAll();                
                Main.ind.setVisible(true);                
                Main.fc.setVisible(false);
                Main.blk.setVisible(false);                      
                Main.cnt.add(BorderLayout.CENTER,Main.ind); 
            }
            else if(i==1)
            {              
                if(Main.classid == 1)
                {
                Main.clearAll();                
                Main.grh.setVisible(true);                
                Main.fc.setVisible(false);
                Main.blk.setVisible(false);                      
                Main.cnt.add(BorderLayout.CENTER,Main.grh); 
                KeyBoard.Linst.setText("DRAW A STRAIGHT LINE");
                KeyBoard.Linst.setVisible(true);
                KeyBoard.lpan.setVisible(true);
                Main.cnt.add(BorderLayout.WEST,KeyBoard.lpan);                    
                Main.cnt.add(BorderLayout.SOUTH,KeyBoard.Linst);
                AnalyticalChoice.topic=1;
                EquationChoice.topic=1;
                }
                else if(Main.classid == 2)
                {
                Main.clearAll();                
                Main.grh.setVisible(true);                
                Main.fc.setVisible(false);
                Main.blk.setVisible(false);                      
                Main.cnt.add(BorderLayout.CENTER,Main.grh); 
                KeyBoard.Linst.setText("DRAW A STRAIGHT LINE");
                KeyBoard.Linst.setVisible(true);
                KeyBoard.lpan.setVisible(true);
                Main.cnt.add(BorderLayout.WEST,KeyBoard.lpan);                    
                Main.cnt.add(BorderLayout.SOUTH,KeyBoard.Linst);
                AnalyticalChoice.topic=1;
                EquationChoice.topic=2;
                }
                else if(Main.classid == 3)
                {
                Main.clearAll();                
                Main.grh.setVisible(true);                
                Main.fc.setVisible(false);
                Main.blk.setVisible(false);                      
                Main.cnt.add(BorderLayout.CENTER,Main.grh); 
                KeyBoard.Linst.setText("DRAW A STRAIGHT LINE");
                KeyBoard.Linst.setVisible(true);
                KeyBoard.lpan.setVisible(true);
                Main.cnt.add(BorderLayout.WEST,KeyBoard.lpan);                    
                Main.cnt.add(BorderLayout.SOUTH,KeyBoard.Linst);
                AnalyticalChoice.topic=2;
                }
                else if(Main.classid == 4)
                {
                Main.clearAll();                
                Main.grh.setVisible(true);                
                Main.fc.setVisible(false);
                Main.blk.setVisible(false);                      
                Main.cnt.add(BorderLayout.CENTER,Main.grh); 
                KeyBoard.Linst.setText("DRAW A TRIANGLE");
                KeyBoard.Linst.setVisible(true);
                KeyBoard.lpan.setVisible(true);
                Main.cnt.add(BorderLayout.WEST,KeyBoard.lpan);                    
                Main.cnt.add(BorderLayout.SOUTH,KeyBoard.Linst);
                AnalyticalChoice.topic=3;
                }
                else if(Main.classid == 5)
                {
                Main.clearAll();                
                Main.grh.setVisible(true);                
                Main.fc.setVisible(false);
                Main.blk.setVisible(false);                      
                Main.cnt.add(BorderLayout.CENTER,Main.grh); 
                KeyBoard.Linst.setText("DRAW A TRIANGLE");
                KeyBoard.Linst.setVisible(true);
                KeyBoard.lpan.setVisible(true);
                Main.cnt.add(BorderLayout.WEST,KeyBoard.lpan);                    
                Main.cnt.add(BorderLayout.SOUTH,KeyBoard.Linst);
                AnalyticalChoice.topic=4;
                }
                else if(Main.classid == 6)
                {
                Main.clearAll();                
                Main.ang.setVisible(true);                
                Main.fc.setVisible(false);
                Main.blk.setVisible(false);                      
                Main.cnt.add(BorderLayout.CENTER,Main.ang); 
                KeyBoard.Linst.setText("ARRANGE THE ANGLES IN ASCENDING ORDER");
                KeyBoard.Linst.setVisible(true);
                Main.cnt.add(BorderLayout.SOUTH,KeyBoard.Linst);
                }
                else if(Main.classid == 7)
                {
                Main.clearAll();                
                Main.tr.setVisible(true);                
                Main.fc.setVisible(false);
                Main.blk.setVisible(false);                      
                Main.cnt.add(BorderLayout.CENTER,Main.tr); 
//                KeyBoard.Linst.setText("ARRANGE THE ANGLES IN ASCENDING ORDER");
                KeyBoard.Linst.setVisible(true);
                Main.cnt.add(BorderLayout.SOUTH,KeyBoard.Linst);
                TrigonometryRatioLevelOne.restart();
                }
                else if(Main.classid == 8)
                {
                Main.clearAll();                
                Main.tr1.setVisible(true);                
                Main.fc.setVisible(false);
                Main.blk.setVisible(false);                      
                Main.cnt.add(BorderLayout.CENTER,Main.tr1); 
//                KeyBoard.Linst.setText("ARRANGE THE ANGLES IN ASCENDING ORDER");
                KeyBoard.Linst.setVisible(true);
                Main.cnt.add(BorderLayout.SOUTH,KeyBoard.Linst);
                }

            }
    }
    
}
