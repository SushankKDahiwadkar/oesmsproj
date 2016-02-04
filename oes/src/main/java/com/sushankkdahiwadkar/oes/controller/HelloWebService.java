/**
 * 
 */
package com.sushankkdahiwadkar.oes.controller;

import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

/**
 * @author SushankKDahiwadkar
 *
 */

@Path("/hello")
public class HelloWebService {

	@GET
	@Path("/{param}")
	public Response sayHello(@PathParam("param") String name) throws UnknownHostException {

		MongoClient mongo = new MongoClient(new MongoClientURI("mongodb://test:test@ds051575.mongolab.com:51575/oes"));
		DB db = mongo.getDB("oes");

		DBCollection table = db.getCollection("sample");
		System.out.println(table.getName());
		BasicDBObject document = new BasicDBObject();
		document.put("sample", "sample");
		table.insert(document);
		return Response.status(200).entity("Hello " + name).build();
	}

	@GET
	@Path("/mysql")
	public Response mySQL() throws UnknownHostException, SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");  
		Connection connection = DriverManager.getConnection("jdbc:mysql://sql6.freemysqlhosting.net:3306/sql6104884","sql6104884"
				,"azWW6Hkjdt");
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery("select * from UserDetails");
		while(rs.next()){
			System.out.println(rs.getString(1));
		}
		connection.close();
		return Response.status(200).entity("Hello ").build();
	}

}
