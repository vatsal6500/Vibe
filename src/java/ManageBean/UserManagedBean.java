/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManageBean;

import client.VibeClient;
import ejb.VibeSessionBeanLocal;
import entity.City;
import entity.Country;
import entity.State;
import entity.User;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author LENOVO
 */
@Named(value = "userManagedBean")
@ApplicationScoped
public class UserManagedBean {

    @EJB
    private VibeSessionBeanLocal vibe;

    private User user = new User();
    private final VibeClient vibeClient = new VibeClient();
    
    private String userId, pincode, countryId,stateId,cityId;
    private String mobile;
    private String firstName, middleName, lastName, gender, email, userName, password, profilePhoto, coverPhoto;
    private String dob;
    private String isActive, isAdmin, access;
        
    private List<Country> countryList;
    private List<State> stateList;
    private List<City> cityList;
    private List<User> userList;
    
    /**
     * Creates a new instance of UserManagedBean
     */
    public UserManagedBean() {
        
    }
    
    @PostConstruct
    public void init() {
        isActive = "true";
        isAdmin = "true";
        access = "true";
        userId = "0";
        userList = vibe.userShowAll();
        countryList = vibe.countryShowActive();
        stateList = vibe.stateShowActive();
        cityList = vibe.cityShowActive();
    }

    public VibeSessionBeanLocal getVibe() {
        return vibe;
    }

    public void setVibe(VibeSessionBeanLocal vibe) {
        this.vibe = vibe;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getStateId() {
        return stateId;
    }

    public void setStateId(String stateId) {
        this.stateId = stateId;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public String getCoverPhoto() {
        return coverPhoto;
    }

    public void setCoverPhoto(String coverPhoto) {
        this.coverPhoto = coverPhoto;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public String getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(String isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }

    public List<Country> getCountryList() {
        return countryList;
    }

    public void setCountryList(List<Country> countryList) {
        this.countryList = countryList;
    }

    public List<State> getStateList() {
        return stateList;
    }

    public void setStateList(List<State> stateList) {
        this.stateList = stateList;
    }

    public List<City> getCityList() {
        return cityList;
    }

    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    
    
    //ManageBeans Methods
    
    public List<Country> countryShowActive() {
        Response response = vibeClient.countryShowActive(Response.class);
        ArrayList<Country> countryArrayList = new ArrayList<>();
        
        GenericType<List<Country>> countryGenericType = new GenericType<List<Country>>(){};
        countryArrayList = (ArrayList<Country>)response.readEntity(countryGenericType);
        
        return countryArrayList;
    }
    
    public List<State> stateShowActive() {
        Response response = vibeClient.stateShowActive(Response.class);
        ArrayList<State> stateArrayList = new ArrayList<>();
        
        GenericType<List<State>> stateGenericType = new GenericType<List<State>>(){};
        stateArrayList = (ArrayList<State>)response.readEntity(stateGenericType);
        
        return stateArrayList;
    }
    
    public List<City> cityShowActive() {
        Response response = vibeClient.cityShowActive(Response.class);
        ArrayList<City> cityArrayList = new ArrayList<>();
        
        GenericType<List<City>> cityGenericType = new GenericType<List<City>>(){};
        cityArrayList = (ArrayList<City>)response.readEntity(cityGenericType);
        
        return cityArrayList;
    }
    
    public String userInsert() {
        try {
            
            vibeClient.userRegister(userId, firstName, lastName, dob, email, password, isActive, isAdmin, access);
            return "User Inserted";
        } catch (ClientErrorException e) {
            
            return "Error:-    " + e.getMessage();
            
        }
    }
    
}
