//package javaapplication2;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Xpositive extends Graph implements Runnable {          
        
    public void run()
    {        
        Graphics g2= g1.create();
        Graphics g3= g1.create();        
        Font f=new Font("ARIAL",Font.PLAIN,18);
        g2.setFont(f);
        g3.setFont(f);
        g2.setColor(Color.GREEN);
        g3.setColor(Color.DARK_GRAY);
        int n=0;
        int temp=11;
        for(int i=width/2-20;i<=width;i=i+rsize)
        {
            String str=String.valueOf(n);
            if(n==0)
            {
                g3.drawString(String.valueOf(temp),rend,height/2+20);
            }
            else
                g3.drawString(String.valueOf(temp),i-rsize,height/2+20);
            g2.drawString(str,i,height/2+20);
            try
            {
            Thread.sleep(500);            
            }
        catch(Exception e){}
            
            temp=n;
            if(n==11)
            {           
              i=width/2-20-rsize;
              n=0;              
            }
            else
            ++n;
            if(Main.flag)
            {
             Main.flag=false;             
             break;
             }
        }
        px=temp;
     if(axis==1||axis==2)
     {
       Thread th=new Thread(new Ypositive());
       th.start();
     }
     else if(axis==3||axis==4)
     {
       Thread th=new Thread(new Ynegative());
       th.start();
     }
    }

}
