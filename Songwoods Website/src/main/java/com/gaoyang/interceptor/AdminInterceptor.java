package com.gaoyang.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.gaoyang.dao.UserDAO;
import com.gaoyang.pojo.UAdmin;
import com.gaoyang.pojo.UAgent;
import com.gaoyang.pojo.User;

public class AdminInterceptor extends HandlerInterceptorAdapter{
	@Autowired
	@Qualifier("userDAO")
	UserDAO userDAO;
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handle, ModelAndView modelAndView) throws Exception {
		System.out.println((String) request.getSession().getAttribute("user"));
		String userName = (String) request.getSession().getAttribute("user");
		if(userName == null) {
			 ModelAndView mav = new ModelAndView("admin/home");
	         throw new ModelAndViewDefiningException(mav);
		} else {
			User user = userDAO.getSpecificUser(userName);
			if(!(user instanceof UAdmin)) {
				System.out.println("asdadasdad");
				ModelAndView mav = new ModelAndView("admin/home");
		        throw new ModelAndViewDefiningException(mav);
			}
		}
	}

}
