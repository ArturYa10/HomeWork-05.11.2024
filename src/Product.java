import java.util.PriorityQueue;

// Класс для товара
class Product implements Comparable<Product> {
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

    // Метод для сравнения товаров по цене
    @Override
    public int compareTo(Product other) {
        return Double.compare(this.price, other.price);
    }

    @Override
    public String toString() {
        return name + " ($" + price + ")";
    }
}

// Класс магазина
class Store {
    private PriorityQueue<Product> products;

    public Store() {
        // Очередь приоритетов для товаров, организованная по цене
        products = new PriorityQueue<>();
    }

    // Метод для добавления товара в магазин
    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Item added: " + product);
    }

    // Метод для покупки самого дешевого товара
    public Product buyCheapestProduct() {
        if (products.isEmpty()) {
            System.out.println("No items in stock!");
            return null;
        } else {
            Product cheapestProduct = products.poll();
            System.out.println("The customer purchased: " + cheapestProduct);
            return cheapestProduct;
        }
    }
}


