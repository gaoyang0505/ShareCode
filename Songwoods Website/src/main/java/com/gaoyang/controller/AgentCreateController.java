package com.gaoyang.controller;


import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gaoyang.dao.HouseDAO;
import com.gaoyang.pojo.House;

@Controller
public class AgentCreateController {
	
	
	@Autowired
	@Qualifier("houseDAO")
	HouseDAO houseDAO;
	
	@RequestMapping(value="/createHouse.htm",method = RequestMethod.POST)
	protected ModelAndView createHouseTypeMethod(@ModelAttribute("house") House house, BindingResult result,HttpServletRequest request) throws Exception {
		house.setHouseStatus("Leasing");
		houseDAO.createHouse(house);
		return new ModelAndView("agent/createHouse");
	}

}
