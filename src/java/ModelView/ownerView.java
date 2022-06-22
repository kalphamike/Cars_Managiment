/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelView;

import Dao.GeneralDao;
import Models.Owner;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


/**
 *
 * @author steve
 */
@ManagedBean(name = "AddOwner")
@SessionScoped
public class ownerView {
    private Owner owner = new Owner();
    GeneralDao<Owner> dao = new GeneralDao<Owner>(Owner.class);
    
    private List<Owner> owners;
    private List<Owner> ownerslist = new ArrayList<>();
    
    public String saveOwn(){
        try {
            
            dao.insert(owner);
         clearAfterSave();
          return "HomePage";
          
        } catch (Exception e) {
        }
      return "SetOwner";
    }
    public String gotosetowener(){
        return"SetOwner";
    }
    public void getownerCar(String id){
        owner = dao.findById(id);
    }
    
    public String gotoLogin(){
        
    return "LoginPage";
}
    public String gotoTruck(){
        return "AddTruckCar";
    }
    public List<Owner> getAllOwners(){
        return dao.findAll();
    }
    public void allallOwner(){
        owner.getOwnerId();
    }
    
    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public List<Owner> getOwners() {
        return owners;
    }

    public void setOwners(List<Owner> owners) {
        this.owners = owners;
    }
    
    
    
    public void clearAfterSave(){
   // owner.setOwnerId("");
    //owner.setOwnerName("");
    }
}
