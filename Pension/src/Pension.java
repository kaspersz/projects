import java.math.BigDecimal;
import java.util.Scanner;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="pension")
public class Pension {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="employee_contribution")
	private double EmployeeContribution;
	
	@Column(name="employer_contribution")
	private double EmployerContribution;
	
	@Column(name="avcOneOff")
	private double AvcOneOff;
	
	@Column(name="avcMonthly")
	private double AvcMonthly;
	
	@Column(name="isActive")
	private String isActive;
	
	
	public Pension() {
		
	}

	public Pension(double employeeContribution, double employerContribution, double avcOneOff,
			double avcMonthly, String isActive) {
	
		
		this.EmployeeContribution = employeeContribution;
		this.EmployerContribution = employerContribution;
		this.AvcOneOff = avcOneOff;
		this.AvcMonthly = avcMonthly;
		this.isActive = isActive;
	}

	public double getEmployeeContribution() {
		return EmployeeContribution;
	}

	public void setEmployeeContribution(double employeeContribution) {
		EmployeeContribution = employeeContribution;
	}

	public double getEmployerContribution() {
		return EmployerContribution;
	}

	public void setEmployerContribution(double employerContribution) {
		EmployerContribution = employerContribution;
	}

	public double getAvcOneOff() {
		return AvcOneOff;
	}

	public void setAvcOneOff(double avcOneOff) {
		AvcOneOff = avcOneOff;
	}

	public double getAvcMonthly() {
		return AvcMonthly;
	}

	public void setAvcMonthly(double avcMonthly) {
		AvcMonthly = avcMonthly;
	}

	public String isActive() {
		return isActive;
	}

	public void setActive(String isActive) {
		this.isActive = isActive;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Pension [EmployeeContribution=" + EmployeeContribution + ", EmployerContribution="
				+ EmployerContribution + ", AvcOneOff=" + AvcOneOff + ", AvcMonthly=" + AvcMonthly + ", isActive="
				+ isActive + "]";
	}
	
	

}
