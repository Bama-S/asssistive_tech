//package javaapplication2;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MarkIcon implements Icon 
{
    int color;
    public MarkIcon(int color) 
    {
        this.color = color;         
    }    
    public void paintIcon(Component c,Graphics g,int x,int y)
    {
        Graphics2D g1 = (Graphics2D) g;
        
        if(color == 0)
        {
            g1.setStroke(new BasicStroke(4));
            g1.setColor(Color.GREEN);
            g1.drawLine(x,y+50,x+25,y+75);
            g1.drawLine(x+25,y+75,x+75,y);
        }
        else if(color == 1)
        {
            g1.setStroke(new BasicStroke(4));
            g1.setColor(Color.RED);
            g1.drawLine(x,y,x+75,y+75);
            g1.drawLine(x+75,y,x,y+75);
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
