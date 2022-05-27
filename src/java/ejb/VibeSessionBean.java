/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.ActivityFeed;
import entity.Ads;
import entity.AdsUser;
import entity.City;
import entity.Comments;
import entity.Country;
import entity.EventUsercount;
import entity.Events;
import entity.FriendList;
import entity.FriendRequest;
import entity.GroupMembers;
import entity.Groups;
import entity.Likes;
import entity.Post;
import entity.State;
import entity.User;
import entity.UserContactInfo;
import entity.UserEducation;
import entity.UserSkills;
import entity.UserWork;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import utility.HashUtility;

/**
 *
 * @author LENOVO
 */
@Stateless
public class VibeSessionBean implements VibeSessionBeanLocal {

    @PersistenceContext(unitName = "VibePU")
    EntityManager em;
    HashUtility hashPassword;
    
    
    @PostConstruct
    public void init() {
        hashPassword = new HashUtility();
    }
    
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    
    //DONE
    //Country
    
    @Override
    public String countryInsert(int countryId, String sortName, String countryName, int phoneCode, boolean isActive) {
        
        Object id = null;
        
        try {
            
            try {
                    id = em.createNamedQuery("Country.findIdByCountryname")
                    .setParameter("countryname", countryName)
                    .getSingleResult();
                    
                    System.out.println(id);
                    
            } catch (Exception e) {
                
                Country c = new Country(countryId,sortName,countryName,phoneCode, isActive);
                em.persist(c);
                
            }
            
            if(id != null) {
                Country c = em.find(Country.class, id);
                boolean active = c.getIsactive();
                if(!active) {
                    c.setIsactive(true);
                    em.merge(c);
                }
            }
            
            
            return "Country Inserted " + String.valueOf(id);
            
        } catch (Exception e) {
            
            return e.getMessage();
            
        }
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String countryUpdate(int countryId, String sortName, String countryName, int phoneCode, boolean isActive) {
        
        try {
            
            Country c = em.find(Country.class, countryId);
            
            if(c == null) {
               return "ID does not exist " + String.valueOf(countryId);
            }
            
            c.setCountryid(countryId);
            c.setSortname(sortName);
            c.setCountryname(countryName);
            c.setPhonecode(phoneCode);
            c.setIsactive(isActive);
            
            em.merge(c);
            return "Country Updated";
            
        } catch (Exception e) {
            
            return e.getMessage();
            
        }
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String countryDelete(int countryId) {
        
        try {
            
            Country c = em.find(Country.class, countryId);
            
            if(c == null) {
               return "ID does not exist " + String.valueOf(countryId);
            }
            
            c.setIsactive(false);
            em.merge(c);
            
            return "Country Deleted";
            
        } catch (Exception e) {
            
            return e.getMessage();
            
        }
        

        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Country countryFindById(int countryId) {
        
        try {
            
            Country c = em.find(Country.class,countryId);
            return c;
            
        } catch (Exception e) {
            
            e.getMessage();
            return null;
            
        }
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Country countryFindByName(String countryName) {
        
        try {
                
            return (Country) em.createNamedQuery("Country.findByCountryname")
                .setParameter("countryname", countryName)
                .getSingleResult();
            
        } catch (Exception e) {
            
            System.out.println(e.getMessage());
            return null;
        }
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Country> countryShowAll() {
        
        try {
            
            return em.createNamedQuery("Country.findAll")
                    .getResultList();
            
        } catch (Exception e) {
            
            e.getMessage();
            return null;
            
        }
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<Country> countryShowActive() {
        
        try {
            
            return em.createNamedQuery("Country.findByIsactive")
                    .setParameter("isactive", true)
                    .getResultList();
            
        } catch (Exception e) {
            
            e.getMessage();
            return null;
            
        }
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    //State

    @Override
    public String stateInsert(int stateId, String stateName, boolean isActive, int countryId) {
        
        try {
            
            Country country = em.find(Country.class, countryId);
            Collection<State> sc = country.getStateCollection();
            
            State s = new State();
            
            s.setStateid(stateId);
            s.setStatename(stateName);
            s.setIsactive(isActive);
            s.setCountryid(country);
            
            sc.add(s);
            country.setStateCollection(sc);
            
            em.persist(s);
            em.merge(country);
            
            return "State Inserted";
            
        } catch (Exception e) {
            
            return e.getMessage();
            
        }
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String stateUpdate(int stateId, String stateName, boolean isActive, int countryId) {
        
        try {
            
            Country c = em.find(Country.class, countryId);
            Collection<State> sc = c.getStateCollection();
            
            State s = em.find(State.class, stateId);
            
            s.setStateid(stateId);
            s.setStatename(stateName);
            s.setIsactive(isActive);
            s.setCountryid(c);
            
            sc.add(s);
            c.setStateCollection(sc);
            
            em.persist(s);
            em.merge(c);
            
            return "State Updated";
            
        } catch (Exception e) {
            
            return e.getMessage();
            
        }
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String stateDelete(int stateId) {
        
        try {
            
            State s = em.find(State.class, stateId);
            s.setIsactive(false);
            em.merge(s);
            
            return "State Deleted";
            
        } catch (Exception e) {
            
            return e.getMessage();
            
        }
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public State stateFindById(int stateId) {
        
        try {
            
            return em.find(State.class, stateId);
            
        } catch (Exception e) {
            
            e.getMessage();
            return null;
        }
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public State stateFindByName(String stateName) {
        
        try {
            
            return  (State) em.createNamedQuery("State.findByStatename")
                    .setParameter("statename", stateName)
                    .getSingleResult();
            
        } catch (Exception e) {
            
            return null;
        }
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<State> stateShowAll() {
        
        try {
            
            return em.createNamedQuery("State.findAll")
                    .getResultList();
            
        } catch (Exception e) {
            
            e.getMessage();
            return null;
            
        }
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<State> stateShowActive() {
        
        try {
            
            return em.createNamedQuery("State.findByIsactive")
                    .setParameter("isactive", true)
                    .getResultList();
            
        } catch (Exception e) {
            
            e.getMessage();
            return null;
            
        }
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    //City
    
    @Override
    public String cityInsert(int cityId, String cityName, boolean isActive, int stateId) {
        
        try {
            
            State s = em.find(State.class, stateId);
            Collection<City> cc = s.getCityCollection();
            
            City c = new City();
            
            c.setCityid(cityId);
            c.setCityname(cityName);
            c.setIsactive(isActive);
            c.setStateid(s);
            
            cc.add(c);
            s.setCityCollection(cc);
            
            em.persist(c);
            em.merge(s);
            
            return "City Inserted";
            
        } catch (Exception e) {
            
            return e.getMessage();
            
        }
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String cityUpdate(int cityId, String cityName, boolean isActive, int stateId) {
        
        try {
            
            State s = em.find(State.class, stateId);
            Collection<City> cc = s.getCityCollection();
            
            City c = em.find(City.class, cityId);
            
            c.setCityid(cityId);
            c.setCityname(cityName);
            c.setIsactive(isActive);
            c.setStateid(s);
            
            cc.add(c);
            s.setCityCollection(cc);
            
            em.persist(c);
            em.merge(s);
            
            return "City Updated";
            
        } catch (Exception e) {
            
            return e.getMessage();
            
        }
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String cityDelete(int cityId) {
        
        try {
            
            City c = em.find(City.class, cityId);
            em.remove(c);
            return "City Deleted";
            
        } catch (Exception e) {
            
            return e.getMessage();
            
        }
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public City cityFindById(int cityId) {
        
        try {
            
            return em.find(City.class, cityId);
            
        } catch (Exception e) {
            
            return null;
            
        }
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public City cityFindByName(String cityName) {
        
        try {
            
            return  (City) em.createNamedQuery("City.findByCityname")
                    .setParameter("cityname", cityName)
                    .getSingleResult();
            
        } catch (Exception e) {
            
            return null;
        }
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<City> cityShowAll() {
        
        try {
            
            return em.createNamedQuery("City.findAll")
                    .getResultList();
            
        } catch (Exception e) {
            
            return null;
            
        }

        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<City> cityShowActive() {
        
        try {
            
            return em.createNamedQuery("City.findByIsactive")
                    .setParameter("isactive", true)
                    .getResultList();
            
        } catch (Exception e) {
            
            return null;
            
        }
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    //User

    @Override
    public String userRegister(int userId, String firstName, String lastName, String dob, String email, String password, boolean isActive, boolean isAdmin, boolean access) {
        
        boolean userRegister = false;
        
        try {
            
            List<User> emailList = em.createNamedQuery("User.findAllEmail")
                    .getResultList();
                        
            if(!emailList.isEmpty()) {
                
                System.out.println(emailList);
                
                for(User userMail : emailList) {
                    if(email.equals(userMail.getEmail())) {
                        return "false";
                    } else {
                        userRegister = true;
                    }
                    
                }
            }
            
            if(userRegister) {
                //parsing string-date to Date
                Date DOB = new SimpleDateFormat("yyyy-MM-dd").parse(dob);
                User user = new User(userId,firstName,lastName,DOB,email,hashPassword.getHashPassword(password),isActive,isAdmin,access);
                em.persist(user);
                System.out.println("User Registered");
                return "User Registered";
            }
            System.out.println("Not Registered");
            return "Not Registered";
            
        } catch (Exception e) {
            
            return "error:-   " + e.getMessage();
            
        }
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String userUpdate(int userId, String firstName, String middleName, String lastName, String gender, Date dob, int pincode, String email, String username, String password, long mobile, String profilePhoto, String coverPhoto, boolean isActive, boolean isAdmin, boolean access, int countryId, int stateId, int cityId) {
        
        try {
            
            
            
            return "User Updated";
            
        } catch (Exception e) {
            
            return e.getMessage();
            
        }
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String userDelete(int userId) {
        
        try {
            
            User user = em.find(User.class, userId);
            user.setIsactive(false);
            em.merge(user);
            
            return "User Deleted";
            
        } catch (Exception e) {
            
            return e.getMessage();
            
        }
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User userFindById(int userId) {
        
        try {
            
            User user = em.find(User.class,userId);
            
            return user;
            
        } catch (Exception e) {
            
            return null;
            
        }
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> userShowAll() {
        
        try {
            
            List<User> user = em.createNamedQuery("User.findAll")
                    .getResultList();
            
            return user;
            
        } catch (Exception e) {
            
            return null;
            
        }
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<User> adminShowAll() {
        
        try {
            
            List<User> user = em.createNamedQuery("User.findByIsadmin")
                    .setParameter("isadmin", true)
                    .getResultList();
            return user;
            
        } catch (Exception e) {
            
            return null;
            
        }
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> userFindByName(String userName) {
        
        try {
            
            return em.createNamedQuery("User.findByFirstname")
                    .setParameter("firstname", userName)
                    .getResultList();
            
        } catch (Exception e) {
            
            System.out.println(e.getMessage());
            return null;
            
        }
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    //User_Contact_Info

    @Override
    public String user_contact_info_Insert(int uciId, String website, String language, String intrested_in, String fb_link, String insta_link, String bio, int userId) {
        
        try {
            
            User u = em.find(User.class, userId);
            Collection<UserContactInfo> ucic = u.getUserContactInfoCollection();
            
            UserContactInfo uci = new UserContactInfo();
            
            uci.setUciId(uciId);
            uci.setUserid(u);
            uci.setWebsite(website);
            uci.setLanguage(language);
            uci.setIntrestedIn(intrested_in);
            uci.setFbLink(fb_link);
            uci.setInstaLink(insta_link);
            uci.setBio(bio);
            
            ucic.add(uci);
            u.setUserContactInfoCollection(ucic);
           
            
            em.persist(uci);
            em.merge(u);
            
            return "User Contact Info Inserted";
            
        } catch (Exception e) {
            return e.getMessage();
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String user_contact_info_Update(int uciId, String website, String language, String intrested_in, String fb_link, String insta_link, String bio, int userId) {
        
        try {
            
            User u = em.find(User.class, userId);
            Collection<UserContactInfo> ucic = u.getUserContactInfoCollection();
            
            UserContactInfo uci = em.find(UserContactInfo.class, uciId);
            
            uci.setUciId(uciId);
            uci.setUserid(u);
            uci.setWebsite(website);
            uci.setLanguage(language);
            uci.setIntrestedIn(intrested_in);
            uci.setFbLink(fb_link);
            uci.setInstaLink(insta_link);
            uci.setBio(bio);
            
            ucic.add(uci);
            u.setUserContactInfoCollection(ucic);
           
            
            em.persist(uci);
            em.merge(u);
            
            return "User Contact Info Updated";
            
        } catch (Exception e) {
            return e.getMessage();
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String user_contact_info_Delete(int uciId) {
        
        try {
            
            UserContactInfo uci = em.find(UserContactInfo.class, uciId);
            em.remove(uci);
            return "User Contact Info Deleted";
            
        } catch (Exception e) {
            
            return e.getMessage();
            
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UserContactInfo user_contact_info_FindById(int uciId) {
        
        try {
            
            UserContactInfo uci = em.find(UserContactInfo.class,uciId);
            
            return uci;
            
        } catch (Exception e) {
            
            return null;
            
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<UserContactInfo> user_contact_info_ShowAll() {
        
        try {
            
            List<UserContactInfo> user = em.createNamedQuery("UserContactInfo.findAll")
                    .getResultList();
            
            return user;
            
        } catch (Exception e) {
            
            return null;
            
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    //User_Education

    @Override
    public String user_education_Insert(int ueId, String instituteName, String joiningDate, String endingDate, String instituteAddress, int userId) {
        
        try {
            
            Date jdate = new SimpleDateFormat("yyyy-MM-dd").parse(joiningDate);
            Date edate = new SimpleDateFormat("yyyy-MM-dd").parse(endingDate);
            
            User u = em.find(User.class, userId);
            Collection<UserEducation> uec = u.getUserEducationCollection();
            
            UserEducation ue = new UserEducation();
            
            ue.setUeId(ueId);
            ue.setUserid(u);
            ue.setInstitutename(instituteName);
            ue.setJoiningdate(jdate);
            ue.setEndingdate(edate);
            ue.setInstituteaddress(instituteAddress);
            
            uec.add(ue);
            u.setUserEducationCollection(uec);
           
            em.persist(ue);
            em.merge(u);
            
            return "User Education Info Inserted";
            
        } catch (Exception e) {
            return e.getMessage();
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String user_education_Update(int ueId, String instituteName, String joiningDate, String endingDate, String instituteAddress, int userId) {
        
        try {
            
            Date jdate = new SimpleDateFormat("yyyy-MM-dd").parse(joiningDate);
            Date edate = new SimpleDateFormat("yyyy-MM-dd").parse(endingDate);
            
            User u = em.find(User.class, userId);
            Collection<UserEducation> uec = u.getUserEducationCollection();
            
            UserEducation ue = em.find(UserEducation.class, ueId);
            
            ue.setUeId(ueId);
            ue.setUserid(u);
            ue.setInstitutename(instituteName);
            ue.setJoiningdate(jdate);
            ue.setEndingdate(edate);
            ue.setInstituteaddress(instituteAddress);
            
            uec.add(ue);
            u.setUserEducationCollection(uec);
           
            em.persist(ue);
            em.merge(u);
            
            return "User Education Info Updated";
            
        } catch (Exception e) {
            return e.getMessage();
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String user_education_Delete(int ueId) {
        
         try {
            
            UserEducation ue = em.find(UserEducation.class, ueId);
            em.remove(ue);
            return "User Education Info Deleted";
            
        } catch (Exception e) {
            
            return e.getMessage();
            
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UserEducation user_education_FindById(int ueId) {
        
        try {
            
            UserEducation ue = em.find(UserEducation.class,ueId);
            
            return ue;
            
        } catch (Exception e) {
            
            return null;
            
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<UserEducation> user_education_ShowAll() {
        
         try {
            
            List<UserEducation> user = em.createNamedQuery("UserEducation.findAll")
                    .getResultList();
            
            return user;
            
        } catch (Exception e) {
            
            return null;
            
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    //User_Skills

    @Override
    public String user_skills_Insert(int usId, String skillName, String skillInfo, String skillPortfolio, int userId) {
        
        try {
            
            User u = em.find(User.class, userId);
            Collection<UserSkills> usc = u.getUserSkillsCollection();
            
            UserSkills us = new UserSkills();
            
            us.setUsId(usId);
            us.setUserid(u);
            us.setSkillname(skillName);
            us.setSkillinfo(skillInfo);
            us.setSkillportfolio(skillPortfolio);
            
            usc.add(us);
            u.setUserSkillsCollection(usc);
           
            em.persist(us);
            em.merge(u);
            
            return "User Skill Inserted";
            
        } catch (Exception e) {
            return e.getMessage();
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String user_skills_Update(int usId, String skillName, String skillInfo, String skillPortfolio, int userId) {
        
        try {
            
            User u = em.find(User.class, userId);
            Collection<UserSkills> usc = u.getUserSkillsCollection();
            
            UserSkills us = em.find(UserSkills.class, usId);
            
            us.setUsId(usId);
            us.setUserid(u);
            us.setSkillname(skillName);
            us.setSkillinfo(skillInfo);
            us.setSkillportfolio(skillPortfolio);
            
            usc.add(us);
            u.setUserSkillsCollection(usc);
           
            em.persist(us);
            em.merge(u);
            
            return "User Skill Updated";
            
        } catch (Exception e) {
            return e.getMessage();
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String user_skills_Delete(int usId) {
        
        try {
            
            UserSkills us = em.find(UserSkills.class, usId);
            em.remove(us);
            return "User Skill Deleted";
            
        } catch (Exception e) {
            
            return e.getMessage();
            
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UserSkills user_skills_FindById(int usId) {
        
        try {
            
            UserSkills us = em.find(UserSkills.class,usId);
            
            return us;
            
        } catch (Exception e) {
            
            return null;
            
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<UserSkills> user_skills_ShowAll() {
        
        try {
            
            List<UserSkills> user = em.createNamedQuery("UserSkills.findAll")
                    .getResultList();
            
            return user;
            
        } catch (Exception e) {
            
            return null;
            
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    //User_Work

    @Override
    public String user_work_Insert(int uwId, String companyName, String joiningDate, String endingDate, String companyAddress, int userId) {
        
        try {
            
            Date jdate = new SimpleDateFormat("yyyy-MM-dd").parse(joiningDate);
            Date edate = new SimpleDateFormat("yyyy-MM-dd").parse(endingDate);
            
            User u = em.find(User.class, userId);
            Collection<UserWork> uwc = u.getUserWorkCollection();
            
            UserWork uw = new UserWork();
            
            uw.setUwId(uwId);
            uw.setUserid(u);
            uw.setCompanyname(companyName);
            uw.setJoiningdate(jdate);
            uw.setEndingdate(edate);
            uw.setCompanyaddress(companyAddress);
            
            uwc.add(uw);
            u.setUserWorkCollection(uwc);
           
            em.persist(uw);
            em.merge(u);
            
            return "User Work Inserted";
            
        } catch (Exception e) {
            return e.getMessage();
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String user_work_Update(int uwId, String companyName, String joiningDate, String endingDate, String companyAddress, int userId) {
        
        try {
            
            Date jdate = new SimpleDateFormat("yyyy-MM-dd").parse(joiningDate);
            Date edate = new SimpleDateFormat("yyyy-MM-dd").parse(endingDate);
            
            User u = em.find(User.class, userId);
            Collection<UserWork> uwc = u.getUserWorkCollection();
            
            UserWork uw = em.find(UserWork.class, uwId);
            
            uw.setUwId(uwId);
            uw.setUserid(u);
            uw.setCompanyname(companyName);
            uw.setJoiningdate(jdate);
            uw.setEndingdate(edate);
            uw.setCompanyaddress(companyAddress);
            
            uwc.add(uw);
            u.setUserWorkCollection(uwc);
           
            em.persist(uw);
            em.merge(u);
            
            return "User Work Updated";
            
        } catch (Exception e) {
            return e.getMessage();
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String user_work_Delete(int uwId) {
        
        try {
            
            UserWork uw = em.find(UserWork.class, uwId);
            em.remove(uw);
            return "User Work Deleted";
            
        } catch (Exception e) {
            
            return e.getMessage();
            
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UserWork user_work_FindById(int uwId) {
        
         try {
            
            UserWork uw = em.find(UserWork.class,uwId);
            
            return uw;
            
        } catch (Exception e) {
            
            return null;
            
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<UserWork> user_work_ShowALl() {
        
        try {
            
            List<UserWork> user = em.createNamedQuery("UserWork.findAll")
                    .getResultList();
            
            return user;
            
        } catch (Exception e) {
            
            return null;
            
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    //Groups

    @Override
    public String groupInsert(int groupId, String groupName, String description, int membersCount, boolean isDeleted, int adminId) {
        
        try {
           
            
            User u = em.find(User.class, adminId);
            Collection<Groups> gc = u.getGroupsCollection();
            
            Groups g = new Groups();
            
            g.setGroupid(groupId);
            g.setAdminid(u);
            g.setGroupname(groupName);
            g.setDescription(description);
            g.setMemberscount(membersCount);
            g.setIsDeleted(isDeleted);
            
            gc.add(g);
            u.setGroupsCollection(gc);
           
            em.persist(g);
            em.merge(u);
            
            return "Group Created";
            
        } catch (Exception e) {
            return e.getMessage();
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String groupUpdate(int groupId, String groupName, String description, int membersCount, boolean isDeleted, int adminId) {
        
        try {
           
            
            User u = em.find(User.class, adminId);
            Collection<Groups> gc = u.getGroupsCollection();
            
            Groups g = em.find(Groups.class, groupId);
            
            g.setGroupid(groupId);
            g.setAdminid(u);
            g.setGroupname(groupName);
            g.setDescription(description);
            g.setMemberscount(membersCount);
            g.setIsDeleted(isDeleted);
            
            gc.add(g);
            u.setGroupsCollection(gc);
           
            em.persist(g);
            em.merge(u);
            
            return "Group Updated";
            
        } catch (Exception e) {
            return e.getMessage();
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String groupDelete(int groupId) {
        
        try {
            
            Groups g = em.find(Groups.class, groupId);
            em.remove(g);
            return "Group Deleted";
            
        } catch (Exception e) {
            
            return e.getMessage();
            
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Groups groupFindById(int groupId) {
        
        try {
            
            Groups g = em.find(Groups.class,groupId);
            
            return g;
            
        } catch (Exception e) {
            
            return null;
            
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Groups> groupShowAll() {
        
        try {
            
            List<Groups> group = em.createNamedQuery("Groups.findAll")
                    .getResultList();
            
            return group;
            
        } catch (Exception e) {
            
            return null;
            
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    //Group_Members

    @Override
    public String group_member_Insert(int gmId, boolean isMember, String becameMember, int groupId, int memberId) {
        
        try {
           
            Date mdate = new SimpleDateFormat("yyyy-MM-dd").parse(becameMember);
            
            User u = em.find(User.class, memberId);
            Groups g  = em.find(Groups.class, groupId);
            
            Collection<GroupMembers> gmuc = u.getGroupMembersCollection();
            Collection<GroupMembers> gmgc = g.getGroupMembersCollection();
            
            GroupMembers gm = new GroupMembers();
            
            gm.setGmId(gmId);
            gm.setIsMember(isMember);
            gm.setBecamemember(mdate);
            gm.setGroupid(g);
            gm.setMemberid(u);
            
            
            gmuc.add(gm);
            gmgc.add(gm);
            u.setGroupMembersCollection(gmuc);
            g.setGroupMembersCollection(gmgc);
           
            em.persist(g);
            em.merge(u);
            em.merge(g);
            
            return "Group Member Inserted";
            
        } catch (Exception e) {
            return e.getMessage();
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String group_member_Update(int gmId, boolean isMember, String becameMember, int groupId, int memberId) {
        
        try {
           
            Date mdate = new SimpleDateFormat("yyyy-MM-dd").parse(becameMember);
            
            User u = em.find(User.class, memberId);
            Groups g  = em.find(Groups.class, groupId);
            
            Collection<GroupMembers> gmuc = u.getGroupMembersCollection();
            Collection<GroupMembers> gmgc = g.getGroupMembersCollection();
            
            GroupMembers gm = em.find(GroupMembers.class, gmId);
            
            gm.setGmId(gmId);
            gm.setIsMember(isMember);
            gm.setBecamemember(mdate);
            gm.setGroupid(g);
            gm.setMemberid(u);
            
            
            gmuc.add(gm);
            gmgc.add(gm);
            u.setGroupMembersCollection(gmuc);
            g.setGroupMembersCollection(gmgc);
           
            em.persist(g);
            em.merge(u);
            em.merge(g);
            
            return "Group Member Updated";
            
        } catch (Exception e) {
            return e.getMessage();
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String group_member_Delete(int gmId) {
        
        try {
            
            GroupMembers g = em.find(GroupMembers.class, gmId);
            em.remove(g);
            return "Group Member Removed";
            
        } catch (Exception e) {
            
            return e.getMessage();
            
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GroupMembers group_member_FindById(int gmId) {
        
        try {
            
            GroupMembers g = em.find(GroupMembers.class,gmId);
            
            return g;
            
        } catch (Exception e) {
            
            return null;
            
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<GroupMembers> group_member_ShowAll() {
        
        try {
            
            List<GroupMembers> group = em.createNamedQuery("GroupMembers.findAll")
                    .getResultList();
            
            return group;
            
        } catch (Exception e) {
            
            return null;
            
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    //Posts

    @Override
    public String postInsert(int postId, String post, String caption, boolean is_deleted, int likeCount, int userId, int groupId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String postUpdate(int postId, String post, String caption, boolean is_deleted, int likeCount, int userId, int groupId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String postDelete(int postId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Post postFindById(int postId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Post> postShowAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    //Likes

    @Override
    public String likeInsert(int likeId, String likeDate, boolean isRemoved, int postId, int senderId, int receiverId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String likeUpdate(int likeId, String likeDate, boolean isRemoved, int postId, int senderId, int receiverId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String likeDelete(int likeId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Likes likeFindById(int likeId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Likes> likeShowAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    //Friend_Request

    @Override
    public String friend_request_Insert(int frId, String status, int senderId, int receiverId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String friend_request_Update(int frId, String status, int senderId, int receiverId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String friend_request_Delete(int frId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public FriendRequest friend_request_FindById(int frId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<FriendRequest> friend_request_ShowAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    //Friend_List

    @Override
    public String friend_list_Insert(int flId, String acceptedDateTime, boolean friendStatus, int userId, int friendId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String friend_list_Update(int flId, String acceptedDateTime, boolean friendStatus, int userId, int friendId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String friend_list_Delete(int flId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public FriendList friend_list_FindById(int flId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<FriendList> friend_list_ShowAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    //Events

    @Override
    public String eventInsert(int eventId, String eventName, String post, Date eventStartDate, Date eventEndDate, String eventInfo, String venue, String type, int fees, String mode, int guestCount, boolean is_removed, int hostId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String eventUpdate(int eventId, String eventName, String post, Date eventStartDate, Date eventEndDate, String eventInfo, String venue, String type, int fees, String mode, int guestCount, boolean is_removed, int hostId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String eventDelete(int eventId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Events eventFindById(int eventId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Events> eventShowAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    //Events_UserCount
    
    @Override
    public String event_usercount_Insert(int euc_Id, boolean isIntrested, int eventId, int userId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String event_usercount_Update(int euc_Id, boolean isIntrested, int eventId, int userId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String event_usercount_Delete(int euc_Id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public EventUsercount event_usercount_FindById(int euc_Id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<EventUsercount> event_usercount_ShowAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    //Comments

    @Override
    public String commentsInsert(int commentId, String comment, boolean isRemoved, int postId, int senderId, int receiverId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String commentsUpdate(int commentId, String comment, boolean isRemoved, int postId, int senderId, int receiverId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String commentsdelete(int commentId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Comments commentsFindById(int commentId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Comments> commentsInsert() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    //Chats

    @Override
    public String chatInsert(int chatId, String message, boolean isDelevered, boolean isRead, boolean isDeleted, int senderId, int receiverId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String chatDelete(int chatId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    //Ads_User

    @Override
    public String ads_user_Insert(int auId, String adsConcent, String description, String link, String endDate, boolean isRemoved, boolean isExpried, int userId, int adsId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String ads_user_Update(int auId, String adsConcent, String description, String link, String endDate, boolean isRemoved, boolean isExpried, int userId, int adsId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String ads_user_Delete(int auId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AdsUser ads_user_FindById(int auId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<AdsUser> ads_user_ShowAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    //Ads

    @Override
    public String adsInsert(int adsId, String adsType, int price, String timeLimit, String description, boolean isRemoved) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String adsUpdate(int adsId, String adsType, int price, String timeLimit, String description, boolean isRemoved) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String adsDelete(int adsId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Ads adsFindById(int adsId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Ads> adsShowAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    //Activity_Feed
    
    @Override
    public String activity_feed_Insert(int afId, String senderMsg, String receiverMsg, String targerURL, boolean isRead, boolean isDeleted, int senderId, int receiverId, int groupId) {
        
        try {
            
            User s = em.find(User.class, senderId);
            User r = em.find(User.class, receiverId);
            Groups g  = em.find(Groups.class, groupId);
            
            Collection<ActivityFeed> gmsc = s.getActivityFeedCollection();
            Collection<ActivityFeed> gmrc = r.getActivityFeedCollection();
            Collection<ActivityFeed> gmgc = g.getActivityFeedCollection();
            
            ActivityFeed af = new ActivityFeed();
            
            af.setAfId(afId);
            af.setSendermessage(senderMsg);
            af.setReceivermessage(receiverMsg);
            af.setTargetUrl(targerURL);
            af.setIsRead(isRead);
            af.setIsDeleted(isDeleted);
            af.setSenderid(r);
            af.setReceiverid(r);
            af.setGroupid(g);
            
            
            gmsc.add(af);
            gmrc.add(af);
            gmgc.add(af);
            s.setActivityFeedCollection(gmsc);
            r.setActivityFeedCollection(gmrc);
            g.setActivityFeedCollection(gmgc);
           
            em.persist(af);
            em.merge(s);
            em.merge(r);
            em.merge(g);
            
            return "Activity Feed Inserted";
            
        } catch (Exception e) {
            return e.getMessage();
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String activity_feed_Update(int afId, String senderMsg, String receiverMsg, String targerURL, boolean isRead, boolean isDeleted, int senderId, int receiverId, int groupId) {
        
        try {
            
            User s = em.find(User.class, senderId);
            User r = em.find(User.class, receiverId);
            Groups g  = em.find(Groups.class, groupId);
            
            Collection<ActivityFeed> gmsc = s.getActivityFeedCollection();
            Collection<ActivityFeed> gmrc = r.getActivityFeedCollection();
            Collection<ActivityFeed> gmgc = g.getActivityFeedCollection();
            
            ActivityFeed af = em.find(ActivityFeed.class, afId);
            
            af.setAfId(afId);
            af.setSendermessage(senderMsg);
            af.setReceivermessage(receiverMsg);
            af.setTargetUrl(targerURL);
            af.setIsRead(isRead);
            af.setIsDeleted(isDeleted);
            af.setSenderid(r);
            af.setReceiverid(r);
            af.setGroupid(g);
            
            
            gmsc.add(af);
            gmrc.add(af);
            gmgc.add(af);
            s.setActivityFeedCollection(gmsc);
            r.setActivityFeedCollection(gmrc);
            g.setActivityFeedCollection(gmgc);
           
            em.persist(af);
            em.merge(s);
            em.merge(r);
            em.merge(g);
            
            return "Activity Feed Updated";
            
        } catch (Exception e) {
            return e.getMessage();
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String activity_feed_Delete(int afId) {
        
        try {
            
            ActivityFeed af = em.find(ActivityFeed.class, afId);
            em.remove(af);
            return "Activity Feed Removed";
            
        } catch (Exception e) {
            
            return e.getMessage();
            
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ActivityFeed activity_feed_FindById(int afId) {
        
        try {
            
            ActivityFeed af = em.find(ActivityFeed.class,afId);
            
            return af;
            
        } catch (Exception e) {
            
            return null;
            
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ActivityFeed> activity_feed_ShowAll() {
        
         try {
            
            List<ActivityFeed> feed = em.createNamedQuery("ActivityFeed.findAll")
                    .getResultList();
            
            return feed;
            
        } catch (Exception e) {
            
            return null;
            
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    //Login 
    
    
    @Override
    public String vibeLogin(String email, String password) {
        
        try {
            
            List<User> userList = em.createNamedQuery("User.findUserByEmail")
                    .setParameter("email", email)
                    .getResultList();
            
            if(!userList.isEmpty()) {
                
                for(User user : userList) {
                    
                    if(user.getAccess() == false || user.getIsactive() == false) {
                        return "delete";
                    }
                    
                    boolean PassToHash = hashPassword.checkPassword(user.getPassword(), password);
                    
                    if(user.getIsadmin() == true) {
                        if(PassToHash) {
                            return "admin";
                        }
                        return "invalid";
                    }
                    
                    if(user.getIsadmin() == false) {
                        if(PassToHash) {
                            return "vibe";
                        }
                        return "invalid";
                    }
                    
                }
                
            }
                
            return "invalid";
            
        } catch (Exception e) {
            
            System.out.println(e.getMessage());
            return "failed";
            
        }

        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
