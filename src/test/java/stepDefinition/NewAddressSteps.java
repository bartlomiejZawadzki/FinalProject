package stepDefinition;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.UserLogInFormPage;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class NewAddressSteps {
    private WebDriver driver;

    @Given("user logged in address page")
    public void logInToAddress() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
        UserLogInFormPage logInFormPage = new UserLogInFormPage(driver);
        logInFormPage.logIn("jlcfgaivperdnelxup@kvhrr.com", "haslo");

    }

    @When("creating a new address")
    public void createNewAddress() {
        WebElement addressButton = driver.findElement(By.xpath("//*[@id=\"addresses-link\"]/span"));
        addressButton.click();
        WebElement createNewAddresLink = driver.findElement(By.partialLinkText("Create"));
        createNewAddresLink.click();
    }

    @Then("^filling in the address form with data \"(.*)\" \"(.*)\" \"(.*)\" \"(.*)\" \"(.*)\" \"(.*)\"$")
    public void fillForm(String alias, String street, String city, String zipCode, String country, String phone) {

        WebElement aliasInput = driver.findElement(By.name("alias"));
        aliasInput.click();
        aliasInput.clear();
        aliasInput.sendKeys(alias);

        WebElement streetInput = driver.findElement(By.name("address1"));
        streetInput.click();
        streetInput.clear();
        streetInput.sendKeys(street);

        WebElement cityInput = driver.findElement(By.name("city"));
        cityInput.click();
        cityInput.clear();
        cityInput.sendKeys(city);

        WebElement zipCodeInput = driver.findElement(By.name("postcode"));
        zipCodeInput.click();
        zipCodeInput.clear();
        zipCodeInput.sendKeys(zipCode);

        WebElement countryInput = driver.findElement(By.name("id_country"));
        countryInput.click();
        countryInput.sendKeys(country);

        WebElement phoneInput = driver.findElement(By.name("phone"));
        phoneInput.click();
        phoneInput.clear();
        phoneInput.sendKeys(phone);

        WebElement saveAddressButton = driver.findElement((By.xpath("//*[@id=\"content\"]/div/div/form/footer/button")));
        saveAddressButton.click();
    }


    @And("^checking the correctness of the new address$")
    public void checkAddress() {
        List<WebElement> addressesList = driver.findElements(By.className("address-body"));

        WebElement addedAddress = addressesList.get(addressesList.size()-1);

        Assert.assertEquals("another address9\n" + "Bartek Zawadzki\n" + "Polna\n" + "Warszawa\n" + "01-001\n" +
                "United Kingdom\n" + "60199222", addedAddress.getText());
    }


}
