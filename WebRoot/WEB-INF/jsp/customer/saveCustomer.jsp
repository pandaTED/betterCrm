<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>保存客户</title>
<%@include file="customer_js_css.jsp"%>
<script
	src="${pageContext.request.contextPath}/js/validate_rules/customer_saveCustomer.js"></script>

</head>

<body>
	<div class="father">
		<%@include file="customer_header.jsp"%>

		<div class="saveTable">
			<s:form id="saveCustomerForm" action="customerAction_saveCustomer">
				<p>
					<s:textfield cssClass="textInput" name="name">姓名&emsp;</s:textfield>
					<font class="fieldError">${FieldErrors.name[0]}</font><br>
				</p>
				<p>
					<s:textfield cssClass="textInput" name="status">备注&emsp;</s:textfield>
					<font class="fieldError">${FieldErrors.status[0]}</font><br>
				</p>
				<p>
					<s:radio name="gender" list="#{'1':'男士','0':'女士'}" value="1">性别&emsp;</s:radio>
					<br>
				</p>
				<p>
					<s:textfield cssClass="textInput" name="companyName">公司&emsp;</s:textfield>
					<br>
				</p>
				<p>
					<s:textfield cssClass="textInput" name="companyPhone">固话&emsp;</s:textfield>
					<br>
				</p>
				<p>
					<s:textfield cssClass="textInput" name="cellphone">手机&emsp;</s:textfield>
					<font class="fieldError">${FieldErrors.cellphone[0]}</font><br>
				</p>
				<p>
					<s:textfield cssClass="textInput" name="email">邮箱&emsp;</s:textfield>
					<font class="fieldError">${FieldErrors.email[0]}</font><br>
				</p>
				<p>
					<s:textfield cssClass="textInput" name="age" value='25'>年龄&emsp;</s:textfield>
					<font class="fieldError">${FieldErrors.age[0]}</font><br>
				</p>
				<p>
					<s:textfield cssClass="textInput" name="birthday">生日&emsp;<s:param
							name="value">
							<s:date name="birthday" format="yyyy-MM-dd"></s:date>
						</s:param>
					</s:textfield>
					<font class="fieldError">${FieldErrors.birthday[0]}</font><br>
				</p>
				<p>
					&emsp;&emsp;&emsp;&emsp;
					<s:submit value="提交"></s:submit>
					&emsp;&emsp;
					<s:reset value="重置"></s:reset>
				</p>
			</s:form>
		</div>
	</div>
</body>
</html>
