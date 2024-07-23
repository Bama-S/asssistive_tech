<%@page import="javax.xml.bind.DatatypeConverter"%>
<%@page import="javax.imageio.ImageIO"%>
<%@page import="java.io.ByteArrayOutputStream"%>
<%@page import="java.awt.image.BufferedImage"%>
<%@page import="java.awt.Graphics"%>
<%@page import="java.util.Scanner"%>
<%@page import="java.io.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<html>
    <head>
	<title>Billing</title>
        <link rel="stylesheet" type="text/css" href="layout.css">  
        <script src="jquery.min.js"></script>
		<%! int no, counterr=0, itotal;%>
    <% 
	String sizestring =request.getParameter("size");
	String speed=request.getParameter("speed");
	int sspeed=Integer.parseInt(speed); 
	String ramount=request.getParameter("receivedamount");
	int receivedamount=Integer.parseInt(ramount);

     BufferedReader reader = new BufferedReader(new FileReader("C:/tomcat/webapps/summer/WEB-INF/classes/files/pvalues/currentitems.txt"));
      no = 0;
     while (reader.readLine() != null) no++;
     reader.close();
      
           // out.println("Number of files: " + no);      
	
	%>
        <script>
            var crctscroll=1;
	</script>
		<script>
var x=1,i,maxvalue=3,size=1, iftime=0, no=<%=no%>-1;
</script>
<script>		
function func(){
setInterval(function(){
if(x==1){
    
var temp=maxvalue;
$("#"+temp).attr("style","border-radius: 8px;background-color: #4CAF50;font-size: <%=sizestring%>px;color: black;text-align: center; padding : 15px 32px; ");
}
for(i=1;i<x;i++){
$("#"+i).attr("style","border-radius: 8px;background-color: #4CAF50;font-size: <%=sizestring%>px;color: black;text-align: center; padding : 15px 32px; ");
}
$("#"+i).attr("style","border-radius: 8px;background-color: red;font-size: <%=sizestring%>px;color: black;text-align: center; padding : 15px 32px; ");
size=x;
//function to play audio
    document.getElementById("audio"+i+"1").play();

x++;
if (x > maxvalue){
x=1;
}
},<%=sspeed%>*1000);
}
</script>
	
        <script>
    function func1(){
        setInterval(function(){
//$('body,html').animate({scrollTop: 200}, 500); 
    //window.scrollBy(200,0);   

scrolfunc();
    },3000)
   }
            
    function scrolfunc(){
		$('html, body').animate({
						scrollTop: $("."+crctscroll).offset().top
					}, 1000);
crctscroll=crctscroll+3;					

 if((crctscroll>(no+3)) && iftime==0){ iftime=1; digitss();}
 
/*	window.scrollBy(0, window.innerHeight); console.log('start'); */
  //  window.scrollTo(1000, 0);
 // $('body,html').animate({scrollTop: 900}, 500);  
 // $(window).scrollTop(900);
 // window.scrollBy(0,1);
  //  scrolldelay = setTimeout(func3,10);
  //window.scrollBy(10000,0);
}
    
        </script>
		<script>
	$(window).click(function(e) {
	if(size==1)
	{
		window.location = "textwrite?receivedamount=<%=receivedamount%>";
	}
	else if(size==2)
	{
		window.location = "icancel";
	}
	else if(size==3)
	{
		window.location = "reset?infoid=1";
	}
     //     
	}
	);
