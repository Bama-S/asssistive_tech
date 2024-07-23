
import javax.swing.*;

public class TextThread implements Runnable
{
JButton btnFontname1,btnFontname2,btnFontname3,btnFontname4,btnFontname5,btnFontname6,btnFontstyle1,btnFontstyle2,btnFontstyle3,btnFontsize1,btnFontsize2,btnFontsize3,btnFontsize4,btnFontsize5,btnFontsize6;
int i=-1;

public TextThread()
{
}
public TextThread(JButton b1,JButton b2,JButton b3,JButton b4,JButton b5,JButton b6,JButton b7,JButton b8,JButton b9,JButton b10,JButton b11,JButton b12,JButton b13,JButton b14,JButton b15)
{
this.btnFontname1=b1;
this.btnFontname2=b2;
this.btnFontname3=b3;
this.btnFontname4=b4;
this.btnFontname5=b5;
this.btnFontname6=b6;
this.btnFontstyle1=b7;
this.btnFontstyle2=b8;
this.btnFontstyle3=b9;
this.btnFontsize1=b10;
this.btnFontsize2=b11;
this.btnFontsize3=b12;
this.btnFontsize4=b13;
this.btnFontsize5=b14;
this.btnFontsize6=b15;

Thread th=new Thread(this);
th.start();
}


public void run()
{
i=-1;
while(true)
{

Mind.flagClick=false;
btnFontname1.setEnabled(false);
btnFontname2.setEnabled(false);
btnFontname2.setEnabled(false);
btnFontname3.setEnabled(false);
btnFontname4.setEnabled(false);
btnFontname5.setEnabled(false);
btnFontname6.setEnabled(false);
btnFontstyle1.setEnabled(false);
btnFontstyle2.setEnabled(false);
btnFontstyle3.setEnabled(false);
btnFontsize1.setEnabled(false);
btnFontsize2.setEnabled(false);
btnFontsize3.setEnabled(false);
btnFontsize3.setEnabled(false);
btnFontsize4.setEnabled(false);
btnFontsize5.setEnabled(false);
btnFontsize6.setEnabled(false);





i=(i+1)%6;
if(i==0) {
                btnFontname1.setEnabled(true);
            }
else if(i==1) {
                btnFontname2.setEnabled(true);
            }
else if(i==2) {
                btnFontname3.setEnabled(true);
            }
else if(i==3) {
                btnFontname4.setEnabled(true);
            }
else if(i==4) {
                btnFontname5.setEnabled(true);
            }
else if(i==5) {
                btnFontname6.setEnabled(true);
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
 Mind.play("arial");    
Mind.varFontName=btnFontname1.getText();
}
else if(i==1)
{
     Mind.play("britannic");
Mind.varFontName=btnFontname2.getText();
}
else if(i==2)
{

     Mind.play("courier");
Mind.varFontName=btnFontname3.getText();
}
else if(i==3)
{
    
    Mind.play("elephant");
Mind.varFontName=btnFontname4.getText();
}
else if(i==4)
{
    
    Mind.play("georgia");
Mind.varFontName=btnFontname5.getText();
}
else if(i==5)
{
    
     Mind.play("impact");
Mind.varFontName=btnFontname6.getText();
}
i=-1;
while(true)
{
Mind.flagClick=false;
btnFontname1.setEnabled(false);
btnFontname2.setEnabled(false);
btnFontname2.setEnabled(false);
btnFontname3.setEnabled(false);
btnFontname4.setEnabled(false);
btnFontname5.setEnabled(false);
btnFontname6.setEnabled(false);
btnFontstyle1.setEnabled(false);
btnFontstyle2.setEnabled(false);
btnFontstyle3.setEnabled(false);
btnFontsize1.setEnabled(false);
btnFontsize2.setEnabled(false);
btnFontsize3.setEnabled(false);
btnFontsize3.setEnabled(false);
btnFontsize4.setEnabled(false);
btnFontsize5.setEnabled(false);
btnFontsize6.setEnabled(false);
i=(i+1)%3;
if(i==0) {
                btnFontstyle1.setEnabled(true);
            }
else if(i==1) {
                btnFontstyle2.setEnabled(true);
            }
else if(i==2) {
                btnFontstyle3.setEnabled(true);
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
         Mind.play("plain");
Mind.varFontStyle=0;
}
else if(i==1)
{
    Mind.play("bold");
Mind.varFontStyle=1;
}
else if(i==2)
{
    Mind.play("italic");
Mind.varFontStyle=2;
}

i=-1;
while(true)
{
Mind.flagClick=false;
btnFontname1.setEnabled(false);
btnFontname2.setEnabled(false);
btnFontname2.setEnabled(false);
btnFontname3.setEnabled(false);
btnFontname4.setEnabled(false);
btnFontname5.setEnabled(false);
btnFontname6.setEnabled(false);
btnFontstyle1.setEnabled(false);
btnFontstyle2.setEnabled(false);
btnFontstyle3.setEnabled(false);
btnFontsize1.setEnabled(false);
btnFontsize2.setEnabled(false);
btnFontsize3.setEnabled(false);
btnFontsize3.setEnabled(false);
btnFontsize4.setEnabled(false);
btnFontsize5.setEnabled(false);
btnFontsize6.setEnabled(false);
i=(i+1)%6;

if(i==0) {
                btnFontsize1.setEnabled(true);
            }
else if(i==1) {
                btnFontsize2.setEnabled(true);
            }
else if(i==2) {
                btnFontsize3.setEnabled(true);
            }
else if(i==3) {
                btnFontsize4.setEnabled(true);
            }
else if(i==4) {
                btnFontsize5.setEnabled(true);
            }
else if(i==5) {
                btnFontsize6.setEnabled(true);
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
    Mind.play("14");
Mind.varFontSize=14;
}
else if(i==1)
{
    Mind.play("16");
Mind.varFontSize=16;

}
else if(i==2)
{
    Mind.play("18");
Mind.varFontSize=18;
}
else if(i==3)
{
    Mind.play("20");
Mind.varFontSize=20;
}
else if(i==4)
{
    Mind.play("24");
Mind.varFontSize=24;
}
else if(i==5)
{
    Mind.play("28");
Mind.varFontSize=28;
}


}
}