/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelView;

import Dao.GeneralDao;
import Models.Employee;
import Models.UserAccount;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Mike
 */
@ManagedBean(name = "userlog")
@SessionScoped
public class UserAccountView {
    GeneralDao<UserAccount> daog = new GeneralDao<UserAccount>(UserAccount.class);
    GeneralDao<Employee> daoe = new GeneralDao<Employee>(Employee.class);
    private Employee employee = new Employee();
    
    
    private UserAccount account = new UserAccount();
    private String username ;
    private String password;
    
    
    public String saveAcc(){
        account.setEmployee(employee);
        daog.insert(account);
        clearAfterSave();
        return "LonginPage";
    }
    public String gotoLogin(){
        return"LoginPage";
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public UserAccount getAccount() {
        return account;
    }

    public void setAccount(UserAccount account) {
        this.account = account;
    }
    
    public List<UserAccount> getAllAccount(){
        return daog.findAll();
    }
    
    public UserAccount getUser(String username){
        List<UserAccount> list = daog.findAll();
        for (UserAccount Us : list) {
            if (Us.getUserName().equals(username)) {
                return Us;
            }
        }
        return null;
    }
    public String login() {
        try {
            
 //account =  daog.findById(username);
       UserAccount usa = getUser(account.getUserName());
         if( account.getUserName().equals("Admin") && account.getPassword().equals("0123")){
             return "HomePage"; 
         }
         else if(usa == null){
             return "LoginPage";
         }
         else if (usa.getPassword().equals(account.getPassword())) {
               HttpSession session = (HttpSession)FacesContext.getCurrentInstance()
                       .getExternalContext().getSession(true);
                //this.authenticatedUser = user;
                session.setAttribute("authenticatedUser", usa);
                return "TruckOrPassengerCar";
            } else {
                FacesMessage msg = new FacesMessage("Invalid username or password");
                FacesContext.getCurrentInstance().addMessage(null, msg);
                return "LoginPage";
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            FacesMessage msg = new FacesMessage("Invalid username or password");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return "LoginPage";
        }

    }
    public void clearAfterSave(){
    account.setUserName("");
    account.setPassword("");
    }


    
}
