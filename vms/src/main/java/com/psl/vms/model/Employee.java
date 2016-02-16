package com.psl.vms.model;

import org.springframework.data.annotation.Id;

/**
 * @author sushank_dahiwadkar
 *
 */

public class Employee {
	@Id
	private String empId;
	private String firstName;
	private String lastName;
	private String location;
	public Employee(String empId, String firstName, String lastName, String location) {
		super();
		this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.location = location;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	
}
