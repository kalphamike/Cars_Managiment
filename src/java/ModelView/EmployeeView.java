/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelView;

import Dao.GeneralDao;
import Models.Employee;
import Models.Gender;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author steve
 */
@ManagedBean(name = "AdminCreate")
@SessionScoped
public class EmployeeView {
    GeneralDao<Employee> daoe= new GeneralDao<Employee>(Employee.class);
    private Employee emp = new Employee();
    private List<Employee> empl;
    private List<Employee> emplist = new ArrayList<>();
    private String empMsg;
    
    public EmployeeView(){
        emplist = daoe.findAll();
    }
    
    public List<Employee> getAllEmployee(){
        return daoe.findAll();
    }

    public List<Employee> getEmpl() {
        return empl;
    }

    public void setEmpl(List<Employee> empl) {
        this.empl = empl;
    }
    
    
    
    public Employee findEmployee(){
        Employee emp1 = daoe.findById(emp.getEmpId());
        return emp1;
    }
    
    public String findUpdateEmployee(String id){
        daoe.findById(id);
        return "";
    }
    
    public void deleteEmployee(){
       daoe.delete(emp);
    }
    
    public String updateEmployee(){
        try {
            daoe.update(emp);
            clearAfterSave();
        } catch (Exception e) {
            empMsg = "Not updated";
        }
        return "DisplayAllEmployee";
    }
    public String adminUpdateEmp(){
        daoe.update(emp);
        clearAfterSave();
        return "AdminDisplayAllEmployee";
    }
    public String gotoAdminDispEmp(){
        return "AdminDisplayAllEmployee";
    }
    
    
  public String saveEmp(){
      daoe.insert(emp); 
      return "DisplayAllEmployee";
  }
    public String gotoEmployee(){
        return "Employee";
    }
    public String gotoUpdateEmployee(){
        return "UpdateEmployee";
    }
    public String gotoAdminUpdateEmp(String id){
        emp = daoe.findById(id);
        return "AdminUpdateEmployee";
    }
    public String getEmpMsg() {
        return empMsg;
    }

    public void setEmpMsg(String empMsg) {
        this.empMsg = empMsg;
    }
    
    public Employee getEmp() {
        return emp;
    }

    public void setEmp(Employee emp) {
        this.emp = emp;
    }
    public void clearAfterSave(){
    emp.setEmpId("");
    emp.setEmpName("");
    emp.setEmail("");
    emp.setGender(null);
    emp.setDate(null);
    }
   
}
