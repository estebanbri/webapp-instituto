package celsawebapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControladorEnvioMail extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		response.setContentType("text/html");
		
		String email = request.getParameter("input_mail").trim();
		String asunto = request.getParameter("input_asunto");
		String texto = request.getParameter("input_textarea");

		final String from = "ESCRIBRI-ACA-TU-EMAIL!!!";
		
		final boolean debug = true;
		
		final String body = texto;
		
		Session session;
		
		try {
			Context initContext = new InitialContext();
			Context context = (Context) initContext.lookup("java:comp/env");
			session = (Session) context.lookup("mail/Session");
			
			
			session.setDebug(debug);
			MimeMessage message = new MimeMessage(session);
			
			message.setFrom(new InternetAddress(from));
			InternetAddress[] address = {new InternetAddress(email)};
			message.setRecipients(Message.RecipientType.TO, address);
			message.setSubject(asunto);
			message.setSentDate(new Date());
			message.setContent(body, "text/html; charset=utf-8");
			Transport.send(message);
			out.println("<h2>Mensaje enviado con exito</h2>");
		
		}catch(Exception e) {
			e.printStackTrace();
			out.println("<h2>No se pudo enviar el mensaje</h2>");
		}
		

		
		
		   
		    
		
	
	}

}
