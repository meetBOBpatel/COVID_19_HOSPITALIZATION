<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="">
    
    <title>body</title>
    
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
	a:link {
  		color: green;
  		background-color: transparent;
  		text-decoration: none;
  		text-align: center;
	}
	a:hover {
  		color: yellow;
  		background-color: transparent;
  		text-decoration: none;
	}
	h1{
		text-align: center;
	}
</style>
  </head>
  
  <body>
    <h1>Welcome to User Table</h1>
    <br>
    <a href="<c:url value='/findAll'/>" target="body">Please list all the user in the table</a>&nbsp;&nbsp;
 
    
  </body>
</html>
