package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BasePage;

import java.util.List;

public class FlightSelectionPage extends BasePage {

    private WebDriver driver;

    private By priceColumn =
            By.xpath("//table/tbody/tr/td[6]");

    private By chooseFlightButtons =
            By.xpath("//table/tbody/tr/td[1]/input");

    private By flightNumberColumn =
            By.xpath("//table/tbody/tr/td[2]");

    private By airLineColumn =
            By.xpath("//table/tbody/tr/td[3]");

    public FlightSelectionPage(WebDriver driver) {
        //this.driver = driver;
        super(driver);
    }

    public void selectCheapestFlight() {

        List<WebElement> prices =
                waitForAllVisible(priceColumn);

        List<WebElement> buttons =
                waitForAllVisible(chooseFlightButtons);

        List<WebElement> flight =
                waitForAllVisible(flightNumberColumn);

        List<WebElement> airline =
                waitForAllVisible(airLineColumn);

        double lowestPrice =
                Double.MAX_VALUE;

        int Index = 0;

        String SelectedFlightNumber ="";
        String SelectedAirLine= "";

        for (int i = 0; i < prices.size(); i++) {

            String priceText =
                    prices.get(i).getText();

            priceText =
                    priceText.replace("$", "");

            double currentPrice =
                    Double.parseDouble(priceText);

            System.out.println("Flight " + (i+1)+"Price = $"+ currentPrice);

            if (currentPrice < lowestPrice ) {

                lowestPrice = currentPrice;

                Index = i;
                SelectedFlightNumber = flight.get(i).getText();
                SelectedAirLine = airline.get(i).getText();

            }
        }

        System.out.println("Cheepest Price = $"+lowestPrice);
        System.out.println("Airline Name = $"+SelectedAirLine);
        System.out.println("Flight Number = $"+SelectedFlightNumber);
        System.out.println("Selecting Flight No. = "+(Index + 1));
        buttons.get(Index).click();
    }

}