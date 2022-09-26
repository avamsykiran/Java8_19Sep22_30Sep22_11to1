package com.cts.jfd;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import com.cts.jfd.model.Employee;

public class App13Serialization {

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

		File file = new File("./data.binary");
		try (FileOutputStream fout = new FileOutputStream(file);
				ObjectOutputStream oout = new ObjectOutputStream(fout)) {
			oout.writeObject(emps);
			System.out.println("Data written to file");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
