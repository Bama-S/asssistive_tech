
<%@page import="java.io.BufferedReader"%>
<%@ page import="java.io.*" %>
<%@ page import="java.util.*"%>
<%! int iiid, valueat1, iter=1;
    String line2, valueat; 
    FileInputStream fs;
 %>

<html>
<head>
<title>Products</title>
<script src="jquery.min.js"></script>
 
<%! int itotal=0,itotal2=0, work=0,noproductid=0; %>
<%
    String size=request.getParameter("size");
    String speed=request.getParameter("speed");
    int spd=Integer.parseInt(speed);
 //  String size="28";
 //  int spd=1;
   //total no of entries in pdetails
   
     
     BufferedReader reader = new BufferedReader(new FileReader("C:/tomcat/webapps/summer/WEB-INF/classes/files/pvalues/pdetails.txt"));
     itotal = 0;
	
     while (reader.readLine() != null) itotal++; 
	 
     reader.close();
      
     //total no of entries in currentitems
     BufferedReader reader2 = new BufferedReader(new FileReader("C:/tomcat/webapps/summer/WEB-INF/classes/files/pvalues/currentitems.txt"));
     itotal2 = 0;
     while (reader2.readLine() != null) itotal2++;
	 
     reader2.close();
    
     //reduce the number of total entries
     
     
            //out.println("Number of files: " + itotal);
%>

<%!
    int maintempid=0;
%>
<script>
$(document).ready(function(){
    $("#109").click(function(){
        times++;
 
        if(times==1){
            clearInterval(gfunc1);
        func2();}
    
         if(times==2)
         {
             iid=f*4-(4-f2);
             clearInterval(gfunc2);
             
            window.location="iquantity.jsp?size="+size+"&speed="+speed+"&id="+iid+"&noproductid=<%=noproductid%>";
    
            
             //func3();
         }
    })
        
    }
);
</script>
<script>
var i, j, s, k, x, gfunc1, gfunc2, f, f2, y=1, maxvalue=<%=(itotal-1)%>, left=0, times=0, mult=1, spd=<%=spd%>, iid=0 , scrollvar=0, speed=<%=spd%>, size=<%=size%>, i1=1, crctscroll=1;
if(maxvalue%4!=0){ left= 1;} 
max= parseInt(maxvalue/4) + left ;
</script>
 
<script>
    
    function func1(){
        gfunc1=setInterval(function(){

       if(y==1 && scrollvar==1){
		   func4();
           //  window.scrollBy(0, max*(-window.innerHeight)); console.log('start');
             scrollvar=0;
			  crctscroll=1;
       }
 


        
        if(y%2==1 && scrollvar==0)
  {
	 
	  func3();
   // window.scrollBy(0, window.innerHeight); console.log('start');
  //$('body,html').animate({scrollTop: 900}, 1000);
  }

 
        
        if(y==1){
                var t=max;
                $("#"+t).attr("style","background-color: black;");
            }
            
            for(j=1;j<y;j++)
            {
              $("#"+(j)).attr("style","background-color: black;");
            }
         $("#"+(j)).attr("style","background-color: red;");  
            f=y;
            y++;
            if (y > max){
                scrollvar=1;
                y=1;
}
  
           },spd*1000);
    }
    
    
    
function func2(){
     x=(f*100)+1;
gfunc2= setInterval(function(){
 
   
if(x==(f*100)+1){
var temp=((f*100)+4);
$("#"+temp).attr("style","background-color: black; font-size: 28px; color: black;text-align: center; padding : 15px 15px ");
}
for(i=(f*100)+1;i<x;i++)
{
           $("#"+(i)).attr("style","background-color: black; font-size: 28px; color: black;text-align: center; padding : 15px 15px ");
}
$("#"+(i)).attr("style","background-color: green; font-size: 28px; color: black;text-align: center; padding : 15px 15px ");
f2=x-(f*100);
x++;


if (x > (f*100)+4)  
{
            x=(f*100)+1;
}
},spd*1000);
} 

function func3()
{
	crctscroll
		$('html, body').animate({
						scrollTop: $("."+crctscroll).offset().top
					}, 500);
crctscroll=crctscroll+2;					
/*	window.scrollBy(0, window.innerHeight); console.log('start'); */
  //  window.scrollTo(1000, 0);
 // $('body,html').animate({scrollTop: 900}, 500);  
 // $(window).scrollTop(900);
 // window.scrollBy(0,1);
  //  scrolldelay = setTimeout(func3,10);
  //window.scrollBy(10000,0);
}
function func4(){

	  window.scrollBy(0, max*(-window.innerHeight)); console.log('start');
}
</script>
</head>
<body onload='func1()' id="109" bgcolor="black">
<audio autoplay>
    <source src="voicemp3/selecttheproducts.mp3" type="audio/mp3" />
