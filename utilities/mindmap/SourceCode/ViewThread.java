import java.awt.BorderLayout;
import javax.swing.*;

public class ViewThread implements Runnable
{
JButton buttonUp,buttonDown,buttonLeft,buttonRight,buttonOk;
int i=-1;

public ViewThread()
{
}
public ViewThread(JButton b1,JButton b2,JButton b3,JButton b4,JButton b5)
{
this.buttonUp=b1;
this.buttonDown=b2;
this.buttonLeft=b3;
this.buttonRight=b4;
this.buttonOk=b5;


Thread th=new Thread(this);
th.start();
}


public void run()
{
i=-1;
while(true)
{
Mind.flagClick=false;
buttonUp.setEnabled(false);
buttonDown.setEnabled(false);
buttonDown.setEnabled(false);
buttonLeft.setEnabled(false);
buttonRight.setEnabled(false);
buttonOk.setEnabled(false);






i=(i+1)%5;
if(i==0) {
                buttonUp.setEnabled(true);
            }
else if(i==1) {
                buttonDown.setEnabled(true);
            }
else if(i==2) {
                buttonLeft.setEnabled(true);
            }
else if(i==3) {
                buttonRight.setEnabled(true);
            }
else if(i==4) {
                buttonOk.setEnabled(true);
            }


try
{

Thread.sleep(Mind.scanSpeed);
}
catch(Exception e)
{ }

int n=0;
if(Mind.flagClick && i==0)
{
    Mind.play("moveup");
n=Mind.scrollpane.getVerticalScrollBar().getValue();
if((n-50)<=0) {
                    n = 0;
                }
else {
                    n = n - 50;
                }
Mind.scrollpane.getVerticalScrollBar().setValue(n);
}
else if(Mind.flagClick && i==1)
{
    Mind.play("movedown");
n=Mind.scrollpane.getVerticalScrollBar().getValue();
if((n+50)>=MindDraw.h) {
                    n = MindDraw.h;
                }
else {
                    n = n + 50;
                }
Mind.scrollpane.getVerticalScrollBar().setValue(n);
}
else if(Mind.flagClick && i==2)
{
    Mind.play("moveleft");
n=Mind.scrollpane.getHorizontalScrollBar().getValue();
if((n-50)<=0) {
                    n = 0;
                }
else {
                    n = n - 50;
                }
Mind.scrollpane.getHorizontalScrollBar().setValue(n);
}
else if(Mind.flagClick && i==3)
{
    Mind.play("moveright");
n=Mind.scrollpane.getHorizontalScrollBar().getValue();
if((n+50)>=MindDraw.w) {
                    n = MindDraw.w;
                }
else {
                    n = n + 50;
                }
Mind.scrollpane.getHorizontalScrollBar().setValue(n);
}
else if(Mind.flagClick && i==4)
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