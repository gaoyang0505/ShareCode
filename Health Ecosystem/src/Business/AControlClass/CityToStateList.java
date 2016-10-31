/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.AControlClass;

import java.util.ArrayList;

/**
 *
 * @author Cassiopeia
 */
public class CityToStateList {
    private ArrayList<CitytoState> cityToStateList;

    public CityToStateList() {
        cityToStateList = new ArrayList<>();
    }
    
    

    public ArrayList<CitytoState> getCityToStateList() {
        return cityToStateList;
    }

    public void setCityToStateList(ArrayList<CitytoState> cityToStateList) {
        this.cityToStateList = cityToStateList;
    }
    
    public CitytoState addCity(CitytoState city) {
        CitytoState cs = city;
        cityToStateList.add(cs);
        return cs;
    }
    
}
