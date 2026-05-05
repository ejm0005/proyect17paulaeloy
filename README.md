# Module 17

## Title: Final Project: “The Clean Code & Automation Cycle”

---

## Description
This project contains a suite of automated tests to validate the login functionality of the SauceDemo website. It is designed using the Page Object Model (POM) design pattern to ensure clean, maintainable and scalable code.

## Technologies Used:
- Java: Primary programming language.
- Selenium WebDriver: Tool for web browser automation.
- JUnit 5 (Jupiter): Testing framework for running test cases and managing assertions.
- WebDriverManager: Library for the automatic management of browser drivers (Chrome).

## Structure:
The project is structured into two main components following the POM pattern:
- LoginPage.java: This is the Page Object. It contains the web element selectors (username, password, login button) and the methods to interact with the page. It's located in /src/main/java/LoginPage.java
- LoginPageTest.java: Contiene los casos de prueba (scripts). Se encarga de la lógica de negocio de las pruebas, como la configuración del driver (@BeforeEach) y la limpieza del entorno (@AfterEach). It's located in /src/main/test/LoginPageTest.java

## Tests included:
- loginCorrect: Login with valid credentials and verify that the user is redirected to the inventory page.
- loginIncorrect: Login with an invalid username or password and verify that the error message appears to the user.
- loginIncorrect2: Failed login attempt with text verification and verify that the error message contains "Username and password do not match".

## Page Object Features (LoginPage)
The LoginPage class encapsulates the following actions:
- writeUser(String user): Enters the username.
- writePassword(String password): Enters the password.
- clickLogin(): Clicks the login button.
- login(user, pass): A convenience method that combines the three previous actions into a single step.
- errorMessage(): Checks whether the error element is visible on screen.
- obtainErrorMessage(): Retrieves the literal text of the error to perform specific validations.

## Requeriments
- JDK 11 or newer
- Maven or Gladle
- Google Chrome installed

---

## Code smells
During the development of this Selenium automation project, several code smells were identified and resolved using Clean Code principles, Page Object Model (POM), and refactoring tools in IntelliJ IDEA.

### 1. Dispensables 
Dispensables are parts of the code that are unnecessary or provide no real value to the system. They make the code harder to read, maintain, and understand without improving functionality.
- Dead code: Dead code refers to any part of the code that is never used or executed during the program’s runtime.
- Duplicate code: Duplicate code occurs when the same or very similar code is repeated in multiple places instead of being reused<br><br>
Solution: The solution is simply to remove any code that is repeated or not used

### 2. Blooters
Bloaters are a type of code smell that appear when parts of the code grow too large, too complex, or overloaded with responsibilities over time. They make the code harder to understand, maintain, and modify
- Long Method: A Long Method is a type of code smell that occurs when a method contains too many lines of code or performs too many different tasks. Instead of focusing on a single responsibility, the method becomes overloaded with multiple actions.<br><br>
Solution: Refactor the long method into smaller, more focused methods, each responsible for a single task.

### 3. Change preventers
Change Preventers are code smells that occur when a single change in the system requires modifying multiple places in the code. This makes the code difficult to maintain and increases the risk of introducing bugs.
- Divergent Change: Divergent Change happens when a single class or module is frequently modified for different and unrelated reasons. In other words, one class is responsible for too many functionalities, and every new requirement forces changes in the same place.<br><br>
Solution: Split responsibilities into different method

### 4. Object-Orientation Abusers
Object-Orientation abusers is a type of code smell that occurs when the principles of object-oriented programming are applied incorrectly, incompletely or excessively 
- Switch Statements: The excessive use of complex switch statements or if statements to determine behaviour based on the object type, rather than using polymorphism
- Temporary Field: An object has fields that are only used under certain circumstances and remain empty or null the rest of the time.<br><br>
Solution:  We remove misplaced code

### 5. Couplers
Couplers are a category of code smells that indicate an excessive coupling between classes or modules, thereby violating the principles of object-oriented design
- Feature Envy: A method uses data from another object rather than its own.
- InappropRiate Intimacy: One class uses the private fields or methods of another class.<br><br>
Solution: We removed those methods because they weren’t necessary for our type of application (a simple login that collects data but doesn’t perform any checks itself).
