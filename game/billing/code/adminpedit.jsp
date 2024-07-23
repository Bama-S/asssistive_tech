<%-- 
    Document   : adminpedit
    Created on : May 19, 2018, 10:25:05 AM
    Author     : ashwi
--%>

<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.Scanner"%>
<%@page import="java.io.File"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EDIT Page</title><link rel="stylesheet" type="text/css" href="layout.css">
<link rel="stylesheet" type="text/css" href="form.css">
        <%
				 		  String tempad="C:";

            int pid=0;
            String pname=null;
            String pquantity=null;
            String pprice=null;
            
            %>
    </head>
    <body>
        <%
            String tmpgnid=request.getParameter("id");
            Integer gnid=Integer.parseInt(tmpgnid);//parses the id got from the previous page
            File details=new File(tempad+"/tomcat/webapps/summer/WEB-INF/classes/files/pvalues/pdetails.txt");
            Scanner s=new Scanner(details);
            
                while(s.hasNext())
                    {
                        String line=s.nextLine();
                        Scanner tempvalue=new Scanner(line).useDelimiter(",");
                            String id1=tempvalue.next();
                            int id=Integer.parseInt(id1);
                            //out.println(eg+"df");
                            if(id==gnid)
                            {
                                pid=id;
                                pname=tempvalue.next();
                                pquantity=tempvalue.next();
                                pprice=tempvalue.next();
                            }
                            else
                            {
                            }
                            tempvalue.close();
                            tempvalue.close();
                    }
                
            s.close();
            
            %>
            
    <div class="header" ><b><center><h1 style='color: black;'>Billing Software</h1></center>
</div> 
            <h1>Welcome User!</h1><br><br>
            <div class='form-style-5'>
                <form action="peditserver.jsp" method="post"><fieldset>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="http://localhost:8080/summer/serveimage?id=<%=pid%>" width="200"> <br><br>
        <!--<label for="ID" ><b>PID</b></label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;-->
        <input type="hidden" name="pid" value=<%=pid%> placeholder=<%=pid%> style=" border-radius: 8px;width: 300px; height: 40px;"><br>
        <br><legend><label for="name"><b>Name</b></label></legend>
       <input type="text"  name="pname" value=<%=pname%> style=" border-radius: 8px;width: 100%; height: 50px;" required>
              <br><legend><label for="quantity"><b>Quantity</b></legend></label>
       <input type="number"  name="pquantity" value=<%=pquantity%> style=" border-radius: 8px;width: 100%; height: 50px;" required>
              <br><legend><label for="price" ><b>Price</b></legend></label>
          <input type="number" name="pprice" value=<%=pprice%> style=" border-radius: 8px;width: 100%; height: 50px;" required> 
                 <br><br>
          <b>Note:Please Enter values in every columns:</b><br><br> 
         <button  type=submit style="background-color: #4CAF50; color: white;padding: 14px 20px;margin: 8px 0;border: none;cursor: pointer;width: 45%; height: 50px;border-radius: 8px;">Save</button>&nbsp;&nbsp;<a href="adminregister.jsp"><button  type=button style="background-color: #4CAF50; color: white;padding: 14px 20px;margin: 8px 0;border: none;cursor: pointer;width: 45%; height: 50px;border-radius: 8px;">Back</button></a>
                    </fieldset>
                </form>

            </body>
</div>
</html>
</body>
</html>
