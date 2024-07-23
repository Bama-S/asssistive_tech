
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Mode extends JPanel implements ActionListener
{

static JButton buttonNormal,buttonSlow,buttonMedium,buttonFast;

public Mode()
{
setLayout(new GridLayout(4,1));

buttonNormal=new JButton("NORMAL");
buttonSlow=new JButton("SLOW");
buttonMedium=new JButton("MEDIUM");
buttonFast=new JButton("FAST");


buttonNormal.setFont(Mind.btnFont);
buttonSlow.setFont(Mind.btnFont);
buttonMedium.setFont(Mind.btnFont);
buttonFast.setFont(Mind.btnFont);

buttonNormal.setForeground(Mind.btnForecolor);
buttonSlow.setForeground(Mind.btnForecolor);
buttonMedium.setForeground(Mind.btnForecolor);
buttonFast.setForeground(Mind.btnForecolor);


buttonNormal.setBackground(Mind.btnBackcolor);
buttonSlow.setBackground(Mind.btnBackcolor);
buttonMedium.setBackground(Mind.btnBackcolor);
buttonFast.setBackground(Mind.btnBackcolor);

add(buttonNormal);
add(buttonSlow);
add(buttonMedium); 
add(buttonFast);
buttonNormal.addActionListener(this);
buttonSlow.addActionListener(this);
buttonMedium.addActionListener(this);
buttonFast.addActionListener(this);

//Mode.start();
}
public static void start()
{
ModeThread maint=new ModeThread(buttonNormal,buttonSlow,buttonMedium,buttonFast);
}
public static void reSet()
{
    buttonNormal.setEnabled(true);
buttonSlow.setEnabled(true);
buttonSlow.setEnabled(true);
buttonMedium.setEnabled(true);
buttonFast.setEnabled(true);
}
public void actionPerformed(ActionEvent ae) {
String label = ae.getActionCommand();
if(label.equals("NORMAL"))
{
Mind.flagNormalMode=true;
Mind.play("normal");
ColorTool.reSet();
EditNode.reSet();
IconTool.reSet();
MenuPanel.reSet();
Mode.reSet();
NewNode.reSet();
NodeTool.reSet();
SaveAs.reSet();
ShapeTool.reSet();
TextTool.reSet();
View.reSet();
}
else if(label.equals("SLOW"))
{
Mind.scanSpeed=Mind.scanSlow;
Mind.play("slow");
MenuPanel.start();
}
else if(label.equals("MEDIUM"))
{
Mind.scanSpeed=Mind.scanMedium;
Mind.play("medium");
MenuPanel.start();
}
else if(label.equals("FAST"))
{
Mind.scanSpeed=Mind.scanFast;
Mind.play("fast");
MenuPanel.start();
}
Mind.Obj_Mode.setVisible(false);
Mind.Obj_Nodetool.setVisible(true);
Mind.containpane.add(BorderLayout.WEST,Mind.Obj_Nodetool);
}

}