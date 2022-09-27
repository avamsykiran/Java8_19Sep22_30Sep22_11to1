package com.cts.hrm.service;

import java.util.List;

import com.cts.hrm.exception.DuplicateEmployeeIdException;
import com.cts.hrm.exception.EmployeeNotFoundException;
import com.cts.hrm.exception.InvalidEmployeeException;
import com.cts.hrm.exception.OperationFailedException;
import com.cts.hrm.model.Employee;

public interface EmployeeService {
	Employee addEmployee(Employee employee)
			throws DuplicateEmployeeIdException, OperationFailedException, InvalidEmployeeException;

	Employee updateEmployee(Employee employee)
			throws EmployeeNotFoundException, OperationFailedException, InvalidEmployeeException;

	List<Employee> getAllEmployees() throws OperationFailedException;

	Employee getEmployeeById(int empId) throws EmployeeNotFoundException, OperationFailedException;

	void deleteEmployeeById(int empId) throws EmployeeNotFoundException, OperationFailedException;
}
