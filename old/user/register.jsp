<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<title>simpleCRM-注册</title>
<meta http-equiv="CONTENT-TYPE" content="text/html" charset="UTF-8">
<script type="text/javascript">
	
		var xmlhttp;
        function hadLoginName(loginName){
        	//1.创建XMLHttpRequest对象
            xmlhttp = new XMLHttpRequest();
            //2.XMLHttpRequest打开连接
          	xmlhttp.open("GET","${pageContext.request.contextPath}/userRegister?loginName="+loginName,true);
          	//3.设置回调函数
          	xmlhttp.onreadystatechange = callback;
          	//4.send
          	xmlhttp.send(null);
        }
	//5.写callback函数
	function callback(){
		//6.状态改变时
		if(xmlhttp.readyState == 4){
		//7.状态码为200时
			if(xmlhttp.status == 200){
			//8.获取responseText
				var message = "<font color='red'>"+xmlhttp.responseText+"</font>";
				//9.获取要覆盖的元素
            	var span = document.getElementById("loginNameExist");
            	//10.修改元素的输出
            	span.innerHTML = message;
			}
		}
	}
</script>
</head>

<body style="background-color:#B2DFDB;text-align: center;">
	<div id="body"
		style="margin-left: auto;margin-right: auto;max-width: 960px;min-height: 99%;">
		<br />
		<h1 style="color: ;font-size: 60px;font-family:Microsoft YaHei;">Simple
			CRM</h1>
		<h1 style="color: ;font-size: 20px;font-family:Microsoft YaHei;">Driven
			by servlet</h1>
		<br />
		<h1 style="color: ;font-size: 30px;font-family:Microsoft YaHei;">注册</h1>
		<br /> <br />
		<form action="${pageContext.request.contextPath}/userRegister" method="post">
			<table
				style="font-family:Microsoft YaHei;font-size: 25px;text-align: center;margin: auto;">
				<tr>
					<td style="color: #212121;">登录名：</td>
					<td><input id="loginName" type="text" name="loginName" onblur="hadLoginName(this.value)" /></td>
					<td><span id = "loginNameExist" style="font-size: 10px" ></span></td>
				</tr>
				<tr>
				<tr>
					<td style="color: #212121;">密码：</td>
					<td><input type="password" name="password"  /></td>
					<td></td>
				</tr>
				<tr>
					<td style="color: #212121;">姓名：</td>
					<td><input type="text" name="name" /></td>
					<td></td>
				</tr>
				<tr>
					<td style="color: #212121;">电子邮件：</td>
					<td><input type="text" name="email" /></td>
					<td></td>
				</tr>
				<tr>
					<td><input type="submit" value="确认" /></td>
					<td><input type="reset" value="重填" /></td>
					<td></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
