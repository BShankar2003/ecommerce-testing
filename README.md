📦 Ecommerce Testing Automation (Selenium + TestNG)

Automated end-to-end test framework for Demo Web Shop using:

Java 17

Selenium WebDriver 4

TestNG

Page Object Model

Maven

ChromeDriver

🚀 Features

Full checkout automation

Guest checkout flow

Robust WebDriver wait usage

Page Object Model (POM) structure

Clean reusable methods

Assertions for order success

Stable & maintainable framework

📂 Project Structure
ecommerce-testing
│
├── src
│   ├── main
│   │   └── java
│   │       └── pages
│   │           ├── BaseClass.java
│   │           ├── HomePage.java
│   │           ├── SearchPage.java
│   │           ├── ProductPage.java
│   │           ├── CartPage.java
│   │           └── CheckoutPage.java
│   │           └── OrderConfirmationPage.java
│   │
│   └── test
│       └── java
│           └── tests
│               └── CheckoutTest.java
│
└── pom.xml
└── README.md

▶ How to Run Tests

In terminal:

mvn clean test


Or in IntelliJ:

Right click → Run CheckoutTest

✅ Test Covered

✔ Search for a product
✔ Add product to cart
✔ Close notification bars
✔ Proceed to checkout
✔ Guest checkout
✔ Billing address
✔ Shipping address
✔ Shipping method
✔ Payment method
✔ Payment info
✔ Confirm order
✔ Validate success message

🛠 Tech Stack
Tool	Purpose
Selenium 4	Web automation
TestNG	Test runner
Java 17	Language
Maven	Dependency management
WebDriverWait	Synchronization
ChromeDriver	Browser automation
📸 Demo Execution Screenshot

(Add later if you want)

⭐ Author

Shankar Singh K K
Automation Tester | Java | Selenium

✅ Step 5: Commit README.md

Run:

git add README.md
git commit -m "Added project README"
git push
