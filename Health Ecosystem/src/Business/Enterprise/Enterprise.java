/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;

/**
 *
 * @author Cassiopeia
 */
public abstract class Enterprise extends Organization{
    
    private EnterpriseType enterpriseType;
    private OrganizationDirectory organizationDirectory;
    
    public Enterprise(String name, EnterpriseType type){
        super(name);
        enterpriseType = type;
        organizationDirectory = new OrganizationDirectory();
    }
    public enum EnterpriseType{
        CityGovernment("City Government"),
        Hospital("Hospital");
        
        private String value;
        
        private EnterpriseType(String type){
            this.value = type;
        }
        
        public String getValue(){
            return value;
        }
        
    }

    public EnterpriseType getEnterpriseType() {
        return enterpriseType;
    }



    public OrganizationDirectory getOrganizationDirectory() {
        return organizationDirectory;
    }


    
}
