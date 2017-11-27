package testingPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPageFactory {
	WebDriver driver;

	@FindBy(id = "email_create")
	WebElement emailAddressCreateAccount;

	@FindBy(name = "SubmitCreate")
	WebElement createAccountButton;

	@FindBy(xpath = "//input[@id='email']")
	WebElement emailAddressBarForSignIn;

	@FindBy(xpath = "//input[@name='passwd']")
	WebElement passWordInputBar;

	@FindBy(id = "SubmitLogin")
	WebElement signInButton;

	@FindBy(xpath = "//a[@class='login']")
	WebElement signInOnNavigationBar;

	@FindBy(xpath = "//a[@title='View my customer account']")
	WebElement viewMyAccountButton;

	// Error message Elements

	@FindBy(xpath = "//li[contains(.,'Invalid email address.')]")
	WebElement errorInvalidEmail;

	@FindBy(xpath = "//li[contains(.,'An account using this email address has already been registered. Please enter a valid password or request a new one. ')]")
	WebElement erroralreadyRegisteredEmail;

	@FindBy(xpath = "//li[contains(.,'An email address required.')]")
	WebElement errorEmailAddressRequiered;

	@FindBy(xpath = "//li[contains(.,'Authentication failed.')]")
	WebElement errorAuthenticationFailed;

	@FindBy(xpath = "//li[contains(.,'Password is required.')]")
	WebElement errorPasswordRequired;
	
	// After Sign in successfully Elements
	
	@FindBy(className = "logout")
	WebElement logoutButton;
	
	@FindBy(className = "account")
	WebElement myAccountButton;
	

	public SignInPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void setEmailAddressCreateAccount(String inputEmailAddress) {
		emailAddressCreateAccount.sendKeys(inputEmailAddress);
	}

	public void clickCreateAccountButton() {
		createAccountButton.click();
	}

	public void setEmailAddress_SignIn(String inputEmailAddress) {
		emailAddressBarForSignIn.sendKeys(inputEmailAddress);
	}

	public void setpassWordInputBar(String inputPassword) {
		passWordInputBar.sendKeys(inputPassword);
	}

	public void clickSignInButton() {
		signInButton.click();
	}
}
