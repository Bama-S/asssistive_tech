/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author ashwi
 */
public class isubmit extends HttpServlet {

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
    //function to edit the pdetails file
    void change(String id4,int quantity) throws FileNotFoundException, IOException
    {
        int id=Integer.parseInt(id4);
            File details=new File(tempad+"/tomcat/webapps/summer/WEB-INF/classes/files/pvalues/pdetails.txt");
            Scanner s=new Scanner(details);
                File file1=new File(tempad+"/tomcat/webapps/summer/WEB-INF/classes/files/pvalues/file1.txt");
                file1.createNewFile();
                PrintWriter outtotemp=new PrintWriter(file1); 
                     while(s.hasNext())
                    {
                        String line=s.nextLine();
                        Scanner tempvalue=new Scanner(line).useDelimiter(",");
                            String id1=tempvalue.next();
                            String name1=tempvalue.next();
                            String quantity1=tempvalue.next();
                            String price1=tempvalue.next();
                            int pid=Integer.parseInt(id1);
                            int qty1=Integer.parseInt(quantity1);
                            //out.println(eg+"df");
                            if(id==pid)
                            {
                               qty1=qty1-quantity;
                                    outtotemp.write(id+","+name1+","+qty1+","+price1+"\r\n");
                            }
                            else
                            {
                                outtotemp.write(line);
                                outtotemp.write("\r\n");
                            }
                            tempvalue.close();
                            tempvalue.close();
                    }
                 outtotemp.flush();
                outtotemp.close();
            s.close();
        FileUtils.forceDelete(details);
       file1.renameTo(details);  
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try{
            /* TODO output your page here. You may use following sample code. */

               String speed=request.getParameter("speed");
               String size=request.getParameter("size");
               
               Scanner s=new Scanner(new File(tempad+"/tomcat/webapps/summer/WEB-INF/classes/files/pvalues/currentitems.txt"));
               while(s.hasNext())
               {
                   String line=s.nextLine();
                   Scanner tempscanner=new Scanner(line).useDelimiter(",");
                   String id=tempscanner.next();
                   String quantity=tempscanner.next();
                   int qty=Integer.parseInt(quantity);
                   change(id,qty);
               }
               s.close();
               
              response.sendRedirect("ibill.jsp?size="+size+"&speed="+speed);


            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet isubmit</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet isubmit at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
        catch(Exception e)
        {
            out.println(e);
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

