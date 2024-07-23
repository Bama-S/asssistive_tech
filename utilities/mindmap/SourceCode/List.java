
import java.awt.Color;
import java.awt.Dimension;



public class List
{
public static int N=0,Y,index=0;
public static Root ROOT;
public static Node LIST[]=new Node[200];
public static Node Clipboard=null;
public static Node tempClip=null;
public List()
{
  new Root();
ROOT=null;
Clipboard=null;
tempClip=null;
N=0;
}
public static Node insertRightNode(String sb1,String sb2,Color n,String fnt,int fst,int fs,int sp,String link)
{
    
        ROOT.Right[Root.RC++]=new Node(sb1,sb2,n,fnt,fst,fs,sp,link);
        SpaceAllocation();
       setScroll(ROOT.Right[Root.RC-1].x,ROOT.Right[Root.RC-1].y);
    
    N++;
     
     index=0;
    for(int i=0;i<Root.RC;i++) {
            LIST[index++] = ROOT.Right[i];
        }
    for(int i=0;i<Root.LC;i++) {
            LIST[index++] = ROOT.Left[i];
        }
    
     
    return ROOT.Right[Root.RC-1];
   
}
public static Node insertLeftNode(String sb1,String sb2,Color n,String fnt,int fst,int fs,int sp,String link)
{
    
        ROOT.Left[Root.LC++]=new Node(sb1,sb2,n,fnt,fst,fs,sp,link);
        SpaceAllocation();
        setScroll(ROOT.Left[Root.LC-1].x,ROOT.Left[Root.LC-1].y);
            
    N++;
     
     index=0;
    for(int i=0;i<Root.RC;i++) {
            LIST[index++] = ROOT.Right[i];
        }
    for(int i=0;i<Root.LC;i++) {
            LIST[index++] = ROOT.Left[i];
        }
    
     
   return ROOT.Left[Root.LC-1]; 
   
}
public static void insertNode(String sb1,String sb2,Color n,String fnt,int fst,int fs,int sp,String link)
{
    if(N==0)
    {
        ROOT=new Root(sb1,sb2,n,fnt,fst,fs,sp,link);
        SpaceAllocation();
        setScroll(ROOT.x,ROOT.y);
    }
    else if(N%2==1){
        ROOT.Right[Root.RC++]=new Node(sb1,sb2,n,fnt,fst,fs,sp,link);
        SpaceAllocation();
       setScroll(ROOT.Right[Root.RC-1].x,ROOT.Right[Root.RC-1].y);
    }
    else
    {
        ROOT.Left[Root.LC++]=new Node(sb1,sb2,n,fnt,fst,fs,sp,link);
        SpaceAllocation();
        setScroll(ROOT.Left[Root.LC-1].x,ROOT.Left[Root.LC-1].y);
        
    }
    N++;
     
     index=0;
    for(int i=0;i<Root.RC;i++) {
            LIST[index++] = ROOT.Right[i];
        }
    for(int i=0;i<Root.LC;i++) {
            LIST[index++] = ROOT.Left[i];
        }
    
     
    
   
}
public static void setScroll(int x, int y)
{
       
         Mind.scrollpane.getHorizontalScrollBar().setMaximum(MindDraw.w+Mind.HSPACE);
          Mind.scrollpane.getVerticalScrollBar().setMaximum(MindDraw.h+Mind.HSPACE);
           Mind.scrollpane.getHorizontalScrollBar().revalidate();
        Mind.scrollpane.getVerticalScrollBar().revalidate();       
          
           Mind.scrollpane.getVerticalScrollBar().setValue(y);
        Mind.scrollpane.getHorizontalScrollBar().setValue(x);
    
        
        
}
public static void insertChild(Node temp,String sb1,String sb2,Color n,String fnt,int fst,int fs,int sp,String link)
{
    temp.Child[temp.N++]=new Node(sb1,sb2,n,fnt,fst,fs,sp,link);
            SpaceAllocation();
        setScroll(temp.Child[temp.N-1].x,temp.Child[temp.N-1].y);
}
public static Node openChild(Node temp,String sb1,String sb2,Color n,String fnt,int fst,int fs,int sp,String link)
{
    temp.Child[temp.N++]=new Node(sb1,sb2,n,fnt,fst,fs,sp,link);
            SpaceAllocation();
        setScroll(temp.Child[temp.N-1].x,temp.Child[temp.N-1].y);
  return temp.Child[temp.N-1];
}
public static void SpaceAllocation()
{
    int y=0,x=0;
    Dimension d=new Dimension(0,0);
    ROOT.x=MindDraw.w/2;
    ROOT.y=MindDraw.h/2;
for(int i=0;i<Root.RC;i++)
{
    ROOT.Right[i].x=MindDraw.w/2+Mind.HSPACE;
    d=RightAllocation(ROOT.Right[i],ROOT.Right[i].x,y);
            if((d.height-y)>Mind.HSPACE)
            {
                ROOT.Right[i].y=y+(d.height-y)/2;
                        }
            else
            {
        ROOT.Right[i].y=y+Mind.VSPACE;
                    }
    
     y=d.height>ROOT.Right[i].y?d.height:ROOT.Right[i].y;
    if(d.width>MindDraw.w-Mind.VSPACE && y>MindDraw.h-50)
    {
        MindDraw.w=d.width+Mind.HSPACE;
        MindDraw.h=y+Mind.VSPACE;
      
       
        SpaceAllocation();
    }
    else if(d.width>MindDraw.w-Mind.VSPACE)
    {
      MindDraw.w=d.width+Mind.HSPACE;
            
                             
        SpaceAllocation();
            }
    else if(y>MindDraw.h-50)
    {
      MindDraw.h=y+Mind.VSPACE;
             
                              
        SpaceAllocation();
            }
}
y=0;
x=0;
 d=new Dimension(0,0);
for(int i=0;i<Root.LC;i++)
{
    
    ROOT.Left[i].x=MindDraw.w/2-300;
    d=LeftAllocation(ROOT.Left[i],ROOT.Left[i].x,y);
            if((d.height-y)>Mind.HSPACE)
            {
                ROOT.Left[i].y=y+(d.height-y)/2;
            
                            }
            else
            {
        ROOT.Left[i].y=y+Mind.VSPACE;
         
            }
  
    y=d.height>ROOT.Left[i].y?d.height:ROOT.Left[i].y;
    if(d.width<0 && y>MindDraw.h-50)
    {
        MindDraw.w+=Mind.HSPACE;
        MindDraw.h=y+Mind.VSPACE;
             SpaceAllocation();
    }
    else if(d.width<0)
    {
      MindDraw.w+=Mind.HSPACE;
        SpaceAllocation();
            }
    else if(y>MindDraw.h-50)
    {
      MindDraw.h=y+Mind.VSPACE;
            SpaceAllocation();
            }
}
 
}
public static Dimension RightAllocation(Node temp,int tx,int ty)
{
    int y=ty;
    Dimension d=new Dimension(0,0);
    if(temp.N>0)
    {
        for(int i=0;i<temp.N;i++,ty=y)
        {
            temp.Child[i].x=tx+Mind.HSPACE;
            if(temp.Child[i].N>0)
            {
            d=RightAllocation(temp.Child[i],tx+Mind.HSPACE,y);
            }
            if((d.height-ty)>Mind.HSPACE)
            {
            temp.Child[i].y=y+(d.height-ty)/2;
                }
            else
            {
                temp.Child[i].y=y+Mind.VSPACE;
                
            }
            y=d.height>temp.Child[i].y?d.height:temp.Child[i].y;
}
        
        return new Dimension(d.width>tx+Mind.HSPACE?d.width:tx+Mind.HSPACE,d.height>y?d.height:y);
}
        return new Dimension(tx,ty);
    
}
public static Dimension LeftAllocation(Node temp,int tx,int ty)
{
    int y=ty;
    Dimension d=new Dimension(0,0);
    if(temp.N>0)
    {
        for(int i=0;i<temp.N;i++,ty=y)
        {
            temp.Child[i].x=tx-Mind.HSPACE;
            if(temp.Child[i].N>0)
            {
            d=LeftAllocation(temp.Child[i],tx-Mind.HSPACE,y);
            }
            if((d.height-ty)>Mind.HSPACE)
            {
            temp.Child[i].y=y+(d.height-ty)/2;
                }
            else
            {
                temp.Child[i].y=y+Mind.VSPACE;
                
            }
             y=d.height>temp.Child[i].y?d.height:temp.Child[i].y;
}
        return new Dimension(d.width<tx-Mind.HSPACE?d.width:tx-Mind.HSPACE,d.height>y?d.height:y);
}
        return new Dimension(tx,ty);
    
}
public static void copyNode()
{
    Clipboard=Mind.currentNode;
    
            
}
public static void pasteNode(Node temp,int n)
{
    
  tempClip=pasteChildNode(Clipboard);
   
      if(temp!=null)
    {
        for(int i=temp.N;i>n;i--)
    {
        temp.Child[i]=temp.Child[i-1];
    }
    temp.Child[n]=tempClip;
    temp.N++;
    
    SpaceAllocation();
    }
    else
    {
    insertPasteNode(n);
    }
  index=0;
    for(int i=0;i<Root.RC;i++) {
            LIST[index++] = ROOT.Right[i];
        }
    for(int i=0;i<Root.LC;i++) {
            LIST[index++] = ROOT.Left[i];
        }
      
}
public static Node pasteChildNode(Node tempClipnode)
{
    Node temp=new Node(tempClipnode.nodeName,tempClipnode.iconName,tempClipnode.color,tempClipnode.fontName,tempClipnode.fontStyle,tempClipnode.fontSize,tempClipnode.shape,tempClipnode.linkName);
     
    temp.N=tempClipnode.N;
     for(int i=0;i<temp.N;i++)
    {
        temp.Child[i]=pasteChildNode(tempClipnode.Child[i]);
    }
    
      return temp;
}
public static void insertPasteNode(int n)
{
    
     if(Root.RC>n){
       for(int i=Root.RC;i>n;i--)
    {
        ROOT.Right[i]=ROOT.Right[i-1];
    }
     
    ROOT.Right[n]= tempClip;
    Root.RC++;
    
    SpaceAllocation();
    }
    else
    {
         n=n-Root.RC;
        for(int i=Root.LC;i>n;i--)
    {
        ROOT.Left[i]=ROOT.Left[i-1];
    }
    ROOT.Left[n]=tempClip;
    Root.LC++;
    SpaceAllocation();
    }
    N++;
     
    
    
        
}
public static void cutNode(Node temp,int n)
{
    if(temp!=null)
    {
        Clipboard=temp.Child[n];
        for(int i=n;i<temp.N;i++)
    {
        temp.Child[i]=temp.Child[i+1];
    }
    
    temp.N--;
    SpaceAllocation();
    }
    else
    {
    deleteCutNode(n);
    }
 index=0;
    for(int i=0;i<Root.RC;i++) {
            LIST[index++] = ROOT.Right[i];
        }
    for(int i=0;i<Root.LC;i++) {
            LIST[index++] = ROOT.Left[i];
        }
      
}
public static void deleteCutNode(int n)
{
    
     if(Root.RC>n){
         Clipboard=ROOT.Right[n];
       for(int i=n;i<Root.RC;i++)
    {
        ROOT.Right[i]=ROOT.Right[i+1];
    }
    
    Root.RC--;
    SpaceAllocation();
    }
    else
    {
         n=n-Root.RC;
         Clipboard=ROOT.Left[n];
        for(int i=n;i<Root.LC;i++)
    {
        ROOT.Left[i]=ROOT.Left[i+1];
    }
    
    Root.LC--;
    SpaceAllocation();
    }
    N--;
     
     
    
        
}
public static void removeNode(Node temp,int n)
{
    if(temp!=null)
    {
        
        for(int i=n;i<temp.N;i++)
    {
        temp.Child[i]=temp.Child[i+1];
    }
    
    temp.N--;
    SpaceAllocation();
    }
    else
    {
    deleteRemoveNode(n);
    }
 
      
}
public static void deleteRemoveNode(int n)
{
    
     if(Root.RC>n){
         
       for(int i=n;i<Root.RC;i++)
    {
        ROOT.Right[i]=ROOT.Right[i+1];
    }
    
    Root.RC--;
    SpaceAllocation();
    }
    else
    {
         n=n-Root.RC;
         
        for(int i=n;i<Root.LC;i++)
    {
        ROOT.Left[i]=ROOT.Left[i+1];
    }
    
    Root.LC--;
    SpaceAllocation();
    }
    N--;
     
     index=0;
    for(int i=0;i<Root.RC;i++) {
            LIST[index++] = ROOT.Right[i];
        }
    for(int i=0;i<Root.LC;i++) {
            LIST[index++] = ROOT.Left[i];
        }
    
        
}
}
