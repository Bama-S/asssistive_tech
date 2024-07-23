/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Scanner;
import org.apache.commons.io.FileUtils;
/**
 *
 * @author ashwi
 */
@WebServlet(urlPatterns = {"/peditserver"})
public class peditserver extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
         String tempad=System.getProperty("user.dir");
            String tmppid=request.getParameter("pid");
            int pid=Integer.parseInt(tmppid);
            
           
            String  pname=request.getParameter("pname");
            String pquantity=request.getParameter("pquantity");
            String pprice=request.getParameter("pprice");        
            //out.println(tmppid+pname+pprice);
            
//function to remove the existing item from the file
           
            int gnid=pid;
            File details=new File(tempad+"\\tomcat\\webapps\\summer\\WEB-INF\\classes\\files\\pvalues\\pdetails.txt");
            
            Scanner s=new Scanner(details);
                File file1=new File(tempad+"\\tomcat\\webapps\\summer\\WEB-INF\\classes\\files\\pvalues\\file2.txt");
                file1.createNewFile();
                PrintWriter outtotemp=new PrintWriter(file1); 
                     while(s.hasNext())
                    {
                        String line=s.nextLine();
                        Scanner tempvalue=new Scanner(line).useDelimiter(",");
                            String id1=tempvalue.next();
                            int id=Integer.parseInt(id1);
                            //out.println(eg+"df");
                            if(id==gnid)
                            {
                                    
                            }
                            else
                            {
                                outtotemp.write(line);
                                outtotemp.write("\r\n");
                            }
                            tempvalue.close();
                            tempvalue.close();
                    }
                outtotemp.write(pid+","+pname+","+pquantity+","+pprice+"\r\n"); 
                outtotemp.flush();
                outtotemp.close();
            s.close();
        	FileUtils.forceDelete(details);
		
            file1.renameTo(details);
            response.sendRedirect("adminregister.jsp");
            

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
