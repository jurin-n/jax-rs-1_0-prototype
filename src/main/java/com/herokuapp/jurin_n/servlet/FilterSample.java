package com.herokuapp.jurin_n.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*")
public class FilterSample implements Filter {
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		/* In ログ */
		System.out.println("Output Log start!");
	
		chain.doFilter(request, response);
		
		/* Out ログ */
		System.out.println("Output Log end!");
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
	}
}
