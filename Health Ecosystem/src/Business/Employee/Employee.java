/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

/**
 *
 * @author Cassiopeia
 */
public class Employee {
    
    private String nameEmployee;
    private String employeeHasAccount;

    public String getEmployeeHasAccount() {
        return employeeHasAccount;
    }

    public void setEmployeeHasAccount(String employeeHasAccount) {
        this.employeeHasAccount = employeeHasAccount;
    }
    
    

    public String getNameEmployee() {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }



    @Override
    public String toString() {
        return nameEmployee;
    }
    
}
