import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.jboss.jandex.EmptyTypeTarget;

public class Main {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.addAnnotatedClass(Pension.class).buildSessionFactory();

		Session session = factory.openSession();

		
		  List<Employee> list = new ArrayList(); 
		  
		  try {
		  
		  System.out.println("Creating new  object");
		  
		  Employee e1 = new Employee(128, "Kasper", "Szczygiel", 3000); 
		  
		  Employee e2 = new Employee(269, "Frank", "Muller", 3500);
		  
		  list.add(e1); list.add(e2); e1.OptIn(); e2.OptIn();
		  
		  session.beginTransaction();
		  
		  System.out.println("Saving Employee Kasper"+e1 + "Saving Employee Frank"
		  +e2); 
		  
		  for(int i = 0; i<list.size(); i++)
		  
		  { session.save(list.get(i)); }
		  
		  
		  
		  session.getTransaction().commit();
		  
		  System.out.println("DONE!"); }
		  
		  finally { System.out.println("First done"); }
		  
		  
		 

	

		/*
		 * try {
		 * 
		 * System.out.println("Creating new  object");
		 * 
		 * e1 = new Employee(124, "Kasper", "Szczygiel", 2000);
		 * 
		 * e1.OptIn();
		 * 
		 * 
		 * session.beginTransaction();
		 * 
		 * System.out.println("Saving Employee"+e1);
		 * 
		 * session.save(e1);
		 * 
		 * 
		 * session.getTransaction().commit();
		 * 
		 * System.out.println("DONE!"); } finally { System.out.println("First done"); }
		 * 
		 */
		/*
		 * try {
		 * 
		 * session.beginTransaction();
		 * 
		 * System.out.println("Getting object");
		 * 
		 * Employee employee = (Employee)session.load(Employee.class, 269);
		 * 
		 * employee.OptOut();
		 * 
		 * session.getTransaction().commit();
		 * 
		 * 
		 * System.out.println("DONE!" + employee.getName() + " "
		 * 
		 * + employee.getSurname() + " " + "has opted out from the Pension"); } finally
		 * { factory.close(); }
		 * 
		 */
	}
}
