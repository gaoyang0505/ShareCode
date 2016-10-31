package com.gaoyang.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gaoyang.dao.UserDAO;
import com.gaoyang.pojo.HouseType;
import com.gaoyang.pojo.User;




@Controller
public class AdminInitiController {
	
	@Autowired
	@Qualifier("userDAO")
	UserDAO userDAO;

	@RequestMapping(value = "/admin/home.htm", method = RequestMethod.GET)
	protected String accessJudgeFunction(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(false);
		if (session == null) {
			return "admin/home";
		} else if (session.getAttribute("user") == null) {
			return "admin/home";
		} else {
			String user = (String) session.getAttribute("user");
			String uri = request.getRequestURI();
			String role = userDAO.getSpecificUser(user).getRoleType();
			if (uri.startsWith("admin") && role.equals("Admin")) {
				return "admin/control";
			} else {
				return "admin/home";
			}
		}
	}

	@RequestMapping(value = "/admin/home.htm", method = RequestMethod.POST)
	protected ModelAndView adminLoginFunction(HttpServletRequest request, HttpServletResponse response) {
		String userEMail = request.getParameter("adminEMail");
		String userPassword = request.getParameter("adminPassword");
		User user = new User();
		user = userDAO.checkUserAccess(userEMail, userPassword);
		System.out.println("wertyui");
		System.out.println("wertyui"+user);
		if (user != null) {
			if (user.getRoleType().equals("Admin")) {
				HttpSession session = request.getSession();
				session.setAttribute("user", user.getUserEMail());
				return new ModelAndView("admin/control");
			}
		}	
		return new ModelAndView("admin/home","error","Double-Check Your Username and Password.");
	}
	
	@RequestMapping(value = "/admin/top_nav.htm", method = RequestMethod.GET)
	protected String iniTopMenu() {
		return "admin/top_nav";
	}
	
	@RequestMapping(value = "/admin/menu_agent.htm", method = RequestMethod.GET)
	protected String iniLeftMenu() {
		return "admin/menu_agent";
	}
	
	@RequestMapping(value = "/admin/content.htm", method = RequestMethod.GET)
	protected String iniContent() {
		return "admin/content";
	}
	
	@RequestMapping(value = "/admin/menu_house.htm", method = RequestMethod.GET)
	protected String iniHouseMenu() {
		return "admin/menu_house";
	}
	
	@RequestMapping(value = "/admin/createHouseType.htm", method = RequestMethod.GET)
	protected String iniHouseType(@ModelAttribute("houseType") HouseType houseType) {
		return "admin/createHouseType";
	}
	
	@RequestMapping(value = "/admin/menu_account.htm", method = RequestMethod.GET)
	protected String iniAccountType() {
		return "admin/menu_account";
	}

}
