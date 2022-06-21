/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelView;

import Dao.GeneralDao;
import Models.Car;
import Models.Owner;
import Models.TruckCar;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author steve
 */
@ManagedBean(name = "AddTruck")
@SessionScoped
public class TruckCarView {
    GeneralDao<TruckCar> daot= new GeneralDao<TruckCar>(TruckCar.class);
    GeneralDao<Car> daocar=new GeneralDao<Car>(Car.class);
    
    private TruckCar car = new TruckCar();
    private Owner owner = new Owner();
    private List<Car> cars;
    private List<TruckCar> tcars;
    
    public List<Car> getAllCarss(){
        return daocar.findAll();
    }
    public List<TruckCar> getAllTrucks(){
        return daot.findAll();
    }
    
    public String gotoCars(){
        return "DisplayAllCar";
    }
    public String gotoTruck(){
        return "AddTruckCar";
    }
    public String gotoUpdateTruck(){
        return "UpdateTruckCar";
    }
    public String gotoAdminDisplayTruck(){
        return "AdminDisplayAllTruckCars";
    }
    public String gotoAdminUpdateTruck(){
        return "AdminUpdateTruck";
    }
    public String gotoDisplayAllTrucks(){
        return "DisplayAllTrucks";
    }
    public String gotoTruckOrPass(){
        return "TruckOrPassengerCar";
    }
    public String saveTruck(){
        daot.insert(car); 
        return "DisplayAllTrucks";
    }
    public void deleteTruck(){
        daot.delete(car);
    }
    public String updateTruck(){
        daot.update(car);
        return "DisplayAllTrucks";
    }
    public String adminupdateTruck(){
        daot.update(car);
        return "AdminDisplayAllTruck";
    }
    

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    
    public List<TruckCar> getTcars() {
        return tcars;
    }

    public void setTcars(List<TruckCar> tcars) {
        this.tcars = tcars;
    }
    
    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
    
    public TruckCar getCar() {
        return car;
    }

    public void setCar(TruckCar car) {
        this.car = car;
    }
}
