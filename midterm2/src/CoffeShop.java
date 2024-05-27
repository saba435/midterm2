import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CoffeeShop {
    private String shopName;
    private List<Order> orders;

    // Constructor
    public CoffeeShop(String shopName) {
        this.shopName = shopName;
        this.orders = new ArrayList<>();
    }

    // Method to add an order
    public void addOrder(Order order) {
        orders.add(order);
    }

    // Method to remove an order
    public boolean removeOrder(Order order) {
        return orders.remove(order);
    }

    // Method to get all orders
    public List<Order> getOrders() {
        return orders;
    }

    // Method to get the shop name
    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    // Method to save the state to a CSV file
    public void saveState() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("state.csv"))) {
            for (Order order : orders) {
                writer.write(order.toCSV());
                writer.newLine();
            }
        }
    }

    // Method to restore the state from a CSV file
    public void restoreState() throws IOException {
        orders.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader("state.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                orders.add(Order.fromCSV(line));
            }
        }
    }

    @Override
    public String toString() {
        return "CoffeeShop{" +
                "shopName='" + shopName + '\'' +
                ", orders=" + orders +
                '}';
    }

    // Main method for testing
    public static void main(String[] args) {
        CoffeeShop coffeeShop = new CoffeeShop("Java Beans Cafe");

        Order order1 = new Order("Alice", "Latte", 2, 5.50);
        Order order2 = new Order("Bob", "Espresso", 1, 3.00);

        coffeeShop.addOrder(order1);
        coffeeShop.addOrder(order2);

        try {
            System.out.println("Saving state...");
            coffeeShop.saveState();

            // Simulate restoring state
            CoffeeShop restoredCoffeeShop = new CoffeeShop("Java Beans Cafe");
            System.out.println("Restoring state...");
            restoredCoffeeShop.restoreState();
            System.out.println(restoredCoffeeShop);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
