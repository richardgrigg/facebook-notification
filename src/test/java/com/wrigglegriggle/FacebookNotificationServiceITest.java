package com.wrigglegriggle;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext-facebookHttpClient.xml"})
public class FacebookNotificationServiceITest {

    private static final String USER_ID = "100001203661280";

    @Autowired
    private FacebookNotificationService testObj;

    @Test
    public void sendNotification() {
        testObj.notifyFacebook();
    }



}
