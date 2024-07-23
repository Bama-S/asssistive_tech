
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**

 *
 * @author ashwi
 */
public class textwrite extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    //***************************************************************************
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String ramount= request.getParameter("receivedamount");
        int receivedamount=Integer.parseInt(ramount);
         int total=0;
			
       File file1=new File("C:/tomcat/webapps/summer/WEB-INF/classes/files/imp/Billdetails.txt");
                file1.createNewFile();
                PrintWriter outtotemp=new PrintWriter(new FileOutputStream(file1,false));
        String company = ""
                + "          VIDYASAGAR\r\n"
                + "    (Spastics Society of India) \r\n"
                + "\r\n    No:1, Ranjith Road,\r\n"
				+ "    Kotturpuram, \r\n"
				+ "    Chennai-85.\r\n"
                + "\r\n"
                + "CUSTOMER INVOICE\r\n"
                + " \r\n";
				outtotemp.write(company);
				outtotemp.write("+-----------------------+---------------------------------+");
		    outtotemp.write("\r\n|                SELLING DETAILS                          |");
		    outtotemp.write("\r\n+--------------------+--------+------------+--------------+");
			outtotemp.write("\r\n|ITEM                |  QTY   |  PRICE($)  |       VALUE  |");
			outtotemp.write("\r\n+--------------------+--------+------------+--------------+");
				
	   
	   //function to write all the items in pdf file
			Scanner s=new Scanner(new File("C:/tomcat/webapps/summer/WEB-INF/classes/files/pvalues/currentitems.txt"));
			while(s.hasNext())
			{
                        String line =s.nextLine();
						Scanner tempvalue=new Scanner(line).useDelimiter(",");
                        String id=tempvalue.next();
                        String quantity=tempvalue.next();
					Scanner s1=new Scanner(new File("C:/tomcat/webapps/summer/WEB-INF/classes/files/pvalues/pdetails.txt"));
                    while(s1.hasNext())
                    {
                        String line1=s1.nextLine();
                        Scanner tempvalue1=new Scanner(line1).useDelimiter(",");
                        String id1=tempvalue1.next();
                        String name1=tempvalue1.next();
                        String quantity1=tempvalue1.next();
                        String  price1 = tempvalue1.next();
                        
                   				if (id.equals(id1)&!id.equals("0")) 
								{
									int cquantity=Integer.parseInt(quantity);
									int iprice=Integer.parseInt(price1);
									int rateperitem=cquantity*iprice;
									String rrateperitem=(""+rateperitem);
									//insert current items into table
									outtotemp.write("\r\n|"+name1);
									for(int i=name1.length();i<20;i++)
										outtotemp.write(" ");
									
									outtotemp.write("|");
									outtotemp.write(quantity);
									for(int i=quantity.length();i<8;i++)
									outtotemp.write(" ");
									outtotemp.write("|");
									outtotemp.write(price1);
									for(int i=price1.length();i<12;i++)
									outtotemp.write(" ");
									outtotemp.write("|");
									outtotemp.write(rrateperitem);	
									for(int i=rrateperitem.length();i<14;i++)
									outtotemp.write(" ");
									outtotemp.write("|");
									total=total+rateperitem;
								}
					}
					s1.close();
			}
			s.close();
			//**************************
            
            int balance= receivedamount - total;
			
		   outtotemp.write("\r\n+--------------------+--------+------------+--------------+\r\n");
		   outtotemp.write("\r\n                            PAYABLE :"+total);
           outtotemp.write("\r\n                               CASH :"+receivedamount);
		   outtotemp.write("\r\n                            BALANCE :"+balance);
		outtotemp.flush();
		outtotemp.close();
			 
		response.sendRedirect("print");
		
		
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
