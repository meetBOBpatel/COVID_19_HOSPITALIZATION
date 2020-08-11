<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Bed</title>
    
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
  <h1>Add New Bed</h1>

<p style="color: red; font-weight: 900">${msg }</p>
<form action="<c:url value='/UserServletBed'/>" method="post">

	<input type="hidden" name="method" value="registBed"/>
	License Num   :<input type="text" name="license_num" value="${form.license_num}"/>
	<br/>
	Hospital ID		:<input type="text" name="hospital_id" value="${form.hospital_id}"/>
	<br/>
	License Bed   ：<input type="text" name="license_beds" value="${form.license_beds}"/>
	<br/>
	Staffed Bed		:<input type="text" name="staffed_beds" value="${form.staffed_beds}"/>
	<br/>
	ICU Beds   :<input type="text" name="icu_beds" value="${form.icu_beds}"/>
	<br/>
	Pedi ICU Bed	:<input type="text" name="pedi_ice_beds" value="${form.pedi_ice_beds}"/>
	<br/>
	Bed Utilization   ：<input type="text" name="bed_utilization" value="${form.bed_utilization}"/>
	<br/>
	Potential Increase   :<input type="text" name="potential_increase" value="${form.potential_increase}"/>
	<br/>
	Average Ventilation Use   ：<input type="text" name="avg_ventilator_use" value="${form.avg_ventilator_use}"/>
	<br/>
	
	<input type="submit" value="Add"/>
</form>
  </body>
</html>
