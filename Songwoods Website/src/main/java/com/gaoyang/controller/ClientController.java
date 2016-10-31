package com.gaoyang.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gaoyang.dao.ClientDAO;
import com.gaoyang.dao.HouseDAO;
import com.gaoyang.dao.UserDAO;
import com.gaoyang.pojo.House;
import com.gaoyang.pojo.UClient;
import com.gaoyang.pojo.User;

@Controller
public class ClientController {
	@Autowired
	@Qualifier("userDAO")
	UserDAO userDAO;
	
	@Autowired
	@Qualifier("clientDAO")
	ClientDAO clientDAO;
	
	@Autowired
	@Qualifier("houseDAO")
	HouseDAO houseDAO;
	
	
	@RequestMapping(value = "/myAccount.htm", method = RequestMethod.GET)
	protected String accountIn(HttpServletRequest request){
		String email = request.getSession().getAttribute("user").toString();
		User user = new User();
		user = userDAO.getSpecificUser(email);
		request.setAttribute("user", user);
		return "myAccount";

	}
	
	
	@RequestMapping(value = "/favoHose.htm", method = RequestMethod.GET)
	protected String favIni(HttpServletRequest request){
		List<House> houseList = new ArrayList<House>();
		UClient client = clientDAO.getClientByEmail(request.getSession().getAttribute("user").toString());
		
		houseList = houseDAO.getFavoriteList(client);
		request.setAttribute("houseList", houseList);
		return "myFavo";

	}
	
	@RequestMapping(value = "/changeP.htm", method = RequestMethod.POST)
	protected String changeP(HttpServletRequest request){
		String old = request.getParameter("oldP");
		String newOne = request.getParameter("newP");
		String confi = request.getParameter("comP");
		String email = request.getSession().getAttribute("user").toString();
		User user = new User();
		user = userDAO.getSpecificUser(email);
		
		if(user.getUserPassword().equals(old) && newOne.equals(old) && newOne.equals(confi)){
			userDAO.updateUserP(user,newOne);
		}
		
		return "index.htm";
	}
}
