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
import pages.AddNewAdddressFormPage;
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

        String mail = "jlcfgaivperdnelxup@kvhrr.com";
        String pass = "haslo";

        logInFormPage.logIn(mail, pass);

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
        AddNewAdddressFormPage adddressFormPage = new AddNewAdddressFormPage(driver);
        adddressFormPage.fillAddress(alias, street, city, zipCode, country, phone);
    }


    @And("^checking the correctness of the new address$")
    public void checkAddress() {
        List<WebElement> addressesList = driver.findElements(By.className("address-body"));
        WebElement addedAddress = addressesList.get(addressesList.size() - 1);
        Assert.assertEquals("another address\n" + "Bartek Zawadzki\n" + "Polna\n" + "Warszawa\n" + "01-001\n" +
                "United Kingdom\n" + "60199222", addedAddress.getText());

        driver.quit();
    }
}
