
import java.awt.*;
import javax.swing.*;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;

public class OpenThread implements Runnable
{
JTextField tfName;
JButton buttonOpen,buttonOK;
static String fileName;
static int i;

public OpenThread()
{
}
public OpenThread(JTextField tf,JButton b1,JButton b2)
{
this.tfName=tf;
this.buttonOpen=b1;
this.buttonOK=b2;
Thread th=new Thread(this);
th.start();

}


public void run()
{

i=-1;
while(true)
{

Mind.flagClick=false;
tfName.setEnabled(false);
buttonOpen.setEnabled(false);
buttonOK.setEnabled(false);

i=(i+1)%4;
if(i==0) {
                tfName.setEnabled(true);
            }
else if(i==1)
{
buttonOpen.setEnabled(true);
}

else if(i==2) {
                buttonOK.setEnabled(true);
            }

try
{

Thread.sleep(Mind.scanSpeed);
}
catch(Exception e)
{ }
if(Mind.flagClick && i==0)
{
StringBuffer sb=new StringBuffer();
tfName.setText(sb.toString());
Mind.Obj_Icontool.setVisible(false);
Mind.Obj_Colortool.setVisible(false);
Mind.Obj_Texttool.setVisible(false);
Mind.Obj_Keyboard.setVisible(true);
Mind.containpane.add(BorderLayout.SOUTH,Mind.Obj_Keyboard);

Keyboard.start();
while(Mind.keyChar!='\n') {
                    if (Mind.flagClick && Mind.keyChar != '\n' && Mind.keyChar != '\0') {
                        sb.append(Mind.keyChar);
                        if (Mind.keyChar == '\b') {
                            sb = new StringBuffer();
                        }
                        tfName.setText(sb.toString());
                        Mind.keyChar = '\0';
                    }
                }
if(Mind.keyChar=='\n')
{
Mind.keyChar='\0';
fileName=tfName.getText();
}

}

else if(Mind.flagClick &&i==1 )
{
     if(tfName.getText().isEmpty())
    {
         Mind.play("filename");
     new ShowDialog("Enter the File Name");
    }
    else
    {
    Mind.play("openfile");
 ReadXMLFile xml=new ReadXMLFile();
xml.Read(fileName);  
    }
}

else if(Mind.flagClick && i==2)
{
    Mind.play("ok");
Mind.westReset();
Mind.Obj_Nodetool.setVisible(true);
Mind.containpane.add(BorderLayout.WEST,Mind.Obj_Nodetool);
MenuPanel.start();
break;

}

}
}
}