import java.awt.Color;
import javax.swing.*;

public class ColorThread implements Runnable
{
JButton btnColor1,btnColor2,btnColor3,btnColor4,btnColor5,btnColor6,btnColor7,btnColor8,btnColor9,btnColor10;
int i=-1;

public ColorThread()
{
}
public ColorThread(JButton b1,JButton b2,JButton b3,JButton b4,JButton b5,JButton b6,JButton b7,JButton b8,JButton b9,JButton b10)
{
this.btnColor1=b1;
this.btnColor2=b2;
this.btnColor3=b3;
this.btnColor4=b4;
this.btnColor5=b5;
this.btnColor6=b6;
this.btnColor7=b7;
this.btnColor8=b8;
this.btnColor9=b9;
this.btnColor10=b10;


Thread th=new Thread(this);
th.start();
}


public void run()
{
i=-1;
while(true)
{
Mind.flagClick=false;
btnColor1.setEnabled(false);
btnColor2.setEnabled(false);
btnColor2.setEnabled(false);
btnColor3.setEnabled(false);
btnColor4.setEnabled(false);
btnColor5.setEnabled(false);
btnColor6.setEnabled(false);
btnColor7.setEnabled(false);
btnColor8.setEnabled(false);
btnColor9.setEnabled(false);
btnColor10.setEnabled(false);






i=(i+1)%10;
if(i==0) {
                btnColor1.setEnabled(true);
            }
else if(i==1) {
                btnColor2.setEnabled(true);
            }
else if(i==2) {
                btnColor3.setEnabled(true);
            }
else if(i==3) {
                btnColor4.setEnabled(true);
            }
else if(i==4) {
                btnColor5.setEnabled(true);
            }
else if(i==5) {
                btnColor6.setEnabled(true);
            }
else if(i==6) {
                btnColor7.setEnabled(true);
            }
else if(i==7) {
                btnColor8.setEnabled(true);
            }
else if(i==8) {
                btnColor9.setEnabled(true);
            }
else if(i==9) {
                btnColor10.setEnabled(true);
            }

try
{

Thread.sleep(Mind.scanSpeed);
}
catch(Exception e)
{ }
if(Mind.flagClick) {
                break;
            }
}
if(i==0)
{
Mind.play("red");    
Mind.varColor=Color.RED;
}
else if(i==1)
{
    Mind.play("green");
Mind.varColor=Color.GREEN;
}
else if(i==2)
{
Mind.varColor=Color.BLUE;
}
else if(i==3)
{
    Mind.play("black");
Mind.varColor=Color.BLACK;
}
else if(i==4)
{
    Mind.play("magenta");
Mind.varColor=Color.MAGENTA;
}
else if(i==5)
{
    Mind.play("orange");
Mind.varColor=Color.ORANGE;
}
else if(i==6)
{
    Mind.play("yellow");
Mind.varColor=Color.YELLOW;
}
else if(i==7)
{
    Mind.play("cyan");
Mind.varColor=Color.CYAN;
}
else if(i==8)
{
    Mind.play("gray");
Mind.varColor=Color.GRAY;
}
else if(i==9)
{
    Mind.play("pink");
Mind.varColor=Color.PINK;
}



}
}