<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registro de empleados</title>
</head>
<body>
<form action="SRegistrar_empleado">
	<table>
		<tr>
			<td>Apellidos</td>
			<td><input type="text" name="apellidos" > </td>
		</tr>
		<tr>
			<td>Nombres</td>
			<td><input type="text" name="nombres" > </td>
		</tr>
		<tr>
			<td>Sueldo</td>
			<td><input type="text" name="sueldo" > </td>
		</tr>
		<tr>
			<td><input type="submit" value="Registrar" > </td>
		</tr>
	</table>
</form>
</body>
</html>