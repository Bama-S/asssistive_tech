<%-- 
    Document   : remove
    Created on : May 19, 2018, 10:01:12 AM
    Author     : ashwi
--%>

<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.Scanner"%>
<%@page import="java.io.File"%>
<%@page  import="org.apache.commons.io.FileUtils"%>
<%@page import="java.io.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%         String tempad="C:";

            String tmpgnid=request.getParameter("id");
            Integer gnid=Integer.parseInt(tmpgnid);//parses the id got from the previous page
            File details=new File(tempad+"/tomcat/webapps/summer/WEB-INF/classes/files/pvalues/pdetails.txt");
            Scanner s=new Scanner(details);
                File file1=new File(tempad+"/tomcat/webapps/summer/WEB-INF/classes/files/pvalues/tempfile.txt");
                File imagefile=new File(tempad+"/tomcat/webapps/summer/WEB-INF/classes/files/pimages/"+gnid+".jpg");
                file1.createNewFile();
                PrintWriter outtotemp=new PrintWriter(new FileOutputStream(file1,false)); 
				int tempvariable=1;
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
								if(tempvariable==1)
								{}
							else{    outtotemp.write("\r\n");
							}
                                outtotemp.write(line);
                            tempvariable++;
                            }
                            tempvalue.close();
                            tempvalue.close();
                    }
                 outtotemp.flush();
                outtotemp.close();
            s.close();
			File details2=new File(tempad+"/tomcat/webapps/summer/WEB-INF/classes/files/pvalues/pdetails.txt");
	PrintWriter outtopdetails=new PrintWriter(new FileOutputStream(details2,false));
    File tempfile1=new File(tempad+"/tomcat/webapps/summer/WEB-INF/classes/files/pvalues/tempfile.txt");
 	Scanner s4=new Scanner(tempfile1);
	int temp2variable=1;
	while(s4.hasNext())
	{
		if(temp2variable==1)
		{
		}
		else
		{outtopdetails.write("\r\n");
		}
		String templine=s4.nextLine();
		outtopdetails.write(templine);
  		temp2variable++;
	}
	s4.close();
	outtopdetails.flush();
	outtopdetails.close();

            imagefile.delete();
            response.sendRedirect("adminregister.jsp");
        %>
        
    </body>
</html>
