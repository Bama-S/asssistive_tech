import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Save extends JPanel implements ActionListener
{
static JButton buttonSave,buttonOk;

static JTextField tfname;



public Save()
{

setLayout(new GridLayout(3,1));


tfname=new JTextField();
tfname.setColumns(8);
buttonSave=new JButton("Save");

buttonOk=new JButton("OK");




buttonSave.setFont(Mind.btnFont);
buttonOk.setFont(Mind.btnFont);

buttonSave.setForeground(Mind.btnForecolor);
buttonOk.setForeground(Mind.btnForecolor);

buttonSave.setBackground(Mind.btnBackcolor);
buttonOk.setBackground(Mind.btnBackcolor);


tfname.setFont(Mind.btnFont);
tfname.setBackground(Mind.btnBackcolor);
tfname.setForeground(Mind.btnForecolor);

buttonSave.addActionListener(this);
buttonOk.addActionListener(this);

add(tfname);
add(buttonSave);
add(buttonOk);


}
public static void start()
{
new SaveThread(tfname,buttonSave,buttonOk);
}
public static void reSet()
{
    tfname.setEnabled(true);
buttonSave.setEnabled(true);
buttonOk.setEnabled(true);
}
public void actionPerformed (ActionEvent ae) {

String label = ae.getActionCommand();
if(label.equals("Save")) {
    if(tfname.getText().isEmpty())
    {
         Mind.play("filename");
     new ShowDialog("Enter the File Name");
    }
    else
    {
    Mind.play("savefile");
 WriteXMLFile xml=new WriteXMLFile();
xml.write(tfname.getText());   
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