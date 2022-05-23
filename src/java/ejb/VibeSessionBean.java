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
    public String user_contact_info_Insert(int uciId, String website, String language, String intrested_in, String fb_link, String insta_link, String bio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String user_contact_info_Update(int uciId, String website, String language, String intrested_in, String fb_link, String insta_link, String bio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String user_contact_info_Delete(int uciId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UserContactInfo user_contact_info_FindById(int uciId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<UserContactInfo> user_contact_info_ShowAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    //User_Education

    @Override
    public String user_education_Insert(int ueId, String instituteName, Date joiningDate, Date endingDate, String instituteAddress, int userId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String user_education_Update(int ueId, String instituteName, Date joiningDate, Date endingDate, String instituteAddress, int userId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String user_education_Delete(int ueId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UserEducation user_education_FindById(int ueId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<UserEducation> user_education_ShowAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    //User_Skills

    @Override
    public String user_skills_Insert(int usId, String skillName, String skillInfo, String skillPortfolio, int userId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String user_skills_Update(int usId, String skillName, String skillInfo, String skillPortfolio, int userId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String user_skills_Delete(int usId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UserSkills user_skills_FindById(int usId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<UserSkills> user_skills_ShowAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    //User_Work

    @Override
    public String user_work_Insert(int uwId, String companyName, Date joiningDate, Date endingDate, String companyAddress, int userId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String user_work_Update(int uwId, String companyName, Date joiningDate, Date endingDate, String companyAddress, int userId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String user_work_Delete(int uwId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UserWork user_work_FindById(int uwId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<UserWork> user_work_ShowALl() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    //Groups

    @Override
    public String groupInsert(int groupId, String groupName, String description, int membersCount, boolean isDeleted, int adminId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String groupUpdate(int groupId, String groupName, String description, int membersCount, boolean isDeleted, int adminId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String groupDelete(int groupId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Groups groupFindById(int groupId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Groups> groupShowAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    //Group_Members

    @Override
    public String group_member_Insert(int gmId, boolean isMember, Date becameMember, int groupId, int memberId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String group_member_Update(int gmId, boolean isMember, Date becameMember, int groupId, int memberId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String group_member_Delete(int gmId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GroupMembers group_member_FindById(int gmId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<GroupMembers> group_member_ShowAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String activity_feed_Update(int afId, String senderMsg, String receiverMsg, String targerURL, boolean isRead, boolean isDeleted, int senderId, int receiverId, int groupId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String activity_feed_Delete(int afId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ActivityFeed activity_feed_FindById(int afId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ActivityFeed> activity_feed_ShowAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
