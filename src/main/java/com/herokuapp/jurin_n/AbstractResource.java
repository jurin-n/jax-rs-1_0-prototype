package com.herokuapp.jurin_n;

import javax.annotation.PreDestroy;
import javax.servlet.ServletContext;
import javax.sql.DataSource;
import javax.ws.rs.core.Context;
import javax.annotation.PostConstruct;

public abstract class AbstractResource {
	private DataSource ds;
	
	/*
	@Context
	private void setDataSource(ServletContext context){
		System.out.println("*** AbstractDataAccess setDataSource ***");
		this.ds = (DataSource)context.getAttribute("db-source");
	}
	*/
	@Context
	ServletContext context;
	
	public DataSource getDs() {
		return ds;
	}
	
	@PostConstruct
	public void init(){
		System.out.println("*** AbstractDataAccess init ***");
		this.ds = (DataSource)context.getAttribute("db-source");
	}

	@PreDestroy
	public void destory(){
		System.out.println("*** AbstractDataAccess destory ***");
	}

	
}
