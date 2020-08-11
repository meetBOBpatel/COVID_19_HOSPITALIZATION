<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
</style>
</head>
<body>
	<h3 align="center"> Location Table </h3>
	
	<table border="1" width="70%" align="center">
	<tr>
		<th>Address</th>
		<th>ID</th>
		<th>city</th>
		<th>state</th>
		<th>county</th>
		<th>zipcode</th>
		<th>state_fips</th>
		<th>county_fips</th>
		<th>fips</th>
		<th>Action</th> 
	</tr>
<c:forEach items="${LocationList}" var="location">
	<tr>
		<td>${location.address}</td>
		<td>${location.hospital_id} </td>
		<td>${location.city}</td>
		<td>${location.state}</td>
		<td>${location.county} </td>
		<td>${location.zipcode}</td>
		<td>${location.state_fips}</td>
		<td>${location.county_fips} </td>
		<td>${location.fips}</td>
		
		<td>
		<a href="<%=request.getContextPath()%>/showEditFormLocation?address=<c:out value='${location.address}'/>">Edit</a>
		&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="<%=request.getContextPath()%>/deleteLocation?address=<c:out value='${location.address}'/>">Delete</a>
		</td>
	</tr>
</c:forEach>
</table>
<a href="<c:url value='/jsps/location/location_form.jsp'/>" target="body" style =" text-align: right">Add Location</a>
</body>
</html>