package stepDefinitions;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.*;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import pages.RegisterPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.JSUtils;
import utilities.ReusableMethods;

public class RegisterStepDef {
    RegisterPage registerPage = new RegisterPage();
    String hubCmfyHandle;
    String minutesEmailHandle;

    String MinuteEmail;

    String code;



    @Given("User goes to hubcomfyUrl")
    public void user_goes_to() {
        Driver.getDriver().get(ConfigReader.getProperty("hubcomfyUrl"));


    }

    @Then("User verifies that he or she went to the home page")
    public void user_verifies_that_he_she_went_to_the_home_page() {
        Assert.assertTrue(registerPage.iconSignIn.isDisplayed());

    }

    @Then("User click the register button")
    public void user_click_the_register_button() {
        registerPage.register.click();

    }

    @Then("User clicks on the Become a vendor link")
    public void user_clicks_on_the_link() throws InterruptedException {
        registerPage.becomeAvendor.click();


    }

    @Then("User verifies that Vendor Registration is visible")
    public void user_verifies_that_is_visible() {
        Assert.assertTrue(registerPage.vendorRegisterVisible.isDisplayed());


    }


    @And("User quits page")
    public void userQuitsPage() {
        Driver.quitDriver();
    }

    ////// TC 02
    @Then("User verifies that there is an email box on the Vendor Registration page")
    public void userVerifiesThatThereIsAnEmailBoxOnTheVendorRegistrationPage() {
        Assert.assertTrue(registerPage.emailBox.isDisplayed());


    }

    @Then("User verifies that there is a password box on the Vendor Registration page")
    public void userVerifiesThatThereIsAPasswordBoxOnTheVendorRegistrationPage() {
        Assert.assertTrue(registerPage.passwordBox.isDisplayed());
    }

    @Then("User verifies that there is a confirm password box on the Vendor Registration page")
    public void userVerifiesThatThereIsAConfirmPasswordBoxOnTheVendorRegistrationPage() {
        Assert.assertTrue(registerPage.confirmPassword.isDisplayed());
    }

    @And("User click the REGISTER")
    public void userClickTheREGISTER() throws InterruptedException {
        //  ReusableMethods.waitForVisibility(registerPage.Register2,7);

        ReusableMethods.jsclick(registerPage.Register2);

    }

    @Then("User verifies that they have received the warning Email This field is required.")
    public void userVerifiesThatTheyHaveReceivedTheWarningEmailThisFieldIsRequired() {
        Assert.assertTrue(registerPage.requiredWarning.isDisplayed());
    }
//////
    @And("User go to minuteEmail to receive a valid email")
    public void userGoToMinuteEmailToReceiveAValidEmail() {
         hubCmfyHandle = Driver.getDriver().getWindowHandle();
        Driver.getDriver().switchTo().newWindow(WindowType.TAB);
        Driver.getDriver().get(ConfigReader.getProperty("minuteEmail"));
         minutesEmailHandle= Driver.getDriver().getWindowHandle();
    }

    @And("User receive the email from the page they go to")
    public void userReceiveTheEmailFromThePageTheyGoTo() {
        MinuteEmail =registerPage.minteEmail.getText();
        System.out.println("MinuteEmail = " + MinuteEmail);
    }

    @And("The user returns to the hub-comfy page and enters the email in the email box")
    public void theUserReturnsToTheHubComfyPageAndEntersTheEmailInTheEmailBox() {
        Driver.getDriver().switchTo().window(hubCmfyHandle);
        registerPage.emailBox.sendKeys(MinuteEmail);
    }

    @And("User clicks the RE-SEND CODE button")
    public void userClicksTheRESENDCODEButton() {

      //  registerPage.resendCode.click();
    }

    @And("The user goes back to minuteEmail to get the code sent to the email address")
    public void theUserGoesBackToMinuteEmailToGetTheCodeSentToTheEmailAddress() {

        Driver.getDriver().switchTo().window(minutesEmailHandle);
        ReusableMethods.waitFor(2);
        Driver.getDriver().navigate().refresh();

        code = registerPage.code.getText().replaceAll("\\D","").substring(0,6);
        System.out.println("code = " + code);


    }

    @And("User receives the code and returns to hubcomfy")
    public void userReceivesTheCodeAndReturnsToHubcomfy() {
        Driver.getDriver().switchTo().window(hubCmfyHandle);


    }

    @And("The user enters the code that comes to the e-mail address entered in the Verification Code box")
    public void theUserEntersTheCodeThatComesToTheEMailAddressEnteredInTheVerificationCodeBox() {
        registerPage.resentCodeBox.sendKeys(code);
    }

    @And("User enter a valid password")
    public void userEnterAValidPassword() {
        registerPage.passwordBox.sendKeys(ConfigReader.getProperty("validPassword"));
    }

    @And("User enters valid confirm password")
    public void userEntersValidConfirmPassword() {

        registerPage.confirmPassword.sendKeys(ConfigReader.getProperty("validPassword"));
    }

    @And("User clicks the register button")
    public void userClicksTheRegisterButton() {

        ReusableMethods.jsclick(registerPage.Register2);
    }

