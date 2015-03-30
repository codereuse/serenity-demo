package org.codereuse.serenity.demo.imdb.steps;

import static org.truth0.Truth.ASSERT;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.codereuse.serenity.demo.imdb.pages.FindResultsPage;
import org.codereuse.serenity.demo.imdb.pages.HomePage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Theo on 29/03/15.
 */
public class UserSteps extends ScenarioSteps {

    HomePage homePage;
    FindResultsPage findResultsPage;

    private List<String> searchResults = new ArrayList<String>();

    @Step
    public void opens_imdb_home_page() {
        homePage.openImdb();
    }

    @Step
    public void searches_for_movie(String title) {
        homePage.searchForMovie(title);
        this.searchResults = findResultsPage.getResultsList();
    }

    @Step
    public void search_header_should_contain(String searchedTitle) {
        String searchHeader = findResultsPage.getFindHeader();
        ASSERT.that(searchHeader).contains(searchedTitle);
    }

    @Step
    public void should_see_number_of_titles_displayed(int expected) {
        ASSERT.that(searchResults.size()).isEqualTo(expected);
    }

    @Step
    public void should_see_in_search_results(String movieTitle) {
        ASSERT.that(searchResults).contains(movieTitle);
    }
}
