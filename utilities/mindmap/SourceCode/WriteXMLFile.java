/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sakthi
 */




import java.awt.Color;
import java.io.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
 
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class WriteXMLFile {
 DocumentBuilderFactory docFactory;
 DocumentBuilder docBuilder;
 Document doc;
 
  
 public void addRoot(Element RootElement)
 {
     
     
          
          Attr attr_TEXT=doc.createAttribute("TEXT");
          attr_TEXT.setValue(List.ROOT.nodeName.toUpperCase());
          RootElement.setAttributeNode(attr_TEXT);
          
          Attr attr_ICON=doc.createAttribute("ICON");
          if(List.ROOT.iconName!=null)
          {
          attr_ICON.setValue(List.ROOT.iconName.toUpperCase());
          }
          else
          {
              attr_ICON.setValue("NIL");
          }
           RootElement.setAttributeNode(attr_ICON);
            Attr attr_COLOR=doc.createAttribute("COLOR");
            if(List.ROOT.color==Color.RED) {
            attr_COLOR.setValue("RED");
        }
            else if(List.ROOT.color==Color.GREEN) {
            attr_COLOR.setValue("GREEN");
        }
            else if(List.ROOT.color==Color.BLUE) {
            attr_COLOR.setValue("BLUE");
        }
            else if(List.ROOT.color==Color.BLACK) {
            attr_COLOR.setValue("BLACK");
        }
            else if(List.ROOT.color==Color.MAGENTA) {
            attr_COLOR.setValue("MAGENTA");
        }
            else if(List.ROOT.color==Color.ORANGE) {
            attr_COLOR.setValue("ORANGE");
        }
            else if(List.ROOT.color==Color.YELLOW) {
            attr_COLOR.setValue("YELLOW");
        }
            else if(List.ROOT.color==Color.CYAN) {
            attr_COLOR.setValue("CYAN");
        }
            else if(List.ROOT.color==Color.GRAY) {
            attr_COLOR.setValue("GRAY");
        }
            else if(List.ROOT.color==Color.PINK) {
            attr_COLOR.setValue("PINK");
        }
            else 
            {
                attr_COLOR.setValue("BLUE");
            }
            if(List.ROOT.color!=null)
            {
          RootElement.setAttributeNode(attr_COLOR);
            }
           
            Attr attr_FNTNAME=doc.createAttribute("FONT_NAME");
          attr_FNTNAME.setValue(List.ROOT.fontName.toUpperCase());
          RootElement.setAttributeNode(attr_FNTNAME); 
          
          Attr attr_STYLE=doc.createAttribute("FONT_STYLE");
          if(List.ROOT.fontStyle==0) {
                attr_STYLE.setValue("PLAIN");
            }
          else if(List.ROOT.fontStyle==1) {
                attr_STYLE.setValue("BOLD");
            }
          else if(List.ROOT.fontStyle==2) {
                attr_STYLE.setValue("ITALIC");
            }
          else {
                attr_STYLE.setValue("PLAIN");
            }  
          RootElement.setAttributeNode(attr_STYLE);
          
          Attr attr_SIZE=doc.createAttribute("FONT_SIZE");
          if(List.ROOT.fontSize!=0)
          {
          attr_SIZE.setValue(Integer.toString(List.ROOT.fontSize));
          }
          else
          {
              attr_SIZE.setValue("16");
          }
          
          RootElement.setAttributeNode(attr_SIZE);
          
            Attr attr_SHAPE=doc.createAttribute("SHAPE");
          if(List.ROOT.shape==1) {
                attr_SHAPE.setValue("RECTANGLE");
            }
	else if(List.ROOT.shape==2) {
                attr_SHAPE.setValue("ELLIPSE");
            }
	else if(List.ROOT.shape==3) {
                attr_SHAPE.setValue("SQUARE");
            }
	else if(List.ROOT.shape==4) {
                attr_SHAPE.setValue("CIRCLE");
            }
	else if(List.ROOT.shape==5) {
                attr_SHAPE.setValue("LINE");
            }
	else {
                attr_SHAPE.setValue("ELLIPSE");
            }
            RootElement.setAttributeNode(attr_SHAPE);
            
           Attr attr_LINK=doc.createAttribute("LINK");  
            if(List.ROOT.linkName!=null) {
                attr_LINK.setValue(List.ROOT.linkName);
            }
            else
            {
               attr_LINK.setValue("NIL");
            }
           RootElement.setAttributeNode(attr_LINK);     
           
            for(int i=0;i<Root.RC;i++)
            {
                Element node = doc.createElement("node");
	  RootElement.appendChild(node);
          Attr attr_DIRECT = doc.createAttribute("DIRECTION");
	  attr_DIRECT.setValue("RIGHT");
	  node.setAttributeNode(attr_DIRECT);
           
                addChild(node,List.ROOT.Right[i]);
            }
            
            for(int i=0;i<Root.LC;i++)
            {
                Element node = doc.createElement("node");
	  RootElement.appendChild(node);
          Attr attr_DIRECT = doc.createAttribute("DIRECTION");
	  attr_DIRECT.setValue("LEFT");
	  node.setAttributeNode(attr_DIRECT);
           
                addChild(node,List.ROOT.Left[i]);
            }
 }
 
 public void addChild(Element Root,Node temp)
 {
     Attr attr_ID = doc.createAttribute("ID");
	  attr_ID.setValue(Long.toString(temp.nodeId));
          Root.setAttributeNode(attr_ID);
	 Root.setIdAttributeNode(attr_ID,attr_ID.isId());
          
          Attr attr_TEXT=doc.createAttribute("TEXT");
          attr_TEXT.setValue(temp.nodeName.toUpperCase());
          Root.setAttributeNode(attr_TEXT);
          Attr attr_ICON=doc.createAttribute("ICON");
          if(temp.iconName!=null)
          {
          attr_ICON.setValue(temp.iconName.toUpperCase());
          }
          else
          {
           attr_ICON.setValue("NIL");   
          }
              
           Root.setAttributeNode(attr_ICON);
            Attr attr_COLOR=doc.createAttribute("COLOR");
            if(temp.color==Color.RED) {
            attr_COLOR.setValue("RED");
        }
            else if(temp.color==Color.GREEN) {
            attr_COLOR.setValue("GREEN");
        }
            else if(temp.color==Color.BLUE) {
            attr_COLOR.setValue("BLUE");
        }
            else if(temp.color==Color.BLACK) {
            attr_COLOR.setValue("BLACK");
        }
            else if(temp.color==Color.MAGENTA) {
            attr_COLOR.setValue("MAGENTA");
        }
            else if(temp.color==Color.ORANGE) {
            attr_COLOR.setValue("ORANGE");
        }
            else if(temp.color==Color.YELLOW) {
            attr_COLOR.setValue("YELLOW");
        }
            else if(temp.color==Color.CYAN) {
            attr_COLOR.setValue("CYAN");
        }
            else if(temp.color==Color.GRAY) {
            attr_COLOR.setValue("GRAY");
        }
            else if(temp.color==Color.PINK) {
            attr_COLOR.setValue("PINK");
        }
            else
            {
                attr_COLOR.setValue("BLUE");
            }
            if(temp.color!=null)
            {
          Root.setAttributeNode(attr_COLOR);
            }
           
            Attr attr_FNTNAME=doc.createAttribute("FONT_NAME");
          attr_FNTNAME.setValue(temp.fontName.toUpperCase());
          Root.setAttributeNode(attr_FNTNAME); 
          
          Attr attr_STYLE=doc.createAttribute("FONT_STYLE");
          if(temp.fontStyle==0) {
                attr_STYLE.setValue("PLAIN");
            }
          else if(temp.fontStyle==1) {
                attr_STYLE.setValue("BOLD");
            }
          else if(temp.fontStyle==2) {
                attr_STYLE.setValue("ITALIC");
            }
          else {
                attr_STYLE.setValue("PLAIN");
            }  
          Root.setAttributeNode(attr_STYLE);
          
          Attr attr_SIZE=doc.createAttribute("FONT_SIZE");
          attr_SIZE.setValue(Integer.toString(temp.fontSize));
          Root.setAttributeNode(attr_SIZE);
          
            Attr attr_SHAPE=doc.createAttribute("SHAPE");
          if(temp.shape==1) {
                attr_SHAPE.setValue("RECTANGLE");
            }
	else if(temp.shape==2) {
                attr_SHAPE.setValue("ELLIPSE");
            }
	else if(temp.shape==3) {
                attr_SHAPE.setValue("SQUARE");
            }
	else if(temp.shape==4) {
                attr_SHAPE.setValue("CIRCLE");
            }
	else if(temp.shape==5) {
                attr_SHAPE.setValue("LINE");
            }
	else {
                attr_SHAPE.setValue("ELLIPSE");
            }
            Root.setAttributeNode(attr_SHAPE);
            Attr attr_LINK=doc.createAttribute("LINK");  
            if(temp.linkName!=null) {
                attr_LINK.setValue(temp.linkName);
            }
            else
            {
               attr_LINK.setValue("NIL");
            }
           Root.setAttributeNode(attr_LINK);
            
            Attr attr_NUM = doc.createAttribute("NO_OF_NODE");
	  attr_NUM.setValue(Integer.toString(temp.N));
           for(int i=0;i<temp.N;i++)
            {
                Element child = doc.createElement("child"+Root.getAttribute("ID"));
	  Root.appendChild(child);
          
           
                addChild(child,temp.Child[i]);
            }
 }
 
 public  void write(String fileName)
 {
    try{
  docFactory = DocumentBuilderFactory.newInstance();
 docBuilder = docFactory.newDocumentBuilder();
 doc = docBuilder.newDocument();
	 // Element rootElement = doc.createElement("map");
	  
 
          Element root = doc.createElement("root");
	 
           Attr attr_ID = doc.createAttribute("ID");
	  attr_ID.setValue("0");
          root.setAttributeNode(attr_ID);
          
          doc.appendChild(root); 
          
    
          addRoot(root);
	  
	  //write the content into xml file
	  TransformerFactory transformerFactory = TransformerFactory.newInstance();
	  Transformer transformer = transformerFactory.newTransformer();
	  DOMSource source = new DOMSource(doc);
	  StreamResult result =  new StreamResult(new File("output\\"+fileName+".mmt"));
	  transformer.transform(source, result);
 
	  System.out.println("Done");
         
     }catch(ParserConfigurationException pce){
	  pce.printStackTrace();
     }catch(TransformerException tfe){
	 tfe.printStackTrace();
     }
 } 
}