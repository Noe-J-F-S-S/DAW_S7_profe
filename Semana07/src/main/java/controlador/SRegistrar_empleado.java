package controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import modelo.BEmpleado;
import javax.swing.JOptionPane;
/**
 * Servlet implementation class SRegistrar_empleado
 */
@WebServlet("/SRegistrar_empleado")
public class SRegistrar_empleado extends HttpServlet {
	String driver="com.mysql.cj.jdbc.Driver";
	String cadena="jdbc:mysql://localhost/empresa2022";
	String usuario="root";
	String clave="";
	Connection conn;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		processRequest(request, response);
	}
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ape=request.getParameter("apellidos");
		String nomb=request.getParameter("nombres");
		double suel=Double.parseDouble(request.getParameter("sueldo"));
		Statement sen;
		String consulta;
		conexion_bd();
		try {
			sen=conn.createStatement();
			consulta="inser into empleado(apellidos,nombres,sueldo) values(?,?,?)";
			sen.executeUpdate(consulta);
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null,"Error en la consulta");
		}
		response.sendRedirect("SLista_empleados");
	}
	public void conexion_bd() {
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(cadena,usuario,clave);
		}catch(ClassNotFoundException e1) {
			JOptionPane.showMessageDialog(null, "Error en el driver");
		}catch(SQLException e2) {
			JOptionPane.showMessageDialog(null, "Error en la conexión");
		}
	}

}
