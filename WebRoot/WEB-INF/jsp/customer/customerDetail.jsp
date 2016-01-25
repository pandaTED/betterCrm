<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>客户详情</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/style/css/user.css">
<script src="${pageContext.request.contextPath}/js/jquery-2.1.4.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.validate.js"></script>
<script src="${pageContext.request.contextPath}/js/messages_zh.js"></script>
<script type="text/javascript">
	$().ready(function() {
		$("#addTrackingForm").validate({
			rules : {
				text : {
					required : true,
					minlength : 10,
					maxlength : 255
				}
			}
		});
	});
</script>
<style type="text/css">
body {
	background-color: white;
}

div.customerDetail, div.tracking, div.trackingList {
	width: 50%;
	margin-left: 30%;
}

table.table {
	width: 80%;
}
.text{
	font-size: 22px;
	font-family: Microsoft YaHei;
}

</style>

</head>
<body>
	<div class="header">
		<div class="logo">
			<img border="0"
				src="${pageContext.request.contextPath}/style/img/logo.jpg" />
		</div>
		<div class="userName">
			<font id="userName">欢迎你，${user.name}</font>
		</div>
		<div class="doSth">
			<s:a action="userAction_logout.do">
				<font id="login">注销</font>
			</s:a>
		</div>
	</div>
	<div class="func">
		<s:a action="customerAction_saveCustomerUI">新增客户</s:a>
		&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
		<s:a action="customerAction_listCustomer">查看所有客户</s:a>
	</div>

	<div class="customerDetail">
		<table class="table" border="1">
			<th colspan="2">姓名/&emsp;${name}&emsp;
				状态/&emsp;${status}&emsp;客户性別/&emsp;${gender==1?"男":"女"}&emsp;客户年龄/&emsp;${age}&emsp;
				生日/<s:date name="birthday" format="yyyy-MM-dd"></s:date>
			</th>
			<tr>
				<td>公司</td>
				<td>${companyName}</td>
			</tr>
			<tr>
				<td>固话</td>
				<td>${companyPhone}</td>
			</tr>
			<tr>
				<td>手机</td>
				<td>${cellphone }</td>
			</tr>
			<tr>
				<td>邮箱</td>
				<td>${email}</td>
			</tr>
			<tr>
				<td>输入时间</td>
				<td><s:date name="customerSaveDate"
						format="yyyy-MM-dd HH:mm:ss"></s:date></td>
			</tr>
		</table>
		<br> 

	</div>
	<div class="tracking">
		<s:form id="addTrackingForm" action="trackingAction_addTracking">
			<table class="table" border="1">
				<tr>
					<td>跟踪信息</td>
				</tr>
				<td><s:textarea rows="5" cols="50" name="text" cssClass="text"></s:textarea>
				</td>
				<tr>
					<td><font class="fieldError">${FieldErrors.text[0]}</font></td>
				</tr>
				<tr style="text-align: right;">
					<td><s:submit value="提交"></s:submit> <s:reset value="重写"></s:reset>
					</td>
				</tr>
			</table>
		</s:form>
	</div>

	<br>
	<div class="trackingList">
		<table border="1" class="table">
			<s:iterator value="#trackingList">
				<tr>
					<td style="background-color: #FFF9C4">追踪时间：<s:date
							name="trackingSaveDate" format="yyyy-MM-dd HH:mm:ss"></s:date> <s:a
							action="trackingAction_deleteTracking?id=%{id}">删除</s:a>
					</td>
				</tr>
				<tr style="height: 50px;">
					<td style="background-color: #D1C4E9;">追踪反馈：${text}</td>
				</tr>
			</s:iterator>
		</table>
	</div>
</body>
</html>
