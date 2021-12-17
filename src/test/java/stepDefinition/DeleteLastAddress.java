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

public class DeleteLastAddress {
    private WebDriver driver;

    @Given("logged in address page")
    public void logIntoAddresses() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
        UserLogInFormPage logInFormPage = new UserLogInFormPage(driver);
        logInFormPage.logIn("jlcfgaivperdnelxup@kvhrr.com", "haslo");

        AddNewAdddressFormPage adddressFormPage = new AddNewAdddressFormPage(driver);
        adddressFormPage.addingAddress();
    }

    @When("deleting last added address")
    public void deleteLastAddedAddress() {
        LastAddresDeleteFormPage lastAddresDeleteFormPage = new LastAddresDeleteFormPage(driver);

        //zapisz rozmiar listy z adresami przed usunięciem ostatniego adresu
        int listaBeforedeleting = lastAddresDeleteFormPage.addressesList().size();

        //usuń ostatnio dodany adres
        lastAddresDeleteFormPage.deleteLastAddress().click();

        //zapisz rozmiar listy z adresami po usunięciu ostatniego adresu
        int listaAfterdeleting = lastAddresDeleteFormPage.addressesList().size();

        //sprawdź czy pojawił się komunikat o usunięciu adresu
        Assert.assertEquals("Address successfully deleted!", lastAddresDeleteFormPage.getDeleteSuccesMessage());

        // sprawdź czy lista adresów po usunięciu ostatniego jest mniejsz niż przed usunięciem
        Assert.assertTrue(listaAfterdeleting < listaBeforedeleting);

    }

    @Then("back to main page")
    public void backToMainPage() {
        WebElement mainPage = driver.findElement(By.xpath("//*[@id=\"main\"]/footer/a[2]"));
        mainPage.click();
        driver.quit();
    }


}
