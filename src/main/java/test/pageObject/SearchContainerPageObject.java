package test.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;
import test.pageObject.common.AbstractPageObject;

import java.util.List;

/**
 * Created by Inna on 03.07.2016.
 */
@Component
public class SearchContainerPageObject extends AbstractPageObject {

    /** Question input field */
    @FindBy(css = "input[id='txtSearch']")
    private WebElement txtSearch;

    /** Answers frame */
    @FindBy(css = "iframe[title='Instant answers frame, access this frame to ask a question.']")
    private WebElement answersFrame;

    /** Suggestion List */
    @FindBy(css = "div.autoCompleteDiv")
    private List<WebElement> suggestionList;

    /**
     * @return - suggestion list
     */
    public List<WebElement> getSuggestionList() {
        return suggestionList;
    }


    /** Question input field */
    public WebElement getTxtSearch() {
        return txtSearch;
    }

    @Override
    protected WebElement getMainFrame() {
        return answersFrame;
    }
}
