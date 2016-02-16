/**
 * 
 */
package com.psl.vms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psl.vms.dao.EmployeeDAO;
import com.psl.vms.model.Employee;

/**
 * @author sushank_dahiwadkar
 *
 */

@Service
public class EmployeeService {

	@Autowired
	EmployeeDAO employeeDAO;

	public void createEmployee(Employee employee) {
		employeeDAO.createEmployee(employee);
	}

	public Employee readEmployeeById(String employeeId) {
		return employeeDAO.readById(employeeId);
	}

	public List<Employee> readEmployees() {
		List<Employee> employees = employeeDAO.readEmployees();
		return employees;
	}
}
