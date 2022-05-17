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
import entity.UserContactInfo;
import entity.UserEducation;
import entity.UserSkills;
import entity.UserWork;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;
import javax.ws.rs.core.Response;

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
    public Country countryFindByName(String countryName); //admin
    public List<Country> countryShowAll(); //admin
    public List<Country> countryShowActive();
    
    //State
    public String stateInsert(int stateId, String stateName, boolean isActive, int countryId);
    public String stateUpdate(int stateId, String stateName, boolean isActive, int countryId);
    public String stateDelete(int stateId);
    public State stateFindById(int stateId);
    public State stateFindByName(String stateName); //admin
    public List<State> stateShowAll(); //admin
    public List<State> stateShowActive();
    
    //City
    public String cityInsert(int cityId, String cityName, boolean isActive, int stateId);
    public String cityUpdate(int cityId, String cityName, boolean isActive, int stateId);
    public String cityDelete(int cityId);
    public City cityFindById(int cityId);
    public City cityFindByName(String cityName); //admin
    public List<City> cityShowAll(); //admin
    public List<City> cityShowActive();
    
    //User
    public String userRegister(int userId, String firstName, String middleName, String lastName, String gender, Date dob, int pincode, String email, String username, String password, long mobile, String profilePhoto, String coverPhoto, boolean isActive, boolean isAdmin, boolean access, int countryId, int stateId, int cityId);
    public String userUpdate(int userId, String firstName, String middleName, String lastName, String gender, Date dob, int pincode, String email, String username, String password, long mobile, String profilePhoto, String coverPhoto, boolean isActive, boolean isAdmin, boolean access, int countryId, int stateId, int cityId);
    public String userDelete(int userId); //admin
    public User userFindById(int userId);
    public List<User> userFindByName(String userName);
    public List<User> userShowAll(); //admin
    public List<User> adminShowAll(); //admin
    
    //User_Contact_Info
    public String user_contact_info_Insert(int uciId, String website, String language, String intrested_in, String fb_link, String insta_link, String bio);
    public String user_contact_info_Update(int uciId, String website, String language, String intrested_in, String fb_link, String insta_link, String bio);
    public String user_contact_info_Delete(int uciId);
    public UserContactInfo user_contact_info_FindById(int uciId);
    public List<UserContactInfo> user_contact_info_ShowAll(); //admin
    
    //User_Education
    public String user_education_Insert(int ueId, String instituteName, Date joiningDate, Date endingDate, String instituteAddress, int userId);
    public String user_education_Update(int ueId, String instituteName, Date joiningDate, Date endingDate, String instituteAddress, int userId);
    public String user_education_Delete(int ueId);
    public UserEducation user_education_FindById(int ueId);
    public List<UserEducation> user_education_ShowAll(); //admin
    
    //User_Skills
    public String user_skills_Insert(int usId, String skillName, String skillInfo, String skillPortfolio, int userId);
    public String user_skills_Update(int usId, String skillName, String skillInfo, String skillPortfolio, int userId);
    public String user_skills_Delete(int usId);
    public UserSkills user_skills_FindById(int usId);
    public List<UserSkills> user_skills_ShowAll(); //admin
    
    //User_Work
    public String user_work_Insert(int uwId, String companyName, Date joiningDate, Date endingDate, String companyAddress, int userId);
    public String user_work_Update(int uwId, String companyName, Date joiningDate, Date endingDate, String companyAddress, int userId);
    public String user_work_Delete(int uwId);
    public UserWork user_work_FindById(int uwId);
    public List<UserWork> user_work_ShowALl();  //admin
    
    
    //Groups
    
    
}
