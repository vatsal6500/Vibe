/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManageBean;

import client.VibeClient;
import ejb.VibeSessionBeanLocal;
import entity.User;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author LENOVO
 */
@Named(value = "loginManagedBean")
@ApplicationScoped
public class LoginManagedBean {

    @EJB
    private VibeSessionBeanLocal vibeSessionBean;
    
    private VibeClient vibeClient = new VibeClient();
    
    private String email;
    private String password;
    private boolean remember;
    
    
    //checking values
    private boolean deniedUser,invalidpass;

    
    
    
    /**
     * Creates a new instance of LoginManagedBean
     */
    public LoginManagedBean() {
        
    }
    
    @PostConstruct
    public void init() {
        deniedUser = false;
        invalidpass = false;
    }

    public VibeSessionBeanLocal getVibeSessionBean() {
        return vibeSessionBean;
    }

    public void setVibeSessionBean(VibeSessionBeanLocal vibeSessionBean) {
        this.vibeSessionBean = vibeSessionBean;
    }

    public VibeClient getVibeClient() {
        return vibeClient;
    }

    public void setVibeClient(VibeClient vibeClient) {
        this.vibeClient = vibeClient;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isRemember() {
        return remember;
    }

    public void setRemember(boolean remember) {
        this.remember = remember;
    }

    public boolean isDeniedUser() {
        return deniedUser;
    }

    public void setDeniedUser(boolean deniedUser) {
        this.deniedUser = deniedUser;
    }

    public boolean isInvalidpass() {
        return invalidpass;
    }

    public void setInvalidpass(boolean invalidpass) {
        this.invalidpass = invalidpass;
    }
    
    
    //Private Methods
    
    private void setFalse() {
        deniedUser = true;
        invalidpass = true;
    }
    
    
    //ManageBeans Methods
    
    public String vibeLogin(){
        
        try {
            
            Response response = vibeClient.vibeLogin(Response.class, email, password);
            
            System.out.println(response.hasEntity());
            System.out.println(response.toString());
            
            if(!response.hasEntity()) {
                invalidpass = true;
                return null;
            }
            
            GenericType<User> vibeLogin = new GenericType<User>(){};
            
            User users = response.readEntity(vibeLogin);
            
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance()
                    .getExternalContext().getRequest();
            
            if(users.getAccess() == false || users.getIsactive() == false) {
                deniedUser = true;
                return null;
            }
            
            if(users.getIsadmin()) {
                
                HttpSession adminSession = request.getSession();
                
                adminSession.setAttribute("AuserId", users.getUserid());
                adminSession.setAttribute("AfullName", users.getFirstname() + " " + users.getLastname());
                adminSession.setAttribute("Aonline", true);
                adminSession.setAttribute("Atype", users.getIsadmin());
                
                System.out.println(adminSession.getAttribute("AuserId").toString() + " " + 
                        adminSession.getAttribute("AfullName") + " " + 
                        adminSession.getAttribute("Aonline") + " " +
                        adminSession.getAttribute("Atype"));
                
                setFalse();
                return "/admin/home.xhtml?faces-redirect=true";
                
            }
            
            if(!users.getIsadmin()) {
                
                HttpSession userSession = request.getSession();
                
                userSession.setAttribute("UuserId", users.getUserid());
                userSession.setAttribute("UfullName", users.getFirstname() + " " + users.getLastname());
                userSession.setAttribute("Uonline", true);
                userSession.setAttribute("Utype", users.getIsadmin());
                
                System.out.println(userSession.getAttribute("UuserId").toString() + " " + 
                        userSession.getAttribute("UfullName") + " " + 
                        userSession.getAttribute("Uonline") + " " + 
                        userSession.getAttribute("Utype"));
                
                setFalse();
                return "/web/home.xhtml?faces-redirect=true";
                
            }
            
            
            
            
        } catch (ClientErrorException e) {
            
            System.out.println("Error:- " + e.getMessage());
            
            setFalse();
            return "/login.xhtml?faces-redirect=true";
            
        }
        
        System.out.println("Outside Exception");
        setFalse();
        return "/login.xhtml?faces-redirect=true";
    }
    
    public void vibeLogout() {
        
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        
        try {
            
            FacesContext.getCurrentInstance().getExternalContext().redirect("../login.xhtml");
            
        } catch (IOException e) {
            
            System.out.println(e.getMessage());
            
        }
    }
}
