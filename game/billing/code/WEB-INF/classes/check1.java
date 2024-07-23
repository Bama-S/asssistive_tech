/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import javax.servlet.RequestDispatcher;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import javax.servlet.http.Cookie;
/**
 *
 * @author ashwi
 */
public class check1 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
         String tempad="C:";
    public class sample
    {
      public String user="";
     public String pass="";
    }
   public boolean find(String id,String password)
   {
       String name;
       String pass;
       boolean exist=false;
   try{
    
       File inputFile = new File(tempad+"/tomcat/webapps/summer/WEB-INF/classes/files/imp/credentials.xml");
       DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
         Document doc = dBuilder.parse(inputFile);
         doc.getDocumentElement().normalize();
         
         NodeList nList = doc.getElementsByTagName("login");
         for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
           if (nNode.getNodeType() == Node.ELEMENT_NODE) {
               Element eElement = (Element) nNode;
               name=eElement.getElementsByTagName("username").item(0).getTextContent();
                pass=eElement.getElementsByTagName("password").item(0).getTextContent();
                if(name.equals(id)&&pass.equals(password))
                {
                    exist=true;
                    break;
                }
                }
         
    }
         }
        
        catch(Exception e)
        {
            e.printStackTrace();
            
       }
            return exist;
   
   }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       try{ response.setContentType("text/html");
        PrintWriter out=response.getWriter();
       String username=request.getParameter("uname");
       String password=request.getParameter("password");
      
       if(find(username,password))
       {
           //response.sendRedirect("register.html?name="+username);
           //response.sendRedirect("register2");
           RequestDispatcher rd=request.getRequestDispatcher("adminregister.jsp");
           rd.forward(request,response);
          
       }
       else
           response.sendRedirect("retry.html");
       //out.println(username);
       //out.println(password);
       
       
       
       
    }
       catch(Exception e)
       {
       }
       }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
