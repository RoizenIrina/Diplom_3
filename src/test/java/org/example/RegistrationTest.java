package org.example;

import another.YandexOptions;
import io.qameta.allure.junit4.DisplayName;
import objpages.AuthorizationPage;
import objpages.MainPageBurger;
import objpages.RegistrationPage;
import another.Generator;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.assertEquals;


public class RegistrationTest {

    //WebDriver driver = new ChromeDriver();//когда нужно в Хроме тестировать
    WebDriver driver = new ChromeDriver(YandexOptions.getYandexOptions());// когда нужно в Яндексе тестировать


    @Test
    @DisplayName("check Registration - creating user")
    public void checkRegistrationTest() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        AuthorizationPage objAuthorizationPage = new AuthorizationPage(driver);
        objAuthorizationPage.open();
        objAuthorizationPage.clickRegistrationLink();
        RegistrationPage objRegistrationPage = new RegistrationPage(driver);
        objRegistrationPage.createNewUser(Generator.getLogin(), Generator.getEmail(), Generator.getPassword());
        objAuthorizationPage.authorization(Generator.getEmail(), Generator.getPassword());
        MainPageBurger objMainPageBurger = new MainPageBurger(driver);
        assertEquals("RegistrationFaild", "Оформить заказ", objMainPageBurger.findOrderButton());
    }

    @Test
    @DisplayName("check Registration - check Error Massage")
    public void checkErrorMassageTest() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        RegistrationPage objRegistrationPage = new RegistrationPage(driver);
        objRegistrationPage.open();
        objRegistrationPage.createNewUser(Generator.getLogin(), Generator.getEmail(), "12345");
        objRegistrationPage.findErrorMessage();
        assertEquals("RegistrationFaild", "Некорректный пароль", objRegistrationPage.checkErrorMessage());
    }

    @After
    public void teardown() {
        driver.quit();
    }

}
