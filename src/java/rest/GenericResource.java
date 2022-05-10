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
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
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
    
    @Path("stateadd/{stateId}/{stateName}/{isActive}/{countryId}")
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
    
    @Path("cityadd/{cityId}/{cityName}/{isActive}/{stateId}")
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
    
    
    
}
