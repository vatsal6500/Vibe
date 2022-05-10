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
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
    public List<Country> countryShowAll() {
        
        try {
            
            List<Country> c = em.createNamedQuery("Country.findAll")
                    .getResultList();
            
            return c;
            
        } catch (Exception e) {
            
            e.getMessage();
            return null;
            
        }
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<Country> countryShowActive() {
        
        try {
            
            List<Country> c = em.createNamedQuery("Country.findByIsactive")
                    .setParameter("isactive", true)
                    .getResultList();
            
            return c;
            
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
            
            State s = em.find(State.class, stateId);
            
            return s;
            
        } catch (Exception e) {
            
            e.getMessage();
            return null;
        }
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<State> stateShowAll() {
        
        try {
            
            List<State> s = em.createNamedQuery("State.findAll")
                    .getResultList();
            
            return s;
            
        } catch (Exception e) {
            
            e.getMessage();
            return null;
            
        }
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<State> stateShowActive() {
        
        try {
            
            List<State> s = em.createNamedQuery("State.findByIsactive")
                    .setParameter("isactive", true)
                    .getResultList();
            
            return s;
            
        } catch (Exception e) {
            
            e.getMessage();
            return null;
            
        }
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String cityInsert(int cityId, String cityName, boolean isActive, int stateId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String cityUpdate(int cityId, String cityName, boolean isActive, int stateId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String cityDelete(int cityId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public City cityFindById(int cityId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<City> cityShowAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<City> cityShowActive() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String userInsert(int userId, String firstName, String middleName, String lastName, String gender, Date dob, int pincode, String email, String username, String password, String mobile, String profilePhoto, String coverPhoto, String isActive, String isAdmin, String access, Date regDate, int countyrId, int stateId, int cityId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String userUpdate(int userId, String firstName, String middleName, String lastName, String gender, Date dob, int pincode, String email, String username, String password, String mobile, String profilePhoto, String coverPhoto, String isActive, String isAdmin, String access, Date regDate, int countyrId, int stateId, int cityId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String userDelete(int userId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User userFindById(int userId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> userShowAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<User> adminShowAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
