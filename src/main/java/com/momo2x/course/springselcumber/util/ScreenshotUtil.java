package com.momo2x.course.springselcumber.util;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Path;

import static org.openqa.selenium.OutputType.FILE;
import static org.springframework.util.FileCopyUtils.copy;

@Lazy
@Component
public class ScreenshotUtil {

    private final WebDriver webDriver;

    private final Path snapshotFile;

    public ScreenshotUtil(
            final WebDriver webDriver,
            @Value("${snapshot.path:/home/ceballos/temp}/${snapshot.file:spring-selenium-cucumber-course-snapshot.png}")
            final Path snapshotFile) {
        this.webDriver = webDriver;
        this.snapshotFile = snapshotFile;
    }

    public void takeScreenShot() throws IOException {
        final var screenShotDriver = (TakesScreenshot) this.webDriver;
        final var file = screenShotDriver.getScreenshotAs(FILE);
        copy(file, this.snapshotFile.toFile());
    }

}
