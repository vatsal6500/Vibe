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
 * @author LENOVO
 */
@Named(value = "userManagedBean")
@ApplicationScoped
public class UserManagedBean {

    @EJB
    private VibeSessionBeanLocal vibe;

    private User user = new User();
    private final VibeClient vibeClient = new VibeClient();
    
    private String userId;
    private String pincode;
    private String countryId;
    private String stateId;
    private String cityId;
    private String mobile;
    
    @NotNull(message = "FirstName Required")
    @Pattern(regexp = "[a-zA-Z]{3,30}", message = "Invalid First Name")
    private String firstName;
    private String middleName;
    
    @NotNull(message = "LastName Required")
    @Pattern(regexp = "[a-zA-Z]{3,30}", message = "Invalid Last Name")
    private String lastName;
    private String gender;
    
    @NotNull(message = "Email Required")
    @Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "Invalid Email")
    private String email;
    
    
    private String userName;
    
    @NotNull(message = "Password Required")
    private String password;
    
    private String profilePhoto;
    
    
    private String coverPhoto;
    
    @NotNull(message = "Date Required")
    @Past(message = "Invalid DOB")
    private Date dob;
    
    private String isActive;
    private String isAdmin;
    private String access;
    
    @AssertTrue(message = "Check Terms and Condition")
    private boolean accept;
    
    //checking value
    private boolean register,notRegister,usedEmail;
        
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
        isAdmin = "false";
        access = "true";
        userId = "0";
        accept = false;
        register = false;
        notRegister = false;
        usedEmail = false;
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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
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

    public boolean isAccept() {
        return accept;
    }

    public void setAccept(boolean accept) {
        this.accept = accept;
    }

    public boolean isRegister() {
        return register;
    }

    public void setRegister(boolean register) {
        this.register = register;
    }

    public boolean isNotRegister() {
        return notRegister;
    }

    public void setNotRegister(boolean notRegister) {
        this.notRegister = notRegister;
    }

    public boolean isUsedEmail() {
        return usedEmail;
    }

    public void setUsedEmail(boolean usedEmail) {
        this.usedEmail = usedEmail;
    }
    
    
    
    //Private Methods
    
    private void showAllVar() {
        System.out.println(firstName);
        System.out.println(lastName);
        System.out.println(email);
        System.out.println(password);
        System.out.println(isActive);
        System.out.println(access);
        System.out.println(isAdmin);
        System.out.println(dob);
        System.out.println(userId);
        System.out.println(accept);
    }
    
    private void clearAll() {
        setFirstName("");
        setLastName("");
        setEmail("");
        setPassword("");
        setDob(null);
        setAccept(false);
    }
    
    
    private void setFalse() {
        setRegister(false);
        setNotRegister(false);
        setUsedEmail(false);
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
    
    public boolean userRegister() {
        try {
            
            //showAllVar();
            
            if(accept) {
                
                //Parsing Date to String
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String DOB = dateFormat.format(dob);
                
                String Register = vibeClient.userRegister(userId, firstName, lastName, DOB, email, password, isActive, isAdmin, access);
                if(Register.equals("false")) {
                    setEmail("");
                    setUsedEmail(true);
                    return isUsedEmail();
                }
                clearAll();
                setFalse();
                return register = true;
                
            } else {
                setFalse();
                return accept = false;
            }
            
        } catch (ClientErrorException e) {
            
            System.out.println("Error:- " + e.getMessage());
            setFalse();
            return notRegister = true;
        }
    }
    
    
    
}
