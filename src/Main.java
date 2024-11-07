public class Main {
    public static void main(String[] args) {
        Store store = new Store();

        // Добавляем товары с двух складов
        store.addProduct(new Product("Television", 300));
        store.addProduct(new Product("Phone", 150));
        store.addProduct(new Product("Laptop", 500));
        store.addProduct(new Product("Tablet", 200));

        // Покупатели покупают товары
        store.buyCheapestProduct();
        store.buyCheapestProduct();
        store.buyCheapestProduct();
        store.buyCheapestProduct();
        store.buyCheapestProduct();  // Проверка, что произойдет, если товаров больше нет
    }
}