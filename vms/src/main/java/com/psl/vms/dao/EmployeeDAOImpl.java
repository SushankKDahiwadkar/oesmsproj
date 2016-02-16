package com.psl.vms.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.psl.vms.model.Employee;

@Repository(value = "Employee")
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private MongoTemplate mongoTemplate;

	private static final String EMPLOYEE_COLLECTION = "Employee";

	public void createEmployee(Employee employee) {
		// TODO Auto-generated method stub
		this.mongoTemplate.insert(employee, EMPLOYEE_COLLECTION);
	}

	public Employee readById(String id) {
		// TODO Auto-generated method stub
		Query query = new Query(Criteria.where("_id").is(id));
		return this.mongoTemplate.findOne(query, Employee.class, EMPLOYEE_COLLECTION);
	}

	public List<Employee> readEmployees() {
		return this.mongoTemplate.findAll(Employee.class, EMPLOYEE_COLLECTION);
	}

}
