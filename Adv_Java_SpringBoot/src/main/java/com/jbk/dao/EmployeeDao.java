package com.jbk.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.entity.Employee;

@Repository
public class EmployeeDao implements EmployeeDaoIF {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Serializable addEmployee(Employee employee) {

		Session session = sessionFactory.getCurrentSession();
		Serializable id = session.save(employee);

		return id;
	}

	@Override
	public Employee getEmployee(int id) {

		Session session = sessionFactory.getCurrentSession();
		Employee employee=session.get(Employee.class, id);

		return employee;
	}

	@Override
	public List<Employee> getAllEmployee() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Employee";

		Query<Employee> query = session.createQuery(hql);
		List<Employee> employeeList = query.list();  

		return employeeList;
	}

	@Override
	@SuppressWarnings("rawtypes")
	public boolean deleteEmployee(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("delete Employee where id = :ID");
		query.setInteger("ID", id);

		int result = query.executeUpdate();

		if (result > 0) {
			System.out.println("Expensive products was removed");
			return true;
		}
		else
			return false;
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return false;
	}

}
