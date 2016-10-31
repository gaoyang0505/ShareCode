package com.gaoyang.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gaoyang.dao.AgentDAO;
import com.gaoyang.dao.HouseDAO;
import com.gaoyang.dao.UserDAO;
import com.gaoyang.pojo.House;
import com.gaoyang.pojo.UAgent;
import com.gaoyang.pojo.User;

@Controller
public class HouseDetailController {
	@Autowired
	@Qualifier("userDAO")
	UserDAO userDAO;
	
	@Autowired
	@Qualifier("houseDAO")
	HouseDAO houseDAO;
	
	@RequestMapping(value = "/houseDetail.htm", method = RequestMethod.GET)
	public String initializeIndex(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		String houseID = request.getParameter("houseInfor");
		House houseIns = new House();
		houseIns = houseDAO.getHouseByID(houseID);
		request.setAttribute("houseDetail", houseIns);
		if(session!=null && session.getAttribute("user")!=null){
			User user = userDAO.getSpecificUser(session.getAttribute("user").toString());
			user.setUserPassword("*");
			request.setAttribute("user", user);
		}
		return "houseDetail";
	}

}
