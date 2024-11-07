import java.util.Objects;
import java.util.TreeSet;
import java.util.HashSet;

public class Customer implements Comparable<Customer> {
    private String name;
    private String email;
    private int bonusAmount;
    private boolean isEmailConfirmed;

    // Конструктор
    public Customer(String name, String email, int bonusAmount, boolean isEmailConfirmed) {
        this.name = name;
        this.email = email;
        this.bonusAmount = bonusAmount;
        this.isEmailConfirmed = isEmailConfirmed;
    }

    // Геттеры
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getBonusAmount() {
        return bonusAmount;
    }

    public boolean isEmailConfirmed() {
        return isEmailConfirmed;
    }

    // Переопределяем метод compareTo для сортировки в TreeSet
    @Override
    public int compareTo(Customer other) {
        // Сначала сортируем по имени
        int nameCompare = this.name.compareTo(other.name);
        if (nameCompare != 0) return nameCompare;

        // Если имена одинаковы, сравниваем по email
        return this.email.compareTo(other.email);
    }

    // Переопределяем equals для корректной работы в HashSet
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return bonusAmount == customer.bonusAmount &&
                isEmailConfirmed == customer.isEmailConfirmed &&
                Objects.equals(name, customer.name) &&
                Objects.equals(email, customer.email);
    }

    // Переопределяем hashCode для HashSet
    @Override
    public int hashCode() {
        return Objects.hash(name, email, bonusAmount, isEmailConfirmed);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", bonusAmount=" + bonusAmount +
                ", isEmailConfirmed=" + isEmailConfirmed +
                '}';
    }

    // Тестирование работы с TreeSet и HashSet
    public static void main(String[] args) {
        // Создаем несколько объектов Customer
        Customer customer1 = new Customer("Alice", "alice@example.com", 100, true);
        Customer customer2 = new Customer("Bob", "bob@example.com", 50, false);
        Customer customer3 = new Customer("Alice", "alice@example.com", 100, true); // Дубликат customer1
        Customer customer4 = new Customer("Charlie", "charlie@example.com", 75, true);

        // Проверка добавления в TreeSet
        TreeSet<Customer> customerTreeSet = new TreeSet<>();
        customerTreeSet.add(customer1);
        customerTreeSet.add(customer2);
        customerTreeSet.add(customer3); // Не добавится, так как совпадает с customer1
        customerTreeSet.add(customer4);

        System.out.println("TreeSet contents:");
        for (Customer customer : customerTreeSet) {
            System.out.println(customer);
        }

        // Проверка добавления в HashSet
        HashSet<Customer> customerHashSet = new HashSet<>();
        customerHashSet.add(customer1);
        customerHashSet.add(customer2);
        customerHashSet.add(customer3); // Не добавится, так как совпадает с customer1
        customerHashSet.add(customer4);

        System.out.println("\nHashSet contents:");
        for (Customer customer : customerHashSet) {
            System.out.println(customer);
        }
    }
}
