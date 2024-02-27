import java.util.Vector;

public class VectorStack<T> implements StackInterface<T> {
    private Vector<T> stack;

    /**
     * Constructor que inicializa la pila como un nuevo vector.
     */
    public VectorStack() {
        this.stack = new Vector<>();
    }

    /**
     * Agrega un elemento a la cima de la pila.
     * 
     * @param value el valor a agregar
     */
    public void push(T value) {
        stack.add(value);
    }

    /**
     * Elimina y devuelve el elemento en la cima de la pila.
     * 
     * @return el elemento en la cima de la pila, o null si la pila está vacía
     */
    public T pop() {
        if (!isEmpty()) {
            return stack.remove(stack.size() - 1);
        }
        return null; // Pila vacía
    }

    /**
     * Devuelve el número de elementos en la pila.
     * 
     * @return el tamaño de la pila
     */
    public int size() {
        return stack.size();
    }

    /**
     * Verifica si la pila está vacía.
     * 
     * @return true si la pila está vacía, false en caso contrario
     */
    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
