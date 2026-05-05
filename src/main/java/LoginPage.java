import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;
    // These attributes indicate the elements on the page
    private By userField = By.id("user-name");
    private By passField = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessage = By.cssSelector("[data-test='error']");

    //This identifies the web browser
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //This is so you can enter your username in the appropriate field
    public void writeUser(String user){
        driver.findElement(userField).sendKeys(user);
    }

    //This is so you can enter the password in the appropriate field
    public void writePassword(String password){
        driver.findElement(passField).sendKeys(password);
    }

    //To be able to click the login button
    public void clickLogin(){
        driver.findElement(loginButton).click();// duplicate
    }

    //This method requires you to enter your login details
    public void login(String user, String password){
        writeUser(user); //Enter user
        writePassword(password); //Enter password
        clickLogin(); //Click the button Login

    }

    //This shows to the user an error message
    public boolean errorMessage(){
        return driver.findElement(errorMessage).isDisplayed();
    }

    //This extract the error message content
    public String obtainErrorMessage() {
        if (errorMessage()) {
            return driver.findElement(errorMessage).getText();
        }
        return "";
    }

}