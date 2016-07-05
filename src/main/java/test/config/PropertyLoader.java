package test.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by Inna on 02.07.2016.
 * Component which contains a fields with data from application.properties file
 * for more convenient work with them.
 */
@Component
public class PropertyLoader {

    @Value("${startup.url}")
    private String url;

    @Value("${browser.timeout}")
    private int timeout;

    public String getUrl() {
        return url;
    }

    public int getTimeout() {
        return timeout;
    }
}
