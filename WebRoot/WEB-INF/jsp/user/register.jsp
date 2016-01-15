<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>注册</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/css/user.css">
  </head>
  
  <body>
	<div class="header">
		<div class="logo"><img border="0" src="${pageContext.request.contextPath}/style/img/logo.jpg" /></div>
		<div class="doSth"><s:a action="userAction_loginUI.do" ><font id="login">登录</font></s:a></div>
	</div>
	<div class="main">
		<s:form action="userAction_register" >
  		<s:textfield name="loginName" id="textInput">登录名</s:textfield><br>
  		<s:textfield name="password" id="textInput">密码</s:textfield><br>
  		<s:textfield name="name" id="textInput">用户名</s:textfield><br>
  		<s:textfield name="email" id="textInput">电子邮箱</s:textfield><br>
  		<s:submit id="submit" value="注册"></s:submit>
  	</s:form>
	</div>
	
    
  </body>
</html>
