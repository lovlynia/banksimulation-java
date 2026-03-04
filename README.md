# banksimulation-java

This project simulates a real banking environment using object-oriented programming, file storage, and secure login handling — all through a cozy console interface ☕💻

🏦✨ Java Banking System ✨🏦
Welcome to my fully functional Java Banking System!

🌸 Features
✨ Create new accounts (with or without an initial deposit)
🔐 Secure login (by account number or username)
💰 Deposit funds
💸 Withdraw funds
🧾 Transaction tracking to file
📂 Persistent account storage
🎲 Random account number & password generation
🛡️ Duplicate account + username protection
🧁 Project Structure

🏦 Bank.java
The main menu driver of the program!
Displays the interactive banking menu
Handles user input
Routes actions like:
Creating accounts
Depositing
Withdrawing
Exiting safely


👤 Account.java
The base class for all accounts.
Contains:
Private fields for:
Username
Account number
Balance
Password
Static ArrayList<Account> to store active accounts
Getter & setter methods
File storage method (accountInfo.txt)
Basic method structure for deposit/withdraw (overridden later)

🌱 NewAccount.java
Handles brand-new account creation!
Features:
🎂 Birthday parsing + validation (MM/DD/YYYY)
🔁 Duplicate account checking
👤 Duplicate username checking
🎲 Random 7-digit account number generation
🔐 Secure 12-character password generator
📁 Writes new accounts to accountInfo.txt
It ensures:
✔️ No duplicate users
✔️ No duplicate account numbers
✔️ Valid dates only
✔️ Clean data storage

🔓 AccessAccount.java
Handles login and transactions.
Features:
Login via:
Account number + password
Username + password
Overridden deposit() and withdraw() methods
Writes transaction history to transactions.txt
Tracks:
Old balance
Transaction type
Date
New balance

📂 Files Created Automatically
When running the program, two files are generated:
📁 accountInfo.txt
Stores:
Account number
Username
Password
First name
Last name
Date of birth

📁 transactions.txt
Stores:
Username
Account number
Old balance
Transaction type
Date
New balance


🖥️ How to Run
Compile all .java files
Run Bank.java
Follow the menu prompts 🎀
Main Menu
1. Create New Account with deposit
2. Create New Account without Deposit
3. Deposit to Existing Account
4. Withdraw from Existing Account
5. Exit
Simple. Clean. Friendly.

🧠 Concepts Used
Object-Oriented Programming (OOP)
Inheritance
Method Overriding
File I/O (FileInputStream, FileOutputStream, PrintWriter)
Exception Handling
ArrayLists
Random number generation
Input validation
Parsing & String manipulation

🌷 Why This Project?
This project demonstrates:
Real-world class relationships
Clean separation of responsibilities
File persistence
Secure login logic
Defensive programming techniques

💖 Future Improvements
Encrypt stored passwords 🔐
Add balance formatting with currency
Add account deletion
Add transfer between accounts
GUI version (JavaFX or Swing)
Database integration (MySQL)

Thanks for visiting my project! 🌸









