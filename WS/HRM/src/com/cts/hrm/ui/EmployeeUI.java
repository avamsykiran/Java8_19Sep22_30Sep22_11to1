package com.cts.hrm.ui;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.cts.hrm.exception.DuplicateEmployeeIdException;
import com.cts.hrm.exception.EmployeeNotFoundException;
import com.cts.hrm.exception.InvalidEmployeeException;
import com.cts.hrm.exception.OperationFailedException;
import com.cts.hrm.model.Employee;
import com.cts.hrm.service.EmployeeService;
import com.cts.hrm.service.EmployeeServiceImpl;

public class EmployeeUI {

	private EmployeeService empService;
	private Scanner kbin;

	public void run() {

		kbin = new Scanner(System.in);
		try {
			this.empService = new EmployeeServiceImpl();
		} catch (OperationFailedException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}

		Menu menu = null;
		Menu[] menuOptions = Menu.values();

		while (menu != Menu.QUIT) {
			Arrays.stream(menuOptions).forEach(m -> {
				System.out.println((m.ordinal() + 1) + "\t" + m);
			});
			System.out.print("Choice> ");
			int ch = kbin.nextInt();

			menu = menuOptions[ch - 1];

			switch (menu) {
			case LIST:
				doList();
				break;
			case ADD:
				doAdd();
				break;
			case DELETE:
				doDelete();
				break;
			case SEARCH:
				doSearch();
				break;
			case QUIT:
				System.out.println("OK! BYE!");
				break;
			}
		}
	}

	private void doSearch() {
		System.out.print("Employee Id: ");
		int empId =kbin.nextInt();
		
		try {
			Employee emp = empService.getEmployeeById(empId);
			System.out.println(emp);
		} catch (EmployeeNotFoundException | OperationFailedException e) {
			System.out.println("No Such Employee Found");
		}
		
	}

	private void doDelete() {
		System.out.print("Employee Id: ");
		int empId =kbin.nextInt();
		
		try {
			empService.deleteEmployeeById(empId);
			System.out.println("Record deleted");
		} catch (EmployeeNotFoundException | OperationFailedException e) {
			System.out.println("No Such Employee Found");
		}
	}

	private void doAdd() {
		
		Employee emp = new Employee();
		
		System.out.print("Employee Id: ");
		emp.setEmpId(kbin.nextInt());
		System.out.print("Name: ");
		emp.setFullName(kbin.next());
		System.out.print("Salary: ");
		emp.setSalary(kbin.nextDouble());
		System.out.print("Join Date (yyyy-MM-dd): ");
		emp.setJoinDate(LocalDate.parse(kbin.next()));
		
		try {
			empService.addEmployee(emp);
			System.out.println("Employee Record Saved!");
		} catch (DuplicateEmployeeIdException | OperationFailedException | InvalidEmployeeException e) {
			System.out.print(e.getMessage());
		}
	}

	private void doList() {
		try {
			empService.getAllEmployees().stream().forEach(System.out::println);
		} catch (OperationFailedException e) {
			System.out.print(e.getMessage());
		}
	}
}
