<html>
<head>
<title>Font Size</title>
<script src="jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="layout.css">
<%
String tempad="C:";
%>
<script>
var x=1,i;
$(document).ready(function(){
$("td").click(function(){
var packed=escape(size);
window.location="cspeed.jsp?tempp="+size;
});
});
</script>
<script>
var x=1,i,maxvalue=3,size=1;
</script>
<script>
function func(){
setInterval(function(){
if(x==1){
    
var temp=maxvalue;
$("#"+temp).attr("style","background-color: white;font-size: 28px;color: black;text-align: center; padding : 15px 32px; ");
}
for(i=1;i<x;i++){
$("#"+i).attr("style","background-color: white;font-size: 28px;color: black;text-align: center; padding : 15px 32px; ");
}
$("#"+i).attr("style","background-color: red;font-size: 28px;color: black;text-align: center; padding : 15px 32px; ");
size=x;
//function to play audio
    document.getElementById("audio"+i).play();

x++;
if (x > maxvalue){
x=1;
}
},3000);
}
</script>
</head>
<body onload='func()' bgcolor="black">
<!-- function to play intro audio automatically-->
<audio autoplay>
    <source src="voicemp3/selectthefontsize.mp3" type="audio/mp3" />
</audio>
    
    <div class="header" style="color: black;"><center><h1><b>Billing Software</b></h1></center>
</div>
<table border=0 style="height: 100%;width: 100%; ">
    <tr style="height:100%;width: 100%;">
<td>
    <div align="top"  style="color:white;"> <h1><center>Font Size</center>
    </div><br><br>
   
<center>
<button id="1" style="background-color : white;font-size: 28px; color: black;text-align: center; padding : 15px 32px;   "><b>Small</button>
<audio id="audio1">
    <source src="voicemp3/Small.mp3" type="audio/mp3"/>
</audio>
<button id="2" style="background-color : white;font-size: 28px; color: black;text-align: center; padding : 15px 32px;   "><b>Medium</button>
<audio id="audio2">
    <source src="voicemp3/Medium.mp3" type="audio/mp3" />
</audio>
<button id="3" style="background-color : white;font-size: 28px; color: black;text-align: center; padding : 15px 32px;   "><b>Large</button>
<audio id="audio3">
    <source src="voicemp3/Large.mp3" type="audio/mp3" />
</audio>
</center>
</td>
</tr>
</table>
</body>
</html>
