public class Order {
    private String customerName;
    private String coffeeType;
    private int quantity;
    private double price;

    // Constructor
    public Order(String customerName, String coffeeType, int quantity, double price) {
        this.customerName = customerName;
        this.coffeeType = coffeeType;
        this.quantity = quantity;
        this.price = price;
    }

    // Getter and Setter methods
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCoffeeType() {
        return coffeeType;
    }

    public void setCoffeeType(String coffeeType) {
        this.coffeeType = coffeeType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Order{" +
                "customerName='" + customerName + '\'' +
                ", coffeeType='" + coffeeType + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }

    // Method to convert Order to CSV format
    public String toCSV() {
        return customerName + "," + coffeeType + "," + quantity + "," + price;
    }

    // Method to create an Order object from a CSV string
    public static Order fromCSV(String csv) {
        String[] values = csv.split(",");
        String customerName = values[0];
        String coffeeType = values[1];
        int quantity = Integer.parseInt(values[2]);
        double price = Double.parseDouble(values[3]);
        return new Order(customerName, coffeeType, quantity, price);
    }
}
