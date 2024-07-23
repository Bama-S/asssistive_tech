//package javaapplication2;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ReflectionIndex extends JPanel
{         
       
    public void paint(Graphics g)
    {  
    	super.paintComponent(g);
        Font f=new Font("ARIAL",Font.BOLD,36);
        g.setFont(f);
        g.setColor(Color.BLUE);        
        g.drawString("CHOOSE AN AXIS FOR REFLECTION",400,500);
    }       
    
}
