package com.gaoyang.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.gaoyang.dao.UserDAO;
import com.gaoyang.pojo.UAgent;
import com.gaoyang.pojo.User;

public class AgentInterceptor extends HandlerInterceptorAdapter{
	@Autowired
	@Qualifier("userDAO")
	UserDAO userDAO;
	
	@Override
    public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {
		
		String userName = (String) request.getSession().getAttribute("user");
		if(userName == null) {
			 ModelAndView mav = new ModelAndView("index");
	         throw new ModelAndViewDefiningException(mav);
		} else {
			User user = userDAO.getSpecificUser(userName);
			if(!(user instanceof UAgent)) {
				ModelAndView mav = new ModelAndView("index");
		        throw new ModelAndViewDefiningException(mav);
			}
		}
		
		return true;
	}
}
