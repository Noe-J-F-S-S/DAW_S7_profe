<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html><head>
<title>Actualizar empleado</title>
</head>
<jsp:useBean id="b_empleado" class="modelo.BEmpleado" scope="request"></jsp:useBean>
<body>
<form action="SActualizar_empleado">
	<table>
		<tr>
			<td>Codigo</td>
			<td><input type="text" name="codigo" value='<%=b_empleado.getCodigo() %>' readonly> </td>
		</tr>
		<tr>
			<td>Apellidos</td>
			<td><input type="text" name="apellidos" value='<%=b_empleado.getApellidos() %>' readonly> </td>
		</tr>
		<tr>
			<td>Nombres</td>
			<td><input type="text" name="nombres" value='<%=b_empleado.getNombres() %>' readonly> </td>
		</tr>
		<tr>
			<td>Sueldo</td>
			<td><input type="text" name="sueldo" value='<%=b_empleado.getSueldo() %>' > </td>
		</tr>
		<tr>
			<td><input type="submit" value="Actualizar" > </td>
		</tr>
	</table>
</form>
</body>
</html>