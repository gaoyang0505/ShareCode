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
public class GovernmentEnterprise extends Enterprise{
    
    public GovernmentEnterprise(String nameEnterprise){
        super(nameEnterprise, EnterpriseType.CityGovernment);
    }
    
    

    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
    
}
