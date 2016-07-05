package test.components;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Inna on 03.07.2016.
 * Service of JavaScript functions processing.
 */
@Component
public class JSExecutorService {

    @Autowired
    private WebDriver driver;

    public JavascriptExecutor getJs(){
        return (JavascriptExecutor) driver;
    }
}
