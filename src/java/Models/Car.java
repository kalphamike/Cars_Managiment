/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author steve
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE",
        discriminatorType = DiscriminatorType.STRING)
@AttributeOverride(name = "TYPE",
        column = @Column(name = "TYPE", nullable=false,
                insertable = false, updatable = false))
public abstract class Car {

    @Id
    private String plateNo;
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String model;
    private int manufureYear;
    @ManyToOne()
    @JoinColumn(name = "ownerId") 
    private Owner owner;
    @ManyToOne()
    @JoinColumn(name = "ownerName")
    private Owner ownername;
    @Enumerated(EnumType.STRING)
    private LocationByProvince locid;
    private Date regDate;
    @ManyToOne()
    @JoinColumn(name = "empId")
    private Employee employeeId;

    public Car() {
        
    }

    public Car(String plateNo, int id, String model, int manufureYear, Owner owner, Owner ownername, LocationByProvince locid, Date regDate, Employee employeeId) {
        this.plateNo = plateNo;
        this.id = id;
        this.model = model;
        this.manufureYear = manufureYear;
        this.owner = owner;
        this.ownername = ownername;
        this.locid = locid;
        this.regDate = regDate;
        this.employeeId = employeeId;
    }
    

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getManufureYear() {
        return manufureYear;
    }

    public void setManufureYear(int manufureYear) {
        this.manufureYear = manufureYear;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Owner getOwnername() {
        return ownername;
    }

    public void setOwnername(Owner ownername) {
        this.ownername = ownername;
    }

    public LocationByProvince getLocid() {
        return locid;
    }

    public void setLocid(LocationByProvince locid) {
        this.locid = locid;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }
    
    
}
