import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class NodeTool extends JPanel implements ActionListener
{
static JButton btnNewnode,btnEditnode,btnRootnode,btnParentnode,btnPreviousnode,btnNextnode,btnChildnode,btnLink,btnOk;
static int n=-1;
Graphics g=null;

 static boolean Parentflag=false,rootflag=false;
public NodeTool()
{


setLayout(new GridLayout(9,1));

btnNewnode=new JButton("New Node");
btnEditnode=new JButton("Edit Node");
btnRootnode=new JButton("Root Node");
btnParentnode=new JButton("Parent Node");
btnPreviousnode=new JButton("Previous Node");
btnNextnode=new JButton("Next Node");
btnChildnode=new JButton("Child Node");
btnLink=new JButton("LINK");
btnOk=new JButton("OK");

btnNewnode.setFont(Mind.btnFont);
btnEditnode.setFont(Mind.btnFont);
btnRootnode.setFont(Mind.btnFont);
btnParentnode.setFont(Mind.btnFont);
btnPreviousnode.setFont(new Font(Mind.btnFont.getFontName(),Mind.btnFont.getStyle(),Mind.btnFont.getSize()-4));
btnNextnode.setFont(Mind.btnFont);
btnChildnode.setFont(Mind.btnFont);
btnLink.setFont(Mind.btnFont);
btnOk.setFont(Mind.btnFont);

btnNewnode.setForeground(Mind.btnForecolor);
btnEditnode.setForeground(Mind.btnForecolor);
btnRootnode.setForeground(Mind.btnForecolor);
btnParentnode.setForeground(Mind.btnForecolor);
btnPreviousnode.setForeground(Mind.btnForecolor);
btnNextnode.setForeground(Mind.btnForecolor);
btnChildnode.setForeground(Mind.btnForecolor);
btnLink.setForeground(Mind.btnForecolor);
btnOk.setForeground(Mind.btnForecolor);

btnNewnode.setBackground(Mind.btnBackcolor);
btnEditnode.setBackground(Mind.btnBackcolor);
btnRootnode.setBackground(Mind.btnBackcolor);
btnParentnode.setBackground(Mind.btnBackcolor);
btnPreviousnode.setBackground(Mind.btnBackcolor);
btnNextnode.setBackground(Mind.btnBackcolor);
btnChildnode.setBackground(Mind.btnBackcolor);
btnLink.setBackground(Mind.btnBackcolor);
btnOk.setBackground(Mind.btnBackcolor);




add(btnNewnode);
add(btnEditnode);
add(btnRootnode);
add(btnParentnode);
add(btnPreviousnode);
add(btnNextnode);
add(btnChildnode);
add(btnLink);
add(btnOk);

btnNewnode.addActionListener(this);
btnEditnode.addActionListener(this);
btnRootnode.addActionListener(this);
btnParentnode.addActionListener(this);
btnPreviousnode.addActionListener(this);
btnNextnode.addActionListener(this);
btnChildnode.addActionListener(this);
btnLink.addActionListener(this);
btnOk.addActionListener(this);


}
public static void start()
{
NodeThread nt=new NodeThread(btnNewnode,btnEditnode,btnRootnode,btnParentnode,btnPreviousnode,btnNextnode,btnChildnode,btnLink,btnOk);

}
public static void reSet()
{
    btnNewnode.setEnabled(true);
btnEditnode.setEnabled(true);
btnEditnode.setEnabled(true);
btnRootnode.setEnabled(true);
btnParentnode.setEnabled(true);
btnParentnode.setEnabled(true);
btnPreviousnode.setEnabled(true);
btnNextnode.setEnabled(true);
btnChildnode.setEnabled(true);
btnLink.setEnabled(true);
btnOk.setEnabled(true);
}
public void actionPerformed(ActionEvent ae) {
String label = ae.getActionCommand();
if(g!=null)
{
g.translate(-100,-100);
Mind.Obj_Drawing.paint(g);
g=null;
}
g=MindDraw.gd.create();
g.translate(100,100);
g.setColor(Color.ORANGE);


if(label.equals("New Node")) {
    Mind.play("newnode");
Mind.westReset();
Mind.Obj_Newnode.setVisible(true);
Mind.containpane.add(BorderLayout.WEST,Mind.Obj_Newnode);
}
else if(label.equals("Edit Node"))
{
    if(!rootflag && Mind.currentNode==null)
    {
        Mind.play("choosenode");
    new ShowDialog("Choose a Node to edit..");
    }
    else
    {
    Mind.play("editnode");
    if(rootflag)
    {
        rootflag=false;
    }
    Mind.currentIndex=n;
        Mind.westReset();
    Mind.Obj_Editnode.setVisible(true);
Mind.containpane.add(BorderLayout.WEST,Mind.Obj_Editnode);
    }
}
else if(label.equals("Root Node")){
    
    if(List.ROOT==null)
    {
        Mind.play("rootnotfound");
     new ShowDialog("Root Node not found..");
    }
    else
    {
    Mind.play("rootnode");
    Mind.currentNode=null;
    rootflag=true;
    fillScan(List.ROOT.x-Mind.ShapeWidth/2,List.ROOT.y);
    }
}
else if(label.equals("Parent Node"))
{
    if(List.N==0)
    {
        Mind.play("parentnotfound");
    new ShowDialog("Parent Node not found..");
    }
    else
    {
   Mind.play("parentnode");
    if(Mind.currentNode!=null)
    {
       toFindParent(Mind.currentNode.nodeId);
         
        if(Mind.currentNode==null)
        {
           Mind.scanNode=List.LIST;
           Mind.parentNode=null;
    Mind.scanIndex=List.index;
   n=0;
        }
        
       
    }
    else
    {
    Mind.scanNode=List.LIST;
    Mind.parentNode=null;
    Mind.scanIndex=List.index;
    n=0;
        }
    
    Mind.currentNode=Mind.scanNode[n];
    fillScan(Mind.scanNode[n].x,Mind.scanNode[n].y);
}
}
else if(label.equals("Previous Node")) {
if(n==-1)
{
    Mind.play("chooseparent");
new ShowDialog("Choose a Parent node..");
}
else
{
Mind.play("previousnode");
n--;
if(n<0) {
                n = Mind.scanIndex-1;
            }
Mind.currentNode=Mind.scanNode[n];
fillScan(Mind.scanNode[n].x,Mind.scanNode[n].y);
}
}
else if(label.equals("Next Node")) {
    if(n==-1)
{
    Mind.play("chooseparent");
new ShowDialog("Choose a Parent node..");
}
else
{
Mind.play("nextnode");
n++;
if(n>Mind.scanIndex-1) {
                n = 0;
            }
Mind.currentNode=Mind.scanNode[n];
fillScan(Mind.scanNode[n].x,Mind.scanNode[n].y);
}
}
else if(label.equals("Child Node")) {
    if(n==-1)
{
    Mind.play("chooseparent");
new ShowDialog("Choose a Parent node..");
}
else
{
    
    if(Mind.scanNode[n].N>0)
    {
        Mind.play("childnode");
        Mind.parentNode=Mind.scanNode[n];
        Mind.scanIndex=Mind.scanNode[n].N;
        Mind.scanNode=Mind.scanNode[n].Child;
       n=0;
        Mind.currentNode=Mind.scanNode[n];
        fillScan(Mind.scanNode[n].x,Mind.scanNode[n].y);
    }
    else
   {
       Mind.play("childnotfound");
       new ShowDialog("Child node not found...");
   }
}
}
else if(label.equals("LINK")) {
    Mind.play("link");
    if(Mind.currentNode!=null)
    {
    new ShowText(Mind.currentNode.linkName);
    }
    else
    {
        new ShowText(List.ROOT.linkName);
    }
    
}
else if(label.equals("OK")) {
Mind.play("ok");

}

}
public  void fillScan(int x,int y)
{
    if(g!=null)
{
g.translate(-100,-100);
Mind.Obj_Drawing.paint(g);
g=null;
}      
    Mind.scrollpane.getHorizontalScrollBar().setValue(x);
Mind.scrollpane.getVerticalScrollBar().setValue(y);
Mind.scrollpane.getHorizontalScrollBar().revalidate();
        Mind.scrollpane.getVerticalScrollBar().revalidate();
  
g=MindDraw.gd.create();
g.translate(100,100);
g.setColor(Color.ORANGE);
g.fillRect(x,y-Mind.ShapeHeight/2, Mind.ShapeWidth, Mind.ShapeHeight);
g.translate(-100,-100);
Mind.flagClearRect=true;
Mind.Obj_Drawing.paint(g);
}
public static void toFindParent(long nodeID){ 
 
    for(int i=0;i<List.index;i++)
    {
        if(List.LIST[i].nodeId==nodeID)
        {
            Mind.currentNode=null;
            break;
          
        }
        if(isMatch(List.LIST[i],nodeID)){
             if(Parentflag)
                {
                        Mind.scanNode=List.LIST;
                    Mind.scanIndex=List.index; 
                    Mind.parentNode=null;
                       n=i;   
                       Parentflag=false;
                }
            break;
        }
       
    }
   
}
public static boolean isMatch(Node temp,long nodeID)
{
   
    for(int i=0;i<temp.N;i++) {
            if (temp.Child[i].nodeId == nodeID) {
                   Parentflag=true;
                    return true;
            }
           
            else  if(isMatch(temp.Child[i],nodeID)) {
                if(Parentflag)
                {
                    Mind.parentNode=temp;
                        Mind.scanNode=temp.Child;
                    Mind.scanIndex=temp.N; 
                       n=i;   
                       Parentflag=false;
                }
                       return true;
                }
           
        }
               
        return false;
}

}
