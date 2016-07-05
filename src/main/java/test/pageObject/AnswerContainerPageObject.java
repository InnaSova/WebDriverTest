package test.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import test.components.JSExecutorService;
import test.pageObject.common.AbstractPageObject;

import java.util.List;

/**
 * Created by Inna on 04.07.2016.
 */
@Component
public class AnswerContainerPageObject extends AbstractPageObject {

    @Autowired
    private SearchContainerPageObject searchContainer;

    @FindBy(css = "div.newlikes")
    private List<WebElement> likesList;

    /** List of like/dislike number */
    public List<WebElement> getLikesList() {
        return likesList;
    }

    /**
     * Method return the like/dislike number
     * @param likeIndex - index of like/dislike field
     * @return - likes/dislike number
     */
    public String getLikesCount(int likeIndex) {
        return getLikesList().get(likeIndex).getText();
    }

    @Override
    protected WebElement getMainFrame() {
        return searchContainer.getMainFrame();
    }
}
