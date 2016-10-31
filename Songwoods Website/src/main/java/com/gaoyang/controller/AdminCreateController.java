package com.gaoyang.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.ModelAndView;

import com.gaoyang.dao.AgentDAO;
import com.gaoyang.dao.CompanyDAO;
import com.gaoyang.dao.HouseDAO;
import com.gaoyang.dao.UserDAO;
import com.gaoyang.pojo.Company;
import com.gaoyang.pojo.HouseType;
import com.gaoyang.pojo.UAgent;

@Controller
public class AdminCreateController implements ServletContextAware {
	
	@Autowired
	@Qualifier("userDAO")
	UserDAO userDAO;
	
	@Autowired
	@Qualifier("comDAO")
	CompanyDAO comDAO;
	
	@Autowired
	@Qualifier("agentDAO")
	AgentDAO agentDAO;
	
	private ServletContext servletContext;
	public void setServletContext(ServletContext servletContext){
		this.servletContext=servletContext;
	}
	public ServletContext getServletContext(){
		return servletContext;
	}

	@RequestMapping(value="/admin/createAgent.htm",method = RequestMethod.POST)
	protected ModelAndView createAgentMethod(@ModelAttribute("agent") UAgent agent, BindingResult result,HttpServletRequest request, HttpServletResponse response) throws Exception {
	
        if(agent.getAgentPicture()!=null){
        	agent.setAgentPicturePath(System.currentTimeMillis()+agent.getAgentPicture().getOriginalFilename());
        	byte[] bytes = agent.getAgentPicture().getBytes();
        	BufferedOutputStream buffStream = new BufferedOutputStream(new FileOutputStream(new File("/Users/clark/Desktop/DestinationImage/"+agent.getAgentPicturePath())));
        	buffStream.write(bytes);
        	buffStream.close();
            agentDAO.create(agent);
        }
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/createAgent");
		return modelAndView;
	}
	
	@RequestMapping(value="/admin/createAgent.htm",method = RequestMethod.GET)
	protected String iniCreateAgent(@ModelAttribute("agent") UAgent agent, HttpServletRequest request) throws Exception {
		List<Company> com;
		com = comDAO.getAllCompany();
		request.setAttribute("companyList", com);
		return "admin/createAgent";
	}
	
	@RequestMapping(value="/admin/createCompany.htm",method = RequestMethod.GET)
	protected String iniCreateCompany(@ModelAttribute("company") Company company) throws Exception {
		return "admin/createCompany";
	}
	
	@RequestMapping(value="/admin/createCompany.htm",method = RequestMethod.POST)
	protected String createCompanyMethod(@ModelAttribute("company") Company company, BindingResult result,HttpServletRequest request) throws Exception {
		CompanyDAO companyDAO = new CompanyDAO();
		companyDAO.create(company);
		return "admin/createCompany";
	}
	
	@RequestMapping(value="/admin/createHouseType.htm",method = RequestMethod.POST)
	protected String createHouseTypeMethod(@ModelAttribute("houseType") HouseType houseType, BindingResult result) throws Exception {
		HouseDAO houseDAO = new HouseDAO();
		houseDAO.createType(houseType);
		return "admin/createHouseType";
	}
}
