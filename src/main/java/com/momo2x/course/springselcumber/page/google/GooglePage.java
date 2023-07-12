package com.momo2x.course.springselcumber.page.google;

import com.momo2x.course.springselcumber.page.BasePage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GooglePage extends BasePage {

    @Getter
    private final SearchComponent searchComponent;

    @Getter
    private final SearchResult searchResult;

    @FindBy(id = "L2AGLb")
    private WebElement acceptAllButton;

    private final String url;

    public GooglePage(
            final WebDriver webDriver,
            final WebDriverWait webDriverWait,
            final SearchComponent searchComponent,
            final SearchResult searchResult,
            final @Value("${application.url:https://www.google.com}") String url
            ) {
        super(webDriver, webDriverWait);

        this.searchComponent = searchComponent;
        this.searchResult = searchResult;
        this.url = url;
    }

    public void goToUrl() {
        this.getWebDriver().get(this.url);
        this.getWebDriverWait().until(driver -> this.isDisplayed() || this.acceptAllButton.isDisplayed());

        if (this.acceptAllButton.isDisplayed()) {
            this.acceptAllButton.click();
        }

        this.getWebDriverWait().until(driver -> this.isDisplayed());
    }

    @Override
    public boolean isDisplayed() {
        return this.searchComponent.isDisplayed();
    }
}
