import java.util.ArrayList;
import java.util.Scanner;

class Customer {
    private String name;
    private String address;
    private String email;

    public Customer(String name, String address, String email) {
        this.name = name;
        this.address = address;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nAddress: " + address + "\nEmail: " + email;
    }
}

class Account {
    private int accountNumber;
    private Customer customer;
    private double balance;
    private double dailyWithdrawalLimit;
    private double dailyWithdrawnAmount;

    public Account(int accountNumber, Customer customer, double balance) {
        this.accountNumber = accountNumber;
        this.customer = customer;
        this.balance = balance;
        this.dailyWithdrawalLimit = 1000; // Set an initial daily withdrawal limit
        this.dailyWithdrawnAmount = 0;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double getBalance() {
        return balance;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount) {
        if (amount > 0) {
            if (dailyWithdrawnAmount + amount <= dailyWithdrawalLimit) {
                if (amount <= balance) {
                    balance -= amount;
                    dailyWithdrawnAmount += amount;
                    return true;
                }
            }
        }
        return false;
    }

    public double checkBalance() {
        return balance;
    }

    public String displayAccountInfo() {
        return "Account Number: " + accountNumber + "\nCustomer Information:\n" + customer + "\nBalance: $" + balance;
    }
}

public class Main { // Renamed BankingSystem to Main
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Account> accounts = new ArrayList<>();

        while (true) {
            System.out.println("\nBanking System Menu:");
            System.out.println("1. Create an Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Display Account Information");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    // Create an account
                    System.out.print("Enter customer name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter customer address: ");
                    String address = scanner.nextLine();
                    System.out.print("Enter customer email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter initial balance: ");
                    double initialBalance = scanner.nextDouble();

                    Customer customer = new Customer(name, address, email);
                    Account account = new Account(accounts.size() + 1, customer, initialBalance);
                    accounts.add(account);

                    System.out.println("Account created successfully. Account Number: " + account.getAccountNumber()); // Display the account number
                    break;

                case 2:
                    // Deposit money
                    System.out.print("Enter account number: ");
                    int accountNumber = scanner.nextInt();
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();

                    if (accountNumber >= 1 && accountNumber <= accounts.size()) {
                        Account depositAccount = accounts.get(accountNumber - 1);
                        if (depositAccount.deposit(depositAmount)) {
                            System.out.println("Deposit successful.");
                        } else {
                            System.out.println("Invalid deposit amount.");
                        }
                    } else {
                        System.out.println("Invalid account number.");
                    }
                    break;

                case 3:
                    // Withdraw money
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.nextInt();
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount = scanner.nextDouble();

                    if (accountNumber >= 1 && accountNumber <= accounts.size()) {
                        Account withdrawalAccount = accounts.get(accountNumber - 1);
                        if (withdrawalAccount.withdraw(withdrawalAmount)) {
                            System.out.println("Withdrawal successful.");
                        } else {
                            System.out.println("Invalid withdrawal amount or exceeded daily withdrawal limit.");
                        }
                    } else {
                        System.out.println("Invalid account number.");
                    }
                    break;

                case 4:
                    // Check balance
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.nextInt();

                    if (accountNumber >= 1 && accountNumber <= accounts.size()) {
                        Account checkBalanceAccount = accounts.get(accountNumber - 1);
                        double balance = checkBalanceAccount.checkBalance();
                        System.out.println("Account balance: $" + balance);
                    } else {
                        System.out.println("Invalid account number.");
                    }
                    break;

                case 5:
                    // Display account information
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.nextInt();

                    if (accountNumber >= 1 && accountNumber <= accounts.size()) {
                        Account displayAccount = accounts.get(accountNumber - 1);
                        System.out.println(displayAccount.displayAccountInfo());
                    } else {
                        System.out.println("Invalid account number.");
                    }
                    break;

                case 6:
                    // Exit the program
                    System.out.println("Exiting the Banking System.");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }
        }
    }
}