package objpages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ResetPasswordPage {

    private final WebDriver driver;

    private final static String resetPasswordPage = "https://stellarburgers.nomoreparties.site/forgot-password";
    private final By authorizationLinkByResetPasswordForm = By.xpath("/html/body/div[1]/div/main/div/div/p/a");

    public ResetPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open (){
        driver.get(resetPasswordPage);
    }

//	вход через кнопку в форме восстановления пароля
    public void clickAuthorizationLinkByResetPasswordForm (By authorizationLinkByResetPasswordForm){
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(authorizationLinkByResetPasswordForm));
        driver.findElement(authorizationLinkByResetPasswordForm).click();
    }

    }

