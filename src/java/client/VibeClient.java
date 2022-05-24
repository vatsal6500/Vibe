/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:GenericResource [generic]<br>
 * USAGE:
 * <pre>
 *        VibeClient client = new VibeClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author pooja
 */
public class VibeClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/Vibe/webresources";

    public VibeClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("generic");
    }

    public <T> T cityFindById(Class<T> responseType, String cityId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("cityfindbyid/{0}", new Object[]{cityId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T user_work_ShowALl(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("user_work_showall");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public String user_skills_Delete(String usId) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("user_skills_delete/{0}", new Object[]{usId})).request().post(null, String.class);
    }

    public String stateDelete(String stateId) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("statedelete/{0}", new Object[]{stateId})).request().post(null, String.class);
    }

    public <T> T countryShowAll(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("countryshowall");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T cityShowAll(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("cityshowall");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T user_skills_FindById(Class<T> responseType, String usId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("user_skills_findbyid/{0}", new Object[]{usId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public String countryDelete(String countryId) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("countrydelete/{0}", new Object[]{countryId})).request().post(null, String.class);
    }

    public <T> T countryFindByName(Class<T> responseType, String countryName) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("countryfindbyname/{0}", new Object[]{countryName}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public String stateUpdate(String stateId, String stateName, String isActive, String countryId) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("stateupdate/{0}/{1}/{2}/{3}", new Object[]{stateId, stateName, isActive, countryId})).request().post(null, String.class);
    }

    public String stateInsert(String stateId, String stateName, String isActive, String countryId) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("stateinsert/{0}/{1}/{2}/{3}", new Object[]{stateId, stateName, isActive, countryId})).request().post(null, String.class);
    }

    public String user_contact_info_Insert(String uci_id, String website, String language, String intrested_in, String fb_link, String insta_link, String bio, String userid) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("user_contact_info_insert/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}", new Object[]{uci_id, website, language, intrested_in, fb_link, insta_link, bio, userid})).request().post(null, String.class);
    }

    public <T> T user_education_ShowAll(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("user_education_showall");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public String user_work_Insert(String uwId, String companyname, String joiningDate, String endingDate, String companyaddress, String userid) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("user_work_insert/{0}/{1}/{2}/{3}/{4}/{5}", new Object[]{uwId, companyname, joiningDate, endingDate, companyaddress, userid})).request().post(null, String.class);
    }

    public <T> T stateShowAll(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("stateshowall");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public String userRegister(String userId, String firstName, String lastName, String dob, String email, String password, String isActive, String isAdmin, String access) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("userregister/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}", new Object[]{userId, firstName, lastName, dob, email, password, isActive, isAdmin, access})).request().post(null, String.class);
    }

    public String user_skills_Update(String usId, String skillname, String skillinfo, String skillportfolio, String userid) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("user_skills_update/{0}/{1}/{2}/{3}/{4}", new Object[]{usId, skillname, skillinfo, skillportfolio, userid})).request().post(null, String.class);
    }

    public String countryInsert(String countryId, String sortName, String countryName, String phoneCode, String isActive) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("countryinsert/{0}/{1}/{2}/{3}/{4}", new Object[]{countryId, sortName, countryName, phoneCode, isActive})).request().post(null, String.class);
    }

    public <T> T stateShowActive(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("stateshowactive");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T cityShowActive(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("cityshowactive");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T userFindById(Class<T> responseType, String userId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("userfindbyid/{0}", new Object[]{userId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T userShowAll(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("usershowall");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T countryFindById(Class<T> responseType, String countryId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("countryfindbyid/{0}", new Object[]{countryId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public String userDelete(String userId) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("userdelete/{0}", new Object[]{userId})).request().post(null, String.class);
    }

    public String user_education_Delete(String ueId) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("user_education_delete/{0}", new Object[]{ueId})).request().post(null, String.class);
    }

    public String cityUpdate(String cityId, String cityName, String isActive, String stateId) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("cityupdate/{0}/{1}/{2}/{3}", new Object[]{cityId, cityName, isActive, stateId})).request().post(null, String.class);
    }

    public String userUpdate(String userId, String firstName, String middleName, String lastName, String gender, String dob, String pincode, String email, String username, String password, String mobile, String profilePhoto, String coverPhoto, String isActive, String isAdmin, String access, String countryId, String stateId, String cityId) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("userupdate/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}/{10}/{11}/{12}/{13}/{14}/{15}/{16}/{17}/{18}", new Object[]{userId, firstName, middleName, lastName, gender, dob, pincode, email, username, password, mobile, profilePhoto, coverPhoto, isActive, isAdmin, access, countryId, stateId, cityId})).request().post(null, String.class);
    }

    public String user_education_Insert(String ueId, String instituteName, String joiningDate, String endingDate, String instituteAddress, String userid) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("user_education_insert/{0}/{1}/{2}/{3}/{4}/{5}", new Object[]{ueId, instituteName, joiningDate, endingDate, instituteAddress, userid})).request().post(null, String.class);
    }

    public String user_education_Update(String ueId, String instituteName, String joiningDate, String endingDate, String instituteAddress, String userid) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("user_education_update/{0}/{1}/{2}/{3}/{4}/{5}", new Object[]{ueId, instituteName, joiningDate, endingDate, instituteAddress, userid})).request().post(null, String.class);
    }

    public String cityDelete(String cityId) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("citydelete/{0}", new Object[]{cityId})).request().post(null, String.class);
    }

    public <T> T countryShowActive(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("countryshowactive");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T user_contact_info_FindById(Class<T> responseType, String uciid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("user_contact_info_findbyid/{0}", new Object[]{uciid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public String cityInsert(String cityId, String cityName, String isActive, String stateId) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("cityinsert/{0}/{1}/{2}/{3}", new Object[]{cityId, cityName, isActive, stateId})).request().post(null, String.class);
    }

    public <T> T userFindByName(Class<T> responseType, String userName) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("userfindbyname/{0}", new Object[]{userName}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public String user_contact_info_Delete(String uciid) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("user_contact_info_delete/{0}", new Object[]{uciid})).request().post(null, String.class);
    }

    public <T> T user_contact_info_ShowAll(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("user_contact_info_showall");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public String user_contact_info_Update(String uci_id, String website, String language, String intrested_in, String fb_link, String insta_link, String bio, String userid) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("user_contact_info_update/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}", new Object[]{uci_id, website, language, intrested_in, fb_link, insta_link, bio, userid})).request().post(null, String.class);
    }

    public String user_work_Update(String uwId, String companyname, String joiningDate, String endingDate, String companyaddress, String userid) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("user_work_update/{0}/{1}/{2}/{3}/{4}/{5}", new Object[]{uwId, companyname, joiningDate, endingDate, companyaddress, userid})).request().post(null, String.class);
    }

    public <T> T cityFindByName(Class<T> responseType, String cityName) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("cityfindbyname/{0}", new Object[]{cityName}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T adminShowAll(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("adminshowall");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public String user_skills_Insert(String usId, String skillname, String skillinfo, String skillportfolio, String userid) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("user_skills_insert/{0}/{1}/{2}/{3}/{4}", new Object[]{usId, skillname, skillinfo, skillportfolio, userid})).request().post(null, String.class);
    }

    public String countryUpdate(String countryId, String sortName, String countryName, String phoneCode, String isActive) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("countryupdate/{0}/{1}/{2}/{3}/{4}", new Object[]{countryId, sortName, countryName, phoneCode, isActive})).request().post(null, String.class);
    }

    public <T> T user_work_FindById(Class<T> responseType, String uwId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("user_work_findbyid/{0}", new Object[]{uwId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T stateFindById(Class<T> responseType, String stateId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("statefindbyid/{0}", new Object[]{stateId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T stateFindByName(Class<T> responseType, String stateName) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("statefindbyname/{0}", new Object[]{stateName}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T user_education_FindById(Class<T> responseType, String ueId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("user_education_findbyid/{0}", new Object[]{ueId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T user_skills_ShowAll(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("user_skills_showall");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public String user_work_Delete(String uwId) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("user_work_delete/{0}", new Object[]{uwId})).request().post(null, String.class);
    }

    public void close() {
        client.close();
    }
    
}
