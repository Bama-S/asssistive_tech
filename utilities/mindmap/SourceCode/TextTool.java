import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class TextTool extends JPanel implements ActionListener
{
static JButton btnFontname1,btnFontname2,btnFontname3,btnFontname4,btnFontname5,btnFontname6,btnFontstyle1,btnFontstyle2,btnFontstyle3,btnFontsize1,btnFontsize2,btnFontsize3,btnFontsize4,btnFontsize5,btnFontsize6;
JPanel panel1,panel2;
public TextTool()
{
setLayout(new GridLayout(2,1));

panel1=new JPanel(); 
panel2=new JPanel();

java.awt.Font font = new java.awt.Font("Arial",Font.BOLD,24);
btnFontname1=new JButton("Arial");
btnFontname2=new JButton("Britannic");
btnFontname3=new JButton("Courier");
btnFontname4=new JButton("Elephant");
btnFontname5=new JButton("Georgia");
btnFontname6=new JButton("Impact");

btnFontstyle1=new JButton("Plain");
btnFontstyle2=new JButton("Bold");
btnFontstyle3=new JButton("Italic");

btnFontsize1=new JButton("14");
btnFontsize2=new JButton("16");
btnFontsize3=new JButton("18");
btnFontsize4=new JButton("20");
btnFontsize5=new JButton("24");
btnFontsize6=new JButton("28");

font = new java.awt.Font("Arial",Font.BOLD,24);
btnFontname1.setFont(font);
font = new java.awt.Font("Britannic",Font.BOLD,24);
btnFontname2.setFont(font);
font = new java.awt.Font("Courier",Font.BOLD,24);
btnFontname3.setFont(font);
font = new java.awt.Font("Elephant",Font.BOLD,24);
btnFontname4.setFont(font);
font = new java.awt.Font("Georgia",Font.BOLD,24);
btnFontname5.setFont(font);
font = new java.awt.Font("Impact",Font.BOLD,24);
btnFontname6.setFont(font);

font = new java.awt.Font("Arial Black",Font.PLAIN,24);
btnFontstyle1.setFont(font);
font = new java.awt.Font("Arial Black",Font.BOLD,24);
btnFontstyle2.setFont(font);
font = new java.awt.Font("Arial Black",Font.ITALIC,24);
btnFontstyle3.setFont(font);

font = new java.awt.Font("Arial Black",Font.BOLD,14);
btnFontsize1.setFont(font);
font = new java.awt.Font("Arial Black",Font.BOLD,16);
btnFontsize2.setFont(font);
font = new java.awt.Font("Arial Black",Font.BOLD,18);
btnFontsize3.setFont(font);
font = new java.awt.Font("Arial Black",Font.BOLD,20);
btnFontsize4.setFont(font);
font = new java.awt.Font("Arial Black",Font.BOLD,24);
btnFontsize5.setFont(font);
font = new java.awt.Font("Arial Black",Font.BOLD,28);
btnFontsize6.setFont(font);

panel1.setLayout(new GridLayout(1,6));

btnFontname1.setBackground(Mind.btnBackcolor);
btnFontname2.setBackground(Mind.btnBackcolor);
btnFontname3.setBackground(Mind.btnBackcolor);
btnFontname4.setBackground(Mind.btnBackcolor);
btnFontname5.setBackground(Mind.btnBackcolor);
btnFontname6.setBackground(Mind.btnBackcolor);

btnFontname1.setForeground(Mind.btnForecolor);
btnFontname2.setForeground(Mind.btnForecolor);
btnFontname3.setForeground(Mind.btnForecolor);
btnFontname4.setForeground(Mind.btnForecolor);
btnFontname5.setForeground(Mind.btnForecolor);
btnFontname6.setForeground(Mind.btnForecolor);

panel1.add(btnFontname1);
panel1.add(btnFontname2);
panel1.add(btnFontname3);
panel1.add(btnFontname4);
panel1.add(btnFontname5);
panel1.add(btnFontname6);

btnFontname1.addActionListener(this);
btnFontname2.addActionListener(this);
btnFontname3.addActionListener(this);
btnFontname4.addActionListener(this);
btnFontname5.addActionListener(this);
btnFontname6.addActionListener(this);


panel2.setLayout(new GridLayout(1,9));

btnFontstyle1.setBackground(Mind.btnBackcolor);
btnFontstyle2.setBackground(Mind.btnBackcolor);
btnFontstyle3.setBackground(Mind.btnBackcolor);

btnFontsize1.setBackground(Mind.btnBackcolor);
btnFontsize2.setBackground(Mind.btnBackcolor);
btnFontsize3.setBackground(Mind.btnBackcolor);
btnFontsize4.setBackground(Mind.btnBackcolor);
btnFontsize5.setBackground(Mind.btnBackcolor);
btnFontsize6.setBackground(Mind.btnBackcolor);

btnFontstyle1.setForeground(Mind.btnForecolor);
btnFontstyle2.setForeground(Mind.btnForecolor);
btnFontstyle3.setForeground(Mind.btnForecolor);

btnFontsize1.setForeground(Mind.btnForecolor);
btnFontsize2.setForeground(Mind.btnForecolor);
btnFontsize3.setForeground(Mind.btnForecolor);
btnFontsize4.setForeground(Mind.btnForecolor);
btnFontsize5.setForeground(Mind.btnForecolor);
btnFontsize6.setForeground(Mind.btnForecolor);


panel2.add(btnFontstyle1);
panel2.add(btnFontstyle2);
panel2.add(btnFontstyle3);

panel2.add(btnFontsize1);
panel2.add(btnFontsize2);
panel2.add(btnFontsize3);
panel2.add(btnFontsize4);
panel2.add(btnFontsize5);
panel2.add(btnFontsize6);


btnFontstyle1.addActionListener(this);
btnFontstyle2.addActionListener(this);
btnFontstyle3.addActionListener(this);

btnFontsize1.addActionListener(this);
btnFontsize2.addActionListener(this);
btnFontsize3.addActionListener(this);
btnFontsize4.addActionListener(this);
btnFontsize5.addActionListener(this);
btnFontsize6.addActionListener(this);



add(panel1);
add(panel2);

}

public static void start()
{
TextThread tt=new TextThread(btnFontname1,btnFontname2,btnFontname3,btnFontname4,btnFontname5,btnFontname6,btnFontstyle1,btnFontstyle2,btnFontstyle3,btnFontsize1,btnFontsize2,btnFontsize3,btnFontsize4,btnFontsize5,btnFontsize6);

}
public static void reSet()
{
    btnFontname1.setEnabled(true);
btnFontname2.setEnabled(true);
btnFontname2.setEnabled(true);
btnFontname3.setEnabled(true);
btnFontname4.setEnabled(true);
btnFontname5.setEnabled(true);
btnFontname6.setEnabled(true);
btnFontstyle1.setEnabled(true);
btnFontstyle2.setEnabled(true);
btnFontstyle3.setEnabled(true);
btnFontsize1.setEnabled(true);
btnFontsize2.setEnabled(true);
btnFontsize3.setEnabled(true);
btnFontsize3.setEnabled(true);
btnFontsize4.setEnabled(true);
btnFontsize5.setEnabled(true);
btnFontsize6.setEnabled(true);
}
public void actionPerformed(ActionEvent ae) {
String label = ae.getActionCommand();
if(label.equals("Arial")) {
    Mind.play("arial");
Mind.varFontName=btnFontname1.getText();
}

else if(label.equals("Britannic")) {
    Mind.play("britannic");
Mind.varFontName=btnFontname2.getText();
}

else if(label.equals("Courier")) {
    Mind.play("courier");
Mind.varFontName=btnFontname3.getText();
}
else if(label.equals("Elephant")) {
    Mind.play("elephant");
Mind.varFontName=btnFontname4.getText();
}

else if(label.equals("Georgia")) {
    Mind.play("georgia");
Mind.varFontName=btnFontname5.getText();
}

else if(label.equals("Impact")) {
    Mind.play("impact");
Mind.varFontName=btnFontname6.getText();
}

else if(label.equals("Plain")) {
    Mind.play("plain");
Mind.varFontStyle=0;
}

else if(label.equals("Bold")) {
    Mind.play("bold");
Mind.varFontStyle=1;
}

else if(label.equals("Italic")) {
    Mind.play("italic");
Mind.varFontStyle=2;
}

else if(label.equals("14")) {
    Mind.play("14");
Mind.varFontSize=14;
}

else if(label.equals("16")) {
    Mind.play("16");
Mind.varFontSize=16;
}

else if(label.equals("18")) {
    Mind.play("18");
Mind.varFontSize=18;
}

else if(label.equals("20")) {
    Mind.play("20");
Mind.varFontSize=20;
}

else if(label.equals("24")) {
    Mind.play("24");
Mind.varFontSize=24;
}

else if(label.equals("28")) {
    Mind.play("28");
Mind.varFontSize=28;
}



}

}

