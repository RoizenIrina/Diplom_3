package objpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AuthorizationPage {
    private final WebDriver driver;
    private final static String authorizationPage = "https://stellarburgers.nomoreparties.site/login";
    private final By
            userEmailAuthorization = By.xpath("/html/body/div/div/main/div/form/fieldset[1]/div/div/input"),
            userPasswordAuthorization = By.xpath("/html/body/div[1]/div/main/div/form/fieldset[2]/div/div/input"),
            loginButton = By.xpath("/html/body/div/div/main/div/form/button"),
            resetPasswordLink = By.xpath("/html/body/div[1]/div/main/div/div/p[2]/a"),
            registrationLink = By.xpath("/html/body/div[1]/div/main/div/div/p[1]/a");

        public AuthorizationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open (){
        driver.get(authorizationPage);
    }

    public void authorization (String email, String password){
        driver.findElement(userEmailAuthorization).clear();
        driver.findElement(userEmailAuthorization).click();
        driver.findElement(userEmailAuthorization).sendKeys(email);
        driver.findElement(userPasswordAuthorization).clear();
        driver.findElement(userPasswordAuthorization).sendKeys(password);
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(loginButton));
        driver.findElement(loginButton).click();
        }

    public void clickResetPasswordLink (By resetPasswordLink){
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(resetPasswordLink));
        driver.findElement(resetPasswordLink).click();
    }

    public void clickRegistrationLink (){
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(registrationLink));
        driver.findElement(registrationLink).click();
    }

    public String checkLoginButton () {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(loginButton));
        return driver.findElement(loginButton).getText();
    }
}
