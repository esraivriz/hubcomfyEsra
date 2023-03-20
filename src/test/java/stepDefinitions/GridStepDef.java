package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import pages.RegisterPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.net.MalformedURLException;
import java.net.URL;

public class GridStepDef {

    WebDriver driver;
    RegisterPage registerPage= new RegisterPage();
    String hubCmfyHandle;
    String minutesEmailHandle;

    String mail;

    String code;
    @Given("GridChrome User goes to Hubcomfy")
    public void gridchromeUserGoesToHubcomfy() throws MalformedURLException {
       // ChromeOptions options = new ChromeOptions();
      //  options.addArguments("--remote-allow-origins=*");
        driver = new RemoteWebDriver(new URL("http://192.168.1.104:4444"),new ChromeOptions());
        driver.get("https://hubcomfy.com/");
        driver.manage().window().maximize();


    }

    @Then("Grid User verifies that he or she went to the home page")
    public void gridUserVerifiesThatHeOrSheWentToTheHomePage() {
      //  Assert.assertTrue(registerPage.iconSignIn.isDisplayed());

    }

    @And("Grid User click the register button")
    public void gridUserClickTheRegisterButton() {
       driver.findElement(By.cssSelector(".register.inline-type")).click();
    }

    @And("Grid User clicks on the Become a vendor link")
    public void gridUserClicksOnTheBecomeAVendorLink() {
        driver.findElement(By.xpath("//*[text()='Become a Vendor']")).click();

    }


    @When("Grid User go to minutesEmail to receive a valid email")
    public void gridUserGoToMinutesEmailToReceiveAValidEmail() {
        hubCmfyHandle = Driver.getDriver().getWindowHandle();
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(ConfigReader.getProperty("minuteEmail"));
        minutesEmailHandle= Driver.getDriver().getWindowHandle();

    }

    @And("Grid User receive the email from the page they go to")
    public void gridUserReceiveTheEmailFromThePageTheyGoTo() {
      mail= registerPage.minteEmail.getText();


    }

    @And("Grid The user returns to the hub-comfy page and enters the email in the email box")
    public void gridTheUserReturnsToTheHubComfyPageAndEntersTheEmailInTheEmailBox() {
        driver.switchTo().window(hubCmfyHandle);
        registerPage.emailBox.sendKeys(mail);
    }

    @And("Grid User clicks the RE-SEND CODE button")
    public void gridUserClicksTheRESENDCODEButton() {


    }

    @And("Grid The user goes back to minutesEmail to get the code sent to the email address")
    public void gridTheUserGoesBackToMinutesEmailToGetTheCodeSentToTheEmailAddress() {

        driver.switchTo().window(minutesEmailHandle);
        ReusableMethods.waitFor(2);
        Driver.getDriver().navigate().refresh();

        code = registerPage.code.getText().replaceAll("\\D","").substring(0,6);
        System.out.println("code = " + code);

    }

    @And("Grid User receives the code and returns to Hubcomfy")
    public void gridUserReceivesTheCodeAndReturnsToHubcomfy() {
        driver.switchTo().window(hubCmfyHandle);

    }

    @And("Grid The user enters the code that comes to the e-mail address entered in the Verification Code box")
    public void gridTheUserEntersTheCodeThatComesToTheEMailAddressEnteredInTheVerificationCodeBox() {
        registerPage.resentCodeBox.sendKeys(code);

    }

    @And("Grid User enter a valid password")
    public void gridUserEnterAValidPassword() {
        registerPage.passwordBox.sendKeys(ConfigReader.getProperty("validPassword"));
    }

    @And("Grid User enters valid confirm password")
    public void gridUserEntersValidConfirmPassword() {
        registerPage.confirmPassword.sendKeys(ConfigReader.getProperty("validPassword"));

    }

    @And("Grid User clicks the register button")
    public void gridUserClicksTheRegisterButton() {
        ReusableMethods.jsclick(registerPage.Register2);
    }

    @Then("Grid The user verifies seeing the text Welcome to Hubcomfy!")
    public void gridTheUserVerifiesSeeingTheTextWelcomeToHubcomfy() {
        ReusableMethods.waitFor(8);
        Driver.getDriver().navigate().refresh();
        Assert.assertTrue(registerPage.welcomeToHuncomfy.isDisplayed());
    }

    @And("Grid User quits page")
    public void gridUserQuitsPage() {
        Driver.quitDriver();
    }

    @Given("GridEdge User goes to Hubcomfy")
    public void gridedgeUserGoesToHubcomfy() throws MalformedURLException {
       driver=new RemoteWebDriver(new URL("http://192.168.1.104:4444"),new EdgeOptions());
        driver.get("https://hubcomfy.com/");
    }


}
