package com.cts.hrm.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.cts.hrm.exception.DuplicateEmployeeIdException;
import com.cts.hrm.exception.EmployeeNotFoundException;
import com.cts.hrm.exception.OperationFailedException;
import com.cts.hrm.model.Employee;

public class EmployeeDaoIOStreamsImpl implements EmployeeDao {

	public static final String FILE_PATH = "./emps.dat";

	private Map<Integer, Employee> data;

	public EmployeeDaoIOStreamsImpl() throws OperationFailedException {
		this.data = readData();
	}

	private Map<Integer, Employee> readData() throws OperationFailedException {
		Map<Integer, Employee> data = null;

		try (ObjectInputStream oin = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
			data = (Map<Integer, Employee>) oin.readObject();
		} catch (FileNotFoundException e) {
			data = new TreeMap<Integer, Employee>();
		} catch (IOException | ClassNotFoundException e) {
			// log the actual exception
			throw new OperationFailedException(e.getMessage());
		}

		return data;
	}

	private void saveData() throws OperationFailedException {

		try (ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
			oout.writeObject(data);
		} catch (IOException e) {
			// log the actual exception
			throw new OperationFailedException(e.getMessage());
		}

	}

	@Override
	public Employee addEmployee(Employee employee) throws DuplicateEmployeeIdException, OperationFailedException {
		if(data.containsKey(employee.getEmpId())) {
			throw new DuplicateEmployeeIdException();
		}
		
		data.put(employee.getEmpId(),employee);
		saveData();
		return employee;
	}

	@Override
	public Employee updateEmployee(Employee employee) throws EmployeeNotFoundException, OperationFailedException {
		if(!data.containsKey(employee.getEmpId())) {
			throw new EmployeeNotFoundException();
		}
		
		data.replace(employee.getEmpId(),employee);
		saveData();
		return employee;
	}

	@Override
	public List<Employee> getAllEmployees() throws OperationFailedException {
		return new ArrayList<>(data.values());
	}

	@Override
	public Employee getEmployeeById(int empId) throws EmployeeNotFoundException, OperationFailedException {
		if(!data.containsKey(empId)) {
			throw new EmployeeNotFoundException();
		}
		return data.get(empId);
	}

	@Override
	public void deleteEmployeeById(int empId) throws EmployeeNotFoundException, OperationFailedException {
		if(!data.containsKey(empId)) {
			throw new EmployeeNotFoundException();
		}
		data.remove(empId);
		saveData();
	}

}
