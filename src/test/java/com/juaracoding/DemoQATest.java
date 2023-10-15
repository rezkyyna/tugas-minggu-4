package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.DemoQA;
import com.juaracoding.utils.Constants;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class DemoQATest {
    private WebDriver driver;
    private DemoQA demoQA;
    private Actions actions;

    @BeforeClass
    public void setUp() {
        DriverSingleton.getInstance(Constants.CHROME);
        driver = DriverSingleton.getDriver();
        driver.get(Constants.URL);
        demoQA = new DemoQA();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)");

    }

    @AfterClass
    public void finish() {
        DriverSingleton.delay(3);
        DriverSingleton.closeObjectInstance();

    }

    @Test(priority = 1)
    public void loginError(){
        demoQA.loginform("RezkyKarunia8@gmail.com", "");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,700)");
        Assert.assertEquals(demoQA.getTxtErrorLogin(), "Error: The password field is empty.");
    }
    @Test(priority = 2)
    public void loginAccount(){
        demoQA.clearUsername();
        demoQA.login();
    }

    @Test(priority = 3)
    public void goToMenu() {
        demoQA.logoClick();
    }

    @Test(priority = 4)
    public void testaddCart() {
        demoQA.addProduct();
    }

    @Test(priority = 5)
    public void testshowCart() {
        demoQA.goToCart();
        Assert.assertEquals(demoQA.getTxtCart(), "CART");
    }

}
