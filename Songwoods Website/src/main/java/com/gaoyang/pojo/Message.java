package com.gaoyang.pojo;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="message")
public class Message {
	
	@Id
	@GenericGenerator(name="hibernate-uuid", strategy="uuid2")
	@GeneratedValue(generator="hibernate-uuid")
	@Column(name="messageID",unique=true)
	private String messageID;
	
	@Column(name="messageText")
	private String messageText;
	
	@Column(name="messageTitle")
	private String messageTitle;
	
	@Column(name="messageDate")
	private Date messageDate;
	
	@Column(name="messageType")
	private String messageType;
	
	@Column(name="messageStatus")
	private String messageStatus;
	
	@ManyToOne
    @JoinColumn(name = "sender_id")
	private User sender;
	
	@ManyToOne
    @JoinColumn(name = "receiver_id")
	private User receiver;

	
	public String getMessageID() {
		return messageID;
	}

	public void setMessageID(String messageID) {
		this.messageID = messageID;
	}

	public String getMessageTitle() {
		return messageTitle;
	}

	public void setMessageTitle(String messageTitle) {
		this.messageTitle = messageTitle;
	}

	public Message() {
		messageDate = new Date();
	}

	public String getMessageText() {
		return messageText;
	}

	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}

	public Date getMessageDate() {
		return messageDate;
	}

	public void setMessageDate(Date messageDate) {
		this.messageDate = messageDate;
	}

	public String getMessageType() {
		return messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	public String getMessageStatus() {
		return messageStatus;
	}

	public void setMessageStatus(String messageStatus) {
		this.messageStatus = messageStatus;
	}

	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public User getReceiver() {
		return receiver;
	}

	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}
}
