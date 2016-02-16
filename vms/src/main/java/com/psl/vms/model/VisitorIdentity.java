package com.psl.vms.model;

/**
 * 
 */


/**
 * @author sushank_dahiwadkar
 *
 */
public class VisitorIdentity {
	private String identityNumber;
	private String identityName;
	public VisitorIdentity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VisitorIdentity(String identityNumber, String identityName) {
		super();
		this.identityNumber = identityNumber;
		this.identityName = identityName;
	}
	public String getIdentityNumber() {
		return identityNumber;
	}
	public void setIdentityNumber(String identityNumber) {
		this.identityNumber = identityNumber;
	}
	public String getIdentityName() {
		return identityName;
	}
	public void setIdentityName(String identityName) {
		this.identityName = identityName;
	}
	@Override
	public String toString() {
		return "VisitorIdentity [identityNumber=" + identityNumber + ", identityName=" + identityName + "]";
	}
	
}
