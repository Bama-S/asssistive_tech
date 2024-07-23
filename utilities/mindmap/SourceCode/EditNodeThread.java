
import java.awt.BorderLayout;
import javax.swing.*;

public class EditNodeThread implements Runnable
{
JButton buttonEdit,buttonCut,buttonCopy,buttonPaste,buttonRemove,buttonOk;
static int n=0,i=-1;

public EditNodeThread()
{
}
public EditNodeThread(JButton b1,JButton b2,JButton b3,JButton b4,JButton b5,JButton b6)
{

this.buttonEdit=b1;
this.buttonCut=b2;
this.buttonCopy=b3;
this.buttonPaste=b4;
this.buttonRemove=b5;
this.buttonOk=b6;

Thread th=new Thread(this);
th.start();

}


public void run()
{
i=-1;


      	 
while(true)
{

Mind.flagClick=false;


buttonEdit.setEnabled(false);
buttonCut.setEnabled(false);

buttonCopy.setEnabled(false);
buttonPaste.setEnabled(false);
buttonRemove.setEnabled(false);
buttonOk.setEnabled(false);

i=(i+1)%6;
  if(i==0) {
                    buttonEdit.setEnabled(true);
                }
else if(i==1) {
                    buttonCut.setEnabled(true);
                }
else if(i==2) {
                    buttonCopy.setEnabled(true);
                }
else if(i==3) {
                    buttonPaste.setEnabled(true);
                }
else if(i==4) {
                    buttonRemove.setEnabled(true);
                }
else if(i==5) {
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
    Mind.play("edit");
Mind.flagEditnode=true;

if(Mind.currentNode!=null)
{
NewNode.tfname.setText(Mind.currentNode.nodeName);
Mind.varIconName=Mind.currentNode.iconName;
Mind.varColor=Mind.currentNode.color;
Mind.varFontName=Mind.currentNode.fontName;
Mind.varFontStyle=Mind.currentNode.fontStyle;
Mind.varFontSize=Mind.currentNode.fontSize;
Mind.varShape=Mind.currentNode.shape;
}
else
{
NewNode.tfname.setText(List.ROOT.nodeName);
Mind.varIconName=List.ROOT.iconName;
Mind.varColor=List.ROOT.color;
Mind.varFontName=List.ROOT.fontName;
Mind.varFontStyle=List.ROOT.fontStyle;
Mind.varFontSize=List.ROOT.fontSize;
Mind.varShape=List.ROOT.shape;
}

Mind.westReset();
Mind.Obj_Newnode.setVisible(true);
Mind.containpane.add(BorderLayout.WEST,Mind.Obj_Newnode);
NewNode.start();
break;
}

else if(Mind.flagClick &&i==1 )
{

   Mind.play("cut");
List.cutNode(Mind.parentNode,Mind.currentIndex);
Mind.Obj_Drawing.repaint();
Mind.scanIndex--;
}
else if(Mind.flagClick && i==2)
{
    Mind.play("copy");
List.copyNode();
}
else if(Mind.flagClick && i==3)
{
    Mind.play("paste");
List.pasteNode(Mind.parentNode,Mind.currentIndex);
Mind.Obj_Drawing.repaint();
Mind.scanIndex++;
}

else if(Mind.flagClick && i==4)
{
    Mind.play("remove");
List.removeNode(Mind.parentNode,Mind.currentIndex);
Mind.Obj_Drawing.repaint();
Mind.scanIndex--;
}

else if(Mind.flagClick && i==5)
{
    Mind.play("ok");
Mind.westReset();
Mind.Obj_Nodetool.setVisible(true);
Mind.containpane.add(BorderLayout.WEST,Mind.Obj_Nodetool);
NodeTool.start();
break;
}


}
}
}
