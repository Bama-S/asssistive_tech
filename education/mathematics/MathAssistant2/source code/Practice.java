//package javaapplication2;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Practice extends JPanel
{
    public Practice() 
    {
    }
    public void paint(Graphics g)
    {
        super.paintComponent(g);        
        Font f=new Font("ARIAL",Font.BOLD,36);
        g.setFont(f);
        g.setColor(Color.MAGENTA);        
        g.drawString("WELCOME TO PRACTICE PAGE",400,100);
        Font f1=new Font("ARIAL",Font.BOLD,30);
        g.setFont(f1);
        g.setColor(Color.BLUE);        
        g.drawString("CHOOSE A TOPIC TO PRACTISE",400,500);
         
    }
    
}
