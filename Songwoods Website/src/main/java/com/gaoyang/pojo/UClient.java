package com.gaoyang.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="clientnProfile")
@PrimaryKeyJoinColumn(name="userID")
public class UClient extends User{
	
	@ManyToMany(fetch=FetchType.EAGER,cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Set<House> houseFav = new HashSet<House>();

	public UClient() {
		houseFav = new HashSet<House>();
	}

	public Set<House> getHouseFav() {
		return houseFav;
	}

	public void setHouseFav(Set<House> houseFav) {
		this.houseFav = houseFav;
	}
}
