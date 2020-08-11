<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Location</title>
    
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
  <h1>Add New Location</h1>

<p style="color: red; font-weight: 900">${msg }</p>
<form action="<c:url value='/UserServletLocation'/>" method="post">

	<input type="hidden" name="method" value="registLocation"/>
	Address    :<input type="text" name="address" value="${form.address }" />
	<br/>
 	Hospital ID	:<input type="text" name="hospital_id" value="${form.hospital_id }"  />
	<br/>
	City   ：<input type="text" name="city" value="${form.city }"/>
	<br/>
	State   :<input type="text" name="state" value="${form.state }"/>
	<br/>
 	County		:<input type="text" name="county" value="${form.county }"  />
	<br/>
	Zip Code   ：<input type="text" name="zipcode" value="${form.zipcode }"/>
	<br/>
	State Fips   :<input type="text" name="state_fips" value="${form.state_fips }"/>
	<br/>
 	County Fips		:<input type="text" name="county_fips" value="${form.county_fips }"  />
	<br/>
	Fips   ：<input type="text" name="fips" value="${form.fips }"/>
	<br/>
	
	<input type="submit" value="Add"/>
</form>
  </body>
</html>
