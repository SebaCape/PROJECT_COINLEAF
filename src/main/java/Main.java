import java.util.Scanner;
/*
 * Driver class for console based application.
 * 
 * @author Sebastian Capellan
 */
public class Main 
{
    public static void main(String[] args) 
    {
        // Initialization of input reading and portfolio management objects
        PortfolioManager manager = new PortfolioManager();
        Scanner scanner = new Scanner(System.in);

        while (true) 
        {
            System.out.println("\nMenu:");
            System.out.println("1. Add Cryptocurrency");
            System.out.println("2. View Portfolio");
            System.out.println("3. Update Cryptocurrency");
            System.out.println("4. Remove Cryptocurrency");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            
            // Read input for switch statement
            int input = scanner.hasNextInt() ? scanner.nextInt() : 6;
            scanner.nextLine();

            switch (input) 
            {
                // Add new Cryptocurrency object
                case 1:
                    System.out.print("Enter cryptocurrency name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    double quantity = scanner.nextDouble();
                    System.out.print("Enter price at purchase: ");
                    double price = scanner.nextDouble();
                    manager.addCrypto(new Crypto(name, quantity, price));
                    break;

                // Read current portfolio
                case 2:
                    manager.viewPortfolio();
                    break;

                // Update selected Cryptocurrency object in portfolio
                case 3:
                    System.out.print("Enter cryptocurrency to update: ");
                    String updateName = scanner.nextLine();
                    System.out.print("Enter new quantity: ");
                    double newQuantity = scanner.nextDouble();
                    manager.updateCrypto(updateName, newQuantity);
                    break;

                // Delete selected Cryptocurrency object from portfolio
                case 4:
                    System.out.print("Enter cryptocurrency name to remove: ");
                    String removeName = scanner.nextLine();
                    manager.removeCrypto(removeName);
                    break;

                // Close program
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                // Default case for invalid inputs
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
