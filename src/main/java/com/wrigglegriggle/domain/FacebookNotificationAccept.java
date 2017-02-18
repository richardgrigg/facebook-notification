package com.wrigglegriggle.domain;

import lombok.Data;
import org.springframework.web.bind.annotation.RequestParam;

@Data
public class FacebookNotificationAccept {

    private String fbSource;
    private String fbRef;
    private String notifT;
    private String ref;
    private String myCustomSource;

}
