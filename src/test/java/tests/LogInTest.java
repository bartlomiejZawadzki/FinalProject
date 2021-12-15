package tests;

import org.junit.Assert;
import org.junit.Test;
import pages.AddNewAdddressFormPage;
import pages.UserLogInFormPage;

public class LogInTest extends BaseTest {

    @Test
    public void shouldLogInSuccesfully() {
        driver.get("https://mystore-testlab.coderslab.pl/index.php");

        String userFirstName = "Bartek";
        String userLastName = "Zawadzki";

        UserLogInFormPage logInFormPage = new UserLogInFormPage(driver);
        AddNewAdddressFormPage newAdddressFormPage = new AddNewAdddressFormPage(driver);

        //logowanie
        logInFormPage.logIn("jlcfgaivperdnelxup@kvhrr.com", "haslo");
        // sprawdź czy zalogował się poprawny user
        Assert.assertEquals(userFirstName + " " + userLastName, logInFormPage.getUserNameConfirmation());

        // kafelek adres
        newAdddressFormPage.addingAddress();
        // sprawdź czy jesteś na poprawnej stronie
        Assert.assertEquals("https://mystore-testlab.coderslab.pl/index.php?controller=addresses",
                newAdddressFormPage.getHeaderAddress());
    }
}
