<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>注册</title>
<%@include file="user_js_css.jsp"%>
<script
	src="${pageContext.request.contextPath}/js/ajax/register_validateLoginName.js"></script>
<script
	src="${pageContext.request.contextPath}/js/validate_rules/user_register.js"></script>

</head>

<body class="father">
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
					<label for="loginName">登录名&emsp;</label>
					<s:textfield name="loginName" cssClass="textInput"
						onblur="hadLoginName(this.value)" />
					<span id="loginNameExist" style="font-size: 10px;"></span> <font
						class="fieldError">${FieldErrors.loginName[0]}</font>
				</p>

				<p>
					<label for="password">密&emsp;码&emsp;</label>
					<s:textfield name="password" cssClass="textInput" />
					<font class="fieldError">${FieldErrors.password[0]}</font>
				</p>
				<p>
					<label for="name">用户名&emsp;</label>
					<s:textfield name="name" cssClass="textInput" />
					<font class="fieldError">${FieldErrors.name[0]}</font>
				</p>
				<p>
					<label for="email">邮&emsp;箱&emsp;</label>
					<s:textfield name="email" cssClass="textInput" />
					<font class="fieldError">${FieldErrors.email[0]}</font>
				</p>

				<p>
					&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
					<s:submit id="submit" value="注册"></s:submit>
				</p>
			</s:form>
		</div>
</body>
</html>


