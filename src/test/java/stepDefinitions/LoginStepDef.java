package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;

public class LoginStepDef {

    LoginPage loginPage=new LoginPage();
    @And("User clicks Sign In")
    public void userClicksSignIn() {
        loginPage.SignIn.click();

    }

    @And("User enters a valid email in the email box")
    public void userEntersAValidEmailInTheEmailBox() {
    loginPage.username.sendKeys(ConfigReader.getProperty("validEmail"));
    }

    @And("User enters the valid password in the password box")
    public void userEntersTheValidPasswordInThePasswordBox() {
        loginPage.password.sendKeys(ConfigReader.getProperty("validpassword"));
    }

    @And("User click the SIGN IN button")
    public void userClickTheSIGNINButton() {
       loginPage.signInGiris.click();
    }

    @Then("The user confirms that they went to the My Account page")
    public void theUserConfirmsThatTheyWentToTheMyAccountPage() {
        Assert.assertTrue(loginPage.signOut.isDisplayed());
    }



    /////// TC02

    @And("User enters {string} and {string} from use cases")
    public void userEntersAndFromUseCases(String username, String password) {
        loginPage.username.sendKeys(username);
        loginPage.password.sendKeys(password);
    }

    @And("User confirms that they cannot go to the My Account page")
    public void userConfirmsThatTheyCannotGoToTheMyAccountPage() {
        Assert.assertEquals(loginPage.wrongText.getText(),"Wrong username or password.");


    }
//////////TC_03

    @Then("Click on the My Account link")
    public void clickOnTheMyAccountLink() {
        ReusableMethods.jsScrollClick(loginPage.myAccount);
    }

    @Then("Verifies the visibility of Orders")
    public void verifiesTheVisibilityOfOrders() {

      Assert.assertTrue(loginPage.orders.isDisplayed());

    }

    @Then("Corrects the visibility of the Downloads text")
    public void correctsTheVisibilityOfTheDownloadsText() {
        Assert.assertTrue(loginPage.dowloads.isDisplayed());
    }

    @Then("Verifies the visibility of Addresses")
    public void verifiesTheVisibilityOfAddresses() {
        Assert.assertTrue(loginPage.addresses.isDisplayed());
    }

    @Then("Verifies the visibility of Account details")
    public void verifiesTheVisibilityOfAccountDetails() {
        Assert.assertTrue(loginPage.accountDetails.isDisplayed());
    }

    @Then("Verifies the visibility of the Wishlist text")
    public void verifiesTheVisibilityOfTheWishlistText() {
        Assert.assertTrue(loginPage.wishlist.isDisplayed());
    }

    @Then("Verifies the visibility of the Logout text")
    public void verifiesTheVisibilityOfTheLogoutText() {
        Assert.assertTrue(loginPage.logout.isDisplayed());
    }


    ////TC_04
   List<String> dashboardStringList= new ArrayList<>();
    @Then("Store manager confirms that the text is there")
    public void storeManagerConfirmsThatTheTextIsThere() {

        for (WebElement w:loginPage.dashboardList
             ) {
          dashboardStringList.add(w.getText());
        }
        System.out.println(dashboardStringList+"liste");
        Assert.assertTrue(dashboardStringList.contains("Store Manager"));
    }

    @Then("Orders confirm that the text is there")
    public void ordersConfirmThatTheTextIsThere() {
        Assert.assertTrue(dashboardStringList.contains("Orders"));
    }


    @Then("Downloads confirm that the text is there")
    public void downloadsConfirmThatTheTextIsThere() {
        Assert.assertTrue(dashboardStringList.contains("Downloads"));
    }

    @Then("Addresses confirm that there is writing")
    public void addressesConfirmThatThereIsWriting() {
        Assert.assertTrue(dashboardStringList.contains("Addresses"));
    }

    @Then("Confirms the existence of account details")
    public void confirmsTheExistenceOfAccountDetails() {
        Assert.assertTrue(dashboardStringList.contains("Account details"));
    }

    @Then("Confirms that there is an Appointments sign")
    public void confirmsThatThereIsAnAppointmentsSign() {
        Assert.assertFalse(dashboardStringList.contains("Appointments"));
    }

    @Then("Wishlist confirms that there is writing")
    public void wishlistConfirmsThatThereIsWriting() {
        Assert.assertTrue(dashboardStringList.contains("Wishlist"));
    }

    @Then("Confirms that there are support tickets")
    public void confirmsThatThereAreSupportTickets() {
        Assert.assertTrue(dashboardStringList.contains("Support Tickets"));
    }

    @Then("Followings confirms that the text exists")
    public void followingsConfirmsThatTheTextExists() {
        Assert.assertTrue(dashboardStringList.contains("Followings"));
    }

    @Then("Confirms that there is a logout sign")
    public void confirmsThatThereIsALogoutSign() {
        Assert.assertTrue(dashboardStringList.contains("Logout"));
    }

}
