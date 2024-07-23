import java.awt.*;
import java.awt.event.*;
import javax.swing.*;




public class NewNode extends JPanel implements ActionListener
{
static JButton buttonIcon,buttonColor,buttonText,buttonShape,buttonAdd,buttonOk;

static JTextField tfname,tflink;
static int fontStyle,fontSize,shape;
static Color color;
static String nodeName,iconName,fontName,linkName;


public NewNode()
{


setLayout(new GridLayout(8,1));


tfname=new JTextField("");
tflink=new JTextField("");
buttonIcon=new JButton("ICON");
buttonColor=new JButton("COLOR");
buttonAdd=new JButton("ADD");
buttonText=new JButton("FONT");
buttonShape=new JButton("SHAPE");
buttonOk=new JButton("OK");

tfname.setColumns(8);
tflink.setColumns(8);
buttonIcon.setFont(Mind.btnFont);
buttonColor.setFont(Mind.btnFont);
buttonAdd.setFont(Mind.btnFont);
buttonOk.setFont(Mind.btnFont);
buttonText.setFont(Mind.btnFont);
buttonShape.setFont(Mind.btnFont);
tfname.setFont(Mind.btnFont);
tflink.setFont(Mind.btnFont);

buttonIcon.setForeground(Mind.btnForecolor);
buttonColor.setForeground(Mind.btnForecolor);
buttonAdd.setForeground(Mind.btnForecolor);
buttonOk.setForeground(Mind.btnForecolor);
buttonText.setForeground(Mind.btnForecolor);
buttonShape.setForeground(Mind.btnForecolor);
//tfname.setForeground(Mind.btnForecolor);

buttonIcon.setBackground(Mind.btnBackcolor);
buttonColor.setBackground(Mind.btnBackcolor);
buttonAdd.setBackground(Mind.btnBackcolor);
buttonOk.setBackground(Mind.btnBackcolor);
buttonText.setBackground(Mind.btnBackcolor);
buttonShape.setBackground(Mind.btnBackcolor);
//tfname.setBackground(Mind.btnBackcolor);

tfname.setToolTipText("Enter the Node Name");
tflink.setToolTipText("Enter the Link Document Name");
buttonIcon.addActionListener(this);
buttonColor.addActionListener(this);
buttonText.addActionListener(this);
buttonShape.addActionListener(this);
buttonAdd.addActionListener(this);
buttonOk.addActionListener(this);


add(tfname);
add(buttonIcon);
add(buttonColor);
add(buttonText);
add(buttonShape);
add(tflink);
add(buttonAdd);
add(buttonOk);


}
public static void start()
{
new NewNodeThread(tfname,buttonIcon,buttonColor,buttonText,buttonShape,tflink,buttonAdd,buttonOk);
}
public static void reSet()
{
    tfname.setEnabled(true);
    tflink.setEnabled(true);
buttonIcon.setEnabled(true);
buttonColor.setEnabled(true);
buttonText.setEnabled(true);
buttonShape.setEnabled(true);
buttonAdd.setEnabled(true);
buttonOk.setEnabled(true);
}
    @SuppressWarnings("empty-statement")
public void actionPerformed (ActionEvent ae) {

String label = ae.getActionCommand();
 if(label.equals("ICON")) {
Mind.play("icon");

Mind.southReset();
Mind.Obj_Icontool.setVisible(true);
Mind.containpane.add(BorderLayout.SOUTH,Mind.Obj_Icontool);


}

else if(label.equals("COLOR")) {
Mind.play("color");
Mind.southReset();
Mind.Obj_Colortool.setVisible(true);
Mind.containpane.add(BorderLayout.SOUTH,Mind.Obj_Colortool);


}
else if(label.equals("FONT")) {
Mind.play("text");
Mind.southReset();
Mind.Obj_Texttool.setVisible(true);
Mind.containpane.add(BorderLayout.SOUTH,Mind.Obj_Texttool);


}
else if(label.equals("SHAPE"))
{
    Mind.play("shape");
Mind.southReset();
Mind.Obj_Shapetool.setVisible(true);
Mind.containpane.add(BorderLayout.SOUTH,Mind.Obj_Shapetool);
}
else if(label.equals("ADD")) {
    if(tfname.getText().isEmpty())
    {
        Mind.play("nodename");
     new ShowDialog("Enter the Node Name");
         }
    else
    {
    Mind.play("add");
nodeName=tfname.getText();

iconName=Mind.varIconName;
color=Mind.varColor;
fontName=Mind.varFontName;
fontStyle=Mind.varFontStyle;
fontSize=Mind.varFontSize;
shape=Mind.varShape;
linkName=tflink.getText();
if(Mind.flagEditnode)
{
  
    if(Mind.currentNode!=null)
{
    Mind.currentNode.nodeName=nodeName;
Mind.currentNode.iconName=iconName;
Mind.currentNode.color=color;
Mind.currentNode.fontName=fontName;
Mind.currentNode.fontStyle=fontStyle;
Mind.currentNode.fontSize=fontSize;
Mind.currentNode.shape=shape;
Mind.currentNode.linkName=linkName;
    }
    else
    {
        
         List.ROOT.nodeName=nodeName;
List.ROOT.iconName=iconName;
List.ROOT.color=color;
List.ROOT.fontName=fontName;
List.ROOT.fontStyle=fontStyle;
List.ROOT.fontSize=fontSize;
List.ROOT.shape=shape;
List.ROOT.linkName=linkName;
    }
    
}
else if(Mind.currentNode==null)     
{
    List.insertNode(nodeName, iconName, color, fontName, fontStyle, fontSize, shape,linkName);
}
else
{
    List.insertChild(Mind.currentNode,nodeName, iconName, color, fontName, fontStyle, fontSize, shape,linkName);
}

Mind.Obj_Drawing.repaint();
Mind.varIconName=null;
Mind.varColor=null;
Mind.varShape=0;
Mind.varFontSize=0;
    }
}

else if(label.equals("OK")) {
    Mind.play("ok");
if(Mind.flagEditnode)
{
    Mind.flagEditnode=false;
     Mind.westReset();
    Mind.Obj_Editnode.setVisible(true);
Mind.containpane.add(BorderLayout.WEST,Mind.Obj_Editnode);
}    
else
{
Mind.westReset();
Mind.Obj_Nodetool.setVisible(true);
Mind.containpane.add(BorderLayout.WEST,Mind.Obj_Nodetool);
}
}

}
}