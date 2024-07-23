/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;
/**
 *
 * @author ashwi
 */
public class userregister extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String usernm=request.getParameter("uname");
        String pas=request.getParameter("password");
        String mailid=request.getParameter("email");
        saveToXML(usernm, pas,mailid);
        out.println("<html><body background=background1.png>");
        out.println("<h1>You have successfully registered</h1>");
        out.println("<a href=index.html><button  type=\"submit\" style=\"background-color: #4CAF50;\n" +
"    color: white;\n" +
"    padding: 14px 20px;\n" +
"    margin: 8px 0;\n" +
"    border: none;\n" +
"    cursor: pointer;\n" +
"    width: 200px; height: 40px\n" +
"    border-radius: 8px;\">Back</button></a>\n");
       
    }

    public void saveToXML(String user, String pass,String emailid)
        {
        try{
             String tempad="C:";
            //File inputFile = new File(tempad+"\\tomcat\\webapps\\summer\\WEB-INF\\classes\\files\\imp\\credentials.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(tempad+"/tomcat/webapps/summer/WEB-INF/classes/files/imp/credentials.xml");
            Node root = doc.getFirstChild();
            
            
            Element login = doc.createElement("login");
             Element username = doc.createElement("username");
	    username.appendChild(doc.createTextNode(user));
	    login.appendChild(username);
            Element password = doc.createElement("password");
	    password.appendChild(doc.createTextNode(pass));
	    login.appendChild(password);
	    Element email=doc.createElement("email");
            email.appendChild(doc.createTextNode(emailid));
            login.appendChild(email);
            root.appendChild(login);
            DOMSource source = new DOMSource(doc);
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            StreamResult result = new StreamResult(tempad+"/tomcat/webapps/summer/WEB-INF/classes/files/imp/credentials.xml");
            transformer.transform(source, result);
          
        }
        catch (Exception e)
    {
        e.printStackTrace();
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
