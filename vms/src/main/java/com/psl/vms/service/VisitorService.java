/**
 * 
 */
package com.psl.vms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psl.vms.dao.VisitorDAO;
import com.psl.vms.model.Visitor;

/**
 * @author sushank_dahiwadkar
 *
 */

@Service
public class VisitorService {

	@Autowired
	VisitorDAO visitorDAO;

	public Visitor createVisitor(Visitor visitor) {
		return visitorDAO.createVisitor(visitor);
	}

	public Visitor readVisitorById(String visitorId) {
		Visitor visitor = visitorDAO.getVisitorById(visitorId);
		return visitor;
	}

	public List<Visitor> readVisitorsByLocation(String location) {
		return visitorDAO.getVisitorsByLocations(location);
	}

	public List<Visitor> readVisitors() {
		return visitorDAO.getVisitors();
	}

	public List<Visitor> readVisitorsByLocationandDate(String location, String date) {
		return visitorDAO.getVisitorsByLocationandDate(location, date);
	}

	public List<Visitor> readVisitorsByDate(String date) {
		return visitorDAO.getVisitorByDate(date);
	}

	public Visitor removeVisitorById(String visitorId) {
		return visitorDAO.removeVisitorById(visitorId);
	}

	public Visitor editVisitor(Visitor visitor) {
		return visitorDAO.editVisitor(visitor);
	}
}
