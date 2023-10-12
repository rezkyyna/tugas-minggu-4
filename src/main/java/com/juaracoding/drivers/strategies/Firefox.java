package com.juaracoding.drivers.strategies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox implements DriverStrategy {
    @Override
    public WebDriver setStrategy() {
        System.out.println("webdriver.gecko.driver, C:\\MyTools\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        return driver;
    }
}
