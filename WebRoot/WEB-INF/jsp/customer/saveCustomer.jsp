<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    <title>保存客户</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/css/user.css">
       <style type="text/css">
			body{
    		background-color: white;
    		}
    		
    		div.saveTable{
    			text-align: right;
    			width: 50%;
    			margin-right: 35%;
    			margin-top: 2%;
    			font-size: 20px;
    		}
		</style>

  <%--   <script src="${pageContext.request.contextPath}/js/ShowCalendar.js"></script> --%>
  </head>
  
  <body>
    <div class="header">
		<div class="logo"><img border="0" src="${pageContext.request.contextPath}/style/img/logo.jpg" /></div>
		<div class="userName"><font id="userName">欢迎你，${user.name}</font></div>
		<div class="doSth"><s:a action="userAction_logout.do" ><font id="login">注销</font></s:a></div>
	</div>
	<div class="func">
  	<s:a action="customerAction_saveCustomerUI" >新增客户</s:a> 
  	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  	<s:a action="customerAction_listCustomer">查看所有客户</s:a>
  	</div>
  
  <div class="saveTable">
	<s:form action="customerAction_saveCustomer">
		<s:textfield cssClass="textInput" name="name">姓名</s:textfield><font class="fieldError">${FieldErrors.name[0]}</font><br>
		<s:textfield cssClass="textInput" name="status">客户状态</s:textfield><font class="fieldError">${FieldErrors.status[0]}</font><br>
		<s:radio name="gender" list="#{'1':'男士','0':'女士' }" value="1">性别</s:radio><br>
		<s:textfield cssClass="textInput" name="companyName">公司名称</s:textfield><br>
		<s:textfield cssClass="textInput" name="companyPhone">办公电话</s:textfield><br>
		<s:textfield cssClass="textInput" name="cellphone">手机</s:textfield><br>
		<s:textfield cssClass="textInput" name="email">电子邮箱</s:textfield><font class="fieldError">${FieldErrors.email[0]}</font><br>
		<s:textfield cssClass="textInput" name="age" value="">年龄</s:textfield><font class="fieldError">${FieldErrors.age[0]}</font><br>
		<s:textfield cssClass="textInput" name="birthday">客户生日
			<s:param name="value"><s:date name="birthday" format="yyyy-MM-dd"></s:date></s:param>
		</s:textfield><font class="fieldError">${FieldErrors.birthday[0]}</font><br>
		<s:submit value="提交"></s:submit>
		<s:reset value="重置"></s:reset>
	</s:form>
	</div>
  </body>
</html>
