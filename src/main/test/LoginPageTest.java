import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginPageTest {
    //This represents the browser
    private WebDriver driver;
    //This is for using the Login Page
    private LoginPage loginPage;

    @BeforeEach
    void setUp() {
        //Automatically configure the Chrome drive
        WebDriverManager.chromedriver().setup();

        //Launch the Chrome browser
        driver = new ChromeDriver();

        //Maximise the browser window
        driver.manage().window().maximize();

        //Open the website to be tested
        driver.get("https://www.saucedemo.com/");

        //Load the login page
        loginPage = new LoginPage(driver);
    }
    //This method run after the tests
    @AfterEach
    void tearDown() {
        //This closes the navegator
        if (driver != null) {
            driver.quit();
        }
    }

    //Test for successful login
    @Test
    void loginCorrect(){
        //Log in using the credentials that have been validated
        loginPage.login("standard_user", "secret_sauce");

        //Check that the URL contains 'inventory'
        assertTrue(driver.getCurrentUrl().contains("inventory"));
    }
    //Test for incorrect login
    @Test
    void loginIncorrect(){
        //Log in using the credentials that haven't been validated
        loginPage.login("standard-user", "incorrect-password");

        //Check that the error appears
        assertTrue(loginPage.errorMessage(),
                "The password is incorrect");
    }
    //Test shows error
    @Test
    void loginIncorrect2() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("standard_user", "clave_incorrecta");

        loginPage.clickLogin();

        assertTrue(loginPage.errorMessage(),
                "An error message must appear");

        assertTrue(loginPage.obtainErrorMessage().contains("Username and password do not match"),
                "This message is not expected");
    }
}
