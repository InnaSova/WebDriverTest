package test.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import java.util.concurrent.TimeUnit;

/**
 * Created by Inna on 02.07.2016.
 */
@Configuration
@ComponentScan(basePackages = { "test" })
@PropertySource(value = { "classpath:application.properties" })
public class WebDriverConfiguration {

    @Autowired
    private PropertyLoader propertyLoader;

    @Bean
    public WebDriver driver() {
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(propertyLoader.getTimeout(), TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySources() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
