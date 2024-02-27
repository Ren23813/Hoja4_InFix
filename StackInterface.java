// Archivo: StackInterface.java
public interface StackInterface<T> {
    void push(T value);

    T pop();

    int size();

    boolean isEmpty();
}
