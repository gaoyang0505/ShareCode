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
public class DiseaseDirectory {
    private ArrayList<Disease> diseaseList;

    public DiseaseDirectory() {
        diseaseList = new ArrayList<>();
    }
    

    public ArrayList<Disease> getDiseaseList() {
        return diseaseList;
    }

    public void setDiseaseList(ArrayList<Disease> diseaseList) {
        this.diseaseList = diseaseList;
    }
    
    public Disease addDisease(Disease disease){
        Disease dis = disease;
        diseaseList.add(dis);
        return dis;
    }
    
    
}
