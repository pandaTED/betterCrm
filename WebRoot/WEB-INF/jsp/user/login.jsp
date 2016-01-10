<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>登录</title>
	<style type="text/css">
		body{
			text-align:center;
    		background-color: #B2DFDB;
    		font-family:Microsoft YaHei;
		}
	</style>
  </head>
  <body>
    <s:form action="userAction_login">
    	<s:textfield name="loginName">登录名：</s:textfield><br>
    	<s:textfield name="password">密码：</s:textfield><br>
    	<s:submit value="提交"></s:submit>
    </s:form>
    <hr>
    <s:form action="userAction_register" >
  		<s:textfield name="loginName">登录名：</s:textfield><br>
  		<s:textfield name="password">密码：</s:textfield><br>
  		<s:textfield name="name">用户名：</s:textfield><br>
  		<s:textfield name="email">电子邮箱：</s:textfield><br>
  		<s:submit value="提交"></s:submit>
  	</s:form>
    
  </body>
</html>
