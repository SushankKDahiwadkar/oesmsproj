package com.psl.vms.model;

/**
 * 
 */


/**
 * @author sushank_dahiwadkar
 *
 */
public class VisitorAddress {
	private String city;

	public VisitorAddress() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VisitorAddress(String city) {
		super();
		this.city = city;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "VisitorAddress [city=" + city + "]";
	}
	
	
}
