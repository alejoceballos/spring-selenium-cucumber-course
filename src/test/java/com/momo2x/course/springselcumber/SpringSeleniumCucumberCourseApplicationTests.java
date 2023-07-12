package com.momo2x.course.springselcumber;

import com.momo2x.course.springselcumber.page.google.GooglePage;
import com.momo2x.course.springselcumber.util.ScreenshotUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Lazy;

import java.io.IOException;

import static java.lang.Boolean.TRUE;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@SpringBootTest
class SpringSeleniumCucumberCourseApplicationTests {

    @Autowired
    private GooglePage googlePage;

    @Lazy
    @Autowired
    private ScreenshotUtil screenshot;

    @Test
    void contextLoads() {
    }

    @Test
    void googleTest() throws IOException {
        this.googlePage.goToUrl();
        assertThat(this.googlePage.isDisplayed(), is(TRUE));

        this.googlePage.getSearchComponent().search("Test");
        assertThat(this.googlePage.getSearchComponent().isDisplayed(), is(TRUE));
        assertThat(this.googlePage.getSearchResult().isDisplayed(), is(TRUE));
        this.screenshot.takeScreenShot();
    }

    @Test
    void firefoxTest() throws IOException {
        this.googlePage.goToUrl();
        assertThat(this.googlePage.isDisplayed(), is(TRUE));

        this.googlePage.getSearchComponent().search("Test");
        assertThat(this.googlePage.getSearchComponent().isDisplayed(), is(TRUE));
        assertThat(this.googlePage.getSearchResult().isDisplayed(), is(TRUE));
        this.screenshot.takeScreenShot();
    }
}
