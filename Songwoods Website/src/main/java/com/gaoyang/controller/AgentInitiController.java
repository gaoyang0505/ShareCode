package com.gaoyang.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gaoyang.dao.AgentDAO;
import com.gaoyang.dao.HouseDAO;
import com.gaoyang.pojo.House;
import com.gaoyang.pojo.HouseType;
import com.gaoyang.pojo.UAgent;

@Controller
public class AgentInitiController {
	
	@Autowired
	@Qualifier("houseDAO")
	HouseDAO houseDAO;
	
	
	@RequestMapping(value = "/manage.htm", method = RequestMethod.GET)
	protected String iniAgentIndex(){
		return "agent/manage";
	}
	
	@RequestMapping(value = "/menu.htm", method = RequestMethod.GET)
	protected String iniMenu(){
		return "agent/menu";
	}
	
	@RequestMapping(value = "/content.htm", method = RequestMethod.GET)
	protected String iniContent() {
		return "agent/content";
	}
	
	@RequestMapping(value = "/createHouse.htm", method = RequestMethod.GET)
	protected String iniCreateHouse(@ModelAttribute("house")House house,HttpServletRequest request) {
		List<HouseType> houseT;
		houseT = houseDAO.getAllType();
		request.setAttribute("typeList", houseT);
		return "agent/createHouse";
	}
	
	@RequestMapping(value = "/myprofile.htm", method = RequestMethod.GET)
	protected String iniMyProfile() {
		return "agent/myProfile";
	}

}
