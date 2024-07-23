//package javaapplication2;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FlashButtonPanel extends JPanel
{         
       public static Button b1,b2,b3;
       
       public static void restart()
       {
           Thread th=new Thread(new FlashButtonThread(b1,b2,b3));
           th.start();        
       }
       
       public FlashButtonPanel()
       {
           Font f=new Font("Arial Black",Font.BOLD,28);
           b1=new Button("PREVIOUS");
           b2=new Button("NEXT");
           b3=new Button("EXIT");
           setLayout(new GridLayout(1,3));
           add(b1);
           add(b2);
           add(b3);
           b1.setFont(f);
           b2.setFont(f);           
           b3.setFont(f);           
       }
    
}

