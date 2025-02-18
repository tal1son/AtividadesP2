import java.util.ArrayList;

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
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
        StringBuilder contents = new StringBuilder();
        for (Product product : productList) {
            contents.append("Produto: ").append(product.getName())
                   .append(", Preço: R$").append(String.format("%.2f", product.getPrice())).append("\n");
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
        double total = 0.0;
        for (Product product : productList) {
            total += product.getPrice();
        }
        return total;
    }
}

public class Main {
    public static void main(String[] args) {
        ShoppingCart carrinho = new ShoppingCart(123);
        
        Product produto1 = new Product("Camiseta", 49.90);
        Product produto2 = new Product("Calça Jeans", 129.90);
        Product produto3 = new Product("Tênis", 199.90);

        carrinho.addProduct(produto1);
        carrinho.addProduct(produto2);
        carrinho.addProduct(produto3);
        
        System.out.println("Cliente ID: " + carrinho.getCustomerID());
        System.out.println("\nItens no carrinho (" + carrinho.getItemCount() + "):");
        System.out.println(carrinho.getContents());
        System.out.println("Total: R$" + String.format("%.2f", carrinho.getTotalPrice()));

        
        carrinho.removeProduct(produto2);
        System.out.println("\nApós remover a Calça Jeans:");
        System.out.println("Itens no carrinho (" + carrinho.getItemCount() + "):");
        System.out.println(carrinho.getContents());
        System.out.println("Total atualizado: R$" + String.format("%.2f", carrinho.getTotalPrice()));
    }
}
