public class MyStack {
    private String[] data;
    private int top; // Указывает на индекс верхнего элемента

    // Конструктор с заданием размера стека
    public MyStack(int capacity) {
        data = new String[capacity];
        top = -1; // Изначально стек пуст, поэтому индекс -1
    }

    // Метод для добавления элемента в стек
    public void push(String item) {
        if (top == data.length - 1) {
            throw new StackOverflowError("Stack is full. Cannot push new element.");
        }
        data[++top] = item;
    }

    // Метод для удаления и возврата верхнего элемента из стека
    public String pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty. Cannot pop element.");
        }
        return data[top--];
    }

    // Метод для возврата верхнего элемента без удаления
    public String peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty. Cannot peek element.");
        }
        return data[top];
    }

    // Метод для получения количества элементов в стеке
    public int size() {
        return top + 1;
    }

    // Метод для проверки, пуст ли стек
    public boolean isEmpty() {
        return top == -1;
    }

    // Основной метод для тестирования работы стека
    public static void main(String[] args) {
        MyStack stack = new MyStack(3);

        System.out.println("Is stack empty? " + stack.isEmpty()); // true
        stack.push("A");
        stack.push("B");
        stack.push("C");

        System.out.println("Current size: " + stack.size()); // 3
        System.out.println("Top element (peek): " + stack.peek()); // "C"

        System.out.println("Popped element: " + stack.pop()); // "C"
        System.out.println("Popped element: " + stack.pop()); // "B"

        System.out.println("Current size after pop: " + stack.size()); // 1

        // Попытка добавить элемент в заполненный стек вызовет исключение
        stack.push("D");
        stack.push("E"); // Exception: StackOverflowError

        // Печать оставшихся элементов
        while (!stack.isEmpty()) {
            System.out.println("Popped element: " + stack.pop());
        }

        // Попытка вызвать pop на пустом стеке
        stack.pop(); // Exception: IllegalStateException
    }
}
