/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.CityDiplomacyRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Cassiopeia
 */
public class DiplomacyOrganization extends Organization{
   
    public DiplomacyOrganization() {
        super(Organization.Type.Diplomacy.getValue());
    }
    

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new CityDiplomacyRole());
        return roles;
    }
    
}
