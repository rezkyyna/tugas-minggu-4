package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.LoginPage;
import com.juaracoding.utils.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {
//ORANGEHRM
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeClass
    public void setUp() {
        DriverSingleton.getInstance(Constants.CHROME);
        driver = DriverSingleton.getDriver();
        driver.get(Constants.URL);
        loginPage = new LoginPage();
        JavascriptExecutor js = (JavascriptExecutor) driver;

    }

    @AfterClass
    public void finish() {
        DriverSingleton.delay(3);
        DriverSingleton.closeObjectInstance();

    }

    @Test(priority = 1)
    public void testValidLogin() {
        loginPage.loginform("Admin", "admin123");
        Assert.assertEquals(loginPage.getTxtDashboard(), "Dashboard");
        System.out.println("Test Case Valid Login");
    }

    @Test(priority = 2)
    public void testInvalidLogin() {
        loginPage.logout();
        loginPage.loginform("Adminn", "admin123");
        Assert.assertEquals(loginPage.getTxtInvalid(), "Invalid credentials");
        System.out.println("Test Case Invalid Login");

    }

    @Test(priority = 3)
    public void testEmptyUsername() {
        loginPage.clearUsername();
        loginPage.clearPassword();
        loginPage.loginform("", "admin123");
        Assert.assertEquals(loginPage.getTxtErrorMessage(), "Required");
        System.out.println("Test Case Username Error");
    }

    @Test(priority = 4)
    public void testEmptyPassword() {
        loginPage.clearPassword();
        loginPage.loginform("Admin", "");
        Assert.assertEquals(loginPage.getTxtErrorMessage(), "Required");
        System.out.println("Test Case Password Error");
    }
}
