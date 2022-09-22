package com.cts.jfd;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

import com.cts.jfd.model.Employee;

public class App09FunctionalPackageDemo {

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

		for(Employee e : emps)
			System.out.println(e);
		System.out.println("----------------------------------------------------------------------------");
	
		List<Employee> janJoinedEmps = filter(emps, e -> (e.getJoinDate().getMonth()==Month.JANUARY));
		for(Employee e : janJoinedEmps)
			System.out.println(e);
		System.out.println("----------------------------------------------------------------------------");
	
		List<Employee> empsEarningLessThan50k = filter(emps, e -> (e.getSalary()<=50000));
		for(Employee e : empsEarningLessThan50k)
			System.out.println(e);
		System.out.println("----------------------------------------------------------------------------");	
		
	}

	public static List<Employee> filter(List<Employee> emps,Predicate<Employee> criteria){
		List<Employee> result = new ArrayList<Employee>();
		
		for(Employee e :  emps) {
			if(criteria.test(e)) {
				result.add(e);
			}
		}
		
		return result;
	}
}
