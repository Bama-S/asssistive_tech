//package javaapplication2;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TrigonometryIcon implements Icon 
{
    int buttonStatus;
    public TrigonometryIcon(int buttonStatus) 
    {
        this.buttonStatus = buttonStatus;         
    }
    public int getButtonStatus()
    {
        return buttonStatus;
    }
    public void paintIcon(Component c,Graphics g,int x,int y)
    {
        Graphics2D g1 = (Graphics2D) g;
        Font f=new Font("Times New Roman",Font.BOLD,32);
        g1.setFont(f);
        if(buttonStatus == 1)
        {
            g1.drawString("0",x,y);
        }
        else if(buttonStatus == 2)
        {
            g1.setStroke(new BasicStroke(3));
            g1.drawLine(x+5,y-20,x-25,y+20);
            g1.drawString("1",x-30,y);
            g1.drawString("2",x,y+20);            
        }
        else if(buttonStatus == 3)
        {
            g1.setStroke(new BasicStroke(3));
            g1.drawString("1",x-40,y);
            g1.drawLine(x,y-20,x-30,y+20);
            g1.drawLine(x,y,x+20,y);
            g1.drawLine(x,y,x-5,y+20);
            g1.drawLine(x-5,y+20,x-10,y+10);
            g1.drawString("2",x+5,y+26);            
        }
        else if(buttonStatus == 4)
        {
            g1.setStroke(new BasicStroke(3));
            g1.drawLine(x+5,y-20,x-25,y+20);
            g1.drawString("3",x-30,y);
            g1.drawString("2",x,y+20);
            g1.drawLine(x-35,y-26,x-15,y-26);
            g1.drawLine(x-35,y-26,x-40,y-6);
            g1.drawLine(x-40,y-6,x-45,y-16);
            
        }
        else if(buttonStatus == 5)
        {
            g1.drawString("1",x,y);
        }
        else if(buttonStatus == 6)
        {
            g1.setStroke(new BasicStroke(3));
            g1.drawString("1",x-40,y);
            g1.drawLine(x,y-20,x-30,y+20);
            g1.drawLine(x,y,x+20,y);
            g1.drawLine(x,y,x-5,y+20);
            g1.drawLine(x-5,y+20,x-10,y+10);
            g1.drawString("3",x+5,y+26);
        }
        else if(buttonStatus == 7)
        {            
            g1.setStroke(new BasicStroke(3));
            g1.drawLine(x-6,y-26,x+14,y-26);
            g1.drawLine(x-6,y-26,x-11,y-6);
            g1.drawLine(x-11,y-6,x-16,y-16);
            g1.drawString("3",x,y);
        }
        else if(buttonStatus == 8)
        {
            g1.drawString("infinity",x-40,y);
        }
        else if(buttonStatus == 9)
        {
            g1.setStroke(new BasicStroke(3));
            g1.drawString("2",x-40,y);
            g1.drawLine(x,y-20,x-30,y+20);
            g1.drawLine(x,y,x+20,y);
            g1.drawLine(x,y,x-5,y+20);
            g1.drawLine(x-5,y+20,x-10,y+10);
            g1.drawString("3",x+5,y+26);
        }
        else if(buttonStatus == 10)
        {
            g1.setStroke(new BasicStroke(3));
            g1.drawLine(x-6,y-26,x+14,y-26);
            g1.drawLine(x-6,y-26,x-11,y-6);
            g1.drawLine(x-11,y-6,x-16,y-16);
            g1.drawString("2",x,y);
        }
        else if(buttonStatus == 11)
        {
            g1.drawString("2",x,y);
        }
        else if(buttonStatus == 12)
        {
            g1.drawString("-1",x,y);
        }
    }
    public int getIconWidth()
    {
        return 0;
    }
    public int getIconHeight()
    {
        return 0;
    }
    
}
