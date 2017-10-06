package celsawebapp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ControladorBusqueda extends HttpServlet {
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String dni = request.getParameter("input_dni_busqueda");
		
		//Accedo a la BD y recojo los datos del alumno segun el DNI especificado.
		Alumno alumno = OperacionesDAO.getAlumno(dni);
	
		//Seteamos el alumno al objeto sesion.
		HttpSession sesion = request.getSession(true);
		sesion.setAttribute("alumno", alumno);
		
		ServletContext servletcontext = this.getServletContext();
		RequestDispatcher requestdispatcher = servletcontext.getRequestDispatcher("/WEB-INF/busqueda.jsp");
		requestdispatcher.forward(request, response);
		
	}

}
