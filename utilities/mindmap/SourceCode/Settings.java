
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sakthi
 */
public class Settings extends JFrame implements ActionListener {
  public JTabbedPane tabbedPane = new JTabbedPane();
 JFrame f;
 JButton btnload,btninsert,btnsave;
 JTextField tfVertical,tfHorizental,tfslow,tfmedium,tffast,tfWidth,tfHeight,tfname;
 JComboBox cbfname,cbfstyle,cbfsize,cbBackColor,cbForeColor,cbThick,cbpos;
 File file=null;
  public Settings() {
      java.awt.Font font = new java.awt.Font("Dialog",Font.BOLD,18);
     f=new JFrame("Settings");
    f.setLayout (new BorderLayout());
    tabbedPane.setFont(font);
            
            tabbedPane.addTab("Button", null, createButtonPane());
            tabbedPane.addTab("Image", null, createImagePane());
            tabbedPane.addTab("Shape", null, createShapePane());
            tabbedPane.addTab("General", null, createGeneralPane());
    tabbedPane.setSelectedIndex(0);
    f.add (tabbedPane, BorderLayout.CENTER);
    f.setSize(600,500);
    f.setLocation(700,100);
     f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       f.setVisible(true);

  }
  JPanel createImagePane() {
    JPanel p = new JPanel();
    p.setLayout(null);
    java.awt.Font font = new java.awt.Font("Dialog",Font.BOLD,16);
    tfname=new JTextField("");
    cbpos = new JComboBox();
    btnload=new JButton("Load");
    btninsert=new JButton("Insert");
    for(int i=1;i<=22;i++)
    {
        cbpos.addItem(Integer.toString(i));
    }
    cbpos.setFont(font);

    btnload.setFont(font);
    tfname.setEditable(false);
    tfname.setFont(font);
    btninsert.setFont(font);
    btnload.addActionListener(this);
    btninsert.addActionListener(this);
    
    p.add(tfname);
    p.add(btnload);
     p.add(cbpos);
     p.add(btninsert);
    tfname.setBounds(50,150,250,20);
    btnload.setBounds(310,150,80,20);
    cbpos.setBounds(400,150,50,20);
    btninsert.setBounds(460,150,80,20);
    return p;
  }
  JPanel createGeneralPane() {
    JPanel p = new JPanel();
p.setLayout(null);
     java.awt.Font font = new java.awt.Font("Dialog",Font.BOLD,16);
     btnsave=new JButton("Save All Changes");
JLabel lblVertical=new JLabel("Vertical Space Value");
JLabel lblHorizental=new JLabel("Horizental Space Value");
tfVertical=new JTextField("150");
tfHorizental=new JTextField("200");

JLabel lblslow=new JLabel("Scan Mode Slow Value");
JLabel lblmedium=new JLabel("Scan Mode Medium Value");
JLabel lblfast=new JLabel("Scan Mode Fast Value");
tfslow=new JTextField("2000");
tfmedium=new JTextField("1000");
tffast=new JTextField("500");
lblVertical.setFont(font);
tfVertical.setFont(font);
    lblHorizental.setFont(font);
    tfHorizental.setFont(font);
btnsave.setFont(font);

lblslow.setFont(font);
    tfslow.setFont(font);
    lblmedium.setFont(font);
    tfmedium.setFont(font);
    lblfast.setFont(font);
    tffast.setFont(font);

btnsave.addActionListener(this);
    p.add(lblVertical);
    p.add(tfVertical);
    p.add(lblHorizental);
    p.add(tfHorizental);

    p.add(lblslow);
    p.add(tfslow);
    p.add(lblmedium);
    p.add(tfmedium);
    p.add(lblfast);
    p.add(tffast);
    p.add(btnsave);
    lblVertical.setBounds(50,50,300,20);
    tfVertical.setBounds(300,50,50,20);
    lblHorizental.setBounds(50,100, 300,20);
    tfHorizental.setBounds(300,100, 50,20);

    lblslow.setBounds(50,200,300,20);
    tfslow.setBounds(300,200,50,20);
    lblmedium.setBounds(50,250, 300,20);
    tfmedium.setBounds(300,250, 50,20);
    lblfast.setBounds(50,300, 300,20);
    tffast.setBounds(300,300, 50,20);
    btnsave.setBounds(300,350,200,20);
    return p;
  }
   JPanel createButtonPane() {
    String color[]={"RED","GREEN","BLUE","BLACK","MAGENTA","ORANGE","YELLOW","CYAN","GRAY","PINK"};
    String fsize[]={"14","16","18","20","22","24","28","30","32","34","36","38","40","42","44","46","48"};
    
    JPanel p = new JPanel();
p.setLayout(null);
     java.awt.Font font = new java.awt.Font("Dialog",Font.BOLD,16);

JLabel lblBackColor=new JLabel("Background Color");
JLabel lblForeColor=new JLabel("Foreground Color");
JLabel lblfname=new JLabel("Font Name");
JLabel lblfstyle=new JLabel("Font Style");
JLabel lblfsize=new JLabel("Font Size");

 cbBackColor = new JComboBox();
 cbForeColor = new JComboBox();
for(int i=0;i<10;i++)
{
    cbBackColor.addItem(color[i]);
    cbForeColor.addItem(color[i]);
}
cbfname = new JComboBox();
cbfstyle = new JComboBox();
cbfsize = new JComboBox();
GraphicsEnvironment ge =GraphicsEnvironment.getLocalGraphicsEnvironment();
Font fnt[]=ge.getAllFonts();
for(int i=0;i<fnt.length;i++)
{
    cbfname.addItem(fnt[i].getFontName());
}
cbfstyle.addItem("Plain");
cbfstyle.addItem("Bold");
cbfstyle.addItem("Italic");

for(int i=0;i<fsize.length;i++)
{
    cbfsize.addItem(fsize[i]);
}
cbfname.setSelectedItem("Elephant");
cbfstyle.setSelectedItem("Bold");
cbfsize.setSelectedItem("30");
lblfname.setFont(font);
lblfstyle.setFont(font);
lblfsize.setFont(font);

lblBackColor.setFont(font);
cbBackColor.setFont(font);
    lblForeColor.setFont(font);
    cbForeColor.setFont(font);

cbBackColor.setSelectedItem("BLACK");
cbForeColor.setSelectedItem("YELLOW");


    p.add(lblBackColor);
    p.add(cbBackColor);
    p.add(lblForeColor);
    p.add(cbForeColor);
    p.add(lblfname);
    p.add(lblfstyle);
    p.add(lblfsize);
    p.add(cbfname);
    p.add(cbfstyle);
    p.add(cbfsize);

    lblBackColor.setBounds(100,50,300,20);
    cbBackColor.setBounds(300,50,100,20);
    lblForeColor.setBounds(100,100, 300,20);
    cbForeColor.setBounds(300,100, 100,20);

lblfname.setBounds(50,200,200,20);
lblfstyle.setBounds(250,200, 150,20);
lblfsize.setBounds(400,200, 100,20);

cbfname.setBounds(50,250,175,20);
cbfstyle.setBounds(250,250,100,20);
cbfsize.setBounds(400,250,50,20);
    return p;
  }
JPanel createShapePane() {
    String pen[]={"3.0","4.0","5.0","6.0","8.0","10.0","12.0","14.0","16.0","18.0","20.0"};
    JPanel p = new JPanel();
p.setLayout(null);
     java.awt.Font font = new java.awt.Font("Dialog",Font.BOLD,16);
cbThick = new JComboBox();
JLabel lblWidth=new JLabel("Shape Width");
JLabel lblHeight=new JLabel("Shape Height");
JLabel lblThick=new JLabel("Shape Thickness");

tfWidth=new JTextField("120");
tfHeight=new JTextField("80");
for(int i=0;i<pen.length;i++)
{
    cbThick.addItem(pen[i]);
    }
cbThick.setSelectedItem("4.0");

lblWidth.setFont(font);
tfWidth.setFont(font);
    lblHeight.setFont(font);
    tfHeight.setFont(font);
 lblThick.setFont(font);
 cbThick.setFont(font);





    p.add(lblWidth);
    p.add(tfWidth);
    p.add(lblHeight);
    p.add(tfHeight);
    p.add(lblThick);
    p.add(cbThick);

   
    lblWidth.setBounds(150,50,150,20);
    tfWidth.setBounds(300,50,50,20);
    lblHeight.setBounds(150,100, 150,20);
    tfHeight.setBounds(300,100, 50,20);

    lblThick.setBounds(150,200, 150,20);
    cbThick.setBounds(300,200, 75,20);

    return p;
  }
    
