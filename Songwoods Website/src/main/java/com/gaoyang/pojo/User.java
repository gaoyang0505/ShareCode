package com.gaoyang.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.InheritanceType;

@Entity
@Table(name="user")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
	
	@Id
	@GenericGenerator(name="hibernate-uuid", strategy="uuid2")
	@GeneratedValue(generator="hibernate-uuid")
	@Column(name="userID",unique=true)
	private String userID;
	
	@Column(name="userPassword")
	private String userPassword;
	
	@Column(name="userEMail")
	private String userEMail;

	@Column(name="userFirstName")
	private String userFirstName;
	
	@Column(name="userLastName")
	private String userLastName;
	
	@Column(name="userRole")
	private String roleType;
	
	@Column(name="userStatus")
	private String userStatus;
	
	
	
	public User() {
		
	}
	
	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public User(String userPassword, String userEMail) {
		this.userPassword = userPassword;
		this.userEMail = userEMail;
	}



	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserEMail() {
		return userEMail;
	}
	public void setUserEMail(String userEMail) {
		this.userEMail = userEMail;
	}
}
