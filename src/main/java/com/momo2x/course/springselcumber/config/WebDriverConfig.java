package com.momo2x.course.springselcumber.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.time.Duration;

@Configuration
public class WebDriverConfig {

    private final String chromeVersion;

    private final String firefoxVersion;

    private final long webDriverWaitTimeout;

    public WebDriverConfig(
            @Value("${webdriver.chrome.version:114}") final String chromeVersion,
            @Value("${webdriver.firefox.version:115}") final String firefoxVersion,
            @Value("${webdriver.wait.timeout:30}") final long webDriverWaitTimeout) {
        this.chromeVersion = chromeVersion;
        this.firefoxVersion = firefoxVersion;
        this.webDriverWaitTimeout = webDriverWaitTimeout;
    }

    @Bean
    public WebDriver chromeDriver() {
        return WebDriverManager
                .chromedriver()
                .browserVersion(this.chromeVersion)
                .create();
    }

    @Bean
    @Primary
    public WebDriver firefoxDriver() {
        return WebDriverManager
                .firefoxdriver()
                .browserVersion(this.firefoxVersion)
                .create();
    }

    @Bean
    public WebDriverWait webDriverWait(final WebDriver webDriver) {
        return new WebDriverWait(webDriver, Duration.ofSeconds(this.webDriverWaitTimeout));
    }
}
