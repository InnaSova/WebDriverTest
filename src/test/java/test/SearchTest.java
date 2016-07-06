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

    /**
     * Search answer by suggestion index
     */
    @Test
    public void t_01_searchBySuggestionIndex() {

        // Write a question on the textbox and find the answer by suggestion index
        searchAnswerScenario.findBySuggestionIndex("contextual", 2);

        // Scroll down the page
        searchAnswerScenario.scrollToLikesLocation(1);

        // Return the last like/dislike number in the suggested answers
        log.info("Count of likes: " + answerContainer.getLikesCount(1));
    }

    /**
     * Search answer by suggestion text
     */
    @Test
    public void t_02_searchBySuggestionText() {

        // Write a question on the textbox and find the answer by suggestion text
        searchAnswerScenario.findBySuggestionText("contextual", "how does the contextual search filter work");

        // Scroll down the page
        searchAnswerScenario.scrollToLikesLocation(1);

        // Return the last like/dislike number in the suggested answers
        log.info("Count of likes: " + answerContainer.getLikesCount(1));
    }
}
