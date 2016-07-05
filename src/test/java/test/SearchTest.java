package test;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import test.pageObject.AnswerContainerPageObject;
import test.pageObject.SearchContainerPageObject;
import test.pageObject.scenario.SearchAnswerScenario;

/**
 * Created by Inna on 02.07.2016.
 */
public class SearchTest extends WebDriverTest {

    @Autowired
    private SearchContainerPageObject searchContainer;

    @Autowired
    private AnswerContainerPageObject answerContainer;

    @Autowired
    private SearchAnswerScenario searchAnswerScenario;

    @Test
    public void t_01_search(){

        // Switch to search frame
        searchContainer.switchToMainPageFrame();

        // Write a question on the textbox and find the answer
        searchAnswerScenario.find("contextual", 2);

        // Switch to answer frame
        answerContainer.switchToMainPageFrame();

        // Scroll down the page
        searchAnswerScenario.scrollToLikesLocation(1);

        // Return the last like/dislike number in the suggested answers
        answerContainer.getLikesCount(1);
    }
}
