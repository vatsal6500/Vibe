/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Country;
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
    public String countryInsert(int cId, String cName, boolean isActive) {
        
        try {
            
            Country c = new Country(cId,cName,isActive);
            em.persist(c);
            return "Country Inserted";
            
        } catch (Exception e) {
            
            return e.getMessage();
            
        }
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String countryUpdate(int cId, String cName, boolean isActive) {
        
        try {
            
            Country c = em.find(Country.class, cId);
            c.setCountryid(cId);
            c.setCountryname(cName);
            c.setIsactive(isActive);
            
            em.merge(c);
            return "Country Updated";
            
        } catch (Exception e) {
            
            return e.getMessage();
            
        }
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String countrydelete(int cId) {
        
        try {
            
            Country c = em.find(Country.class, cId);
            c.setIsactive(false);
            em.merge(c);
            
            return "Country Deleted";
            
        } catch (Exception e) {
            
            return e.getMessage();
            
        }
        

        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Country countryFindById(int cId) {
        
        try {
            
            Country c = em.find(Country.class,cId);
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
}
