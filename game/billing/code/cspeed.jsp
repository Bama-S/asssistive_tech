
<html>
<head>
<title>SPEED</title>
    <link rel="stylesheet" type="text/css" href="layout.css">
    
    <% String temporarysize1=request.getParameter("tempp");
 int temporarysize=Integer.parseInt(temporarysize1);
 if(temporarysize==1){
 temporarysize=16;
 }else if(temporarysize==2){
 temporarysize=24;}else{
 temporarysize=32;}
 %>
<script src="jquery.min.js"></script>

<script>
var x=1,i;
$(document).ready(function(){
$("td").click(function(){
     var valuetosend = "<%=temporarysize%>";
                          //alert(valuetosend);
                     
    window.location="iselect.jsp?"+"speed="+speed+"&size="+valuetosend;
});
});

<!--script to get the value from url -->
 var query = window.location.search;
  // Skip the leading ?, which should always be there, 
  // but be careful anyway
  if (query.substring(0, 1) == '?') {
    query = query.substring(1);
  }
  var data = query.split(','); 
  for (i = 0; (i < data.length); i++) {
    data[i] = unescape(data[i]);
  }
  sizetemp=data[0];
  
<!--script to set the value of size-->
 if(sizetemp==1){
 size1=16;
 }else if(sizetemp==2){
 size1=24;}else{
 size1=32;}

        $(".size").attr("style","background-color: white; color: black;text-align: center; padding : 15px 32px;font-size:"+size1+";");
   
</script>
       
<script>
var x=1,i,maxvalue=4,sizetemp,size1,speed=1;
</script>
<script>
function func(){
setInterval(function(){
if(x===1){
var temp=maxvalue;
$("#"+temp).attr("style","background-color: white; font-size:"+size1+"; color: black;text-align: center; padding : 15px 32px;font-size:"+<%=temporarysize%>+";");
    }

    for(i=1;i<x;i++){
    $("#"+i).attr("style","background-color: white; font-size:"+size1+"; color: black;text-align: center; padding : 15px 32px;font-size:"+<%=temporarysize%>+";");
    }
    $("#"+i).attr("style","background-color: red; font-size:"+size1+"; color: black;text-align: center; padding : 15px 32px;font-size:"+<%=temporarysize%>+";");
        speed=x;
 <!--function to play audio-->
    document.getElementById("audio"+x).play();
            x++;
    if (x > maxvalue){
    x=1;
    }
},3000);

}
</script>
</head>
<body onload='func()'>
 <!-- function to play intro audio automatically-->
<audio autoplay>
    <source src="voicemp3/selectthecursorspeed.mp3" type="audio/mp3" />
</audio>

    <div class="header" style='font-size:<%=temporarysize%>;' ><b><center><h1 style='color: black; font-size:<%=temporarysize%>;'>Billing Software</h1></center>
</div>    
    <table align="center"  style="width : 100%; height: 100%">
    
            <tr>
            <td>   
<table align="center" border="0">
<tr>
<td>
   <div align="top" style='color: white; font-size:<%=temporarysize%>;'> <h1> <center>Cursor Speed
               </div><br>
<button id="1" style="background-color : white; color: black;text-align: center; padding : 15px 32px;font-size:<%=temporarysize%>;"><b>Fastest </button>
<audio id="audio1">
    <source src="voicemp3/Fastest.mp3" type="audio/mp3" />
</audio>

<button id="2" style="background-color : white; color: black;text-align: center; padding : 15px 32px;font-size:<%=temporarysize%>;"><b>Fast</button>
<audio id="audio2">
    <source src="voicemp3/Fast.mp3" type="audio/mp3" />
</audio>

<button id="3" style="background-color : white; color: black;text-align: center; padding : 15px 32px;font-size:<%=temporarysize%>;"><b>Slow</button>
<audio id="audio3">
    <source src="voicemp3/Slow.mp3" type="audio/mp3" />
</audio>
<button id="4" style="background-color : white; color: black;text-align: center; padding : 15px 32px;font-size:<%=temporarysize%>;"><b>Slower</button>
<audio id="audio4">
    <source src="voicemp3/Slower.mp3" type="audio/mp3" />
</audio>
</td>
</tr>
</table>
    </td>
    </table>
    </font>
</body>
</html>
