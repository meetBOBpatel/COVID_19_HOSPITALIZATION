<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>top</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
	body {
		/* background: #4682B4; */
		background: #333; 
	}
 	.topnav a {
	  float: left;
	  color: #f2f2f2;
	  text-align: center;
	  padding: 14px 16px;
	  text-decoration: none;
	  font-size: 17px;
	  border-radius: 25px;
	}

	.topnav a:hover {
	  background-color: black;
	  color: yellow;
	}
	.topnav {
	  overflow: hidden;
	  background-color: red;
	  border: 2px solid pink;
	  padding: 2px;
	  border-radius: 25px;
	}

	
</style>
  </head>
  
  <body>
<h1 style="text-align: center; color: white">CSC480</h1>
<div style="font-size: 10pt;">
	<c:choose>
		<c:when test="${empty sessionScope.session_user }">
		<nav class = "topnav">
			<a href="<c:url value='/jsps/user/login.jsp'/>" target="_parent">Login</a>
			<a href="<c:url value='/jsps/user/regist.jsp'/>" target="_parent">Register</a>
			<a href="<c:url value='/jsps/user/initialize.jsp'/>" target="_parent">Initialize Database</a> 
		    
		</nav>
			
		</c:when>
		<c:otherwise>
			Hello：${sessionScope.session_user.username };
		<nav class = "topnav">
			<a href="<c:url value='/jsps/item.jsp'/>" target="body">User Info</a>
			<a href="<c:url value='/jsps/location/location_item.jsp'/>" target="body">Location</a> 
			<a href="<c:url value='/jsps/hospital/hospital_item.jsp'/>" target="body">Hospital</a> 
			<a href="<c:url value='/jsps/bed/bed_item.jsp'/>" target="body">Bed</a>
			<a href="<c:url value='/jsps/queries/allButtons.jsp'/>" target="body">All Queries</a>
		</nav>
			</c:otherwise>
	</c:choose>

</div>
  </body>
</html>
