import javax.swing.*;

public class ShapeThread implements Runnable
{
JButton buttonRect,buttonEllipse,buttonSquare,buttonCircle,buttonLine;
int i=-1;

public ShapeThread()
{
}
public ShapeThread(JButton b1,JButton b2,JButton b3,JButton b4,JButton b5)
{
this.buttonRect=b1;
this.buttonEllipse=b2;
this.buttonSquare=b3;
this.buttonCircle=b4;
this.buttonLine=b5;


Thread th=new Thread(this);
th.start();
}


public void run()
{
i=-1;
while(true)
{
Mind.flagClick=false;
buttonRect.setEnabled(false);
buttonEllipse.setEnabled(false);
buttonEllipse.setEnabled(false);
buttonSquare.setEnabled(false);
buttonCircle.setEnabled(false);
buttonLine.setEnabled(false);






i=(i+1)%5;
if(i==0) {
                buttonRect.setEnabled(true);
            }
else if(i==1) {
                buttonEllipse.setEnabled(true);
            }
else if(i==2) {
                buttonSquare.setEnabled(true);
            }
else if(i==3) {
                buttonCircle.setEnabled(true);
            }
else if(i==4) {
                buttonLine.setEnabled(true);
            }


try
{

Thread.sleep(Mind.scanSpeed);
}
catch(Exception e)
{ }
if(Mind.flagClick) {
    buttonRect.setEnabled(false);
buttonEllipse.setEnabled(false);
buttonEllipse.setEnabled(false);
buttonSquare.setEnabled(false);
buttonCircle.setEnabled(false);
buttonLine.setEnabled(false);

                break;
            }
}

if(i==0)
{
     Mind.play("rect");
Mind.varShape=1;
}
else if(i==1)
{
     Mind.play("ellipse");
Mind.varShape=2;
}
else if(i==2)
{
     Mind.play("square");
Mind.varShape=3;
}
else if(i==3)
{
     Mind.play("circle");
Mind.varShape=4;
}
else if(i==4)
{
     Mind.play("line");
Mind.varShape=5;
}



}
}