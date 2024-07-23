//package javaapplication2;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.Math.*; 

public class Translation extends Graph
{    
    public static int tindex;    
    public static int[] x=new int[3];
    public static int[] y=new int[3];
    public static int[] xpt=new int[3];
    public static int[] ypt=new int[3]; 
    public static int[] tx=new int[3];
    public static int[] ty=new int[3];
    public static int[] txpt=new int[3];
    public static int[] typt=new int[3];     
    public static boolean TranslationFirst = true;
    public int xArray[]={-11,-10,-9,-8,-7,-6,-5,-4,-3,-2,-1,0,1,2,3,4,5,6,7,8,9,10,11,12};
    public int yArray[]={-5,-4,-3,-2,-1,0,1,2,3,4,5,6};
    public static int ptx,pty;
    
    public static void clearTranslation()
    {
        tindex = 0;
        x = new int[3];
        y = new int[3];
        xpt = new int[3];
        ypt = new int[3];
        tx = new int[3];
        ty = new int[3]; 
        txpt = new int[3];
        typt = new int[3];
        TranslationFirst = true;
        ptx = 0;
        pty = 0;        
    }
    
    public Translation() 
   {
        Main.classid = 5;    
        Graphics g2 = g1.create();    
        
        if(TranslationFirst)
        {        
        tx[tindex]=px;
        ty[tindex]=py;
        xpt[tindex]=t3;
        ypt[tindex++]=t4;
        if(tindex<3)    
        Graph.restart();
        else
        {
        g2.drawLine(xpt[0],ypt[0],xpt[1],ypt[1]);
        g2.drawLine(xpt[1],ypt[1],xpt[2],ypt[2]);
        g2.drawLine(xpt[2],ypt[2],xpt[0],ypt[0]);        
        
        if((ty[2]-ty[1]==0 && ty[0]-ty[1]==0)||(tx[2]-tx[1]==0 && tx[0]-tx[1]==0)) // collinear checking
        {            
            KeyBoard.Linst.setText("INVALID POINTS OF A TRIANGLE");
        }
        else
        {
         float check1 = ty[0]-ty[1];
         float check2 = ty[2]-ty[1];
         float check3 = tx[0]-tx[1]; 
         float check4 = tx[2]-tx[1];
         //System.out.println(check1+"  "+check2+"  "+check3+"  "+check4);
            if(check1/check2 == check3/check4)
            {    
            KeyBoard.Linst.setText("THESE POINTS ARE COLLINEAR");
            }
            else
            {
            TranslationFirst = false;        
            tindex = 0;
        while(true)
        {
            boolean test = true;
            double d1=Math.random()*24;
            int rand1 = (int)d1;
            double d2=Math.random()*12;
            int rand2 = (int)d2;
            ptx = xArray[rand1];
            pty = yArray[rand2];
            for(int i=0;i<3;i++)
            {
                int a=tx[i]+ptx;
                int b=ty[i]+pty;
                if( a>11 || a<-11 || b>5 || b<-5)
                {
                    test=false;
                    break;
                }    
            }
            if(test)
                break;
        }
        
        KeyBoard.Linst.setText("TRANSLATE THE TRIANGLE BY ("+ptx+","+pty+")");
        Graph.restart();
        }  
        }
        }
        }
        
        else if(!TranslationFirst)
        {            
            x[tindex]=px;
            y[tindex]=py;       
            xpt[tindex]=t3;
            ypt[tindex++]=t4;
            
            if(tindex<3)
            Graph.restart();
        else
        {
           g2.drawLine(xpt[0],ypt[0],xpt[1],ypt[1]);
           g2.drawLine(xpt[1],ypt[1],xpt[2],ypt[2]);
           g2.drawLine(xpt[2],ypt[2],xpt[0],ypt[0]);        
           if((y[2]-y[1]==0 && y[0]-y[1]==0)||(x[2]-x[1]==0 && x[0]-x[1]==0)) // collinear checking
           {            
            KeyBoard.Linst.setText("INVALID POINTS OF A TRIANGLE");
           }
        else
        {
         float check1 = y[0]-y[1];
         float check2 = y[2]-y[1];
         float check3 = x[0]-x[1]; 
         float check4 = x[2]-x[1];
         //System.out.println(check1+"  "+check2+"  "+check3+"  "+check4);
            if(check1/check2 == check3/check4)
            {    
            KeyBoard.Linst.setText("THESE POINTS ARE COLLINEAR");
            }
            else
            {
        
           
           boolean f= false;
           for(int i=0;i<3;i++)
           {
                txpt[i] = tx[i] + ptx;
                typt[i] = ty[i] + pty;
                
           }
           Lp1: for(int i=0;i<3;i++)
            {               
               Lp2: for(int j=0;j<3;j++)
                {    
                  if((txpt[i]==x[j])&&(typt[i]==y[j]))
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
    }    
    
}
