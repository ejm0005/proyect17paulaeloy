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

    // 3 DISPENSABLE: Duplicate Code (start)
    public void writeUser(String user){
        driver.findElement(userField).sendKeys(user);
    }
    public void writeUser2(String user){
        driver.findElement(userField).sendKeys(user);
    }
    // DISPENSABLE: Duplicate Code (end)

    // 4 DISPENSABLE: Duplicate Code (start)
    public void writePassword(String password){
        driver.findElement(passField).sendKeys(password);
        driver.findElement(passField).sendKeys(password);
    }
    // DISPENSABLE: Duplicate Code (end)

    // 5 DISPENSABLE: Duplicate Code (start)
    public void clickLogin(){
        driver.findElement(loginButton).click();// duplicate
    }
    public void clickLogin2(){
        driver.findElement(loginButton).click();// duplicate
    }
    // DISPENSABLE: Duplicate Code (start)

    // 6 + 7 BLOATERS: Long Method (start) + CHANGE PREVENTER: Divergent Change (start)
    public void login(String user, String password){

        // 8 OBJECT-ORIENTATION ABUSER: Switch (start)
        if(user.equals("user")){
            writeUser("user");
            writePassword("1234");
        }
        // OBJECT-ORIENTATION ABUSER: Switch (end)

        writeUser(user);
        writePassword(password);
        clickLogin();

        // 9 DISPENSABLE: Dead Code (start)
        int a = 5;
        int b = 10;
        int c = a + b;
        // unused variables
        // DISPENSABLE: Dead Code (end)

        // 10 CHANGE PREVENTER: Shotgun Surgery (simulate)
        driver.findElement(userField).clear();
        driver.findElement(passField).clear();
        // If this changes, it will have to be updated in many places

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
