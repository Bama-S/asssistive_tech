<%@page import="java.io.File"%>
<%@page import="java.util.Scanner"%>
<%@page import="java.io.BufferedReader"%>
<%@ page import="java.io.*" %>
<html>
<head><link rel="stylesheet" type="text/css" href="layout.css">
    
    <% 
	String line4="";
	String page1="0";
	   int size=0,speed1=0,speed=0;
	   String temporarysize1="",temporaryspeed="",tempadd="",id="",id1="";
	   int teeid=0,sa=0;
	    temporarysize1=request.getParameter("size");
        temporaryspeed=request.getParameter("speed");
	    tempadd="C:";
		 size=Integer.parseInt(temporarysize1);
         speed1=Integer.parseInt(temporaryspeed);
         speed=speed1; 
        
			 
    %>
<script src="jquery.min.js"></script>

<script>
var x=0,minvalue,maxvalue,sizetemp,size1,speed=1,tempdigit=-1,mainintervalid,subintervalid,totalmax=13,needtorefresh;
</script>
<script>
var x=1,i;
function abc(){
     //var valuetosend = "<%=size%>";
                          //alert(maintempdigit);
                          //assigning functions to outer scan
                          //alert("hye");
						  needtorefresh=0;
                          if(maintempdigit>=0)
                          {
                              //alert(maintempdigit);
							  needtorefresh=1;
                              if(maintempdigit==0)
                              {   maxvalue=10;
                                  minvalue=0;
                                  
                              }
                             else if(maintempdigit==1){
                                 maxvalue=13;
                                 minvalue=10;
                             }
                             else
                             {
								 //alert("Please Click Only When the RED Cursor points to your desired option..!");
								 location.reload();
							 }
                            
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
                                $("#"+i).attr("style","border-radius: 8px;background-color: green; color: black;text-align: center; padding : 15px 32px;font-size:"+<%=size%>+";");
                                tempdigit=x;
                                <!--function to play audio-->
                                document.getElementById("audio"+x).play();
                                 x++;
                                 //alert("yes");
                                 if (x >= maxvalue){
                                    x = minvalue;
                                  //alert("entered");
                                    }
                                  
                              },<%=speed%>*1000);   
      
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
    var tempdigitpresent=Number(document.getElementById("text").innerHTML);
    window.location="ibill.jsp?size=<%=size%>&speed=<%=speed%>&receivedamount="+tempdigitpresent;
   clearfunc();
   mainfunc();
    }
    
	else{
		
	}
    //function to run the innerloop
   
} 
</script>
<script>
    function clearfunc()
    {
        for(var i1=0;i<mainmax;i++){
           $("#subrow"+i1).attr("style","background-color: black;");
       }
       for(var i1=0;i1<maxvalue;i1++){
        $("#"+i1).attr("style","border-radius: 8px;background-color: white;color: black;text-align: center; padding : 15px 32px;font-size:"+<%=size%>+";");                                       
       }
           
    }
    </script>
<script>
    var mainmax=2,mainx,maintempdigit=-1;
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
        if(mainx>mainmax)
		{
            mainx=0;
			
		}
},<%=speed%>*1000);
    }
    </script>
</head>
<body onload='mainfunc()' onclick="abc()">
<audio autoplay>
    <source src="voicemp3/selectthereceivedamount.mp3" type="audio/mp3" />
</audio>
    <div class="header" style="color: black;"><center><h1><b>Billing Software</b></h1></center>
</div>
 <div class="topnav"><p style="color:white; font-size:<%=size%>;"> <b>SELECT  THE  RECEIVED AMOUNT </p>
     </div>
    <table border="0" align="center" style="width : 100%; height: 100%" bgcolor="black">
    
        
        <tr valign="top">
            <td valign="top">   
<table align="center" border="0" id="subtable1" bgcolor="black">
<tr id="subrow0" style="background-color: black;">
<td><b>
    <br>&nbsp;
