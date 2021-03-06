package controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import modelo.BEmpleado;

import java.sql.*;
import java.util.ArrayList;

/**
 * Servlet implementation class SLista_empleados
 */
@WebServlet("/SLista_empleados")
public class SLista_empleados extends HttpServlet {
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
		ArrayList lista = new ArrayList();
		BEmpleado bemp;
		Statement sen;
		ResultSet res;
		conexion_bd();
		try {
			sen = conn.createStatement();
			res = sen.executeQuery("select * from empleado");
			while(res.next()) {
				bemp= new BEmpleado();
				bemp.setCodigo(res.getString(1));
				bemp.setApellidos(res.getString(2));
				bemp.setNombres(res.getString(3));
				bemp.setSueldo(res.getDouble(4));
				lista.add(bemp);
			}
		}catch(SQLException e) {
			JOptionPane.showConfirmDialog(null, "error en la consulta");
		}
		//se le asigna un id al array para poder ser llamado en la capa vista
		request.setAttribute("a_empleado",lista);
		RequestDispatcher rd=request.getRequestDispatcher("lista_empleados.jsp");
		rd.forward(request,response);
	}
	public void conexion_bd() {
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(cadena,usuario,clave);
		}catch(ClassNotFoundException e1) {
			JOptionPane.showMessageDialog(null, "Error en el driver");
		}catch(SQLException e2) {
			JOptionPane.showMessageDialog(null, "Error en la conexi?n");
		}
	}
	

}
