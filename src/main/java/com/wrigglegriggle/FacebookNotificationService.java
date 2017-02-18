package com.wrigglegriggle;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URLEncoder;

@Service
public class FacebookNotificationService {

    private static final String USER_ID = "";

    private String postUrl = "/{recipient_userid}/notifications?access_token= … &template= … &href= …";

    private HttpClient httpClient;

    @Autowired
    public FacebookNotificationService (HttpClient httpClient) {
        this.httpClient = httpClient;
    }


    public void notifyFacebook() {
        String responseStream = null;
        String authToken = getAuthToken();
        String authtokenValue = authToken.replace("access_token=", "");
        String urlE = URLEncoder.encode(authtokenValue);
        String testUserId = "100005089140504";
        String postNotification = "https://graph.facebook.com/" + testUserId + "/notifications?access_token=" + urlE + "&template=Hello&href=hello.html?source=facebook&ref=notification_test";
        HttpPost httpget = new HttpPost(postNotification);

        try {
            httpClient.execute(httpget);
            HttpResponse response = httpClient.execute(httpget);
            HttpEntity entity = response.getEntity();

            if(entity != null) {
                responseStream = EntityUtils.toString(entity);
            }

            System.out.println(responseStream);
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } finally {
            httpget.releaseConnection();
        }

    }

    private String getAuthToken() {
        String responseStream = null;
        String getAuth = "https://graph.facebook.com/oauth/access_token?client_id=100177150161842&client_secret=c8b68bd18e8082024c1dc28fc295b855&grant_type=client_credentials";
        HttpGet httpget = new HttpGet(getAuth);

        try {
            httpClient.execute(httpget);
            HttpResponse response = httpClient.execute(httpget);
            HttpEntity entity = response.getEntity();

            if(entity != null) {
                responseStream = EntityUtils.toString(entity);
            }

        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        finally {
            httpget.releaseConnection();
        }

    return responseStream;

    }

}
