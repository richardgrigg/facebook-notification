package com.wrigglegriggle.mvt.app;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class WebServerUTest {

    @Test
    public void loadProperties() throws IOException {

        Properties prop = new Properties();
        InputStream in = getClass().getResourceAsStream("/webserver.properties");
        prop.load(in);

        in.close();
    }

}
