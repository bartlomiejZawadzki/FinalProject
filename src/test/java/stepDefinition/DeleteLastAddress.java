package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AddNewAdddressFormPage;
import pages.LastAddresDeleteFormPage;
import pages.UserLogInFormPage;

import java.util.concurrent.TimeUnit;

public class DeleteLastAddress   {
    private WebDriver driver;

    @Given("logged in address page")
    public void logIntoAddresses(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
        UserLogInFormPage logInFormPage = new UserLogInFormPage(driver);
        logInFormPage.logIn("jlcfgaivperdnelxup@kvhrr.com", "haslo");
    }

    @When("deleting last added address")
    public void deleteLastAddedAddress(){
        AddNewAdddressFormPage adddressFormPage = new AddNewAdddressFormPage(driver);
        adddressFormPage.addingAddress();

        LastAddresDeleteFormPage lastAddresDeleteFormPage = new LastAddresDeleteFormPage(driver);
        lastAddresDeleteFormPage.getLastAddressToDelete().click();

        Assert.assertEquals("Address successfully deleted!", lastAddresDeleteFormPage.getDeleteSuccesMessage());

    }

    @Then("back to main page")
    public void backToMainPage(){
        WebElement mainPage = driver.findElement(By.xpath("//*[@id=\"main\"]/footer/a[2]"));
        mainPage.click();
        driver.quit();
    }


}
