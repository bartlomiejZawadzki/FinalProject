package pages;

import com.google.common.collect.Lists;
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


    public WebElement deleteLastAddress() {

        List<WebElement> deleteList = new ArrayList<>();
        deleteList.addAll((deleteLink));
        WebElement lastAddressDeleteLink = deleteList.get(deleteList.size() - 1);

        return lastAddressDeleteLink;
    }

    public List<WebElement> addressesList() {

        List<WebElement> addresslist = new ArrayList<>();
        addresslist.addAll((deleteLink));
        return addresslist;
    }


    public String getDeleteSuccesMessage() {
        return deleteSuccesMessage.getText();
    }
}
