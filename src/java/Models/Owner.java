    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author steve
 */
@Entity
public class Owner {
    @Id
    
    private String ownerId;
    private String ownerName;
    @OneToMany(mappedBy = "owner")
    private List<Car> cars;
    @OneToMany(mappedBy = "ownername")
    private List<Car> carss;

    public Owner() {
    }

    public Owner(String ownerId, String ownerName) {
        this.ownerId = ownerId;
        this.ownerName = ownerName;
    }

    public Owner(String ownerId, String ownerName, List<Car> cars, List<Car> carss) {
        this.ownerId = ownerId;
        this.ownerName = ownerName;
        this.cars = cars;
        this.carss = carss;
    }
    
    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCarss() {
        return carss;
    }

    public void setCarss(List<Car> carss) {
        this.carss = carss;
    }

    
}
