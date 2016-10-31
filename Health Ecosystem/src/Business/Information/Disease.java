/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Information;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Cassiopeia
 */
public class Disease {
    private String nameDisease;
    private Date beginTime;

    public Disease() {
        beginTime = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("MM-dd-yyyy");
        ft.format(beginTime);
    }
    

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public String getNameDisease() {
        return nameDisease;
    }

    public void setNameDisease(String nameDisease) {
        this.nameDisease = nameDisease;
    }
    
}
