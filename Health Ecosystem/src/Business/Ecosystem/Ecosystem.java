/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Ecosystem;

import Business.AControlClass.CityToStateList;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.Role.SystemAdminRole;
import java.util.ArrayList;

/**
 *
 * @author Cassiopeia
 */
public class Ecosystem extends Organization{
    
    private static Ecosystem business;
    private CityToStateList cityToStateList;
    private ArrayList<Network> networkList;
    
    public static Ecosystem getInstance() {
        if (business == null) {
            business = new Ecosystem();
        }
        return business;
    }

    private Ecosystem() {
        super(null);
        networkList = new ArrayList<>();
        cityToStateList = new CityToStateList();
    }

    public CityToStateList getCityToStateList() {
        return cityToStateList;
    }

    public void setCityToStateList(CityToStateList cityToStateList) {
        this.cityToStateList = cityToStateList;
    }

    

    public ArrayList<Network> getNetworkList() {
        return networkList;
    }

    public Network createAndAddNetwork() {
        Network network = new Network();
        networkList.add(network);
        return network;
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList = new ArrayList<>();
        roleList.add(new SystemAdminRole());
        return roleList;
    }

    public boolean checkIfUsernameIsUnique(String username) {

        if (!this.getUserAccountDirectory().checkIfUsernameIsUnique(username)) {
            return false;
        }
        return true;
    }
    
}
