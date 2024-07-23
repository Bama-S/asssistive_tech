

import java.awt.*;
import javax.swing.*;

public class ModeThread implements Runnable
{
JButton buttonNormal,buttonSlow,buttonMedium,buttonFast;
int i=-1;




public ModeThread(JButton jb1,JButton jb2,JButton jb3,JButton jb4)
{

this.buttonNormal=jb1;
this.buttonSlow=jb2;
this.buttonMedium=jb3;
this.buttonFast=jb4;

Thread th=new Thread(this);
th.start();

}


public void run()
{
    i=-1;
while(true)
{
Mind.flagClick=false;
buttonNormal.setEnabled(false);
buttonSlow.setEnabled(false);
buttonSlow.setEnabled(false);
buttonMedium.setEnabled(false);
buttonFast.setEnabled(false);

i=(i+1)%4;
if(i==0)
{
buttonNormal.setEnabled(true);
}
else if(i==1) {
                buttonSlow.setEnabled(true);
            }
else if(i==2) {
                buttonMedium.setEnabled(true);
            }
else {
                buttonFast.setEnabled(true);
            }
try
{

Thread.sleep(1000);
}
catch(Exception e)
{ }
if(Mind.flagClick) {
                break;
            }
}
if(i==0)
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
else if(i==1)
{
Mind.scanSpeed=Mind.scanSlow;
Mind.play("slow");
MenuPanel.start();
}
else if(i==2)
{
Mind.scanSpeed=Mind.scanMedium;
Mind.play("medium");
MenuPanel.start();
}
else if(i==3)
{
Mind.scanSpeed=Mind.scanFast;
Mind.play("fast");
MenuPanel.start();
}

Mind.Obj_Menupanel.setVisible(true);
Mind.Obj_Nodetool.setVisible(true);

Mind.Obj_Newnode.setVisible(false);
Mind.Obj_Mode.setVisible(false);
Mind.Obj_View.setVisible(false);
Mind.Obj_Saveas.setVisible(false);
Mind.containpane.add(BorderLayout.WEST,Mind.Obj_Nodetool);
}
}