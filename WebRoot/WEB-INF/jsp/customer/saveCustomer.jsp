<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    <title>保存客户</title>
       <style type="text/css">
		body{
			text-align:center;
    		background-color: #B2DFDB;
    		font-family:Microsoft YaHei;
		}
		div.header{
    		
    		margin-top: 5%;
    	}
	</style>
    <script src="${pageContext.request.contextPath}/js/ShowCalendar.js"></script>
  </head>
  
  <body>
  <div class="header">
  		欢迎你！${user.name}
  	</div>
  
  	<div>
  	
  	<s:a action="customerAction_saveCustomerUI" >保存客户</s:a> 
  	&nbsp &nbsp &nbsp
  	<s:a action="customerAction_listCustomer">列出所有客户</s:a>
	<br>
  	
  	</div>
  
	<s:form action="customerAction_saveCustomer">

		<s:textfield name="name">姓名</s:textfield><br>
		<s:textfield name="status">客户状态</s:textfield><br>
		<s:radio name="gender" list="#{'1':'男士','0':'女士' }" value="1">性别</s:radio><br>
		<s:textfield name="companyName">公司名称</s:textfield><br>
		<s:textfield name="companyPhone">办公电话</s:textfield><br>
		<s:textfield name="cellphone">手机</s:textfield><br>
		<s:textfield name="email">电子邮箱</s:textfield><br>
		<s:textfield name="age" value="">年龄</s:textfield><br>
		<s:textfield name="birthday" onclick="showCalendar(this.id)" id="birthday">客户生日</s:textfield>
		<br>
		<%-- <s:textarea name="text" rows="10" cols="50">客户跟踪</s:textarea><br> --%>
		<s:submit value="提交"></s:submit>
		<s:reset value="重置"></s:reset>
	</s:form>
	
  </body>
</html>
