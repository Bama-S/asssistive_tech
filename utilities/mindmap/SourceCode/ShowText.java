
import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ShowText extends Dialog implements ActionListener,MouseListener,Runnable {
static JTextArea textArea;
static JButton buttonHome,buttonUp,buttonDown,buttonLeft,buttonRight,buttonEnd,buttonOk;
JPanel panel;
static boolean flag=false;
static Thread th;

public static JScrollPane scrollpane;

 public void mouseClicked(MouseEvent me) {
    }

    public void mouseEntered(MouseEvent me) {
    }

    public void mouseExited(MouseEvent me) {
    }

    public void mousePressed(MouseEvent me) {
       flag=true;
    }

    public void mouseReleased(MouseEvent me) {
    }
    public void run()
{
int i=-1;
int n=0,h=scrollpane.getVerticalScrollBar().getMaximum(),w=scrollpane.getHorizontalScrollBar().getMaximum();
while(true)
{
flag=false;
buttonHome.setEnabled(false);
buttonUp.setEnabled(false);
buttonDown.setEnabled(false);
buttonDown.setEnabled(false);
buttonLeft.setEnabled(false);
buttonRight.setEnabled(false);
buttonEnd.setEnabled(false);
buttonOk.setEnabled(false);






i=(i+1)%7;
if(i==0)
{
    buttonHome.setEnabled(true);
}
if(i==1) {
                buttonUp.setEnabled(true);
            }
else if(i==2) {
                buttonDown.setEnabled(true);
            }
else if(i==3) {
                buttonLeft.setEnabled(true);
            }
else if(i==4) {
                buttonRight.setEnabled(true);
            }
else if(i==5)
{
                buttonEnd.setEnabled(true);
}
else if(i==6) {
                buttonOk.setEnabled(true);
            }


try
{

Thread.sleep(Mind.scanSpeed);
}
catch(Exception e)
{ }

if(flag && i==0)
{
    Mind.play("home");
   scrollpane.getVerticalScrollBar().setValue(0);
 scrollpane.getHorizontalScrollBar().setValue(0);
}
else if(flag && i==1)
{
    Mind.play("moveup");
n=scrollpane.getVerticalScrollBar().getValue();
if((n-50)<=0) {
                    n = 0;
                }
else {
                    n = n - 50;
                }
scrollpane.getVerticalScrollBar().setValue(n);
}
else if(flag && i==2)
{
    Mind.play("movedown");
n=scrollpane.getVerticalScrollBar().getValue();
if((n+50)>=h) {
                    n = h;
                }
else {
                    n = n + 50;
                }
scrollpane.getVerticalScrollBar().setValue(n);
}
else if(flag && i==3)
{
    Mind.play("moveleft");
n=scrollpane.getHorizontalScrollBar().getValue();
if((n-50)<=0) {
                    n = 0;
                }
else {
                    n = n - 50;
                }
scrollpane.getHorizontalScrollBar().setValue(n);
}
else if(flag && i==4)
{
    Mind.play("moveright");
n=scrollpane.getHorizontalScrollBar().getValue();
if((n+50)>=w) {
                    n = w;
                }
else {
                    n = n + 50;
                }
scrollpane.getHorizontalScrollBar().setValue(n);
}
else if(flag && i==5)
{
    Mind.play("end");
   scrollpane.getVerticalScrollBar().setValue(h);
 scrollpane.getHorizontalScrollBar().setValue(w);
}
else if(flag && i==6)
{
    Mind.play("ok");
    dispose();
//    th.destroy();
    break;
}
}


}
   public static void start()
   {
       
       th.start();
   }

   public ShowText(String filename)
{
   super(Mind.Frame,"Text Box", false);
setLayout(new BorderLayout());
ImageIcon icon[] = new ImageIcon[6];
panel=new JPanel();
icon[0]=new ImageIcon("icon\\navigation\\home.png");
icon[1]=new ImageIcon("icon\\navigation\\up.png");
icon[2]=new ImageIcon("icon\\navigation\\down.png");
icon[3]=new ImageIcon("icon\\navigation\\left.png");
icon[4]=new ImageIcon("icon\\navigation\\right.png");
icon[5]=new ImageIcon("icon\\navigation\\end.png");

buttonHome=new JButton(icon[0]);
buttonUp=new JButton(icon[1]);
buttonDown=new JButton(icon[2]);
buttonLeft=new JButton(icon[3]);
buttonRight=new JButton(icon[4]);
buttonEnd=new JButton(icon[5]);
buttonOk=new JButton("OK");
buttonOk.setForeground(Mind.btnForecolor);
buttonOk.setFont(new Font("Elephant",Font.BOLD,24));
buttonHome.setBackground(Mind.btnBackcolor);
buttonUp.setBackground(Mind.btnBackcolor);
buttonDown.setBackground(Mind.btnBackcolor);
buttonLeft.setBackground(Mind.btnBackcolor);
buttonRight.setBackground(Mind.btnBackcolor);
buttonEnd.setBackground(Mind.btnBackcolor);
buttonOk.setBackground(Mind.btnBackcolor);
panel.setLayout(new GridLayout(7,1));
panel.add(buttonHome);
panel.add(buttonUp);
panel.add(buttonDown);
panel.add(buttonLeft);
panel.add(buttonRight);
panel.add(buttonEnd);
panel.add(buttonOk);

buttonHome.addActionListener(this);
buttonUp.addActionListener(this);
buttonDown.addActionListener(this);
buttonLeft.addActionListener(this);
buttonRight.addActionListener(this);
buttonEnd.addActionListener(this);
buttonOk.addActionListener(this);
textArea= new JTextArea();
textArea.setFont(new Font("Elephant",Font.BOLD,14));
Document(filename);
scrollpane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
add(BorderLayout.CENTER,scrollpane);
add(BorderLayout.WEST,panel);
Toolkit kit = Toolkit.getDefaultToolkit();
Dimension screenSize = kit.getScreenSize();
int width=screenSize.width/4*3,height=screenSize.height/4*3;
        try {
            Robot rbt = new Robot();
            rbt.mouseMove(screenSize.width/2,screenSize.height/2);
        } catch (AWTException ex) {
           
        }
setBounds((screenSize.width-width)/2,(screenSize.height-height)/2, width,height);
textArea.addMouseListener(this);
setVisible(true);
th=new Thread(this);
}
    
 public static void Document(String filename)
  {
      textArea.setText("");
       try
      {
     File f=new File("document\\"+filename+".txt");
    FileInputStream fis=new FileInputStream(f);
    Scanner in=new Scanner(fis);
    String str=new String();
    while(in.hasNext())
    {
    str=in.nextLine();

     textArea.append(str.concat("\n"));

    }
     }
 catch(Exception e)
 {
     System.out.println(e);
 }
  }

    public void actionPerformed(ActionEvent e) {
Object ob=e.getSource();
int n=0,h=scrollpane.getVerticalScrollBar().getMaximum(),w=scrollpane.getHorizontalScrollBar().getMaximum();
if(ob==buttonHome)
{
    Mind.play("home");
   scrollpane.getVerticalScrollBar().setValue(0);
 scrollpane.getHorizontalScrollBar().setValue(0);
}
else if(ob==buttonUp)
{
    Mind.play("moveup");
n=scrollpane.getVerticalScrollBar().getValue();
if((n-50)<=0) {
                n = 0;
            }
else {
                n = n - 50;
            }
scrollpane.getVerticalScrollBar().setValue(n);
}
else if(ob==buttonDown)
{
    Mind.play("movedown");
n=scrollpane.getVerticalScrollBar().getValue();
if((n+50)>=h) {
                n =h;
            }
else {
                n = n + 50;
            }
scrollpane.getVerticalScrollBar().setValue(n);
}
else if(ob==buttonLeft)
{
    Mind.play("moveleft");
n=scrollpane.getHorizontalScrollBar().getValue();
if((n-50)<=0) {
                n = 0;
            }
else {
                n = n - 50;
            }
scrollpane.getHorizontalScrollBar().setValue(n);
}
else if(ob==buttonRight)
{
    Mind.play("moveright");
n=scrollpane.getHorizontalScrollBar().getValue();
if((n+50)>=w) {
                n = w;
            }
else {
                n = n + 50;
            }
scrollpane.getHorizontalScrollBar().setValue(n);
}
else if(ob==buttonEnd)
{
    Mind.play("end");
    scrollpane.getVerticalScrollBar().setValue(h);
 scrollpane.getHorizontalScrollBar().setValue(w);
}
else if(ob==buttonOk) {
Mind.play("ok");

dispose();

}
    }
}
