package com.jbk.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.jbk.entity.Employee;
import com.jbk.service.EmployeeServiceIF;

@RestController
@EnableAutoConfiguration(exclude = HibernateJpaAutoConfiguration.class)

public class EmployeeController {

	@Autowired
	private EmployeeServiceIF service_i;


	@PostMapping(value = "/save")
	public ResponseEntity<Serializable> addEmployee(@RequestBody Employee employee){
		Serializable id=	service_i.addEmployee(employee);

		if(id!=null) {
			return new ResponseEntity<Serializable> (id,HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<Serializable> (HttpStatus.FORBIDDEN);

		}

	}

	@GetMapping(value = "/get/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("id") int id){

		Employee employee=	service_i.getEmployee(id);

		if(employee!=null) {
			return new ResponseEntity<Employee> (employee,HttpStatus.FOUND);
		}
		else {
			return new ResponseEntity<Employee> (HttpStatus.NOT_FOUND);

		}
	}

	/*@GetMapping(value = "/getAllEmployee")
	public ResponseEntity<List<Employee>> getAllEmployee( List<Employee> employee)
	{
		employee = service_i.getAllEMployee();

		if(employee.isEmpty()) {
			return new ResponseEntity<List<Employee>> (HttpStatus.FOUND);
		}
		else {
			return new ResponseEntity<List<Employee>> (HttpStatus.NOT_FOUND);
		}


	}*/
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") int id){

		boolean result=	service_i.deleteEmployee(id);

		if(result == true) {
			return new ResponseEntity<Employee> (HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Employee> (HttpStatus.NOT_FOUND);

		}
	}
	

}
