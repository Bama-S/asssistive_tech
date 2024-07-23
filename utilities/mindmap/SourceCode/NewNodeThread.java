
import java.awt.*;
import javax.swing.*;

public class NewNodeThread  implements Runnable
{
JTextField tfname,tflink;
JButton buttonIcon,buttonColor,buttonText,buttonShape,buttonAdd,buttonOk;
static int i=-1,fontStyle,fontSize,shape;
static Color color;
static String nodeName,iconName,fontName,linkName;


public NewNodeThread()
{
}
public NewNodeThread(JTextField tf,JButton b1,JButton b2,JButton b3,JButton b4,JTextField tfl,JButton b5,JButton b6)
{
this.tfname=tf;
this.buttonIcon=b1;
this.buttonColor=b2;
this.buttonText=b3;
this.buttonShape=b4;
this.buttonAdd=b5;
this.tflink=tfl;
this.buttonOk=b6;
Thread th=new Thread(this);
th.start();

}


    @SuppressWarnings("empty-statement")
public void run()
{
i=-1;

while(true)
{

Mind.flagClick=false;
tfname.setEnabled(false);
buttonIcon.setEnabled(false);
buttonColor.setEnabled(false);
buttonText.setEnabled(false);
buttonShape.setEnabled(false);
tflink.setEnabled(false);
buttonAdd.setEnabled(false);
buttonOk.setEnabled(false);
i=(i+1)%8;
if(i==0) {
                tfname.setEnabled(true);
            }
else if(i==1)
{
buttonIcon.setEnabled(true);
}
else if(i==2) {
                buttonColor.setEnabled(true);
            }
else if(i==3) {
                buttonText.setEnabled(true);
            }
else if(i==4) {
                buttonShape.setEnabled(true);
            }
else if(i==5) {
                tflink.setEnabled(true);
            }
else if(i==6) {
                buttonAdd.setEnabled(true);
            }
else if(i==7) {
                buttonOk.setEnabled(true);
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
tfname.setText(sb.toString());
Mind.southReset();
Mind.Obj_Keyboard.setVisible(true);
Mind.containpane.add(BorderLayout.SOUTH,Mind.Obj_Keyboard);

Keyboard.start();
while(Mind.keyChar!='\n') {
                    if (Mind.flagClick && Mind.keyChar != '\n' && Mind.keyChar != '\0') {
                        sb.append(Mind.keyChar);
                        if (Mind.keyChar == '\b') {
                            sb = new StringBuffer();
                        }
                        tfname.setText(sb.toString());
                        Mind.keyChar = '\0';
                    }
                }
if(Mind.keyChar=='\n')
{
Mind.keyChar='\0';
nodeName=tfname.getText();
}

}

else if(Mind.flagClick &&i==1 )
{
    Mind.play("icon");
Mind.southReset();
Mind.Obj_Icontool.setVisible(true);
Mind.containpane.add(BorderLayout.SOUTH,Mind.Obj_Icontool);
Mind.varIconName=null;
IconTool.start();
while(Mind.varIconName==null);
iconName=Mind.varIconName;
Mind.varIconName=null;

}
else if(Mind.flagClick && i==2)
{
    Mind.play("color");
Mind.southReset();
Mind.Obj_Colortool.setVisible(true);
Mind.containpane.add(BorderLayout.SOUTH,Mind.Obj_Colortool);
Mind.varColor=null;
ColorTool.start();
while(Mind.varColor==null);
color=Mind.varColor;
Mind.varColor=null;
}
else if(Mind.flagClick && i==3)
{
    Mind.play("text");
Mind.southReset();
Mind.Obj_Texttool.setVisible(true);
Mind.containpane.add(BorderLayout.SOUTH,Mind.Obj_Texttool);
Mind.varFontSize=0;
TextTool.start();
while(Mind.varFontSize==0);
fontName=Mind.varFontName;
fontStyle=Mind.varFontStyle;
fontSize=Mind.varFontSize;
Mind.varFontSize=0;

}
else if(Mind.flagClick && i==4)
{
    Mind.play("shape");
Mind.southReset();
Mind.Obj_Shapetool.setVisible(true);
Mind.containpane.add(BorderLayout.SOUTH,Mind.Obj_Shapetool);
Mind.varShape=0;
ShapeTool.start();
while(Mind.varShape==0);
shape=Mind.varShape;
Mind.varShape=0;
}
else if(Mind.flagClick && i==5)
{
    StringBuffer sb=new StringBuffer();
tflink.setText(sb.toString());
Mind.southReset();
Mind.Obj_Keyboard.setVisible(true);
Mind.containpane.add(BorderLayout.SOUTH,Mind.Obj_Keyboard);

Keyboard.start();
while(Mind.keyChar!='\n') {
                    if (Mind.flagClick && Mind.keyChar != '\n' && Mind.keyChar != '\0') {
                        sb.append(Mind.keyChar);
                        if (Mind.keyChar == '\b') {
                            sb = new StringBuffer();
                        }
                        tflink.setText(sb.toString());
                        Mind.keyChar = '\0';
                    }
                }
if(Mind.keyChar=='\n')
{
Mind.keyChar='\0';
linkName=tflink.getText();
}
}
else if(Mind.flagClick && i==6)
{
  
nodeName=tfname.getText();
linkName=tflink.getText();

if(nodeName.isEmpty())
{
        Mind.play("nodename");
     new ShowDialog("Enter the Node Name");
    }
else
{
      Mind.play("add");
if(Mind.flagEditnode)
{
  
   if(Mind.currentNode!=null)
{
    Mind.currentNode.nodeName=nodeName;
Mind.currentNode.iconName=iconName;
Mind.currentNode.color=color;
Mind.currentNode.fontName=fontName;
Mind.currentNode.fontStyle=fontStyle;
Mind.currentNode.fontSize=fontSize;
Mind.currentNode.shape=shape;
Mind.currentNode.linkName=linkName;
    }
    else
    {
        
         List.ROOT.nodeName=nodeName;
List.ROOT.iconName=iconName;
List.ROOT.color=color;
List.ROOT.fontName=fontName;
List.ROOT.fontStyle=fontStyle;
List.ROOT.fontSize=fontSize;
List.ROOT.shape=shape;
List.ROOT.linkName=linkName;
    }
}
else if(Mind.currentNode==null)     
{
    List.insertNode(nodeName, iconName, color, fontName, fontStyle, fontSize, shape,linkName);
}
else
{
    List.insertChild(Mind.currentNode,nodeName, iconName, color, fontName, fontStyle, fontSize, shape,linkName);
}


Mind.Obj_Drawing.repaint();
iconName=null;
color=null;
shape=0;
fontSize=0;
}
}
else if(Mind.flagClick && i==7)
{
    Mind.play("ok");
if(Mind.flagEditnode)
{
    Mind.flagEditnode=false;
     Mind.westReset();
    Mind.Obj_Editnode.setVisible(true);
Mind.containpane.add(BorderLayout.WEST,Mind.Obj_Editnode);
EditNode.start();
break;
}    
else
{
Mind.westReset();
Mind.Obj_Nodetool.setVisible(true);
Mind.containpane.add(BorderLayout.WEST,Mind.Obj_Nodetool);
NodeTool.start();
break;
}
}
}
}
}