<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
  <head>
    <title>simpleCRM-提示消息</title>
	<script type="text/javascript">  
    var start = 3;  
    var step = -1;  
    function count() {  
        document.getElementById("div1").innerHTML = "页面将在" + start+ "秒后返回";  
        start += step;  
        if (start <= 0) {  
            start = 3;  
            //alert(start);  
            window.location = "${pageContext.request.contextPath}/listCustomer";//重定位  
        }  
        setTimeout("count()", 1000);  
    }  
    window.onload = count;  
</script>  
  </head>
  <body style="background-color:#BBDEFB;text-align: center;font-size: 30px;font-family:Microsoft YaHei;">
  	<br>
  	<br>
  	<br>
  	<br>
  	<br>
  	<br>
   
     <div class="myDiv">  
    <p> ${requestScope.message}</p>  
        <div id="div1"></div>  
    </div>  
  </body>
</html>

