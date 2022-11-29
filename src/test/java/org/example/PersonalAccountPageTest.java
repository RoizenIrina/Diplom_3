package org.example;

import io.qameta.allure.junit4.DisplayName;
import objpages.AuthorizationPage;
import objpages.MainPageBurger;
import objpages.PersonalAccountPage;
import objpages.RegistrationPage;
import org.Generator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import static org.junit.Assert.assertEquals;

public class PersonalAccountPageTest {
    WebDriver driver = new ChromeDriver();

    @Before
    public void setUp(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        RegistrationPage objRegistrationPage = new RegistrationPage(driver);
        objRegistrationPage.open();
        objRegistrationPage.createNewUser(Generator.getLogin(), Generator.getEmail(), Generator.getPassword());
        AuthorizationPage objAuthorizationPage = new AuthorizationPage(driver);
//        objAuthorizationPage.open();
        objAuthorizationPage.authorization(Generator.getEmail(), Generator.getPassword());
    }

    @Test
    @DisplayName("check enter in Personal Account")
    public void checkPersonalAccountLinkTest() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        MainPageBurger objMainPageBurger = new MainPageBurger(driver);
        objMainPageBurger.open();//оставляю повторный опен тк вдруг авторизация не будет возвращать на страницу ссылки
        objMainPageBurger.findAndClickPersonalAccountElement();
        PersonalAccountPage objPersonalAccountPage = new PersonalAccountPage(driver);
        assertEquals("PersonalAccountEnterLinkFaild", "Выход", objPersonalAccountPage.checkLogInPersonalAccount());
    }

    @Test
    @DisplayName("check exit from Account by Link at Personal Account")
    public void checkExitButtonTest() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        PersonalAccountPage objPersonalAccountPage = new PersonalAccountPage(driver);
        objPersonalAccountPage.open();
        objPersonalAccountPage.clickExitButton();
        AuthorizationPage objAuthorizationPage = new AuthorizationPage(driver);
        assertEquals("ExitFaild", "Войти", objAuthorizationPage.checkLoginButton());
    }

    @Test
    @DisplayName("check exit to MainPage by Logo at Personal Account")
    public void checkLogoButtonTest() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        PersonalAccountPage objPersonalAccountPage = new PersonalAccountPage(driver);
        objPersonalAccountPage.open();
        objPersonalAccountPage.clickLogoButton();
        MainPageBurger objMainPageBurger = new MainPageBurger(driver);
        assertEquals("LogoButtonFaild", "Оформить заказ", objMainPageBurger.findOrderButton());
    }

    @Test
    @DisplayName("check exit to MainPage by Constructor Button at Personal Account")
    public void checkConstructorButtonTest() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        PersonalAccountPage objPersonalAccountPage = new PersonalAccountPage(driver);
        objPersonalAccountPage.open();
        objPersonalAccountPage.clickConstructorButton();
        MainPageBurger objMainPageBurger = new MainPageBurger(driver);
        assertEquals("ConstructorButtonFaild", "Оформить заказ", objMainPageBurger.findOrderButton());
    }

        @After       // Закрыть браузер
    public void teardown() {
        driver.quit();
    }
}
