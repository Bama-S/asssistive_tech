<%-- 
    Document   : adminregister
    Created on : May 18, 2018, 10:07:13 AM
    Author     : ashwi
--%>

<%@page import="java.io.FileReader"%>
<%@page import="java.io.BufferedReader"%>
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
        
        <title>Remove Product</title>
        <!-- script to produce scan algorithm-->
        <link rel="stylesheet" type="text/css" href="layout.css">
    
    <% String temporarysize1=request.getParameter("size");
       String temporaryspeed=request.getParameter("speed");
 int size=Integer.parseInt(temporarysize1);
 int speed1=Integer.parseInt(temporaryspeed);
          int speed=speed1; 
          //assigning correct values to speed variable
		  String tempad="C:";
    %>
<script src="jquery.min.js"></script>
<!-- script to perform scan operation-->
<script>
var x=1,i;

$(window).click(function(e) {
                          //alert(valuetosend);
                     
                     if(speed<maxvalue)
                     {
                        var id=$("#subrow"+speed).html();
                      if(isNaN(id))
					  {
						  location.reload();
					  }
					  else
					  {
						  window.location="iremove.jsp?"+"id="+id+"&size=<%=size%>&speed=<%=speed%>";
					  }
                         
                     }
                     else
                     {
                      window.location="ichange.jsp?size=<%=size%>&speed=<%=speed%>";                     
                     }
});

</script>
   <%
    BufferedReader reader = new BufferedReader(new FileReader(tempad+"/tomcat/webapps/summer/WEB-INF/classes/files/pvalues/currentitems.txt"));
int lines = 0;
while (reader.readLine() != null) lines++;
reader.close();
    %>    
<script>
var x=0,i,maxvalue=<%=lines%>,sizetemp,size1,speed=0, crctscroll=1;
</script>

<script>
function func(){
setInterval(function(){
    

        if(x==0){
                var temp=maxvalue;
                $("#"+temp).attr("style","background-color: #323C50;  padding : 15px 32px;font-size:"+<%=size%>+"px;");
                }

    for(i=0;i<x;i++){
    $("#"+i).attr("style","background-color: #323C50;  padding : 15px 32px;font-size:"+<%=size%>+"px;");
    }
    $("#"+i).attr("style","background-color: red; color: black; padding : 15px 32px;font-size:"+<%=size%>+"px;");
        speed=x;<!--function to play audio-->
        if(x==maxvalue)
		{
		document.getElementById("audio").play();
		}
	
		x++;
            if(x%4==2)
{
    $('html, body').animate({
						scrollTop: $("."+crctscroll).offset().top
					}, 500);
                                        crctscroll=crctscroll+4;
}

    if (x > maxvalue){
    x=0;
    crctscroll=1;
    }
},<%=speed%>*1000);

}
</script> 
<!-- ////////////////////////////////////////-->
    </head>
    <body  text=white onload="func()" style="font-size: 52">
	<audio autoplay>
    <source src="voicemp3/selecttheproductstoremove.mp3" type="audio/mp3" />
	</audio>
        <div class="header"><h1 style="color: black;">Billing Software</div>
        <div class="topnav"><p style="color: white; font-size:<%=size%>px;"><b>Product Details</p></div>
         <%  
            String username=request.getParameter("uname");
            if(username!=null)
            out.println("Welcome "+username+"!");
            else
            out.println("Welcome User!");
           %> 
           <% 
               int rowid=1;
               int ppid=0;
               String pid=null;
               String pname=null;
            String pquantity=null;
            String pprice=null;
            int outertemp=0;
            int innertemp=0;
            
               %>
           <table class="container" border="0" style="font-size: <%=size%>px;" >
           <% rowid=1;
               Scanner s=new Scanner(new File(tempad+"/tomcat/webapps/summer/WEB-INF/classes/files/pvalues/currentitems.txt"));
           %>
           <tr><td><b>Image</td><td><b>Id&nbsp;&nbsp;</td><td><b>Name</td><td><b>Quantity</td><td><b>Price&nbsp;</td></tr>
                <%
                    while(s.hasNext())
                    {
                        String line=s.nextLine();
                        Scanner tempvalue=new Scanner(line).useDelimiter(",");
                        pid=tempvalue.next();
                        pquantity=tempvalue.next();
                        


//jsp function to retrieve the other values from pdetails.txt

            Integer gnid=Integer.parseInt(pid);//parses the id got from the previous page
            File details=new File(tempad+"/tomcat/webapps/summer/WEB-INF/classes/files/pvalues/pdetails.txt");
            Scanner pdetailss=new Scanner(details);
            
                while(pdetailss.hasNext())
                    {
                        String pline=pdetailss.nextLine();
                        Scanner ptempvalue=new Scanner(pline).useDelimiter(",");
                            String pid1=ptempvalue.next();
                             ppid=Integer.parseInt(pid1);
                            //out.println(eg+"df");
                            if(ppid==gnid)
                            {
                              
                                pname=ptempvalue.next();
                                ptempvalue.next();
                                pprice=ptempvalue.next();
                                break;
                            }
                            else
                            {
                            }
                            ptempvalue.close();
                            ptempvalue.close();
                    }
                
            pdetailss.close();
          if(gnid!=0){
                %>
           
                <tr id="<%=outertemp%>" class="<%=rowid%>" >
                <%
				int imagesize=size+100;
				%>
                    <td><b><img src="http://localhost:8080/summer/serveimage?id=<%=pid%>" width="<%=imagesize%>" ></td>
                <!--<td><img src="C:\Users\ashwi\Desktop\spastic society\files\pimages\2.jpg"></td>-->
                    <td id="subrow<%=outertemp%>"><%=pid%></td>
                
                <td><b><%=pname%></td>
                <td><b><%=pquantity%></td>
                <td><b><%=pprice%></td>
                </tr>
                    <% rowid++; }
		else
		{
		}
                 tempvalue.close();
                    //out.println(outertemp);
                    outertemp++;}

s.close();
                   %>
                   
                   <tr id="<%=outertemp%>" class="<%=(lines+1)%>">
                    <td colspan="5" id="subrow<%=outertemp%>"><button type="button" style="font-size:<%=size%>px; background-color: #4CAF50;color: black;padding: 20px 20px;margin: 8px 0;border: none;cursor: pointer;border-radius: 8px; width:100%; height=100%;"><b>Back</button></a></td>
                  <audio id="audio">
                <source src="voicemp3/GoBack.mp3" type="audio/mp3" />
                </audio>      
            </tr>
           
           </table>
                 	
    </body>
</html>
