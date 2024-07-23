import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.util.logging.Level;
import java.util.logging.Logger;

class ShowDialog extends Dialog implements  MouseListener,Runnable {
    Label lbl;
ShowDialog(String content) {
super(Mind.Frame,"Message Box", false);
Toolkit kit = Toolkit.getDefaultToolkit();
Dimension screenSize = kit.getScreenSize();
int width=screenSize.width/3,height=screenSize.height/4;
        try {
            Robot rbt = new Robot();
            rbt.mouseMove(screenSize.width/2,screenSize.height/2);
        } catch (AWTException ex) {
            Logger.getLogger(ShowDialog.class.getName()).log(Level.SEVERE, null, ex);
        }


setLayout(new GridLayout(1,1));
setBackground(Mind.btnBackcolor);
setForeground(Mind.btnForecolor);
setFont(Mind.btnFont);
setBounds((screenSize.width-width)/2,(screenSize.height-height)/2, width,height);
lbl=new Label(content);
lbl.setBackground(getBackground());
lbl.setAlignment(Label.CENTER);
add(lbl);

addMouseListener(this);
lbl.addMouseListener(this);
setVisible(true);
Thread th=new Thread(this);
th.start();
}
  public void mouseClicked(MouseEvent me) {
    }

    public void mouseEntered(MouseEvent me) {
    }

    public void mouseExited(MouseEvent me) {
    }

    public void mousePressed(MouseEvent me) {
        dispose();
    }

    public void mouseReleased(MouseEvent me) {
    }
    public void run()
    {try
     {
         while(true)
         {
         Thread.sleep(500);
        setBackground(Mind.btnBackcolor);
        lbl.setBackground(getBackground());
        setForeground(Mind.btnForecolor);
        lbl.setForeground(getForeground());
        Thread.sleep(500);
        setBackground(Mind.btnForecolor);
        lbl.setBackground(getBackground());
        setForeground(Mind.btnBackcolor);
        lbl.setForeground(getForeground());
         }
     }
     catch(Exception e)
     {

     }
    }

}