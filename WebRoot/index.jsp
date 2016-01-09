<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>betterCRM</title>
</head>
<body style="text-align: center;">

	<s:a action="userAction_loginUI" >用户登录</s:a>
	<br>
	<s:a action="userAction_registerUI" >用户注册</s:a>
	<br>
	<s:a action="customerAction_saveCustomerUI">保存客户</s:a>
	<br>
	<s:a action="customerAction_listCustomer">列出所有客户</s:a>
	<br>

</body>
</html>
