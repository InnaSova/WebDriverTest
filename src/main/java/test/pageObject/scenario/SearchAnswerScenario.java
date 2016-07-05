package test.pageObject.scenario;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import test.components.JSExecutorService;
import test.pageObject.AnswerContainerPageObject;
import test.pageObject.SearchContainerPageObject;

import java.util.List;

/**
 * Created by Inna on 04.07.2016.
 * Common methods for search answer.
 */
@Component
public class SearchAnswerScenario {

    @Autowired
    private SearchContainerPageObject searchContainer;

    @Autowired
    private AnswerContainerPageObject answerContainer;

    @Autowired
    private WebDriver driver;

    @Autowired
    private JSExecutorService jse;

    /**
     * Input question and choose suggestion by index
     * @param question - question for search
     * @param suggestionIndex - suggestion index
     */
    public void find(String question, int suggestionIndex) {
        searchContainer.getTxtSearch().sendKeys(question);
        // Get suggestion list
        List<WebElement> list = searchContainer.getSuggestionList();
        // Choose suggestion by index
        list.get(suggestionIndex).click();
    }

    /**
     * Scroll down to like/dislike field location
     * @param likeId - like/dislike field index
     */
    public void scrollToLikesLocation(int likeId) {
        // Get likes list
        List<WebElement> likes = answerContainer.getLikesList();
        likes.get(likeId);
        // Scroll down the page
        scrollToElementLocation(likes.get(likeId));
    }

    /**
     * Scroll down the page
     * @param e - element for determining the position of the scroll
     */
    public void scrollToElementLocation(WebElement e) {
        // Get Y coordinate
        int y = e.getLocation().getY();
        // Switch to the top of the hierarchy (to the browser page model)
        driver.switchTo().defaultContent();
        // Use JavaScript for scrolling page
        jse.getJs().executeScript("scroll(0," + y +");");
        answerContainer.switchToMainPageFrame();
    }
}
