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
import com.gaoyang.dao.CompanyDAO;
import com.gaoyang.dao.UserDAO;
import com.gaoyang.pojo.Company;
import com.gaoyang.pojo.UAgent;

@Controller
public class AdminUpdateAgentController {
	
	@Autowired
	@Qualifier("userDAO")
	UserDAO userDAO;
	
	@Autowired
	@Qualifier("comDAO")
	CompanyDAO comDAO;
	
	@Autowired
	@Qualifier("agentDAO")
	AgentDAO agentDAO;
	
	
	@RequestMapping(value = "/admin/browserAgent.htm", method = RequestMethod.GET)
	protected String iniTFopMenu(HttpServletRequest request) {
		List<Company> com;
		com = comDAO.getAllCompany();
		request.setAttribute("companyList", com);

		List<UAgent> agn;
		agn = agentDAO.getAllAgent();
		request.setAttribute("agentList", agn);
		return "admin/browserAgent";
	}

	@RequestMapping(value = "/admin/updateAgent.htm", method = RequestMethod.GET)
	protected String iniAgentMethod(@ModelAttribute("agent") UAgent agent, HttpServletRequest request) {
		String agentID = request.getParameter("detailID");
		UAgent agentIns = new UAgent();
		agentIns = agentDAO.getSpecificAgent(agentID);
		if(request.getParameter("disAct")!=null){
			agentIns.setUserStatus("Disable");
			agentDAO.updateSpecificAgent(agentIns);
		}
		agentIns = agentDAO.getSpecificAgent(agentID);
		request.setAttribute("agentDetail", agentIns);
		return "admin/updateAgent";
	}

	@RequestMapping(value = "/admin/updateAgent.htm", method = RequestMethod.POST)
	protected String updateAgentMethod(HttpServletRequest request) {
		String agentID =request.getParameter("agentItemID");		
		UAgent agentIns = agentDAO.getSpecificAgent(agentID);
		String action = request.getParameter("action");
		if(action==null){
			String agentDescription = request.getParameter("descArea");
			agentIns.setAgentDescription(agentDescription);
		}

		if(action!=null && action.equals("actA")){
			agentIns.setUserStatus("Active");
		}
		agentDAO.updateSpecificAgent(agentIns);
		agentIns = agentDAO.getSpecificAgent(agentID);
		request.setAttribute("agentDetail", agentIns);
		return "admin/updateAgent";
	}
}
