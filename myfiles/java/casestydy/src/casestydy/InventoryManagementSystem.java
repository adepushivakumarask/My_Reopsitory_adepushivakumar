package casestydy;

import java.util.Scanner;

public class InventoryManagementSystem {

    static String[] productNames = new String[100];
    static int[] productQuantities = new int[100];
    static int[] productThresholds = new int[100]; 
    static int productCount = 0; 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Inventory Management System ---");
            System.out.println("1. Add New Product");
            System.out.println("2. Update Stock Level");
            System.out.println("3. Generate Inventory Report");
            System.out.println("4. Find a Product");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    addNewProduct(scanner);
                    break;
                case 2:
                    updateStockLevel(scanner);
                    break;
                case 3:
                    generateInventoryReport();
                    break;
                case 4:
                    findProductInInventory(scanner);
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
        scanner.close();
    }

    // add a new product
    public static void addNewProduct(Scanner scanner) {
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter product quantity: ");
        int quantity = scanner.nextInt();
        System.out.print("Enter threshold limit for restocking: ");
        int threshold = scanner.nextInt();

        productNames[productCount] = name;
        productQuantities[productCount] = quantity;
        productThresholds[productCount] = threshold;
        productCount++;

        System.out.println("Product added: " + name);
    }

    // Method to update stock level
    public static void updateStockLevel(Scanner scanner) {
        System.out.print("Enter product name to update: ");
        String name = scanner.nextLine();

        int index = findProduct(name);
        if (index != -1) {
            System.out.print("Enter new stock quantity for " + name + ": ");
            int newQuantity = scanner.nextInt();
            productQuantities[index] = newQuantity;
            System.out.println("Stock updated for: " + name);
        } else {
            System.out.println("Product not found.");
        }
    }

    // generate inventory report
    public static void generateInventoryReport() {
        System.out.println("\n--- Inventory Report ---");
        for (int i = 0; i < productCount; i++) {
            System.out.println("Product: " + productNames[i] + ", Quantity: " + productQuantities[i]);
            if (productQuantities[i] < productThresholds[i]) {
                System.out.println("  *Needs Restocking*");
            }
        }
    }

    // find a product by name
    public static int findProduct(String name) {
        for (int i = 0; i < productCount; i++) {
            if (productNames[i].equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1; 
    }

    // search for a product and display whether it is found or not
    public static void findProductInInventory(Scanner scanner) {
        System.out.print("Enter the product name to search: ");
        String name = scanner.nextLine();
        int index = findProduct(name);

        if (index != -1) {
            System.out.println("Product found: " + productNames[index] + ", Quantity: " + productQuantities[index]);
        } else {
            System.out.println("Product not found");
        }
    }
}