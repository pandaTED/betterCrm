<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>登录</title>
<%@include file="user_js_css.jsp"%>
<script
	src="${pageContext.request.contextPath}/js/ajax/login_validateLoginName.js"></script>
<script
	src="${pageContext.request.contextPath}/js/validate_rules/user_login.js"></script>

</head>
<body>
	<div class="father">
		<div class="header">
			<div class="logo">
				<img border="0"
					src="${pageContext.request.contextPath}/style/img/logo.jpg" />
			</div>
			<div class="doSth">
				<s:a action="userAction_registerUI.do">
					<font id="login">注册</font>
				</s:a>
			</div>
		</div>
		<div class="main">
			<s:form id="loginForm" action="userAction_login">
				<p>
					<label for="loginName">登录名</label>
					<s:textfield name="loginName" cssClass="textInput"
						onblur="hadLoginName(this.value)" />
					<span id="loginNameNotExist" style="font-size: 10px;"></span> <font
						class="fieldError">${FieldErrors.loginName[0]}</font>
				</p>
				<p>
					<label for="loginName">密&emsp;码</label>
					<s:textfield name="password" cssClass="textInput" />
					<font class="fieldError">${FieldErrors.password[0]}</font>
				</p>
				<p>
					&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
					<s:submit id="submit" value="登录"></s:submit>
				</p>
			</s:form>
		</div>
	</div>

</body>
</html>
