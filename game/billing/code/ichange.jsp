<%@page import="javax.xml.bind.DatatypeConverter"%>
<%@page import="javax.imageio.ImageIO"%>
<%@page import="java.io.ByteArrayOutputStream"%>
<%@page import="java.awt.image.BufferedImage"%>
<%@page import="java.awt.Graphics"%>
<%@page import="java.util.Scanner"%>
<%@page import="java.io.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head> <script src="jquery.min.js"></script>
        <link rel="stylesheet" type="text/css" href="layout.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Items</title>  

<%! int itotal; %>
        <%
		     String tempad="C:";
            String sizestring=request.getParameter("size");
	    int size=Integer.parseInt(sizestring);
		int ssize=size;	
            String speed=request.getParameter("speed");
 BufferedReader reader2 = new BufferedReader(new FileReader("C:/tomcat/webapps/summer/WEB-INF/classes/files/pvalues/currentitems.txt"));
     itotal = 0;
     while (reader2.readLine() != null) itotal++;
	 
     reader2.close();        
    %>
        <script>
var x=1,i,maxvalue=4,size=1, crctscroll=1, looptimes=0, itotal=<%=itotal%> ;
</script>
<script>
function func(){
setInterval(function(){
looptimes++;        
if(looptimes%4==1)
{
    $('html, body').animate({
						scrollTop: $("."+crctscroll).offset().top
					}, 500);
                                        crctscroll=crctscroll+4;
}
    
    
if(x==1){
var temp=maxvalue;
$("#"+temp).attr("style","border-radius: 8px;background-color:#4CAF50; color: black;text-align: center; padding : 15px 32px;font-size:"+<%=ssize%>+"px;");
}
for(i=1;i<x;i++){
$("#"+i).attr("style","border-radius: 8px;background-color:#4CAF50; color: black;text-align: center; padding : 15px 32px;font-size:"+<%=ssize%>+"px;");
}
$("#"+i).attr("style","border-radius: 8px;background-color:red; color: black;text-align: center; padding : 15px 32px;font-size:"+<%=ssize%>+"px;");
size=x;
<!--function to play audio-->
    document.getElementById("audio"+x).play();
x++;
if(looptimes>itotal){ looptimes=0;}
if (x > maxvalue){
x=1;
}
},<%=speed%>*1000);
}  
 $(window).click(function(e) {
        if(size==1)
        {
        window.location = "iselect.jsp?speed=<%=speed%>&size=<%=size%>";
    }
   else  if(size==2)
        {
        window.location = "uremove.jsp?speed=<%=speed%>&size=<%=size%>";
    }
    else if(size==3)
        {
        window.location = "isubmit?speed=<%=speed%>&size=<%=size%>";
        }
	else if(size==4)
		{
			window.location="index.html";
		}
    
    }
    );
</script>  
    </head>
   
    <body id="11" onload="func()"  bgcolor="black" text=white>
        <div class="header"><h1 style="color: black;">Billing Software</div>
        <div class="topnav"><p style="color: white; font-size:<%=size%>px;"><b>Product Details</p></div>  
       
    <audio autoplay>
    <source src="voicemp3/theselectedproductsare.mp3" type="audio/mp3" />
	</audio>
   <script type='text/javascript'>
    
   
