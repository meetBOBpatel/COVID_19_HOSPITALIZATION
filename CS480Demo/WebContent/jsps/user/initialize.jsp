<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="">
    
    <title>Initialize Database</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style>
	body{
	
		background: coral;		
	}
</style>

  </head>
  
<body>
    <h1>Welcome to the Hospital Database</h1>
    <%-- <br>
    <a href="<c:url value='/InitServlet'/>" target="body">Initialize Database</a>&nbsp;&nbsp;
      --%>
      
       <h1 style="text-align: center;">Initialize Database</h1>

<div id = "topInit">
<form action="< c:url value='/InitServlet'/>" method="post">
	<input type="submit" value="Initialize Database"/>
</form>
  </body>
</html>



  
