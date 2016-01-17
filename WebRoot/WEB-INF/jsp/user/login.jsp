<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>登录</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/css/user.css">
 <style type="text/css">
 
 	div.main{
 		width: 50%;
 		font-size: 20px;
 		text-align: center;
 	}
 	
 
 
 </style>
 
  </head>
  <body>
  <div class="header">
		<div class="logo"><img border="0" src="${pageContext.request.contextPath}/style/img/logo.jpg" /></div>
		<div class="doSth"><s:a action="userAction_registerUI.do" ><font id="login">注册</font></s:a></div>
	</div>
	<div class="main">
		<s:form action="userAction_login">
    	<s:textfield name="loginName" id="textInput" >登录名：</s:textfield><font class="fieldError">${FieldErrors.loginName[0]}</font><br>
    	<s:textfield name="password" id="textInput" >密码：</s:textfield><font class="fieldError">${FieldErrors.password[0]}</font><br>
    	<s:submit id="submit" value="登录"></s:submit>
    	</s:form>
	</div>
 
  </body>
</html>
