
import java.awt.*;
import javax.swing.*;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;

public class SaveAsThread implements Runnable
{
JTextField tfName;
JButton buttonSave,buttonJPG,buttonOK;
static String fileName;
static int i;
 BufferedImage offscreenImage;
public SaveAsThread()
{
}
public SaveAsThread(JTextField tf,JButton b1,JButton b2,JButton b3)
{
this.tfName=tf;
this.buttonSave=b1;
this.buttonJPG=b2;
this.buttonOK=b3;
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
buttonSave.setEnabled(false);
buttonJPG.setEnabled(false);
buttonOK.setEnabled(false);

i=(i+1)%4;
if(i==0) {
                tfName.setEnabled(true);
            }
else if(i==1)
{
buttonSave.setEnabled(true);
}
else if(i==2) {
                buttonJPG.setEnabled(true);
            }
else if(i==3) {
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
    Mind.play("png");
try {


fileName=tfName.getText();
File file = new File("output\\"+fileName+".png");

offscreenImage=new BufferedImage(MindDraw.w+Mind.HSPACE,MindDraw.h+Mind.HSPACE, BufferedImage.TYPE_INT_ARGB);

Graphics g=offscreenImage.createGraphics();
g.setColor(Color.WHITE);
g.fillRect(0,0,MindDraw.w+Mind.HSPACE,MindDraw.h+Mind.HSPACE);
Mind.flagClearRect=true;
Mind.Obj_Drawing.paint(g);
ImageIO.write(offscreenImage,"png", file);


 }
            catch (Exception e)
{  }

    }

}
else if(Mind.flagClick && i==2)
{
    if(tfName.getText().isEmpty())
    {
         Mind.play("filename");
     new ShowDialog("Enter the File Name");
    }
    else
    {
    Mind.play("jpg");
try {


fileName=tfName.getText();
File file = new File("output\\"+fileName+".jpg");

offscreenImage=new BufferedImage(MindDraw.w+Mind.HSPACE,MindDraw.h+Mind.HSPACE, BufferedImage.TYPE_INT_RGB);

Graphics g=offscreenImage.createGraphics();
g.setColor(Color.WHITE);
g.fillRect(0,0,MindDraw.w+Mind.HSPACE,MindDraw.h+Mind.HSPACE);
Mind.flagClearRect=true;
Mind.Obj_Drawing.paint(g);


ImageIO.write(offscreenImage,"jpg", file);
 }
            catch (Exception e)
{  }
    }
}
else if(Mind.flagClick && i==3)
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