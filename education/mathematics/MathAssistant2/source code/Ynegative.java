//package javaapplication2;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Ynegative extends Graph implements Runnable
{        
    public void run()
    {       
        Graphics g2= g1.create();
        Graphics g3= g1.create();
        Graphics g4= g1.create();
        Font f=new Font("ARIAL",Font.PLAIN,18);
        g2.setFont(f);
        g3.setFont(f);
        g2.setColor(Color.GREEN);
        g3.setColor(Color.DARK_GRAY);
        g4.setColor(Color.BLACK);
        int n=0;
        int temp=-5;
        
        for(int i=height/2+20;i>=0;i=i+bsize)
        {
            String str=String.valueOf(n);
            if(n==0)
            {
                g3.drawString(String.valueOf(temp),width/2-25,bend-bsize);
            }
            else if(n==-1)
                g3.drawString(String.valueOf(temp),width/2-20,i-bsize);
            else
                g3.drawString(String.valueOf(temp),width/2-25,i-bsize);
            
            if(n==0)
            g2.drawString(str,width/2-20,i);          
            else
            g2.drawString(str,width/2-25,i);          
            try
            {
            Thread.sleep(500);            
            }
            catch(Exception e){}            
            temp=n;
            if(Main.flag)
            {
            Main.flag=false;
            py=temp;
            break;
            }
            if(n==-5)
            {           
              i=height/2+20-bsize;
              n=0;              
            }
            else
            --n;	
        }
         if(axis==3)
        {
            int t1,t2;
            t1=t3=px;
            t2=t4=py;            
            t3=width/2+px*lsize;
            t4=height/2-py*bsize;
            g4.fillOval(t3-7,t4-7,14,14);
            g3.drawString(String.valueOf(t1),(width/2-20)+t1*lsize,height/2+20);
            if(t2==0)
                g3.drawString(String.valueOf(t2),width/2-20,(height/2+20)-t2*bsize);
            else
            g3.drawString(String.valueOf(t2),width/2-25,(height/2+20)-t2*bsize);
        }
        else if(axis==4)
        {
            int t1,t2;
            t1=t3=px;
            t2=t4=py;            
            t3=width/2+px*rsize;
            t4=height/2-py*bsize;
            g4.fillOval(t3-7,t4-7,14,14);           
            g3.drawString(String.valueOf(t1),(width/2-20)+t1*rsize,height/2+20);
            if(t2==0)
                g3.drawString(String.valueOf(t2),width/2-20,(height/2+20)-t2*bsize);
            else
            g3.drawString(String.valueOf(t2),width/2-25,(height/2+20)-t2*bsize);
        }                
        
        if(AnalyticalChoice.topic == 1)    
        {
            if(EquationChoice.topic == 1)
            {
                SlopeInterceptEquation spe=new SlopeInterceptEquation();   
            }
            else if(EquationChoice.topic == 2)
            {
                InterceptEquation spe=new InterceptEquation();   
            }
        }
        else if(AnalyticalChoice.topic == 2)
        {
            Slope s=new Slope();
        }        
        else if(AnalyticalChoice.topic == 3)
        {
            Reflection r=new Reflection();   
        }        
        else if(AnalyticalChoice.topic == 4)
        {
            Translation t=new Translation();
        }
        
        
    }
}
