
import javax.swing.*;

public class KeyboardThread implements Runnable
{
JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,b17,b18,b19,b20,b21,b22,b23,b24,b25,b26,b27,b28,b29,b30,b31,b32,b33,b34,b35,b36,b37,b38,b39,b40,b41,b42,b43,b44,b45,b46,b47,b48,b49,b50,b51;
int i=-1;
boolean flagCaps=false;
public KeyboardThread()
{
}
public KeyboardThread(JButton b1,JButton b2,JButton b3,JButton b4,JButton b5,JButton b6,JButton b7,JButton b8,JButton b9,JButton b10,JButton b11,JButton b12,JButton b13,JButton b14,JButton b15,JButton b16,JButton b17,JButton b18,JButton b19,JButton b20,JButton b21,JButton b22,JButton b23,JButton b24,JButton b25,JButton b26,JButton b27,JButton b28,JButton b29,JButton b30,JButton b31,JButton b32,JButton b33,JButton b34,JButton b35,JButton b36,JButton b37,JButton b38,JButton b39,JButton b40,JButton b41,JButton b42,JButton b43,JButton b44,JButton b45,JButton b46,JButton b47,JButton b48,JButton b49,JButton b50,JButton b51)
{
this.b1=b1;
this.b2=b2;
this.b3=b3;
this.b4=b4;
this.b5=b5;
this.b6=b6;
this.b7=b7;
this.b8=b8;
this.b9=b9;
this.b10=b10;
this.b11=b11;
this.b12=b12;
this.b13=b13;
this.b14=b14;
this.b15=b15;
this.b16=b16;
this.b17=b17;
this.b18=b18;
this.b19=b19;
this.b20=b20;
this.b21=b21;
this.b22=b22;
this.b23=b23;
this.b24=b24;
this.b25=b25;
this.b26=b26;
this.b27=b27;
this.b28=b28;
this.b29=b29;
this.b30=b30;
this.b31=b31;
this.b32=b32;
this.b33=b33;
this.b34=b34;
this.b35=b35;
this.b36=b36;
this.b37=b37;
this.b38=b38;
this.b39=b39;
this.b40=b40;
this.b41=b41;
this.b42=b42;
this.b43=b43;
this.b44=b44;
this.b45=b45;
this.b46=b46;
this.b47=b47;
this.b48=b48;
this.b49=b49;
this.b50=b50;
this.b51=b51;

Thread th=new Thread(this);
th.start();

}

public void run()
{


b1.setEnabled(false);
b2.setEnabled(false);
b3.setEnabled(false);
b4.setEnabled(false);
b5.setEnabled(false);
b6.setEnabled(false);
b7.setEnabled(false);
b8.setEnabled(false);
b9.setEnabled(false);
b10.setEnabled(false);
b11.setEnabled(false);
b12.setEnabled(false);
b13.setEnabled(false);
b14.setEnabled(false);
b15.setEnabled(false);
b16.setEnabled(false);
b17.setEnabled(false);
b18.setEnabled(false);
b19.setEnabled(false);
b20.setEnabled(false);
b21.setEnabled(false);
b22.setEnabled(false);
b23.setEnabled(false);
b24.setEnabled(false);
b25.setEnabled(false);
b26.setEnabled(false);
b27.setEnabled(false);
b28.setEnabled(false);
b29.setEnabled(false);
b30.setEnabled(false);
b31.setEnabled(false);
b32.setEnabled(false);
b33.setEnabled(false);
b34.setEnabled(false);
b35.setEnabled(false);
b36.setEnabled(false);
b37.setEnabled(false);
b38.setEnabled(false);
b39.setEnabled(false);
b40.setEnabled(false);
b41.setEnabled(false);
b42.setEnabled(false);
b43.setEnabled(false);
b44.setEnabled(false);
b45.setEnabled(false);
b46.setEnabled(false);
b47.setEnabled(false);
b48.setEnabled(false);
b49.setEnabled(false);
b50.setEnabled(false);
b51.setEnabled(false);



Loop1: while(true)
{

Mind.flagClick=false;

b1.setEnabled(false);
b2.setEnabled(false);
b3.setEnabled(false);
b4.setEnabled(false);
b5.setEnabled(false);
b6.setEnabled(false);
b7.setEnabled(false);
b8.setEnabled(false);
b9.setEnabled(false);
b10.setEnabled(false);
b11.setEnabled(false);
b12.setEnabled(false);
b13.setEnabled(false);
b14.setEnabled(false);
b15.setEnabled(false);
b16.setEnabled(false);
b17.setEnabled(false);
b18.setEnabled(false);
b19.setEnabled(false);
b20.setEnabled(false);
b21.setEnabled(false);
b22.setEnabled(false);
b23.setEnabled(false);
b24.setEnabled(false);
b25.setEnabled(false);
b26.setEnabled(false);
b27.setEnabled(false);
b28.setEnabled(false);
b29.setEnabled(false);
b30.setEnabled(false);
b31.setEnabled(false);
b32.setEnabled(false);
b33.setEnabled(false);
b34.setEnabled(false);
b35.setEnabled(false);
b36.setEnabled(false);
b37.setEnabled(false);
b38.setEnabled(false);
b39.setEnabled(false);
b40.setEnabled(false);
b41.setEnabled(false);
b42.setEnabled(false);
b43.setEnabled(false);
b44.setEnabled(false);
b45.setEnabled(false);
b46.setEnabled(false);
b47.setEnabled(false);
b48.setEnabled(false);
b49.setEnabled(false);
b50.setEnabled(false);
b51.setEnabled(false);

i=(i+1)%13;
if(i==0) {
                b1.setEnabled(true);
            }
else if(i==1) {
                b2.setEnabled(true);
            }
else if(i==2) {
                b3.setEnabled(true);
            }
else if(i==3) {
                b4.setEnabled(true);
            }
else if(i==4) {
                b5.setEnabled(true);
            }
else if(i==5) {
                b6.setEnabled(true);
            }
else if(i==6) {
                b7.setEnabled(true);
            }
else if(i==7) {
                b8.setEnabled(true);
            }
else if(i==8) {
                b9.setEnabled(true);
            }
else if(i==9) {
                b10.setEnabled(true);
            }
else if(i==10) {
                b11.setEnabled(true);
            }
else if(i==11) {
                b12.setEnabled(true);
            }
else if(i==12) {
                b13.setEnabled(true);
            }

try
{

Thread.sleep(Mind.scanSpeed);
}
catch(Exception e)
{ }
if(Mind.flagClick && i==1) {
    Mind.play("1");
                Mind.keyChar = '1';
            }
else if(Mind.flagClick && i==2) {
    Mind.play("2");
                Mind.keyChar = '2';
            }

else if(Mind.flagClick && i==3) {
    Mind.play("3");
                Mind.keyChar = '3';
            }

else if(Mind.flagClick && i==4) {
    Mind.play("4");
                Mind.keyChar = '4';
            }

else if(Mind.flagClick && i==5) {
    Mind.play("5");
                Mind.keyChar = '5';
            }

else if(Mind.flagClick && i==6) {
    Mind.play("6");
                Mind.keyChar = '6';
            }

else if(Mind.flagClick && i==7) {
    Mind.play("7");
                Mind.keyChar = '7';
            }

else if(Mind.flagClick && i==8) {
    Mind.play("8");
                Mind.keyChar = '8';
            }

else if(Mind.flagClick && i==9) {
    Mind.play("9");
                Mind.keyChar = '9';
            }

else if(Mind.flagClick && i==10) {
    Mind.play("0");
                Mind.keyChar = '0';
            }
else if(Mind.flagClick && i==11) {
    Mind.play("clear");
                Mind.keyChar = '\b';
            }
else if(Mind.flagClick && i==12)
{
Mind.play("enter");    
Mind.keyChar='\n';
break;
}
else if(Mind.flagClick && i==0)
{
Mind.play("down");    
Mind.flagClick=false;
i=-1;
Loop2: while(true)
{
Mind.flagClick=false;
b1.setEnabled(false);
b2.setEnabled(false);
b3.setEnabled(false);
b4.setEnabled(false);
b5.setEnabled(false);
b6.setEnabled(false);
b7.setEnabled(false);
b8.setEnabled(false);
b9.setEnabled(false);
b10.setEnabled(false);
b11.setEnabled(false);
b12.setEnabled(false);
b13.setEnabled(false);
b14.setEnabled(false);
b15.setEnabled(false);
b16.setEnabled(false);
b17.setEnabled(false);
b18.setEnabled(false);
b19.setEnabled(false);
b20.setEnabled(false);
b21.setEnabled(false);
b22.setEnabled(false);
b23.setEnabled(false);
b24.setEnabled(false);
b25.setEnabled(false);
b26.setEnabled(false);
b27.setEnabled(false);
b28.setEnabled(false);
b29.setEnabled(false);
b30.setEnabled(false);
b31.setEnabled(false);
b32.setEnabled(false);
b33.setEnabled(false);
b34.setEnabled(false);
b35.setEnabled(false);
b36.setEnabled(false);
b37.setEnabled(false);
b38.setEnabled(false);
b39.setEnabled(false);
b40.setEnabled(false);
b41.setEnabled(false);
b42.setEnabled(false);
b43.setEnabled(false);
b44.setEnabled(false);
b45.setEnabled(false);
b46.setEnabled(false);
b47.setEnabled(false);
b48.setEnabled(false);
b49.setEnabled(false);
b50.setEnabled(false);
b51.setEnabled(false);

i=(i+1)%13;
if(i==0) {
                        b14.setEnabled(true);
                    }
else if(i==1) {
                        b15.setEnabled(true);
                    }
else if(i==2) {
                        b16.setEnabled(true);
                    }
else if(i==3) {
                        b17.setEnabled(true);
                    }
else if(i==4) {
                        b18.setEnabled(true);
                    }
else if(i==5) {
                        b19.setEnabled(true);
                    }
else if(i==6) {
                        b20.setEnabled(true);
                    }
else if(i==7) {
                        b21.setEnabled(true);
                    }
else if(i==8) {
                        b22.setEnabled(true);
                    }
else if(i==9) {
                        b23.setEnabled(true);
                    }
else if(i==10) {
                        b24.setEnabled(true);
                    }
else if(i==11) {
                        b25.setEnabled(true);
                    }
else if(i==12) {
                        b26.setEnabled(true);
                    }

try
{

Thread.sleep(Mind.scanSpeed);
}
catch(Exception e)
{ }
if(Mind.flagClick && i==1) {
    Mind.play("q");
                        Mind.keyChar = flagCaps ? 'Q' : 'q';
                    }
else if(Mind.flagClick && i==2) {
    Mind.play("w");
                        Mind.keyChar = flagCaps ? 'W' : 'w';
                    }
else if(Mind.flagClick && i==3) {
    Mind.play("e");
                        Mind.keyChar = flagCaps ? 'E' : 'e';
                    }
else if(Mind.flagClick && i==4) {
    Mind.play("r");
                        Mind.keyChar = flagCaps ? 'R' : 'r';
                    }
else if(Mind.flagClick && i==5) {
    Mind.play("t");
                        Mind.keyChar = flagCaps ? 'T' : 't';
                    }
else if(Mind.flagClick && i==6) {
    Mind.play("y");
                        Mind.keyChar = flagCaps ? 'Y' : 'y';
                    }
else if(Mind.flagClick && i==7) {
    Mind.play("u");
                        Mind.keyChar = flagCaps ? 'U' : 'u';
                    }
else if(Mind.flagClick && i==8) {
    Mind.play("i");
                        Mind.keyChar = flagCaps ? 'I' : 'i';
                    }
else if(Mind.flagClick && i==9) {
    Mind.play("o");
                        Mind.keyChar = flagCaps ? 'O' : 'o';
                    }
else if(Mind.flagClick && i==10) {
    Mind.play("p");
                        Mind.keyChar = flagCaps ? 'P' : 'p';
                    }
else if(Mind.flagClick && i==11) {
    Mind.play("clear");
                        Mind.keyChar = '\b';
                    }
else if(Mind.flagClick && i==12)
{
    Mind.play("up");
i=-1;
Mind.flagClick=false;
break Loop2;
}
else if(Mind.flagClick && i==0)
{
    Mind.play("down");
Mind.flagClick=false;
i=-1;
Loop3: while(true)
{
Mind.flagClick=false;
b1.setEnabled(false);
b2.setEnabled(false);
b3.setEnabled(false);
b4.setEnabled(false);
b5.setEnabled(false);
b6.setEnabled(false);
b7.setEnabled(false);
b8.setEnabled(false);
b9.setEnabled(false);
b10.setEnabled(false);
b11.setEnabled(false);
b12.setEnabled(false);
b13.setEnabled(false);
b14.setEnabled(false);
b15.setEnabled(false);
b16.setEnabled(false);
b17.setEnabled(false);
b18.setEnabled(false);
b19.setEnabled(false);
b20.setEnabled(false);
b21.setEnabled(false);
b22.setEnabled(false);
b23.setEnabled(false);
b24.setEnabled(false);
b25.setEnabled(false);
b26.setEnabled(false);
b27.setEnabled(false);
b28.setEnabled(false);
b29.setEnabled(false);
b30.setEnabled(false);
b31.setEnabled(false);
b32.setEnabled(false);
b33.setEnabled(false);
b34.setEnabled(false);
b35.setEnabled(false);
b36.setEnabled(false);
b37.setEnabled(false);
b38.setEnabled(false);
b39.setEnabled(false);
b40.setEnabled(false);
b41.setEnabled(false);
b42.setEnabled(false);
b43.setEnabled(false);
b44.setEnabled(false);
b45.setEnabled(false);
b46.setEnabled(false);
b47.setEnabled(false);
b48.setEnabled(false);
b49.setEnabled(false);
b50.setEnabled(false);
b51.setEnabled(false);

i=(i+1)%13;
if(i==0) {
                                b27.setEnabled(true);
                            }
else if(i==1) {
                                b28.setEnabled(true);
                            }
else if(i==2) {
                                b29.setEnabled(true);
                            }
else if(i==3) {
                                b30.setEnabled(true);
                            }
else if(i==4) {
                                b31.setEnabled(true);
                            }
else if(i==5) {
                                b32.setEnabled(true);
                            }
else if(i==6) {
                                b33.setEnabled(true);
                            }
else if(i==7) {
                                b34.setEnabled(true);
                            }
else if(i==8) {
                                b35.setEnabled(true);
                            }
else if(i==9) {
                                b36.setEnabled(true);
                            }
else if(i==10) {
                                b37.setEnabled(true);
                            }
else if(i==11) {
                                b38.setEnabled(true);
                            }
else if(i==12) {
                                b39.setEnabled(true);
                            }

try
{

Thread.sleep(Mind.scanSpeed);
}
catch(Exception e)
{ }
if(Mind.flagClick && i==1) {
    Mind.play("caps");
                                flagCaps = flagCaps ? false : true;
                            }
else if(Mind.flagClick && i==2) {
  Mind.play("a");  
                                Mind.keyChar = flagCaps ? 'A' : 'a';
                            }
else if(Mind.flagClick && i==3) {
    Mind.play("s");
                                Mind.keyChar = flagCaps ? 'S' : 's';
                            }
else if(Mind.flagClick && i==4) {
    Mind.play("d");
                                Mind.keyChar = flagCaps ? 'D' : 'd';
                            }
else if(Mind.flagClick && i==5) {
    Mind.play("f");
                                Mind.keyChar = flagCaps ? 'F' : 'f';
                            }
else if(Mind.flagClick && i==6) {
    Mind.play("g");
                                Mind.keyChar = flagCaps ? 'G' : 'g';
                            }
else if(Mind.flagClick && i==7) {
    Mind.play("h");
                                Mind.keyChar = flagCaps ? 'H' : 'h';
                            }
else if(Mind.flagClick && i==8) {
    Mind.play("j");
                                Mind.keyChar = flagCaps ? 'J' : 'j';
                            }
else if(Mind.flagClick && i==9) {
    Mind.play("k");
                                Mind.keyChar = flagCaps ? 'K' : 'k';
                            }
else if(Mind.flagClick && i==10) {
    Mind.play("l");
                                Mind.keyChar = flagCaps ? 'L' : 'l';
                            }

else if(Mind.flagClick && i==11)
{
    Mind.play("enter");
Mind.keyChar='\n';
break Loop1;
}
else if(Mind.flagClick && i==12)
{
    Mind.play("up");
i=-1;
Mind.flagClick=false;
break Loop3;
}

else if(Mind.flagClick && i==0)
{
    Mind.play("down");
Mind.flagClick=false;
i=-1;
Loop4: while(true)
{
Mind.flagClick=false;
b1.setEnabled(false);
b2.setEnabled(false);
b3.setEnabled(false);
b4.setEnabled(false);
b5.setEnabled(false);
b6.setEnabled(false);
b7.setEnabled(false);
b8.setEnabled(false);
b9.setEnabled(false);
b10.setEnabled(false);
b11.setEnabled(false);
b12.setEnabled(false);
b13.setEnabled(false);
b14.setEnabled(false);
b15.setEnabled(false);
b16.setEnabled(false);
b17.setEnabled(false);
b18.setEnabled(false);
b19.setEnabled(false);
b20.setEnabled(false);
b21.setEnabled(false);
b22.setEnabled(false);
b23.setEnabled(false);
b24.setEnabled(false);
b25.setEnabled(false);
b26.setEnabled(false);
b27.setEnabled(false);
b28.setEnabled(false);
b29.setEnabled(false);
b30.setEnabled(false);
b31.setEnabled(false);
b32.setEnabled(false);
b33.setEnabled(false);
b34.setEnabled(false);
b35.setEnabled(false);
b36.setEnabled(false);
b37.setEnabled(false);
b38.setEnabled(false);
b39.setEnabled(false);
b40.setEnabled(false);
b41.setEnabled(false);
b42.setEnabled(false);
b43.setEnabled(false);
b44.setEnabled(false);
b45.setEnabled(false);
b46.setEnabled(false);
b47.setEnabled(false);
b48.setEnabled(false);
b49.setEnabled(false);
b50.setEnabled(false);
b51.setEnabled(false);

i=(i+1)%12;
if(i==0) {
                                        b40.setEnabled(true);
                                    }
else if(i==1) {
                                        b41.setEnabled(true);
                                    }
else if(i==2) {
                                        b42.setEnabled(true);
                                    }
else if(i==3) {
                                        b43.setEnabled(true);
                                    }
else if(i==4) {
                                        b44.setEnabled(true);
                                    }
else if(i==5) {
                                        b45.setEnabled(true);
                                    }
else if(i==6) {
                                        b46.setEnabled(true);
                                    }
else if(i==7) {
                                        b47.setEnabled(true);
                                    }
else if(i==8) {
                                        b48.setEnabled(true);
                                    }
else if(i==9) {
                                        b49.setEnabled(true);
                                    }
else if(i==10) {
                                        b50.setEnabled(true);
                                    }
else if(i==11) {
                                        b51.setEnabled(true);
                                    }

try
{

Thread.sleep(Mind.scanSpeed);
}
catch(Exception e)
{ }
if(Mind.flagClick && i==0) {
    Mind.play("z");
                                        Mind.keyChar = flagCaps ? 'Z' : 'z';
                                    }
else if(Mind.flagClick && i==1) {
    Mind.play("x");
                                        Mind.keyChar = flagCaps ? 'X' : 'x';
                                    }
else if(Mind.flagClick && i==2) {
    Mind.play("c");
                                        Mind.keyChar = flagCaps ? 'C' : 'c';
                                    }
else if(Mind.flagClick && i==3) {
    Mind.play("v");
                                        Mind.keyChar = flagCaps ? 'V' : 'v';
                                    }
else if(Mind.flagClick && i==4) {
    Mind.play("b");
                                        Mind.keyChar = flagCaps ? 'B' : 'b';
                                    }
else if(Mind.flagClick && i==5) {
    Mind.play("n");
                                        Mind.keyChar = flagCaps ? 'N' : 'n';
                                    }
else if(Mind.flagClick && i==6) {
    Mind.play("m");
                                        Mind.keyChar = flagCaps ? 'M' : 'm';
                                    }
else if(Mind.flagClick && i==7) {
    Mind.play("comma");
                                        Mind.keyChar = ',';
                                    }
else if(Mind.flagClick && i==8) {
    Mind.play("dot");
                                        Mind.keyChar = '.';
                                    }
else if(Mind.flagClick && i==9) {
    Mind.play("clear");
                                        Mind.keyChar = '\b';
                                    }
if(Mind.flagClick && i==10)
{
    Mind.play("enter");
Mind.keyChar='\n';
break Loop1;
}
if(Mind.flagClick && i==11)
{
    Mind.play("up");
i=-1;
Mind.flagClick=false;
break Loop4;
}

}
}
}


}

}
}
}


}
}





