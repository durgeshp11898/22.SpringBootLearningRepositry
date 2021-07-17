package com.jbk.service;

import java.io.Serializable;
import java.util.List;

import com.jbk.entity.Employee;

public interface EmployeeServiceIF {

	public Serializable addEmployee(Employee employee);
	public Employee getEmployee(int id);
	public List<Employee> getAllEMployee();
	public boolean deleteEmployee(int id);
	public boolean updateEmployee(Employee employee);
	
	
	
	
}
