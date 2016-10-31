/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Information;

import java.util.ArrayList;

/**
 *
 * @author Cassiopeia
 */
public class EnviornmentConditionDirectory {
    private ArrayList<EnviornmentCondition> enviornmentConditionList;

    public EnviornmentConditionDirectory() {
        enviornmentConditionList = new ArrayList<>();
    }

    public ArrayList<EnviornmentCondition> getEnviornmentConditionList() {
        return enviornmentConditionList;
    }

    public void setEnviornmentConditionList(ArrayList<EnviornmentCondition> enviornmentConditionList) {
        this.enviornmentConditionList = enviornmentConditionList;
    }
    
    public EnviornmentCondition addAir(EnviornmentCondition city) {
        EnviornmentCondition cs = city;
        enviornmentConditionList.add(cs);
        return cs;
    }
    
}
