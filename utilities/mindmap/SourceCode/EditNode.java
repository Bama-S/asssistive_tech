import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class EditNode extends JPanel implements ActionListener
{
static JButton buttonEdit,buttonCut,buttonCopy,buttonPaste,buttonRemove,buttonOk;
static int n=0;

public EditNode()
{


setLayout(new GridLayout(6,1));




buttonEdit=new JButton("Edit");
buttonCut=new JButton("Cut");
buttonCopy=new JButton("Copy");
buttonPaste=new JButton("Paste");
buttonRemove=new JButton("Remove");
buttonOk=new JButton("OK");




buttonEdit.setFont(Mind.btnFont);
buttonCut.setFont(Mind.btnFont);
buttonCopy.setFont(Mind.btnFont);
buttonPaste.setFont(Mind.btnFont);
buttonRemove.setFont(Mind.btnFont);
buttonOk.setFont(Mind.btnFont);


buttonEdit.setForeground(Mind.btnForecolor);
buttonCut.setForeground(Mind.btnForecolor);
buttonCopy.setForeground(Mind.btnForecolor);
buttonPaste.setForeground(Mind.btnForecolor);
buttonRemove.setForeground(Mind.btnForecolor);
buttonOk.setForeground(Mind.btnForecolor);

buttonEdit.setBackground(Mind.btnBackcolor);
buttonCut.setBackground(Mind.btnBackcolor);
buttonCopy.setBackground(Mind.btnBackcolor);
buttonPaste.setBackground(Mind.btnBackcolor);
buttonRemove.setBackground(Mind.btnBackcolor);
buttonOk.setBackground(Mind.btnBackcolor);



add(buttonEdit);
add(buttonCut);
add(buttonCopy);
add(buttonPaste);
add(buttonRemove);
add(buttonOk);



buttonEdit.addActionListener(this);
buttonCut.addActionListener(this);
buttonCopy.addActionListener(this);
buttonPaste.addActionListener(this);
buttonRemove.addActionListener(this);
buttonOk.addActionListener(this);

}
public static void start()
{
EditNodeThread edt=new EditNodeThread(buttonEdit,buttonCut,buttonCopy,buttonPaste,buttonRemove,buttonOk);
}
public static void reSet()
{
   
buttonEdit.setEnabled(true);
buttonCut.setEnabled(true);
buttonCopy.setEnabled(true);
buttonPaste.setEnabled(true);
buttonRemove.setEnabled(true);
buttonOk.setEnabled(true);
}
public void actionPerformed (ActionEvent ae) {

String label = ae.getActionCommand();


 if(label.equals("Edit")) {
 Mind.play("edit");
Mind.flagEditnode=true;

if(Mind.currentNode!=null)
{
NewNode.tfname.setText(Mind.currentNode.nodeName);
Mind.varIconName=Mind.currentNode.iconName;
Mind.varColor=Mind.currentNode.color;
Mind.varFontName=Mind.currentNode.fontName;
Mind.varFontStyle=Mind.currentNode.fontStyle;
Mind.varFontSize=Mind.currentNode.fontSize;
Mind.varShape=Mind.currentNode.shape;
}
else
{
NewNode.tfname.setText(List.ROOT.nodeName);
Mind.varIconName=List.ROOT.iconName;
Mind.varColor=List.ROOT.color;
Mind.varFontName=List.ROOT.fontName;
Mind.varFontStyle=List.ROOT.fontStyle;
Mind.varFontSize=List.ROOT.fontSize;
Mind.varShape=List.ROOT.shape;
}
Mind.westReset();
Mind.Obj_Newnode.setVisible(true);
Mind.containpane.add(BorderLayout.WEST,Mind.Obj_Newnode);

}
else if(label.equals("Cut")) {
Mind.play("cut");
List.cutNode(Mind.parentNode,Mind.currentIndex);
Mind.Obj_Drawing.repaint();
Mind.scanIndex--;
}
else if(label.equals("Copy")) {
    Mind.play("copy");
List.copyNode();
}
else if(label.equals("Paste")) {
Mind.play("paste");
List.pasteNode(Mind.parentNode,Mind.currentIndex);
Mind.Obj_Drawing.repaint();
Mind.scanIndex++;
}
else if(label.equals("Remove")) {
    Mind.play("remove");
List.removeNode(Mind.parentNode,Mind.currentIndex);
Mind.Obj_Drawing.repaint();
Mind.scanIndex--;
}
else if(label.equals("OK")) {
    Mind.play("ok");
Mind.westReset();
Mind.Obj_Nodetool.setVisible(true);
Mind.containpane.add(BorderLayout.WEST,Mind.Obj_Nodetool);

}

}
}