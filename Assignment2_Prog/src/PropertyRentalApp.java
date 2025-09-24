import java.util.Scanner;

public class PropertyRentalApp {

    // Method to validate rental amount input
    private static double readValidAmount(Scanner scanner) {
        while (true) {
            System.out.print("Enter property rental price per month: R");
            String input = scanner.nextLine();
            try {
                double value = Double.parseDouble(input); // try converting
                if (value > 0) {
                    return value; // valid number
                } else {
                    System.out.println("You have entered an invalid amount, please try again!!!!");
                }
            } catch (NumberFormatException e) {
                System.out.println("You have entered an invalid amount, please try again.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PropertyService service = new PropertyService();
        PropertyReport report = new PropertyReport();

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Enter new property");
            System.out.println("2. Search property");
            System.out.println("3. Update property");
            System.out.println("4. Delete a property");
            System.out.println("5. Print property report - 2025");
            System.out.println("0. Exit Application");
            System.out.print("Choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter the property ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter the property address: ");
                    String address = scanner.nextLine();
                    double rent = readValidAmount(scanner); // ✅ validation here
                    System.out.print("Enter the property agent: ");
                    String agent = scanner.nextLine();

                    Property p = new Property(id, address, rent, agent);
                    service.addProperty(p);
                    System.out.println("✅ Property added successfully.");
                    break;

                case 2:
                    System.out.print("Enter property ID to search: ");
                    String searchId = scanner.nextLine();
                    Property found = service.findPropertyById(searchId);
                    report.printProperty(found);
                    break;

                case 3:
                    System.out.print("Enter property ID to update: ");
                    String updateId = scanner.nextLine();
                    System.out.print("Enter new address: ");
                    String newAddr = scanner.nextLine();
                    double newRent = readValidAmount(scanner); // ✅ validation here
                    System.out.print("Enter the property agent: ");
                    String newAgent = scanner.nextLine();

                    if (service.updateProperty(updateId, newAddr, newRent, newAgent)) {
                        System.out.println("✅ Property updated successfully.");
                    } else {
                        System.out.println("❌ Property not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter property ID to delete: ");
                    String deleteId = scanner.nextLine();
                    if (service.deleteProperty(deleteId)) {
                        System.out.println("✅ Property deleted.");
                    } else {
                        System.out.println("❌ Property not found.");
                    }
                    break;

                case 5:
                    report.printAllProperties(service.getAllProperties());
                    break;

                case 0:
                    System.out.println("Goodbye 👋");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