function reverse_a_number(n)
	{
		n = n + "";
		return n.split("").reverse().join("");
	}
	
	</script>
    </head>
    <body onload="func1()">
	<audio autoplay id="infoaudio">
    <source src="voicemp3/thebillamountis.mp3" type="audio/mp3" />
	</audio>
    <%
        int size=Integer.parseInt(sizestring);
 
    %>
    <% 
        String[] id=new String[no];
        String qty[]= new String[no];
        String getid;
        int i,k=0, total=0;
        
    %>
    <%
        
       
    Scanner s1= new Scanner(new File("C:/tomcat/webapps/summer/WEB-INF/classes/files/pvalues/currentitems.txt"));   
    
    while(s1.hasNext())
    {
                         String line= s1.nextLine();
                      
                       Scanner s2= new Scanner(line).useDelimiter(",");
                      
                        id[k]= s2.next();
                        qty[k]= s2.next();
                        
                       k++;
                      
    }
    s1.close(); 
    %>
    <div class="header"><h1 style="color: black;">Billing Software</h1></div>
        <div class="topnav"><h1 style="color: white">Product Details</h1></div>  
       
    <table class="container" style="font-size: <%=size%>px;">
        <tr><td>Image</td><td>ID</td><td>Name</td><td>quantity</td><td>Rate</td><td>Price</td></tr><% 
    
    
    Scanner scan1= new Scanner(new File("C:/tomcat/webapps/summer/WEB-INF/classes/files/pvalues/pdetails.txt"));
    counterr=0 ;
    int line0=0;
  
    while(scan1.hasNext())
    {
        if(line0==0){
        scan1.nextLine();
        line0=1;
        }
                       String lines= scan1.nextLine();
                       Scanner scan2= new Scanner(lines).useDelimiter(",");
                       getid=scan2.next();
                       
                       //out.println(getid+",");
                       
                       for(i=0;i<k;i++)
                       {
                           
                          if(id[i].equals(getid))
                          {
                              counterr++;
                              %>
                              <tr class="<%=counterr%>">
				<td><img src="http://localhost:8080/summer/serveimage?id=<%=getid%>" width="<%=size+150%>" alt="Sorry Network Error :("></td>
				<td><%=getid%></td>
				<td><%=scan2.next()%></td>
				<td><%=qty[i]%></td>
				<%
					scan2.next(); 
					int rate=Integer.parseInt(scan2.next());
				%>
				<td><%=rate%></td>
				<% 
						total= total+ (rate * Integer.parseInt(qty[i]));
				%>
				<td><%=(rate * Integer.parseInt(qty[i]))%></td>
                              </tr>
                              
			 <% 
                           
                          }
                       }
    }
    scan1.close();
    %>
                              <tr class=<%=(counterr+1)%>><td colspan="5" align="center" style=" font-size: <%=size%>px;">TOTAL</td><td><%=total%></td></tr>
                              <tr class=<%=(counterr+2)%>><td colspan="5" align="center" style=" font-size: <%=size%>px;">RECEIVED AMOUNT</td><td><%=receivedamount%></td></tr>
                              <tr class=<%=(counterr+3)%>><td colspan="5" align="center" style=" font-size: <%=size%>px;">BALANCE</td><td><%=receivedamount-total%></td></tr>
                              
							 <tr><td colspan="6">
                              <button id="1" style="border-radius: 8px;background-color: #4CAF50;font-size: <%=size%>px;color: black;text-align: center; padding : 15px 32px; " >PRINT</button>&nbsp;&nbsp;&nbsp;&nbsp;
                              <button id="2"style="border-radius: 8px;background-color: #4CAF50;font-size: <%=size%>px;color: black;text-align: center; padding : 15px 32px;" >CANCEL</button>					  &nbsp;&nbsp;&nbsp;
                              <button id="3" style="border-radius: 8px;background-color: #4CAF50;font-size: <%=size%>px;color: black;text-align: center; padding : 15px 32px;" >HOME</button>&nbsp;&nbsp;&nbsp;
							  <!--function to play audio-->		
				<audio id="audio11">
                <source src="voicemp3/Print.mp3" type="audio/mp3" />
                </audio>
				<audio id="audio21">
                <source src="voicemp3/Cancel.mp3" type="audio/mp3" />
                </audio>
				<audio id="audio31">
                <source src="voicemp3/Home.mp3" type="audio/mp3" />
                </audio>
                </td></tr>
        </table>
		<!--audio functions to play the final bill value-->
	<audio id="audio0">
		<source src="voicemp3/0.mp3" type="audio/mp3" />
	</audio>
	<audio id="audio1">
		<source src="voicemp3/1.mp3" type="audio/mp3" />
	</audio>
	<audio id="audio2">
		<source src="voicemp3/2.mp3" type="audio/mp3" />
	</audio>
	<audio id="audio3">
		<source src="voicemp3/3.mp3" type="audio/mp3" />
	</audio>
	<audio id="audio4">
		<source src="voicemp3/4.mp3" type="audio/mp3" />
	</audio>
	<audio id="audio5">
		<source src="voicemp3/5.mp3" type="audio/mp3" />
	</audio>
	<audio id="audio6">
		<source src="voicemp3/6.mp3" type="audio/mp3" />
	</audio>
	<audio id="audio7">
		<source src="voicemp3/7.mp3" type="audio/mp3" />
	</audio>
	<audio id="audio8">
		<source src="voicemp3/8.mp3" type="audio/mp3" />
	</audio>
	<audio id="audio9">
		<source src="voicemp3/9.mp3" type="audio/mp3" />
	</audio>
	<script>
	function digitss()
	{	
	document.getElementById("infoaudio").play(); 
	var atotal=reverse_a_number(<%=total%>);
	var i;
	var digits = atotal.toString().split('');
	var digitslength=digits.length;
	window.setTimeout(func,digitslength*<%=speed%>*1000);

	var intervalid=setInterval(function()
	{
		if(digitslength!=0)
		{
			var readnumber=digits[digitslength-1];
			digitslength--;
		document.getElementById("audio"+readnumber).play(); 	
		}
	}	,<%=speed%>*1000);
	
	}

	</script>
	
</body>
    </html> 
