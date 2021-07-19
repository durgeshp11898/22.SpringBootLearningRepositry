package com.jbk.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jbk.dao.EmployeeDaoIF;
import com.jbk.entity.Employee;

@Service
@Transactional
public class EmployeeService implements EmployeeServiceIF {

	@Autowired
	private EmployeeDaoIF dao;

	@Override
	public Serializable addEmployee(Employee employee) {
		Serializable id = dao.addEmployee(employee);
		return id;
	}

	@Override
	public Employee getEmployee(int id) {
		Employee employee = dao.getEmployee(id);
		return employee;
	}

	@Override
	public List<Employee> getAllEMployee() {
		List<Employee> employee = dao.getAllEmployee();
		return employee;
	}

	@Override
	public boolean deleteEmployee(int id) {
		boolean result = dao.deleteEmployee(id);
		if(result ==true )
			return true;
		else 
			return false;
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return false;
	}

}
