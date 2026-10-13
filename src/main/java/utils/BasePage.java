package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement waitForVisible(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void clickElement(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
    public void enterText(By locator, String text){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);

    }
    public String getElementText(By locator){
        return waitForVisible(locator).getText();
    }

    public List<WebElement> waitForAllVisible(By locator){
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public void selectByVisibleText(By locator, String text){
        WebElement dropdown = waitForVisible(locator);
        Select select = new Select(dropdown);
        select.selectByVisibleText(text);
    }

}

