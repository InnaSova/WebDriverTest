package test.pageObject.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * Created by Inna on 02.07.2016.
 */
public abstract class AbstractPageObject {

    @Autowired
    protected WebDriver driver;

    @FindBy(css = "iframe[id='supportFrame']")
    private WebElement supportFrame;

    @PostConstruct
    public void init(){
        PageFactory.initElements(driver, this);
    }

   protected abstract WebElement getMainFrame();

    /**
     * Switch to main frame
     */
    public void switchToMainPageFrame() {
        driver.switchTo().defaultContent();
        driver.switchTo().frame(supportFrame).switchTo().frame(getMainFrame());
    }
}
