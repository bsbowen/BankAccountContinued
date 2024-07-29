package org.example;

import java.util.Scanner;

//define a class named BankAccount

public class BankAccount {
    //declare private variables for balance and account holder
    private double balance;
    public String accountHolderName;
    private int accountNumber; //add accountNumber attribute to class
    //static variable to keep track of account numbers
    private static int accountCounter = 0;

    // Constructor for BankAccount class that initializes balance and accountHolderName
    public BankAccount(double balance, String accountHolderName) {
        this.balance = balance;
        this.accountHolderName = accountHolderName;
        this.accountNumber = ++accountCounter; //increment and assign unique account number
    }

    /*new constructor that takes no parameters and allows
     user input for name and starting balance */
    public BankAccount() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter account holder's name: ");
        this.accountHolderName = scanner.next();
        System.out.print("Enter starting balance: ");
        this.balance = scanner.nextDouble();
        this.accountNumber = ++accountCounter; //increment and assign unique account number
    }

    //public method to deposit an amount into the account
    public void deposit(double amount) {
        this.balance += amount; //add amount to the current balance.

    }

    //public method to withdraw an amount from the account
    public void withdraw(double amount) {
        this.balance -= amount; //subtract the amount from the current balance.
    }

    //public method to print the account details to the console
    public void printAccountDetails() {
        System.out.println("The name on this account is: "
                + this.accountHolderName + " and they have a balance of $"
                + " balance: " + this.balance);
    }

    //use generate getter for accountNumber
    public int getAccountNumber() {
        return this.accountNumber;
    }

    //main method to test the BankAccount class
    public static void main(String[] args) {

    }
}