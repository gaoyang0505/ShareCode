package com.gaoyang.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="companyInfor")
public class Company {
	
	@Id
	@GeneratedValue(generator="hibernate-uuid")
	@GenericGenerator(name="hibernate-uuid", strategy="uuid2")
	@Column(name="companyID",unique=true)
	private String companyID;
	
	@Column(name="companyName")
	private String companyName;
	
	//Unidirectional
	@OneToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="companyAddressID")
	private Address companyAddress;
	
	@Column(name="contactEMail")
	private String contactEMail;
	
	@Column(name="phoneNumber")
	private String phoneNumber;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="company")
	private Set<UAgent> agent = new HashSet<UAgent>();

	
	
	public Address getCompanyAddress() {
		return companyAddress;
	}



	public void setCompanyAddress(Address companyAddress) {
		this.companyAddress = companyAddress;
	}



	public Company() {

	}

	

	public String getCompanyID() {
		return companyID;
	}



	public void setCompanyID(String companyID) {
		this.companyID = companyID;
	}



	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

//	public Address getCompanyAddress() {
//		return companyAddress;
//	}
//
//	public void setCompanyAddress(Address companyAddress) {
//		this.companyAddress = companyAddress;
//	}

	public String getContactEMail() {
		return contactEMail;
	}

	public void setContactEMail(String contactEMail) {
		this.contactEMail = contactEMail;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Set<UAgent> getAgent() {
		return agent;
	}

	public void setAgent(Set<UAgent> agent) {
		this.agent = agent;
	}
	
	
	

}
