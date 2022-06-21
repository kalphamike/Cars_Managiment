/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author steve
 */
@Entity
public class PassengeCar extends Car{
    @Column(name = "numberOfPassanger")
    private String numberOfPassanger;

    public PassengeCar() {
    }

    public String getNumberOfPassanger() {
        return numberOfPassanger;
    }

    public void setNumberOfPassanger(String numberOfPassanger) {
        this.numberOfPassanger = numberOfPassanger;
    }

   
    
    
}
