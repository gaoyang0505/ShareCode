package com.gaoyang.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;

import com.gaoyang.pojo.Company;

public class CompanyDAO extends DAO{
	public boolean create(Company company) {
		try {
			begin();
			getSession().save(company);
			commit();
			close();
			return true;
		} catch (HibernateException exception) {
			rollback();
			close();
			throw exception;
		}
	}
	
	public List<Company> getAllCompany(){
		
		try {
			Criteria cri = getSession().createCriteria(Company.class);
			List<Company> list = cri.list();
			close();
			return list;
		} catch (HibernateException exception) {
			rollback();
			close();
			throw exception;
		}
	}

}
