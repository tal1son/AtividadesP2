import java.util.ArrayList;

class Product {
    private String brand;
    private double price;

    public Product(String brand, double price) {
        this.brand = brand;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }
}

class TV extends Product {
    private int inches;

    public TV(String brand, double price, int inches) {
        super(brand, price);
        this.inches = inches;
    }

    public int getInches() {
        return inches;
    }
}

class Refrigerator extends Product {
    private int size;

    public Refrigerator(String brand, double price, int size) {
        super(brand, price);
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}

class Stove extends Product {
    private int burners;

    public Stove(String brand, double price, int burners) {
        super(brand, price);
        this.burners = burners;
    }

    public int getBurners() {
        return burners;
    }
}

class ShoppingCart {
    private int customerID;
    private ArrayList<Product> productList;

    public ShoppingCart(int customerID) {
        this.customerID = customerID;
        this.productList = new ArrayList<>();
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public void removeProduct(Product product) {
        productList.remove(product);
    }

    public String getContents() {
        StringBuilder contents = new StringBuilder("Itens no carrinho de compras:\n");
        for (Product product : productList) {
            contents.append(product.getBrand()).append(" - $").append(product.getPrice()).append("\n");
        }
        return contents.toString();
    }

    public int getCustomerID() {
        return customerID;
    }

    public int getItemCount() {
        return productList.size();
    }

    public double getTotalPrice() {
        double total = 0;
        for (Product product : productList) {
            total += product.getPrice();
        }
        return total;
    }
}

public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart(123);

        TV tv = new TV("Samsung", 1200.50, 55);
        Refrigerator fridge = new Refrigerator("LG", 2300.75, 500);
        Stove stove = new Stove("Electrolux", 1500.25, 4);

        cart.addProduct(tv);
        cart.addProduct(fridge);
        cart.addProduct(stove);

        System.out.println(cart.getContents());
        System.out.println("Total Price: $" + cart.getTotalPrice());
    }
}
