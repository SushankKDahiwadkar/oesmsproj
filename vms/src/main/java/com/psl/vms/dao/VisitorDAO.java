package com.psl.vms.dao;

import java.util.List;

import com.psl.vms.model.Visitor;

public interface VisitorDAO {
	/**
	 * creates the visitor
	 * @param visitor
	 * @return 
	 */
	public Visitor createVisitor(Visitor visitor);
	
	/**
	 * return single viitor By Id
	 * @param visitorId
	 * @return
	 */
	public Visitor getVisitorById(String visitorId);
	
	/**
	 * returns visitor by location
	 * @param location
	 * @return
	 */
	public List<Visitor> getVisitorsByLocations(String location);
	
	/**
	 * get all visitors
	 * @return
	 */
	public List<Visitor> getVisitors();

	public List<Visitor> getVisitorsByLocationandDate(String location, String date);

	public List<Visitor> getVisitorByDate(String date);

	public Visitor removeVisitorById(String visitorId);

	public Visitor editVisitor(Visitor visitor);
}
