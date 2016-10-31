/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.ResidenceRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Cassiopeia
 */
public class ResidenceOrganization extends Organization{
    
    public ResidenceOrganization() {
        super(Organization.Type.Residence.getValue());
    }  
    

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new ResidenceRole());
        return roles;
    }
    
}
