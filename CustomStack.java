    public class CustomStack <T> {
        private Node<T> lastNode;
        private Node<T> firstNode;
     
    
    
        /**
         * Agrega un nuevo elemento a la pila.
         * @param value
         */
        public void push(T value){
            if(lastNode == null){       //En caso aún no se tenga registro de algún nodo. 
                lastNode = new Node <T>(value);
                firstNode = lastNode; 
            }
            else {      //Para crear un nuevo nodo, cuando existe uno previo. 
                Node<T> current = new Node <T>(value);
                
                current.setNext(firstNode); 
                firstNode = current;
            }
        }
    
    
        /**
         * Elimina un dato de la pila y devuelve el elemento anterior.
         * @return
         */
        public T pop(){
            if(firstNode != null){      //Si existe algún nodo creado
                T value = firstNode.getValue();
                firstNode = firstNode.getNext();
                return value;
            }
            return null;        //Si aún no existe nodo creado previamente. 
        }
    
        /**
         * Obtiene el número de elementos que contiene la pila.
         * @return
         */
        public int size(){
            int counter = 0;
    
            Node<T> current = firstNode;
    
            while(current != null){
                counter  ++;    //Para llevar conteo de nodos.
                current  = current.getNext();
            }
    
            return counter;
        }
}
