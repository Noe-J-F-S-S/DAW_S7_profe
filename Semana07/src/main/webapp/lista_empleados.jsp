<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="modelo.BEmpleado" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de empleados</title>
</head>
<body>

<jsp:useBean id="a_empleado" class="java.util.ArrayList" scope="request"></jsp:useBean>
<table>
	<tr>
		<th>Codigo</th><th>Apellidos</th><th>Nombres</th><th>Sueldo</th><th>Eliminar</th>
	</tr>
	<%
		BEmpleado bemp =new BEmpleado();
		for(int i = 0;i<a_empleado.size();i++){
			bemp = (BEmpleado)a_empleado.get(i);
	%>
	<tr>
		<td><a href='SData_empleado?codigo=<%=bemp.getCodigo()%>'><%=bemp.getCodigo() %></a></td>
		<td><%=bemp.getApellidos() %></td>
		<td><%=bemp.getNombres() %></td>
		<td><%=bemp.getSueldo() %></td>
		<td><a href='SDataEliminar_empleado?codigo=<%=bemp.getCodigo()%>'>Eliminar</a></td>
	</tr>
	<%}%>
</table>
</body>
</html>