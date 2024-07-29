package org.example;

import java.util.ArrayList;
import java.util.Scanner;

//main method to test the BankAccount Class
public class Main {
    public static void main(String[] args) {
        //create an arraylist to keep track of all BankAccount objects
        ArrayList<BankAccount> accounts = new ArrayList<>();
        // Create some accounts
        accounts.add(new BankAccount(500.0, "Chelsea"));
        accounts.add(new BankAccount(5000.0, "Britt"));
        accounts.add(new BankAccount(300.0, "Debbie"));

        // Print details of all accounts
        //for (BankAccount account : accounts) {
        //  account.printAccountDetails();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello world! Welcome to The Bowen Bank!");
        while (true) {
            System.out.println("Are you an existing customer? (-1 to exit)");
            System.out.println("1. Yes");
            System.out.println("2. No");
            int response = scanner.nextInt();

            if (response == -1) {
                System.exit(0);
            } else if (response == 1) {
                // Existing customer: select account
                System.out.println("Enter your account number:");
                int accountNumber = scanner.nextInt();
                BankAccount currentAccount = findAccount(accounts, accountNumber);

                if (currentAccount != null) {
                    mainMenu(accounts, currentAccount);
                } else {
                    System.out.println("Account not found.");
                }
            } else if (response == 2) {
                // New customer: create account
                System.out.println("Let's make a new account!");
                BankAccount newAccount = new BankAccount();
                accounts.add(newAccount);
                System.out.println("Account created successfully.");
                //newAccount.printAccountDetails();
                mainMenu(accounts, newAccount);
            } else {
                System.out.println("Invalid response. Please try again.");
            }
        }
    }

    //main menu method for user interaction
    public static void mainMenu
    (ArrayList<BankAccount> accounts, BankAccount currentAccount) {
    Scanner scanner = new Scanner(System.in);
    boolean firstTime = true;
    while (true) {
        if (firstTime) {
            System.out.println("Hello " + currentAccount.accountHolderName + "!");
            System.out.println("Welcome to the Main Menu, what would you like to do today?");
            firstTime = false;
        }
        //print menu options
        System.out.println("1. To check account balance.");
        System.out.println("2. To make a withdrawal.");
        System.out.println("3. To make a deposit.");
        System.out.println("4. To make a transfer to another account.");
        System.out.println("0. To exit.");
        int choice = scanner.nextInt();
        boolean validChoice = false; //new
        switch (choice) {
            case 1:
                currentAccount.printAccountDetails();
                break;
            case 2:
                System.out.print("Enter amount to withdraw: ");
                double withdrawalAmount = scanner.nextDouble();
                currentAccount.withdraw(withdrawalAmount);
                break;
            case 3:
                System.out.print("Enter amount to deposit: ");
                double depositAmount = scanner.nextDouble();
                currentAccount.deposit(depositAmount);
                break;
            case 4:
                System.out.print("Please enter the account number to transfer to: ");
                int targetAccountNumber = scanner.nextInt();
                BankAccount targetAccount = findAccount(accounts, targetAccountNumber);
                if (targetAccount == null) {
                    System.out.println("Account doesn't exist.");
                    validChoice = false; //new
                }else {
                    System.out.print("Please enter the amount to transfer: ");
                    double transferAmount = scanner.nextDouble();
                    transfer(currentAccount, accounts, targetAccountNumber, transferAmount);
                }
                break;
            case 0:
                System.exit(0);
            default:
                System.out.println("Invalid choice. Please try again.");
                validChoice = false; //
             }
             if (validChoice) { //only add new line if a valid choice was made and executed
                 System.out.println();
             }
         }
    }

    // Transfer method to transfer money between accounts
    public static void transfer(BankAccount fromAccount,
                                ArrayList<BankAccount> accounts,
                                int toAccountNumber, double amount)
    {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber() == toAccountNumber) {
                fromAccount.withdraw(amount);
                account.deposit(amount);
                System.out.println("Transfer successful.");
                fromAccount.printAccountDetails();
                account.printAccountDetails();
                return;
            }
        }
        System.out.println("Account doesn't exist");
    }
    // Helper method to find an account by account number
    public static BankAccount findAccount(ArrayList<BankAccount> accounts, int accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }
}
