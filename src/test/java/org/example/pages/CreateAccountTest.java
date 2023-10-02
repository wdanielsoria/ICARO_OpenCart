package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateAccountTest {
    private WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new FirefoxDriver();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void createAccountTest() {
        HomePage homePage = new HomePage(driver);
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        AccountCreatedPage accountCreatedPage = new AccountCreatedPage(driver);

        homePage.open();
        homePage.clickMyAccount();
        myAccountPage.clickRegister();

        registerPage.fillRegistrationForm("Daniel", "Soria", "wds@example.com", "1234567890", "password123", "password123");
        registerPage.agreePrivacyPolicy();
        registerPage.clickContinue();

        String successMessage = accountCreatedPage.getSuccessMessage();
        Assert.assertTrue(successMessage.contains("Congratulations! Your new account has been successfully created!"));
    }
}