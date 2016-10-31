package com.gaoyang.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gaoyang.dao.HouseDAO;
import com.gaoyang.dao.UserDAO;
import com.gaoyang.pojo.House;
import com.gaoyang.pojo.HouseType;
import com.gaoyang.pojo.User;

@Controller
public class IndexSearchController {
	
	@Autowired
	@Qualifier("userDAO")
	UserDAO userDAO;
	
	@Autowired
	@Qualifier("houseDAO")
	HouseDAO houseDAO;

	@RequestMapping(value = "/search_index.htm", method = RequestMethod.POST)
	protected ModelAndView searchHouse(HttpServletRequest request) throws Exception {

		String city = request.getParameter("citySearch");
		List<House> houseList;
		List<HouseType> houseTypeList;
		houseList = houseDAO.getHouseByCity(city);
		houseTypeList = houseDAO.getAllType();

		ModelAndView modelView = new ModelAndView();

		modelView.addObject("typeList", houseTypeList);
		modelView.addObject("houseList", houseList);
		modelView.addObject("city", city);
		
		HttpSession session = request.getSession(false);
		if(session!=null && session.getAttribute("user")!=null){
			User user = userDAO.getSpecificUser(session.getAttribute("user").toString());
			user.setUserPassword("*");
			modelView.addObject("user",user);
			
		}
		modelView.setViewName("advancedHouse");

		return modelView;
	}

	@RequestMapping(value = "/search_advance.htm", method = RequestMethod.POST)
	protected ModelAndView searchHouseAdvance(HttpServletRequest request) throws Exception {
		
		int bathNum=-1;
		if(request.getParameter("bathNum")!=null && !request.getParameter("bathNum").equals("Any"))
			bathNum = Integer.parseInt(request.getParameter("bathNum"));
		
		int bedNum=-1;
		if(request.getParameter("bedNum")!=null && !request.getParameter("bedNum").equals("Any"))
			bedNum = Integer.parseInt(request.getParameter("bedNum"));
			
		
		int minPrice=-1;
		if(request.getParameter("minPrice")!=null && !request.getParameter("minPrice").equals(""))
			minPrice =Integer.parseInt(request.getParameter("minPrice"));
		
		int maxPrice=999999999;
		if(request.getParameter("maxPrice")!=null && !request.getParameter("maxPrice").equals(""))
			maxPrice= Integer.parseInt(request.getParameter("maxPrice"));
		
		
		String[] type=new String[10];
		if(request.getParameterValues("checkType")!=null)
			type = request.getParameterValues("checkType");
		
		String search = request.getParameter("cityZip");

		List<House> houseList;
		houseList = houseDAO.getHouseAdvanced(search,bathNum,bedNum,minPrice,maxPrice,type);
		
		List<HouseType> houseTypeList;
		houseTypeList = houseDAO.getAllType();

		ModelAndView modelView = new ModelAndView();

		modelView.addObject("typeList", houseTypeList);
		modelView.addObject("houseList", houseList);
		modelView.addObject("city", search);
		
		HttpSession session = request.getSession(false);
		if(session!=null && session.getAttribute("user")!=null){
			User user = userDAO.getSpecificUser(session.getAttribute("user").toString());
			user.setUserPassword("*");
			modelView.addObject("user",user);		
		}

		modelView.setViewName("advancedHouse");

		return modelView;
	}

}
