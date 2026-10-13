package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class ScreenshotUtil {

    public static void captureScreenshot(
            WebDriver driver,
            String fileName
    ) {

        try {

            TakesScreenshot screenshot =
                    (TakesScreenshot) driver;

            File source =
                    screenshot.getScreenshotAs(
                            OutputType.FILE
                    );

            File destination =
                    new File(
                            "screenshots/"
                                    + fileName
                                    + ".png"
                    );

            FileUtils.copyFile(
                    source,
                    destination
            );

            System.out.println(
                    "Screenshot captured successfully."
            );

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}