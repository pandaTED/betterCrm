<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    <title>客户详情</title>
    <style type="text/css">
    	body{
    		text-align:center;
    		background-color: #B2DFDB;
    		font-family:Microsoft YaHei;
    	}
    	
    	table{
    		margin:auto;
    		margin-top:5px;
    		text-align:left;	
    		min-width: 50%;
    		max-width: 75%;
    	}
    	
    	
    	.text{
    	font-size: 20px;
    	font-family:Microsoft YaHei;
    	background-color: #DCEDC8;
    	}
    	
    	div.header{
    		
    		margin-top: 5%;
    	}
    </style>
  </head>
  <body>
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
  		<th colspan="2">姓名：${name} &nbsp&nbsp 状态：${status}&nbsp&nbsp客户性別：${gender==1?"男":"女"}&nbsp&nbsp客户年龄：${age}&nbsp&nbsp 生日：<s:date name="birthday" format="yyyy-MM-dd"></s:date> </th>
  		<tr>
  			<td>公司名称：</td> <td>${companyName}</td>
  		</tr>
  		<tr>
  			<td>办公电话：</td><td>${companyPhone}</td>
  		</tr>
  		<tr>
  			<td>手机：</td><td>${cellphone }</td>
  		</tr>
  		<tr>
  			<td>电子邮箱：</td><td>${email}</td>
  		</tr>
  		<tr>
  			<td>输入时间：</td><td><s:date name="customerSaveDate" format="yyyy-MM-dd HH:mm:ss"></s:date></td>
  		</tr>
    	</table>
    	</div>
    	<div class="tracking">
    	<s:form action="trackingAction_addTracking">
    		<table border="1">
    			<tr>
    				<td>跟踪信息</td>
    			</tr>
    				<td>
    					<s:textarea rows="5" cols="68" name="text" cssClass="text"></s:textarea>
    					
    				</td>
    				<tr style="text-align: right;">
    					<td>
    					<s:submit value="提交"></s:submit>
    					<s:reset value="重写"></s:reset>
    					</td>
    				</tr>
    		</table>
    		</s:form>	
    	</div>
    	<div>
    		<table border="1">
    		<s:iterator value="#trackingList">
    			<tr>
   				<td style="background-color:#FFF9C4">追踪时间：<s:date name="trackingSaveDate" format="yyyy-MM-dd HH:mm:ss"></s:date> <s:a action="trackingAction_deleteTracking?id=%{id}">删除</s:a>
    				</td>
    			</tr>
    			<tr style="height: 50px;">
    				<td style="background-color:#D1C4E9;">追踪反馈：${text}</td>
    			</tr>
    		</s:iterator>
    		</table>
    	</div>
  </body>
</html>
