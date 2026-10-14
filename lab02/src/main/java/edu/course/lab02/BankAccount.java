package edu.course.lab02;

public class BankAccount {

    private int balance;

    public BankAccount(int balance) {
        if (balance < 0) {
            throw new IllegalArgumentException(
                "Balance cannot be negative"
            );
        }
        this.balance = balance;
    }

    public void deposit(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(
                "Deposit must be positive"
            );
        }
        balance += amount;
    }

    public void withdraw(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(
                "Withdraw must be positive"
            );
        }

        if (amount > balance) {
            throw new IllegalArgumentException(
                "Withdraw is bigger than balance"
            );
        }
        balance -= amount;
    }

    public int getBalance() {
        return balance;
    }
}
