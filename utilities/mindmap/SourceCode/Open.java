import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Open extends JPanel implements ActionListener
{
static JButton buttonOpen,buttonOk;

static JTextField tfname;



public Open()
{

setLayout(new GridLayout(3,1));


tfname=new JTextField();
tfname.setColumns(8);
buttonOpen=new JButton("Open");

buttonOk=new JButton("OK");




buttonOpen.setFont(Mind.btnFont);
buttonOk.setFont(Mind.btnFont);

buttonOpen.setForeground(Mind.btnForecolor);
buttonOk.setForeground(Mind.btnForecolor);

buttonOpen.setBackground(Mind.btnBackcolor);
buttonOk.setBackground(Mind.btnBackcolor);


tfname.setFont(Mind.btnFont);
tfname.setBackground(Mind.btnBackcolor);
tfname.setForeground(Mind.btnForecolor);

buttonOpen.addActionListener(this);
buttonOk.addActionListener(this);

add(tfname);
add(buttonOpen);
add(buttonOk);


}
public static void start()
{
new OpenThread(tfname,buttonOpen,buttonOk);
}
public static void reSet()
{
    tfname.setEnabled(true);
buttonOpen.setEnabled(true);
buttonOk.setEnabled(true);
}
public void actionPerformed (ActionEvent ae) {

String label = ae.getActionCommand();
if(label.equals("Open")) {
    
    if(tfname.getText().isEmpty())
    {
         Mind.play("filename");
     new ShowDialog("Enter the File Name");
    }
    else
    {
        Mind.play("openfile");
 ReadXMLFile xml=new ReadXMLFile();
xml.Read(tfname.getText());
    }
 
}
else if(label.equals("OK")) {
Mind.play("ok");
Mind.westReset();
Mind.Obj_Nodetool.setVisible(true);

Mind.containpane.add(BorderLayout.WEST,Mind.Obj_Nodetool);

}

}
}