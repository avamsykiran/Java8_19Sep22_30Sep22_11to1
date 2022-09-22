package com.cts.jfd;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.cts.jfd.model.Employee;

public class App08LambdaExpressionsDemo {

	public static void main(String[] args) {
	
		List<Employee> emps = new ArrayList<>();
	
		emps.add(new Employee(1, "Vamsy", 45000, LocalDate.of(2021, Month.MAY, 1)));
		emps.add(new Employee(4, "Varun", 55000, LocalDate.of(2022, Month.MAY, 1)));
		emps.add(new Employee(3, "Vainay", 35000, LocalDate.of(2021, Month.JUNE, 1)));
		emps.add(new Employee(2, "Wasim", 25000, LocalDate.of(2021, Month.APRIL, 1)));
		emps.add(new Employee(5, "Sruthi", 85000, LocalDate.of(2021, Month.JANUARY, 1)));
		emps.add(new Employee(9, "Sudha", 49000, LocalDate.of(2021, Month.DECEMBER, 1)));
		emps.add(new Employee(8, "Zubeda", 47000, LocalDate.of(2021, Month.JULY, 1)));
		emps.add(new Employee(7, "Amrutha", 46000, LocalDate.of(2021, Month.OCTOBER, 1)));
		emps.add(new Employee(6, "Indhikaa", 49000, LocalDate.of(2022, Month.MAY, 1)));
		emps.add(new Employee(10, "Indhiraa", 55000, LocalDate.of(2022, Month.JANUARY, 1)));

		Collections.sort(emps);
		for(Employee e : emps)
			System.out.println(e);
		System.out.println("----------------------------------------------------------------------------");
	
		Collections.sort(emps, (e1,e2) -> (e1.getFullName().compareTo(e2.getFullName())));
		for(Employee e : emps)
			System.out.println(e);
		System.out.println("----------------------------------------------------------------------------");
	
		Collections.sort(emps, (e1,e2) -> (((Double)e1.getSalary()).compareTo(e2.getSalary())));
		for(Employee e : emps)
			System.out.println(e);
		System.out.println("----------------------------------------------------------------------------");

		Collections.sort(emps, (e1,e2) -> (e1.getJoinDate().compareTo(e2.getJoinDate())));
		for(Employee e : emps)
			System.out.println(e);
		System.out.println("----------------------------------------------------------------------------");

	}

}
