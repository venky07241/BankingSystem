import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Account1 {
    private String customerName;
    private String customerId;
    private double balance = 0;

    // Constructor
    public Account1(String customerName, String customerId) {
        this.customerName = customerName;
        this.customerId = customerId;
    }

    // Method to show the menu (you can add more functionalities here)
    public void showMenu() {
        System.out.println("Welcome " + customerName);
        System.out.println("Your ID is " + customerId);
        // Add more menu options and functionalities as needed
    }

    // Additional methods for deposit, withdraw, etc. can be added here
}

public class FirstBank {
    // In-memory database to store account details
    private static Map<String, Account> accountDatabase = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Get account details from the user
            System.out.println("Enter account holder's name:");
            String customerName = scanner.nextLine();
            System.out.println("Enter account holder's ID:");
            String customerId = scanner.nextLine();

            // Check if account already exists
            if (accountDatabase.containsKey(customerId)) {
                System.out.println("Account with ID " + customerId + " already exists. Try again.");
                continue;
            }

            // Create a new account with user-provided details
            Account userAccount = new Account(customerName, customerId);

            // Store the account in the database
            accountDatabase.put(customerId, userAccount);

            // Show the menu for the user
            userAccount.showMenu();

            // Ask if the user wants to add another account
            System.out.println("Do you want to add another account? (yes/no):");
            String response = scanner.nextLine();
            if (!response.equalsIgnoreCase("yes")) {
                break;
            }
        }

        // Close the scanner
        scanner.close();
    }
}
