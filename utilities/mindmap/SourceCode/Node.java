
import java.awt.Color;
import java.util.Random;

public class Node
{
public long nodeId;
public String nodeName;
public String iconName=null;
public int x,y;
public Color color;
public int fontStyle=-1,fontSize=0,shape=0;
public String fontName;
public String linkName;
public Node[] Child=new Node[100];
public  int N;
public static long Number=1L;
public Node()
{

}

public Node(String sb1,String sb2,Color n,String fnt,int fst,int fs,int sp,String link)
{
nodeId=Number++;
nodeName=sb1;
iconName=sb2;
color=n;
fontName=fnt;
fontStyle=fst;
fontSize=fs;
shape=sp;
linkName=link;
N=0;
}
public Node(String sb1,String sb2,Color n,String fnt,int fst,int fs,int sp,String link,Node chd[])
{
nodeName=sb1;
iconName=sb2;
color=n;
fontName=fnt;
fontStyle=fst;
fontSize=fs;
shape=sp;
linkName=link;
Child=chd;
}
}