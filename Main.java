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
         //calculadora.setStackImplementation("ArrayList");
        //  System.out.println("\nUsando VectorStack:");
        //  calculadora.showResultado("5 3 +");
        //  calculadora.showResultado("8 2 /");

        String stackType = null;

        while (true) {

            System.out.println("\n------------------------------------");
            System.out.println("\nIngrese el tipo de Stack que desee:");

            System.out.println("1. Stack ArrayList");
            System.out.println("2. Stack Vector");
            System.out.println("3. Stack lista");
            System.out.println("4. Salir");
            System.out.print("\nOpción: ");

            String op = scan.nextLine();
           
            switch (op) {
                
                case "1":
                    stackType = "ArrayList";
                    System.out.println("Tipo de stack seleccionado: " + stackType);
                    calculadora.setStackImplementation(stackType);
                    //calculadora.processExpresiones("datos.txt");

                    break;
                case "2":
                    stackType = "Vector";
                    System.out.println("Tipo de stack seleccionado: " + stackType);

                    break;
                case "3":

                    System.out.println("\n     | Ingrese el tipo de Lista que desea:");
                    System.out.println("     | 1. Encadenada (Simple)");
                    System.out.println("     | 2. Doblemente Encadenada (Double)");
                    System.out.println("     |");
                    System.out.print("     | Opción: ");

                    String listOp = scan.nextLine();
                    switch (listOp) {
                        case "1":
                            stackType = "Lista_Simple";
                            System.out.println("       Tipo de stack seleccionado: " + stackType);

                            break;
                        case "2":
                            stackType = "Lista_Double";
                            System.out.println("       Tipo de stack seleccionado: " + stackType);
                            calculadora.setStackImplementation(stackType);                            
                            calculadora.showResultado("5 3 +");
                            break;
                        default:
                            System.out.println("\nLa opción ingresada no es válida.");
                            break;
                    }

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
