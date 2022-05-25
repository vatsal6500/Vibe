/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.*;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author LENOVO
 */
@Local
public interface VibeSessionBeanLocal {
    
    //Login
    public String vibeLogin(String email, String password);
    
    
    //Country
    public String countryInsert(int countryId, String sortName, String countryName, int phoneCode, boolean isActive);
    public String countryUpdate(int countryId, String sortName, String countryName, int phoneCode, boolean isActive);
    public String countryDelete(int countryId);
    public Country countryFindById(int countryId);
    public Country countryFindByName(String countryName); //admin
    public List<Country> countryShowAll(); //admin
    public List<Country> countryShowActive();
    
    //State
    public String stateInsert(int stateId, String stateName, boolean isActive, int countryId);
    public String stateUpdate(int stateId, String stateName, boolean isActive, int countryId);
    public String stateDelete(int stateId);
    public State stateFindById(int stateId);
    public State stateFindByName(String stateName); //admin
    public List<State> stateShowAll(); //admin
    public List<State> stateShowActive();
    
    //City
    public String cityInsert(int cityId, String cityName, boolean isActive, int stateId);
    public String cityUpdate(int cityId, String cityName, boolean isActive, int stateId);
    public String cityDelete(int cityId);
    public City cityFindById(int cityId);
    public City cityFindByName(String cityName); //admin
    public List<City> cityShowAll(); //admin
    public List<City> cityShowActive();
    
    //User
    public String userRegister(int userId, String firstName, String lastName, String dob, String email, String password, boolean isActive, boolean isAdmin, boolean access);
    public String userUpdate(int userId, String firstName, String middleName, String lastName, String gender, Date dob, int pincode, String email, String username, String password, long mobile, String profilePhoto, String coverPhoto, boolean isActive, boolean isAdmin, boolean access, int countryId, int stateId, int cityId);
    public String userDelete(int userId); //admin
    public User userFindById(int userId);
    public List<User> userFindByName(String userName);
    public List<User> userShowAll(); //admin
    public List<User> adminShowAll(); //admin
    
    //User_Contact_Info
    public String user_contact_info_Insert(int uciId, String website, String language, String intrested_in, String fb_link, String insta_link, String bio, int userId);
    public String user_contact_info_Update(int uciId, String website, String language, String intrested_in, String fb_link, String insta_link, String bio, int userId);
    public String user_contact_info_Delete(int uciId);
    public UserContactInfo user_contact_info_FindById(int uciId);
    public List<UserContactInfo> user_contact_info_ShowAll(); //admin
    
    //User_Education
    public String user_education_Insert(int ueId, String instituteName, String joiningDate, String endingDate, String instituteAddress, int userId);
    public String user_education_Update(int ueId, String instituteName, String joiningDate, String endingDate, String instituteAddress, int userId);
    public String user_education_Delete(int ueId);
    public UserEducation user_education_FindById(int ueId);
    public List<UserEducation> user_education_ShowAll(); //admin
    
    //User_Skills
    public String user_skills_Insert(int usId, String skillName, String skillInfo, String skillPortfolio, int userId);
    public String user_skills_Update(int usId, String skillName, String skillInfo, String skillPortfolio, int userId);
    public String user_skills_Delete(int usId);
    public UserSkills user_skills_FindById(int usId);
    public List<UserSkills> user_skills_ShowAll(); //admin
    
    //User_Work
    public String user_work_Insert(int uwId, String companyName, String joiningDate, String endingDate, String companyAddress, int userId);
    public String user_work_Update(int uwId, String companyName, String joiningDate, String endingDate, String companyAddress, int userId);
    public String user_work_Delete(int uwId);
    public UserWork user_work_FindById(int uwId);
    public List<UserWork> user_work_ShowALl();  //admin
    
    
    //Groups
    public String groupInsert(int groupId, String groupName, String description, int membersCount, boolean isDeleted, int adminId);
    public String groupUpdate(int groupId, String groupName, String description, int membersCount, boolean isDeleted, int adminId);
    public String groupDelete(int groupId);
    public Groups groupFindById(int groupId);
    public List<Groups> groupShowAll(); //admin 
    
    //Group Members
    public String group_member_Insert(int gmId, boolean isMember, String becameMember, int groupId, int memberId);
    public String group_member_Update(int gmId, boolean isMember, String becameMember, int groupId, int memberId);
    public String group_member_Delete(int gmId);
    public GroupMembers group_member_FindById(int gmId);
    public List<GroupMembers> group_member_ShowAll(); //admin
    
