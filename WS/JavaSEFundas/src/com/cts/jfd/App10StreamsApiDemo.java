package com.cts.jfd;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.cts.jfd.model.Employee;

public class App10StreamsApiDemo {

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
		emps.add(null);
		emps.add(new Employee(10, "Indhiraa", 55000, LocalDate.of(2022, Month.JANUARY, 1)));

		emps.stream().forEach(System.out::println);
		System.out.println("----------------------------------------------------------------------------");

		List<Employee> janJoinedEmps = 
				emps.stream()
				.filter(e -> e!=null && (e.getJoinDate().getMonth() == Month.JANUARY))
				.collect(Collectors.toList());
		janJoinedEmps.stream().forEach(System.out::println);
		System.out.println("----------------------------------------------------------------------------");

		emps.stream()
			.map( e -> e!=null?String.format("%s earns INR.%.2f per month",e.getFullName(),e.getSalary()):"")
			.forEach(System.out::println);
		System.out.println("----------------------------------------------------------------------------");

		Optional<Employee> seniorEmp = emps.stream()
				.reduce((e1,e2) -> (e1!=null && e2!=null && e1.getJoinDate().isBefore(e2.getJoinDate()))?e1:e2);
		//System.out.println(seniorEmp.isPresent()?seniorEmp.get():null);
		System.out.println(seniorEmp.orElse(null));
	}
}
