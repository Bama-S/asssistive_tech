//package javaapplication2;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class TrigonometryRatioLevelTwoThread extends TrigonometryRatioLevelTwo implements Runnable
{       
    public static int index = 0;
    public static int count = 0;
    public static boolean answerFlag = true;
    public static boolean resultBox[] = {true,true,true,true,true};
    public static int result[] = new int[5];
    public MarkIcon correct = new MarkIcon(0);
    public MarkIcon wrong = new MarkIcon(1);
    
    public TrigonometryRatioLevelTwoThread()
    {
        
    }

    public static void clearTrigonometryRatioLevelTwoThread()
   {
    index = 0;
    count = 0;
    answerFlag = true;
    resultBox[0]=true;
    resultBox[1]=true;
    resultBox[2]=true;
    resultBox[3]=true;
    resultBox[4]=true;
    result = new int[5];
    }
    public void run()
    {
        Graphics g2 = g1.create();
        Graphics g3 = g1.create();
        Graphics g4 = g1.create();        
        g2.setColor(Color.PINK);
        g3.setColor(Color.getHSBColor(60,70,50));        
        g4.setColor(Color.BLACK);                
        while(true)
        {
            if(index == 0)
            {                
                g2.fillRect(900,450,150,75);                              
                icon[4].paintIcon(null,g4,970,490);
                g3.fillRect(900,50,150,75);                
                icon[0].paintIcon(null,g4,970,90);
            }    
            else if(index == 1)
            {    
                g2.fillRect(900,50,150,75);                              
                icon[0].paintIcon(null,g4,970,90);
                g3.fillRect(900,150,150,75);
                icon[1].paintIcon(null,g4,970,190);
            }
            else if(index == 2)
            {    
                g2.fillRect(900,150,150,75);
                icon[1].paintIcon(null,g4,970,190);
                g3.fillRect(900,250,150,75);                
                icon[2].paintIcon(null,g4,970,290);
            }    
            else if(index == 3)
            {    
                g2.fillRect(900,250,150,75);                              
                icon[2].paintIcon(null,g4,970,290);
                g3.fillRect(900,350,150,75);                
                icon[3].paintIcon(null,g4,970,390);
            }    
            else if(index == 4)
            {    
                g2.fillRect(900,350,150,75);                              
                icon[3].paintIcon(null,g4,970,390);
                g3.fillRect(900,450,150,75);                
                icon[4].paintIcon(null,g4,970,490);
            }    
            
            try
            {
                Thread.sleep(500);
            }
            catch(Exception e){}            
            
            if(Main.flag)
            {
                Main.flag = false;
                count++;
                break;
            }
            
            index = (index + 1) % 5;        
        }
        for(int i=0;i<5;i++)
        {
            if(resultBox[i])
            {
                resultBox[i] = false;
                icon[index].paintIcon(null,g4,470,(count*100)-10);
                result[i] = icon[index].getButtonStatus()-1;
                break;
            }
        }
        if(count < 5)
            TrigonometryRatioLevelTwo.restart();
        else if(count == 5)
        {       
            for(int i=0;i<5;i++)
            {                
                if(result[i] == myAnswer[i])
                {
                  correct.paintIcon(null,g4,600,(2*(i+1)-1)*50);
                    continue;
                }    
                else
                {
                    wrong.paintIcon(null,g4,600,(2*(i+1)-1)*50);
                    answerFlag = false;                    
                }
            }


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
            Main.tr1.setVisible(false);            
            Main.cnt.add(BorderLayout.SOUTH,Main.fc);
            Main.cnt.add(BorderLayout.CENTER,Main.blk);            
            FinalChoice.restart();
            break;
            }
            }

            /*if(answerFlag)
                KeyBoard.Linst.setText("CORRECT ANSWER");
            else
                KeyBoard.Linst.setText("WRONG ANSWER");*/
        }   
    }
       
}