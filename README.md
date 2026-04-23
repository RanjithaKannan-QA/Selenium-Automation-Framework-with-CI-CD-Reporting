# Selenium Automation Framework with CI/CD & Reporting

[![Selenium CI Pipeline](https://github.com/RanjithaKannan-QA/Selenium-Automation-Framework-with-CI-CD-Reporting/actions/workflows/ci.yml/badge.svg)](https://github.com/RanjithaKannan-QA/Selenium-Automation-Framework-with-CI-CD-Reporting/actions/workflows/ci.yml)

A professional, modular automation engine designed for scalability and reliability. This framework is built using the **Page Object Model (POM)** and integrated into a **CI/CD pipeline** to provide immediate feedback on application health.
**This framework is designed as a Universal E2E Solution.** While currently demonstrated using SauceDemo as a test bed, the architecture is fully decoupled, allowing for easy migration to any enterprise e-commerce or retail platform by simply updating the Page Objects and DataProviders.

---

## 🛠 Tech Stack & Tools
* **Language:** Java 17
* **Automation:** Selenium WebDriver (4.x)
* **Test Runner:** TestNG
* **Design Pattern:** Page Object Model (POM)
* **Build Tool:** Maven
* **Reporting:** Extent Reports v5
* **CI/CD:** GitHub Actions
* **Logging:** Log4j2

---

## 🌟 Key Framework Features

### 🏛 Architecture & Design
* **Page Object Model (POM):** Decoupled UI elements from test logic, ensuring high maintainability and reduced script fragility.
* **Centralized DriverFactory:** Advanced browser management supporting multiple browsers and **Headless Execution** optimized for CI environments.
* **Parallel Execution Ready:** Architected with thread-safe components to support future scale-up for parallel test runs.
* **Flaky Test Management:** Custom **RetryAnalyzer** logic to handle intermittent network/environment failures.

### 📊 Reporting & Visibility
* **Interactive Extent Reports:** Generates rich HTML reports with step-by-step logs and embedded failure screenshots.
* **Automatic Failure Capture:** Utilizes **TestNG Listeners** to trigger screenshots only when a test fails, optimizing storage and debugging.
* **Log4j2 Integration:** Robust logging mechanism for deep traceability and rapid root cause analysis (RCA).

### 💾 Data & Configuration
* **Data-Driven Testing:** Integrated with **Apache POI** to drive scenarios through external Excel files and TestNG DataProviders.
* **Environment Flexibility:** Externalized configurations via `.properties` files to easily switch between test environments.

### 🔄 CI/CD & DevOps
* **GitHub Actions Pipeline:** Fully automated execution on every code push/Pull Request.
* **Artifact Management:** CI pipeline is configured to upload and store execution reports as downloadable artifacts for historical tracking.
* **Git Workflow:** Adheres to industry-standard branching strategies (Feature branches/PRs) for professional version control.

---

## 🚀 How to Run Locally

1. **Clone the repo:**
   git clone [https://github.com/RanjithaKannan-QA/Selenium-Automation-Framework-with-CI-CD-Reporting.git](https://github.com/RanjithaKannan-QA/Selenium-Automation-Framework-with-CI-CD-Reporting.git)

2. **Ensure you have Maven Installed**
3. **Run the following command in the terminal:** mvn clean test
4. **View Reports:** After execution, navigate to reports/index.html to view the interactive Extent Report.

📬 Contact
Ranjitha Kannan - Senior Quality Assurance Engineer | Toronto, ON https://www.linkedin.com/in/ranjithakannan/