<button id="0" style="border-radius: 8px;background-color : white; color: black;text-align: center; padding : 15px 32px;font-size:<%=size%>;"><b>0</button>
&nbsp;<audio id="audio0">
    <source src="voicemp3/0.mp3" type="audio/mp3" />
</audio>
<button id="1" style="border-radius: 8px;background-color : white; color: black;text-align: center; padding : 15px 32px;font-size:<%=size%>;"><b>1</button>
&nbsp;<audio id="audio1">
    <source src="voicemp3/1.mp3" type="audio/mp3" />
</audio>
<button id="2" style="border-radius: 8px;background-color : white; color: black;text-align: center; padding : 15px 32px;font-size:<%=size%>;"><b>2</button>
&nbsp;<audio id="audio2">
    <source src="voicemp3/2.mp3" type="audio/mp3" />
</audio>
<button id="3" style="border-radius: 8px;background-color : white; color: black;text-align: center; padding : 15px 32px;font-size:<%=size%>;"><b>3</button>
&nbsp;<audio id="audio3">
    <source src="voicemp3/3.mp3" type="audio/mp3" />
</audio>
<button id="4" style="border-radius: 8px;background-color : white; color: black;text-align: center; padding : 15px 32px;font-size:<%=size%>;"><b>4</button>
&nbsp;<audio id="audio4">
    <source src="voicemp3/4.mp3" type="audio/mp3" />
</audio>
<button id="5" style="border-radius: 8px;background-color : white; color: black;text-align: center; padding : 15px 32px;font-size:<%=size%>;"><b>5</button>
&nbsp;<audio id="audio5">
    <source src="voicemp3/5.mp3" type="audio/mp3" />
</audio>
<button id="6" style="border-radius: 8px;background-color : white; color: black;text-align: center; padding : 15px 32px;font-size:<%=size%>;"><b>6</button>
&nbsp;<audio id="audio6">
    <source src="voicemp3/6.mp3" type="audio/mp3" />
</audio>
<button id="7" style="border-radius: 8px;background-color : white; color: black;text-align: center; padding : 15px 32px;font-size:<%=size%>;"><b>7</button>
&nbsp;<audio id="audio7">
    <source src="voicemp3/7.mp3" type="audio/mp3" />
</audio>
<button id="8" style="border-radius: 8px;background-color : white; color: black;text-align: center; padding : 15px 32px;font-size:<%=size%>;"><b>8</button>
&nbsp<audio id="audio8">
    <source src="voicemp3/8.mp3" type="audio/mp3" />
</audio>
<button id="9" style="border-radius: 8px;background-color : white; color: black;text-align: center; padding : 15px 32px;font-size:<%=size%>;"><b>9</button>
&nbsp;<audio id="audio9">
    <source src="voicemp3/9.mp3" type="audio/mp3" />
</audio>
<br><br>
</td>
</tr>
<tr id="subrow1" style="background-color: black;">
<td>
    <!--left=01 right=02--><br> &nbsp;  
<button id="10" style="border-radius: 8px;background-color : white; color: black;text-align: center; padding : 15px 32px;font-size:<%=size%>;"><b>BACKSPACE</button>
<audio id="audio10">
    <source src="voicemp3/BackSpace.mp3" type="audio/mp3" />
</audio> &nbsp;  
<button id="11" style="border-radius: 8px;background-color : white; color: black;text-align: center; padding : 15px 32px;font-size:<%=size%>;"><b>RESET</button>
<audio id="audio11">
    <source src="voicemp3/reset.mp3" type="audio/mp3" />
</audio> &nbsp;  
<button id="12" style="border-radius: 8px; background-color : white; color: black;text-align: center; padding : 15px 32px;font-size:<%=size%>;"><b>SUBMIT</button>
<audio id="audio12">
    <source src="voicemp3/submit.mp3" type="audio/mp3" />
</audio> &nbsp;  
<br><br>
</td>
</tr>
</table>
        <br>
       <center><p style="color:white; font-size:<%=size%>;"><b> Entered digits</p>
        <b><p id="text" style="color:white; font-size:<%=size%>;"></p>
    </td>
    </table>
   
</body>
</html>
