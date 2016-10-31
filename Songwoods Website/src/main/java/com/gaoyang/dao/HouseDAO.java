package com.gaoyang.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;

import com.gaoyang.pojo.Address;
import com.gaoyang.pojo.House;
import com.gaoyang.pojo.HouseType;
import com.gaoyang.pojo.UClient;

public class HouseDAO extends DAO {

	public boolean createType(HouseType houseType) {
		try {
			begin();
			getSession().save(houseType);
			commit();
			close();
			return true;
		} catch (HibernateException exception) {
			rollback();
			close();
			throw exception;
		}
	}

	public boolean createHouse(House house) {
		try {
			begin();

			House houseSave = house;
			getSession().save(houseSave);

			commit();
			close();
			return true;
		} catch (HibernateException exception) {
			rollback();
			close();
			throw exception;
		}
	}

	public List<HouseType> getAllType() {
		try {
			Criteria cri = getSession().createCriteria(HouseType.class);
			List<HouseType> list = cri.list();
			close();
			return list;
		} catch (HibernateException exception) {
			rollback();
			close();
			throw exception;
		}
	}

	public List<House> getHouseByCity(String city) {
		try {
			List<House> list = new ArrayList<House>();
			Criteria houseCri = getSession().createCriteria(House.class);
			List<House> houseList = houseCri.list();
			for (House house : houseList) {
				if (city.equals(house.getHouseAddress().getAddressCity())) {
					list.add(house);
				}
			}
			close();
			return list;
		} catch (HibernateException exception) {
			rollback();
			close();
			throw exception;
		}
	}
	
	public List<House> getFavoriteList(UClient client) {
		try {
			List<House> list = new ArrayList<House>();
			Set<House> houseSet = client.getHouseFav();
			for(House house:houseSet){
				list.add(house);
			}
			return list;
		} catch (HibernateException exception) {
			throw exception;
		}
	}

	public List<House> getHouseAdvanced(String search, int bathNum, int bedNum, int minPrice, int maxPrice,
			String[] type) {
		try {
			List<House> list = new ArrayList<House>();
			List<House> listResult = new ArrayList<House>();

			Criteria houseCri = getSession().createCriteria(House.class);
			houseCri.add(Restrictions.gt("houseBath", bathNum));
			houseCri.add(Restrictions.gt("houseRoom", bedNum));
			houseCri.add(Restrictions.gt("housePrice", minPrice));
			houseCri.add(Restrictions.lt("housePrice", maxPrice));
			
			List<House> houseList = houseCri.list();

			System.out.println("@#$%^&*(@#$%^&*($%^&*("+type.length);
			for (House house : houseList) {
				for (int i = 0; i < type.length; i++) {
					if (house.getTypeID().getHouseTypeName().equals(type[i]))
						list.add(house);
				}
			}
			
			for (House houseNew : list) {
				if (isNumeric(search)){
					if(houseNew.getHouseAddress().getAddressZipCode().equals(search))
						listResult.add(houseNew);
				}else{
					if(houseNew.getHouseAddress().getAddressCity().equals(search))
						listResult.add(houseNew);
				}				
			}
			
			close();
			return listResult;
		} catch (HibernateException exception) {
			rollback();
			close();
			throw exception;
		}
	}

	public House getHouseByID(String houseID) {
		try {
		
			Criteria houseCri = getSession().createCriteria(House.class);
			houseCri.add(Restrictions.eq("houseID", houseID));
			House house = (House) houseCri.uniqueResult();
			close();
			return house;
		} catch (HibernateException exception) {
			rollback();
			close();
			throw exception;
		}
	}
	
	
	public static boolean isNumeric(String inputData) {
		return inputData.matches("[-+]?\\d+(\\.\\d+)?");
	}
}
