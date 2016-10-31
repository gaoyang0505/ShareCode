/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

/**
 *
 * @author Cassiopeia
 */
public class MedicalWorkRequest  extends WorkRequest{
    private String sthMedical;

    public String getSthMedical() {
        return sthMedical;
    }

    public void setSthMedical(String sthMedical) {
        this.sthMedical = sthMedical;
    }
    
}
