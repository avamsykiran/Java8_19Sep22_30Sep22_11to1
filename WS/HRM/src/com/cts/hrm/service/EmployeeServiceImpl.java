package com.cts.hrm.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.cts.hrm.dao.EmployeeDao;
import com.cts.hrm.dao.EmployeeDaoIOStreamsImpl;
import com.cts.hrm.exception.DuplicateEmployeeIdException;
import com.cts.hrm.exception.EmployeeNotFoundException;
import com.cts.hrm.exception.InvalidEmployeeException;
import com.cts.hrm.exception.OperationFailedException;
import com.cts.hrm.model.Employee;

public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDao empDao;
	
	public EmployeeServiceImpl() throws OperationFailedException {
		this.empDao=new EmployeeDaoIOStreamsImpl();
	}
	
	private void validate(Employee emp) throws InvalidEmployeeException {
		List<String> errors = new ArrayList<String>();
		
		if(emp==null) {
			throw new InvalidEmployeeException("Employee data not received");
		}
		
		if(emp.getEmpId()<=0) {
			errors.add("Employee Id can not be negative or zero");
		}
		
		if(emp.getFullName()==null || emp.getFullName().isEmpty() ) {
			errors.add("Full Name is a manditory field");
		}
		
		if(emp.getSalary()<=0) {
			errors.add("Salary is not expected to be zero or negative");
		}
		
		if(emp.getJoinDate()==null || emp.getJoinDate().isAfter(LocalDate.now())) {
			errors.add("Join Date is mandate and is expected to be present or past date");
		}
		
		if(!errors.isEmpty()) {
			throw new InvalidEmployeeException(errors.toString());
		}
	}
	
	@Override
	public Employee addEmployee(Employee employee)
			throws DuplicateEmployeeIdException, OperationFailedException, InvalidEmployeeException {
		validate(employee);
		return empDao.addEmployee(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee)
			throws EmployeeNotFoundException, OperationFailedException, InvalidEmployeeException {
		validate(employee);
		return empDao.updateEmployee(employee);
	}

	@Override
	public List<Employee> getAllEmployees() throws OperationFailedException {
		return empDao.getAllEmployees();
	}

	@Override
	public Employee getEmployeeById(int empId) throws EmployeeNotFoundException, OperationFailedException {
		return empDao.getEmployeeById(empId);
	}

	@Override
	public void deleteEmployeeById(int empId) throws EmployeeNotFoundException, OperationFailedException {
		empDao.deleteEmployeeById(empId);		
	}

}
