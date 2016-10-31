/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Information;

import Business.AControlClass.CitytoState;

/**
 *
 * @author Cassiopeia
 */
public class EnviornmentCondition {
    private int airCondition;
    private CitytoState citytoState;

    public EnviornmentCondition() {
        citytoState = new CitytoState();
    }

    public int getAirCondition() {
        return airCondition;
    }

    public void setAirCondition(int airCondition) {
        this.airCondition = airCondition;
    }
    
    public CitytoState getCitytoState() {
        return citytoState;
    }

    public void setCitytoState(CitytoState citytoState) {
        this.citytoState = citytoState;
    }

  
    
    
    
}
