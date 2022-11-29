package org.example;

import io.qameta.allure.junit4.DisplayName;
import objpages.AuthorizationPage;
import objpages.MainPageBurger;
import objpages.RegistrationPage;
import objpages.ResetPasswordPage;
import org.Generator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.Random;
import static org.junit.Assert.assertEquals;

public class AuthorizationTest {
    WebDriver driver = new ChromeDriver();

    @Before
    public void setUp(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        RegistrationPage objRegistrationPage = new RegistrationPage(driver);
        objRegistrationPage.open();
        objRegistrationPage.createNewUser(Generator.getLogin(), Generator.getEmail(), Generator.getPassword());
          }

    @Test
    @DisplayName("check Authorization path by Authorization Button at MainPage")
    public void mainPageAuthorizationButtonTest() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        MainPageBurger objMainPageBurger = new MainPageBurger(driver);
        objMainPageBurger.open();
        objMainPageBurger.findCheckAndClickAuthorizationButton();
        AuthorizationPage objAuthorizationPage = new AuthorizationPage(driver);
        objAuthorizationPage.authorization(Generator.getEmail(), Generator.getPassword());
        assertEquals("AuthorizationFaild", "Оформить заказ", objMainPageBurger.findOrderButton());
    }

    @Test
    @DisplayName("check Authorization path by Personal Account Element at MainPage")
    public void authorizationByPersonalAccountTest() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        MainPageBurger objMainPageBurger = new MainPageBurger(driver);
        objMainPageBurger.open();
        objMainPageBurger.findAndClickPersonalAccountElement();
        AuthorizationPage objAuthorizationPage = new AuthorizationPage(driver);
        objAuthorizationPage.authorization(Generator.getEmail(), Generator.getPassword());
        assertEquals("AuthorizationFaild", "Оформить заказ", objMainPageBurger.findOrderButton());
    }

    @Test
    @DisplayName("check Authorization path by Authorization Link at Registration Page")
    public void authorizationByRegistrationLinkTest() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        RegistrationPage objRegistrationPage = new RegistrationPage(driver);
        objRegistrationPage.open();
        objRegistrationPage.clickAuthorizationLinkByRegistrationForm();
        AuthorizationPage objAuthorizationPage = new AuthorizationPage(driver);
        objAuthorizationPage.authorization(Generator.getEmail(), Generator.getPassword());
        MainPageBurger objMainPageBurger = new MainPageBurger(driver);
        assertEquals("AuthorizationFaild", "Оформить заказ", objMainPageBurger.findOrderButton());
    }

    @Test
    @DisplayName("check Authorization path by Authorization Link at ResetPassword Page")
    public void authorizationByResetPasswordLinkTest() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        ResetPasswordPage objResetPasswordPage = new ResetPasswordPage(driver);
        objResetPasswordPage.open();
        objResetPasswordPage.clickAuthorizationLinkByResetPasswordForm();
        AuthorizationPage objAuthorizationPage = new AuthorizationPage(driver);
        objAuthorizationPage.authorization(Generator.getEmail(), Generator.getPassword());
        MainPageBurger objMainPageBurger = new MainPageBurger(driver);
        assertEquals("AuthorizationFaild", "Оформить заказ", objMainPageBurger.findOrderButton());
    }

    @After
    public void teardown() {
        driver.quit();
    }

}
