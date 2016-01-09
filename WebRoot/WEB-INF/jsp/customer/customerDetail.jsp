<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    <title>客户详情</title>
    <style type="text/css">
    	body{
    		text-align:center;
    		margin: auto;
    		background-color: #B2DFDB;
    		font-family:Microsoft YaHei;
    	}
    
    </style>
  </head>
  
  
  
  <body>
  		
    	客户姓名：${name} <br>
    	客户性別：${gender==1?"男":"女" }<br>
  		客户状态：${status}<br>
  		公司名称：${companyName}<br>
  		办公电话：${companyPhone}<br>
  		手机：${cellphone }<br>
  		电子邮箱：${email}<br>
  		输入时间：${customerSaveDate}<br>
    	
  </body>
</html>
