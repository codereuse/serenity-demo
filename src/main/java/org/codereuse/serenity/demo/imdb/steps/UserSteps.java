package org.codereuse.serenity.demo.imdb.steps;

import static com.google.common.truth.Truth.assertThat;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.codereuse.serenity.demo.imdb.pages.FindResultsPage;
import org.codereuse.serenity.demo.imdb.pages.HomePage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Theo on 29/03/15.
 */
public class
UserSteps extends ScenarioSteps {

    HomePage homePage;
    FindResultsPage findResultsPage;

    private List<String> searchResults = new ArrayList<String>();

    @Step("Open IMDB website")
    public void opens_imdb_home_page() {
        homePage.openImdb();
    }

    @Step("Search for '{0}' movie")
    public void searches_for_movie(String title) {
        homePage.searchForMovie(title);
        this.searchResults = findResultsPage.getResultsList();
    }

    @Step
    public void search_header_should_contain(String searchedTitle) {
        String searchHeader = findResultsPage.getFindHeader();
        assertThat(searchHeader).contains(searchedTitle);
    }

    @Step("Search should return {0} movie titles")
    public void should_see_number_of_titles_displayed(int expected) {
        assertThat(searchResults.size()).isEqualTo(expected);
    }

    @Step("Should see '{0}' in search results")
    public void should_see_in_search_results(String movieTitle) {
        assertThat(searchResults).contains(movieTitle);
    }
}
