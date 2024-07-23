import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import javax.imageio.*;
import java.io.*;

public class MindDraw extends JPanel
{
public static Graphics gd=null;
public static int h=600,w=1200,n;
static BufferedImage image;
public MindDraw()
{
    
setPreferredSize(new Dimension(w+Mind.HSPACE,h+Mind.HSPACE)); 

}
   
    @Override
public void paint(Graphics g1)
{
 setPreferredSize(new Dimension(w+Mind.HSPACE,h+Mind.HSPACE)); 

 Graphics2D g = (Graphics2D) g1;
if(Mind.flagClearRect) {
            Mind.flagClearRect = false;
        }
else {
            g.clearRect(0, 0, w+Mind.HSPACE,h+Mind.HSPACE);
        }
g.translate(100,100);
    g.setStroke(new BasicStroke(Mind.Shapethick));

setBackground(Color.white);
gd=getGraphics();

try
{



Font f = new Font("Arial Black", Font.BOLD, 16);
	g.setFont(f);
      	 g.setColor(Color.BLUE);

if(List.ROOT!=null)
{

        paintRoot(g,List.ROOT);
        

	for(int i=0;i<Root.RC;i++)
{	
            paintChild(g,List.ROOT.Right[i],(w+150)/2, h/2,1);
}
	
for(int i=0;i<Root.LC;i++)
{
    paintChild(g,List.ROOT.Left[i],(w-150)/2, h/2,2);
}
}

}
catch(Exception e)
{

}	
}
public void paintChild(Graphics2D g,Node temp,int x,int y,int dir) throws Exception
{
    int tx=0;
    Font f = new Font("Arial Black", Font.BOLD, 16);
    g.setFont(f);
      	g.setColor(Color.BLUE);
	if(temp.color!=null) {
                        g.setColor(temp.color);
                    }
	if(temp.fontSize!=0) {
                        f = new Font(temp.fontName, temp.fontStyle, temp.fontSize);
                    }
	g.setFont(f);
if(dir==1) {
    tx=temp.x;
            
        }
else {
            tx=temp.x+Mind.ShapeWidth;
            
        }
        g.drawLine(x, y, tx, temp.y);
        
if(temp.iconName!=null)
{
image = ImageIO.read(new File(temp.iconName));
	g.drawImage(image,(temp.x-5)-48, (temp.y-20),null);
}
	if(temp.shape==1) {
                        g.drawRect(temp.x, temp.y - Mind.ShapeHeight/2, Mind.ShapeWidth, Mind.ShapeHeight);
                    }
	else if(temp.shape==2) {
                        g.drawOval(temp.x, temp.y - Mind.ShapeHeight/2,  Mind.ShapeWidth, Mind.ShapeHeight);
                    }
	else if(temp.shape==3) {
                        g.drawRect(temp.x, temp.y - Mind.ShapeWidth/2, Mind.ShapeWidth,Mind.ShapeWidth);
                    }
	else if(temp.shape==4) {
                        g.drawOval(temp.x, temp.y - Mind.ShapeWidth/2, Mind.ShapeWidth, Mind.ShapeWidth);
                    }
	else if(temp.shape==5) {
                        g.drawLine(temp.x, temp.y + Mind.ShapeHeight/2, temp.x +Mind.ShapeWidth, temp.y +  Mind.ShapeHeight/2);
                    }
	else {
                        g.drawRect(temp.x, temp.y - Mind.ShapeHeight/2,  Mind.ShapeWidth, Mind.ShapeHeight);
                    }

	g.drawString(temp.nodeName,temp.x+5,temp.y);
    for(int i=0;i<temp.N;i++)
{	
        if(dir==1)
        {
            paintChild(g,temp.Child[i],tx+Mind.ShapeWidth,temp.y,dir);
}
        else
        {
            paintChild(g,temp.Child[i],tx-Mind.ShapeWidth,temp.y,dir);
        }

}
}
public void paintRoot(Graphics2D g,Root temp) throws Exception
{
    
        Font f = new Font("Arial Black", Font.BOLD, 16);
	if(temp.iconName!=null)
{
       image = ImageIO.read(new File(temp.iconName));
	g.drawImage(image,(w-Mind.ShapeWidth)/2-48, (h-Mind.ShapeHeight)/2,null);
}
	if(temp.color!=null) {
                    g.setColor(temp.color);
                }
		if(temp.fontSize!=0) {
                    f = new Font(temp.fontName, temp.fontStyle, temp.fontSize);
                }
	g.setFont(f);
	if(temp.shape==1) {
                    g.drawRect((w - Mind.ShapeWidth) / 2, (h - Mind.ShapeHeight) / 2, Mind.ShapeWidth, Mind.ShapeHeight);
                }
	else if(temp.shape==2) {
                    g.drawOval((w - Mind.ShapeWidth) / 2, (h - Mind.ShapeHeight) / 2, Mind.ShapeWidth, Mind.ShapeHeight);
                }
	else if(temp.shape==3) {
                    g.drawRect((w - Mind.ShapeWidth) / 2, (h - Mind.ShapeWidth) / 2, Mind.ShapeWidth, Mind.ShapeWidth);
                }
	else if(temp.shape==4) {
                    g.drawOval((w - Mind.ShapeWidth) / 2, (h - Mind.ShapeWidth) / 2, Mind.ShapeWidth, Mind.ShapeWidth);
                }
	else if(temp.shape==5) {
                    g.drawLine((w - Mind.ShapeWidth) / 2, (h + Mind.ShapeHeight) / 2 , (w + Mind.ShapeWidth) / 2, (h + Mind.ShapeHeight) / 2 );
                }
	else {
                    g.drawOval((w - Mind.ShapeWidth) / 2, (h - Mind.ShapeHeight) / 2, Mind.ShapeWidth, Mind.ShapeHeight);
                }

	g.drawString(temp.nodeName,(w-Mind.ShapeWidth)/2+5, h/2);

}

    }