</audio>
    <table style=" width: 100%; height:100%; background-color : black;" cellspacing="20px" >
        <thead><font size="36" style="background-color:white;"> SELECT THE PRODUCTS: </font></thead>
		<tr>
    <td align="center" style="background-color: black;"> 
      
        <table class="container" cellspacing="10px" >
        
            <%!
               String checkid[];
               int checki=0;
                String temporaryid;
               int left=0, nrows, cols;
            
               %>
            
              <%
               
               checkid= new String[itotal2];
               if((itotal-1)%4==0){ 
                   left=0;
               }
               else{
                   left = 1;
               }
           
               nrows= (itotal-1)/4 + left ;
            %>
            <%noproductid=0;
			if(itotal==1){ noproductid=1;%><h1 style="background-color:white;">NO PRODUCTS AVAILABLE !!!<br>Please Double Click to Go Back to HomePage</h1> <% } else {noproductid=0; 
                     Scanner sss= new Scanner(new File("C:/tomcat/webapps/summer/WEB-INF/classes/files/pvalues/currentitems.txt"));   
                        
						while(sss.hasNext())
                        {
                        String temppline=sss.nextLine();
                      //  out.println(temppline);
                     
                        Scanner tempid=new Scanner(temppline).useDelimiter(",");
                        temporaryid=tempid.next();
                      
                        checkid[checki]=temporaryid; 
                        checki++;
                        }
                        checki=0;
                        sss.close();
                     %>
            <%  
             
			
                 Scanner s1= new Scanner (new File("C:/tomcat/webapps/summer/WEB-INF/classes/files/pvalues/pdetails.txt"));
                        
			
            for(int j=1;j<=nrows;j++) { 
                
            if(j==nrows && left==1){
             cols= (itotal-1)%4;}
            else{cols=4;}
            %>
            <tr id="<%=j%>">
			<td style="padding: 0px 10px;">
                    <%
                 
                    
                   
                    
                      for(int i=1;i<=cols ;i++)   
                    {
                        work=0;
                        if(i==1 && j==1){
                         s1.nextLine(); 
                        }
                         String line1= s1.nextLine();
        
                        Scanner s2= new Scanner(line1).useDelimiter(",");
                      
                        String id= s2.next();
						
						s2.next();
						String displayquantity= s2.next();
						String displayprice= s2.next();
                    //    int gnid=Integer.parseInt(id);
                        
                       
                        s2.close();
                  
                  
                //    int tmpid=Integer.parseInt(temporaryid);
                        for(int itr=0; itr<itotal2; itr++){
                       if(checkid[itr].equals(id))
                       {   
                       
                          work=1;  
                       }
                        }
											
                        
						if(i%4==1)
						{
						%><div class="<%=j%>"> <%
						}
						
                          
                        if(work==1)
                        {
                            %>  <button id="<%=(j*100)+i%>" style="background-color : black; font-size: 28px; color: black;text-align: center; padding : 15px 15px; border-width: 2px ; "> <img src="http://localhost:8080/summer/serveimage?id=tick" alt="Sorry network errror" width="250px" height="162px"><div height="20px" style="background-color: white;">Product has already<br>been selected</div> </button> &nbsp &nbsp &nbsp; <%
                        }
else{
                        
                    %>
                            <button id="<%=(j*100)+i%>" style="background-color : black; font-size: 28px; color: black;text-align: center; padding : 15px 15px; border-width: 2px ; "> <img src="http://localhost:8080/summer/serveimage?id=<%=id%>" alt="Sorry network errror" width="245px" height="162px"><div height="20px" style="background-color: white;">quantity: <%=displayquantity%> <br> price: <%=displayprice%> </div></button> &nbsp &nbsp &nbsp;
						<% }

                     
						if(i%4==0)
						{
						%> </div> <%	
						}	

						}
           
					
					
					
					
					
					
					
					
					
                    
          
                     %></td>
			</tr> <% } }			%> 
                    
    
       
</table>

    </td>
    </tr>
</table>

    
</body>
</html>
