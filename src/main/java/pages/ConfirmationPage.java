
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.BasePage;

public class ConfirmationPage extends BasePage {

    private By successMessage =
            By.tagName("h1");

    private By bookingId =
            By.xpath("//table/tbody/tr[1]/td[2]");

    public ConfirmationPage(WebDriver driver) {
        super(driver);
    }

    public String getSuccessMessage() {

        return getElementText(successMessage);

    }

    public String getBookingId() {
        return getElementText(bookingId);

    }
}