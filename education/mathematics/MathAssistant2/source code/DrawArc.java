//package javaapplication2;

import java.applet.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;       

public class DrawArc extends DrawTriangle
{
    public static int mylength;
    Graphics2D g2,g3;
    Graphics g5;
    public int r1,r2;    
    
    public DrawArc() 
    {
        g2 = (Graphics2D) g1.create();
        g3 = (Graphics2D) g1.create();        
        g5 = g1.create();
        
        g2.setStroke(new BasicStroke(3.0f));
        g3.setStroke(new BasicStroke(3.0f));
        
        g2.setColor(Color.BLACK);
        g3.setColor(Color.WHITE);
        drawArc();
    }
    
    public void drawArc()
    {
        KeyBoard.tf.setText(null);   
        Main.ch = '\0';        
        KeyBoard.Linst.setText("ENTER THE LENGTH OF THIRD SIDE FROM THE BLUE POINT");
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
        
        try{
        KeyBoard.thread.join();
        }
        catch(Exception e){}
        int getLength=Integer.parseInt(KeyBoard.tf.getText());
        mylength = getLength * 45;
        r1 = mylength;
        Thread th=new Thread(new CircleThread(bluex,bluey,mylength));
        th.start();       
        
        try{
        th.join();
        }
        catch(Exception e){}
        
        firstCirclex1 = CircleThread.startx;
        firstCircley1 = CircleThread.starty;
        firstCirclex2 = CircleThread.endx;
        firstCircley2 = CircleThread.endy;
        
        Main.ch = '\0';        
        KeyBoard.tf.setText(null);
        KeyBoard.Linst.setText("ENTER THE LENGTH OF THIRD SIDE FROM THE RED POINT");
        KeyBoard.keyStart();        
        
        StringBuffer sb1=new StringBuffer();
        while(Main.ch!='\n')
        {
          if(Main.ch!='\0')
          { 
           if(Main.ch=='\b')
             sb1=new StringBuffer();
           else                    
             sb1.append(Main.ch);     
           Main.ch='\0';
           KeyBoard.tf.setText(sb1.toString());
          }
        }
        
        try{
        KeyBoard.thread.join();
        }
        catch(Exception e){}
        int getLength1=Integer.parseInt(KeyBoard.tf.getText());
        mylength = getLength1 * 45;
        r2 = mylength;
        Thread th1=new Thread(new CircleThread(redx,redy,mylength));
        th1.start();                
        
        try{
        th1.join();
        }
        catch(Exception e){}         
        
        secondCirclex1 = CircleThread.startx;
        secondCircley1 = CircleThread.starty;
        secondCirclex2 = CircleThread.endx;
        secondCircley2 = CircleThread.endy;        
        
        double x1=bluex;
        double y1=bluey;
        double x2=redx;
        double y2=redy;
        
        double temp= ((x2-x1)*(x2-x1)) + ((y2-y1)*(y2-y1));
        double d=Math.sqrt(temp);
        double dsqr = d*d;
        double r1sqr = r1*r1;
        double r2sqr = r2*r2;
        double r1pr2sqr = (r1+r2)*(r1+r2);
        double r2mr1sqr = (r2-r1)*(r2-r1);
        double temp1 = (r1pr2sqr - dsqr)*(dsqr-r2mr1sqr);
        
        int newx1 = (int)((((x2+x1)/2) + (((x2-x1)*(r1sqr-r2sqr))/(2*dsqr))) + (((y2-y1)/(2*dsqr))*(Math.sqrt(temp1))));
        int newy1 = (int)((((y2+y1)/2) + (((y2-y1)*(r1sqr-r2sqr))/(2*dsqr))) - (((x2-x1)/(2*dsqr))*(Math.sqrt(temp1))));
        
        int newx2 = (int)((((x2+x1)/2) + (((x2-x1)*(r1sqr-r2sqr))/(2*dsqr))) - (((y2-y1)/(2*dsqr))*(Math.sqrt(temp1))));
        int newy2 = (int)((((y2+y1)/2) + (((y2-y1)*(r1sqr-r2sqr))/(2*dsqr))) + (((x2-x1)/(2*dsqr))*(Math.sqrt(temp1))));              
            
        boolean flag = false;    
        int option = 0;
        
        if(firstCirclex1 > firstCirclex2)
        {
            int tmp = firstCirclex1;
            firstCirclex1 = firstCirclex2;
            firstCirclex2 = tmp;
        } 
        
        if(firstCircley1 > firstCircley2)
        {
            int tmp = firstCircley1;
            firstCircley1 = firstCircley2;
            firstCircley2 = tmp;
        }
        
        if(secondCirclex1 > secondCirclex2)
        {
            int tmp = secondCirclex1;
            secondCirclex1 = secondCirclex2;
            secondCirclex2 = tmp;
        } 
        
        if(secondCircley1 > secondCircley2)
        {
            int tmp = secondCircley1;
            secondCircley1 = secondCircley2;
            secondCircley2 = tmp;
        }
        
        if((newx1 > firstCirclex1 && newx1 < firstCirclex2)&&(newy1 > firstCircley1 && newy1 < firstCircley2))
        {
            if((newx1 > secondCirclex1 && newx1 < secondCirclex2)&&(newy1 > secondCircley1 && newy1 < secondCircley2))
            {
                flag = true;
                option = 1;
            }
        }        
        else if((newx2 > firstCirclex1 && newx2 < firstCirclex2)&&(newy2 > firstCircley1 && newy2 < firstCircley2))
        {
            if((newx2 > secondCirclex1 && newx2 < secondCirclex2)&&(newy2 > secondCircley1 && newy2 < secondCircley2))
            {
                flag = true;
                option = 2;
            }
        }
        
        if(flag)
        {    
            KeyBoard.Linst.setText("YOUR TRIANGLE HAS BEEN DRAWN");
            if(option == 1)
            {
                greenx = newx1;
                greeny = newy1;
            }
            else if(option == 2)            
            {
                greenx = newx2;
                greeny = newy2;
            }            
            
            g5.setColor(Color.BLUE);
             g5.fillOval(bluex-10,bluey-10,20,20);
            g5.setColor(Color.RED);
             g5.fillOval(redx-10,redy-10,20,20);
            g5.setColor(Color.GREEN);
             g5.fillOval(greenx-10,greeny-10,20,20);
             
            g2.drawLine(bluex,bluey,redx,redy);
            g2.drawLine(bluex,bluey,greenx,greeny);
            g2.drawLine(greenx,greeny,redx,redy);            
        }
        else
        {            
            KeyBoard.Linst.setText("THE ARCS DIDN'T INTERSECT. TRY AGAIN");
            try{
                Thread.sleep(3500);
            }
            catch(Exception e){}
            g2.setColor(Color.WHITE);
            g2.fillRect(0,0,width,height);
            
            g5.setColor(Color.BLUE);
             g5.fillOval(bluex-10,bluey-10,20,20);
            g5.setColor(Color.RED);
             g5.fillOval(redx-10,redy-10,20,20);
            g2.setColor(Color.BLACK) ;
            g2.drawLine(bluex,bluey,redx,redy);
            
            DrawArc da = new DrawArc();
        }
    }
    
}
