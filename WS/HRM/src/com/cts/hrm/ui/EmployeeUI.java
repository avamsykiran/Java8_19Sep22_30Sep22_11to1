package com.cts.hrm.ui;

import com.cts.hrm.exception.OperationFailedException;
import com.cts.hrm.service.EmployeeService;
import com.cts.hrm.service.EmployeeServiceImpl;

public class EmployeeUI {

	private EmployeeService empService;
	
	public void run() {
		try {
			this.empService = new EmployeeServiceImpl();
		} catch (OperationFailedException e) {
			System.out.println(e.getMessage());
		}
	}
}
