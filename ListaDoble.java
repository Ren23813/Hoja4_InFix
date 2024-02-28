public class ListaDoble <T> {
    private Node<T> next;
    private Node<T> prev;
    private Node<T> current;
    Node<T> firstNode;


    public void push(T value) {
        if ( current== null) { // En caso aún no se tenga registro de algún nodo.
            current= new Node<T>(value);
            current.constructDoble(value);
            firstNode = current;
        } else { // Para crear un nuevo nodo, cuando existe uno previo.
            next = new Node<T>(value);
            current.setNext(next);
            prev = current;
            current = next;
            current.setPrevious(prev);
        }
    }

    public Object pop(T value) {
        Node<T> iterator = firstNode;
        Node<T> target;
        while (value != iterator.getValue()) {
            iterator = iterator.getNext();
        }
        target = iterator;
        current.setNext(target.getNext());
        target.getNext().setPrevious(current);
        return target;
    }

    public int size() {
        int counter = 0;

        Node<T> current = firstNode;

        while (current != null) {
            counter++; // Para llevar conteo de nodos.
            current = current.getNext();
        }

        return counter;
    }

    public boolean isEmpty() {
        return firstNode == null;
    }
    
}
