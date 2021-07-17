package com.jbk.dao;

import java.io.Serializable;
import java.util.List;

import com.jbk.entity.Employee;

public interface EmployeeDaoIF {
	public Serializable addEmployee(Employee employee);
	public Employee getEmployee(int id);
	public List<Employee> getAllEmployee();
	public boolean deleteEmployee(int id);
	public boolean updateEmployee(Employee employee);
}
