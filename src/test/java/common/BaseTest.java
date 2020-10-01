package common;

import framework.configuration.Configuration;
import framework.grid.SeleniumGrid;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.security.InvalidParameterException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    private final Configuration configuration = new Configuration().getInstance();
    private static final Logger logger = LoggerFactory.getLogger(BaseTest.class);
    private static final SeleniumGrid testOnGrid = new SeleniumGrid();
    protected static WebDriver webDriver;
    private static final String DRIVER = "driver";
    private final String REMOTE_HOST_URL = configuration.getPropertyFromFile("remoteHostURL");
    private final boolean doesGridActive = Boolean.parseBoolean(configuration.getPropertyFromFile("localhostGridEnabled"));

    protected BaseTest() {
        try {
            setDriver();
        } catch (InvalidParameterException e) {
            logger.warn("Missing 'driver' property. Set driver to default");
            configuration.setProperty(DRIVER, "firefox");
            configuration.setProperty("webdriver.gecko.driver", configuration.getPropertyFromFile("geckoDriver"));
            webDriver = new FirefoxDriver();
        } finally {
            if (!"remote".equals(configuration.getProperty(DRIVER))) {
                Objects.requireNonNull(webDriver).manage().window().maximize();
            }
        }
    }

    protected static void navigateToPage(String url) {
        webDriver.navigate().to(url);
    }

    protected void tearDownGridIfNeeded() {
        if (doesGridActive) {
            testOnGrid.stopNode();
            testOnGrid.stopHub();
            logger.info("Grid closed!");
        }
    }

    private void setDriver() throws InvalidParameterException {
        switch (configuration.getProperty(DRIVER)) {
            case "chrome" -> setChromeDriver();
            case "firefox" -> setFirefoxDriver();
            case "remoteChrome" -> setRemoteChromeDriver();
            case "remoteFirefox" -> setRemoteFirefoxDriver();
            case "remoteOnLocalhost" -> setRemoteOnLocalhost();
        }
    }

    private void setChromeDriver() {
        configuration.setProperty("webdriver.chrome.driver", configuration.getPropertyFromFile("chromeDriver"));
        webDriver = new ChromeDriver();
    }

    private void setFirefoxDriver() {
        configuration.setProperty("webdriver.gecko.driver", configuration.getPropertyFromFile("geckoDriver"));
        webDriver = new FirefoxDriver();
    }

    private void setRemoteFirefoxDriver() {
        try {
            RemoteWebDriver remoteWebDriver = new RemoteWebDriver(new URL(REMOTE_HOST_URL), DesiredCapabilities.firefox());
            remoteWebDriver.setFileDetector(new LocalFileDetector());
            webDriver = remoteWebDriver;
        } catch (MalformedURLException e) {
            logger.error("Missing RemoteWebDriver instance! ", e);
        }
    }

    private void setRemoteChromeDriver() {
        try {
            RemoteWebDriver remoteWebDriver = new RemoteWebDriver(new URL(REMOTE_HOST_URL), DesiredCapabilities.chrome());
            remoteWebDriver.setFileDetector(new LocalFileDetector());
            webDriver = remoteWebDriver;
        } catch (MalformedURLException e) {
            logger.error("Missing RemoteWebDriver instance! ", e);
        }
    }

    private void setRemoteOnLocalhost() {
        configuration.setProperty("webdriver.chrome.driver", configuration.getPropertyFromFile("chromeDriver"));
        setUpGrid();
        try {
            RemoteWebDriver remoteWebDriver = new RemoteWebDriver(new URL(REMOTE_HOST_URL), DesiredCapabilities.chrome());
            remoteWebDriver.setFileDetector(new LocalFileDetector());
            webDriver = remoteWebDriver;
        } catch (MalformedURLException e) {
            logger.error("Missing RemoteWebDriver instance ", e);
        }
    }

    private void setUpGrid() {
        if (doesGridActive) {
            testOnGrid.runHub();
            testOnGrid.runNode();
            try {
                TimeUnit.SECONDS.sleep(20);
            } catch (InterruptedException e) {
                logger.error("Timeout corrupted! ", e);
            }
            logger.info("Grid set up and ready for test processing!");
        }
    }
}
