//package javaapplication2;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FinalChoice extends JPanel
{         
       public static Button b1,b2;
       
       public static void restart()
       {
           FinalChoiceThread ch=new FinalChoiceThread(b1,b2);
       }
       
       public FinalChoice()
       {
           Font f=new Font("Arial Black",Font.BOLD,28);
           b1=new Button("GO TO HOME PAGE");
           b2=new Button("TRY AGAIN");
           
           setLayout(new GridLayout(1,2));
           add(b1);
           add(b2);
           b1.setFont(f);
           b2.setFont(f);
       }
    
}

