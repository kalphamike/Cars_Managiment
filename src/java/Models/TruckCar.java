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
public class TruckCar extends Car{
    @Column(name = "loadCapacity")
    private Double loadCapacity;

    public TruckCar() {
    }

    public TruckCar(Double loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    public Double getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(Double loadCapacity) {
        this.loadCapacity = loadCapacity;
    }
    
    
}
