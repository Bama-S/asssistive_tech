import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class MenuPanel extends JPanel implements ActionListener
{
static JButton buttonNew,buttonOpen,buttonSave,buttonSaveAs,buttonNode,buttonView,buttonMode,buttonPrint,buttonSet,buttonExit;
    @SuppressWarnings("empty-statement")
public MenuPanel()
{
setLayout(new GridLayout(1,10));
 
buttonNew= new JButton("New");
buttonOpen= new JButton("Open");
buttonSave= new JButton("Save");
buttonSaveAs= new JButton("Save As");


buttonNode= new JButton("Node");
buttonView= new JButton("View");
buttonMode=new JButton("Mode");
buttonExit= new JButton("Exit");
buttonSet=new JButton("Settings");
buttonPrint=new JButton("Print");
buttonNew.setFont(Mind.btnFont);
buttonOpen.setFont(Mind.btnFont);
buttonSave.setFont(Mind.btnFont);
buttonSaveAs.setFont(new Font(Mind.btnFont.getFontName(),Mind.btnFont.getStyle(),Mind.btnFont.getSize()-4));


buttonNode.setFont(Mind.btnFont);
buttonView.setFont(Mind.btnFont);
buttonMode.setFont(Mind.btnFont);
buttonExit.setFont(Mind.btnFont);
buttonPrint.setFont(Mind.btnFont);
buttonSet.setFont(new Font(Mind.btnFont.getFontName(),Mind.btnFont.getStyle(),Mind.btnFont.getSize()-6));

buttonNew.setForeground(Mind.btnForecolor);
buttonOpen.setForeground(Mind.btnForecolor);
buttonSave.setForeground(Mind.btnForecolor);
buttonSaveAs.setForeground(Mind.btnForecolor);


buttonNode.setForeground(Mind.btnForecolor);
buttonView.setForeground(Mind.btnForecolor);
buttonMode.setForeground(Mind.btnForecolor);
buttonExit.setForeground(Mind.btnForecolor);
buttonPrint.setForeground(Mind.btnForecolor);
buttonSet.setForeground(Mind.btnForecolor);


buttonNew.setBackground(Mind.btnBackcolor);
buttonOpen.setBackground(Mind.btnBackcolor);
buttonSave.setBackground(Mind.btnBackcolor);
buttonSaveAs.setBackground(Mind.btnBackcolor);


buttonNode.setBackground(Mind.btnBackcolor);
buttonView.setBackground(Mind.btnBackcolor);
buttonMode.setBackground(Mind.btnBackcolor);
buttonExit.setBackground(Mind.btnBackcolor);
buttonPrint.setBackground(Mind.btnBackcolor);
buttonSet.setBackground(Mind.btnBackcolor);


buttonNew.addActionListener(this);
buttonOpen.addActionListener(this);
buttonSave.addActionListener(this);
buttonSaveAs.addActionListener(this);


buttonNode.addActionListener(this);
buttonView.addActionListener(this);
buttonMode.addActionListener(this);
buttonExit.addActionListener(this);
buttonPrint.addActionListener(this);
buttonSet.addActionListener(this);

add(buttonNew);
add(buttonOpen);
add(buttonSave);
add(buttonSaveAs);


add(buttonNode);
add(buttonView);
add(buttonMode);
add(buttonExit);
add(buttonSet);
add(buttonPrint);
}

public static void start()
{

MenuThread mt=new MenuThread(buttonNew,buttonOpen,buttonSave,buttonSaveAs,buttonNode,buttonView,buttonMode,buttonExit);
}
public static void reSet()
{
    buttonNew.setEnabled(true);
buttonOpen.setEnabled(true);
buttonOpen.setEnabled(true);
buttonSave.setEnabled(true);
buttonSaveAs.setEnabled(true);
buttonNode.setEnabled(true);
buttonView.setEnabled(true);
buttonMode.setEnabled(true);
buttonExit.setEnabled(true);
}
public void actionPerformed(ActionEvent ae) {
String label = ae.getActionCommand();
if(label.equals("New")) {
    Mind.play("new");
 new List();
    
Mind.Obj_Drawing.repaint();
}
else if(label.equals("Open")) {
Mind.play("open");
 new List();
    Mind.westReset();
Mind.Obj_Open.setVisible(true);
Mind.containpane.add(BorderLayout.WEST,Mind.Obj_Open); 
}
else if(label.equals("Save")) {
    Mind.play("save");
Mind.westReset();
Mind.Obj_Save.setVisible(true);
Mind.containpane.add(BorderLayout.WEST,Mind.Obj_Save);    
}
else if(label.equals("Save As")) {
   Mind.play("saveas");
Mind.westReset();
Mind.Obj_Saveas.setVisible(true);
Mind.containpane.add(BorderLayout.WEST,Mind.Obj_Saveas);

}
else if(label.equals("Node")) {
    Mind.play("node");
Mind.westReset();    
Mind.Obj_Nodetool.setVisible(true);
Mind.containpane.add(BorderLayout.WEST,Mind.Obj_Nodetool);
}
else if(label.equals("View")) {
    Mind.play("view");
Mind.westReset();
Mind.Obj_View.setVisible(true);

Mind.containpane.add(BorderLayout.WEST,Mind.Obj_View);
}
else if(label.equals("Mode")) {
    Mind.play("mode");
Mind.westReset();
Mind.Obj_Mode.setVisible(true);

Mind.containpane.add(BorderLayout.WEST,Mind.Obj_Mode);
}
else if(label.equals("Exit")) {
    Mind.play("exit");
System.exit(0);
}
else if(label.equalsIgnoreCase("Settings"))
{
    new Settings();
}
else if(label.equals("Print"))
{
    new Printer();
}
}



}

