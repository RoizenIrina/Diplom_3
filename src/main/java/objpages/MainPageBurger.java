package objpages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPageBurger {

        private final WebDriver driver;
        private final static String mainPage = "https://stellarburgers.nomoreparties.site/";

        private final By
    // https://stellarburgers.nomoreparties.site/
                authorizationButton = By.xpath("/html/body/div[1]/div/main/section[2]/div/button"),
                personalAccountElement = By.xpath("html/body/div[1]/div/header/nav/a/p"),
                ingredientSauceLink = By.xpath("/html/body/div[1]/div/main/section[1]/div[1]/div[2]/span"),
                checkSauceDisplayed = By.xpath("/html/body/div[1]/div/main/section[1]/div[2]/h2[2]"),
                ingredientStuffingLink = By.xpath("/html/body/div[1]/div/main/section[1]/div[1]/div[3]/span"),
                checkStuffingDisplayed = By.xpath("/html/body/div[1]/div/main/section[1]/div[2]/h2[3]"),
                ingredientBunsLink = By.xpath("/html/body/div[1]/div/main/section[1]/div[1]/div[1]/span"),
                checkBunsDisplayed = By.xpath("/html/body/div[1]/div/main/section[1]/div[2]/h2[1]"),
                orderButton = By.xpath("//*[contains(text(), 'Оформить заказ')]");



    // проверить работает ли element.is_displayed()
        // boolean eleSelected= driver.findElement(By.xpath("xpath")).isDisplayed();


        public MainPageBurger(WebDriver driver) {
            this.driver = driver;
        }

        public void open (){
            driver.get(mainPage);
        }

        // 	вход по кнопке «Войти в аккаунт» на главной
        public void findCheckAndClickAuthorizationButton(By authorizationButton ) {
            new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(authorizationButton));
            Object elementAuthorizationButton = driver.findElement(authorizationButton);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elementAuthorizationButton);
            new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(authorizationButton));
            driver.findElement(authorizationButton).click();
        }

            // 	вход в личный кабинет
        public void findAndClickPersonalAccountElement(By personalAccountElement) {
            new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(personalAccountElement));
            driver.findElement(personalAccountElement).click();
        }

        // загрузка стартовой страницы после авторизации и наличие кнопки "Оформить заказ"
        public boolean findOrderButton () {
            new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(orderButton));
            try {
                return driver.findElement(orderButton).isDisplayed();
            } catch (NoSuchElementException e) {
                return false;
            }
        }

          // метод того что при нажатии ссылки соусов меню автоматически скролится до соусов
        public boolean checkSauceLinkDisplayed () {
            driver.findElement(ingredientSauceLink).click();
            try {
                return driver.findElement(checkSauceDisplayed).isDisplayed();
            } catch (NoSuchElementException e) {
                return false;
            }
        }

          // метод того что при нажатии ссылки соусов меню автоматически скролится до начинки
        public boolean checkStuffingLinkDisplayed() {
            driver.findElement(ingredientStuffingLink).click();
            try {
                return driver.findElement(checkStuffingDisplayed).isDisplayed();
            } catch (NoSuchElementException e) {
                return false;
            }
        }
    // метод того что при нажатии ссылки соусов меню автоматически скролится до булок
         public boolean checkBunsLinkDisplayed () {
             driver.findElement(ingredientStuffingLink).click(); //(сначала отмотаем меню тк булки и так стартовые)
             driver.findElement(ingredientBunsLink).click();
             try {
                 return driver.findElement(checkBunsDisplayed).isDisplayed();
             } catch (NoSuchElementException e) {
                 return false;
             }
         }


    //конец класса
    }

