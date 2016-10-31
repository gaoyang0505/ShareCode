/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.Ecosystem.Ecosystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;

/**
 *
 * @author Cassiopeia
 */
public abstract class Role {
    private RoleType roleType;

    public Role() {

    }
    
    public enum RoleType{

        
        Mayor("Mayor"),
        SystemAdmin("System Admin"),
        StateAdmin("State Admin"),
        CityEPA("City EPA"),
        CityDiplomacy("City Diplomacy"),
        MedicalWorker("Medical Worker"),
        Residence("Residence");
        
        private String value;
        
        private RoleType(String value){
            this.value = value;
        }
        
        public String getValue(){
            return value;
        }
    }

    public RoleType getRoleType() {
        return roleType;
    }
    
    public abstract JPanel createWorkArea(JPanel upc, UserAccount ua, Organization o, Enterprise e, Network network, Ecosystem system);
    
    @Override
    public String toString(){
        return this.getClass().getName();
    }
    
}
