/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import ejb.VibeSessionBeanLocal;
import entity.ActivityFeed;
import entity.Ads;
import entity.AdsUser;
import entity.City;
import entity.Country;
import entity.GroupMembers;
import entity.Groups;
import entity.Post;
import entity.State;
import entity.User;
import entity.UserContactInfo;
import entity.UserEducation;
import entity.UserSkills;
import entity.UserWork;
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
    
    @Path("userregister/{userId}/{firstName}/{lastName}/{dob}/{email}/{password}/{isActive}/{isAdmin}/{access}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String userRegister(@PathParam("userId")int userId, @PathParam("firstName")String firstName, @PathParam("lastName")String lastName, @PathParam("dob")String dob, @PathParam("email")String email, @PathParam("password")String password, @PathParam("isActive")boolean isActive , @PathParam("isAdmin")boolean isAdmin, @PathParam("access")boolean access) {
        return vibe.userRegister(userId, firstName, lastName, dob, email, password, isActive, isAdmin, access);
    }
    
    @Path("userupdate/{userId}/{firstName}/{middleName}/{lastName}/{gender}/{dob}/{pincode}/{email}/{username}/{password}/{mobile}/{profilePhoto}/{coverPhoto}/{isActive}/{isAdmin}/{access}/{countryId}/{stateId}/{cityId}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String userUpdate(@PathParam("userId")int userId, @PathParam("firstName")String firstName, @PathParam("middleName")String middleName, @PathParam("lastName")String lastName, @PathParam("gender")String gender, @PathParam("dob")Date dob, @PathParam("pincode")int pincode, @PathParam("email")String email, @PathParam("username")String username, @PathParam("password")String password, @PathParam("mobile")long mobile, @PathParam("profilePhoto")String profilePhoto, @PathParam("coverPhoto")String coverPhoto, @PathParam("isActive")boolean isActive, @PathParam("isAdmin")boolean isAdmin, @PathParam("access")boolean access, @PathParam("countryId")int countryId, @PathParam("stateId")int stateId, @PathParam("cityId")int cityId) {
        return vibe.userUpdate(userId, firstName, middleName, lastName, gender, dob, pincode, email, username, password, mobile, profilePhoto, coverPhoto, isActive, isAdmin, access, countryId, stateId, cityId);
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
    
    //User Contact Info
    
    @Path("user_contact_info_insert/{uci_id}/{website}/{language}/{intrested_in}/{fb_link}/{insta_link}/{bio}/{userid}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String user_contact_info_Insert(@PathParam("uci_id")int uci_id, @PathParam("website")String website, @PathParam("language")String language, @PathParam("intrested_in")String intrested_in, @PathParam("fb_link")String fb_link, @PathParam("insta_link")String insta_link, @PathParam("bio")String bio, @PathParam("userid")int userid) {
        return vibe.user_contact_info_Insert(uci_id, website, language, intrested_in, fb_link, insta_link, bio, userid);
    }
    
    @Path("user_contact_info_update/{uci_id}/{website}/{language}/{intrested_in}/{fb_link}/{insta_link}/{bio}/{userid}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String user_contact_info_Update(@PathParam("uci_id")int uci_id, @PathParam("website")String website, @PathParam("language")String language, @PathParam("intrested_in")String intrested_in, @PathParam("fb_link")String fb_link, @PathParam("insta_link")String insta_link, @PathParam("bio")String bio, @PathParam("userid")int userid) {
        return vibe.user_contact_info_Update(uci_id, website, language, intrested_in, fb_link, insta_link, bio, userid);
    }
    
    @Path("user_contact_info_delete/{uciid}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String user_contact_info_Delete(@PathParam("uciid")int uciid) {
        return vibe.user_contact_info_Delete(uciid);
    }
    
    @Path("user_contact_info_findbyid/{uciid}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public UserContactInfo user_contact_info_FindById(@PathParam("uciid")int uciid) {
        return vibe.user_contact_info_FindById(uciid);
    }
    
    
    @Path("user_contact_info_showall")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserContactInfo> user_contact_info_ShowAll() {
        return vibe.user_contact_info_ShowAll();
    }
        
    //User Education
    
    @Path("user_education_insert/{ueId}/{instituteName}/{joiningDate}/{endingDate}/{instituteAddress}/{userid}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String user_education_Insert(@PathParam("ueId")int ueId, @PathParam("instituteName")String instituteName, @PathParam("joiningDate")String joiningDate, @PathParam("endingDate")String endingDate, @PathParam("instituteAddress")String instituteAddress, @PathParam("userid")int userid) {
        return vibe.user_education_Insert(ueId, instituteName, joiningDate, endingDate, instituteAddress, userid);
    }
    
    @Path("user_education_update/{ueId}/{instituteName}/{joiningDate}/{endingDate}/{instituteAddress}/{userid}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String user_education_Update(@PathParam("ueId")int ueId, @PathParam("instituteName")String instituteName, @PathParam("joiningDate")String joiningDate, @PathParam("endingDate")String endingDate, @PathParam("instituteAddress")String instituteAddress, @PathParam("userid")int userid) {
        return vibe.user_education_Update(ueId, instituteName, joiningDate, endingDate, instituteAddress, userid);
    }
    
    @Path("user_education_delete/{ueId}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String user_education_Delete(@PathParam("ueId")int ueId) {
        return vibe.user_education_Delete(ueId);
    }
    
    @Path("user_education_findbyid/{ueId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public UserEducation user_education_FindById(@PathParam("ueId")int ueId) {
        return vibe.user_education_FindById(ueId);
    }
    
    
    @Path("user_education_showall")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserEducation> user_education_ShowAll() {
        return vibe.user_education_ShowAll();
    }
    
    
    //User Skills
    
    @Path("user_skills_insert/{usId}/{skillname}/{skillinfo}/{skillportfolio}/{userid}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String user_skills_Insert(@PathParam("usId")int usId, @PathParam("skillname")String skillname, @PathParam("skillinfo")String skillinfo, @PathParam("skillportfolio")String skillportfolio, @PathParam("userid")int userid) {
        return vibe.user_skills_Insert(usId, skillname, skillinfo, skillportfolio, userid);
    }
    
    @Path("user_skills_update/{usId}/{skillname}/{skillinfo}/{skillportfolio}/{userid}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String user_skills_Update(@PathParam("usId")int usId, @PathParam("skillname")String skillname, @PathParam("skillinfo")String skillinfo, @PathParam("skillportfolio")String skillportfolio, @PathParam("userid")int userid) {
        return vibe.user_skills_Update(usId, skillname, skillinfo, skillportfolio, userid);
    }
    
    @Path("user_skills_delete/{usId}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String user_skills_Delete(@PathParam("usId")int usId) {
        return vibe.user_skills_Delete(usId);
    }
    
    @Path("user_skills_findbyid/{usId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public UserSkills user_skills_FindById(@PathParam("usId")int usId) {
        return vibe.user_skills_FindById(usId);
    }
    
    
    @Path("user_skills_showall")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserSkills> user_skills_ShowAll() {
        return vibe.user_skills_ShowAll();
    }
    
    //User Work
    
    @Path("user_work_insert/{uwId}/{companyname}/{joiningDate}/{endingDate}/{companyaddress}/{userid}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String user_work_Insert(@PathParam("uwId")int uwId, @PathParam("companyname")String companyname, @PathParam("joiningDate")String joiningDate, @PathParam("endingDate")String endingDate, @PathParam("companyaddress")String companyaddress, @PathParam("userid")int userid) {
        return vibe.user_work_Insert(uwId, companyname, joiningDate, endingDate, companyaddress, userid);
    }
    
    @Path("user_work_update/{uwId}/{companyname}/{joiningDate}/{endingDate}/{companyaddress}/{userid}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String user_work_Update(@PathParam("uwId")int uwId, @PathParam("companyname")String companyname, @PathParam("joiningDate")String joiningDate, @PathParam("endingDate")String endingDate, @PathParam("companyaddress")String companyaddress, @PathParam("userid")int userid) {
        return vibe.user_work_Update(uwId, companyname, joiningDate, endingDate, companyaddress, userid);
    }
    
    @Path("user_work_delete/{uwId}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String user_work_Delete(@PathParam("uwId")int uwId) {
        return vibe.user_work_Delete(uwId);
    }
    
    @Path("user_work_findbyid/{uwId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public UserWork user_work_FindById(@PathParam("uwId")int uwId) {
        return vibe.user_work_FindById(uwId);
    }
    
    
    @Path("user_work_showall")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserWork> user_work_ShowALl() {
        return vibe.user_work_ShowALl();
    }
    
    //Groups
    
    @Path("groupinsert/{groupid}/{groupName}/{description}/{membersCount}/{isDeleted}/{adminId}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String groupInsert(@PathParam("groupid")int groupid, @PathParam("groupName")String groupName, @PathParam("description")String description, @PathParam("membersCount")int membersCount, @PathParam("isDeleted")boolean isDeleted, @PathParam("adminId")int adminId) {
        return vibe.groupInsert(groupid, groupName, description, membersCount, isDeleted, adminId);
    }
    
    @Path("groupupdate/{groupid}/{groupName}/{description}/{membersCount}/{isDeleted}/{adminId}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String groupUpdate(@PathParam("groupid")int groupid, @PathParam("groupName")String groupName, @PathParam("description")String description, @PathParam("membersCount")int membersCount, @PathParam("isDeleted")boolean isDeleted, @PathParam("adminId")int adminId) {
        return vibe.groupUpdate(groupid, groupName, description, membersCount, isDeleted, adminId);
    }
    
    @Path("groupdelete/{groupid}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String groupDelete(@PathParam("groupid")int groupid) {
        return vibe.groupDelete(groupid);
    }
    
    @Path("groupfindbyid/{groupid}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Groups groupFindById(@PathParam("groupid")int groupid) {
        return vibe.groupFindById(groupid);
    }
    
    
    @Path("groupshowall")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Groups> groupShowAll() {
        return vibe.groupShowAll();
    }
    
    //Group Members
    
    
    @Path("group_member_insert/{gmId}/{isMember}/{becameMember}/{groupId}/{memberId}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String group_member_Insert(@PathParam("gmId")int gmId, @PathParam("isMember")boolean isMember, @PathParam("becameMember")String becameMember, @PathParam("groupId")int groupId, @PathParam("memberId")int memberId) {
        return vibe.group_member_Insert(gmId, isMember, becameMember, groupId, memberId);
    }
    
    @Path("group_member_update/{gmId}/{isMember}/{becameMember}/{groupId}/{memberId}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String group_member_Update(@PathParam("gmId")int gmId, @PathParam("isMember")boolean isMember, @PathParam("becameMember")String becameMember, @PathParam("groupId")int groupId, @PathParam("memberId")int memberId) {
        return vibe.group_member_Update(gmId, isMember, becameMember, groupId, memberId);
    }
    
    @Path("group_member_delete/{gmId}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String group_member_Delete(@PathParam("gmId")int gmId) {
        return vibe.group_member_Delete(gmId);
    }
    
    @Path("group_member_findbyid/{gmId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public GroupMembers group_member_FindById(@PathParam("gmId")int gmId) {
        return vibe.group_member_FindById(gmId);
    }
    
    
    @Path("group_member_showall")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<GroupMembers> group_member_ShowAll() {
        return vibe.group_member_ShowAll();

    }
    
    //Activity Feed
    
    @Path("activity_feed_insert/{afId}/{senderMsg}/{receiverMsg}/{targerURL}/{isRead}/{isDeleted}/{senderId}/{receiverId}/{groupId}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String activity_feed_Insert(@PathParam("afId")int afId, @PathParam("senderMsg")String senderMsg, @PathParam("receiverMsg")String receiverMsg, @PathParam("targerURL")String targerURL, @PathParam("isRead")boolean isRead, @PathParam("isDeleted")boolean isDeleted, @PathParam("senderId")int senderId, @PathParam("receiverId")int receiverId, @PathParam("groupId")int groupId) {
        return vibe.activity_feed_Insert(afId, senderMsg, receiverMsg, targerURL, isRead, isDeleted, senderId, receiverId, groupId);
    }
    
    @Path("activity_feed_update/{afId}/{senderMsg}/{receiverMsg}/{targerURL}/{isRead}/{isDeleted}/{senderId}/{receiverId}/{groupId}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String activity_feed_Update(@PathParam("afId")int afId, @PathParam("senderMsg")String senderMsg, @PathParam("receiverMsg")String receiverMsg, @PathParam("targerURL")String targerURL, @PathParam("isRead")boolean isRead, @PathParam("isDeleted")boolean isDeleted, @PathParam("senderId")int senderId, @PathParam("receiverId")int receiverId, @PathParam("groupId")int groupId) {
        return vibe.activity_feed_Update(afId, senderMsg, receiverMsg, targerURL, isRead, isDeleted, senderId, receiverId, groupId);
    }
    
    @Path("activity_feed_delete/{afId}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String activity_feed_Delete(@PathParam("afId")int afId) {
        return vibe.activity_feed_Delete(afId);
    }
    
    @Path("activity_feed_findbyid/{afId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ActivityFeed activity_feed_FindById(@PathParam("afId")int afId) {
        return vibe.activity_feed_FindById(afId);
    }
    
    
    @Path("activity_feed_showall")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ActivityFeed> activity_feed_ShowAll() {
        return vibe.activity_feed_ShowAll();

    }
    
    
    //Ads
    
    
    @Path("adsinsert/{adsId}/{adsType}/{price}/{timeLimit}/{description}/{isRemoved}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String adsInsert(@PathParam("adsId")int adsId, @PathParam("adsType")String adsType, @PathParam("price")int price, @PathParam("timeLimit")String timeLimit, @PathParam("description")String description, @PathParam("isRemoved")boolean isRemoved) {
        return vibe.adsInsert(adsId, adsType, price, timeLimit, description, isRemoved);
    }
    
    @Path("adsupdate/{adsId}/{adsType}/{price}/{timeLimit}/{description}/{isRemoved}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String adsUpdate(@PathParam("adsId")int adsId, @PathParam("adsType")String adsType, @PathParam("price")int price, @PathParam("timeLimit")String timeLimit, @PathParam("description")String description, @PathParam("isRemoved")boolean isRemoved) {
        return vibe.adsUpdate(adsId, adsType, price, timeLimit, description, isRemoved);
    }
    
    @Path("adsdelete/{adsId}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String adsDelete(@PathParam("adsId")int adsId) {
        return vibe.adsDelete(adsId);
    }
    
    @Path("adsfindbyid/{adsId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Ads adsFindById(@PathParam("adsId")int adsId) {
        return vibe.adsFindById(adsId);
    }
    
    
    @Path("adsshowall")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Ads> adsShowAll() {
        return vibe.adsShowAll();

    }
    
    
    //Ads_User
    
    @Path("ads_user_insert/{auId}/{adsContent}/{description}/{link}/{endDate}/{isRemoved}/{isExpired}/{userId}/{adsId}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String ads_user_Insert(@PathParam("auId")int auId, @PathParam("adsContent")String adsContent, @PathParam("description")String description, @PathParam("link")String link, @PathParam("endDate")String endDate, @PathParam("isRemoved")boolean isRemoved, @PathParam("isExpired")boolean isExpired, @PathParam("userId")int userId, @PathParam("adsId")int adsId) {
        return vibe.ads_user_Insert(auId, adsContent, description, link, endDate, isRemoved, isExpired, userId, adsId);
    }
    
    @Path("ads_user_update/{auId}/{adsContent}/{description}/{link}/{endDate}/{isRemoved}/{isExpired}/{userId}/{adsId}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String ads_user_Update(@PathParam("auId")int auId, @PathParam("adsContent")String adsContent, @PathParam("description")String description, @PathParam("link")String link, @PathParam("endDate")String endDate, @PathParam("isRemoved")boolean isRemoved, @PathParam("isExpired")boolean isExpired, @PathParam("userId")int userId, @PathParam("adsId")int adsId) {
        return vibe.ads_user_Update(auId, adsContent, description, link, endDate, isRemoved, isExpired, userId, adsId);
    }
    
    @Path("ads_user_delete/{auId}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String ads_user_Delete(@PathParam("auId")int auId) {
        return vibe.ads_user_Delete(auId);
    }
    
    @Path("ads_user_findbyid/{auId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public AdsUser ads_user_FindById(@PathParam("auId")int auId) {
        return vibe.ads_user_FindById(auId);
    }
    
    
    @Path("ads_user_showall")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<AdsUser> ads_user_ShowAll() {
        return vibe.ads_user_ShowAll();

    }
    
    //Posts
    
    @Path("postinsert/{postId}/{post}/{caption}/{is_deleted}/{likecount}/{userId}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String postInsert(@PathParam("postId")int postId, @PathParam("post")String post, @PathParam("caption")String caption, @PathParam("is_deleted")boolean is_deleted, @PathParam("likecount")int likecount, @PathParam("userId")int userId) {
        return vibe.postInsert(postId, post, caption, is_deleted, likecount, userId);
    }
    
    @Path("postupdate/{postId}/{post}/{caption}/{is_deleted}/{likecount}/{userId}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String postUpdate(@PathParam("postId")int postId, @PathParam("post")String post, @PathParam("caption")String caption, @PathParam("is_deleted")boolean is_deleted, @PathParam("likecount")int likecount, @PathParam("userId")int userId) {
        return vibe.postUpdate(postId, post, caption, is_deleted, likecount, userId);
    }
    
    @Path("postdelete/{postId}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String postDelete(@PathParam("postId")int postId) {
        return vibe.postDelete(postId);
    }
    
    @Path("postfindbyid/{postId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Post postFindById(@PathParam("postId")int postId) {
        return vibe.postFindById(postId);
    }
    
    
    @Path("postShowAll")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Post> postShowAll() {
        return vibe.postShowAll();

    }
    
    
    //Login

    @Path("vibelogin/{email}/{password}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public User vibeLogin(@PathParam("email")String email, @PathParam("password")String password) {
        return vibe.vibeLogin(email, password);
    }
    
}
