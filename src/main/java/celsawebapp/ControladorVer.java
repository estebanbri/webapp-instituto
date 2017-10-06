package celsawebapp;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ControladorVer extends HttpServlet {
	    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Alumno> lista = OperacionesDAO.getAlumnos();
		
		request.setAttribute("lista", lista);
		
		ServletContext servletcontext = this.getServletContext();
		RequestDispatcher requestdispatcher = servletcontext.getRequestDispatcher("/WEB-INF/verbasededatos.jsp");
		requestdispatcher.forward(request, response);
	}

}
