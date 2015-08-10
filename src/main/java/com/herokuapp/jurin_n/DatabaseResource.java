package com.herokuapp.jurin_n;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/db")
public class DatabaseResource extends AbstractResource {
	@GET
	@Path("{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getLinkedHashMap(@PathParam("id") String id){

    	/*
		 * データベース接続
		 * */
		Connection connection=null;
		try {
			connection = getDs().getConnection();
			connection.setAutoCommit(false);
			
			Statement stmt = connection.createStatement();
			stmt.executeUpdate("CREATE TABLE IF NOT EXISTS database_resource (tick timestamp)");
			stmt.executeUpdate("INSERT INTO database_resource VALUES (now())");
			ResultSet rs = stmt.executeQuery("SELECT tick FROM database_resource");
			while (rs.next()) {
				System.out.println("Read from DB: " + rs.getTimestamp("tick"));
			}
			
			connection.commit();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response
				.status(Response.Status.OK)
				.entity("db resource!")
				.build();
	}
}
