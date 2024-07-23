import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class View extends JPanel implements ActionListener
{
static JButton buttonUp,buttonDown,buttonLeft,buttonRight,buttonOk;
public View()
{
java.awt.Font font = new java.awt.Font("Bookman Old Style",Font.BOLD,32);

setLayout(new GridLayout(5,1));
ImageIcon icon[] = new ImageIcon[4];

icon[0]=new ImageIcon("icon\\Up.png");
icon[1]=new ImageIcon("icon\\Down.png");
icon[2]=new ImageIcon("icon\\Left.png");
icon[3]=new ImageIcon("icon\\Right.png");

buttonUp=new JButton(icon[0]);
buttonDown=new JButton(icon[1]);
buttonLeft=new JButton(icon[2]);
buttonRight=new JButton(icon[3]);
buttonOk=new JButton("OK");
buttonOk.setForeground(Mind.btnForecolor);
buttonOk.setFont(Mind.btnFont);

buttonUp.setBackground(Mind.btnBackcolor);
buttonDown.setBackground(Mind.btnBackcolor); 
buttonLeft.setBackground(Mind.btnBackcolor); 
buttonRight.setBackground(Mind.btnBackcolor); 
buttonOk.setBackground(Mind.btnBackcolor);

add(buttonUp);
add(buttonDown); 
add(buttonLeft); 
add(buttonRight); 
add(buttonOk);

buttonUp.addActionListener(this);
buttonDown.addActionListener(this); 
buttonLeft.addActionListener(this); 
buttonRight.addActionListener(this); 
buttonOk.addActionListener(this);
}
public static void start()
{
ViewThread vt=new ViewThread(buttonUp,buttonDown,buttonLeft,buttonRight,buttonOk);
}
public static void reSet()
{
    buttonUp.setEnabled(true);
buttonDown.setEnabled(true);
buttonDown.setEnabled(true);
buttonLeft.setEnabled(true);
buttonRight.setEnabled(true);
buttonOk.setEnabled(true);
}
public void actionPerformed(ActionEvent ae) {
Object ob=ae.getSource();
int n=0;
if(ob==buttonUp)
{
    Mind.play("moveup");
n=Mind.scrollpane.getVerticalScrollBar().getValue();
if((n-50)<=0) {
                n = 0;
            }
else {
                n = n - 50;
            }
Mind.scrollpane.getVerticalScrollBar().setValue(n);
}
else if(ob==buttonDown)
{
    Mind.play("movedown");
n=Mind.scrollpane.getVerticalScrollBar().getValue();
if((n+50)>=MindDraw.h) {
                n = MindDraw.h;
            }
else {
                n = n + 50;
            }
Mind.scrollpane.getVerticalScrollBar().setValue(n);
}
else if(ob==buttonLeft)
{
    Mind.play("moveleft");
n=Mind.scrollpane.getHorizontalScrollBar().getValue();
if((n-50)<=0) {
                n = 0;
            }
else {
                n = n - 50;
            }
Mind.scrollpane.getHorizontalScrollBar().setValue(n);
}
else if(ob==buttonRight)
{
    Mind.play("moveright");
n=Mind.scrollpane.getHorizontalScrollBar().getValue();
if((n+50)>=MindDraw.w) {
                n = MindDraw.w;
            }
else {
                n = n + 50;
            }
Mind.scrollpane.getHorizontalScrollBar().setValue(n);
}
else if(ob==buttonOk) {
Mind.play("ok");
Mind.westReset();
Mind.Obj_Nodetool.setVisible(true);

Mind.containpane.add(BorderLayout.WEST,Mind.Obj_Nodetool);

}
}

}
