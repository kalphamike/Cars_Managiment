/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelView;

import Dao.GeneralDao;
import Models.PassengeCar;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author steve
 */
@ManagedBean(name = "AddPassengerCars")
@SessionScoped
public class PassengeCarView {
private PassengeCar car = new PassengeCar();
    GeneralDao<PassengeCar> daop = new GeneralDao<PassengeCar>(PassengeCar.class);
    
    private List<PassengeCar> passengeCars;

    public String gotoPassengerCar() {
        return "AddPassengerCar";
    }

    public String gotoDisplayAllPassengerCar() {
        return "DisplayAllPassengerCar";
    }
    public String gotoAdminDisplayAllPassengerCar() {
        return "AdminDisplayAllPassengerCar";
    }
    public String gotoUpdatePassengerCar(){
        return "UpdatePassengerCar";
    }
     public String gotoAdminUpdatePassengerCar(){
        return "AdminUpdatePassengerCar";
    }

    public List<PassengeCar> getAllPassengerCar() {
        return daop.findAll();
    }

    public String savePcar() {
        daop.insert(car);
        return "DisplayAllPassengerCar";
    }

    public void deletePcar() {
        daop.delete(car);
    }

    public String updatePassengerCar() {
        daop.update(car);
        return "DisplayAllPassengerCar";
    }
    public String adminupdatePassengerCar() {
        daop.update(car);
        return "AdminDisplayAllPassengerCar";
    }

    public PassengeCar getCar() {
        return car;
    }

    public void setCar(PassengeCar car) {
        this.car = car;
    }

    public List<PassengeCar> getPassengeCars() {
        return passengeCars;
    }

    public void setPassengeCars(List<PassengeCar> passengeCars) {
        this.passengeCars = passengeCars;
    }

}
