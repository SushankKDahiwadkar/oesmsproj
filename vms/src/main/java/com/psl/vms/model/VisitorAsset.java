package com.psl.vms.model;

/**
 * 
 */


/**
 * @author sushank_dahiwadkar
 *
 */
public class VisitorAsset {
	private String vehicleNumber;
	private String visitorGadgets;
	private VisitorIdentity visitorIdentity;
	public VisitorAsset() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VisitorAsset(String vehicleNumber, String visitorGadgets, VisitorIdentity visitorIdentity) {
		super();
		this.vehicleNumber = vehicleNumber;
		this.visitorGadgets = visitorGadgets;
		this.visitorIdentity = visitorIdentity;
	}
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public String getVisitorGadgets() {
		return visitorGadgets;
	}
	public void setVisitorGadgets(String visitorGadgets) {
		this.visitorGadgets = visitorGadgets;
	}
	public VisitorIdentity getVisitorIdentity() {
		return visitorIdentity;
	}
	public void setVisitorIdentity(VisitorIdentity visitorIdentity) {
		this.visitorIdentity = visitorIdentity;
	}
	@Override
	public String toString() {
		return "VisitorAsset [vehicleNumber=" + vehicleNumber + ", visitorGadgets=" + visitorGadgets
				+ ", visitorIdentity=" + visitorIdentity + "]";
	}
	
	
}
