<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>simpleCRM-登录</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<script type="text/javascript">
			function go(){	
			window.location="${pageContext.request.contextPath}/userRegisterUI";
			}
	</script>

</head>

<body style="background-color:#C5CAE9;text-align: center;">
	<div id="body" style="margin-left: auto;margin-right: auto;max-width: 960px;min-height: 99%;">
	<br/>
	<h1 style="color: ;font-size: 60px;font-family:Microsoft YaHei;">Simple CRM</h1>
	<h1 style="color: ;font-size: 20px;font-family:Microsoft YaHei;">Driven by servlet </h1>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
	<form action="${pageContext.request.contextPath}/userLogin" method="post">
		<table style="font-family:Microsoft YaHei;font-size: 25px;text-align: center;margin: auto;">
			<tr>
				<td style="color: #212121;">登录名：</td>
				<td><input type="text" name="loginName" /></td>
			</tr>
			<tr>
				<td style="color: #212121;">密码：</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td><br></td>
				<td><br></td>
			</tr>
			<tr>
				<td ><input type="submit" value="登录"/></td>
				<td ><input type="button" onclick="go()" value="注册"/></td>
			</tr>
		</table>
	</form>
	</div>
</body>
</html>
