package org.example;

import objpages.AuthorizationPage;
import objpages.MainPageBurger;
import objpages.PersonalAccountPage;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import static org.junit.Assert.assertEquals;


public class PersonalAccountPageTest {
    WebDriver driver = new ChromeDriver();



    @Test
    public void checkExitButtonTest() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        MainPageBurger objMainPageBurger = new MainPageBurger(driver);
        objMainPageBurger.open();
        objMainPageBurger.findCheckAndClickAuthorizationButton();
        AuthorizationPage objAuthorizationPage = new AuthorizationPage(driver);
        objAuthorizationPage.open();
        String email = "kotik2@yandex.ru";
        String password = "kotik222";
        objAuthorizationPage.authorization(email, password);
        objMainPageBurger.findAndClickPersonalAccountElement();
        PersonalAccountPage objPersonalAccountPage = new PersonalAccountPage(driver);
        objPersonalAccountPage.clickExitButton();
        assertEquals("ExitFaild", "Войти", objAuthorizationPage.checkLoginButton());
    }

    @Test
    public void checkLogoButtonTest() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        MainPageBurger objMainPageBurger = new MainPageBurger(driver);
        objMainPageBurger.open();
        objMainPageBurger.findCheckAndClickAuthorizationButton();
        AuthorizationPage objAuthorizationPage = new AuthorizationPage(driver);
        objAuthorizationPage.open();
        String email = "kotik2@yandex.ru";
        String password = "kotik222";
        objAuthorizationPage.authorization(email, password);
        objMainPageBurger.findAndClickPersonalAccountElement();
        PersonalAccountPage objPersonalAccountPage = new PersonalAccountPage(driver);
        objPersonalAccountPage.clickLogoButton();
        assertEquals("LogoButtonFaild", "Оформить заказ", objMainPageBurger.findOrderButton());
    }

    @Test
    public void checkConstructorButtonTest() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        MainPageBurger objMainPageBurger = new MainPageBurger(driver);
        objMainPageBurger.open();
        objMainPageBurger.findCheckAndClickAuthorizationButton();
        AuthorizationPage objAuthorizationPage = new AuthorizationPage(driver);
        objAuthorizationPage.open();
        String email = "kotik2@yandex.ru";
        String password = "kotik222";
        objAuthorizationPage.authorization(email, password);
        objMainPageBurger.findAndClickPersonalAccountElement();
        PersonalAccountPage objPersonalAccountPage = new PersonalAccountPage(driver);
        objPersonalAccountPage.clickConstructorButton();
        assertEquals("ConstructorButtonFaild", "Оформить заказ", objMainPageBurger.findOrderButton());
    }

        @After       // Закрой браузер
    public void teardown() {
        driver.quit();
    }
}
