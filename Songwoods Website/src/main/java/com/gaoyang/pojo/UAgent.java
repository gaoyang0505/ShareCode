package com.gaoyang.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="agentnProfile")
@PrimaryKeyJoinColumn(name="userID")
public class UAgent extends User{
	
	@Column(name="agentPhoneNumber")
	private String agentPhoneNumber;
	
	@Column(name="agentFaxNumber")
	private String agentFaxNumber;
	
	@Column(name="agentPicturePath")
	private String agentPicturePath;
	
	
	@Column(name="agentDescription")
	private String agentDescription;
	
	@Transient
	private MultipartFile agentPicture;
	
	@ManyToOne
	@JoinColumn(name="companyID")
	private Company company;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="ownerAgent")
	@Column(name="agentHouse")
	private Set<House> agentHouse = new HashSet<House>();

	
	public Set<House> getAgentHouse() {
		return agentHouse;
	}

	public void setAgentHouse(Set<House> agentHouse) {
		this.agentHouse = agentHouse;
	}

	public String getAgentPhoneNumber() {
		return agentPhoneNumber;
	}

	public void setAgentPhoneNumber(String agentPhoneNumber) {
		this.agentPhoneNumber = agentPhoneNumber;
	}

	public String getAgentFaxNumber() {
		return agentFaxNumber;
	}

	public void setAgentFaxNumber(String agentFaxNumber) {
		this.agentFaxNumber = agentFaxNumber;
	}

	public String getAgentPicturePath() {
		return agentPicturePath;
	}

	public void setAgentPicturePath(String agentPicturePath) {
		this.agentPicturePath = agentPicturePath;
	}

	public MultipartFile getAgentPicture() {
		return agentPicture;
	}

	public void setAgentPicture(MultipartFile agentPicture) {
		this.agentPicture = agentPicture;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getAgentDescription() {
		return agentDescription;
	}

	public void setAgentDescription(String agentDescription) {
		this.agentDescription = agentDescription;
	}
}
