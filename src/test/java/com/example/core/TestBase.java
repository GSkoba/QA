package com.example.core;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class TestBase {
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    protected WebDriver driver;

    @Before
    public void setUp() throws Exception {
        init();

    }

    @After
    public void tearDown() throws Exception {
        stop();
    }

    public void init() {
        ChromeDriverService driverService = ChromeDriverService.createDefaultService();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("allow-file-access-from-files");
        options.addArguments("use-fake-device-for-media-stream");
        options.addArguments("use-fake-ui-for-media-stream");
        options.addArguments("--no-sandbox");
        driver = new ChromeDriver(driverService, options);
        driver.manage().window().setSize(new Dimension(1600, 1200));
        baseUrl = "https://ok.ru/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        driver.get(baseUrl + "/");
    }

    public void stop() {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

}
