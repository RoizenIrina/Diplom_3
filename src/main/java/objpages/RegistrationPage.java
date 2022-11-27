package objpages;

import org.example.Client;
import org.example.Generator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage {

    private final WebDriver driver;
    private final static String registrationPage = "https://stellarburgers.nomoreparties.site/register";

    private final By

            userNameRegistration = By.xpath("/html/body/div[1]/div/main/div/form/fieldset[1]/div/div/input"),
            userEmailRegistration = By.xpath("/html/body/div[1]/div/main/div/form/fieldset[2]/div/div/input"),
            userPasswordRegistration = By.xpath("/html/body/div[1]/div/main/div/form/fieldset[3]/div/div/input"),
            registrationButton = By.xpath("/html/body/div[1]/div/main/div/form/button"),
            errorMessage = By.xpath("//*[contains(text(), 'Некорректный пароль')]"),
            authorizationLinkByRegistrationForm = By.xpath("/html/body/div[1]/div/main/div/div/p/a");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

   //завели логин
    public void userNameRegistration(String login)
    {        driver.findElement(userNameRegistration).sendKeys(login);
    }
// завели почту
    public void userEmailRegistration(String email){
        driver.findElement(userEmailRegistration).sendKeys(email);
    }
// завели пароль
    public void userPasswordRegistration(String password){
        driver.findElement(userPasswordRegistration).sendKeys(password);
    }
// кликнули Зарегистрироваться
    public void clickRegistrationButton (){
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(registrationButton));
        driver.findElement(registrationButton).click();
    }

    //	вход через кнопку в форме регистрации
    public void clickAuthorizationLinkByRegistrationForm (By authorizationLinkByRegistrationForm){
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(authorizationLinkByRegistrationForm));
        driver.findElement(authorizationLinkByRegistrationForm).click();
    }

    // наличие сообщения об ошибке пароля
    public boolean findErrorMessage (By errorMessage ) {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        try {
            return driver.findElement(errorMessage).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
// текст ошибки
    public String checkErrorMessage (By errorMessage ) {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        return driver.findElement(errorMessage).getText();

    }

}
