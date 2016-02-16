/**
 * 
 */
package com.psl.vms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.psl.vms.model.Employee;
import com.psl.vms.service.EmployeeService;

/**
 * @author sushank_dahiwadkar
 *
 */

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> createEmployee(@RequestBody Employee employee) {
		employeeService.createEmployee(employee);
		System.out.println("id" + employee.getEmpId());
		return new ResponseEntity<Object>(employee, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{employeeId}", method = RequestMethod.GET)
	public Employee readEmployeeById(@PathVariable("employeeId") String employeeId) {
		Employee employee = employeeService.readEmployeeById(employeeId);
		System.out.println(employee);
		return employee;

	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Employee> readEmployees() {
		List<Employee> employee = employeeService.readEmployees();
		System.out.println(employee);
		return employee;

	}
}
