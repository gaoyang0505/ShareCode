package com.gaoyang.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;

import com.gaoyang.pojo.Message;
import com.gaoyang.pojo.UClient;
import com.gaoyang.pojo.User;

public class MessageDAO extends DAO {

	public void createMessage(String mesCon, String mesTit, String mesTyp, User sender, User receiver) {
		try {

			begin();

			Message mess = new Message();
			mess.setMessageStatus("Unread");
			mess.setMessageText(mesCon);
			mess.setMessageType(mesTyp);
			mess.setMessageTitle(mesTit);

			User send = sender;
			User rece = receiver;

			mess.setReceiver(rece);
			mess.setSender(send);

			getSession().save(mess);
			commit();

		} catch (HibernateException exception) {
			rollback();

			throw exception;
		} finally {
			close();
		}

	}

	public List<Message> getSendedMessage(String clientID) {
		try {
			begin();
			Criteria cri = getSession().createCriteria(Message.class);
			List<Message> list = cri.list();
			List<Message> listResult = new ArrayList<Message>();
			for(Message me:list){
				if(me.getSender().getUserID().equals(clientID)){
					listResult.add(me);
				}
			}
			commit();
			return listResult;
		} catch (HibernateException exception) {
			rollback();
			throw exception;
		} finally {
			close();
		}
	}
	
	public List<Message> getRecivedMessage(String clientID) {
		try {
			begin();
			Criteria cri = getSession().createCriteria(Message.class);
			List<Message> listResult = new ArrayList<Message>();
			List<Message> list = cri.list();
			for(Message me:list){
				if(me.getReceiver().getUserID().equals(clientID)){
					listResult.add(me);
				}
			}
			commit();
			return listResult;
		} catch (HibernateException exception) {
			rollback();
			throw exception;
		} finally {
			close();
		}
	}

	public Message getMessage(String messageID){
		try {
			begin();
			Criteria cri = getSession().createCriteria(Message.class);
			cri.add(Restrictions.eq("messageID", messageID));
			Message message = (Message) cri.uniqueResult();
			commit();
			return message;
		} catch (HibernateException exception) {
			rollback();
			throw exception;
		} finally {
			close();
		}
		
	}
}
