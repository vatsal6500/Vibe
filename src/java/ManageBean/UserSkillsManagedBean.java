/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManageBean;


import client.VibeClient;
import ejb.VibeSessionBeanLocal;
import entity.UserEducation;
import entity.UserSkills;
import entity.UserWork;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
/**
 *
 * @author pooja
 */

@Named(value = "userskillsManagedBean")
@ApplicationScoped

public class UserSkillsManagedBean {
    
    @EJB
    private VibeSessionBeanLocal vibeSessionBean;
    private final VibeClient vibeClient = new VibeClient();
    
    private String us_id;
    private String userid;
    private String skillname;
    private String skillinfo;
    private String skillportfolio;

    public VibeSessionBeanLocal getVibeSessionBean() {
        return vibeSessionBean;
    }

    public void setVibeSessionBean(VibeSessionBeanLocal vibeSessionBean) {
        this.vibeSessionBean = vibeSessionBean;
    }

    public String getUs_id() {
        return us_id;
    }

    public void setUs_id(String us_id) {
        this.us_id = us_id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getSkillname() {
        return skillname;
    }

    public void setSkillname(String skillname) {
        this.skillname = skillname;
    }

    public String getSkillinfo() {
        return skillinfo;
    }

    public void setSkillinfo(String skillinfo) {
        this.skillinfo = skillinfo;
    }

    public String getSkillportfolio() {
        return skillportfolio;
    }

    public void setSkillportfolio(String skillportfolio) {
        this.skillportfolio = skillportfolio;
    }
    
    
    public UserSkillsManagedBean()
    {
        
    }
    
    public List<UserSkills> showUserSkillInfo() {
        
        HttpServletRequest requests = (HttpServletRequest) FacesContext.getCurrentInstance()
                    .getExternalContext().getRequest();
        HttpSession userSessions = requests.getSession();
        
        Response response = vibeClient.user_skills_FindByUserId(Response.class, userSessions.getAttribute("UuserId").toString());
        ArrayList<UserSkills> skillArrayList = new ArrayList<>();
        GenericType<List<UserSkills>> showAllskill  = new GenericType<List<UserSkills>>() {
        };
        skillArrayList = (ArrayList<UserSkills>) response.readEntity(showAllskill);
        System.out.println(skillArrayList);
        return skillArrayList;
    }
}
