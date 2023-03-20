package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class LoginPage {
    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//span[text()='Sign In']")
    public WebElement SignIn;

    @FindBy(xpath = "//input[starts-with(@id,'username')]")
    public WebElement username;

    @FindBy(xpath = "//input[starts-with(@id,'password')]")
    public WebElement password;

    @FindBy(xpath = "//button[starts-with(@name,'login')]")
    public WebElement signInGiris;

    @FindBy(xpath = "//span[starts-with(text(),'Sign Out')]")
    public WebElement signOut;

    @FindBy(xpath = "//p[text()='Wrong username or password.']")
    public WebElement wrongText;

    @FindBy(xpath = "//a[contains(text(),'My Account')]")
    public WebElement myAccount;

    @FindBy(xpath = "//p[contains(text(),'Orders')]")
    public WebElement orders;

    @FindBy(xpath = "//p[contains(text(),'Downloads')]")
    public WebElement dowloads;

    @FindBy(xpath = "//p[contains(text(),'Addresses')]")
    public WebElement addresses;

    @FindBy(xpath = "//p[contains(text(),'Account details')]")
    public WebElement accountDetails;

    @FindBy(xpath = "//p[contains(text(),'Wishlist')]")
    public WebElement wishlist;

    @FindBy(xpath = "//a[contains(text(),'Logout')]")
    public WebElement logout;

    @FindBy(xpath = "//li[contains(@class,'woocommerce-MyAccount-navigation-link woocommerce-MyAccount')]")
    public List<WebElement> dashboardList;
}
