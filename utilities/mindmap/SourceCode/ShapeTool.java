import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class ShapeTool extends JPanel implements ActionListener
{
public static JButton buttonRect,buttonEllipse,buttonSquare,buttonCircle,buttonLine;
ImageIcon icon;
public ShapeTool()
{


setLayout(new GridLayout(1,5));

icon = new ImageIcon("icon\\Rectangle.png");
buttonRect=new JButton(icon);
icon = new ImageIcon("icon\\Oval.png");
buttonEllipse=new JButton(icon);
icon = new ImageIcon("icon\\Square.png");
buttonSquare=new JButton(icon);
icon = new ImageIcon("icon\\Circle.png");
buttonCircle=new JButton(icon);
icon = new ImageIcon("icon\\Line.png");
buttonLine=new JButton(icon);


buttonRect.setBackground(Mind.btnBackcolor);
buttonEllipse.setBackground(Mind.btnBackcolor);
buttonSquare.setBackground(Mind.btnBackcolor);
buttonCircle.setBackground(Mind.btnBackcolor);
buttonLine.setBackground(Mind.btnBackcolor);


add(buttonRect);
add(buttonEllipse);
add(buttonSquare);
add(buttonCircle);
add(buttonLine);

buttonRect.addActionListener(this);
buttonEllipse.addActionListener(this);
buttonSquare.addActionListener(this);
buttonCircle.addActionListener(this);
buttonLine.addActionListener(this);


}
public static void start()
{
ShapeThread ct=new ShapeThread(buttonRect,buttonEllipse,buttonSquare,buttonCircle,buttonLine);

}
public static void reSet()
{
    buttonRect.setEnabled(true);
buttonEllipse.setEnabled(true);
buttonEllipse.setEnabled(true);
buttonSquare.setEnabled(true);
buttonCircle.setEnabled(true);
buttonLine.setEnabled(true);
}
public void actionPerformed(ActionEvent ae) {

Object ob=ae.getSource();

if(ob==buttonRect)
{
Mind.play("rect");    
Mind.varShape=1;
}
else if(ob==buttonEllipse)
{
Mind.play("ellipse");    
Mind.varShape=2;
}
else if(ob==buttonSquare)
{
    Mind.play("square");
Mind.varShape=3;
}
else if(ob==buttonCircle)
{
    Mind.play("circle");
Mind.varShape=4;
}
else if(ob==buttonLine)
{
    Mind.play("line");
Mind.varShape=5;
}



}



}
