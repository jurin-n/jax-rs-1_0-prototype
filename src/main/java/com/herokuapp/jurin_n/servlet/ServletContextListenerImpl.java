package com.herokuapp.jurin_n.servlet;


import java.net.URI;
import java.net.URISyntaxException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.commons.dbcp2.BasicDataSource;

@WebListener
public class ServletContextListenerImpl implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void contextInitialized(ServletContextEvent contextEvent) {
		System.out.println("contextInitialized start");

		/*
		  * コネクションプール作成
		  * */
		//[database type]://[username]:[password]@[host]:[port]/[database name]
		URI dbUri=null;
		try {
			dbUri = new URI(System.getenv("DATABASE_URL"));
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + dbUri.getPath();
		BasicDataSource connectionPool = new BasicDataSource();

		if (dbUri.getUserInfo() != null) {
			System.out.println("db user & password setting.");
		    connectionPool.setUsername(dbUri.getUserInfo().split(":")[0]);
		    connectionPool.setPassword(dbUri.getUserInfo().split(":")[1]);
		}
		connectionPool.setDriverClassName("org.postgresql.Driver");
		connectionPool.setUrl(dbUrl);
		connectionPool.setInitialSize(5);
		
		ServletContext context = contextEvent.getServletContext();
		context.setAttribute("db-source",connectionPool);
		System.out.println("contextInitialized end");
	}
}
