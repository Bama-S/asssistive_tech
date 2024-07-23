
import javax.swing.*;

public class IconThread implements Runnable
{
JButton btnIcon1,btnIcon2,btnIcon3,btnIcon4,btnIcon5,btnIcon6,btnIcon7,btnIcon8,btnIcon9,btnIcon10,btnIcon11,btnIcon12,btnIcon13,btnIcon14,btnIcon15,btnIcon16,btnIcon17,btnIcon18,btnIcon19,btnIcon20,btnIcon21,btnIcon22;
int i=-1;

public IconThread()
{
}
public IconThread(JButton b1,JButton b2,JButton b3,JButton b4,JButton b5,JButton b6,JButton b7,JButton b8,JButton b9,JButton b10,JButton b11,JButton b12,JButton b13,JButton b14,JButton b15,JButton b16,JButton b17,JButton b18,JButton b19,JButton b20,JButton b21,JButton b22)
{
this.btnIcon1=b1;
this.btnIcon2=b2;
this.btnIcon3=b3;
this.btnIcon4=b4;
this.btnIcon5=b5;
this.btnIcon6=b6;
this.btnIcon7=b7;
this.btnIcon8=b8;
this.btnIcon9=b9;
this.btnIcon10=b10;
this.btnIcon11=b11;
this.btnIcon12=b12;
this.btnIcon13=b13;
this.btnIcon14=b14;
this.btnIcon15=b15;
this.btnIcon16=b16;
this.btnIcon17=b17;
this.btnIcon18=b18;
this.btnIcon19=b19;
this.btnIcon20=b20;
this.btnIcon21=b21;
this.btnIcon22=b22;
Thread th=new Thread(this);
th.start();
}


public void run()
{
i=-1;
while(true)
{
Mind.flagClick=false;
btnIcon1.setEnabled(false);
btnIcon2.setEnabled(false);
btnIcon2.setEnabled(false);
btnIcon3.setEnabled(false);
btnIcon4.setEnabled(false);
btnIcon5.setEnabled(false);
btnIcon6.setEnabled(false);
btnIcon7.setEnabled(false);
btnIcon8.setEnabled(false);
btnIcon9.setEnabled(false);
btnIcon10.setEnabled(false);
btnIcon11.setEnabled(false);
btnIcon12.setEnabled(false);
btnIcon12.setEnabled(false);
btnIcon13.setEnabled(false);
btnIcon14.setEnabled(false);
btnIcon15.setEnabled(false);
btnIcon16.setEnabled(false);
btnIcon17.setEnabled(false);
btnIcon18.setEnabled(false);
btnIcon19.setEnabled(false);
btnIcon20.setEnabled(false);
btnIcon21.setEnabled(false);
btnIcon22.setEnabled(false);




i=(i+1)%22;
if(i==0) {
                btnIcon1.setEnabled(true);
            }
else if(i==1) {
                btnIcon2.setEnabled(true);
            }
else if(i==2) {
                btnIcon3.setEnabled(true);
            }
else if(i==3) {
                btnIcon4.setEnabled(true);
            }
else if(i==4) {
                btnIcon5.setEnabled(true);
            }
else if(i==5) {
                btnIcon6.setEnabled(true);
            }
else if(i==6) {
                btnIcon7.setEnabled(true);
            }
else if(i==7) {
                btnIcon8.setEnabled(true);
            }
else if(i==8) {
                btnIcon9.setEnabled(true);
            }
else if(i==9) {
                btnIcon10.setEnabled(true);
            }
else if(i==10) {
                btnIcon11.setEnabled(true);
            }
else if(i==11) {
                btnIcon12.setEnabled(true);
            }
else if(i==12) {
                btnIcon13.setEnabled(true);
            }
else if(i==13) {
                btnIcon14.setEnabled(true);
            }
else if(i==14) {
                btnIcon15.setEnabled(true);
            }
else if(i==15) {
                btnIcon16.setEnabled(true);
            }
else if(i==16) {
                btnIcon17.setEnabled(true);
            }
else if(i==17) {
                btnIcon18.setEnabled(true);
            }
else if(i==18) {
                btnIcon19.setEnabled(true);
            }
else if(i==19) {
                btnIcon20.setEnabled(true);
            }
else if(i==20) {
                btnIcon21.setEnabled(true);
            }
else if(i==21) {
                btnIcon22.setEnabled(true);
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
Mind.varIconName=btnIcon1.getIcon().toString();
}
else if(i==1)
{
Mind.varIconName=btnIcon2.getIcon().toString();

}
else if(i==2)
{
Mind.varIconName=btnIcon3.getIcon().toString();
}
else if(i==3)
{
Mind.varIconName=btnIcon4.getIcon().toString();
}
else if(i==4)
{
Mind.varIconName=btnIcon5.getIcon().toString();
}
else if(i==5)
{
Mind.varIconName=btnIcon6.getIcon().toString();
}
else if(i==6)
{
Mind.varIconName=btnIcon7.getIcon().toString();
}
else if(i==7)
{
Mind.varIconName=btnIcon8.getIcon().toString();
}
else if(i==8)
{
Mind.varIconName=btnIcon9.getIcon().toString();
}
else if(i==9)
{
Mind.varIconName=btnIcon10.getIcon().toString();
}
else if(i==10)
{
Mind.varIconName=btnIcon11.getIcon().toString();
}
else if(i==11)
{
Mind.varIconName=btnIcon12.getIcon().toString();
}
else if(i==12)
{
Mind.varIconName=btnIcon13.getIcon().toString();
}
else if(i==13)
{
Mind.varIconName=btnIcon14.getIcon().toString();
}
else if(i==14)
{
Mind.varIconName=btnIcon15.getIcon().toString();
}
else if(i==15)
{
Mind.varIconName=btnIcon16.getIcon().toString();
}
else if(i==16)
{
Mind.varIconName=btnIcon17.getIcon().toString();
}
else if(i==17)
{
Mind.varIconName=btnIcon18.getIcon().toString();
}
else if(i==18)
{
Mind.varIconName=btnIcon19.getIcon().toString();
}
else if(i==19)
{
Mind.varIconName=btnIcon20.getIcon().toString();
}
else if(i==20)
{
Mind.varIconName=btnIcon21.getIcon().toString();
}
else if(i==21)
{
Mind.varIconName=btnIcon22.getIcon().toString();
}


}
}