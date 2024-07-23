//package javaapplication2;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class InterceptEquation extends Graph
{  
    public static int index,i1,i2,i3,i4;
    public static float slope,xintercept,yinter,yintercept,xinter;    
    public static boolean xInterceptFlag = true;
    public static boolean yInterceptFlag = false;
    public static int[] x=new int[2];
    public static int[] y=new int[2];
    public static int[] xpt=new int[2];
    public static int[] ypt=new int[2];    
    
    public static void clearInterceptEquation()
    {
        index = 0;
        i1 = 0;
        i2 = 0;
        i3 = 0;
        i4 = 0;
        slope = 0.0f;
        xintercept = 0.0f;
        yinter = 0.0f;
        yintercept = 0.0f;
        xinter = 0.0f;
        xInterceptFlag = true;
        yInterceptFlag = false;
        x = new int[2];
        y = new int[2];
        xpt = new int[2];
        ypt = new int[2];
    }
    
    public InterceptEquation() 
    {   
        Main.classid = 2;
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
            
            if(xInterceptFlag)
            {
                xInterceptFlag = false;                
            KeyBoard.Linst.setText("ENTER THE X-INTERCEPT");
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
            xintercept=Float.parseFloat(KeyBoard.tf.getText());
            float numerator = (float) y[1]-y[0];
            float denominator = (float) x[1]-x[0];
            float slope= numerator/denominator;
            i1=(int)xintercept*100;
            yInterceptFlag = true;
            Main.ch = '\0';
            KeyBoard.tf.setText("");                    
            }
            if(yInterceptFlag)
            {
                yInterceptFlag = false;
            KeyBoard.Linst.setText("ENTER THE Y-INTERCEPT");
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
            yintercept = Float.parseFloat(KeyBoard.tf.getText());                
            yinter = y[0]-slope*x[0];
            xinter = -slope * yinter;
            i2 = (int) xinter * 100;
            i3 = (int) yintercept * 100;
            i4 = (int) yinter * 100;
//            System.out. println(i1+" "+i2+" "+i3+" "+i4);
            if(i1==i2 && i3==i4)            
                KeyBoard.Linst.setText("YOUR ANSWER IS : (x/"+xintercept+") + (y/"+yintercept+") = 1. IT IS CORRECT");
            else
                KeyBoard.Linst.setText("WRONG ANSWER. CORRECT ANSWER IS : (x/"+xinter+") + (y/"+yinter+") = 1");

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