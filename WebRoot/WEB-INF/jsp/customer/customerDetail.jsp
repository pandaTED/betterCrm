<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>客户详情</title>
<%@include file="customer_js_css.jsp"%>
<script
	src="${pageContext.request.contextPath}/js/validate_rules/customer_customerDetail.js"></script>
<style type="text/css">
body {
	background-color: white;
}

div.customerDetail, div.tracking, div.trackingList {
	width: 50%;
	margin-left: 30%;
}

table.table {

	border:1px;
	width: 80%;
}
table.table td{
	border-width: 1px;
}
table.table tr{
	border-width: 1px;
}
.text {
	font-size: 22px;
	font-family: Microsoft YaHei;
}
</style>

</head>
<body>
	<%@include file="customer_header.jsp"%>

	<div class="customerDetail">
		<table class="table"  border="1">
			<th colspan="2">
			客户详情
			</th>
			<tr>
				<td>姓名</td>
				<td>${name}</td>
			</tr>
			<tr>
				<td>状态</td>
				<td>${status}</td>
			</tr>
			<tr>
				<td>性别</td>
				<td>${gender==1?"男":"女"}</td>
			</tr>
			<tr>
				<td>年龄</td>
				<td>${age}</td>
			</tr>
			<tr>
				<td>生日</td>
				<td><s:date name="birthday" format="yyyy-MM-dd"></s:date></td>
			</tr>
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
			<table class="table" >
				<tr>
					<td>拜访信息</td>
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
		<table border="0" class="table">
			<s:iterator value="#trackingList">
				<tr>
					<td style="background-color: #56c9ac">录入时间：<s:date
							name="trackingSaveDate" format="yyyy-MM-dd HH:mm:ss"></s:date> &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
							<s:a action="trackingAction_deleteTracking?id=%{id}">删除</s:a>
					</td>
				</tr>
				<tr style="height: 50px;">
					<td style="background-color: #DCEDC8;">反馈：${text}</td>
				</tr>
			</s:iterator>
		</table>
	</div>
</body>
</html>
