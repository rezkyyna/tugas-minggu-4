package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoQA {
    private WebDriver driver;

    public DemoQA() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[normalize-space()='My Account']")
    private WebElement account;
    @FindBy(xpath = "//input[@id='username']")
    private WebElement username;
    @FindBy(xpath = "//input[@id='password']")
    private WebElement password;
    @FindBy(xpath = "//button[@name='login']")
    private WebElement btnlogin;
    @FindBy(xpath = "//a[@class='custom-logo-link']//img[@alt='ToolsQA Demo Site']")
    private WebElement logoClick;

    @FindBy(xpath = "//a[normalize-space()='pink drop shoulder oversized t shirt']")
    private WebElement chooseShirt;
    @FindBy(xpath = "//select[@id='pa_color']")
    private WebElement colorShirt;
    @FindBy(xpath = "//select[@id='pa_size']")
    private WebElement sizeShirt;
    @FindBy(xpath = "//button[normalize-space()='Add to cart']")
    private WebElement addCart;
    @FindBy(xpath = "//div[@role='alert']")
    private WebElement txtMsgAdded;
    @FindBy(xpath = "//a[@class='button wc-forward']")
    private WebElement btnCart;
    @FindBy(xpath = "//h1[@class='page-title']")
    private WebElement pageTitle;




    public void login() {
        account.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        username.sendKeys("Rezkykarunia8@gmail.com");
        password.sendKeys("Kitabersama");
        btnlogin.click();
    }

    public void logoClick() {
        logoClick.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1100)");
    }

    public void addProduct() {
        chooseShirt.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,800)");
        colorShirt.sendKeys("Pink");
        sizeShirt.sendKeys("36");
        addCart.click();
    }
    public void goToCart(){
        btnCart.click();
    }

    public String getTxtCart(){
        return pageTitle.getText();
    }

}


