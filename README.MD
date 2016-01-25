##betterCrm
###这是我正在写的一个crm管理系统，采用Spring、struts2、hibernate流行框架。
###主要功能
	用户注册模块
		|--注册
		|--登录
	客户信息管理模块
		|--新增客户
		|--修改
		|--删除
		|--查看详情
		|--列出所有客户
	客户追踪模块
		|--录入客户追踪信息
		|--删除追踪信息
###框架版本
	spring 		4.2.3
	struts2 	2.3
	hibernate 	4.2.2
###本项目使用到的一些小功能的lib
	commons-lang.jar中的html代码转义为无害代码，
	比如把客户输入的表单中的<font></font>,<>/等符号转为html的代表符号。
###所需的lib已经全部放到了/WEB-INF/lib 目录下
###功能模块
1.cn.panda.bettercrm.interceptor/RequestEncoding为编码拦截器，负责把页面编码、用户输入的文本转为utf-8编码；
2.使用struts2原生的validate框架实现表单的后台验证；
3.使用jquery-validate插件使用表单的前台验证；
4.使用ajax在注册和登录页面验证登录名是否已存在。
###开发环境
	eclipse-4.5.1
	mysql-5.7
	jdk-1.8
	tomcat8.0.28
###在本地运行时，请先修改config/jdbc.properties内的数据库连接信息
###不完善的地方
1.功能十分简单，后期会加入更多实用的功能
2.页面布局有bug，在我学完easyUI后会对页面进行重写
3.地址栏显示action链接过长，后期会进行修改
###本项目是我的练手项目，不足之处还很多，希望大家在发现问题后给我留言，或发email给我。
###本项目对于javaEE初学者学习SSH框架搭建，jquery-validate使用，ajax原理，struts2-validate框架等有一定帮助作用