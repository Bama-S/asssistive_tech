
import java.awt.Color;


public class Root {
public String nodeName;
public String iconName;
public int x,y;
public Color color;
public int fontStyle=-1,fontSize=0,shape=0;
public String fontName;
public String linkName;
public static int RC,LC,N;
 Node Right[]=new Node[100];
Node Left[]=new Node[100];
public Root()
{
    RC=0;
    LC=0;
    N=0;
    Mind.currentNode=null;
    Mind.parentNode=null;
}
public Root(String sb1,String sb2,Color n,String fnt,int fst,int fs,int sp,String link)
{
nodeName=sb1;
iconName=sb2;
color=n;
fontName=fnt;
fontStyle=fst;
fontSize=fs;
shape=sp;
linkName=link;
}

   
   
}