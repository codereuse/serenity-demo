package org.codereuse.serenity.demo.imdb.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

/**
 * Created by Theo on 29/03/15.
 */
@DefaultUrl("http://www.imdb.com")
public class HomePage extends PageObject {

    private final static By searchField = By.cssSelector("#navbar-query");

    public void openImdb() {
        getDriver().get("http://www.imdb.com");
        getDriver().manage().window().maximize();
    }

    public void searchForMovie(String movie) {
            find(searchField).then().typeAndEnter(movie);
    }
}
