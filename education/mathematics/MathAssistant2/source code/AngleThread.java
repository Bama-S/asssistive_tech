//package javaapplication2;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class AngleThread extends Angle implements Runnable 
{
    public static int x=50,y=80;
    public int xnew,ynew;
    public static int index = 1;
    public static int Oval;    
    public static boolean[] ResultOval = {true,true,true,true};
    public static double[] ResultAngle = new double[4];
    
    public static void clearAngleThread()
    {
        x = 50;
        y = 80;
        index = 1;
        Oval = 0;
        ResultOval[0]=true;
        ResultOval[1]=true;
        ResultOval[2]=true;
        ResultOval[3]=true;
        ResultAngle[0]=0.0;
        ResultAngle[1]=0.0;
        ResultAngle[2]=0.0;
        ResultAngle[3]=0.0;
    }
    
    public void rotate(int x,int y,int xr,int yr,double theta)
    {
        theta = Math.toRadians(theta);
        int a = (int) ((x - xr) * Math.cos(theta) - (y - yr) * Math.sin(theta));
        int b = (int) ((x - xr) * Math.sin(theta) - (y - yr) * Math.cos(theta));
        xnew = xr + a;
        ynew = yr + b;
    }
    
    public void run()
    {
        Graphics g2= g1.create();
        Graphics g3= g1.create();
        Graphics g4= g1.create();
        Graphics g5= g1.create();      
        Graphics g6= g1.create();
        g2.setColor(Color.ORANGE);
        g3.setColor(Color.PINK);
        g5.setColor(Color.cyan);
        g6.setXORMode(Color.BLACK);
        
        while(true)
        {
            int x1=0,y1=0,x2=0,y2=0;
            
            if(Oval == 0)
            { 
                x1 = x + 75;
                x2 = x + 175;
                y1 = 200;
                y2 = 200;
                g2.fillOval(x,y,200,150);                
                g4.drawLine(x1,y1,x2,y2);
                rotate(x2,y2,x1,y1,angle[Oval]);
                g4.drawLine(x1,y1,xnew,ynew);
                g3.fillOval(x+900,y,200,150);                                
                x1 = x1 + 900;
                x2 = x2 + 900;
                g4.drawLine(x1,y1,x2,y2);
                rotate(x2,y2,x1,y1,angle[Oval+3]);
                g4.drawLine(x1,y1,xnew,ynew);
            }
            else
            {
                x1 = x + 75;
                x2 = x + 175;
                y1 = 200;
                y2 = 200;
                g2.fillOval(x,y,200,150);                
                g4.drawLine(x1,y1,x2,y2);
                rotate(x2,y2,x1,y1,angle[Oval]);
                g4.drawLine(x1,y1,xnew,ynew);
                g3.fillOval(x-300,y,200,150);                
                x1 = x1 - 300;
                x2 = x2 - 300;
                g4.drawLine(x1,y1,x2,y2);
                rotate(x2,y2,x1,y1,angle[Oval-1]);
                g4.drawLine(x1,y1,xnew,ynew);
            }
            
            try
            {
                Thread.sleep(1000);                
            }
            catch(Exception e){}
            
            if(Main.flag)
            {
                Main.flag = false;
                index++;
                break;
            }
            
            Oval = (Oval+1) % 4;                 
            x = 50 + Oval*300;
           
        }
        
        for(int i=0;i<4;i++)
        {
            int x1=0,x2=0,y1=0,y2=0;
            if(ResultOval[i])
            {
                ResultOval[i] = false;
                x = 50 + i * 300;
                y = 380;
                x1 = x + 75;
                x2 = x + 175;
                y1 = 500;
                y2 = 500;
                g5.fillOval(x,y,200,150);
                g4.drawLine(x1,y1,x2,y2);
                rotate(x2,y2,x1,y1,angle[Oval]);
                g4.drawLine(x1,y1,xnew,ynew);
                ResultAngle[i] = -angle[Oval];
                break;
            }
        }        
        
        Oval = (Oval+1) % 4;                 
            x = 50 + Oval*300;
            y = 80;
        
        if(index < 5)
            Angle.restart();
        else if(index == 5)    
        {
            if(ResultAngle[0]<ResultAngle[1] && ResultAngle[1]<ResultAngle[2] && ResultAngle[2]<ResultAngle[3])
                KeyBoard.Linst.setText("CORRECT ANSWER");
            else
                KeyBoard.Linst.setText("WRONG ANSWER");            
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
            Main.ang.setVisible(false);            
            Main.cnt.add(BorderLayout.SOUTH,Main.fc);
            Main.cnt.add(BorderLayout.CENTER,Main.blk);            
            FinalChoice.restart();
            break;
            }
            }
        }       
         
    }
    
}
