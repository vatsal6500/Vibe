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

    public <T> T countryFindById(Class<T> responseType, String countryId) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("countryfindbyid/{0}", new Object[]{countryId})).request().post(null, responseType);
    }

    public <T> T countryShowAll(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("countryshowall");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T countryShowActive(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("countryshowactive");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public String countryUpdate(String countryId, String countryName, String isActive) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("countryupdate/{0}/{1}/{2}", new Object[]{countryId, countryName, isActive})).request().post(null, String.class);
    }

    public String countryDelete(String countryId) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("countrydelete/{0}", new Object[]{countryId})).request().post(null, String.class);
    }

    public void close() {
        client.close();
    }
    
}
