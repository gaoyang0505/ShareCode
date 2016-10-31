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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="houseInfor")
public class House {
	
	@Id
	@GeneratedValue(generator="hibernate-uuid")
	@GenericGenerator(name="hibernate-uuid", strategy="uuid2")
	@Column(name="houseID",unique=true)
	private String houseID;
	
	@Column(name="houseName")
	private String houseName;
	
	@Column(name="houseDescription")
	private String houseDescription;
	
	@Column(name="housePrice")
	private int housePrice;
	
	@Column(name="houseRoom")
	private int houseRoom;
	
	@Column(name="houseStatus")
	private String houseStatus;
	
	@Column(name="houseBath")
	private int houseBath;
	
	@Column(name="houseLiving")
	private int houseLiving;
	
	@Column(name="houseLat")
	private float houseLat;
	
	@Column(name="houseLon")
	private float houseLon;
	
	@ManyToOne
	@JoinColumn(name="typeID")
	private HouseType typeID;
	
	@OneToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	private Address houseAddress;
	
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private Set<HousePictures> housePictures = new HashSet<HousePictures>();
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ownerAgent")
	private UAgent ownerAgent;
	
	

	public HouseType getTypeID() {
		return typeID;
	}

	public void setTypeID(HouseType typeID) {
		this.typeID = typeID;
	}

	public UAgent getOwnerAgent() {
		return ownerAgent;
	}

	public void setOwnerAgent(UAgent ownerAgent) {
		this.ownerAgent = ownerAgent;
	}

	public String getHouseID() {
		return houseID;
	}

	public void setHouseID(String houseID) {
		this.houseID = houseID;
	}

	public String getHouseName() {
		return houseName;
	}

	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}

	public String getHouseDescription() {
		return houseDescription;
	}

	public void setHouseDescription(String houseDescription) {
		this.houseDescription = houseDescription;
	}

	public Address getHouseAddress() {
		return houseAddress;
	}

	public void setHouseAddress(Address houseAddress) {
		this.houseAddress = houseAddress;
	}

	public Set<HousePictures> getHousePictures() {
		return housePictures;
	}

	public void setHousePictures(Set<HousePictures> housePictures) {
		this.housePictures = housePictures;
	}

	public House() {
		
	}

	public int getHousePrice() {
		return housePrice;
	}

	public void setHousePrice(int housePrice) {
		this.housePrice = housePrice;
	}

	public int getHouseRoom() {
		return houseRoom;
	}

	public void setHouseRoom(int houseRoom) {
		this.houseRoom = houseRoom;
	}

	public String getHouseStatus() {
		return houseStatus;
	}

	public void setHouseStatus(String houseStatus) {
		this.houseStatus = houseStatus;
	}

	public int getHouseBath() {
		return houseBath;
	}

	public void setHouseBath(int houseBath) {
		this.houseBath = houseBath;
	}

	public int getHouseLiving() {
		return houseLiving;
	}

	public void setHouseLiving(int houseLiving) {
		this.houseLiving = houseLiving;
	}

	public float getHouseLat() {
		return houseLat;
	}

	public void setHouseLat(float houseLat) {
		this.houseLat = houseLat;
	}

	public float getHouseLon() {
		return houseLon;
	}

	public void setHouseLon(float houseLon) {
		this.houseLon = houseLon;
	}
	
	
	
}
