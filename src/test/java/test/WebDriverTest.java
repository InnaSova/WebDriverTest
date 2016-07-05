package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import test.config.PropertyLoader;
import test.config.WebDriverConfiguration;

/**
 * Created by Inna on 02.07.2016.
 */
@ContextConfiguration(classes = WebDriverConfiguration.class)
public class WebDriverTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private WebDriver driver;

    @Autowired
    private PropertyLoader propertyLoader;

    private Log log = LogFactory.getLog(this.getClass());

    @BeforeClass
    public void setUpDriver() {
        driver.get(propertyLoader.getUrl());
        log.info("Webdriver browser was started");
    }

    @AfterClass
    public void closeAndRemoveDriver() {
        try {
            driver.quit();
            log.info("Webdriver browser was closed");
        } catch (UnreachableBrowserException e) {
            log.error("The browser was not closed.", e);
        }
    }
}
