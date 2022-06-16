/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManageBean;

import client.VibeClient;
import ejb.VibeSessionBeanLocal;
import entity.UserContactInfo;
import entity.UserEducation;
import entity.UserSkills;
import entity.UserWork;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author pooja
 */
@Named(value = "uinfoManagedBean")
@ApplicationScoped

public class UInfoManagedBean {

    @EJB
    private VibeSessionBeanLocal vibeSessionBean;
    private VibeClient vibeClient = new VibeClient();
    private ManageBean.UserSkillsManagedBean skillManagedBean ;
    private ManageBean.UserEduManagedBean eduManagedBean ;
    private ManageBean.UserWorkManagedBean workManagedBean ;
    
    private List<UserSkills> skillist;
    private List<UserEducation> edulist;
    private List<UserWork> worklist;
    
    private String uci_id;
    private String userid;
    private String website;
    private String language;
    private String intrested_in;
    private String fb_link;
    private String insta_link;
    private String bio;
    
    private String ue_id;
    private String institutename;
    private String joiningdate;
    private String endingdate;
    private String instituteaddress;
    
    private String us_id;
    private String skillname;
    private String skillinfo;
    private String skillportfolio;
    
    private String uw_id;
    private String companyname;
    private String workjoiningdate;
    private String workendingdate;
    private String companyaddress;

    public String getUw_id() {
        return uw_id;
    }

