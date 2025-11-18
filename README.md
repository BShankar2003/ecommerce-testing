
# 📦 Ecommerce Testing Automation (Selenium + TestNG)

![Java](https://img.shields.io/badge/Java-17-orange)
![Selenium](https://img.shields.io/badge/Selenium-4-brightgreen)
![TestNG](https://img.shields.io/badge/TestNG-Framework-blue)
![Maven](https://img.shields.io/badge/Maven-Build-red)
![License](https://img.shields.io/badge/License-MIT-green)

Automated **end-to-end checkout testing framework** for **Demo Web Shop** developed using:

* **Java 17**
* **Selenium WebDriver 4**
* **TestNG**
* **Page Object Model (POM)**
* **Maven**
* **ChromeDriver**

This project delivers a **stable, maintainable & scalable automation framework** designed for real-world ecommerce flows.

---

## 🚀 Features

* 🔍 Automated product search
* 🛒 Add-to-cart automation
* 👤 Guest checkout flow
* 🧾 Billing, shipping & payment automation
* ⚡ Robust WebDriverWait usage
* 🧱 Clean Page Object Model (POM) structure
* 🔁 Reusable & maintainable components
* ✔ Assertions for order success
* 🧹 Auto-handling of notification popups
* 💯 Works on latest Chrome versions

---

## 📂 Project Structure

```
ecommerce-testing
│
├── src
│   ├── main
│   │   └── java
│   │       ├── pages
│   │       │   ├── AddToCartPage.java
│   │       │   ├── CartPage.java
│   │       │   ├── CheckoutPage.java
│   │       │   ├── HomePage.java
│   │       │   ├── LoginPage.java
│   │       │   ├── OrderConfirmationPage.java
│   │       │   ├── ProductPage.java
│   │       │   └── SearchPage.java
│   │       │
│   │       └── utils
│   │           ├── BrowserFactory.java
│   │           └── ConfigReader.java
│   │
│   ├── resources
│   │   └── config.properties
│   │
│   └── test
│       └── java
│           ├── base
│           │   └── BaseClass.java
│           │
│           └── tests
│               ├── AddToCartTest.java
│               ├── CheckoutTest.java
│               ├── HomePageTest.java
│               └── LoginTest.java
│
├── pom.xml
└── README.md

```

---

## ▶ How to Run Tests

### **Run from Terminal**

```sh
mvn clean test
```

### **Run from IntelliJ IDEA**

```
Right-click → Run 'CheckoutTest'
```

---

## ✅ Test Flow Covered

✔ Search for a product
✔ Select first product from results
✔ Add product to cart
✔ Close notification bars
✔ Navigate to cart
✔ Proceed to checkout
✔ Guest checkout
✔ Billing address
✔ Shipping address
✔ Shipping method
✔ Payment method
✔ Payment info
✔ Confirm order
✔ Validate order success message

---

## 🛠 Tech Stack

| Tool / Tech       | Purpose                       |
| ----------------- | ----------------------------- |
| **Selenium 4**    | Web automation                |
| **TestNG**        | Test runner                   |
| **Java 17**       | Programming language          |
| **Maven**         | Build & dependency management |
| **WebDriverWait** | Synchronization               |
| **ChromeDriver**  | Browser interaction           |

---

## 📸 Demo Execution Screenshot

### ✔ IntelliJ Test Results
![Test Results](<img width="339" height="538" alt="image" src="https://github.com/user-attachments/assets/ceef599c-c96f-4897-b505-5f78710cbd6b" />
)

### ✔ Console Output
![Console Output](<img width="1137" height="202" alt="image" src="https://github.com/user-attachments/assets/8f92b668-3ff4-4401-a7b7-f78e31d2282c" />
)


---

## 👤 Author

**Shankar Subhan Singh Bondili**
📧 **Email:** [shankarsingh.job@gmail.com](mailto:shankarsingh.job@gmail.com)
🔗 **GitHub:** [https://github.com/BShankar2003](https://github.com/BShankar2003)
💼 Automation Tester | Java | Selenium | TestNG

---

## 📜 License (MIT)

```
MIT License

Copyright (c) 2025 Shankar Subhan Singh Bondili

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:
(license continues…)
```

---

## ✔ Next Steps (Recommended)

* Add screenshots of test runs
* Add GitHub Actions CI pipeline
* Add parallel execution support
* Add Allure reports

---

If you want, I can also:
✅ Add a **LICENSE file**
✅ Add a **.gitignore**
✅ Add **GitHub Actions CI** (`mvn test` on every push)

Just tell me **"Add CI"** or **"Add .gitignore"** etc.
