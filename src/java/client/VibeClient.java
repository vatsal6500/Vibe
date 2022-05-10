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
 * @author LENOVO
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

    public <T> T countryFindById(Class<T> responseType, String countryId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("countryfindbyid/{0}", new Object[]{countryId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public String cityUpdate(String cityId, String cityName, String isActive, String stateId) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("cityupdate/{0}/{1}/{2}/{3}", new Object[]{cityId, cityName, isActive, stateId})).request().post(null, String.class);
    }

    public String stateDelete(String stateId) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("statedelete/{0}", new Object[]{stateId})).request().post(null, String.class);
    }

    public <T> T countryShowAll(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("countryshowall");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public String cityDelete(String cityId) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("citydelete/{0}", new Object[]{cityId})).request().post(null, String.class);
    }

    public <T> T cityShowAll(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("cityshowall");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T countryShowActive(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("countryshowactive");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public String cityInsert(String cityId, String cityName, String isActive, String stateId) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("cityadd/{0}/{1}/{2}/{3}", new Object[]{cityId, cityName, isActive, stateId})).request().post(null, String.class);
    }

    public String countryDelete(String countryId) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("countrydelete/{0}", new Object[]{countryId})).request().post(null, String.class);
    }

    public String stateUpdate(String stateId, String stateName, String isActive, String countryId) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("stateupdate/{0}/{1}/{2}/{3}", new Object[]{stateId, stateName, isActive, countryId})).request().post(null, String.class);
    }

    public String stateInsert(String stateId, String stateName, String isActive, String countryId) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("stateadd/{0}/{1}/{2}/{3}", new Object[]{stateId, stateName, isActive, countryId})).request().post(null, String.class);
    }

    public <T> T stateShowAll(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("stateshowall");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public String countryInsert(String countryId, String sortName, String countryName, String phoneCode, String isActive) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("countryinsert/{0}/{1}/{2}/{3}/{4}", new Object[]{countryId, sortName, countryName, phoneCode, isActive})).request().post(null, String.class);
    }

    public String countryUpdate(String countryId, String sortName, String countryName, String phoneCode, String isActive) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("countryupdate/{0}/{1}/{2}/{3}/{4}", new Object[]{countryId, sortName, countryName, phoneCode, isActive})).request().post(null, String.class);
    }

    public <T> T stateFindById(Class<T> responseType, String stateId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("statefindbyid/{0}", new Object[]{stateId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
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

    public void close() {
        client.close();
    }
    
}
