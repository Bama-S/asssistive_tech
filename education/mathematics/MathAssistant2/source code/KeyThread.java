//package javaapplication2;

import java.applet.*;
import java.awt.*;
import java.awt.event.*; 

public class KeyThread implements Runnable
{    
    Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13; 
    int i=-1;
    public KeyThread(Button b0,Button b1,Button b2,Button b3,Button b4,Button b5,Button b6,Button b7,Button b8,Button b9,Button b10,Button b11,Button b12,Button b13) 
    {
        this.b0=b0;
        this.b1=b1;
        this.b2=b2;
        this.b3=b3;
        this.b4=b4;
        this.b5=b5;
        this.b6=b6;
        this.b7=b7;
        this.b8=b8;
        this.b9=b9;
        this.b10=b10;
        this.b11=b11;
        this.b12=b12;        
        this.b13=b13;        
    }
    
    public void run()
    {
        while(true)
        {
            b0.setEnabled(false);
            b1.setEnabled(false);
            b2.setEnabled(false);
            b3.setEnabled(false);
            b4.setEnabled(false);
            b5.setEnabled(false);
            b6.setEnabled(false);
            b7.setEnabled(false);
            b8.setEnabled(false);
            b9.setEnabled(false);
            b10.setEnabled(false);
            b11.setEnabled(false);
            b12.setEnabled(false);
            b13.setEnabled(false);
            i=(i+1)%14;
            if(i==0)
            b0.setEnabled(true);
            else if(i==1)
            b1.setEnabled(true);
            else if(i==2)
            b2.setEnabled(true);
            else if(i==3)
            b3.setEnabled(true);
            else if(i==4)
            b4.setEnabled(true);
            else if(i==5)
            b5.setEnabled(true);
            else if(i==6)
            b6.setEnabled(true);
            else if(i==7)
            b7.setEnabled(true);
            else if(i==8)
            b8.setEnabled(true);
            else if(i==9)
            b9.setEnabled(true);
            else if(i==10)
            b10.setEnabled(true);
            else if(i==11)
            b11.setEnabled(true);
            else if(i==12)
            b12.setEnabled(true);
            else if(i==13)
            b13.setEnabled(true);
            try
            {
                Thread.sleep(500);                
            }
            catch(Exception e){}
            if(Main.flag && i==0)
            {
               Main.flag=false;
               Main.ch='0';
            }
            else if(Main.flag && i==1)
            {
               Main.flag=false;
               Main.ch='1';
            }
            else if(Main.flag && i==2)
            {
               Main.flag=false;
               Main.ch='2';
            }
            else if(Main.flag && i==3)
            {
               Main.flag=false;
               Main.ch='3';
            }
            else if(Main.flag && i==4)
            {
               Main.flag=false;
               Main.ch='4';
            }
            else if(Main.flag && i==5)
            {
               Main.flag=false;
               Main.ch='5';
            }
            else if(Main.flag && i==6)
            {
               Main.flag=false;
               Main.ch='6';
            }
            else if(Main.flag && i==7)
            {
               Main.flag=false;
               Main.ch='7';
            }
            else if(Main.flag && i==8)
            {
               Main.flag=false;
               Main.ch='8';
            }
            else if(Main.flag && i==9)
            {
               Main.flag=false;
               Main.ch='9';
            }
            else if(Main.flag && i==10)
            {
               Main.flag=false;
               Main.ch='.';
            }
            else if(Main.flag && i==11)
            {
               Main.flag=false;
               Main.ch='-';               
            }
            else if(Main.flag && i==12)
            {
               Main.flag=false;
               Main.ch='\n';
               break;
            }
            else if(Main.flag && i==13)
            {
               Main.flag=false;
               Main.ch='\b';
            }
        }
    }
    
}
