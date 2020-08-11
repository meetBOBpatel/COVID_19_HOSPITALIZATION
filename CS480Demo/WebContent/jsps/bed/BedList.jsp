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
	<h3 align="center"> Bed Table </h3>
		
	<table border="1" width="70%" align="center">
	<tr>
		<th>License Num</th>
		<th>Hospital ID</th>
		<th>License Beds</th>
		<th>Staffed Beds</th>
		<th>ICU Beds</th>
		<th>Pedi ICU Beds</th>
		<th>Bed Utilization</th>
		<th>Potential Increase</th>
		<th>Avg Ventilation</th>
		<th>Action</th> 
	</tr>
	
<c:forEach items="${BedList}" var="bed">
	<tr>
		<td>${bed.license_num}</td>
		<td>${bed.hospital_id} </td>
		<td>${bed.license_beds}</td>
		<td>${bed.staffed_beds}</td>
		<td>${bed.icu_beds} </td>
		<td>${bed.pedi_ice_beds}</td>
		<td>${bed.bed_utilization}</td>
		<td>${bed.potential_increase} </td>
		<td>${bed.avg_ventilator_use}</td>	
		<td>
		<a href="<%=request.getContextPath()%>/showEditFormBed?license_num=<c:out value='${bed.license_num}'/>">Edit</a>
		&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="<%=request.getContextPath()%>/deleteBed?license_num=<c:out value='${bed.license_num}'/>">Delete</a>
		</td>
	</tr>
</c:forEach>
</table>
	<a href="<c:url value='/jsps/bed/bed_form.jsp'/>" target="body">Add Bed</a>
</body>
</html>