    @And("The user verifies seeing the text Welcome to Hubcomfy!")
    public void theUserVerifiesSeeingTheTextWelcomeToHubcomfy() {
        ReusableMethods.waitFor(8);
        Driver.getDriver().navigate().refresh();
         Assert.assertTrue(registerPage.welcomeToHuncomfy.isDisplayed());

    }

    @And("User enters an {string}")
    public void userEntersAn(String invalidEmail) {
        registerPage.emailBox.sendKeys(invalidEmail);
        registerPage.resendCode.click();
        ReusableMethods.waitFor(5);
    }


    @Then("User verifies that Please provide a valid email address. appears")
    public void userVerifiesThatPleaseProvideAValidEmailAddressAppears() {
        Assert.assertTrue(registerPage.emailWrong.isDisplayed());
    }

    @And("User go to minuteEmail to receive a valid and unique email")
    public void userGoToMinuteEmailToReceiveAValidAndUniqueEmail() {
        hubCmfyHandle = Driver.getDriver().getWindowHandle();
        Driver.getDriver().switchTo().newWindow(WindowType.TAB);
        Driver.getDriver().get(ConfigReader.getProperty("minuteEmail"));
        minutesEmailHandle= Driver.getDriver().getWindowHandle();

    }
    @When("User enters non-unique email in the email box")
    public void userEntersNonUniqueEmailInTheEmailBox() {
        registerPage.emailBox.sendKeys(ConfigReader.getProperty("nonUniqe"));
    }


    @And("User enters a postal code in the Verification Code box")
    public void userEntersAPostalCodeInTheVerificationCodeBox() {
        registerPage.resentCodeBox.sendKeys(ConfigReader.getProperty("code"));
    }

    @And("User confirms that 'This Email already exists. Please login to the site and apply as a vendor.")
    public void userConfirmsThatThisEmailAlreadyExistsPleaseLoginToTheSiteAndApplyAsAVendor() {
        Assert.assertTrue(registerPage.nonUniqeEmailText.isDisplayed());
    }

//// Tc_012
    @And("The user enters a {string} of at least six characters including lowercase, uppercase, numbers and special characters")
    public void theUserEntersAOfAtLeastSixCharactersIncludingLowercaseUppercaseNumbersAndSpecialCharacters(String password) {
        registerPage.passwordBox.sendKeys(password);

    }

    @Then("The user verifies seeing the text Strong")
    public void theUserVerifiesSeeingTheTextStrong() {
        Assert.assertTrue(registerPage.strongPasswordText.isDisplayed());

    }

///// Tc_013
    @And("User enters {string} use cases\\(PageThree)")
    public void userEntersUseCasesPageThree(String invalidPassword) {
        registerPage.passwordBox.sendKeys(invalidPassword);
    }



    @Then("User verifies that he or she cannot see the strong text")
    public void userVerifiesThatHeOrSheCannotSeeTheStrongText() {
        ReusableMethods.jsScroll(registerPage.strongPasswordText);
        ReusableMethods.waitFor(3);
        Assert.assertNotEquals(registerPage.strongPasswordText.getText(),"Strong");
    }
//=======================================TC_014

    @And("The user enters the same valid password in the confirm password as they enter in the password")
    public void theUserEntersTheSameValidPasswordInTheConfirmPasswordAsTheyEnterInThePassword() {
        registerPage.confirmPassword.sendKeys(ConfigReader.getProperty("validPassword"));


    }
    //================================TC_15
    @And("To confirm the password, the user enters a different password than the current password entered in the password")
    public void toConfirmThePasswordTheUserEntersADifferentPasswordThanTheCurrentPasswordEnteredInThePassword() {
        registerPage.confirmPassword.sendKeys(ConfigReader.getProperty("notSamePassword"));
    }

    @Then("The user confirms that they are unable to log in by seeing the text Password and Password Confirmation are not the same!")
    public void theUserConfirmsThatTheyAreUnableToLogInBySeeingTheTextPasswordAndPasswordConfirmationAreNotTheSame() {
        Assert.assertEquals(registerPage.notSameText.getText(),"Password and Confirm-password are not same.");
    }
///// Tc_016
    @And("The user goes to minuteEmail to verify incoming email")
    public void theUserGoesToMinuteEmailToVerifyIncomingEmail() {
     Driver.getDriver().switchTo().window(minutesEmailHandle);

    }

    @And("The user clicks on the Hubcomfy email")
    public void theUserClicksOnTheHubcomfyEmail() {
        Driver.getDriver().navigate().refresh();

    }

    @And("The user confirms that their My Account is visible by clicking on the Visit now... link in the emaAnd")
    public void theUserConfirmsThatTheirMyAccountIsVisibleByClickingOnTheVisitNowLinkInTheEmaAnd() {
      //  ReusableMethods.waitFor(3);
        System.out.println(registerPage.succesfulyText.getText());
        Assert.assertEquals(registerPage.succesfulyText.getText(),"[Hubcomfy] Successfully Registered");

    }
    //============================


}

