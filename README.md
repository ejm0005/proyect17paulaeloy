# Module 17

## Title: Final Project: “The Clean Code & Automation Cycle”

---

## Code Smells Identified and Refactored

During the development of this Selenium automation project, several code smells were identified and resolved using Clean Code principles, Page Object Model (POM), and refactoring tools in IntelliJ IDEA.

---

### 1. Dispensables 
Dispensables are parts of the code that are unnecessary or provide no real value to the system. They make the code harder to read, maintain, and understand without improving functionality.
- Dead code: Dead code refers to any part of the code that is never used or executed during the program’s runtime.
- Duplicate code: Duplicate code occurs when the same or very similar code is repeated in multiple places instead of being reused
Solution: The solution is simply to remove any code that is repeated or not used

### 2. Blooters
Bloaters are a type of code smell that appear when parts of the code grow too large, too complex, or overloaded with responsibilities over time. They make the code harder to understand, maintain, and modify
- Long Method: A Long Method is a type of code smell that occurs when a method contains too many lines of code or performs too many different tasks. Instead of focusing on a single responsibility, the method becomes overloaded with multiple actions.
Solution: Refactor the long method into smaller, more focused methods, each responsible for a single task.

### 3. Change preventers
Change Preventers are code smells that occur when a single change in the system requires modifying multiple places in the code. This makes the code difficult to maintain and increases the risk of introducing bugs.
- Divergent Change: Divergent Change happens when a single class or module is frequently modified for different and unrelated reasons. In other words, one class is responsible for too many functionalities, and every new requirement forces changes in the same place.
Solution: Split responsibilities into different method




