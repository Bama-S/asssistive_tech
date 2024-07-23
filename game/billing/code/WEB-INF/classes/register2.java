/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ashwi
 */
public class register2 extends HttpServlet {

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
            throws ServletException, IOException {		 		  String tempad="C:";

       response.setContentType("text/html;charset=UTF-8");
PrintWriter out = response.getWriter();
        String content;String name=null;int id=0;
        File file1 =new File(tempad+"/tomcat/webapps/summer/WEB-INF/classes/files/imp/idvalue.txt");
try{          
              
           BufferedReader in;
       in =new BufferedReader(new FileReader(tempad+"/tomcat/webapps/summer/WEB-INF/classes/files/imp/idvalue.txt"));
          
           while((content= in.readLine())!=null)
       {
           String s[]=content.split("\\s");
           
           for(int i=0;i<s.length;i++)
           {
                   id=Integer.parseInt(s[i]);
           }
          
       }
           //out.print(id);
          int tempid=id+1;
          
          PrintWriter outtofile=new PrintWriter(new FileOutputStream(file1,false));
          outtofile.write(""+tempid);
                   outtofile.flush();
          
}
catch(Exception e)
{

}
       out.println("<!DOCTYPE html>");
            out.println("<html>");
//            out.println("<meta http-equiv=refresh content=10;>");
            out.println("<head>");
		//script to check name
	out.print("<script>\n" +
"	 function check()\n" +
"	 {\n" +
"    var x = document.getElementById(\"namevalue\").value;\n" +
"    if (x.includes(\",\")) {\n" +
"        alert(\"Name should not include ' , '(comma): \");\n" +
"        return false;\n" +
"    }\n" +
"	return true;\n" +
"\n" +
"	 }\n" +
"	 </script>");
		//......................
            out.println("<title>Registration Form</title>"
                    + "<link rel=\"stylesheet\" type=\"text/css\" href=\"layout.css\"><link rel=\"stylesheet\" type=\"text/css\" href=\"form.css\">");            
            out.println("</head>");
            out.println("<body>");
            out.println("<body>" +
"       <div class=\"header\" ><b><center><h1 style='color: black;'>Billing Software</h1></center></div><br><h1>Welcome User!</h1></div>\n" +
"        <br>\n" +
"        <div class=form-style-5>" +
"        <form action=\"savetofile\" method=\"post\" onsubmit=\"return check()\" enctype=\"multipart/form-data\"><br><br>\n");
            out.println("<fieldset><input type=hidden name=id value="+id);
out.println("<label for=\"name\" ><legend><b>Name</b></legend></label>\n" +
"            <input type=\"text\" name=\"pname\" id=\"namevalue\" placeholder=\"Product Name\" style=\"border-radius: 8px;width: 100%; height: 50px\" required><br>\n" +
"            <br><legend><label for=\"name\" ><b>Image</b></legend></label>\n" +
"            <input type=\"file\" name=\"pimage\" placeholder=\"Product Image\" style=\"border-radius: 8px;width: 100%; height: 50px\"required><br>           \n" +
"            <br><legend><label for=\"quantity\"><b>Quantity</b></legend></label>\n" +
"            <input type=\"number\" enctype=\"multipart/form-data\" name=\"pquantity\" placeholder=\"Product Quantity\" style=\"border-radius: 8px;width: 100%; height: 50px\" required><br>\n" +
"            <br><legend><label for=\"price\" ><b>Price</b></legend></label>\n" +
"            <input type=\"number\" name=\"pprice\" placeholder=\"Product Price\" style=\"border-radius: 8px;width: 100%; height: 50px\"required>\n" +
"            <br><br> \n" +
"<button  type=submit style=\"background-color: #4CAF50; color: white;padding: 14px 20px;margin: 8px 0;border: none;cursor: pointer;width: 45%; height: 50px;border-radius: 8px;\">Save</button>"
        + "&nbsp;&nbsp;<a href=\"adminregister.jsp\"><button  type=button style=\"background-color: #4CAF50; color: white;padding: 14px 20px;margin: 8px 0;border: none;cursor: pointer;width: 45%; height: 50px;border-radius: 8px;\">Back</button></a>"
        + "     </fieldset>   </form>\n" +
"   </div> </body>\n" +
"</html>\n" +
"");
           out.println("</body>");
            out.println("</html>");
            
       // }
      
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
