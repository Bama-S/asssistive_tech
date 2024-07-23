//package javaapplication2;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class SlopeInterceptEquation extends Graph
{  
    public static int index,i1,i2,i3,i4;
    public static float slope,ft,constant,cnst;    
    public static boolean slopeFlag = true;
    public static boolean constantFlag = false;
    public static int[] x=new int[2];
    public static int[] y=new int[2];
    public static int[] xpt=new int[2];
    public static int[] ypt=new int[2];
    
    public static void clearSlopeInterceptEquation()
    {
        i1 = 0;
        i2 = 0;
        i3 = 0;
        i4 = 0;
        index = 0; 
        slope = 0.0f;
        ft = 0.0f;
        constant = 0.0f;
        cnst = 0.0f;
        slopeFlag = true;
        constantFlag = false;
        x = new int[2];
        y = new int [2];
        xpt = new int[2];
        ypt = new int[2];
    }
    
    public SlopeInterceptEquation() 
    {   
        Main.classid = 1;
        Main.currentTopic = 1;
        Graphics g2=g1.create();
        x[index]=px;
        y[index]=py;               
        xpt[index]=t3;
        ypt[index++]=t4;
        if(index<2)
        Graph.restart();
        
       if(index>1)
       {
            g2.drawLine(xpt[0],ypt[0],xpt[1],ypt[1]);
            StringBuffer sb=new StringBuffer();
            StringBuffer sb1=new StringBuffer();
            
            if(slopeFlag)
            {
                slopeFlag = false;                
            KeyBoard.Linst.setText("ENTER THE SLOPE");
            KeyBoard.tf.setText(null);
            Main.ch = '\0';
            KeyBoard.keyStart();            
        
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
            ft=Float.parseFloat(KeyBoard.tf.getText());
            float numerator = (float) y[1]-y[0];
            float denominator = (float) x[1]-x[0];
            slope= numerator/denominator;
            i1=(int)ft*100;
            i2=(int)slope*100;
            constantFlag = true;
            Main.ch = '\0';
            KeyBoard.tf.setText("");
            }
            if(constantFlag)
            {
                constantFlag = false;
            KeyBoard.Linst.setText("ENTER THE VALUE OF 'C'");
            KeyBoard.keyStart();
            sb1=new StringBuffer();
            while(Main.ch!='\n')
            {
                if(Main.ch!='\0')
                { 
                    if(Main.ch=='\b')
                      sb1=new StringBuffer();
                    else                    
                sb1.append(Main.ch);     
                Main.ch='\0';
                KeyBoard.tf.setText(sb1.toString());
                }
            }
            try{
            KeyBoard.thread.join();                        
            }
            catch(Exception e){}
            cnst = Float.parseFloat(KeyBoard.tf.getText());
                KeyBoard.Linst.setText("YOUR ANSWER IS : y = "+ft+" x + "+cnst);
            constant = y[0]-slope*x[0];
            i3 = (int) cnst * 100;
            i4 = (int) constant*100;
            if(i1==i2 && i3==i4)
                KeyBoard.Linst.setText("YOUR ANSWER IS : y = "+ft+" x + "+cnst+". IT IS CORRECT");
            else
                KeyBoard.Linst.setText("WRONG ANSWER. CORRECT ANSWER IS : y = "+slope+" x + "+constant);

             try
            {
                Thread.sleep(4000);
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