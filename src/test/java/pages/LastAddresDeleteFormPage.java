package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;


public class LastAddresDeleteFormPage extends BasePage {
    public LastAddresDeleteFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "address-body")
    List<WebElement> lista;

    @FindBy(xpath = "//*[@id=\"notifications\"]/div/article")
    private WebElement deleteSuccesMessage;

    @FindBy(xpath = "//span[contains(text(),'Delete')]")
    List<WebElement> deleteLink;


    public WebElement getLastAddressToDelete() {

        List<WebElement> deleteList = new ArrayList<>();
        deleteList.addAll((deleteLink));
        WebElement lastAddressdelete = deleteList.get(deleteList.size() - 1);

        return lastAddressdelete;
    }


    public String getDeleteSuccesMessage() {
        return deleteSuccesMessage.getText();
    }
}
