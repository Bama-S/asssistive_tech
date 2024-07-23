//package javaapplication2;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class VerticalMove extends DrawTriangle implements Runnable 
{      
    //public static int bluey;
      public void run()
      {       
        Graphics2D g2= (Graphics2D) g1.create();
        Graphics2D g3= (Graphics2D) g1.create();            
        Graphics2D g4= (Graphics2D) g1.create();                    
        
        Graphics g5= g1.create();
        
        g2.setStroke(new BasicStroke(5.0f));
        g3.setStroke(new BasicStroke(5.0f));
        g4.setStroke(new BasicStroke(5.0f));
        
        g2.setColor(Color.RED);        
        g3.setColor(Color.BLACK);
        g4.setColor(Color.WHITE);
        
        for(bluey=0;bluey<=height;)
        {   
            
            if(redy==0)
            {
                g3.drawLine(bluex,0,bluex,height);            
            }
            
            g2.drawLine(bluex,0,bluex,bluey);
            
            try{
            Thread.sleep(50);            
            }
            catch(Exception e){}        
           
	if(Main.flag)
        {
          Main.flag=false;
          break;
	}            
	 if(bluey >= height-20)                     
             bluey=0;         
         else
             bluey+=5;
        }
        
        g4.drawLine(bluex,0,bluex,height);
        
        g5.setColor(Color.BLUE);
        g5.fillOval(bluex-10,bluey-10,20,20) ;
        
        KeyBoard.Linst.setText("ENTER THE LENGTH OF FIRST SIDE");
        KeyBoard.keyStart();
        
        StringBuffer sb=new StringBuffer();
        while(Main.ch!='\n')
        {
          if(Main.ch!='\0')
          { 
           if(Main.ch=='\b')
             sb=new StringBuffer();
           else                    
             sb.append(Main.ch);     
           Main.ch='\0';
           KeyBoard.tf.setText(sb.toString());
          }
        }            
        
        int getLength=Integer.parseInt(KeyBoard.tf.getText());
        int length = getLength * 45;
        KeyBoard.tf.setText(null);     
        
        g3.setStroke(new BasicStroke(3.0f));
        g3.drawLine(bluex,bluey,bluex+length,bluey);
        
        KeyBoard.Linst.setText("SELECT A LOCATION FOR THE RED POINT");
        Thread th = new Thread(new RotationThread(bluex,bluey,length));
        th.start();
        
    }
    
}
