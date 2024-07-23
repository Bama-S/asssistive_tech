
import java.awt.*;
import javax.swing.*;

public class NodeThread  implements Runnable
{
JButton btnNewnode,btnEditnode,btnRootnode,btnParentnode,btnPreviousnode,btnNextnode,btnChildnode,btnLink,btnOk;
int i=-1;
static int n=-1;
Graphics g=null;
static boolean Parentflag=false,rootflag=false;
public NodeThread()
{
}
public NodeThread(JButton b1,JButton b2,JButton b3,JButton b4,JButton b5,JButton b6,JButton b7,JButton b8,JButton b9)
{
btnNewnode=b1;
btnEditnode=b2;
btnRootnode=b3;
btnParentnode=b4;
btnPreviousnode=b5;
btnNextnode=b6;
btnChildnode=b7;
btnLink=b8;
btnOk=b9;
Thread th=new Thread(this);
th.start();
}


public void run()
{
i=-1;
btnNewnode.setEnabled(false);
btnEditnode.setEnabled(false);
btnRootnode.setEnabled(false);
btnParentnode.setEnabled(false);
btnPreviousnode.setEnabled(false);
btnNextnode.setEnabled(false);
btnChildnode.setEnabled(false);
btnLink.setEnabled(false);
btnOk.setEnabled(false);
 while(true)
{

Mind.flagClick=false;
btnNewnode.setEnabled(false);
btnEditnode.setEnabled(false);
btnRootnode.setEnabled(false);
btnParentnode.setEnabled(false);
btnPreviousnode.setEnabled(false);
btnNextnode.setEnabled(false);
btnChildnode.setEnabled(false);
btnLink.setEnabled(false);
btnOk.setEnabled(false);
i=(i+1)%9;
if(i==0) {
                btnNewnode.setEnabled(true);
            }
else if(i==1) {
               btnEditnode.setEnabled(true);
            }
else if(i==2) {
               btnRootnode.setEnabled(true);
            }
else if(i==3) {
            
                 btnParentnode.setEnabled(true);
            }
else if(i==4) {
                btnPreviousnode.setEnabled(true);
            }
else if(i==5) {
               btnNextnode.setEnabled(true);
            }
else if(i==6) {
                btnChildnode.setEnabled(true);
            }
else if(i==7) {
                btnLink.setEnabled(true);
            }
else if(i==8) {
                btnOk.setEnabled(true);
            }

try
{

Thread.sleep(Mind.scanSpeed);
}
catch(Exception e)
{ }
if(Mind.flagClick)
{
    if(g!=null)
{
g.translate(-100,-100);
Mind.Obj_Drawing.paint(g);
g=null;
}
g=MindDraw.gd.create();
g.translate(100,100);
g.setColor(Color.ORANGE);
}

if(i==0 && Mind.flagClick)
{
    Mind.play("newnode");
Mind.westReset();
Mind.Obj_Newnode.setVisible(true);
Mind.containpane.add(BorderLayout.WEST,Mind.Obj_Newnode);
NewNode.start();
break;
}
else if(i==1&& Mind.flagClick)
{
      if(!rootflag && Mind.currentNode==null)
    {
        Mind.play("choosenode");
    new ShowDialog("Choose a Node to edit..");
    }
    else
    {
    Mind.play("editnode");
  Mind.currentIndex=n;
  if(rootflag)
  {
      rootflag=false;
  }
        Mind.westReset();
    Mind.Obj_Editnode.setVisible(true);
Mind.containpane.add(BorderLayout.WEST,Mind.Obj_Editnode);
EditNode.start();
break;
}
}
else if(i==2 && Mind.flagClick)
{
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
else if(i==3 && Mind.flagClick)
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
else if(i==4 && Mind.flagClick)
{
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
else if(i==5 && Mind.flagClick)
{
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
else if(i==6 && Mind.flagClick)
{
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
else if(i==7 && Mind.flagClick)
{
     Mind.play("link");
    if(Mind.currentNode!=null)
    {
    new ShowText(Mind.currentNode.linkName);
    }
    else
    {
    new ShowText(List.ROOT.linkName);
    }
  ShowText.start();
}

else if(i==8 && Mind.flagClick) {
    Mind.play("ok");
            MenuPanel.start();
            break;
        }
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