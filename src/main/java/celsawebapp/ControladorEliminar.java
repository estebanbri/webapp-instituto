package celsawebapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;


public class ControladorEliminar extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession(false);
		Alumno alumno =(Alumno) sesion.getAttribute("alumno");
		
		//Eliminar de la base de datos
		OperacionesDAO.eliminarAlumno(alumno.getDni());
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h2>Registro borrado con exito</h2>");
		out.println("</html></body>");
		
	}

	

}