    public void setUw_id(String uw_id) {
        this.uw_id = uw_id;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getWorkjoiningdate() {
        return workjoiningdate;
    }

    public void setWorkjoiningdate(String workjoiningdate) {
        this.workjoiningdate = workjoiningdate;
    }

    public String getWorkendingdate() {
        return workendingdate;
    }

    public void setWorkendingdate(String workendingdate) {
        this.workendingdate = workendingdate;
    }

    public String getCompanyaddress() {
        return companyaddress;
    }

    public void setCompanyaddress(String companyaddress) {
        this.companyaddress = companyaddress;
    }
    
    

    public String getUs_id() {
        return us_id;
    }

    public void setUs_id(String us_id) {
        this.us_id = us_id;
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
    
    

    public String getUe_id() {
        return ue_id;
    }

    public void setUe_id(String ue_id) {
        this.ue_id = ue_id;
    }

    public String getInstitutename() {
        return institutename;
    }

    public void setInstitutename(String institutename) {
        this.institutename = institutename;
    }

    public String getJoiningdate() {
        return joiningdate;
    }

    public void setJoiningdate(String joiningdate) {
        this.joiningdate = joiningdate;
    }

    public String getEndingdate() {
        return endingdate;
    }

    public void setEndingdate(String endingdate) {
        this.endingdate = endingdate;
    }

    public String getInstituteaddress() {
        return instituteaddress;
    }

    public void setInstituteaddress(String instituteaddress) {
        this.instituteaddress = instituteaddress;
    }
    
    

    public UserSkillsManagedBean getSkillManagedBean() {
        return skillManagedBean;
    }

    public void setSkillManagedBean(UserSkillsManagedBean skillManagedBean) {
        this.skillManagedBean = skillManagedBean;
    }

    public UserEduManagedBean getEduManagedBean() {
        return eduManagedBean;
    }

    public void setEduManagedBean(UserEduManagedBean eduManagedBean) {
        this.eduManagedBean = eduManagedBean;
    }

    public UserWorkManagedBean getWorkManagedBean() {
        return workManagedBean;
    }

    public void setWorkManagedBean(UserWorkManagedBean workManagedBean) {
        this.workManagedBean = workManagedBean;
    }

    public List<UserSkills> getSkillist() {
        return skillist;
    }

    public void setSkillist(List<UserSkills> skillist) {
        this.skillist = skillist;
    }

    public List<UserEducation> getEdulist() {
        return edulist;
    }

    public void setEdulist(List<UserEducation> edulist) {
        this.edulist = edulist;
    }

    public List<UserWork> getWorklist() {
        return worklist;
    }

    public void setWorklist(List<UserWork> worklist) {
        this.worklist = worklist;
    }

    public VibeSessionBeanLocal getVibeSessionBean() {
        return vibeSessionBean;
    }

    public void setVibeSessionBean(VibeSessionBeanLocal vibeSessionBean) {
        this.vibeSessionBean = vibeSessionBean;
    }

    public VibeClient getVibeClient() {
        return vibeClient;
    }

    public void setVibeClient(VibeClient vibeClient) {
        this.vibeClient = vibeClient;
    }

    public String getUci_id() {
        return uci_id;
    }

    public void setUci_id(String uci_id) {
        this.uci_id = uci_id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getIntrested_in() {
        return intrested_in;
    }

    public void setIntrested_in(String intrested_in) {
        this.intrested_in = intrested_in;
    }

    public String getFb_link() {
        return fb_link;
    }

    public void setFb_link(String fb_link) {
        this.fb_link = fb_link;
    }

    public String getInsta_link() {
        return insta_link;
    }

    public void setInsta_link(String insta_link) {
        this.insta_link = insta_link;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
    
    
    /**
     * Creates a new instance of UInfoManagedBean
     */
    public UInfoManagedBean() {
    }
    
    
    public List<UserContactInfo> showUserContactInfo() {
        
        HttpServletRequest requests = (HttpServletRequest) FacesContext.getCurrentInstance()
                    .getExternalContext().getRequest();
        HttpSession userSessions = requests.getSession();
        
        System.out.println(userSessions.getAttribute("UuserId").toString());
        Response response = vibeClient.user_contact_info_FindByUserId(Response.class, userSessions.getAttribute("UuserId").toString());
        ArrayList<UserContactInfo> contactArrayList = new ArrayList<>();
        GenericType<List<UserContactInfo>> showAllcontact  = new GenericType<List<UserContactInfo>>() {
        };
        contactArrayList = (ArrayList<UserContactInfo>) response.readEntity(showAllcontact);
        return contactArrayList;
    }
    
    public List<UserContactInfo> showUserContactInfoByProfileId(String Id) {
        
        Response response = vibeClient.user_contact_info_FindByUserId(Response.class, Id);
        ArrayList<UserContactInfo> contactArrayList = new ArrayList<>();
        GenericType<List<UserContactInfo>> showAllcontact  = new GenericType<List<UserContactInfo>>() {
        };
        contactArrayList = (ArrayList<UserContactInfo>) response.readEntity(showAllcontact);
        return contactArrayList;
    }
    
    public String editUserContact(String Id) {
        
        Response response = vibeClient.user_contact_info_FindById(Response.class, Id);
        UserContactInfo contactArrayList = new UserContactInfo();
        GenericType<UserContactInfo> showAllcontact  = new GenericType<UserContactInfo>() {
        };
        contactArrayList = (UserContactInfo) response.readEntity(showAllcontact);
        uci_id = contactArrayList.getUciId().toString();
        userid = contactArrayList.getUserid().getUserid().toString();
        website = contactArrayList.getWebsite();
        language = contactArrayList.getLanguage();
        intrested_in = contactArrayList.getIntrestedIn();
        fb_link = contactArrayList.getFbLink();
        insta_link = contactArrayList.getInstaLink();
        bio = contactArrayList.getBio();
        
        return "/web/editsociallink.xhtml?faces-redirect=true";
    }
    
    public String showUserContact(String Id) {
        
        Response response = vibeClient.user_contact_info_FindById(Response.class, Id);
        UserContactInfo contactArrayList = new UserContactInfo();
        GenericType<UserContactInfo> showAllcontact  = new GenericType<UserContactInfo>() {
        };
        contactArrayList = (UserContactInfo) response.readEntity(showAllcontact);
        uci_id = contactArrayList.getUciId().toString();
        userid = contactArrayList.getUserid().getUserid().toString();
        website = contactArrayList.getWebsite();
        language = contactArrayList.getLanguage();
        intrested_in = contactArrayList.getIntrestedIn();
        fb_link = contactArrayList.getFbLink();
        insta_link = contactArrayList.getInstaLink();
        bio = contactArrayList.getBio();
        
        
        Response resedu = vibeClient.user_education_FindById(Response.class, Id);
        UserEducation eduArrayList = new UserEducation();
        GenericType<UserEducation> showAlledu  = new GenericType<UserEducation>() {
        };
        eduArrayList = (UserEducation) resedu.readEntity(showAlledu); 
        ue_id = eduArrayList.getUeId().toString();
        institutename = eduArrayList.getInstitutename();
        joiningdate = eduArrayList.getJoiningdate().toString();
        endingdate = eduArrayList.getEndingdate().toString();
        instituteaddress = eduArrayList.getInstituteaddress();
        
        Response resskill = vibeClient.user_skills_FindById(Response.class, Id);
        UserSkills skillArrayList = new UserSkills();
        GenericType<UserSkills> showAllskill  = new GenericType<UserSkills>() {
        };
        skillArrayList = (UserSkills) resskill.readEntity(showAllskill); 
        us_id = skillArrayList.getUsId().toString();
        skillname = skillArrayList.getSkillname();
        skillinfo = skillArrayList.getSkillinfo();
        skillportfolio = skillArrayList.getSkillportfolio();
        
        Response reswork = vibeClient.user_work_FindById(Response.class, Id);
        UserWork workArrayList = new UserWork();
        GenericType<UserWork> showAllwork  = new GenericType<UserWork>() {
        };
        workArrayList = (UserWork) reswork.readEntity(showAllwork); 
        uw_id =  workArrayList.getUwId().toString();
        companyname = workArrayList.getCompanyname();
        workjoiningdate = workArrayList.getJoiningdate().toString();
        workendingdate = workArrayList.getEndingdate().toString();
        companyaddress = workArrayList.getCompanyaddress();
        
        return "/admin/userinfo.xhtml?faces-redirect=true";
    }
    
    public String editUserInterest(String Id) {
        
        Response response = vibeClient.user_contact_info_FindById(Response.class, Id);
        UserContactInfo contactArrayList = new UserContactInfo();
        GenericType<UserContactInfo> showAllcontact  = new GenericType<UserContactInfo>() {
        };
        contactArrayList = (UserContactInfo) response.readEntity(showAllcontact);
        uci_id = contactArrayList.getUciId().toString();
        userid = contactArrayList.getUserid().getUserid().toString();
        website = contactArrayList.getWebsite();
        language = contactArrayList.getLanguage();
        intrested_in = contactArrayList.getIntrestedIn();
        fb_link = contactArrayList.getFbLink();
        insta_link = contactArrayList.getInstaLink();
        bio = contactArrayList.getBio();
        
        return "/web/editinterest.xhtml?faces-redirect=true";
    }
    
    public String updateUserContact() {
        
        try {
            
            HttpServletRequest requests = (HttpServletRequest) FacesContext.getCurrentInstance()
                    .getExternalContext().getRequest();
            HttpSession userSessions = requests.getSession();
        
            if(uci_id == null)
            {
                vibeClient.user_contact_info_Insert("0", website, language, intrested_in, fb_link, insta_link, bio, userSessions.getAttribute("UuserId").toString());
            }
            else{
                vibeClient.user_contact_info_Update(uci_id, website, language, intrested_in, fb_link, insta_link, bio, userid);
            }
               
               return "/web/profile.xhtml?faces-redirect=true";
              
        } catch (ClientErrorException e) {
            System.out.println(e);
            return e.getMessage();
        }
    }
}
