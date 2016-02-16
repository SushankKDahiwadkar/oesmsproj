/**
 * 
 */
package com.psl.vms.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.psl.vms.model.Visitor;

/**
 * @author sushank_dahiwadkar
 *
 */
@Repository(value = "Visitor")
public class VisitorDAOImpl implements VisitorDAO {

	@Autowired
	private MongoTemplate mongoTemplate;

	private static final String VISITOR_COLLECTION = "Visitor";

	public Visitor createVisitor(Visitor visitor) {
		this.mongoTemplate.insert(visitor, VISITOR_COLLECTION);
		return visitor;
	}

	public Visitor getVisitorById(String visitorId) {
		Query query = new Query(Criteria.where("_id").is(visitorId));
		return this.mongoTemplate.findOne(query, Visitor.class, VISITOR_COLLECTION);
	}

	public List<Visitor> getVisitorsByLocations(String location) {
		Query query = new Query(Criteria.where("vistingLocation").is(location));
		return this.mongoTemplate.find(query, Visitor.class, VISITOR_COLLECTION);
	}

	public List<Visitor> getVisitors() {
		// Query query = new Query(new Query());
		return this.mongoTemplate.findAll(Visitor.class, VISITOR_COLLECTION);
	}

	public List<Visitor> getVisitorsByLocationandDate(String location, String date) {
		Query query = new Query(Criteria.where("vistingLocation").is(location).andOperator(Criteria.where("visitingDate").is(date)));
		return this.mongoTemplate.find(query, Visitor.class, VISITOR_COLLECTION);
	}

	public List<Visitor> getVisitorByDate(String date) {
		Query query = new Query(Criteria.where("visitingDate").is(date));
		return this.mongoTemplate.find(query, Visitor.class, VISITOR_COLLECTION);
	}

	public Visitor removeVisitorById(String visitorId) {
		Query query = new Query(Criteria.where("_id").is(visitorId));
		return this.mongoTemplate.findAndRemove(query, Visitor.class, VISITOR_COLLECTION);
	}

	public Visitor editVisitor(Visitor visitor) {
		System.out.println(visitor.getId());
		Query query = new Query(Criteria.where("_id").is(visitor.getId()));
		Update update = new Update();
		update.set("firstName", visitor.getFirstName());
		update.set("lastName", visitor.getLastName());
		update.set("mobileNumber", visitor.getMobileNumber());
		update.set("visitingDate", visitor.getVisitingDate());
		update.set("purpose", visitor.getPurpose());
		update.set("representing", visitor.getRepresenting());
		update.set("visitorType", visitor.getVisitorType());
		update.set("vistingLocation", visitor.getVistingLocation());
		update.set("inTime", visitor.getInTime());
		update.set("outTime", visitor.getOutTime());
		System.out.println(visitor.toString());
		System.out.println(update.toString());
		Visitor v = this.mongoTemplate.findAndModify(query, update, new FindAndModifyOptions().returnNew(true), Visitor.class, VISITOR_COLLECTION);
		return v;
	}


}
