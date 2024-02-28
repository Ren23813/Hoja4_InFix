public class ListaUna<T> {
    private Node<T> firstNode;

    public void push(T value) {
        if (firstNode == null) {
            firstNode = new Node<T>(value);
        } else {
            Node<T> current = firstNode;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(new Node<T>(value));
        }
    }

    public Object pop(T value) {
        if (firstNode == null) {
            return null; // La lista está vacía
        }
        
        if (firstNode.getValue().equals(value)) {
            Node<T> target = firstNode;
            firstNode = firstNode.getNext();
            return target;
        }

        Node<T> current = firstNode;
        while (current.getNext() != null && !current.getNext().getValue().equals(value)) {
            current = current.getNext();
        }

        if (current.getNext() == null) {
            return null; // El valor no se encontró en la lista
        }

        Node<T> target = current.getNext();
        current.setNext(target.getNext());
        return target;
    }

    public int size() {
        int counter = 0;
        Node<T> current = firstNode;
        while (current != null) {
            counter++;
            current = current.getNext();
        }
        return counter;
    }

    public boolean isEmpty() {
        return firstNode == null;
    }
}
