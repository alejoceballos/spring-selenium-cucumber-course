package com.momo2x.course.springselcumber.page.google;

import com.momo2x.course.springselcumber.page.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class SearchResult extends BasePage {

    @FindBy(id = "logo")
    private WebElement homeLink;

    public SearchResult(final WebDriver webDriver, final WebDriverWait webDriverWait) {
        super(webDriver, webDriverWait);
    }

    @Override
    public boolean isDisplayed() {
        return this.getWebDriverWait().until(driver -> this.homeLink.isDisplayed());
    }
}
