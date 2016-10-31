/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Cassiopeia
 */
public class HospitalEnterprise extends Enterprise{
    private String hospitalCity;
    private String hospitalCommunity;
    
    public HospitalEnterprise(String nameEnterprise){
        super(nameEnterprise, EnterpriseType.Hospital);
    }

    public String getHospitalCity() {
        return hospitalCity;
    }

    public void setHospitalCity(String hospitalCity) {
        this.hospitalCity = hospitalCity;
    }

    public String getHospitalCommunity() {
        return hospitalCommunity;
    }

    public void setHospitalCommunity(String hospitalCommunity) {
        this.hospitalCommunity = hospitalCommunity;
    }
    
    

    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
    
}
