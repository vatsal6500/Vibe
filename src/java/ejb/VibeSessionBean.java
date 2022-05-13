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
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
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

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public String stateInsert(int stateId, String stateName, boolean isActive, int countryId) {
        
        try {
            
            Country c = em.find(Country.class, countryId);
            Collection<State> sc = c.getStateCollection();
            
            State s = new State();
            
            s.setStateid(stateId);
            s.setStatename(stateName);
            s.setIsactive(isActive);
            s.setCountryid(c);
            
            sc.add(s);
            c.setStateCollection(sc);
            
            em.persist(s);
            em.merge(c);
            
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

    @Override
    public String userInsert(int userId, String firstName, String middleName, String lastName, String gender, Date dob, int pincode, String email, String username, String password, long mobile, String profilePhoto, String coverPhoto, boolean isActive, boolean isAdmin, boolean access, Date regDate, int countyrId, int stateId, int cityId) {
        
        boolean userRegister = false;
        
        try {
            
            List<User> u = em.createNamedQuery("User.findAllEmail")
                    .getResultList();
            
            if(!u.isEmpty()) {
                for (User ul : u) {
                    if(email.equals(ul.getEmail())) {
                        return "Email Already used.";
                    } else {
                        userRegister = true;
                    }
                }
            }
            
            if(userRegister || u.isEmpty()) {
                
                Country country = em.find(Country.class, countyrId);
                State state = em.find(State.class, stateId);
                City city = em.find(City.class, cityId);

                Collection<User> userCountryCollection = country.getUserCollection();
                Collection<User> userStateCollection = state.getUserCollection();
                Collection<User> userCityCollection = city.getUserCollection();

                User user = new User();
                HashUtility hashpassword = new HashUtility();

                user.setUserid(userId);
                user.setFirstname(firstName);
                user.setMiddlename(middleName);
                user.setLastname(lastName);
                user.setGender(gender);
                user.setDob(dob);
                user.setPincode(pincode);
                user.setEmail(email);
                user.setUsername(username);
                user.setPassword(hashpassword.getHashPassword(password));
                user.setMobile(mobile);
                user.setProfilephoto(profilePhoto);
                user.setCoverphoto(coverPhoto);
                user.setIsactive(isActive);
                user.setIsadmin(isAdmin);
                user.setAccess(access);
                user.setRegDate(regDate);

                user.setCountryid(country);
                user.setStateid(state);
                user.setCityid(city);

                userCountryCollection.add(user);
                userStateCollection.add(user);
                userCityCollection.add(user);

                country.setUserCollection(userCountryCollection);
                state.setUserCollection(userStateCollection);
                city.setUserCollection(userCityCollection);


                em.persist(user);
                em.merge(country);
                em.merge(state);
                em.merge(city);

                return "User Inserted";
                
            }
            
            return "Registration Failed";
            
        } catch (Exception e) {
            
            return Arrays.toString(e.getStackTrace());
            
        }
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String userUpdate(int userId, String firstName, String middleName, String lastName, String gender, Date dob, int pincode, String email, String username, String password, long mobile, String profilePhoto, String coverPhoto, boolean isActive, boolean isAdmin, boolean access, Date regDate, int countyrId, int stateId, int cityId) {
        
        try {
            
            Country country = em.find(Country.class, countyrId);
            State state = em.find(State.class, stateId);
            City city = em.find(City.class, cityId);
            
            Collection<User> userCountryCollection = country.getUserCollection();
            Collection<User> userStateCollection = state.getUserCollection();
            Collection<User> userCityCollection = city.getUserCollection();
            
            User user = em.find(User.class, userId);
            
            user.setUserid(userId);
            user.setFirstname(firstName);
            user.setMiddlename(middleName);
            user.setLastname(lastName);
            user.setGender(gender);
            user.setDob(dob);
            user.setPincode(pincode);
            user.setEmail(email);
            user.setUsername(username);
            user.setPassword(password);
            user.setMobile(mobile);
            user.setProfilephoto(profilePhoto);
            user.setCoverphoto(coverPhoto);
            user.setIsactive(isActive);
            user.setIsadmin(isAdmin);
            user.setAccess(access);
            user.setRegDate(regDate);
            
            user.setCountryid(country);
            user.setStateid(state);
            user.setCityid(city);
            
            userCountryCollection.add(user);
            userStateCollection.add(user);
            userCityCollection.add(user);
            
            country.setUserCollection(userCountryCollection);
            state.setUserCollection(userStateCollection);
            city.setUserCollection(userCityCollection);
            
            
            em.persist(user);
            em.merge(country);
            em.merge(state);
            em.merge(city);
            
            return "User Inserted";
            
            
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
    
}
