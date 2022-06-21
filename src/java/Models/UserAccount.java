/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author steve
 */
@ManagedBean
@Entity
public class UserAccount implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int accId;
    private String userName;
    private String password;
    private String email;
    @OneToOne
    @JoinColumn(name = "empId")
    private Employee employee;

    public UserAccount() {
    }

    public UserAccount(int accId, String userName, String password, String email, Employee employee) {
        this.accId = accId;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.employee = employee;
    }

    public int getAccId() {
        return accId;
    }

    public void setAccId(int accId) {
        this.accId = accId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    
    
}
