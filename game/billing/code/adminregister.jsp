<%-- 
    Document   : adminregister
    Created on : May 18, 2018, 10:07:13 AM
    Author     : ashwi
--%>

<%@page import="javax.xml.bind.DatatypeConverter"%>
<%@page import="javax.imageio.ImageIO"%>
<%@page import="java.io.ByteArrayOutputStream"%>
<%@page import="java.awt.image.BufferedImage"%>
<%@page import="java.awt.Graphics"%>
<%@page import="java.util.Scanner"%>
<%@page import="java.io.File"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head><link rel="stylesheet" type="text/css" href="layout.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>REGISTERATION PAGE</title>
    </head>
    <body bgcolor="black" text=white>
        <div class="header"><h1 style="color: black;">Billing Software</div>
        <div class="topnav"><h1 style="color: white">Product Details</h1></div>
         <%  
		 		  String tempad="C:";

            String username=request.getParameter("uname");
            if(username!=null)
            out.println("Welcome "+username+"!");
            else
            out.println("Welcome User!");
           %> 
           
           <table class="container">
           <% Scanner s=new Scanner(new File(tempad+"/tomcat/webapps/summer/WEB-INF/classes/files/pvalues/pdetails.txt"));
           %>
           <tr><td>Image</td><td>Id</td><td>Name</td><td>Quantity</td><td>Price</td><td>Edit</td><td>Remove</td></tr>
                <%
                    while(s.hasNext())
                    {
                        String line=s.nextLine();
                        Scanner tempvalue=new Scanner(line).useDelimiter(",");
                        String id=tempvalue.next();
                        String name=tempvalue.next();
                        String quantity=tempvalue.next();
                        String price=tempvalue.next();
						if(id.equals("0"))
						{
						}
						else
						{
							
                      %>
           
                <tr>
                    <td><img src="http://localhost:8080/summer/serveimage?id=<%=id%>" width="100" ></td>
                    <td><%=id%>&nbsp;&nbsp;</td>
                
                <td><%=name%></td>
                <td><%=quantity%></td>
                <td><%=price%></td>
                <td><a href="adminpedit.jsp?id=<%=id%>"><button type="button" style="background-color: #4CAF50;color: white;padding: 14px 20px;margin: 8px 0;border: none;cursor: pointer;border-radius: 8px;">Edit&nbsp;</button></a></td>
                    <td><a href="remove.jsp?id=<%=id%>"><button type="button" style="background-color: #4CAF50;color: white;padding: 14px 20px;margin: 8px 0;border: none;cursor: pointer;border-radius: 8px;">Remove</button></a></td>
                </tr>
                
						<% }}
                   %>
                   <tr>
                       <th colspan="7"><a href="register2"><button type="button" style="background-color: #4CAF50;color: white;padding: 14px 20px;margin: 8px 0;border: none;cursor: pointer;border-radius: 8px;">New Product</button></a>&nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="index.html"><button type="button" style="background-color: #4CAF50;color: white;padding: 14px 20px;margin: 8px 0;border: none;cursor: pointer;border-radius: 8px;">Log Out</button></a></th>
                </tr>
           </table>
         
    </body>
</html>
