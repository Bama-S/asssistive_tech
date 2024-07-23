//package javaapplication2;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class TrigonometryRatioLevelTwo extends JPanel
{   
    public static Graphics g1;
    public static int width,height;
    public static JButton b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11;
    public static boolean Ratiofirst = true;
    public static int angle[]={0,30,45,60,90,180};
    public static String identity[]={"sin","cos","tan","cosec","sec","cot"};
    public static String myIdentity[]=new String[5];
    public static int myAngle[]=new int[5];
    public static String myOrder[]={"0","1","2","3","4"};
    public static int myAnswer[] = new int[5];
    public static TrigonometryIcon[] icon = new TrigonometryIcon[5];
    
    public static void clearTrigonometryRatioLevelTwo()
    {
        Ratiofirst = true;
        myIdentity = new String[5];
        myAngle = new int[5];
        myOrder[0] = "0";
        myOrder[1] = "1";
        myOrder[2] = "2";
        myOrder[3] = "3";
        myOrder[4] = "4";
        myAnswer = new int[5];
        icon = new TrigonometryIcon[5];
    }
    
    public static void findAnswer(String[] ansIdentity,int[] ansAngle)
    {
        for(int i=0;i<5;i++)
        {
            if(ansAngle[i] == 0 && (ansIdentity[i].equals("sin")|| ansIdentity[i].equals("tan")))
            {
                myAnswer[i] = 0;
            }
            else if(ansAngle[i] == 90 && (ansIdentity[i].equals("cos")|| ansIdentity[i].equals("cot")))
            {
                myAnswer[i] = 0;
            }
            else if(ansAngle[i] == 180 && (ansIdentity[i].equals("sin")|| ansIdentity[i].equals("tan")))
            {
                myAnswer[i] = 0;
            }
            else if(ansAngle[i] == 30 && ansIdentity[i].equals("sin"))
            {
                myAnswer[i] = 1;
            }
            else if(ansAngle[i] == 60 && ansIdentity[i].equals("cos"))
            {
                myAnswer[i] = 1;
            }
            else if(ansAngle[i] == 45 && ansIdentity[i].equals("sin"))
            {
                   myAnswer[i] = 2;
            }
            else if(ansAngle[i] == 45 && ansIdentity[i].equals("cos"))
            {
                myAnswer[i] = 2;
            }
            else if(ansAngle[i] == 60 && ansIdentity[i].equals("sin"))
            {
                myAnswer[i] = 3;
            }
            else if(ansAngle[i] == 30 && ansIdentity[i].equals("cos"))
            {
                myAnswer[i] = 3;
            }
            else if(ansAngle[i] == 0 && (ansIdentity[i].equals("cos")|| ansIdentity[i].equals("sec")))
            {
                myAnswer[i] = 4;
            }
            else if(ansAngle[i] == 90 && (ansIdentity[i].equals("sin")|| ansIdentity[i].equals("cosec")))
            {
                myAnswer[i] = 4;
            }
            else if(ansAngle[i] == 45 && (ansIdentity[i].equals("tan")|| ansIdentity[i].equals("cot")))
            {
                myAnswer[i] = 4;
            }
            else if(ansAngle[i] == 60 && ansIdentity[i].equals("cot"))
            {
                myAnswer[i] = 5;
            }
            else if(ansAngle[i] == 30 && ansIdentity[i].equals("tan"))
            {
                myAnswer[i] = 5;
            }
            else if(ansAngle[i] == 60 && ansIdentity[i].equals("tan"))
            {
                myAnswer[i] = 6;
            }
            else if(ansAngle[i] == 30 && ansIdentity[i].equals("cot"))
            {
                myAnswer[i] = 6;
            }
            else if(ansAngle[i] == 0 && (ansIdentity[i].equals("cosec")|| ansIdentity[i].equals("cot")))
            {
                myAnswer[i] = 7;
            }
            else if(ansAngle[i] == 90 && (ansIdentity[i].equals("tan")|| ansIdentity[i].equals("sec")))
            {
                myAnswer[i] = 7;
            }
            else if(ansAngle[i] == 180 && (ansIdentity[i].equals("cosec")|| ansIdentity[i].equals("cot")))
            {
                myAnswer[i] = 7;
            }
            if(ansAngle[i] == 60 && ansIdentity[i].equals("cosec"))
            {
                myAnswer[i] = 8;
            }
            else if(ansAngle[i] == 30 && ansIdentity[i].equals("sec"))
            {
                myAnswer[i] = 8;
            }
            else if(ansAngle[i] == 45 && ansIdentity[i].equals("cosec"))
            {
                myAnswer[i] = 9;
            }
            else if(ansAngle[i] == 45 && ansIdentity[i].equals("sec"))
            {
                myAnswer[i] = 9;
            }
            else if(ansAngle[i] == 60 && ansIdentity[i].equals("sec"))
            {
                myAnswer[i] = 10;
            }
            else if(ansAngle[i] == 30 && ansIdentity[i].equals("cosec"))
            {
                myAnswer[i] = 10;
            }
            else if(ansAngle[i] == 180 && ansIdentity[i].equals("cos"))
            {
                myAnswer[i] = 11;
            }
            else if(ansAngle[i] == 180 && ansIdentity[i].equals("sec"))
            {
                myAnswer[i] = 11;
            }
        }    
    }
    
    public static void generateQuestion()
    {
        boolean random = true;         
       while(true)
       {
       for(int i=0;i<5;i++)
       {
       double d1 = Math.random()*6;
       int rand1 = (int)d1;
       double d2 = Math.random()*6;
       int rand2 = (int)d2;
       myIdentity[i] = identity[rand1];
       myAngle[i] = angle[rand2];
       }
       
       for(int i=0;i<5;i++)
       {
           for(int j=i+1;j<5;j++)
           {
               if(myIdentity[i].equals(myIdentity[j]) && (myAngle[i]==myAngle[j]))
               {
                   random = false;
                   break;
               }
           }
       }
       if(random)
       {
        Collections.shuffle(Arrays.asList(myOrder));
        break;
       }
       }                    
    }
    
    public static void restart()
    {       
       KeyBoard.Linst.setText("MATCH THE FOLLOWING");       
       Thread th = new Thread(new TrigonometryRatioLevelTwoThread());
       th.start();
    }
    public TrigonometryRatioLevelTwo()
    {        
    }
    
    public void paint(Graphics g)
    {  
        Main.classid = 8;
    	super.paintComponent(g);
        g1=getGraphics();
        
        if(Ratiofirst)
        {
            generateQuestion();
            findAnswer(myIdentity,myAngle);
        }
        
        Font f=new Font("Times New Roman",Font.BOLD,28);
        g.setFont(f);
        for(int i=0;i<5;i++)
            g.drawString(myIdentity[i]+" "+myAngle[i],200,i*100+100);
        
        g.setColor(Color.BLUE);
        g.drawString("YOUR ANSWER",360,25);
        g.setColor(Color.getHSBColor(50,80,30));
        g.fillRect(400,50,150,75);
        g.fillRect(400,150,150,75);
        g.fillRect(400,250,150,75);
        g.fillRect(400,350,150,75);
        g.fillRect(400,450,150,75);
        
        g.setColor(Color.BLUE);
        g.drawString("OPTIONS",920,25);
        g.setColor(Color.PINK);
        g.fillRect(900,50,150,75);
        g.fillRect(900,150,150,75);
        g.fillRect(900,250,150,75);
        g.fillRect(900,350,150,75);
        g.fillRect(900,450,150,75);
        g.setColor(Color.BLACK);
        
        
        icon[0] = new TrigonometryIcon(myAnswer[Integer.parseInt(myOrder[0])]+1);
        icon[0].paintIcon(null,g,970,90);
        icon[1] = new TrigonometryIcon(myAnswer[Integer.parseInt(myOrder[1])]+1);
        icon[1].paintIcon(null,g,970,190);
        icon[2]= new TrigonometryIcon(myAnswer[Integer.parseInt(myOrder[2])]+1);
        icon[2].paintIcon(null,g,970,290);
        icon[3] = new TrigonometryIcon(myAnswer[Integer.parseInt(myOrder[3])]+1);
        icon[3].paintIcon(null,g,970,390);
        icon[4] = new TrigonometryIcon(myAnswer[Integer.parseInt(myOrder[4])]+1);
        icon[4].paintIcon(null,g,970,490);
        
        if(Ratiofirst)
        {
            Ratiofirst = false;
            TrigonometryRatioLevelTwo.restart();
        }
    }
}    