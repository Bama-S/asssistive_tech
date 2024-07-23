import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class IconTool extends JPanel implements ActionListener
{
static JButton btnIcon1,btnIcon2,btnIcon3,btnIcon4,btnIcon5,btnIcon6,btnIcon7,btnIcon8,btnIcon9,btnIcon10,btnIcon11,btnIcon12,btnIcon13,btnIcon14,btnIcon15,btnIcon16,btnIcon17,btnIcon18,btnIcon19,btnIcon20,btnIcon21,btnIcon22;
public IconTool()
{


setLayout(new GridLayout(2,11));
ImageIcon icon[] = new ImageIcon[22];
for(int i=1;i<=22;i++)
{
icon[i-1]=new ImageIcon("icon\\png\\"+i+".png");
}


btnIcon1=new JButton(icon[0]);
btnIcon2=new JButton(icon[1]);
btnIcon3=new JButton(icon[2]);
btnIcon4=new JButton(icon[3]);
btnIcon5=new JButton(icon[4]);
btnIcon6=new JButton(icon[5]);
btnIcon7=new JButton(icon[6]);
btnIcon8=new JButton(icon[7]);
btnIcon9=new JButton(icon[8]);
btnIcon10=new JButton(icon[9]);
btnIcon11=new JButton(icon[10]);
btnIcon12=new JButton(icon[11]);
btnIcon13=new JButton(icon[12]);
btnIcon14=new JButton(icon[13]);
btnIcon15=new JButton(icon[14]);
btnIcon16=new JButton(icon[15]);
btnIcon17=new JButton(icon[16]);
btnIcon18=new JButton(icon[17]);
btnIcon19=new JButton(icon[18]);
btnIcon20=new JButton(icon[19]);
btnIcon21=new JButton(icon[20]);
btnIcon22=new JButton(icon[21]);

btnIcon1.setBackground(Mind.btnBackcolor);
btnIcon2.setBackground(Mind.btnBackcolor);
btnIcon3.setBackground(Mind.btnBackcolor);
btnIcon4.setBackground(Mind.btnBackcolor);
btnIcon5.setBackground(Mind.btnBackcolor);
btnIcon6.setBackground(Mind.btnBackcolor);
btnIcon7.setBackground(Mind.btnBackcolor);
btnIcon8.setBackground(Mind.btnBackcolor);
btnIcon9.setBackground(Mind.btnBackcolor);
btnIcon10.setBackground(Mind.btnBackcolor);
btnIcon11.setBackground(Mind.btnBackcolor);
btnIcon12.setBackground(Mind.btnBackcolor);
btnIcon13.setBackground(Mind.btnBackcolor);
btnIcon14.setBackground(Mind.btnBackcolor);
btnIcon15.setBackground(Mind.btnBackcolor);
btnIcon16.setBackground(Mind.btnBackcolor);
btnIcon17.setBackground(Mind.btnBackcolor);
btnIcon18.setBackground(Mind.btnBackcolor);
btnIcon19.setBackground(Mind.btnBackcolor);
btnIcon20.setBackground(Mind.btnBackcolor);
btnIcon21.setBackground(Mind.btnBackcolor);
btnIcon22.setBackground(Mind.btnBackcolor);

add(btnIcon1);
add(btnIcon2);
add(btnIcon3);
add(btnIcon4);
add(btnIcon5);
add(btnIcon6);
add(btnIcon7);
add(btnIcon8);
add(btnIcon9);
add(btnIcon10);
add(btnIcon11);
add(btnIcon12);
add(btnIcon13);
add(btnIcon14);
add(btnIcon15);
add(btnIcon16);
add(btnIcon17);
add(btnIcon18);
add(btnIcon19);
add(btnIcon20);
add(btnIcon21);
add(btnIcon22);


btnIcon1.addActionListener(this);
btnIcon2.addActionListener(this);
btnIcon3.addActionListener(this);
btnIcon4.addActionListener(this);
btnIcon5.addActionListener(this);
btnIcon6.addActionListener(this);
btnIcon7.addActionListener(this);
btnIcon8.addActionListener(this);
btnIcon9.addActionListener(this);
btnIcon10.addActionListener(this);
btnIcon11.addActionListener(this);
btnIcon12.addActionListener(this);
btnIcon13.addActionListener(this);
btnIcon14.addActionListener(this);
btnIcon15.addActionListener(this);
btnIcon16.addActionListener(this);
btnIcon17.addActionListener(this);
btnIcon18.addActionListener(this);
btnIcon19.addActionListener(this);
btnIcon20.addActionListener(this);
btnIcon21.addActionListener(this);
btnIcon22.addActionListener(this);

}
public static void start()
{
IconThread ic=new IconThread(btnIcon1,btnIcon2,btnIcon3,btnIcon4,btnIcon5,btnIcon6,btnIcon7,btnIcon8,btnIcon9,btnIcon10,btnIcon11,btnIcon12,btnIcon13,btnIcon14,btnIcon15,btnIcon16,btnIcon17,btnIcon18,btnIcon19,btnIcon20,btnIcon21,btnIcon22);

}
public static void reSet()
{
    btnIcon1.setEnabled(true);
btnIcon2.setEnabled(true);
btnIcon2.setEnabled(true);
btnIcon3.setEnabled(true);
btnIcon4.setEnabled(true);
btnIcon5.setEnabled(true);
btnIcon6.setEnabled(true);
btnIcon7.setEnabled(true);
btnIcon8.setEnabled(true);
btnIcon9.setEnabled(true);
btnIcon10.setEnabled(true);
btnIcon11.setEnabled(true);
btnIcon12.setEnabled(true);
btnIcon12.setEnabled(true);
btnIcon13.setEnabled(true);
btnIcon14.setEnabled(true);
btnIcon15.setEnabled(true);
btnIcon16.setEnabled(true);
btnIcon17.setEnabled(true);
btnIcon18.setEnabled(true);
btnIcon19.setEnabled(true);
btnIcon20.setEnabled(true);
btnIcon21.setEnabled(true);
btnIcon22.setEnabled(true);
}
public void actionPerformed(ActionEvent ae) {

Object ob=ae.getSource();

if(ob==btnIcon1)
{
Mind.varIconName=btnIcon1.getIcon().toString();
}
else if(ob==btnIcon2)
{
Mind.varIconName=btnIcon2.getIcon().toString();

}
else if(ob==btnIcon3)
{
Mind.varIconName=btnIcon3.getIcon().toString();
}
else if(ob==btnIcon4)
{
Mind.varIconName=btnIcon4.getIcon().toString();
}
else if(ob==btnIcon5)
{
Mind.varIconName=btnIcon5.getIcon().toString();
}
else if(ob==btnIcon6)
{
Mind.varIconName=btnIcon6.getIcon().toString();
}
else if(ob==btnIcon7)
{
Mind.varIconName=btnIcon7.getIcon().toString();
}
else if(ob==btnIcon8)
{
Mind.varIconName=btnIcon8.getIcon().toString();
}
else if(ob==btnIcon9)
{
Mind.varIconName=btnIcon9.getIcon().toString();
}
else if(ob==btnIcon10)
{
Mind.varIconName=btnIcon10.getIcon().toString();
}
else if(ob==btnIcon11)
{
Mind.varIconName=btnIcon11.getIcon().toString();
}
else if(ob==btnIcon12)
{
Mind.varIconName=btnIcon12.getIcon().toString();
}
else if(ob==btnIcon13)
{
Mind.varIconName=btnIcon13.getIcon().toString();
}
else if(ob==btnIcon14)
{
Mind.varIconName=btnIcon14.getIcon().toString();
}
else if(ob==btnIcon15)
{
Mind.varIconName=btnIcon15.getIcon().toString();
}
else if(ob==btnIcon16)
{
Mind.varIconName=btnIcon16.getIcon().toString();
}
else if(ob==btnIcon17)
{
Mind.varIconName=btnIcon17.getIcon().toString();
}
else if(ob==btnIcon18)
{
Mind.varIconName=btnIcon18.getIcon().toString();
}
else if(ob==btnIcon19)
{
Mind.varIconName=btnIcon19.getIcon().toString();
}
else if(ob==btnIcon20)
{
Mind.varIconName=btnIcon20.getIcon().toString();
}
else if(ob==btnIcon21)
{
Mind.varIconName=btnIcon21.getIcon().toString();
}
else if(ob==btnIcon22)
{
Mind.varIconName=btnIcon22.getIcon().toString();
}

}

}
