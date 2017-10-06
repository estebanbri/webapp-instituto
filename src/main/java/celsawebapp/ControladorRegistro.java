package celsawebapp;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ControladorRegistro extends HttpServlet {

	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String dni = request.getParameter("input_dni");
		String apellido = request.getParameter("input_apellido");
		String nombre = request.getParameter("input_nombre");
		String adeuda = request.getParameter("input_adeuda");
		
		Alumno alumno = new Alumno(dni,apellido, nombre,adeuda);
		request.setAttribute("alumno", alumno);
		
		//Agrego el alumno a la base de datos
		OperacionesDAO.agregar_o_actualizar_Alumno(alumno);
		
		//Paso el request con el objeto alumno al jsp
		ServletContext servletcontext = this.getServletContext();
		RequestDispatcher requestdispatcher = servletcontext.getRequestDispatcher("/WEB-INF/registro.jsp");
		requestdispatcher.forward(request, response);
	}

}
