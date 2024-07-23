//package javaapplication2;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Blank extends JPanel
{
    public Blank() 
    {
    }
    public void paint(Graphics g)
    {
        super.paintComponent(g);        
        Font f=new Font("ARIAL",Font.BOLD,30);
        g.setFont(f);
        g.setColor(Color.BLUE);        
        g.drawString("CHOOSE ANY OPTION FROM BELOW",400,100);
    }
    
}
