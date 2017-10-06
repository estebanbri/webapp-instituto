package celsawebapp;




import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class OperacionesDAO {

	static SessionFactory factory = new Configuration()
			.addAnnotatedClass(Alumno.class)
			.configure("hibernate.cfg.xml")
			.buildSessionFactory();
	
	public static void agregar_o_actualizar_Alumno(Alumno alumno){
		
		Session sesion = factory.openSession();

		try {
			//comenzamos la transaccion
			sesion.beginTransaction();
			//Almacenar el alumno
			sesion.saveOrUpdate(alumno);
			//comit la transaccion
			sesion.getTransaction().commit();
		}catch(Exception e) {
			System.out.println("No se pudo almacenar el alumno");
		}finally {
			sesion.close();
		}
	}
	public static List<Alumno> getAlumnos(){
		Session sesion = factory.openSession();
		List<Alumno> listaAlumno = new ArrayList();
		try {
			//comenzamos la transaccion
			sesion.beginTransaction();
			/*SELECT todos los alumnos 
			 * (ATENCION: acordate de no usar el 
			 * nombre de la tabla tenes que poner 
			 * en el nombre de la @Entity como no 
			 * le asignaste ningun name se corresponde
			 *  con el nombre de la clase.
			*/
			Query query = sesion.createQuery("from Alumno");
			listaAlumno = query.getResultList();
			//comit la transaccion
			sesion.getTransaction().commit();
		}catch(Exception e){
			System.out.println("No se pudo hacer el SELECT de todos los alumnos");
		}finally{
			sesion.close();
		}
		
		return listaAlumno ;
	}
	public static Alumno getAlumno(String dni) {
		Session sesion = factory.openSession();
		Alumno alumno = new Alumno();
		try {
		sesion.beginTransaction();	
		alumno =(Alumno)sesion.get(Alumno.class, dni); 	
		sesion.getTransaction().commit();
		}
		catch(Exception e) {
			System.out.println("No se pudo encontrar el alumno en la base de datos");
		}finally {
			sesion.close();
		}
		return alumno;
	}
	public static void eliminarAlumno(String dni) {
		Session sesion = factory.openSession();
		
		try {
		sesion.beginTransaction();	
		
        Query query = sesion.createQuery("delete from Alumno where dni = :dni");
        query.setParameter("dni",dni);
        query.executeUpdate();
		
		
		sesion.getTransaction().commit();
		}
		catch(Exception e) {
			System.out.println("No se pudo eliminar el alumno en la base de datos");
		}finally {
			sesion.close();
		}
		
	}
	
}
