package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddNewAdddressFormPage extends BasePage{
    public AddNewAdddressFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//*[@id=\"addresses-link\"]/span")
    private WebElement addressButton;

    @FindBy (xpath = "//*[@id=\"content\"]/div[3]/a/span")
    private WebElement createAddress;


    public void addingAddress(){
        addressButton.click();
    }

     public String getHeaderAddress() {
           return driver.getCurrentUrl();
      }
}
