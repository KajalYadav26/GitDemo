package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.testng.Assert;
import org.openqa.selenium.WebDriver;

import pages.HomePage;
import pages.FlightSelectionPage;
import pages.PurchasePage;
import pages.ConfirmationPage;

import utils.DriverFactory;
import utils.FileUtil;
import utils.ScreenshotUtil;

import java.util.List;
import java.util.Map;

public class FlightBookingSteps {

    private WebDriver driver;

    private HomePage homePage;

    private FlightSelectionPage flightSelectionPage;

    private PurchasePage purchasePage;

    private ConfirmationPage confirmationPage;

    @Given("User launches BlazeDemo application")
    public void user_launches_blaze_demo_application() {

        driver = DriverFactory.getDriver();

        driver.get("https://blazedemo.com");

        homePage = new HomePage(driver);
    }
    @When("User selects departure city {string}")
    public void user_selects_departure_city(String city) {

        homePage.selectDepartureCity(city);
    }

    @When("User selects destination city {string}")
    public void user_selects_destination_city(String city) {

        homePage.selectDestinationCity(city);
    }


    @When("User clicks Find Flights")
    public void user_clicks_find_flights() {

        homePage.clickFindFlights();

        flightSelectionPage =
                new FlightSelectionPage(driver);
    }
    @When("User selects the cheapest flight")
    public void user_selects_the_cheapest_flight() {

        flightSelectionPage.selectCheapestFlight();

        purchasePage =
                new PurchasePage(driver);
    }

    @When("User enters passenger details")
    public void user_enters_passenger_details(DataTable dataTable) {

        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

        purchasePage.enterPassengerDetails(
                data.get(0).get("Name"),
                data.get(0).get("Address"),
                data.get(0).get("City"),
                data.get(0).get("State"),
                data.get(0).get("ZipCode"),
                data.get(0).get("CardNumber"),
                data.get(0).get("CardHolderName")
        );
    }

    @When("User purchases the flight")
    public void user_purchases_the_flight() {

        purchasePage.clickPurchaseFlight();

        confirmationPage =
                new ConfirmationPage(driver);
    }
    @Then("Booking confirmation page should be displayed successfully")
    public void booking_should_be_completed_successfully() {

        String actualMessage =
                confirmationPage.getSuccessMessage();

        Assert.assertTrue(
                actualMessage.contains(
                        "Thank you for your purchase today!"
                )
        );

        System.out.println(
                "Booking Id : "
                        + confirmationPage.getBookingId()
        );


    }

    @Then("Confirmation ID should be captured and saved to file")
    public void capture_confirmation_id() {

        String bookingId =
                confirmationPage.getBookingId();

        System.out.println(
                "Booking Id : " + bookingId
        );

        FileUtil.saveBookingId(
                bookingId
        );

        ScreenshotUtil.captureScreenshot(
                driver, "BookingConfirmation"
        );
        driver.quit();
    }
}