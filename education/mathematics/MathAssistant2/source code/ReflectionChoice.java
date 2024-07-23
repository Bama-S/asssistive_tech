//package javaapplication2;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ReflectionChoice extends JPanel
{         
       public static Button b1,b2;
       
       public static void restart()
       {
           Thread th=new Thread(new ReflectionChoiceThread(b1,b2));
           th.start();        
       }
       
       public ReflectionChoice()
       {
           Font f=new Font("Arial Black",Font.BOLD,28);
           b1=new Button("X-AXIS");
           b2=new Button("Y-AXIS");
           setLayout(new GridLayout(1,2));
           add(b1);
           add(b2);
           b1.setFont(f);
           b2.setFont(f);           
       }
    
}

