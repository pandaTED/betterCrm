<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    <title>修改客户</title>
    
  </head>
  
  <body style="text-align: center;">
	<s:form action="customerAction_updateCustomer">
		id=${id}
		<s:hidden name="id"></s:hidden>
		<s:textfield name="name">姓名</s:textfield><br>
		<s:textfield name="status">客户状态</s:textfield><br>
		<s:radio name="gender" list="#{'1':'男士','0':'女士' }">性别</s:radio><br>
		<s:textfield name="companyName">公司名称</s:textfield><br>
		<s:textfield name="companyPhone">办公电话</s:textfield><br>
		<s:textfield name="cellphone">手机</s:textfield><br>
		<s:textfield name="email">电子邮箱</s:textfield><br>
		<s:textfield name="age">年龄</s:textfield><br>
		
		<s:textfield name="birthday">客户生日：
			<s:param name="value">
			<s:date name="birthday" format="yyyy-MM-dd"></s:date>
			</s:param>
		</s:textfield><br>
		
		<%-- <s:textarea name="text" rows="10" cols="50">客户跟踪</s:textarea><br> --%>
		<s:submit value="提交"></s:submit>
		<s:reset value="重置"></s:reset>
	</s:form>
	
  </body>
</html>
