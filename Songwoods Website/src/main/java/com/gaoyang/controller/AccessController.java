package com.gaoyang.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.gaoyang.dao.ClientDAO;
import com.gaoyang.dao.UserDAO;
import com.gaoyang.pojo.UClient;
import com.gaoyang.pojo.User;

@Controller
public class AccessController {

	// Validator Here
	
	@Autowired
	@Qualifier("userValidator")
	ValidatorSignUser validator;

	@Autowired
	@Qualifier("userDAO")
	UserDAO userDAO;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}


	//// Using AJAX to Complete Log In
	@RequestMapping(value = "/index.htm", method = RequestMethod.POST)
	protected String accessJudgeFunction(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String action = request.getParameter("action");
		User user = new User();
		HttpSession session = request.getSession();
		if (action.equals("submit")) {
			String userEMail = (String) request.getParameter("userEMail");
			String userPassword = (String) request.getParameter("userPassword");
			user = userDAO.checkUserAccess(userEMail, userPassword);
			String access = "false";
			JSONObject obj = new JSONObject();
			if (user != null && !user.getRoleType().equals("Admin") && user.getUserStatus().equals("Active")) {
				access = "true";
				session.setAttribute("user", user.getUserEMail());
				session.setAttribute("userID", user.getUserID());
				session.setAttribute("userRole", user.getRoleType());
				session.setAttribute("userFirst", user.getUserFirstName());
				obj.put("userFirstName", user.getUserFirstName());
				obj.put("access", access);
				obj.put("role", user.getRoleType());
				obj.put("error", "Double-Check Your U&P.");
			} else {
				obj.put("access", access);
				obj.put("error", "Double-Check Your U&P.");
			}
			PrintWriter out = response.getWriter();
			out.println(obj);
		}
		return null;
	}

	@RequestMapping(value = "/signup.htm", method = RequestMethod.POST)
	protected String registerMethod(@ModelAttribute("client") UClient client, BindingResult result,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		validator.validate(client, result);
		if (result.hasErrors()) {
			return "signup";
		}

		String action = request.getParameter("action");
		if (action != null && action.equals("check")) {
			String emailString = request.getParameter("userEMail");
			boolean userUnique = false;
			userUnique = userDAO.checkUnique(emailString);
			JSONObject obj = new JSONObject();
			if (userUnique) {
				obj.put("userOnly", "true");
			} else {
				obj.put("userOnly", "false");
			}
			PrintWriter out = response.getWriter();
			out.println(obj);
			return null;
		}

		if (action == null) {
			ClientDAO clientDAO = new ClientDAO();
			clientDAO.create(client.getUserPassword(), client.getUserEMail(), client.getUserFirstName(),
					client.getUserFirstName());
			HttpSession session = request.getSession();
			User user = new User();
			user = userDAO.getSpecificUser(client.getUserEMail());

			session.setAttribute("user", user.getUserEMail());
			session.setAttribute("userID", user.getUserID());
			session.setAttribute("userRole", user.getRoleType());
			session.setAttribute("userFirst", user.getUserFirstName());
			return "success";
		}

		return null;
	}

	@RequestMapping(value = "/signup.htm", method = RequestMethod.GET)
	public String returnSignup(@ModelAttribute("client") UClient client) {
		return "signup";
	}

	@RequestMapping(value = "/index.htm", method = RequestMethod.GET)
	public String initializeIndex(HttpServletRequest request) {

		String ipaddress = request.getRemoteAddr();
		System.out.println(ipaddress);

		HttpSession session = request.getSession(false);
		if (session.getAttribute("user") != null) {
			String user = (String) session.getAttribute("user");
			User userTest = userDAO.getSpecificUser(user);
			userTest.setUserPassword("*");
			request.setAttribute("userInfor", userTest);
			if (userTest.getRoleType().equals("Admin"))
				return "admin/control";
		}
		return "index";
	}

	@RequestMapping(value = "/logout.htm", method = RequestMethod.GET)
	public String logoutMethod(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "index";
	}

	@RequestMapping(value = "/admin/adminlogout.htm", method = RequestMethod.GET)
	protected String process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.getSession().invalidate();
			return "admin/home";
	}
}
