/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainTesting;

import Dao.GeneralDao;
import Models.Car;
import Models.Employee;
import Models.Gender;
import Models.LocationByProvince;
import Models.Owner;
import Models.PassengeCar;
import Models.TruckCar;
import Models.UserAccount;
import Util.HibernateUtil;
import java.util.Date;
import org.hibernate.Session;


/**
 *
 * @author steve
 */
public class MyTesting {
    public static void main(String[] args){
//         HibernateUtil.getSessionFactory().openSession();
        GeneralDao<Owner> dao= new GeneralDao<Owner>(Owner.class);
        GeneralDao<Car> daoc= new GeneralDao<Car>(Car.class);
        GeneralDao<TruckCar> daot= new GeneralDao<TruckCar>(TruckCar.class);
        GeneralDao<PassengeCar> daop = new GeneralDao<PassengeCar>(PassengeCar.class);
        GeneralDao<LocationByProvince> daol = new GeneralDao<LocationByProvince>(LocationByProvince.class);
        GeneralDao<UserAccount> daoacc = new GeneralDao<UserAccount>(UserAccount.class);
        GeneralDao<Employee> daoem= new GeneralDao<Employee>(Employee.class);
        
        TruckCar tcar = new TruckCar();
        PassengeCar passengeCar = new PassengeCar();
        Owner o= new Owner();
        o.setOwnerId(0);
        o.setOwnerName("zezera");
        Employee e= new Employee("09876", "kali"," kali@gmail", Gender.MALE,new Date("11/02/2021"));
        UserAccount account = new UserAccount();
        account.setUserName("zeko");
        account.setEmail("zeko@Yahoo");
        account.setPassword("0123");
        account.setEmployee(e);
        dao.insert(o);
        daoem.insert(e);
        daoacc.insert(account);
        
        tcar.setLoadCapacity(1000.9);
        tcar.setModel("FUSO");
        tcar.setManufureYear(1989);
        tcar.setPlateNo("RAA342Y");
        tcar.setRegDate(new  Date("11/11/2021"));
        tcar.setOwner(o);
        tcar.setOwnername(o);
        
        tcar.setLocid(LocationByProvince.NORTHERN);
        daot.insert(tcar);

            passengeCar.setNumberOfPassanger("8");
            passengeCar.setLocid(LocationByProvince.SOUTHERN);
            passengeCar.setModel("V8");
            passengeCar.setPlateNo("RAW132I");
            passengeCar.setRegDate(new Date("08/11/2018"));
            passengeCar.setManufureYear(2000);
            
            daop.insert(passengeCar);
        
    }
}