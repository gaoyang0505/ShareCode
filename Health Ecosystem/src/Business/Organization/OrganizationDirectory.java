/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import java.util.ArrayList;

/**
 *
 * @author Cassiopeia
 */
public class OrganizationDirectory {
    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList<>();
    }
    
    public Organization createOrganization(Organization.Type type){
        Organization org = null;
        
        if(type.getValue().equals(Organization.Type.EPA.getValue())){
            org = new EPAOrganization();
            organizationList.add(org);
        }
        
        if(type.getValue().equals(Organization.Type.Diplomacy.getValue())){
            org = new DiplomacyOrganization();
            organizationList.add(org);
        }
        
        if(type.getValue().equals(Organization.Type.Residence.getValue())){
            org = new ResidenceOrganization();
            organizationList.add(org);
        }
        return org;
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
}
