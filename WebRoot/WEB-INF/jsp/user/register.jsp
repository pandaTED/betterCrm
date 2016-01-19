<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>注册</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/style/css/user.css">
<script src="${pageContext.request.contextPath}/js/jquery-2.1.4.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.validate.js"></script>
<script src="${pageContext.request.contextPath}/js/messages_zh.js"></script>
<%-- <script src="${pageContext.request.contextPath}/js/jquery.metadata.js"></script> --%>
<script type="text/javascript">
	$().ready(function() {
		$("#registerForm").validate({
			rules : {
				loginName : {
					required : true,
					minlength : 4
				},
				password : {
					required : true,
					minlength : 6
				},
				name : {
					required : true,
					minlength : 2
				},
				email : {
					required : true,
					email : true
				},
			}
		});
	});
</script>

</head>

<body>
	<div class="header">
		<div class="logo">
			<img border="0"
				src="${pageContext.request.contextPath}/style/img/logo.jpg" />
		</div>
		<div class="doSth">
			<s:a action="userAction_loginUI.do">
				<font id="login">登录</font>
			</s:a>
		</div>
	</div>
	<div class="main">
		<s:form id="registerForm" action="userAction_register">
			<p>
				<label for="loginName">登录名</label>
				<s:textfield name="loginName" cssClass="textInput"/>
				 <font class="fieldError">${FieldErrors.loginName[0]}</font>
			</p>
			<p>
				<label for="password">密码</label>
				<s:textfield name="password" cssClass="textInput"/>
				 <font class="fieldError">${FieldErrors.password[0]}</font> 
			</p>
			<p>
				<label for="name">用户名</label>
				<s:textfield name="name"  cssClass="textInput"/>
				 <font class="fieldError">${FieldErrors.name[0]}</font>
			</p>
			<p>
				<label for="email">电子邮箱</label>
				<s:textfield name="email"  cssClass="textInput"/>
				<font class="fieldError">${FieldErrors.email[0]}</font>
			</p>
			<p>
				<s:submit id="submit" value="注册"></s:submit>
			</p>
		</s:form>
	</div>

</body>
</html>


