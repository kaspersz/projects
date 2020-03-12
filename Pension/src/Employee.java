import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="employee")
public class Employee {
	
	
	@Id
	private int id;
	
	@Column(name="first_name")
	private String name;
	
	@Column(name="last_name")
	private String surname;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="pension_id")
	private Pension pension = new Pension(0,0,0,0,"isNotActive");
	
	@Column(name="salary")
	private double salary;
	
	
	
	

	public Employee() {
		
	}

	public Employee(int id, String name, String surname, double salary) {
		
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Pension getPension() {
		return pension;
	}

	public void setPension(Pension pension) {
		this.pension = pension;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
	

	public void updateEmployeeContribution() {
		Scanner sc = new Scanner(System.in);
		Scanner sc1 = new Scanner(System.in);
		double nmw = 1600;
		double c = 0;
		
		
			if(pension.isActive().equalsIgnoreCase("isActive")) {
				do {
					
				
				System.out.println("Type the amount which you want to contribute for Employee" + " " + name + " " + surname);
				
				c = sc.nextDouble();
				
				if(salary - c - pension.getAvcMonthly() - pension.getAvcOneOff() < nmw ) {
						
						System.out.println("You cannot decrease your salary below NMW. Please try again");
					}
				
					else if(c>0 && c<=500) {
					pension.setEmployeeContribution(c);
					pension.setEmployerContribution(0.02*salary);
					}
	
					else if(c>500) {
					pension.setEmployeeContribution(c);
					pension.setEmployerContribution(0.05*salary);
					}
				
				
				
				}
				while(c>0 && salary - c - pension.getAvcMonthly() - pension.getAvcOneOff() < nmw);
			
				}
	
	};
	
	public void updateAvcOneOff() {
		Scanner sc = new Scanner(System.in);
		Scanner sc1 = new Scanner(System.in);
		double nmw = 1600;
		double c = 0;
		
		if(pension.isActive().equalsIgnoreCase("isActive")) {
			
			do {
				System.out.println("Type the amount which you want to contribute to AVC One off");
				
				c = sc.nextDouble();
				
				if(salary - pension.getEmployeeContribution() - c - pension.getAvcMonthly() < nmw ) {
					
					System.out.println("You cannot decrease your salary below NMW. Please try again.");
					
				}
				else { pension.setAvcOneOff(c); }
				
				}
			
				while(salary - pension.getEmployeeContribution() - c - pension.getAvcMonthly() < nmw);
	}
		else System.out.println("you need to opt in to the Pension if want choose AVC");
	};
	
	public void resetAvcOneOff() {
		
	}
	public void updateAvcMonthly() {
		Scanner sc = new Scanner(System.in);
		Scanner sc1 = new Scanner(System.in);
		double nmw = 1600;
		double c = 0;
		
		if(pension.isActive().equalsIgnoreCase("isActive")) {
			
			do {
				
				System.out.println("Type the amount which you want to contribute to AVC Monthly");
				
				c = sc.nextDouble();
			
				if(salary - pension.getEmployeeContribution() - c - pension.getAvcOneOff() < nmw ) {
				System.out.println("You cannot decrease your salary below NMW");
				}
				
				else  pension.setAvcMonthly(c);
				}
			
				while(salary - pension.getEmployeeContribution() - c - pension.getAvcOneOff() < nmw);
			
		}
			 
			
		else System.out.println("you need to opt in to the Pension if want choose AVC");
		
}
	public void OptOut() {
		setPension(new Pension(0,0,0,0,"isNotActive"));
	}
	public void OptIn() {
		Scanner sc = new Scanner(System.in);
		Scanner sc1 = new Scanner(System.in);
		double nmw = 1600;
		double c = 0;
		
		String s;
		
		do {
			
			System.out.println("Type the amount which you want to contribute" + " " + name + " " + surname);
			
			c = sc.nextDouble();
			
			if(salary - c - pension.getAvcMonthly() - pension.getAvcOneOff() < nmw ) {
					
					System.out.println("You cannot decrease your salary below NMW. Please try again");
				}
			else if (c<=0) {System.out.println("The amount needs to be greatest than zero");}
		}
			while(c<=0 || salary - c - pension.getAvcMonthly() - pension.getAvcOneOff() < nmw);
		
		if(c>0 && c<=500) {
			
			pension.setEmployeeContribution(c);
			pension.setActive("isActive");
			pension.setEmployerContribution(0.02*salary);
		}

		else if(c>500) {
			
			pension.setEmployeeContribution(c);
			pension.setActive("isActive");
			pension.setEmployerContribution(0.05*salary);
		}
		

		System.out.println("If you wish to set your AVC monthly, please type Monthly, if AVC oneoff, please type OneOff. However if you do not want to contribute any additional amount, please type No remember that you can amend your Pension anytime in the future");
		
		s = sc1.nextLine();
		
			if(s.equalsIgnoreCase("Monthly")){
				updateAvcMonthly();
			}
			else if(s.equalsIgnoreCase("OneOff")){
				updateAvcOneOff();
			}
			else System.out.println("Thank you for your choice");
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", surname=" + surname + ", pension=" + pension + ", salary="
				+ salary + "]";
	}
	

}
