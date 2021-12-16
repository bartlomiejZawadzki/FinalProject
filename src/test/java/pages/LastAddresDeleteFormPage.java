package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class LastAddresDeleteFormPage extends BasePage {
    public LastAddresDeleteFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "address-body")
    List<WebElement> lista;

    @FindBy(xpath = "//*[@id=\"notifications\"]/div/article")
    private WebElement deleteSuccesMessage;


    public WebElement getLastAddressToDelete() {
        List<WebElement> addressesList = lista;

        for (int i = 0; i < addressesList.size(); i++) {
            WebElement x = addressesList.get(addressesList.size() - 1);
            addressesList.set(0, x);
        }

        WebElement addressTodeleted = addressesList.get(0);


        return addressTodeleted.findElement(By.xpath("//*[contains(@data-link-action, 'delete-address')]"));
    }

    public String getDeleteSuccesMessage() {
        return deleteSuccesMessage.getText();
    }
}
