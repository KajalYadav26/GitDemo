package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BasePage;

public class HomePage extends BasePage {

    private By departureCityDropdown = By.name("fromPort");

    private By destinationCityDropdown = By.name("toPort");

    private By findFlightsButton =
            By.xpath("//input[@value='Find Flights']");



    public HomePage(WebDriver driver) {

        super(driver);
    }

    public void selectDepartureCity(String city) {

        selectByVisibleText(departureCityDropdown, city);

    }

    public void selectDestinationCity(String city) {

        selectByVisibleText(destinationCityDropdown, city);

    }

    public void clickFindFlights() {

        clickElement(findFlightsButton);
    }


}
