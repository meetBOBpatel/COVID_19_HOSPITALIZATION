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
  <h1> Welcome to Simple and Complex queries </h1>
  <br> 
  <a href="<%=request.getContextPath()%>/queries?action=/query_1">1. List all hospital names of type VA or Short Term Acute Care hospital</a>
  <br> <br> 
  <a href="<%=request.getContextPath()%>/queries?action=/query_2">2. Count how many hospitals in the database have been licensed to have more than 100 beds</a>
  <br> <br> 
  <a href="<%=request.getContextPath()%>/queries?action=/query_3">3. List all hospital id and county for the hospitals present in the state of Alabama order by non increasing county name.</a>
  <br> <br> 
  <a href="<%=request.getContextPath()%>/queries?action=/query_4">4. List all Hospitals and their addresses in the State of Alabama</a>
  <br> <br> 
  <a href="<%=request.getContextPath()%>/queries?action=/query_5">5. List the average bed capacity for distinct hospital types</a>
  <br> <br> 
  <a href="<%=request.getContextPath()%>/queries?action=/query_6">6. List top 3 hospitals in a state with minimum bed utilization</a>
  <br> <br> 
  <a href="<%=request.getContextPath()%>/queries?action=/query_7">7. List all hospital with address and types who has a bed capacity less than the average bed capacity of that type hospital</a>
  <br> <br> 
  <a href="<%=request.getContextPath()%>/queries?action=/query_8">8. List the number of hospitals per state</a>
   </body>
