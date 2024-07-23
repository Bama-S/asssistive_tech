//package javaapplication2;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TrigonometryRatioLevelOne extends JPanel
{   
    public static Graphics g1;
    public static int width,height;
    public static JButton b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11;
    public static boolean Ratiofirst = true;
    public static int angle[]={0,30,45,60,90,180};
    public static String identity[]={"sin","cos","tan","cosec","sec","cot"};
    public static String myIdentity;
    public static int myAngle;
    
    public static void clearTrigonometryRatioLevelOne()
    {
        Ratiofirst = true;
        myIdentity = null;
        myAngle = 0;
    }
    
    
    public static void restart()
    {
       double d1 = Math.random()*6;
       int rand1 = (int)d1;
       double d2 = Math.random()*6;
       int rand2 = (int)d2;
       myIdentity = identity[rand1];
       myAngle = angle[rand2];
       KeyBoard.Linst.setText("What is the value of "+myIdentity+" "+myAngle+" ?");
       Thread th = new Thread(new TrigonometryRatioLevelOneThread(b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11));
       th.start();
    }
    public TrigonometryRatioLevelOne()
    {
        Main.classid = 7;        
        setLayout(null);        
        Icon icon = new TrigonometryIcon(1);
        b0 = new JButton(icon);
        
        icon = new TrigonometryIcon(2);
        b1 = new JButton(icon);
        
        icon = new TrigonometryIcon(3);
        b2 = new JButton(icon);
        
        icon = new TrigonometryIcon(4);
        b3 = new JButton(icon);
        
        icon = new TrigonometryIcon(5);
        b4 = new JButton(icon);
        
        icon = new TrigonometryIcon(6);
        b5 = new JButton(icon);
        
        icon = new TrigonometryIcon(7);
        b6 = new JButton(icon);
        
        icon = new TrigonometryIcon(8);
        b7 = new JButton(icon);
        
        icon = new TrigonometryIcon(9);
        b8 = new JButton(icon);
        
        icon = new TrigonometryIcon(10);
        b9 = new JButton(icon);
        
        icon = new TrigonometryIcon(11);
        b10 = new JButton(icon);
        
        icon = new TrigonometryIcon(12);
        b11 = new JButton(icon);
        
        
        b0.setBounds(100,100,150,100);
        b1.setBounds(250,100,150,100);
        b2.setBounds(400,100,150,100);
        b3.setBounds(550,100,150,100);
        b4.setBounds(700,100,150,100);
        b5.setBounds(850,100,150,100);        
        b6.setBounds(100,200,150,100);
        b7.setBounds(250,200,150,100);
        b8.setBounds(400,200,150,100);
        b9.setBounds(550,200,150,100);
        b10.setBounds(700,200,150,100);
        b11.setBounds(850,200,150,100); 
        
        add(b0);
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        add(b6);
        add(b7);
        add(b8);
        add(b9);
        add(b10);
        add(b11);           
        
    }
}