/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import ejb.VibeSessionBeanLocal;
import entity.City;
import entity.Country;
import entity.State;
import entity.User;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author LENOVO
 */
@Path("generic")
public class GenericResource {

    @EJB VibeSessionBeanLocal vibe; 
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }
    
    
    //country
    
    @Path("countryinsert/{countryId}/{sortName}/{countryName}/{phoneCode}/{isActive}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String countryInsert(@PathParam("countryId")int countryId, @PathParam("sortName")String sortName, @PathParam("countryName")String countryName, @PathParam("phoneCode")int phoneCode, @PathParam("isActive")boolean isActive) {
        return vibe.countryInsert(countryId, sortName, countryName, phoneCode, isActive);
    }
    
    @Path("countryupdate/{countryId}/{sortName}/{countryName}/{phoneCode}/{isActive}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String countryUpdate(@PathParam("countryId")int countryId, @PathParam("sortName")String sortName, @PathParam("countryName")String countryName, @PathParam("phoneCode")int phoneCode, @PathParam("isActive")boolean isActive) {
        return vibe.countryUpdate(countryId, sortName, countryName, phoneCode, isActive);
    }
    
    @Path("countrydelete/{countryId}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String countryDelete(@PathParam("countryId")int countryId) {
        return vibe.countryDelete(countryId);
    }
    
    @Path("countryfindbyid/{countryId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Country countryFindById(@PathParam("countryId")int countryId) {
        return vibe.countryFindById(countryId);
    }
    
    @Path("countryfindbyname/{countryName}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Country countryFindByName(@PathParam("countryName")String countryName) {
        return vibe.countryFindByName(countryName);
    }
    
    @Path("countryshowall")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Country> countryShowAll() {
        return vibe.countryShowAll();
    }
    
    @Path("countryshowactive")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Country> countryShowActive() {
        return vibe.countryShowActive();
    }
    
    
    //State
    
    @Path("stateinsert/{stateId}/{stateName}/{isActive}/{countryId}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String stateInsert(@PathParam("stateId")int stateId, @PathParam("stateName")String stateName, @PathParam("isActive")boolean isActive, @PathParam("countryId")int countryId) {
        return vibe.cityInsert(countryId, stateName, isActive, stateId);
    }
    
    @Path("stateupdate/{stateId}/{stateName}/{isActive}/{countryId}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String stateUpdate(@PathParam("stateId")int stateId, @PathParam("stateName")String stateName, @PathParam("isActive")boolean isActive, @PathParam("countryId")int countryId) {
        return vibe.stateUpdate(stateId, stateName, isActive, countryId);
    }
    
    @Path("statedelete/{stateId}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String stateDelete(@PathParam("stateId")int stateId) {
        return vibe.stateDelete(stateId);
    }
    
    @Path("statefindbyid/{stateId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public State stateFindById(@PathParam("stateId")int stateId) {
        return vibe.stateFindById(stateId);
    }
    
    @Path("statefindbyname/{stateName}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public State stateFindByName(@PathParam("stateName")String stateName) {
        return vibe.stateFindByName(stateName);
    }
    
    @Path("stateshowall")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<State> stateShowAll() {
        return vibe.stateShowAll();
    }
    
    @Path("stateshowactive")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<State> stateShowActive() {
        return vibe.stateShowActive();
    }
    
    
    //City
    
    @Path("cityinsert/{cityId}/{cityName}/{isActive}/{stateId}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String cityInsert(@PathParam("cityId")int cityId, @PathParam("cityName")String cityName, @PathParam("isActive")boolean isActive, @PathParam("stateId")int stateId) {
        return vibe.cityInsert(cityId, cityName, isActive, stateId);
    }
    
    @Path("cityupdate/{cityId}/{cityName}/{isActive}/{stateId}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String cityUpdate(@PathParam("cityId")int cityId, @PathParam("cityName")String cityName, @PathParam("isActive")boolean isActive, @PathParam("stateId")int stateId) {
        return vibe.cityUpdate(cityId, cityName, isActive, stateId);
    }
    
    @Path("citydelete/{cityId}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String cityDelete(@PathParam("cityId")int cityId) {
        return vibe.cityDelete(cityId);
    }
    
    @Path("cityfindbyid/{cityId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public City cityFindById(@PathParam("cityId")int cityId) {
        return vibe.cityFindById(cityId);
    }
    
    @Path("cityfindbyname/{cityName}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public City cityFindByName(@PathParam("cityName")String cityName) {
        return vibe.cityFindByName(cityName);
    }
    
    @Path("cityshowall")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<City> cityShowAll() {
        return vibe.cityShowAll();
    }
    
    @Path("cityshowactive")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<City> cityShowActive() {
        return vibe.cityShowActive();
    }
    
    
    @Path("userinsert/{userId}/{firstName}/{middleName}/{lastName}/{gender}/{dob}/{pincode}/{email}/{username}/{password}/{mobile}/{profilePhoto}/{coverPhoto}/{isActive}/{isAdmin}/{access}/{regDate}/{countryId}/{stateId}/{cityId}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String userInsert(@PathParam("userId")int userId, @PathParam("firstName")String firstName, @PathParam("middleName")String middleName, @PathParam("lastName")String lastName, @PathParam("gender")String gender, @PathParam("dob")Date dob, @PathParam("pincode")int pincode, @PathParam("email")String email, @PathParam("username")String username, @PathParam("password")String password, @PathParam("mobile")long mobile, @PathParam("profilePhoto")String profilePhoto, @PathParam("coverPhoto")String coverPhoto, @PathParam("isActive")boolean isActive, @PathParam("isAdmin")boolean isAdmin, @PathParam("access")boolean access, @PathParam("regDate")Date regDate, @PathParam("countyrId")int countyrId, @PathParam("stateId")int stateId, @PathParam("cityId")int cityId) {
        try {
            return vibe.userInsert(userId, firstName, middleName, lastName, gender, dob, pincode, email, username, password, mobile, profilePhoto, coverPhoto, isActive, isAdmin, access, regDate, countyrId, stateId, cityId);
        } catch (Exception e) {
            return Arrays.toString(e.getStackTrace());
        }
    }
    
    @Path("userupdate/{userId}/{firstName}/{middleName}/{lastName}/{gender}/{dob}/{pincode}/{email}/{username}/{password}/{mobile}/{profilePhoto}/{coverPhoto}/{isActive}/{isAdmin}/{access}/{regDate}/{countryId}/{stateId}/{cityId}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String userUpdate(@PathParam("userId")int userId, @PathParam("firstName")String firstName, @PathParam("middleName")String middleName, @PathParam("lastName")String lastName, @PathParam("gender")String gender, @PathParam("dob")Date dob, @PathParam("pincode")int pincode, @PathParam("email")String email, @PathParam("username")String username, @PathParam("password")String password, @PathParam("mobile")long mobile, @PathParam("profilePhoto")String profilePhoto, @PathParam("coverPhoto")String coverPhoto, @PathParam("isActive")boolean isActive, @PathParam("isAdmin")boolean isAdmin, @PathParam("access")boolean access, @PathParam("regDate")Date regDate, @PathParam("countyrId")int countyrId, @PathParam("stateId")int stateId, @PathParam("cityId")int cityId) {
        return vibe.userUpdate(userId, firstName, middleName, lastName, gender, dob, pincode, email, username, password, mobile, profilePhoto, coverPhoto, isActive, isAdmin, access, regDate, countyrId, stateId, cityId);
    }
    
    @Path("userdelete/{userId}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String userDelete(@PathParam("userId")int userId) {
        return vibe.userDelete(userId);
    }
    
    @Path("userfindbyid/{userId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public User userFindById(@PathParam("userId")int userId) {
        return vibe.userFindById(userId);
    }
    
    @Path("userfindbyname/{userName}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> userFindByName(@PathParam("userName")String userName) {
        return vibe.userFindByName(userName);
    }
    
    @Path("usershowall")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> userShowAll() {
        return vibe.userShowAll();
    }
    
    @Path("adminshowall")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> adminShowAll() {
        return vibe.adminShowAll();
    }
    
}
