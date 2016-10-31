package com.gaoyang.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class Inputfilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		PrintWriter out = arg1.getWriter();
        HttpServletRequest request1 = new ChangeRequest((HttpServletRequest) arg0);
        arg2.doFilter(request1, arg1);
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
	private static class ChangeRequest extends HttpServletRequestWrapper {

        public ChangeRequest(HttpServletRequest request) {
            super(request);
        }


        public String[] getParameterValues(String paramName) {
            String values[] = super.getParameterValues(paramName);
            for (int index = 0; index < values.length; index++) {
                values[index] = values[index].replaceAll("[^\\dA-Za-z@. ]", "");
            }
            return values;
        }
    }

}
