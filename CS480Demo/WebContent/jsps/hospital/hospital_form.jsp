<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Hospital</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
<style>
		form{
			text-align: center;
			font-size: 19px;
		}
		h1{
			font-size: 30px;
			text-align: center;
		}
		body{
			background: coral;
		}
	</style>
  </head>
  
  <body>
  <h1>Add New Hospital</h1>

<p style="color: red; font-weight: 900">${msg }</p>
<form action="<c:url value='/UserServletHospital'/>" method="post">

	<input type="hidden" name="method" value="registHospital"/>
	Hospital Name   :<input type="text" name="hospital_name" value="${form.hospital_name }"/>
	<br/>
	Hospital ID		:<input type="text" name="hospital_id" value="${form.hospital_id }"/>
	<br/>
	Hospital Type   ：<input type="text" name="hospital_type" value="${form.hospital_type }"/>
	<br/>
	
	<input type="submit" value="Add"/>
</form>
  </body>
</html>
