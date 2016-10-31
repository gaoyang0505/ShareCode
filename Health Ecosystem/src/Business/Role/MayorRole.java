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
import Interface.Mayor.MayorWorkArea;
import javax.swing.JPanel;

/**
 *
 * @author Cassiopeia
 */
public class MayorRole extends Role{

    
    @Override
    public JPanel createWorkArea(JPanel upc, UserAccount ua, Organization o, Enterprise e, Network network, Ecosystem system){
        return new MayorWorkArea(upc,e,ua,system.getEnviornmentConditionDirectory());
    }
}