/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author steve
 */

@Entity
public class Employee  {

    @Id
   // @GeneratedValue(strategy = GenerationType.AUTO)
    private String empId;
    private String empName;
    private String email;
    private Date date;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @OneToOne(mappedBy = "employee")
    private UserAccount UserAccount;
    @OneToMany(mappedBy = "employeeId")
    private List<Car> cars;

    public Employee() {
    }

    public Employee(String empId, String empName, String email, Gender gender, Date date) {
        this.empId = empId;
        this.empName = empName;
        this.email = email;
        this.gender = gender;
        this.date = date;
    }

    public Employee(UserAccount UserAccount) {
        this.UserAccount = UserAccount;
    }

  
    
    public Employee(String empId) {
        this.empId = empId;
    }

   
    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public UserAccount getUserAccount() {
        return UserAccount;
    }

    public void setUserAccount(UserAccount UserAccount) {
        this.UserAccount = UserAccount;
    }
    
  

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
    
}
