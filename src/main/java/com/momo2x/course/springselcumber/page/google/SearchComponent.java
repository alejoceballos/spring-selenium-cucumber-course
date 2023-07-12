package com.momo2x.course.springselcumber.page.google;

import com.momo2x.course.springselcumber.page.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

import static org.openqa.selenium.Keys.TAB;

@Component
public class SearchComponent extends BasePage {

    @FindBy(name = "q")
    private WebElement searchBox;

    @FindBy(name = "btnK")
    private List<WebElement> searchButtons;

    public SearchComponent(final WebDriver webDriver, final WebDriverWait webDriverWait) {
        super(webDriver, webDriverWait);
    }

    public void search(final String keyword) {
        this.searchBox.sendKeys(keyword);
        this.searchBox.sendKeys(TAB);
        this.searchButtons.stream()
                .filter(WebElement::isDisplayed)
                .filter(WebElement::isEnabled)
                .findFirst()
                .ifPresent(WebElement::click);
    }

    @Override
    public boolean isDisplayed() {
        return this.getWebDriverWait().until(driver -> this.searchBox.isDisplayed());
    }
}
