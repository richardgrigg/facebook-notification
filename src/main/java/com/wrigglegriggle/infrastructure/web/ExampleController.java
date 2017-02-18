package com.wrigglegriggle.infrastructure.web;

import com.wrigglegriggle.domain.FacebookAppRequest;
import com.wrigglegriggle.domain.FacebookNotificationAccept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.social.support.URIBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;

@Controller
public class ExampleController {


    @RequestMapping("/hello")
    public ModelAndView notificationResponse() {
        return new ModelAndView("hello", "message", "asdasdasd");
    }

    @RequestMapping("/canvas")
    public ModelAndView facebookCanvas(HttpServletRequest request) {
        FacebookNotificationAccept facebookNotificationAccept = new FacebookNotificationAccept();

        if(request.getParameter("request_ids") != null && request.getParameter("fb_source") != null  &&  request.getParameter("fb_source").equals("reminders")) {

            facebookNotificationAccept.setFbSource(" its a reminder ");

            Facebook facebook = new FacebookTemplate();

            // Get the full list of reminders using the graph api
            //https://graph.facebook.com/<REQUEST_OBJECT_ID>?access_token=APP_ACCESS_TOKEN

            String access_token = "100177150161842|0AgA7--OXFx6DPqr10imturWeUw";
            String encodedAccessToken = URLEncoder.encode(access_token);
            MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
            parameters.set("access_token", encodedAccessToken);
            String[] requestIds = request.getParameter("request_ids").split(",");

            for(String requestId : requestIds) {
                FacebookAppRequest appRequest = facebook.fetchObject(requestId, FacebookAppRequest.class, parameters);

                String json = "";


            }


        } else {

            facebookNotificationAccept.setFbSource(" unknown ");
        }


        return new ModelAndView("hello", "notificationClicked", facebookNotificationAccept);
    }





}