    public void actionPerformed(ActionEvent ae) {
       String cmd=ae.getActionCommand();
       if(cmd.equalsIgnoreCase("load"))
       {
           JFileChooser filech=new JFileChooser();
           filech.showOpenDialog(f);
           filech.setVisible(true);
           tfname.setText(filech.getSelectedFile().getName());
           file=filech.getSelectedFile();
       }
       else if(cmd.equalsIgnoreCase("insert"))
       {
           try
           {
            if(file!=null)
            {
                FileInputStream fis=new FileInputStream(file);
                byte buffer[]=new byte[(int)file.length()];
                fis.read(buffer,0,buffer.length);
                fis.close();
                FileOutputStream fos=new FileOutputStream("icon\\png\\"+cbpos.getSelectedItem()+".png");
                fos.write(buffer);
                fos.close();

            }
           }
           catch(Exception e)
           {
           }

       }
       else if(cmd.equalsIgnoreCase("Save All Changes"))
       {
           writeConfig();
          f.setVisible(false);
       }
    }
    public void writeConfig()
    {
        
        try
     {
            FileOutputStream fos=new FileOutputStream("settings.conf");
           PrintStream ps=new PrintStream(fos);
            ps.println(cbBackColor.getSelectedItem());
            ps.println(cbForeColor.getSelectedItem());
            ps.println(cbfname.getSelectedItem());
            ps.println(cbfstyle.getSelectedItem());
            ps.println(cbfsize.getSelectedItem());

            ps.println(tfWidth.getText());
            ps.println(tfHeight.getText());
            ps.println(cbThick.getSelectedItem());

            ps.println(tfVertical.getText());
            ps.println(tfHorizental.getText());
            ps.println(tfslow.getText());
            ps.println(tfmedium.getText());
            ps.println(tffast.getText());
            ps.close();
            fos.close();



     }
        catch(Exception e)
        {

        }

    }

}
