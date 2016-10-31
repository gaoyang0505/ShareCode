/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Network;

import Business.Enterprise.EnterpriseDirectory;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.Role.StateHealthWorkerRole;
import java.util.ArrayList;

/**
 *
 * @author Cassiopeia
 */
public class Network extends Organization{
    
    private String netWorkName;
    private EnterpriseDirectory enterpriseDirectory;

    public Network() {
        super(null);
        enterpriseDirectory = new EnterpriseDirectory();
    }

    public String getNetWorkName() {
        return netWorkName;
    }

    public void setNetWorkName(String netWorkName) {
        this.netWorkName = netWorkName;
    }


    public EnterpriseDirectory getEnterpriseDirectory() {
        return enterpriseDirectory;
    }

    public void setEnterpriseDirectory(EnterpriseDirectory enterpriseDirectory) {
        this.enterpriseDirectory = enterpriseDirectory;
    }
    
    @Override
    
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList = new ArrayList<>();
        roleList.add(new StateHealthWorkerRole());
        return roleList;
    }
    
    @Override
    public String toString(){
        return netWorkName;
    }
}
