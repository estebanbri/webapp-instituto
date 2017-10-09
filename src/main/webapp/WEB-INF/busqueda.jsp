<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://use.fontawesome.com/ec60c23b24.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Busqueda de alumno</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
<style>
.wrapper {
    position: absolute;
    bottom: 10px;
}
</style>
<link rel="stylesheet" type="text/css" href="miestilo.css">
</head>
<body>

<c:if test="${alumno != null }">
	<table class="table table-striped">
		<tr>
			<th>DNI</th>
			<th>Apellido</th>
			<th>Nombre</th>
			<th>Adeuda</th>
		</tr>
		<tr>
			<td>${alumno.dni}</td>
			<td>${alumno.apellido}</td>
			<td>${alumno.nombre}</td>
			<td>${alumno.adeuda}</td>
		</tr>
	</table>
	
	<br><br>
	<div class="wrapper">
	<i class="fa fa-trash-o fa-lg" aria-hidden="true"></i>
	<input type="button" class="btn btn-danger" value="Eliminar datos alumno" onclick="location.href = 'controladoreliminar.do';">
	</div>
	
</c:if>

<c:if test="${alumno == null }">
	<h1>Alumno no encontrado en la base de datos.</h1>
</c:if>

</body>
</html>