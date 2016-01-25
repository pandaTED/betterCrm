<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    <title>保存客户</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/css/user.css">
    <script src="${pageContext.request.contextPath}/js/jquery-2.1.4.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery.validate.js"></script>
	<script src="${pageContext.request.contextPath}/js/messages_zh.js"></script>
       <style type="text/css">
			body{
    		background-color: white;
    		}
    		
    		div.saveTable{
    		position: absolute;
			top:10%;
			left:40%;
			font-size: 20px;
			color: black;
    		}
		</style>

  <%--   <script src="${pageContext.request.contextPath}/js/ShowCalendar.js"></script> --%>
  
  <script type="text/javascript">
  $().ready(function() {
		$("#saveCustomerForm").validate({
			rules : {
				name: {
					required : true,
					minlength : 2
				},
				status: {
					required : true,
					minlength : 2
				},
				cellphone: {
					required : true,
					minlength : 11
				}	
			}
		});
	});
  </script>
  </head>
  
  <body>
  <div class="father">
    <div class="header">
		<div class="logo"><img border="0" src="${pageContext.request.contextPath}/style/img/logo.jpg" /></div>
		<div class="userName"><font id="userName">欢迎你，${user.name}</font></div>
		<div class="doSth"><s:a action="userAction_logout.do" ><font id="login">注销</font></s:a></div>
	</div>
	<div class="func">
  	<s:a action="customerAction_saveCustomerUI" >新增客户</s:a> 
  	&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
  	<s:a action="customerAction_listCustomer">查看所有客户</s:a>
  	</div>
  
  <div class="saveTable">
	<s:form id="saveCustomerForm" action="customerAction_saveCustomer">
		<p>
		<s:textfield cssClass="textInput" name="name">姓名&emsp;</s:textfield><font class="fieldError">${FieldErrors.name[0]}</font><br>
		</p>
		<p>
		<s:textfield cssClass="textInput" name="status">备注&emsp;</s:textfield><font class="fieldError">${FieldErrors.status[0]}</font><br>
		</p>
		<p>
		<s:radio name="gender" list="#{'1':'男士','0':'女士'}" value="1">性别&emsp;</s:radio><br>
		</p>
		<p>
		<s:textfield cssClass="textInput" name="companyName">公司&emsp;</s:textfield><br>
		</p>
		<p>
		<s:textfield cssClass="textInput" name="companyPhone">固话&emsp;</s:textfield><br>
		</p>
		<p>
		<s:textfield cssClass="textInput" name="cellphone">手机&emsp;</s:textfield><font class="fieldError">${FieldErrors.cellphone[0]}</font><br>
		</p>
		<p>
		<s:textfield cssClass="textInput" name="email">邮箱&emsp;</s:textfield><font class="fieldError">${FieldErrors.email[0]}</font><br>
		</p>
		<p>
		<s:textfield cssClass="textInput" name="age" value='25' >年龄&emsp;</s:textfield><font class="fieldError">${FieldErrors.age[0]}</font><br>
		</p>
		<p>
		<s:textfield cssClass="textInput" name="birthday">生日&emsp;<s:param name="value"><s:date name="birthday" format="yyyy-MM-dd"></s:date></s:param>
		</s:textfield><font class="fieldError">${FieldErrors.birthday[0]}</font><br>
		</p>
		<p>
		&emsp;&emsp;&emsp;&emsp;<s:submit  value="提交"></s:submit>&emsp;&emsp;
		<s:reset  value="重置"></s:reset>
		</p>
	</s:form>
	</div>
	</div>
  </body>
</html>
