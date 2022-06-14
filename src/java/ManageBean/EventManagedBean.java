/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManageBean;

import client.VibeClient;
import ejb.VibeSessionBeanLocal;
import entity.Events;
import entity.FriendList;
import entity.UserSkills;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author pooja
 */
@Named(value = "eventManagedBean")
@ApplicationScoped
public class EventManagedBean {

    @EJB
    private VibeSessionBeanLocal vibe;
    private VibeClient vibeClient = new VibeClient();

    public VibeClient getVibeClient() {
        return vibeClient;
    }

    public void setVibeClient(VibeClient vibeClient) {
        this.vibeClient = vibeClient;
    }
    
    
    private String eventid;
    private String hostid;
    private String eventname;
    private String post;
    private String eventstartdate;
    private String eventenddate;
    private String eventinfo;
    private String venue;
    private String type;
    private String fees;
    private String mode;
    private String guestcount;
    private boolean is_removed;

    public VibeSessionBeanLocal getVibe() {
        return vibe;
    }

    public void setVibe(VibeSessionBeanLocal vibe) {
        this.vibe = vibe;
    }

    public String getEventid() {
        return eventid;
    }

    public void setEventid(String eventid) {
        this.eventid = eventid;
    }

    public String getHostid() {
        return hostid;
    }

    public void setHostid(String hostid) {
        this.hostid = hostid;
    }

    public String getEventname() {
        return eventname;
    }

    public void setEventname(String eventname) {
        this.eventname = eventname;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getEventstartdate() {
        return eventstartdate;
    }

    public void setEventstartdate(String eventstartdate) {
        this.eventstartdate = eventstartdate;
    }

    public String getEventenddate() {
        return eventenddate;
    }

    public void setEventenddate(String eventenddate) {
        this.eventenddate = eventenddate;
    }

    public String getEventinfo() {
        return eventinfo;
    }

    public void setEventinfo(String eventinfo) {
        this.eventinfo = eventinfo;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFees() {
        return fees;
    }

    public void setFees(String fees) {
        this.fees = fees;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getGuestcount() {
        return guestcount;
    }

    public void setGuestcount(String guestcount) {
        this.guestcount = guestcount;
    }

    public boolean getIs_removed() {
        return is_removed;
    }

    public void setIs_removed(boolean is_removed) {
        this.is_removed = is_removed;
    }
    
    
    /**
     * Creates a new instance of EventManagedBean
     */
    public EventManagedBean() {
    }
    
    public List<Events> showSubscribedEvents() {
        
        HttpServletRequest requests = (HttpServletRequest) FacesContext.getCurrentInstance()
                    .getExternalContext().getRequest();
        HttpSession userSessions = requests.getSession(); 
        
        Response response = vibeClient.subscribedEvents(Response.class, userSessions.getAttribute("UuserId").toString());
        
        ArrayList<Events> subeventsArrayList = new ArrayList<>();
        GenericType<List<Events>> eventsGenericType = new GenericType<List<Events>>(){};
        
        subeventsArrayList = (ArrayList<Events>)response.readEntity(eventsGenericType);
        
        return subeventsArrayList;
    }
    
    public List<Events> showSuggestedEvents() {
        
        HttpServletRequest requests = (HttpServletRequest) FacesContext.getCurrentInstance()
                    .getExternalContext().getRequest();
        HttpSession userSessions = requests.getSession(); 
        
        Response response = vibeClient.suggestedEvents(Response.class, userSessions.getAttribute("UuserId").toString());
        
        ArrayList<Events> sugeventsArrayList = new ArrayList<>();
        GenericType<List<Events>> eventsGenericType = new GenericType<List<Events>>(){};
        
        sugeventsArrayList = (ArrayList<Events>)response.readEntity(eventsGenericType);
        
        return sugeventsArrayList;
    }
    
    
}
