package com.gaoyang.pojo;


import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="adminProfile")
@PrimaryKeyJoinColumn(name="userID")
public class UAdmin extends User {
	
	public UAdmin() {
		
	}

}
