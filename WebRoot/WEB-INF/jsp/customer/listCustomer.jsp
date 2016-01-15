<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    <title>首页</title>
   <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/css/user.css">
    <script type="text/javascript">
    	function delC(id) {
			if (window.confirm("确定删除？")) {
				window.location.href = 'customerAction_deleteCustomer.do?id='+id;
			}
		}
    
    </script>
    	<style>
    	body{
    	
    		background-color: white;
    	}
    	
    	div.table{
    		margin-left:15%;
    		}
    		
    	#customerTable{
    		width: 80%;
    	}
    	tr.tr{
    	
    		height: 40px;
    	}
    	
    	</style>
  </head>
  <body>
    <div class="header">
		<div class="logo"><img border="0" src="${pageContext.request.contextPath}/style/img/logo.jpg" /></div>
		<div class="userName"><font id="userName">欢迎你，${user.name}</font></div>
		<div class="doSth"><s:a action="userAction_logout.do" ><font id="login">注销</font></s:a></div>
	</div>
	<div class="func">
  	<s:a action="customerAction_saveCustomerUI" >新增客户</s:a> 
  	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  	<s:a action="customerAction_listCustomer">查看所有客户</s:a>
  	</div>
  	
  	<div class="table">
  		<table id="customerTable" >
  		<tr class="tr">
  			<td>序号</td>
  			<td>姓名</td>
  			<td>性別</td>
  			<td>状态</td>
  			<td>公司名称</td>
  			<td>办公电话</td>
  			<td>手机号</td>
  			<td>电子邮箱</td>
  			<td>输入日期</td>
  			<td>操作</td>
  		</tr>
  		<s:iterator value="#customerList" status="st" >
  			<s:if test="#st.odd==true"> 
  			<tr style="background-color:#f0f3f8" class="tr">
  			</s:if>
  			<s:else>
  			<tr style="background-color:#eef3fb " class="tr">
  			</s:else>
  			<td><s:property value="#st.count"></s:property></td>
    		<td>${name}</td>
    		<td>${gender==1?"男":"女"}</td>
  			<td>${status}</td>
  			<td>${companyName}</td>
  			<td>${companyPhone}</td>
  			<td>${cellphone }</td>
  			<td>${email}</td>
  			<td><s:date name="customerSaveDate" format="yyyy-MM-dd HH:mm:ss"></s:date></td>
  			<td>
    		<s:a action="customerAction_customerDetail?id=%{id}">查看详情</s:a>
    		<s:a action="customerAction_updateCustomerUI?id=%{id}">修改</s:a>
    		<a href="javascript:void(0)" onclick="delC(${id})">删除</a>
    		</td>
    		</tr>
    	</s:iterator>
  		</table>
    	</div>
  </body>
</html>
