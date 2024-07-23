<%@page import="java.util.Scanner"%>
<%@page import="java.io.File"%>
<html>
<head><link rel="stylesheet" type="text/css" href="layout.css">
    
    <% String temporarysize1=request.getParameter("size");
       String temporaryspeed=request.getParameter("speed");
 int size=Integer.parseInt(temporarysize1);
 int speed1=Integer.parseInt(temporaryspeed);
          int speed=speed1; 
          //assigning correct values to speed variable
        if(speed1 ==1)
            speed=1;
        else if(speed1 == 2)
        speed=2;
        else if(speed1 ==3)
        speed= 3;
        else
            speed= 4;
    
        
    %>
<script src="jquery.min.js"></script>

<script>
var x=0,minvalue,maxvalue,sizetemp,size1,speed=1,tempdigit=-1,mainintervalid,subintervalid,totalmax=13;
</script>
<script>
var x=1,i;
$(document).ready(function(){
    var mainmax=4,mainx,maintempdigit=-1;
    function mainfunc(){
       mainx=0;
        mainintervalid = setInterval(function(){
          
        if(mainx==0){
            var maintemp=mainmax-1;
            $("#subrow"+maintemp).attr("style","background-color: black;");
            $("#subrow"+mainx).attr("style","background-color: red;");           
        }
        for(i=0;i<mainx;i++){
            $("#subrow"+i).attr("style","background-color: black;");
        }
        //alert(i);
            $("#subrow"+i).attr("style","background-color: red;");
           
        maintempdigit=mainx;
       
        mainx++;
        if(mainx>mainmax){
            mainx=0;
    }
},<%=speed%>*1000);
    }
$("td").click(function(){
     //var valuetosend = "<%=size%>";
                          //alert(valuetosend);
                          //assigning functions to outer scan
                          //alert("hye");
                          if(maintempdigit>=0)
                          {
                              //alert(maintempdigit);
                              if(maintempdigit==0)
                              {   maxvalue=10;
                                  minvalue=0;
                                  
                              }
                             else if(maintempdigit==1){
                                 maxvalue=13;
                                 minvalue=10;
                             }
                             else
                             {}
                            
                             maintempdigit=-1;
                                 clearInterval(mainintervalid);
                               x=minvalue;
                                     subintervalid=setInterval(function(){
                                   
                                   
                                if(x===minvalue){
                               var temp=maxvalue-1;
                                $("#"+temp).attr("style","border-radius: 8px;background-color: white; color: black;text-align: center; padding : 15px 32px;font-size:"+<%=size%>+";");
                                }
                                 
                                for(var i=minvalue;i<x;i++){
                                $("#"+i).attr("style","border-radius: 8px;background-color: white;color: black;text-align: center; padding : 15px 32px;font-size:"+<%=size%>+";");
                               }
                                $("#"+i).attr("style","border-radius: 8px;background-color: red; color: black;text-align: center; padding : 15px 32px;font-size:"+<%=size%>+";");
                                tempdigit=x;
                                 x++;
                                 //alert("yes");
                                 if (x >= maxvalue){
                                    x = minvalue;
                                  //alert("entered");
                                    }
                                  
                              },1*1000);   
      
                             }
                            
    if(tempdigit >=0&&tempdigit<10){                      
    var tempdigitpresent=document.getElementById("text").innerHTML;
    //alert(tempdigitpresent);                      
    document.getElementById("text").innerHTML="";
    tempdigitpresent=tempdigitpresent+tempdigit;
    
    document.getElementById("text").innerHTML=tempdigitpresent;
    tempdigit=-1;
   
    clearInterval(subintervalid);
     clearfunc();
   mainfunc();
    }
   else if(tempdigit==10)
   {
       var tempdigitpresent=document.getElementById("text").innerHTML;
       var tempdigitpresent=parseInt(tempdigitpresent/10);
       document.getElementById("text").innerHTML=tempdigitpresent;
    tempdigit=-1;
    clearInterval(subintervalid);
   
     clearfunc();
   mainfunc();}
    else if(tempdigit==11)
    {
        document.getElementById("text").innerHTML="";
    tempdigit=-1;
    clearInterval(subintervalid);
     clearfunc();
   mainfunc();}
    else if(tempdigit==12)
    {
    tempdigit=-1;
    clearInterval(subintervalid);
    window.location="testing.jsp";
   clearfunc();
   mainfunc();
    }
    else
    {    
    }
    //function to run the innerloop
   
});
});  
</script>
<script>
    function clearfunc()
    {
        for(var i1=0;i<mainmax;i++){
           $("#subrow"+i1).attr("style","background-color: white;");
       }
       for(var i1=0;i1<maxvalue;i1++){
        $("#"+i1).attr("style","border-radius: 8px;background-color: white;color: black;text-align: center; padding : 15px 32px;font-size:"+<%=size%>+";");                                       
       }
           
    }
    </script>
