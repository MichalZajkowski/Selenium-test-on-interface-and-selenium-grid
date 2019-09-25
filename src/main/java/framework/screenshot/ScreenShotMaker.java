package framework.screenshot;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;

public class ScreenShotMaker {

    private static String FOLDER = "screenshot";

    public static void takeErrorScreenShot(WebDriver webDriver) {
        try {
            shot(webDriver);
        } catch (IOException ex) {
            //no-op
        }
    }

    private static void shot(WebDriver webDriver) throws IOException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss");
        long time = new Date().getTime();
        Path screenShotPath = Paths.get(FOLDER, "screenshot_" + dateFormat.format(time));
        TakesScreenshot scrShot = ((TakesScreenshot) webDriver);
        File screenShotFile = scrShot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShotFile, new File(screenShotPath + ".png"));
    }
}
