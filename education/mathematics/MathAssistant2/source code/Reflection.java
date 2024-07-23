//package javaapplication2;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Reflection extends Graph
{
    public static int index;
    public static int practice;
    public static int[] x=new int[3];
    public static int[] y=new int[3];
    public static int[] xpt=new int[3];
    public static int[] ypt=new int[3]; 
    public static int[] rx=new int[3];
    public static int[] ry=new int[3];
    public static int[] rxpt=new int[3];
    public static int[] rypt=new int[3];     
    public static boolean ReflectionFirst = true;
    

    public static void clearReflection()
    {
        index = 0;
        //practice = 0;
        x = new int[3];
        y = new int[3];
        xpt = new int[3];
        ypt = new int[3];
        rx = new int[3];
        ry = new int[3];
        rxpt = new int[3];
        rypt = new int[3];
        ReflectionFirst = true;        
    }   
    
    public Reflection() 
    {          
        Main.classid = 4;
        Graphics g2 = g1.create();            
        if(ReflectionFirst)
        {        
        rx[index]=px;
        ry[index]=py;       
        xpt[index]=t3;
        ypt[index++]=t4;        
        if(index<3)        
        Graph.restart(); 
        else
        {            
        g2.drawLine(xpt[0],ypt[0],xpt[1],ypt[1]);
        g2.drawLine(xpt[1],ypt[1],xpt[2],ypt[2]);
        g2.drawLine(xpt[2],ypt[2],xpt[0],ypt[0]);        
        ReflectionFirst = false;
        index = 0;
        if(practice == 1)
            KeyBoard.Linst.setText("REFLECT THE TRIANGLE WITH RESPECT TO X-AXIS");
        if(practice == 2)
            KeyBoard.Linst.setText("REFLECT THE TRIANGLE WITH RESPECT TO Y-AXIS");        
          Graph.restart();
        }
        }       
        else if(!ReflectionFirst)
        {            
            x[index]=px;
            y[index]=py;       
            xpt[index]=t3;
            ypt[index++]=t4;
            
            if(index<3)
            Graph.restart();
        else
        {
           g2.drawLine(xpt[0],ypt[0],xpt[1],ypt[1]);
           g2.drawLine(xpt[1],ypt[1],xpt[2],ypt[2]);
           g2.drawLine(xpt[2],ypt[2],xpt[0],ypt[0]);        
        
        boolean f= false;
        if(practice == 1)
        {           
            for(int i=0;i<3;i++)
            {
                rxpt[i]=rx[i];
                rypt[i]=-ry[i];
            }
        }
        else if(practice == 2)
        {
        
            for(int i=0;i<3;i++)
            {
                rxpt[i]=-rx[i];
                rypt[i]=ry[i];
            }    
        }
           Lp1: for(int i=0;i<3;i++)
            {               
               Lp2: for(int j=0;j<3;j++)
                {    
                  if((rxpt[i]==x[j])&&(rypt[i]==y[j]))
                  {
                      f=true;
                    break Lp2;                    
                  }
                  else   
                  {
                      f=false;
                      if(j==2)
                          break Lp1;
                      continue;
                  }
                }  
            }    
            if(f)
            {
                KeyBoard.Linst.setText("CORRECT ANSWER");                             
            }    
            else
            {
                KeyBoard.Linst.setText("WRONG ANSWER"); 
            }

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
