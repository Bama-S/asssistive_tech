<%@page import="java.io.File"%>
<%@page import="java.util.Scanner"%>
<%@page import="java.io.BufferedReader"%>
<%@ page import="java.io.*" %>
<html>
<head><link rel="stylesheet" type="text/css" href="layout.css">
    
    <% 
	String infoid=request.getParameter("infoid");
	String size=request.getParameter("size");
    String speed=request.getParameter("speed");
	
    %>
<script src="jquery.min.js"></script>


<script>
var x=<%=infoid%>
function mainfunc()
{
	if(x==1)
	{
		document.getElementById("demo").innerHTML="&nbsp;<br>Please Click Only When the RED Cursor points to your desired option..!<br>&nbsp;";
	}
	else if(x==2)
	{
		
		document.getElementById("demo").innerHTML="&nbsp;<br>THIS PRODUCT HAS ALREADY BEEN SELECTED:PLEASE TRY AGAIN<br>&nbsp;";
	}
	else if(x==3)
	{
	
		document.getElementById("demo").innerHTML="&nbsp;<br>PRODUCT QUANTITY EXCEEDS MAXIMUM LIMIT.PLEASE TRY AGAIN<br>&nbsp;";
		
	}
	else if(x==4)
	{
		document.getElementById("demo").innerHTML="&nbsp;<br>BILL has been printed successfully!<br>&nbsp;";		
	}
}
	function abc()
	{
		if(x==1)
		{	
			window.location="iselect.jsp?size=<%=size%>&speed=<%=speed%>";
		}
		else if(x==2)
		{
			window.location="ichange.jsp?size=<%=size%>&speed=<%=speed%>";	
		}
		else if(x==3)
		{
			window.location="iremove.jsp?id=<%=request.getParameter("id")%>&size=<%=size%>&speed=<%=speed%>";
		}
		else if(x==4)
		{
			window.location="index.html";		
		}
	}	
</script>
</head>
<body onclick="abc()" onload="mainfunc()">
    <div class="header" style="color: black;"><center><h1><b>Billing Software</b></h1></center>
</div>
<br><br><br>
<b>
<h1 id="demo" style="color: black; font-size: 40px;background-color:white;"></h1><br><center>
<h1 style="color: black; font-size: 40px;background-color:white;">&nbsp;<br>Click anywhere on the Screen to go Back<br>&nbsp;</h1>
	 </body>
</html>