    //Post
    public String postInsert(int postId, String post, String caption, boolean is_deleted, int likeCount, int userId, int groupId);
    public String postUpdate(int postId, String post, String caption, boolean is_deleted, int likeCount, int userId, int groupId);
    public String postDelete(int postId);
    public Post postFindById(int postId);
    public List<Post> postShowAll(); //admin
    
    //Likes
    public String likeInsert(int likeId, String likeDate, boolean isRemoved, int postId, int senderId, int receiverId);
    public String likeUpdate(int likeId, String likeDate, boolean isRemoved, int postId, int senderId, int receiverId);
    public String likeDelete(int likeId);
    public Likes likeFindById(int likeId);
    public List<Likes> likeShowAll(); //admin
    
    //Friend Request
    public String friend_request_Insert(int frId, String status, int senderId, int receiverId);
    public String friend_request_Update(int frId, String status, int senderId, int receiverId);
    public String friend_request_Delete(int frId);
    public FriendRequest friend_request_FindById(int frId);
    public List<FriendRequest> friend_request_ShowAll(); //admin
    
    //Friend List
    public String friend_list_Insert(int flId, String acceptedDateTime, boolean friendStatus, int userId, int friendId);
    public String friend_list_Update(int flId, String acceptedDateTime, boolean friendStatus, int userId, int friendId);
    public String friend_list_Delete(int flId);
    public FriendList friend_list_FindById(int flId);
    public List<FriendList> friend_list_ShowAll();  //admin
    
    //Events
    public String eventInsert(int eventId, String eventName, String post, Date eventStartDate, Date eventEndDate, String eventInfo, String venue, String type, int fees, String mode, int guestCount, boolean is_removed, int hostId);
    public String eventUpdate(int eventId, String eventName, String post, Date eventStartDate, Date eventEndDate, String eventInfo, String venue, String type, int fees, String mode, int guestCount, boolean is_removed, int hostId);
    public String eventDelete(int eventId);
    public Events eventFindById(int eventId);
    public List<Events> eventShowAll();  //admin
    
    //Event Usercount
    public String event_usercount_Insert(int euc_Id, boolean isIntrested, int eventId, int userId);
    public String event_usercount_Update(int euc_Id, boolean isIntrested, int eventId, int userId);
    public String event_usercount_Delete(int euc_Id);
    public EventUsercount event_usercount_FindById(int euc_Id);
    public List<EventUsercount> event_usercount_ShowAll();  //admin
    
    //Comments
    public String commentsInsert(int commentId, String comment, boolean isRemoved, int postId, int senderId, int receiverId);
    public String commentsUpdate(int commentId, String comment, boolean isRemoved, int postId, int senderId, int receiverId);
    public String commentsdelete(int commentId);
    public Comments commentsFindById(int commentId);
    public List<Comments> commentsInsert(); //admin
    
    //Chat
    public String chatInsert(int chatId, String message, boolean isDelevered, boolean isRead, boolean isDeleted, int senderId, int receiverId);
    public String chatDelete(int chatId);
    //    public Chat chatFindById(int chatId);
    //    public List<Chat> chatShowAll(); //admin

    //Ads User
    public String ads_user_Insert(int auId, String adsConcent, String description, String link, String endDate, boolean isRemoved, boolean isExpried, int userId, int adsId);
    public String ads_user_Update(int auId, String adsConcent, String description, String link, String endDate, boolean isRemoved, boolean isExpried, int userId, int adsId);
    public String ads_user_Delete(int auId);
    public AdsUser ads_user_FindById(int auId);
    public List<AdsUser> ads_user_ShowAll();  //admin
    
    //Ads
    public String adsInsert(int adsId, String adsType, int price, String timeLimit, String description, boolean isRemoved);
    public String adsUpdate(int adsId, String adsType, int price, String timeLimit, String description, boolean isRemoved);
    public String adsDelete(int adsId);
    public Ads adsFindById(int adsId);
    public List<Ads> adsShowAll(); //admin
    
    //Activity Feed
    public String activity_feed_Insert(int afId, String senderMsg, String receiverMsg, String targerURL, boolean isRead, boolean isDeleted, int senderId, int receiverId, int groupId);
    public String activity_feed_Update(int afId, String senderMsg, String receiverMsg, String targerURL, boolean isRead, boolean isDeleted, int senderId, int receiverId, int groupId);
    public String activity_feed_Delete(int afId);
    public ActivityFeed activity_feed_FindById(int afId);
    public List<ActivityFeed> activity_feed_ShowAll();  //admin
    
}