</script>
  
        </script>    
       
      
      
      <table class="container"style="font-size: <%=size%>px;">
               
                                      
               <% 
                int currenttotal=0;                
				int rowid=1;
                   Scanner s=new Scanner(new File(tempad+"/tomcat/webapps/summer/WEB-INF/classes/files/pvalues/currentitems.txt"));
           %>
               <tr><td><b>Image</td><td><b>Id&nbsp;&nbsp;</td><td><b>Name</td><td><b>Quantity</td><td><b>Rate&nbsp;</td><td>Price&nbsp;</td></tr>
               <%       
                while(s.hasNext()){
                       String line =s.nextLine();
                Scanner tempvalue=new Scanner(line).useDelimiter(",");
                        String id=tempvalue.next();
                        String quantity=tempvalue.next();
                        int qty=Integer.parseInt(quantity);
                        
                        int id111=Integer.parseInt(id);
                        
                     
               
                 Scanner s1=new Scanner(new File(tempad+"/tomcat/webapps/summer/WEB-INF/classes/files/pvalues/pdetails.txt"));
               
                
                    while(s1.hasNext())
                    {
                        String line1=s1.nextLine();
                        Scanner tempvalue1=new Scanner(line1).useDelimiter(",");
                        String id1=tempvalue1.next();
                        String name1=tempvalue1.next();
                        String quantity1=tempvalue1.next();
                        String  price1 = tempvalue1.next();
                        
                      String id11=id1;
                      int idd=Integer.parseInt(id1);
                     
                   String name11=name1;
                   String price11=price1; 
                   int quantity11=Integer.parseInt(quantity1);
                   
                   
				int imagesize=size+100;
				%>
                   <tr class="<%=rowid%>">
                         <% 
				
				if (id111==idd&id111!=0) {  if(qty<=quantity11){ %>
                    <td><img src="http://localhost:8080/summer/serveimage?id=<%=id1%>" width="<%=imagesize%>" ></td>
                <td ><b><%=id%>&nbsp;&nbsp;</td>
                 <td><b><%=name1%>&nbsp;&nbsp;</td>
                <td><b><%=qty%>&nbsp;&nbsp;</td>
                <td><b><%=price1%>&nbsp;&nbsp;</td> 
				<td><b><%=(Integer.parseInt(price1)*(qty))%></td><%  
				currenttotal=currenttotal + (Integer.parseInt(price1)*(qty));
				%>
				
                </tr>
            <%  rowid++;
                   }
            else
            {%>
            <td colspan="5">Invalid Quantity:</td></tr>
	
             <%	
		//Request Dispatcher removerd=request.getRequestDispatcher("iremove.jsp?id="+id1+"&size="+size+"&speed="+speed);
		//removerd.include(request,response);
		response.sendRedirect("info.jsp?id="+id1+"&size="+size+"&speed="+speed+"&infoid=3");
			}	
                }
                   %>
                    <% }}                   %>
                <tr><td colspan="5">Total : </td><td><%=currenttotal%></td>
				</tr>
                   <tr>
                <th colspan="7"><a href="iselect.jsp?speed=<%=speed%>&size=<%=size%>"><button  id="1" type="button"  style="border-radius: 8px;background-color : #4CAF50 ; color: black;text-align: center; padding : 15px 32px;font-size:<%=size%>px;">ADD</button></a>&nbsp;&nbsp;&nbsp;&nbsp;
                <audio id="audio1">
                 <source src="voicemp3/add.mp3" type="audio/mp3" />
                </audio>    
                <a href="uremove.jsp?speed=<%=speed%>&size=<%=size%>"><button id="2"type="button" style="border-radius: 8px;background-color : #4CAF50 ; color: black;text-align: center; padding : 15px 32px;font-size:<%=size%>px;">REMOVE</button></a>&nbsp;&nbsp;&nbsp;&nbsp;
                <audio id="audio2">
                <source src="voicemp3/remove.mp3" type="audio/mp3" />
                </audio>
                 <a href="isubmit?speed=<%=speed%>&size=<%=size%>"><button id="3" type="button"style="border-radius: 8px;background-color : #4CAF50 ; color: black;text-align: center; padding : 15px 32px;font-size:<%=size%>px;">SUBMIT</button></a>&nbsp;&nbsp;&nbsp;&nbsp;
                <audio id="audio3">
                <source src="voicemp3/submit.mp3" type="audio/mp3" />
                </audio>
				<button id="4" type="button"style="border-radius: 8px;background-color : #4CAF50 ; color: black;text-align: center; padding : 15px 32px;font-size:<%=size%>px;">CANCEL</button>&nbsp;&nbsp;&nbsp;&nbsp;</th>
                <audio id="audio4">
                <source src="voicemp3/Cancel.mp3" type="audio/mp3" />
                </audio>
                    </tr>
           </table>
         
    </body>
</html>