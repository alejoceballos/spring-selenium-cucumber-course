package com.momo2x.course.springselcumber.page;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

@RequiredArgsConstructor
public abstract class BasePage {

    @Getter
    private final WebDriver webDriver;

    @Getter
    private final WebDriverWait webDriverWait;

    public abstract boolean isDisplayed();

    @PostConstruct
    private void init() {
        PageFactory.initElements(this.webDriver, this);
    }
}
