# OrangeHRM Automation Suite 🚀

This is a **Test Automation Framework** built for **OrangeHRM** (HR Management application) using **Java, Selenium, TestNG, and Maven**.  
It demonstrates end-to-end automation testing practices with reporting, logging, and reusable utilities.

---

## 🔹 Features
- ✅ Cross-browser testing (Chrome, Firefox, Edge)  
- ✅ Config-driven (URL, browser, environment from `config.properties`)  
- ✅ Page Object Model (POM) implementation  
- ✅ TestNG-based test execution (Parallel & Regression suites)  
- ✅ ExtentReports integration with screenshots for failures  
- ✅ Thread-safe WebDriver management with `ThreadLocal`  
- ✅ Logging using Log4j  

---

## 🔹 Project Structure
```bash
OrangeHRM/
│── src/test/java/com/orangehrm/   # Test cases & utilities
│── Reports/                       # ExtentReports HTML reports
│── Screenshots/                   # Failure screenshots
│── logs/                          # Execution logs
│── pom.xml                        # Maven dependencies
│── RegressionSuite.xml            # TestNG suite for regression
│── ParallelSuite.xml              # TestNG suite for parallel execution

🔹 Tech Stack

Language: Java

Automation Tool: Selenium WebDriver

Test Framework: TestNG

Build Tool: Maven

Reporting: ExtentReports

Logging: Log4j

🔹 How to Run

Clone the repository

git clone https://github.com/sagar-bankar/OrangeHRM.git


Open the project in IntelliJ IDEA / Eclipse.

Run the following Maven command to clean and execute tests:

mvn clean test


After execution:

Reports will be available under the Reports/ folder

Logs will be stored in the logs/ folder

Screenshots for failures will be inside Screenshots/

🔹 Reports & Logs

📊 ExtentReports → Rich HTML reports with detailed steps & screenshots

📝 Execution Logs → Captured using Log4j under the logs/ directory

📷 Failure Screenshots → Auto-captured for failed test cases

🔹 Author

👨‍💻 Sagar Bankar
🔗 GitHub Profile

⭐ If you find this project helpful, please give it a star on GitHub!
