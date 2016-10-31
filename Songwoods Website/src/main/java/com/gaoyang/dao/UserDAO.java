package com.gaoyang.dao;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import com.gaoyang.pojo.House;
import com.gaoyang.pojo.UClient;
import com.gaoyang.pojo.User;

public class UserDAO extends DAO {

	public User checkUserAccess(String userEMail, String userPassword) {
		try {
			begin();
			Query query = getSession()
					.createQuery("from User where useremail = :useremail and userpassword = :userpassword");
			query.setString("useremail", userEMail);
			query.setString("userpassword", userPassword);
			User user = (User) query.uniqueResult();
			commit();
			if (user != null) {
				return user;
			} else {
				return null;
			}
		} catch (HibernateException exception) {
			rollback();
			throw exception;
		}
	}

	public boolean checkUnique(String userEmail) {
		try {
			begin();
			Query query = getSession().createQuery("from User where useremail = :useremail");
			query.setString("useremail", userEmail);
			User user = (User) query.uniqueResult();
			commit();
			close();
			if (user != null) {
				return false;
			} else {
				return true;
			}
		} catch (HibernateException exception) {
			rollback();
			throw exception;
		}
	}

	public void updateUserP(User user, String newOne) {
		try {
			begin();
			user.setUserPassword(newOne);
			getSession().update(user);
			commit();
		} catch (HibernateException exception) {
			rollback();
			close();
			throw exception;
		} finally {
			close();
		}

	}

	public User getSpecificUser(String userEmail) {

		try {
			Criteria cri = getSession().createCriteria(User.class);
			cri.add(Restrictions.eq("userEMail", userEmail));
			User user = (User) cri.uniqueResult();
			close();
			return user;
		} catch (HibernateException exception) {
			rollback();
			close();
			throw exception;
		}
	}
}
