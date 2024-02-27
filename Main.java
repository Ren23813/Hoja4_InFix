public class Main {

    /**
     * Método principal, ejecuta el programa.
     * 
     * @param args
     */
    public static void main(String[] args) {
        Calculadora calculadora = Calculadora.getInstance();

        // Usar CustomStack
        System.out.println("Usando CustomStack:");
        calculadora.showResultado("5 3 +");
        calculadora.showResultado("8 2 /");

        // Cambiar a vectorStack
        calculadora.setStackImplementation("VectorStack");
        System.out.println("\nUsando VectorStack:");
        calculadora.showResultado("5 3 +");
        calculadora.showResultado("8 2 /");

    }
}
