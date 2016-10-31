/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import java.util.ArrayList;

/**
 *
 * @author Cassiopeia
 */
public class EnterpriseDirectory {
    
    private ArrayList<Enterprise> enterpriseList;
    
    public EnterpriseDirectory(){
        enterpriseList = new ArrayList<>();
    }
    
    public Enterprise createAndAddEnterprise(String nameEnterprise, Enterprise.EnterpriseType type){
        Enterprise enterprise = null;
        if(type == Enterprise.EnterpriseType.Hospital){
            enterprise = new HospitalEnterprise(nameEnterprise);
            enterpriseList.add(enterprise);
        }
        
        if(type == Enterprise.EnterpriseType.CityGovernment){
            enterprise = new GovernmentEnterprise(nameEnterprise);
            enterpriseList.add(enterprise);
        }
        
        return enterprise;
    }

    public ArrayList<Enterprise> getEnterpriseList() {
        return enterpriseList;
    }
    
}
