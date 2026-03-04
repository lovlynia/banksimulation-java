# banksimulation-java

This project simulates a real banking environment using object-oriented programming, file storage, and secure login handling — all through a cozy console interface ☕💻<br>

🏦✨ Java Banking System ✨🏦<br>
Welcome to my fully functional Java Banking System!

🌸 Features<br>
✨ Create new accounts (with or without an initial deposit)<br>
🔐 Secure login (by account number or username)<br>
💰 Deposit funds<br>
💸 Withdraw funds<br>
🧾 Transaction tracking to file<br>
📂 Persistent account storage<br>
🎲 Random account number & password generation<br>
🛡️ Duplicate account + username protection<br>
🧁 Project Structure<br>

🏦 Bank.java<br>
The main menu driver of the program!<br>
Displays the interactive banking menu<br>
Handles user input<br>
Routes actions like:<br>
- Creating accounts<br>
- Depositing<br>
- Withdrawing<br>
- Exiting safely<br>


👤 Account.java<br>
The base class for all accounts.<br>
Contains:<br>
Private fields for:<br>
- Username<br>
- Account number<br>
- Balance<br>
- Password<br>
Static ArrayList<Account> to store active accounts<br>
Getter & setter methods<br>
File storage method (accountInfo.txt)<br>
Basic method structure for deposit/withdraw <br>

🌱 NewAccount.java<br>
Handles brand-new account creation!<br>
Features:<br>
🎂 Birthday parsing + validation (MM/DD/YYYY)<br>
🔁 Duplicate account checking<br>
👤 Duplicate username checking<br>
🎲 Random 7-digit account number generation<br>
🔐 Secure 12-character password generator<br>
📁 Writes new accounts to accountInfo.txt<br>
It ensures:<br>
✔️ No duplicate users<br>
✔️ No duplicate account numbers<br>
✔️ Valid dates only<br>
✔️ Clean data storage<br>

🔓 AccessAccount.java<br>
Handles login and transactions.<br>
Features:<br>
Login via:<br>
Account number + password<br>
Username + password<br>
Overridden deposit() and withdraw() methods<br>
Writes transaction history to transactions.txt<br>
Tracks:<br>
Old balance<br>
Transaction type<br>
Date<br>
New balance<br>

📂 Files Created Automatically<br>
When running the program, two files are generated:<br>
📁 accountInfo.txt<br>
Stores:<br>
- Account number<br>
- Username<br>
- Password<br>
- First name<br>
- Last name<br>
- Date of birth<br>

📁 transactions.txt<br>
Stores:<br>
- Username<br>
- Account number<br>
- Old balance<br>
- Transaction type<br>
- Date<br>
- New balance<br>


🖥️ How to Run<br>
Compile all .java files<br>
Run Bank.java<br>
Follow the menu prompts 🎀<br>
Main Menu<br>
1. Create New Account with deposit<br>
2. Create New Account without Deposit<br>
3. Deposit to Existing Account<br>
4. Withdraw from Existing Account<br>
5. Exit<br>
Simple. Clean. Friendly.<br>

🧠 Concepts Used<br>
Object-Oriented Programming (OOP)<br>
Inheritance<br>
Method Overriding<br>
File I/O (FileInputStream, FileOutputStream, PrintWriter)<br>
Exception Handling<br>
ArrayLists<br>
Random number generation<br>
Input validation<br>
Parsing & String manipulation<br>

🌷 Why This Project?<br>
This project demonstrates:<br>
Real-world class relationships<br>
Clean separation of responsibilities<br>
File persistence<br>
Secure login logic<br>
Defensive programming techniques<br>

💖 Future Improvements<br>
Encrypt stored passwords 🔐<br>
Add balance formatting with currency<br>
Add account deletion<br>
Add transfer between accounts<br>
GUI version (JavaFX or Swing)<br>
Database integration (MySQL)<br>

Thanks for visiting my project! 🌸









