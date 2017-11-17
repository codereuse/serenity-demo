package org.codereuse.serenity.demo.imdb;

import io.qameta.allure.*;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Screenshots;
import net.thucydides.core.annotations.Steps;
import org.codereuse.serenity.demo.imdb.steps.UserSteps;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

/**
 * Created by Theo on 29/03/15.
 */
@RunWith(SerenityRunner.class)
@Epic("Some epic example")
@Feature("Some feature example")
public class SmokeTest {

    @Managed
    public WebDriver driver;

    @Steps
    public UserSteps user;

    @Test
    @Story("Test for a specific story")
    @Story("And it can even belong to a second story")
    @Screenshots(afterEachStep = true)
    @Severity(SeverityLevel.NORMAL)
    public void shouldBeAbleToSearchForMovie() {
        user.opens_imdb_home_page();
        user.searches_for_movie("Titanic");
        user.search_header_should_contain("Titanic");
        user.should_see_number_of_titles_displayed(2);
        user.should_see_in_search_results("Titanic (1997)");
    }

    @Test
    @Ignore
    @Severity(SeverityLevel.MINOR)
    public void shouldBeIgnored(){
        //This method is intended to be empty as it is going to be ignored.
    }

    @Test
    @Screenshots(afterEachStep = true)
    @Severity(SeverityLevel.BLOCKER)
    public void shouldFail(){
        user.opens_imdb_home_page();
        user.searches_for_movie("Titanic");
        //This line should make the test fail.
        user.search_header_should_contain("Godfather");
    }
}
