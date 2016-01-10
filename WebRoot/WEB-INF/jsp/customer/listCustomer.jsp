<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    <title>首页</title>
    <script type="text/javascript">
    	function delC(id) {
			if (window.confirm("确定删除？")) {
				window.location.href = 'customerAction_deleteCustomer.do?id='+id;
			}
		}
    
    </script>
    <style type="text/css">
    	body{
    		margin: auto;
    		font-family: Microsoft YaHei;
    		background-color: #FFCCBC;
    		
    	}
    
    
    	div.table,div.header{
    		
    		margin-top: 5%;
    	}
    	table{
    		min-width:80%;
    		max-width:95%;
			text-align:center;
    		margin: auto;
    	}
    	
    </style>
  </head>
  
  <body style="text-align: center;">
  	<div class="header">
  		欢迎你！${user.name}
  	</div>
  
  	<div>
  	
  	<s:a action="customerAction_saveCustomerUI" >保存客户</s:a> 
  	&nbsp &nbsp &nbsp
  	<s:a action="customerAction_listCustomer">列出所有客户</s:a>
	<br>
  	
  	</div>
  	<div class="table">
  		<table border="1">
  		<tr>
  		<td colspan="10">
  			客户信息
  		</td>
  		<tr>
  		<tr>
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
  			<tr style="background-color:#DCEDC8 ">
  			</s:if>
  			<s:else>
  			<tr style="background-color:#F0F4C3 ">
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
