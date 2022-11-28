package org.example;

import objpages.AuthorizationPage;
import objpages.MainPageBurger;
import objpages.RegistrationPage;
import objpages.ResetPasswordPage;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import static org.junit.Assert.assertEquals;


public class AuthorizationTest {
    WebDriver driver = new ChromeDriver();

    @Test
    public void mainPageAuthorizationButtonTest() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        MainPageBurger objMainPageBurger = new MainPageBurger(driver);
        objMainPageBurger.open();
        objMainPageBurger.findCheckAndClickAuthorizationButton();
        AuthorizationPage objAuthorizationPage = new AuthorizationPage(driver);
        String email = "kotik2@yandex.ru";
        String password = "kotik222";
        objAuthorizationPage.authorization(email, password);
        assertEquals("AuthorizationFaild", "Оформить заказ", objMainPageBurger.findOrderButton());
    }

    @Test
    public void authorizationByPersonalAccountTest() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        MainPageBurger objMainPageBurger = new MainPageBurger(driver);
        objMainPageBurger.open();
        objMainPageBurger.findAndClickPersonalAccountElement();
        AuthorizationPage objAuthorizationPage = new AuthorizationPage(driver);
        String email = "kotik2@yandex.ru";
        String password = "kotik222";
        objAuthorizationPage.authorization(email, password);
        assertEquals("AuthorizationFaild", "Оформить заказ", objMainPageBurger.findOrderButton());
    }

    @Test
    public void authorizationByRegistrationLinkTest() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        RegistrationPage objRegistrationPage = new RegistrationPage(driver);
        objRegistrationPage.open();
        objRegistrationPage.clickAuthorizationLinkByRegistrationForm();
        AuthorizationPage objAuthorizationPage = new AuthorizationPage(driver);
        String email = "kotik2@yandex.ru";
        String password = "kotik222";
        objAuthorizationPage.authorization(email, password);
        MainPageBurger objMainPageBurger = new MainPageBurger(driver);
        assertEquals("AuthorizationFaild", "Оформить заказ", objMainPageBurger.findOrderButton());
    }

    @Test
    public void authorizationByResetPasswordLinkTest() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        ResetPasswordPage objResetPasswordPage = new ResetPasswordPage(driver);
        objResetPasswordPage.open();
        objResetPasswordPage.clickAuthorizationLinkByResetPasswordForm();
        AuthorizationPage objAuthorizationPage = new AuthorizationPage(driver);
        String email = "kotik2@yandex.ru";
        String password = "kotik222";
        objAuthorizationPage.authorization(email, password);
        MainPageBurger objMainPageBurger = new MainPageBurger(driver);
        assertEquals("AuthorizationFaild", "Оформить заказ", objMainPageBurger.findOrderButton());
    }

    @After
    public void teardown() {
        driver.quit();
    }

}
