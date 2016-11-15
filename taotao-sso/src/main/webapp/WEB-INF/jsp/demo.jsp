<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>



<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="Cache-Control" content="no-cache,must-revalidate">
    <title>注册-个人用户</title>
    <link type="text/css" rel="stylesheet" href="/css/regist.personal.css"/>
    <link type="text/css" rel="stylesheet" href="/css/passport.base.css"/>
    <script type="text/javascript" src="/js/jquery-1.6.4.js"></script>
</head>
<body>
<div class="w" id="logo">
    <div>
    	<a href="http://www.taotao.com:9092">
    		<img src="/images/taotao-logo.gif" alt="淘淘商城" width="170" height="60"/>
    	</a> <b></b>
    </div>
</div>

<div class="w" id="regist">
    <div class="mt">
        <ul class="tab">
            <li class="curr">个人用户</li>
        </ul>
        <div class="extra">
        <span>我已经注册，现在就&nbsp;
        	<a href="/page/login" class="flk13">登录</a>
        </span>
        </div>
    </div>
    <div class="mc">
        <form:form modelAttribute="validateModel" method="post" action="/demo/vdemo.html">    
            <div class="form" onselectstart="return false;">
            	<form:errors path="*"></form:errors><br/><br/>
            
		        name：<input type="text" name="name"/> <br/>
		        <form:errors path="name"></form:errors><br/>
		        
		        age：<input type="text" name="age"/><br/>
		        <form:errors path="age"></form:errors><br/>
		        
		        email： <input type="text" name="email"/><br/>
		        <form:errors path="email"></form:errors><br/>
		
		        <input type="submit" value="Submit" />
			</div>
        </form:form>
    </div>
<script type="text/javascript">
	
</script>
</body>
</html>