<!--<script>
                            function func(){
                                alert("entered ");
                                 
                                setInterval(function(){
                                if(x===0){
                                var temp=maxvalue;
                                $("#"+temp).attr("style","border-radius: 8px;background-color: white; color: black;text-align: center; padding : 15px 32px;font-size:"+<%=size%>+";");
                                }

                                for(int i=minvalue;i<x;i++){
                                $("#"+i).attr("style","border-radius: 8px;background-color: white;color: black;text-align: center; padding : 15px 32px;font-size:"+<%=size%>+";");
                                }
                                $("#"+i).attr("style","border-radius: 8px;background-color: red; color: black;text-align: center; padding : 15px 32px;font-size:"+<%=size%>+";");
                                tempdigit=x;
                                 x++;
                                 if (x >= maxvalue){
                                     x=0;
                                    }
                                },<%=speed%>*1000);
                               
    }
</script>--><% 
               int ppid=0;
               String pid=null;
               String pname=null;
            String pquantity=null;
            String pprice=null;
            int outertemp=0;
            int innertemp=0;
            
               %>
<script>
    
    
    </script>
</head>
<body  text=white onload="mainfunc()">
        <div class="header"><h1 style="color: black;">Billing Software</div>
        <div class="topnav"><h1 style="color: white">Product Details</h1></div>
         <%  
            String username=request.getParameter("uname");
            if(username!=null)
            out.println("Welcome "+username+"!");
            else
            out.println("Welcome User!");
           %> 
           
           <table class="container" border="0">
           <% Scanner s=new Scanner(new File("C:\\Users\\ashwi\\Desktop\\spastic society\\files\\pvalues\\currentitems.txt"));
           %>
           <tr><td>Image</td><td>Id</td><td>Name</td><td>Quantity</td><td>Price</td></tr>
                <%
                    while(s.hasNext())
                    {
                        String line=s.nextLine();
                        Scanner tempvalue=new Scanner(line).useDelimiter(",");
                        pid=tempvalue.next();
                        pquantity=tempvalue.next();
                        


//jsp function to retrieve the other values from pdetails.txt

            Integer gnid=Integer.parseInt(pid);//parses the id got from the previous page
            File details=new File("C:\\Users\\ashwi\\Desktop\\spastic society\\files\\pvalues\\pdetails.txt");
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
          
                %>
           
                <tr id="subrow<%=outertemp%>">
                
                    <td><img src="http://localhost:8080/Billing_Software/serveimage?id=<%=pid%>" width="100" ></td>
                <!--<td><img src="C:\Users\ashwi\Desktop\spastic society\files\pimages\2.jpg"></td>-->
                    <td><%=pid%>&nbsp;&nbsp;</td>
                
                <td><%=pname%></td>
                <td><%=pquantity%></td>
                <td><%=pprice%></td>
                </tr>
                
                    <% tempvalue.close();
                    out.println(outertemp);
                    outertemp++;}

s.close();
                   %>
                   
                   <tr id="subrow<%=outertemp%>">
                       <th colspan="5"><a href="ichange.jsp"><button type="button" style="background-color: #4CAF50;color: white;padding: 14px 20px;margin: 8px 0;border: none;cursor: pointer;border-radius: 8px;">Back</button></a></th>
                   </tr>
           
           </table>
                       <p id="demo">   dv</p>
    </body>
</html>
