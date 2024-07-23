//package javaapplication2;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Slope extends Graph
{  
    public static int index;
    public static int[] x=new int[2];
    public static int[] y=new int[2];
    public static int[] xpt=new int[2];
    public static int[] ypt=new int[2];
    
    public static void clearSlope()
    {
        index = 0;
        x = new int[2];
        y = new int[2];
        xpt = new int[2];
        ypt = new int[2];
    }
    
    public Slope() 
    {   
        Main.classid = 3;
        Graphics g2=g1.create();
        x[index]=px;
        y[index]=py;               
        xpt[index]=t3;
        ypt[index++]=t4;
        if(index<2)
        Graph.restart();
        
       if(index>1)
       {
            if(x[0]==x[1] && y[0]==y[1])
            {
                index = 0;
                KeyBoard.Linst.setText("INVALID POINTS OF A LINE. CLICK ONCE TO TRY AGAIN");            
                while(true)
                {
                  if(Main.flag) 
                  {
                      Main.flag = false; 
                      break;                      
                  }                  
                }
             index = 0;
             
             Graph.restart();
            }
            else
            {
            g2.drawLine(xpt[0],ypt[0],xpt[1],ypt[1]);
            KeyBoard.Linst.setText("ENTER THE SLOPE");
            KeyBoard.tf.setText(null);
            Main.ch = '\0';
            KeyBoard.keyStart();            
            StringBuffer sb=new StringBuffer();
            while(Main.ch!='\n')
            {
                if(Main.ch!='\0')
                { 
                    if(Main.ch=='\b')
                      sb=new StringBuffer();
                    else                    
                sb.append(Main.ch);     
                Main.ch='\0';
                KeyBoard.tf.setText(sb.toString());
                }
            }            
            try{
            KeyBoard.thread.join();                        
            }
            catch(Exception e){}
            float ft=Float.parseFloat(KeyBoard.tf.getText());
            float numerator = (float) y[1]-y[0];
            float denominator = (float) x[1]-x[0];
            float slope= numerator/denominator;
            int i1=(int)ft*100;
            int i2=(int)slope*100;
            if(i1==i2)
                KeyBoard.Linst.setText("CORRECT ANSWER");
            else
                KeyBoard.Linst.setText("WRONG ANSWER. THE ANSWER IS "+slope);      

             try
            {
                Thread.sleep(2000);
            }
            catch(Exception e)
            {}
            KeyBoard.Linst.setText("CLICK ONCE TO TRY AGAIN");
            
            while(true)
            {
            if(Main.flag)
            {            
            Main.flag = false;
            Main.fc.setVisible(true);
            Main.cm.setVisible(true);
            KeyBoard.Linst.setVisible(false);
            Main.grh.setVisible(false);            
            KeyBoard.lpan.setVisible(false);
            Main.cnt.add(BorderLayout.SOUTH,Main.fc);
            Main.cnt.add(BorderLayout.CENTER,Main.blk);            
            FinalChoice.restart();
            break;
            }
            }

            }
    }
}
}