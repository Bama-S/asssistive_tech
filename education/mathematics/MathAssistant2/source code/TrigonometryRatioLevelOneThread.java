//package javaapplication2;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TrigonometryRatioLevelOneThread implements Runnable 
{    
    JButton b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11;
    int i = -1;
    boolean answer = false;
    public TrigonometryRatioLevelOneThread(JButton b0,JButton b1,JButton b2,JButton b3,JButton b4,JButton b5,JButton b6,JButton b7,JButton b8,JButton b9,JButton b10,JButton b11) 
    {       
        this.b0=b0;
        this.b1=b1;
        this.b2=b2;
        this.b3=b3;
        this.b4=b4;
        this.b5=b5;
        this.b6=b6;
        this.b7=b7;
        this.b8=b8;
        this.b9=b9;
        this.b10=b10;
        this.b11=b11;
    }
    
    public void run()
    {
        while(true)
        {            
            b0.setEnabled(false);
            b1.setEnabled(false);
            b2.setEnabled(false);
            b3.setEnabled(false);
            b4.setEnabled(false);
            b5.setEnabled(false);
            b6.setEnabled(false);
            b7.setEnabled(false);
            b8.setEnabled(false);
            b9.setEnabled(false);
            b10.setEnabled(false);
            b11.setEnabled(false);              
            
            i=(i+1)%12;            
            if(i==0)
            b0.setEnabled(true);
            else if(i==1)
            b1.setEnabled(true);
            else if(i==2)
            b2.setEnabled(true);
            else if(i==3)
            b3.setEnabled(true);
            else if(i==4)
            b4.setEnabled(true);
            else if(i==5)
            b5.setEnabled(true);
            else if(i==6)
            b6.setEnabled(true);
            else if(i==7)
            b7.setEnabled(true);
            else if(i==8)
            b8.setEnabled(true);
            else if(i==9)
            b9.setEnabled(true);
            else if(i==10)
            b10.setEnabled(true);
            else if(i==11)
            b11.setEnabled(true);      
         
            try
            {
                Thread.sleep(1000);                                 
            }
            catch(Exception e)
            {}
            
            if(Main.flag)
            {               
                Main.flag = false;
                break;
            }
            
        }
        
        if(i == 0)
        {
            if(TrigonometryRatioLevelOne.myAngle == 0 && (TrigonometryRatioLevelOne.myIdentity.equals("sin")|| TrigonometryRatioLevelOne.myIdentity.equals("tan")))
            {
                answer = true;
            }
            else if(TrigonometryRatioLevelOne.myAngle == 90 && (TrigonometryRatioLevelOne.myIdentity.equals("cos")|| TrigonometryRatioLevelOne.myIdentity.equals("cot")))
            {
                answer = true;
            }
            else if(TrigonometryRatioLevelOne.myAngle == 180 && (TrigonometryRatioLevelOne.myIdentity.equals("sin")|| TrigonometryRatioLevelOne.myIdentity.equals("tan")))
            {
                answer = true;
            }
            else answer = false;
        }
        else if(i == 1)
        {
            if(TrigonometryRatioLevelOne.myAngle == 30 && TrigonometryRatioLevelOne.myIdentity.equals("sin"))
            {
                answer = true;
            }
            else if(TrigonometryRatioLevelOne.myAngle == 60 && TrigonometryRatioLevelOne.myIdentity.equals("cos"))
            {
                answer = true;
            }
            else answer = false;
        }
        else if(i == 2)
        {
            if(TrigonometryRatioLevelOne.myAngle == 45 && TrigonometryRatioLevelOne.myIdentity.equals("sin"))
            {
                answer = true;
            }
            else if(TrigonometryRatioLevelOne.myAngle == 45 && TrigonometryRatioLevelOne.myIdentity.equals("cos"))
            {
                answer = true;
            }
            else answer = false;
        }
        else if(i == 3)
        {
            if(TrigonometryRatioLevelOne.myAngle == 60 && TrigonometryRatioLevelOne.myIdentity.equals("sin"))
            {
                answer = true;
            }
            else if(TrigonometryRatioLevelOne.myAngle == 30 && TrigonometryRatioLevelOne.myIdentity.equals("cos"))
            {
                answer = true;
            }
            else answer = false;
        }
        else if(i == 4)
        {
            if(TrigonometryRatioLevelOne.myAngle == 0 && (TrigonometryRatioLevelOne.myIdentity.equals("cos")|| TrigonometryRatioLevelOne.myIdentity.equals("sec")))
            {
                answer = true;
            }
            else if(TrigonometryRatioLevelOne.myAngle == 90 && (TrigonometryRatioLevelOne.myIdentity.equals("sin")|| TrigonometryRatioLevelOne.myIdentity.equals("cosec")))
            {
                answer = true;
            }
            else if(TrigonometryRatioLevelOne.myAngle == 45 && (TrigonometryRatioLevelOne.myIdentity.equals("tan")|| TrigonometryRatioLevelOne.myIdentity.equals("cot")))
            {
                answer = true;
            }
            else answer = false;
        }
        else if(i == 5)
        {
            if(TrigonometryRatioLevelOne.myAngle == 60 && TrigonometryRatioLevelOne.myIdentity.equals("cot"))
            {
                answer = true;
            }
            else if(TrigonometryRatioLevelOne.myAngle == 30 && TrigonometryRatioLevelOne.myIdentity.equals("tan"))
            {
                answer = true;
            }
            else answer = false;
        }
        else if(i == 6)
        {
            if(TrigonometryRatioLevelOne.myAngle == 60 && TrigonometryRatioLevelOne.myIdentity.equals("tan"))
            {
                answer = true;
            }
            else if(TrigonometryRatioLevelOne.myAngle == 30 && TrigonometryRatioLevelOne.myIdentity.equals("cot"))
            {
                answer = true;
            }
            else answer = false;
        }
        else if(i == 7)
        {
            if(TrigonometryRatioLevelOne.myAngle == 0 && (TrigonometryRatioLevelOne.myIdentity.equals("cosec")|| TrigonometryRatioLevelOne.myIdentity.equals("cot")))
            {
                answer = true;
            }
            else if(TrigonometryRatioLevelOne.myAngle == 90 && (TrigonometryRatioLevelOne.myIdentity.equals("tan")|| TrigonometryRatioLevelOne.myIdentity.equals("sec")))
            {
                answer = true;
            }
            else if(TrigonometryRatioLevelOne.myAngle == 180 && (TrigonometryRatioLevelOne.myIdentity.equals("cosec")|| TrigonometryRatioLevelOne.myIdentity.equals("cot")))
            {
                answer = true;
            }
            else answer = false;
        }        
        else if(i == 8)
        {
            if(TrigonometryRatioLevelOne.myAngle == 60 && TrigonometryRatioLevelOne.myIdentity.equals("cosec"))
            {
                answer = true;
            }
            else if(TrigonometryRatioLevelOne.myAngle == 30 && TrigonometryRatioLevelOne.myIdentity.equals("sec"))
            {
                answer = true;
            }
            else answer = false;
        }
        else if(i == 9)
        {
            if(TrigonometryRatioLevelOne.myAngle == 45 && TrigonometryRatioLevelOne.myIdentity.equals("cosec"))
            {
                answer = true;
            }
            else if(TrigonometryRatioLevelOne.myAngle == 45 && TrigonometryRatioLevelOne.myIdentity.equals("sec"))
            {
                answer = true;
            }
            else answer = false;
        }   
        else if(i == 10)
        {
            if(TrigonometryRatioLevelOne.myAngle == 60 && TrigonometryRatioLevelOne.myIdentity.equals("sec"))
            {
                answer = true;
            }
            else if(TrigonometryRatioLevelOne.myAngle == 30 && TrigonometryRatioLevelOne.myIdentity.equals("cosec"))
            {
                answer = true;
            }
            else answer = false;
        }
        else if(i == 11)
        {
            if(TrigonometryRatioLevelOne.myAngle == 180 && TrigonometryRatioLevelOne.myIdentity.equals("cos"))
            {
                answer = true;
            }
            else if(TrigonometryRatioLevelOne.myAngle == 180 && TrigonometryRatioLevelOne.myIdentity.equals("sec"))
            {
                answer = true;
            }
            else answer = false;
        }
        
        if(answer == true)
            KeyBoard.Linst.setText("CORRECT ANSWER");
        else
            KeyBoard.Linst.setText("WRONG ANSWER");      
try
            {
                Thread.sleep(4000);
            }
            catch(Exception e)
            {}
            KeyBoard.Linst.setText("CLICK ONCE TO TRY AGAIN");
            
            while(true)
            {
            if(Main.flag)
            {            
            Main.flag = false;
            Main.fc.setVisible(true);
            Main.cm.setVisible(true);
            KeyBoard.Linst.setVisible(false);
            Main.tr.setVisible(false);            
            Main.cnt.add(BorderLayout.SOUTH,Main.fc);
            Main.cnt.add(BorderLayout.CENTER,Main.blk);            
            FinalChoice.restart();
            break;
            }
            }
 }
}
        
        
   