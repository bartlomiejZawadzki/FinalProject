package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddNewAdddressFormPage extends BasePage {
    public AddNewAdddressFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"addresses-link\"]/span")
    private WebElement addressButton;

    @FindBy(xpath = "//*[@id=\"content\"]/div[3]/a/span")
    private WebElement createAddress;

    @FindBy(name = "alias")
    WebElement aliasInput;

    @FindBy(name="address1")
    WebElement streetInput;

    @FindBy(name="city")
    WebElement cityInput;

    @FindBy(name="postcode")
    WebElement zipCodeInput;

    @FindBy(name="id_country")
    WebElement  countryInput;

    @FindBy(name="phone")
    WebElement phoneInput;

    @FindBy(xpath="//*[@id=\"content\"]/div/div/form/footer/button")
    WebElement saveAddressButton;


    public void addingAddress() {
        addressButton.click();
    }

    public String getHeaderAddress() {
        return driver.getCurrentUrl();
    }

    public void fillAddress(String alias, String street, String city, String zipCode, String country, String phone){

        aliasInput.click();
        aliasInput.clear();
        aliasInput.sendKeys(alias);

        streetInput.click();
        streetInput.clear();
        streetInput.sendKeys(street);

        cityInput.click();
        cityInput.clear();
        cityInput.sendKeys(city);

        zipCodeInput.click();
        zipCodeInput.clear();
        zipCodeInput.sendKeys(zipCode);

        countryInput.click();
        countryInput.sendKeys(country);

        phoneInput.click();
        phoneInput.clear();
        phoneInput.sendKeys(phone);

        saveAddressButton.click();
    }
}


