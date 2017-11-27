package testingPackage;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestCases {
	private WebDriver driver;
	private String baseUrl;
	SignInPageFactory loginPage;
	private static final Logger log = LogManager.getLogger(TestCases.class.getName());

	@BeforeMethod
	public void beforeyClass() {
		driver = new FirefoxDriver();
		baseUrl = "http://automationpractice.com/index.php?controller=authentication&back=my-account";

		loginPage = new SignInPageFactory(driver);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);

	}

	@Test // Create account section
	public void createAccountWithBlankEmailAddress() {
		loginPage.emailAddressCreateAccount.clear();
		loginPage.clickCreateAccountButton();
		Assert.assertTrue(loginPage.errorInvalidEmail.isDisplayed());

	}

	@Test(dataProvider = "inCorrectEmailInputList", dataProviderClass = testData.class) // Create account section
	public void createAccountWithIncorrectEmailPattern(String inCorrectEmailInputList) {
		loginPage.emailAddressCreateAccount.clear();
		loginPage.setEmailAddressCreateAccount(inCorrectEmailInputList);
		loginPage.clickCreateAccountButton();
		Assert.assertTrue(loginPage.errorInvalidEmail.isDisplayed());

	}

	@Test(dataProvider = "correctPasswordAndEmail", dataProviderClass = testData.class) // Create account section
	public void createAccountWithCorrectEmailAddress(String correctPassword, String correctEmail) {
		loginPage.emailAddressCreateAccount.clear();
		loginPage.setEmailAddressCreateAccount(correctEmail);
		loginPage.clickCreateAccountButton();
		Assert.assertTrue(loginPage.erroralreadyRegisteredEmail.isDisplayed());

	}

	@Test(dataProvider = "correctPasswordAndEmail", dataProviderClass = testData.class) // Create account section
	public void CreateAccountWithExitingEmail(String correctPassword, String correctEmail) {
		loginPage.emailAddressCreateAccount.clear();
		loginPage.setEmailAddressCreateAccount(correctEmail);
		loginPage.clickCreateAccountButton();
		Assert.assertTrue(loginPage.erroralreadyRegisteredEmail.isDisplayed());

	}

	@Test(dataProvider = "correctPasswordAndEmail", dataProviderClass = testData.class) // User Login/Sign in Section
	public void CreateAccountBlankEmailAddress(String correctPassword, String correctEmail) {
		loginPage.emailAddressBarForSignIn.clear();
		loginPage.setpassWordInputBar(correctPassword);
		loginPage.clickSignInButton();
		Assert.assertTrue(loginPage.errorEmailAddressRequiered.isDisplayed());

	}

	@Test(dataProvider = "correctPasswordAndEmail", dataProviderClass = testData.class) // User Login/Sign in Section
	public void test6(String correctPassword, String correctEmail) {
		loginPage.emailAddressBarForSignIn.clear();
		loginPage.passWordInputBar.clear();
		loginPage.setEmailAddress_SignIn("adi.adi.com");
		loginPage.setpassWordInputBar(correctPassword);
		loginPage.signInButton.click();
		Assert.assertTrue(loginPage.errorInvalidEmail.isDisplayed());

	}

	// @Test // User Login/Sign in Section
	public void test7() {
		loginPage.emailAddressBarForSignIn.clear();
		loginPage.passWordInputBar.clear();
		loginPage.setEmailAddress_SignIn("adi@gmail.com");
		loginPage.setpassWordInputBar("A12345678");
		loginPage.signInButton.click();
		Assert.assertTrue(loginPage.errorAuthenticationFailed.isDisplayed());

	}

	@Test // User Login/Sign in Section
	public void test8() {
		loginPage.emailAddressBarForSignIn.clear();
		loginPage.passWordInputBar.clear();
		loginPage.setEmailAddress_SignIn("adi@gmail.com");
		loginPage.signInButton.click();
		Assert.assertTrue(loginPage.errorPasswordRequired.isDisplayed());

	}

	@Test(dataProvider = "correctPasswordAndEmail", dataProviderClass = testData.class) // User Login/Sign in Section
	public void test9(String correctPassword, String correctEmail) {
		loginPage.emailAddressBarForSignIn.clear();
		loginPage.passWordInputBar.clear();
		loginPage.setEmailAddress_SignIn(correctEmail);
		loginPage.setpassWordInputBar(correctPassword);
		loginPage.signInButton.click();
		Assert.assertTrue(loginPage.logoutButton.isDisplayed());
		Assert.assertTrue(loginPage.myAccountButton.isDisplayed());

	}

	@Test(dataProvider = "correctPasswordAndEmail", dataProviderClass = testData.class) // User Login/Sign in Section //
																						// Validate that password is
																						// encrypted
	public void testcase10(String correctPassword, String correctEmail) {
		loginPage.emailAddressCreateAccount.clear();
		loginPage.setEmailAddressCreateAccount(correctEmail);
		Assert.assertTrue(loginPage.PasswordMaskValidation.getAttribute("type").equals("password"));

	}

	@Test(dataProvider = "correctPasswordAndEmail", dataProviderClass = testData.class) // User Login/Sign in Section
	public void test11(String correctPassword, String correctEmail) {
		loginPage.emailAddressBarForSignIn.clear();
		loginPage.passWordInputBar.clear();
		loginPage.setEmailAddress_SignIn(correctEmail);
		loginPage.setpassWordInputBar(correctPassword);
		loginPage.signInButton.click();
		Assert.assertTrue(loginPage.logoutButton.isDisplayed());
		Assert.assertTrue(loginPage.myAccountButton.isDisplayed());

	}

	@AfterMethod
	public void afterClass() throws InterruptedException {
		// Thread.sleep(2000);
		driver.quit();

	}

}
