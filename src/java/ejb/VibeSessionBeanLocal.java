/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.City;
import entity.Country;
import entity.State;
import entity.User;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author LENOVO
 */
@Local
public interface VibeSessionBeanLocal {
    
    //Country
    public String countryInsert(int countryId, String sortName, String countryName, int phoneCode, boolean isActive);
    public String countryUpdate(int countryId, String sortName, String countryName, int phoneCode, boolean isActive);
    public String countryDelete(int countryId);
    public Country countryFindById(int countryId);
    public Country countryFindByName(String countryName);
    public List<Country> countryShowAll();
    public List<Country> countryShowActive();
    
    //State
    public String stateInsert(int stateId, String stateName, boolean isActive, int countryId);
    public String stateUpdate(int stateId, String stateName, boolean isActive, int countryId);
    public String stateDelete(int stateId);
    public State stateFindById(int stateId);
    public State stateFindByName(String stateName);
    public List<State> stateShowAll();
    public List<State> stateShowActive();
    
    //City
    public String cityInsert(int cityId, String cityName, boolean isActive, int stateId);
    public String cityUpdate(int cityId, String cityName, boolean isActive, int stateId);
    public String cityDelete(int cityId);
    public City cityFindById(int cityId);
    public City cityFindByName(String cityName);
    public List<City> cityShowAll();
    public List<City> cityShowActive();
    
    //User
    public String userInsert(int userId, String firstName, String middleName, String lastName, String gender, Date dob, int pincode, String email, String username, String password, long mobile, String profilePhoto, String coverPhoto, boolean isActive, boolean isAdmin, boolean access, Date regDate, int countyrId, int stateId, int cityId);
    public String userUpdate(int userId, String firstName, String middleName, String lastName, String gender, Date dob, int pincode, String email, String username, String password, long mobile, String profilePhoto, String coverPhoto, boolean isActive, boolean isAdmin, boolean access, Date regDate, int countyrId, int stateId, int cityId);
    public String userDelete(int userId);
    public User userFindById(int userId);
    public List<User> userFindByName(String userName);
    public List<User> userShowAll();
    public List<User> adminShowAll();
    
}
