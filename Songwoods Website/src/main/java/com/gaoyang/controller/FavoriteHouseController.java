package com.gaoyang.controller;

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
public class FavoriteHouseController {

	
	@Autowired
	@Qualifier("houseDAO")
	HouseDAO houseDAO;
	
	@Autowired
	@Qualifier("clientDAO")
	ClientDAO clientDAO;
	
	
	@RequestMapping(value = "/addFav.htm", method = RequestMethod.GET)
	protected String addFavorite(HttpServletRequest request){
		String email = request.getParameter("userEMail");
		String houseID = request.getParameter("houseID");
		House house = new House();	
		UClient client = clientDAO.getClientByEmail(email);
		house = houseDAO.getHouseByID(houseID);
		clientDAO.addFavoriteHouse(client,house);
		return null;
	}
	
	@RequestMapping(value = "/houseDelete.htm", method = RequestMethod.GET)
	public String initializeIndex(HttpServletRequest request) {

		String houseID = request.getParameter("houseID");
		UClient client  = new UClient ();
		client = clientDAO.getClientByEmail(request.getSession().getAttribute("user").toString());
	
		House houseIns = new House();
		houseIns = houseDAO.getHouseByID(houseID);
		
		clientDAO.deleteFavoriteHouse(client, houseIns);

		return null;
	}

}
