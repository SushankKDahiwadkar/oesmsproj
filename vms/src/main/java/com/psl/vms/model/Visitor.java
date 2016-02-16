package com.psl.vms.model;

import org.springframework.data.annotation.Id;

import lombok.Data;

/**
 * @author sushank_dahiwadkar
 *
 */

@Data
public class Visitor {

	@Id
	private String id;
	private String firstName;
	private String lastName;
	private String mobileNumber;
	private String visitingDate;
	private VisitorAddress visitorAddress;
	private String purpose;
	private String representing;
	private String visitorType;
	private String vistingLocation;
	private String inTime;
	private String outTime;
}
