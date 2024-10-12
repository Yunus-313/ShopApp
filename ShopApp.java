import java.util.Scanner;

public class ShopApp {
    public static void main(String args[]) {
        Product p1 = new Product("Milk", 100, 2.5);

        System.out.println("2259699");
        System.out.println("Welcome to the marketplace!!");
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Menu:");
            System.out.println("0: Display products");
            System.out.println("1: Buy Stock");
            System.out.println("2: Sell Stock");
            System.out.println("3: Re-Price an item");
            System.out.println("4: Display Total Value of Stock");
            System.out.println("5: Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 0:
                    displayProducts(p1);
                    break;
                case 1:
                    productBuyStock(p1, sc);
                    break;
                case 2:
                    productSellStock(sc, p1);
                    break;
                case 3:
                    rePriceItem(p1, sc);
                    break;
                case 4:
                    displayTotalValue(p1);
                    break;
                case 5:
                    System.out.println("Exiting bye bye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }

    public static void displayProducts(Product product) {
        System.out.println("Here is what we offer:");
        System.out.println("Name: " + product.getName() + ", Quantity: " + product.getStockLevel() + ", Price: "
                + product.getPrice());

    }

    public static void productBuyStock(Product pBuy, Scanner sc) {
        System.out.println("How much stock would you like to buy?");
        int buys = sc.nextInt();
        pBuy.buyStock(buys);
        System.out.println(pBuy.getStockLevel());
    }

    public static void productSellStock(Scanner sc, Product pSells) {
        System.out.println("How much stock would you like to sell?");
        int sells = sc.nextInt();
        pSells.sellStock(sells);
        System.out.println(pSells.getStockLevel());
    }

    public static void rePriceItem(Product product, Scanner sc) {
        System.out.print("Enter the new price for " + product.getName() + ": ");
        double newPrice = sc.nextDouble();
        product.setPrice(newPrice);
        System.out.println("Price for " + product.getName() + " updated to " + newPrice);
    }

    public static void displayTotalValue(Product product) {
        double totalValue = 0;
        totalValue = product.getPrice();

        System.out.println("Total value of all stock: $" + totalValue);
    }
}
