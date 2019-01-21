package com.web.filters;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class RequestFilters implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		Enumeration<String> names = request.getParameterNames();
		while(names.hasMoreElements()) {
			String eleName = names.nextElement();
			String eleValue = request.getParameter(eleName);
			eleValue = new String(eleValue.getBytes(),"UTF-8");
			request.setAttribute(eleName, eleValue);
		}
		HttpServletResponse httpResponse = (HttpServletResponse)response;
		httpResponse.setHeader("Access-Control-Allow-Origin", "*");
		httpResponse.setContentType("text/html;charset=utf-8");
		chain.doFilter(request, httpResponse);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}


}
