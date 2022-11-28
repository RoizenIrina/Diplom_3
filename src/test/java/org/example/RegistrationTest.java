package org.example;

import objpages.AuthorizationPage;
import objpages.MainPageBurger;
import objpages.RegistrationPage;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.Random;
import static org.junit.Assert.assertEquals;



public class RegistrationTest {
    WebDriver driver = new ChromeDriver();


          @Test
    public void checkRegistrationTest() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        AuthorizationPage objAuthorizationPage = new AuthorizationPage(driver);
        objAuthorizationPage.open();
        objAuthorizationPage.clickRegistrationLink();
        RegistrationPage objRegistrationPage = new RegistrationPage(driver);
           final String login = "something" + new Random().nextInt(10000);
         final String email = "something" + new Random().nextInt(10000) + "@yandex.ru";
           final String password = "something" + new Random().nextInt(10000);
        objRegistrationPage.createNewUser(login,email,password);
        objAuthorizationPage.authorization(email,password);
              MainPageBurger objMainPageBurger = new MainPageBurger(driver);
        assertEquals("RegistrationFaild", "Оформить заказ", objMainPageBurger.findOrderButton());
    }

    @Test
    public void checkErrorMassageTest() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        AuthorizationPage objAuthorizationPage = new AuthorizationPage(driver);
        objAuthorizationPage.open();
        objAuthorizationPage.clickRegistrationLink();
        RegistrationPage objRegistrationPage = new RegistrationPage(driver);
        final String login = "something" + new Random().nextInt(10000);
        final String email = "something" + new Random().nextInt(10000) + "@yandex.ru";
        final String password =  "12345";
        objRegistrationPage.createNewUser(login, email, password);
        objRegistrationPage.findErrorMessage();
        assertEquals("RegistrationFaild", "Некорректный пароль", objRegistrationPage.checkErrorMessage());
    }

    @After
    public void teardown() {
        driver.quit();
    }

}
