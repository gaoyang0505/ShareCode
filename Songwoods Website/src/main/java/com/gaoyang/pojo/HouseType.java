package com.gaoyang.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="houseType")
public class HouseType {
	@Id
	@GeneratedValue(generator="hibernate-uuid")
	@GenericGenerator(name="hibernate-uuid", strategy="uuid2")
	@Column(name="houseTypeID",unique=true)
	private String houseTypeID;
	
	@Column(name="houseTypeName")
	private String houseTypeName;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="typeID")
	@Column(name="houseSet")
	private Set<House> houseSet = new HashSet<House>();

	public HouseType() {
		
	}

	public String getHouseTypeID() {
		return houseTypeID;
	}

	public void setHouseTypeID(String houseTypeID) {
		this.houseTypeID = houseTypeID;
	}

	public String getHouseTypeName() {
		return houseTypeName;
	}

	public void setHouseTypeName(String houseTypeName) {
		this.houseTypeName = houseTypeName;
	}

	public Set<House> getHouseSet() {
		return houseSet;
	}

	public void setHouseSet(Set<House> houseSet) {
		this.houseSet = houseSet;
	}
	
	
	
	
	

}
