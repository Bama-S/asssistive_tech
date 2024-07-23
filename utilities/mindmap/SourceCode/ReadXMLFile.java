/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sakthi
 */




import java.io.*;
import javax.xml.transform.dom.DOMResult;
import java.awt.Color;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamSource;
 
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
 
public class ReadXMLFile {
 DocumentBuilderFactory docFactory;
 DocumentBuilder docBuilder;
 Document doc;
 static int fontStyle,fontSize,shape;
static Color color;
static String nodeName,iconName,fontName,linkName;

public void readAttribute(Element RootElement)
{
    nodeName=RootElement.getAttribute("TEXT");
     iconName=RootElement.getAttribute("ICON");     
     
     if(RootElement.getAttribute("COLOR").equalsIgnoreCase("RED")) {
            color=Color.RED;
        }
     
     else if(RootElement.getAttribute("COLOR").equalsIgnoreCase("GREEN")) {
            color=Color.GREEN;
        }
     else if(RootElement.getAttribute("COLOR").equalsIgnoreCase("BLUE")) {
            color=Color.BLUE;
        }
     else if(RootElement.getAttribute("COLOR").equalsIgnoreCase("BLACK")) {
            color=Color.BLACK;
        }
     else if(RootElement.getAttribute("COLOR").equalsIgnoreCase("MAGENTA")) {
            color=Color.MAGENTA;
        }
     else if(RootElement.getAttribute("COLOR").equalsIgnoreCase("ORANGE")) {
            color=Color.ORANGE;
        }
     else if(RootElement.getAttribute("COLOR").equalsIgnoreCase("YELLOW")) {
            color=Color.YELLOW;
        }
     else if(RootElement.getAttribute("COLOR").equalsIgnoreCase("CYAN")) {
            color=Color.CYAN;
        }
     else if(RootElement.getAttribute("COLOR").equalsIgnoreCase("GRAY")) {
            color=Color.GRAY;
        }
     else if(RootElement.getAttribute("COLOR").equalsIgnoreCase("PINK")) {
            color=Color.PINK;
        }
     
     fontName=RootElement.getAttribute("FONT_NAME");
     
      if(RootElement.getAttribute("FONT_STYLE").equalsIgnoreCase("PLAIN")) {
            fontStyle=0;
        }
     else if(RootElement.getAttribute("FONT_STYLE").equalsIgnoreCase("BOLD")) {
            fontStyle=1;
        }
     else if(RootElement.getAttribute("FONT_STYLE").equalsIgnoreCase("ITALIC")) {
            fontStyle=2;
        }
     else  {
            fontStyle=0;
        }
     
      fontSize=Integer.parseInt(RootElement.getAttribute("FONT_SIZE"));
     
          if(RootElement.getAttribute("SHAPE").equalsIgnoreCase("RECTANGLE")) {
            shape=1;
        }
     else if(RootElement.getAttribute("SHAPE").equalsIgnoreCase("ELLIPSE")) {
            shape=2;
        }
      else if(RootElement.getAttribute("SHAPE").equalsIgnoreCase("SQUARE")) {
            shape=3;
        }   
      else if(RootElement.getAttribute("SHAPE").equalsIgnoreCase("CIRCLE")) {
            shape=4;
        }   
      else if(RootElement.getAttribute("SHAPE").equalsIgnoreCase("LINE")) {
            shape=5;
        }   
      linkName=RootElement.getAttribute("LINK");
}
public void readChild(Node temp,Element RootElement)
 {
     
    NodeList nodeList=RootElement.getElementsByTagName("child"+RootElement.getAttribute("ID"));

for(int i=0;i<nodeList.getLength();i++)
{
    Element node=(Element)nodeList.item(i);
            readAttribute(node);
  Node child=List.openChild(temp,nodeName, iconName, color, fontName, fontStyle, fontSize, shape,linkName); 
   readChild(child,node);
}    
 Mind.Obj_Drawing.repaint();   
 }
 public void readRoot(Element RootElement)
 {
     
     
         readAttribute(RootElement);
           List.insertNode(nodeName, iconName, color, fontName, fontStyle, fontSize, shape,linkName); 
           
      Mind.Obj_Drawing.repaint();
      NodeList nodeList=RootElement.getElementsByTagName("node");

for(int i=0;i<nodeList.getLength();i++)
{
    Element node=(Element)nodeList.item(i);
            readAttribute(node);
       if(node.getAttribute("DIRECTION").equalsIgnoreCase("RIGHT"))    
       {
       Node temp=List.insertRightNode(nodeName, iconName, color, fontName, fontStyle, fontSize, shape,linkName); 
           readChild(temp,node);
       }
       else
       {
         Node temp=List.insertLeftNode(nodeName, iconName, color, fontName, fontStyle, fontSize, shape,linkName);
         readChild(temp,node);
       }
}    

      
      
      
 }
  public  void Read(String fileName)
 {
    try{
         System.out.println("start");
  docFactory = DocumentBuilderFactory.newInstance();
 docBuilder = docFactory.newDocumentBuilder();
  doc = docBuilder.newDocument();
  TransformerFactory transformerFactory = TransformerFactory.newInstance();
	  Transformer transformer = transformerFactory.newTransformer();
 DOMResult result = new DOMResult(doc);
 
	  StreamSource source =  new StreamSource(new File("output\\"+fileName+".mmt"));
	  transformer.transform(source, result);

Element root=doc.getDocumentElement();
readRoot(root);

	           
     }

    catch(Exception e){
        Mind.play("validfilename");
new ShowDialog("Enter the Valid File Name");
	  System.out.println(e);
     }
 } 
}