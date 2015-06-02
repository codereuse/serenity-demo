package org.codereuse.serenity.demo.imdb.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

/**
 * Created by Theo on 29/03/15.
 */
@DefaultUrl("http://www.imdb.com")
public class HomePage extends PageObject {

    private final static By searchField = By.cssSelector("#navbar-query");

    public void openImdb() {
        open();
        getDriver().manage().window().maximize();
    }

    public void searchForMovie(String movie) {
        try {
            find(searchField).then().typeAndEnter(movie);
        } catch (NoSuchElementException e) {
            throw new AssertionError("Could not find search field");
        }
    }
}
