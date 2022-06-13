/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManageBean;

import client.VibeClient;
import ejb.VibeSessionBeanLocal;
import entity.User;
import entity.UserContactInfo;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author pooja
 */
@Named(value = "userinfoManagedBean")
@ApplicationScoped

public class UserInfoManagedBean {
    
    @EJB
    private VibeSessionBeanLocal vibeSessionBean;
    private final VibeClient vibeClient = new VibeClient();
    
    private String uci_id;
    private String userid;
    private String website;
    private String language;
    private String intrested_in;
    private String fb_link;
    private String insta_link;
    private String bio;

    public VibeSessionBeanLocal getVibeSessionBean() {
        return vibeSessionBean;
    }

    public void setVibeSessionBean(VibeSessionBeanLocal vibeSessionBean) {
        this.vibeSessionBean = vibeSessionBean;
    }

    public String getUci_id() {
        return uci_id;
    }

    public void setUci_id(String uci_id) {
        this.uci_id = uci_id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getIntrested_in() {
        return intrested_in;
    }

    public void setIntrested_in(String intrested_in) {
        this.intrested_in = intrested_in;
    }

    public String getFb_link() {
        return fb_link;
    }

    public void setFb_link(String fb_link) {
        this.fb_link = fb_link;
    }

    public String getInsta_link() {
        return insta_link;
    }

    public void setInsta_link(String insta_link) {
        this.insta_link = insta_link;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
    
    
    
    public UserInfoManagedBean()
    {
        
    }
    
    public List<UserContactInfo> showUserContactInfo() {
        
        HttpServletRequest requests = (HttpServletRequest) FacesContext.getCurrentInstance()
                    .getExternalContext().getRequest();
        HttpSession userSessions = requests.getSession();
        
        Response response = vibeClient.user_contact_info_FindByUserId(Response.class, userSessions.getAttribute("UuserId").toString());
        ArrayList<UserContactInfo> contactArrayList = new ArrayList<>();
        GenericType<List<UserContactInfo>> showAllcontact  = new GenericType<List<UserContactInfo>>() {
        };
        contactArrayList = (ArrayList<UserContactInfo>) response.readEntity(showAllcontact);
        return contactArrayList;
    }
    
    
    
}
