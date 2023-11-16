import java.util.Scanner;


class Bank {
    private double balance;

    public Bank(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit of $" + amount + " successful.");
        } else {
            System.out.println("Please enter a valid amount to deposit.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawal of $" + amount + " successful.");
        } else if (amount <= 0) {
            System.out.println("Please enter a valid amount to withdraw.");
        } else {
            System.out.println("Insufficient funds for withdrawal.");
        }
    }
}


class ATM {
    private Bank bankAccount;

    public ATM(Bank account) {
        this.bankAccount = account;
    }

    public void displayMenu() {
        System.out.println("\nATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 4) {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Current Balance: $" + bankAccount.getBalance());
                    break;
                case 2:
                    System.out.print("Enter deposit amount: $");
                    double depositAmount = scanner.nextDouble();
                    bankAccount.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: $");
                    double withdrawAmount = scanner.nextDouble();
                    bankAccount.withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.println("Exiting. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
        scanner.close();
    }
}


public class Main {
    public static void main(String[] args) {
        Bank userAccount = new Bank(1000); 
        ATM atm = new ATM(userAccount);
        atm.start();
    }
}

