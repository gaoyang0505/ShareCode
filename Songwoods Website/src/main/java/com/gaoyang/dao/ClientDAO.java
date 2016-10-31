package com.gaoyang.dao;

import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;

import com.gaoyang.pojo.House;
import com.gaoyang.pojo.UClient;
import com.gaoyang.pojo.User;

public class ClientDAO extends DAO {

	public ClientDAO() {
    }
	
	public UClient create(String userPassword, String userEMail, String userFirstName, String userLastName) {
		try {
			begin();

			UClient clientUser = new UClient();

			clientUser.setUserFirstName(userFirstName);
			clientUser.setUserLastName(userLastName);
			clientUser.setRoleType("Client");
			clientUser.setUserStatus("Active");
			clientUser.setUserEMail(userEMail);
			clientUser.setUserPassword(userPassword);

			getSession().save(clientUser);

			commit();
			close();
			return clientUser;
		} catch (HibernateException exception) {
			rollback();
			close();
			throw exception;
		}
	}

	public void addFavoriteHouse(UClient client, House house) {
		try {
			begin();
			client.getHouseFav().add(house);
			Set<House> houseList = client.getHouseFav();
			houseList.add(house);
			getSession().update(client);
			commit();
		} catch (HibernateException exception) {
			rollback();
			throw exception;
		} finally {
			close();
		}
	}
	
	public void deleteFavoriteHouse(UClient client, House house) {
		try {
			begin();
			client.getHouseFav().add(house);
			Set<House> houseList = client.getHouseFav();
			houseList.remove(house);
			getSession().update(client);
			commit();
		} catch (HibernateException exception) {
			rollback();
			throw exception;
		} finally {
			close();
		}
	}
	
	public UClient getClientByEmail(String userEmail) {

		try {
			Criteria cri = getSession().createCriteria(UClient.class);
			cri.add(Restrictions.eq("userEMail",userEmail));
			UClient user = (UClient) cri.uniqueResult();
			close();
			return user;
		} catch (HibernateException exception) {
			rollback();
			close();
			throw exception;
		}
	}
}
