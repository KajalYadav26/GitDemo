package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.BasePage;

public class PurchasePage extends BasePage {

    private By nameField =
            By.id("inputName");

    private By addressField =
            By.id("address");

    private By cityField =
            By.id("city");

    private By stateField =
            By.id("state");

    private By zipCodeField =
            By.id("zipCode");

    private By creditCardField =
            By.id("creditCardNumber");

    private By nameOnCardField =
            By.id("nameOnCard");

    private By purchaseFlightButton =
            By.xpath("//input[@value='Purchase Flight']");

    public PurchasePage(WebDriver driver) {
        super(driver);
        //this.driver = driver;
    }

    public void enterPassengerDetails(String name, String address, String city, String state, String zipCode, String cardNumber, String cardHolderName) {

        enterText(nameField, name);

        enterText(addressField, address);

        enterText(cityField, city);

        enterText(stateField, state);

        enterText(zipCodeField, zipCode);

        enterText(creditCardField, cardNumber);

        enterText(nameOnCardField, cardHolderName);
    }

    public void clickPurchaseFlight() {

        clickElement(purchaseFlightButton);
    }
}
