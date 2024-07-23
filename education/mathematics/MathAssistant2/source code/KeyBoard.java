//package javaapplication2;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class KeyBoard extends JPanel
{    
    public static Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,bdot,bminus,bok,bclr; 
    public static Panel lpan;
    public static Label Linst;
    public static TextField tf;    
    public static Thread thread;
    
    public static void clearKeyBoard()
    {
        Linst.setText("");
        tf.setText("");
    }
    
    public static void keyStart()
    {
        thread=new Thread(new KeyThread(b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,bdot,bminus,bok,bclr));
        thread.start();
    }
    
    public KeyBoard()
    {       
        lpan=new Panel();
        
        lpan.setLayout(new GridLayout(15,1));
        
        Linst=new Label("INSTRUCTIONS TO THE USERS");
        tf=new TextField();
        Font f=new Font("Arial Black",Font.BOLD,28);
        b0=new Button("0");
        b1=new Button("1");
        b2=new Button("2");
        b3=new Button("3");
        b4=new Button("4");
        b5=new Button("5");
        b6=new Button("6");
        b7=new Button("7");
        b8=new Button("8");
        b9=new Button("9");
        bdot=new Button(".");
        bminus=new Button("-");
        bok=new Button("OK");
        bclr=new Button("CLEAR");
        
        b1.setFont(f);
        b2.setFont(f);
        b3.setFont(f);
        b4.setFont(f);
        b5.setFont(f);
        b6.setFont(f);
        b7.setFont(f);
        b8.setFont(f);
        b9.setFont(f);
        b0.setFont(f);
        bminus.setFont(f);
        bok.setFont(f);
        bdot.setFont(f);
        bclr.setFont(f);        
        lpan.add(b0);
        lpan.add(b1);
        lpan.add(b2);
        lpan.add(b3);
        lpan.add(b4);
        lpan.add(b5);
        lpan.add(b6);
        lpan.add(b7);
        lpan.add(b8);
        lpan.add(b9);
        lpan.add(bdot);
        lpan.add(bminus);
        lpan.add(bok);
        lpan.add(bclr);
        lpan.add(tf);
        tf.setFont(f);
        f=new Font("Arial Black",Font.BOLD,32);
        
        Linst.setFont(f);
        Linst.setAlignment(Linst.CENTER);       
    }
}