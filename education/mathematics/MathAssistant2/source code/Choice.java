//package javaapplication2;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Choice extends JPanel
{         
       public static Button b1,b2;
       
       public static void restart()
       {
           ChoiceThread ch=new ChoiceThread(b1,b2);
       }
       
       public Choice()
       {
           Font f=new Font("Arial Black",Font.BOLD,28);
           b1=new Button("ANALYTICAL GEOMETRY");
           b2=new Button("TRIGONOMETRY");
           
           setLayout(new GridLayout(1,2));
           add(b1);
           add(b2);
           b1.setFont(f);
           b2.setFont(f);
       }
    
}

