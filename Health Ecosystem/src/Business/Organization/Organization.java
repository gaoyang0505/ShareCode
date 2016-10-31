/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Employee.EmployeeDirectory;
import Business.Information.EnviornmentConditionDirectory;
import Business.Role.Role;
import Business.UserAccount.UserAccountDirectory;
import Business.WorkQueue.WorkQueue;
import java.util.ArrayList;

/**
 *
 * @author Cassiopeia
 */
public abstract class Organization {
    
    private String name;
    private WorkQueue workQueue;
    private UserAccountDirectory userAccountDirectory;
    private EmployeeDirectory employeeDirectory;
    private EnviornmentConditionDirectory enviornmentConditionDirectory;
    private int organizationID;
//    private static int counter;
    
    
    public enum Type{
        Admin("Admin Organization"), 
        Diplomacy("Diplomacy Organization"), 
        EPA("EPA Organization"),
        Medical("Medical Organization"),
        Residence("Residence Organization"),
        Mayor("Mayor Organization");
        
        private String value;
        
        private Type(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }
    
    public Organization(String name) {
        this.name = name;
        workQueue = new WorkQueue();
        userAccountDirectory = new UserAccountDirectory();
        employeeDirectory = new EmployeeDirectory();
        enviornmentConditionDirectory = new EnviornmentConditionDirectory();
    }

    public abstract ArrayList<Role> getSupportedRole();
    
    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public int getOrganizationID() {
        return organizationID;
    }
    
    public String getName() {
        return name;
    }

    public EnviornmentConditionDirectory getEnviornmentConditionDirectory() {
        return enviornmentConditionDirectory;
    }

    public void setEnviornmentConditionDirectory(EnviornmentConditionDirectory enviornmentConditionDirectory) {
        this.enviornmentConditionDirectory = enviornmentConditionDirectory;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public EmployeeDirectory getEmployeeDirectory() {
        return employeeDirectory;
    }

    public void setEmployeeDirectory(EmployeeDirectory employeeDirectory) {
        this.employeeDirectory = employeeDirectory;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

    @Override
    public String toString() {
        return name;
    }
    
}
