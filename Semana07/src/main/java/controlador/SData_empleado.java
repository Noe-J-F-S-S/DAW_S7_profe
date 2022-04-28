package controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import modelo.BEmpleado;
import javax.swing.JOptionPane;
/**
 * Servlet implementation class SData_empleado
 */
@WebServlet("/SData_empleado")
public class SData_empleado extends HttpServlet {
	String driver="com.mysql.cj.jdbc.Driver";
	String cadena="jdbc:mysql://localhost/empresa2022";
	String usuario="root";
	String clave="";
	Connection conn;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processResponse(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		processResponse(request, response);
	}
	protected void processResponse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BEmpleado bemp=new BEmpleado();
		String codigo =request.getParameter("codigo");
		Statement sen;
		ResultSet res; 
		conexion_bd();
		try {
			sen=conn.createStatement();
			res = sen.executeQuery("select * from empleado where codigo ="+codigo);
			while(res.next()){
				bemp.setCodigo(res.getString(1));
				bemp.setApellidos(res.getString(2));
				bemp.setNombres(res.getString(3));
				bemp.setSueldo(res.getDouble(4));
			}
		}catch(SQLException e) {
			JOptionPane.showConfirmDialog(null, "Error al cargar los datos");
		}
		request.setAttribute("b_empleado",bemp);
		RequestDispatcher rd=request.getRequestDispatcher("data_empleado.jsp");
		rd.forward(request,response);
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
