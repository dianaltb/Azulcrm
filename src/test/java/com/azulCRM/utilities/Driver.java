package com.azulCRM.utilities;


import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {

    private Driver(){}
    private static final InheritableThreadLocal<WebDriver> POOL = new InheritableThreadLocal<>();

    public static WebDriver getDriver() {
        if (POOL.get() == null) {
            String browser = ConfigurationReader.getProperty("browser");

            switch (browser) {
                case "chrome":
//                    ChromeOptions options = new ChromeOptions();
//                    options.addArguments("--headless=new", "--disable-gpu");
                    POOL.set(new ChromeDriver());
                    break;
                case "firefox":
                    POOL.set(new FirefoxDriver());
                    break;
                default:
                    throw new RuntimeException("Unsupported browser: " + browser);
            }
            POOL.get().manage().window().maximize();
            POOL.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        return POOL.get();
    }

    public static void closeDriver() {
        if (POOL.get() != null) {
            POOL.get().quit();  // Close all tabs and end the session
            POOL.remove();
        }
    }
}