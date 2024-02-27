import java.util.Scanner;

public class Main {

    /**
     * Método principal, ejecuta el programa.
     * 
     * @param args
     */
    public static void main(String[] args) {
        Calculadora calculadora = Calculadora.getInstance();

        Scanner scan = new Scanner(System.in);

        // Cambiar a vectorStack
        // calculadora.setStackImplementation("VectorStack");
        // System.out.println("\nUsando VectorStack:");
        // calculadora.showResultado("5 3 +");
        // calculadora.showResultado("8 2 /");

        String stackType = null;

        while (true) {

            System.out.println("\n------------------------------------");
            System.out.println("\nIngrese el tipo de Stack que desee:");

            System.out.println("1. Stack ArraList");
            System.out.println("2. Stack Vector");
            System.out.println("3. Stack lista");
            System.out.println("4. Salir");
            System.out.print("\nOpción: ");

            String op = scan.nextLine();

            switch (op) {
                case "1":
                    stackType = "ArrayList";
                    System.out.println("Tipo de stack seleccionado: " + stackType);

                    break;
                case "2":
                    stackType = "Vector";
                    System.out.println("Tipo de stack seleccionado: " + stackType);

                    break;
                case "3":
                    stackType = "Lista";
                    System.out.println("Tipo de stack seleccionado: " + stackType);

                    break;

                case "4":
                    System.out.println("---");
                    return;

                default:
                    System.out.println("\nLa opción ingresada no es válida.");
                    break;

            }

        }

    }
}
