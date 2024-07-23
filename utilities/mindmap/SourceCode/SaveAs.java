import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;


public class SaveAs extends JPanel implements ActionListener
{
static JButton buttonPNG,buttonJPG,buttonOk;

static JTextField tfname;
static String fileName;
BufferedImage offscreenImage;

public SaveAs()
{

setLayout(new GridLayout(4,1));


tfname=new JTextField();
buttonPNG=new JButton("PNG File");
buttonJPG=new JButton("JPEG File");
buttonOk=new JButton("OK");




buttonPNG.setFont(Mind.btnFont);
buttonJPG.setFont(Mind.btnFont);
buttonOk.setFont(Mind.btnFont);

buttonPNG.setForeground(Mind.btnForecolor);
buttonJPG.setForeground(Mind.btnForecolor);
buttonOk.setForeground(Mind.btnForecolor);

buttonPNG.setBackground(Mind.btnBackcolor);
buttonJPG.setBackground(Mind.btnBackcolor);
buttonOk.setBackground(Mind.btnBackcolor);


tfname.setFont(Mind.btnFont);
tfname.setBackground(Mind.btnBackcolor);
tfname.setForeground(Mind.btnForecolor);

buttonPNG.addActionListener(this);
buttonJPG.addActionListener(this);
buttonOk.addActionListener(this);

add(tfname);
add(buttonPNG);
add(buttonJPG);
add(buttonOk);


}
public static void start()
{
new SaveAsThread(tfname,buttonPNG,buttonJPG,buttonOk);
}
public static void reSet()
{
    tfname.setEnabled(true);
buttonPNG.setEnabled(true);
buttonJPG.setEnabled(true);
buttonOk.setEnabled(true);
}
public void actionPerformed (ActionEvent ae) {

String label = ae.getActionCommand();
if(label.equals("PNG File")) {
    if(tfname.getText().isEmpty())
    {
         Mind.play("filename");
     new ShowDialog("Enter the File Name");
    }
    else
    {
   Mind.play("png");
 try { 


fileName=tfname.getText();
File file = new File("output\\"+fileName+".png");

offscreenImage=new BufferedImage(MindDraw.w+Mind.HSPACE,MindDraw.h+Mind.HSPACE, BufferedImage.TYPE_INT_ARGB);

Graphics g=offscreenImage.createGraphics();
g.setColor(Color.WHITE);
g.fillRect(0,0,MindDraw.w+Mind.HSPACE,MindDraw.h+Mind.HSPACE);
Mind.flagClearRect=true;
Mind.Obj_Drawing.paint(g); 
ImageIO.write(offscreenImage,"png", file); 


 }
            catch (IOException e)
{  }



}
}
else if(label.equals("JPEG File")) {
    if(tfname.getText().isEmpty())
    {
         Mind.play("filename");
     new ShowDialog("Enter the File Name");
    }
    else
    {
Mind.play("jpg");
try { 

 
fileName=tfname.getText();
File file = new File("output\\"+fileName+".jpg");

offscreenImage=new BufferedImage(MindDraw.w+Mind.HSPACE,MindDraw.h+Mind.HSPACE, BufferedImage.TYPE_INT_RGB);

Graphics g=offscreenImage.createGraphics();
g.setColor(Color.WHITE);
g.fillRect(0,0,MindDraw.w+Mind.HSPACE,MindDraw.h+Mind.HSPACE);
Mind.flagClearRect=true;
Mind.Obj_Drawing.paint(g); 


ImageIO.write(offscreenImage,"jpg", file); 
 }
            catch (IOException e)
{  }

    }

}

else if(label.equals("OK")) {
Mind.play("ok");
Mind.westReset();
Mind.Obj_Nodetool.setVisible(true);

Mind.containpane.add(BorderLayout.WEST,Mind.Obj_Nodetool);

}

}
}