import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class ColorTool extends JPanel implements ActionListener
{
public static JButton btnColor1,btnColor2,btnColor3,btnColor4,btnColor5,btnColor6,btnColor7,btnColor8,btnColor9,btnColor10;
Icon icon;
public ColorTool()
{
ImageIcon icon[] = new ImageIcon[22];

setLayout(new GridLayout(2,5));


icon[0]=new ImageIcon("icon\\Red.png");
icon[1]=new ImageIcon("icon\\Green.png");
icon[2]=new ImageIcon("icon\\Blue.png");
icon[3]=new ImageIcon("icon\\Black.png");
icon[4]=new ImageIcon("icon\\Magenta.png");
icon[5]=new ImageIcon("icon\\Orange.png");
icon[6]=new ImageIcon("icon\\Yellow.png");
icon[7]=new ImageIcon("icon\\Cyan.png");
icon[8]=new ImageIcon("icon\\Gray.png");
icon[9]=new ImageIcon("icon\\Pink.png");


btnColor1=new JButton(icon[0]);

btnColor2=new JButton(icon[1]);

btnColor3=new JButton(icon[2]);

btnColor4=new JButton(icon[3]);

btnColor5=new JButton(icon[4]);

btnColor6=new JButton(icon[5]);

btnColor7=new JButton(icon[6]);

btnColor8=new JButton(icon[7]);

btnColor9=new JButton(icon[8]);

btnColor10=new JButton(icon[9]);

btnColor1.setBackground(Mind.btnBackcolor);
btnColor2.setBackground(Mind.btnBackcolor);
btnColor3.setBackground(Mind.btnBackcolor);
btnColor4.setBackground(Mind.btnBackcolor);
btnColor5.setBackground(Mind.btnBackcolor);
btnColor6.setBackground(Mind.btnBackcolor);
btnColor7.setBackground(Mind.btnBackcolor);
btnColor8.setBackground(Mind.btnBackcolor);
btnColor9.setBackground(Mind.btnBackcolor);
btnColor10.setBackground(Mind.btnBackcolor);


add(btnColor1);
add(btnColor2);
add(btnColor3);
add(btnColor4);
add(btnColor5);
add(btnColor6);
add(btnColor7);
add(btnColor8);
add(btnColor9);
add(btnColor10);


btnColor1.addActionListener(this);
btnColor2.addActionListener(this);
btnColor3.addActionListener(this);
btnColor4.addActionListener(this);
btnColor5.addActionListener(this);
btnColor6.addActionListener(this);
btnColor7.addActionListener(this);
btnColor8.addActionListener(this);
btnColor9.addActionListener(this);
btnColor10.addActionListener(this);



}
public static void start()
{
ColorThread ct=new ColorThread(btnColor1,btnColor2,btnColor3,btnColor4,btnColor5,btnColor6,btnColor7,btnColor8,btnColor9,btnColor10);

}
public static void reSet()
{
    btnColor1.setEnabled(true);
btnColor2.setEnabled(true);
btnColor2.setEnabled(true);
btnColor3.setEnabled(true);
btnColor4.setEnabled(true);
btnColor5.setEnabled(true);
btnColor6.setEnabled(true);
btnColor7.setEnabled(true);
btnColor8.setEnabled(true);
btnColor9.setEnabled(true);
btnColor10.setEnabled(true);

}
public void actionPerformed(ActionEvent ae) {

Object ob=ae.getSource();

if(ob==btnColor1)
    {
    Mind.play("red");
Mind.varColor=Color.RED;
}
else if(ob==btnColor2)
{
    Mind.play("green");
Mind.varColor=Color.GREEN;
}
else if(ob==btnColor3)
{
    Mind.play("blue");
Mind.varColor=Color.BLUE;
}
else if(ob==btnColor4)
{
    Mind.play("black");
Mind.varColor=Color.BLACK;
}
else if(ob==btnColor5)
{
    Mind.play("magenta");
Mind.varColor=Color.MAGENTA;
}
else if(ob==btnColor6)
{
    Mind.play("orange");
Mind.varColor=Color.ORANGE;
}
else if(ob==btnColor7)
{
Mind.play("yellow");
Mind.varColor=Color.YELLOW;
}
else if(ob==btnColor8)
{
    Mind.play("cyan");
Mind.varColor=Color.CYAN;
}
else if(ob==btnColor9)
{
    Mind.play("gray");
Mind.varColor=Color.GRAY;
}
else if(ob==btnColor10)
{
    Mind.play("pink");
Mind.varColor=Color.PINK;
}



}



}
