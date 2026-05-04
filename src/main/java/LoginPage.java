import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// Class for Couplers
class UserSession {
    public String username;
    private String _internalToken = "SECRET_123";

    public String getUsername() { return username; }
}
public class LoginPage {

    private WebDriver driver;
    // These attributes indicate the elements on the page
    private By userField = By.id("user-name");
    private By passField = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessage = By.cssSelector("[data-test='error']");

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


    // 6 + 7 BLOATERS: Long Method (start) + CHANGE PREVENTER: Divergent Change (start)
    public void login(String user, String password){
        writeUser(user); //Enter user
        writePassword(password); //Enter password
        clickLogin(); //Click the button Login

        saveLog();
    }
    // BLOATERS: Long Method (end) + CHANGE PREVENTER: Divergent Change (end)
    // It does too many things in a single method

    public boolean errorMessage(){
        return driver.findElement(errorMessage).isDisplayed();
    }

    // 11 Unnecessary method added
    public void saveLog(){
        System.out.println("Login");
    }

    // 12 COUPLERS: Feature Envy (start)
    public boolean validateUserFormat(UserSession session) {
        return session.username.contains("@") && session.username.length() > 5 && !session.username.isEmpty();
    }
    // COUPLERS: Feature Envy (end)

    // 13 COUPLERS: Inappropriate Intimacy (start)
    public void hackSessionToken(UserSession session) {
        System.out.println("Accessing data I'm not authorized to see: " + session.username);
    }
}
