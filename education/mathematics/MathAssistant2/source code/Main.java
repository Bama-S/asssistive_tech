//package javaapplication2;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JFrame implements MouseListener
{
   public static boolean flag=false;
   public static JFrame frame;
   public static int choice;
   public static KeyBoard key;
   public static Graph grh;
   public static Angle ang;
   public static Choice cho;
   public static Index ind;
   public static Blank blk;
   public static CourseMaterial cm;
   public static Practice practice;
   public static EquationChoice ec;
   public static ReflectionIndex rind;
   public static AnalyticalChoice acho;
   public static TrigonometryChoice tcho;
   public static ReflectionChoice rc;
   public static TrigonometryRatioChoice trc;
   public static TrigonometryRatioLevelOne tr;
   public static TrigonometryRatioLevelTwo tr1;
   public static FinalChoice fc;
   public static DrawTriangle dt;   
   public static char ch='\0';
   public static Container cnt;
   public static int currentTopic;
   public static int classid;
   
   public static void clearAll()
   {
       ch = '\0';
       AnalyticalChoice.clearAnalyticalChoice(); 
       Angle.clearAngle();
       AngleThread.clearAngleThread();
       EquationChoice.clearEquationChoice();
       Graph.clearGraph();
       Index.clearIndex();
       InterceptEquation.clearInterceptEquation();
       KeyBoard.clearKeyBoard();
       Reflection.clearReflection();
       Slope.clearSlope();
       SlopeInterceptEquation.clearSlopeInterceptEquation();
       Translation.clearTranslation();
       TrigonometryChoice.clearTrigonometryChoice();
       TrigonometryRatioChoice.clearTrigonometryRatioChoice();
       TrigonometryRatioLevelOne.clearTrigonometryRatioLevelOne();
       TrigonometryRatioLevelTwo.clearTrigonometryRatioLevelTwo();
       TrigonometryRatioLevelTwoThread.clearTrigonometryRatioLevelTwoThread();
     //  DrawTriangle.clearDrawTriangle();
   }
   
   public Main()
   {
       init();
   }
   
    public void mouseClicked(MouseEvent me)
    {
         flag=true;  
     }
    public void mouseEntered(MouseEvent me)
    {}
    public void mouseExited(MouseEvent me)
    {}
    public void mousePressed(MouseEvent me)
    {}
    public void mouseReleased(MouseEvent me)
    {}
    
    public void init() 
    {        
        frame = new JFrame("MATH ASSISTANT");
        cnt=frame.getContentPane();        
        ind = new Index();
        cm = new CourseMaterial();
        practice = new Practice();
        rind = new ReflectionIndex();
        cho = new Choice();
        blk = new Blank();
        grh = new Graph();
        ang = new Angle();
        key = new KeyBoard();
        ec = new EquationChoice();
        acho = new AnalyticalChoice();
        rc = new ReflectionChoice();
        tcho = new TrigonometryChoice();
        trc = new TrigonometryRatioChoice();
        tr = new TrigonometryRatioLevelOne();
        tr1 = new TrigonometryRatioLevelTwo();
        fc = new FinalChoice();
        dt = new DrawTriangle();
        cnt.add(BorderLayout.CENTER,ind);
        //cnt.add(BorderLayout.WEST,KeyBoard.lpan);
        //cnt.add(BorderLayout.SOUTH,KeyBoard.Linst);
        cnt.addMouseListener(this);     
        frame.setSize(1296,700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //centerAndDisplay();
        frame.setVisible(true);
        //Index.restart();
    }
public void start()
{
}
    
public static void main(String[] args)
{
    new Main();
}


}
