package org.codereuse.serenity.demo.imdb.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Theo on 29/03/15.
 */
public class FindResultsPage extends PageObject {

    private final static By findHeader = By.cssSelector("#main .findHeader");
    private final static By resultsTable = By.cssSelector("#main table.findList");
    private final static By searchResultTitles = By.cssSelector("#main table.findList td.result_text");

    public String getFindHeader() {
        return find(findHeader).getTextValue();
    }

    public List<String> getResultsList() {
        return find(resultsTable).thenFindAll(searchResultTitles).stream().map(FindResultsPage::convertElementToText).collect(Collectors.toList());
    }

    public static String convertElementToText(WebElementFacade element) {
        return element.getTextValue();
    }
}
