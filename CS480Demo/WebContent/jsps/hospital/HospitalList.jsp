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
  		align: center;
	}
	a:hover {
  		color: yellow;
  		background-color: transparent;
  		text-decoration: none;
	}
</style>
</head>
<body>
	<h3 align="center"> Hospital Table </h3>
	
	<table border="1" width="70%" align="center">
	<tr>
		<th>id</th>
		<th>name</th>
		<th>type</th>
		<th>Action</th> 
	</tr>
<c:forEach items="${HospitalList}" var="hospital">
	<tr>
		<td>${hospital.hospital_id}</td>
		<td>${hospital.hospital_name} </td>
		<td>${hospital.hospital_type}</td>
		
		<td>
		<a href="<%=request.getContextPath()%>/showEditForm?hospital_id=<c:out value='${hospital.hospital_id}'/>">Edit</a>
		&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="<%=request.getContextPath()%>/deleteHospital?hospital_id=<c:out value='${hospital.hospital_id}'/>">Delete</a>
		</td>
	</tr>
</c:forEach>
</table>
<a href="<c:url value='/jsps/hospital/hospital_form.jsp'/>" target="body">Add Hospital</a>
</body>
</html>