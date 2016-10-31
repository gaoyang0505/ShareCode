package com.gaoyang.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="addressInfor")
public class Address {
	
	@Id
	@GenericGenerator(name="hibernate-uuid", strategy="uuid2")
	@GeneratedValue(generator="hibernate-uuid")	
	@Column(name="addressID",unique=true)
	private String addressID;
	
	@Column(name="addressZipCode")
	private String addressZipCode;
	
	@Column(name="addressState")
	private String addressState;
	
	@Column(name="addressCity")
	private String addressCity;
	
	@Column(name="addressStreet")
	private String addressStreet;
	
	@Column(name="addressNumber")
	private String addressNumber;
	
	@Column(name="addressOther")
	private String addressOther;
	
//	@OneToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name="houseID")
//	private House house;
	
	

	public Address() {

	}

	public String getAddressID() {
		return addressID;
	}

	public void setAddressID(String addressID) {
		this.addressID = addressID;
	}

	public String getAddressZipCode() {
		return addressZipCode;
	}

	public void setAddressZipCode(String addressZipCode) {
		this.addressZipCode = addressZipCode;
	}

	public String getAddressState() {
		return addressState;
	}

	public void setAddressState(String addressState) {
		this.addressState = addressState;
	}

	public String getAddressCity() {
		return addressCity;
	}

	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}

	public String getAddressStreet() {
		return addressStreet;
	}

	public void setAddressStreet(String addressStreet) {
		this.addressStreet = addressStreet;
	}

	public String getAddressNumber() {
		return addressNumber;
	}

	public void setAddressNumber(String addressNumber) {
		this.addressNumber = addressNumber;
	}

	public String getAddressOther() {
		return addressOther;
	}

	public void setAddressOther(String addressOther) {
		this.addressOther = addressOther;
	}

//	public House getHouse() {
//		return house;
//	}
//
//	public void setHouse(House house) {
//		this.house = house;
//	}
	
	


}
