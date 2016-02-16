package com.psl.vms.dao;

import java.util.List;

import com.psl.vms.model.Employee;

public interface EmployeeDAO {
	public void createEmployee(Employee employee);

	public Employee readById(String id);

	public List<Employee> readEmployees();
}
