<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<style type="text/css">
	table, td, th{
		border: 1px solid black;
	}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Base de datos de alumnos</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="miestilo.css">
<script src="https://use.fontawesome.com/ec60c23b24.js"></script>
</head>
<body>

	<div class="centrar">
		<i class="fa fa-database fa-2x" aria-hidden="true"></i>

		<h2 id="inline" class="centertext">&nbsp;Base de datos de alumnos</h2> 
	</div>

	<br> <br>


	<table class="table table-striped">
		<tr>
			<th>DNI</th>
			<th>Apellido</th>
			<th>Nombre</th>
			<th>Adeuda</th>
		</tr>
	
		<c:forEach var="alumnoTemp" items="${lista}" >
			<tr>
				<td><c:out value="${alumnoTemp.getDni()}"></c:out> </td>
				<td><c:out value="${alumnoTemp.getApellido()}"></c:out> </td>
				<td><c:out value="${alumnoTemp.getNombre()}"></c:out> </td>
				<td><c:out value="${alumnoTemp.getAdeuda()}"></c:out> </td>
			</tr>
		</c:forEach>
	
	</table>


</body>
</html>