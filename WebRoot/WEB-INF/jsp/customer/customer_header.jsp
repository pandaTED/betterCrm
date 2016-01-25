<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

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
