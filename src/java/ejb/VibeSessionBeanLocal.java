/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Country;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author LENOVO
 */
@Local
public interface VibeSessionBeanLocal {
    
    //Country
    public String countryInsert(int cId, String cName, boolean isActive);
    public String countryUpdate(int cId, String cName, boolean isActive);
    public String countrydelete(int cId);
    public Country countryFindById(int cId);
    public List<Country> countryShowAll();
    
}
