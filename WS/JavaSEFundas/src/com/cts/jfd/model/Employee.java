package com.cts.jfd.model;

import java.io.Serializable;
import java.time.LocalDate;

public class Employee implements Comparable<Employee>,Serializable {

	private static final long serialVersionUID = 1L;

	private int empId;
	private String fullName;
	private double salary;
	private LocalDate joinDate;
	
	public Employee() {
	}

	public Employee(int empId, String fullName, double salary, LocalDate joinDate) {
		super();
		this.empId = empId;
		this.fullName = fullName;
		this.salary = salary;
		this.joinDate = joinDate;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public LocalDate getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(LocalDate joinDate) {
		this.joinDate = joinDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + empId;
		result = prime * result + ((fullName == null) ? 0 : fullName.hashCode());
		result = prime * result + ((joinDate == null) ? 0 : joinDate.hashCode());
		long temp;
		temp = Double.doubleToLongBits(salary);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (empId != other.empId)
			return false;
		if (fullName == null) {
			if (other.fullName != null)
				return false;
		} else if (!fullName.equals(other.fullName))
			return false;
		if (joinDate == null) {
			if (other.joinDate != null)
				return false;
		} else if (!joinDate.equals(other.joinDate))
			return false;
		if (Double.doubleToLongBits(salary) != Double.doubleToLongBits(other.salary))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", fullName=" + fullName + ", salary=" + salary + ", joinDate=" + joinDate
				+ "]";
	}

	@Override
	public int compareTo(Employee o) {
		Integer empId1 = this.empId;
		Integer empId2 = o.empId;
		return empId1.compareTo(empId2);
	}
	
	
}
