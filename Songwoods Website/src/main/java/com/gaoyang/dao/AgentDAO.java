package com.gaoyang.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.gaoyang.pojo.Company;
import com.gaoyang.pojo.UAgent;

public class AgentDAO extends DAO {

	public AgentDAO() {

	}

	public boolean create(UAgent agent) {
		try {
			begin();

			UAgent agentUser = agent;
			agentUser.setRoleType("Agent");
			agentUser.setUserStatus("Active");
			agentUser.setUserFirstName(agent.getUserFirstName());
			agentUser.setUserLastName(agent.getUserLastName());
			agentUser.setUserEMail(agent.getUserEMail());
			agentUser.setUserPassword(agent.getUserPassword());

			getSession().save(agentUser);

			commit();
			close();
			return true;
		} catch (HibernateException exception) {
			rollback();
			close();
			throw exception;
		}
	}
	
	public boolean updateSpecificAgent(UAgent agent){
		try {
			begin();
			UAgent agentUser = agent;
			getSession().update(agentUser);;
			commit();
			close();
			return true;
		} catch (HibernateException exception) {
			rollback();
			close();
			throw exception;
		}
	}

	public List<UAgent> getAllAgent() {

		try {
			Criteria cri = getSession().createCriteria(UAgent.class);
			cri.addOrder(Order.asc("userLastName"));
			List<UAgent> list = cri.list();
			close();
			return list;
		} catch (HibernateException exception) {
			rollback();
			close();
			throw exception;
		}
	}
	
	public UAgent getSpecificAgent(String agentID) {

		try {
			Criteria cri = getSession().createCriteria(UAgent.class);
			cri.add(Restrictions.eq("userID",agentID));
			UAgent agent = (UAgent) cri.uniqueResult();
			close();
			return agent;
		} catch (HibernateException exception) {
			rollback();
			close();
			throw exception;
		}
	}

}
