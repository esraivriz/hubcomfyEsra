package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class RegisterPage {
    public RegisterPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

   @FindBy(xpath = "//a[contains(@class,\"login\")]")
    public WebElement iconSignIn;


    @FindBy(css = ".register.inline-type")
    public WebElement register;

    @FindBy(xpath = "//*[text()='Become a Vendor']")
    public WebElement becomeAvendor;

    @FindBy(css = ".page-title")
    public WebElement vendorRegisterVisible;

    @FindBy(css = "#user_email")
    public WebElement emailBox;

    @FindBy(css = "#passoword")
    public WebElement passwordBox;

    @FindBy(css = "#confirm_pwd")
    public WebElement confirmPassword;

    @FindBy(css = "#wcfm_membership_register_button")
    public WebElement Register2;

    @FindBy(css = ".wcfm-message.email_verification_message.wcfm-error")
    public WebElement requiredWarning;

    @FindBy(xpath = "//span[@id=\"email\"]")
    public WebElement minteEmail;

    @FindBy(css = ".wcfm-text.wcfm_submit_button.wcfm_email_verified_button")
     public WebElement resendCode;

    @FindBy(xpath = "//tr[contains(@class,'hidden-xs')]")
     public WebElement code;

    @FindBy(css = ".wcfm-text.wcfm_email_verified_input")
    public WebElement resentCodeBox;

    @FindBy(xpath = "//h1[contains(text(),'Welcome')]")
    public WebElement welcomeToHuncomfy;

    @FindBy(xpath = "//div[@class='wcfm-message email_verification_message wcfm-error']")
    public WebElement emailWrong;

    @FindBy(xpath = "//div[text()='This Email already exists. Please login to the site and apply as vendor.']")
    public WebElement nonUniqeEmailText;

     @FindBy(xpath = "//div[@id='password_strength']")
     public WebElement strongPasswordText;

   @FindBy(xpath = "//div[contains(text(),'Password and Confirm')]")
    public WebElement notSameText;

   @FindBy(xpath = "//tr[@class='hidden-xs hidden-sm klikaciRadek newMail']")
   public WebElement hubcomfyEmail;


   @FindBy(xpath = "//div[contains(@class,'row no-padding no-margin-top hidden-xs')]")
   public WebElement welcomeStore;

    @FindBy(xpath = "(//tbody//tr//td)[2]")
    public WebElement succesfulyText;


}
