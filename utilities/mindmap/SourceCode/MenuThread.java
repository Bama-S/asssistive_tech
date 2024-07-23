
import java.awt.*;
import javax.swing.*;

public class MenuThread implements Runnable
{
JButton buttonNew,buttonOpen,buttonSave,buttonSaveAs,buttonNode,buttonView,buttonMode,buttonExit;
int i=-1;

public MenuThread()
{
}
public MenuThread(JButton b1,JButton b2,JButton b3,JButton b4,JButton b5,JButton b6,JButton b7,JButton b8)
{
this.buttonNew=b1;
this.buttonOpen=b2;
this.buttonSave=b3;
this.buttonSaveAs=b4;
this.buttonNode=b5;
this.buttonView=b6;
this.buttonMode=b7;
this.buttonExit=b8;
Thread th=new Thread(this);
th.start();

}


public void run()
{
i=-1;

while(true)
{

Mind.flagClick=false;
buttonNew.setEnabled(false);
buttonOpen.setEnabled(false);
buttonOpen.setEnabled(false);
buttonSave.setEnabled(false);
buttonSaveAs.setEnabled(false);
buttonNode.setEnabled(false);
buttonView.setEnabled(false);
buttonMode.setEnabled(false);
buttonExit.setEnabled(false);


i=(i+1)%8;
if(i==0) {
                buttonNew.setEnabled(true);
            }
else if(i==1) {
                buttonOpen.setEnabled(true);
            }
else if(i==2) {
                buttonSave.setEnabled(true);
            }
else if(i==3) {
                buttonSaveAs.setEnabled(true);
            }
else if(i==4) {
                buttonNode.setEnabled(true);
            }
else if(i==5) {
                buttonView.setEnabled(true);
            }
else if(i==6) {
                buttonMode.setEnabled(true);
            }
else if(i==7) {
                buttonExit.setEnabled(true);
            }

try
{

Thread.sleep(Mind.scanSpeed);
}
catch(Exception e)
{ }

if(Mind.flagClick && i==0)
{
    Mind.play("new");
    new List();
   
Mind.Obj_Drawing.repaint();
}
else if(Mind.flagClick && i==1)
{
    Mind.play("open");
    new List();
    
 Mind.westReset();
Mind.Obj_Open.setVisible(true);
Mind.containpane.add(BorderLayout.WEST,Mind.Obj_Open); 
Open.start();
break;
}
else if(Mind.flagClick && i==2)
{
    Mind.play("save");
    Mind.westReset();
Mind.Obj_Save.setVisible(true);
Mind.containpane.add(BorderLayout.WEST,Mind.Obj_Save);  
Save.start();
break;
}
else if(Mind.flagClick && i==3)
{
    Mind.play("saveas");
Mind.westReset();
Mind.Obj_Saveas.setVisible(true);
Mind.containpane.add(BorderLayout.WEST,Mind.Obj_Saveas);
SaveAs.start();
break;
}
else if(Mind.flagClick && i==4)
{
    Mind.play("node");
    Mind.westReset();
Mind.Obj_Nodetool.setVisible(true);

Mind.containpane.add(BorderLayout.WEST,Mind.Obj_Nodetool);
NodeTool.start();
break;
}
else if(Mind.flagClick && i==5)
{
    Mind.play("view");
Mind.westReset();
Mind.Obj_View.setVisible(true);
Mind.containpane.add(BorderLayout.WEST,Mind.Obj_View);
View.start();
break;
}
else if(Mind.flagClick && i==6)
{
    Mind.play("mode");
Mind.westReset();
Mind.Obj_Mode.setVisible(true);
Mind.containpane.add(BorderLayout.WEST,Mind.Obj_Mode);
Mode.start();
break;
}
else if(Mind.flagClick && i==7)
{
    Mind.play("exit");
    System.exit(0);
}

}
}

}