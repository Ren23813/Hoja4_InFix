import java.util.Stack;

public class Calculadora {

    private static final Calculadora instance = new Calculadora();

    private StackInterface<Integer> pila;
    private Traductor traductor;

    // CustomStack<Integer> pila = new CustomStack<>();

    private Calculadora() {
        this.pila = new CustomStack<>();
        this.traductor = new Traductor();
    }

    public static Calculadora getInstance() {
        return instance;
    }

    // --------------------------------------------------------------------
    String archivo = "datos.txt";

    public void processExpresiones(String archivo, String stackType) {
        String[] expresiones = traductor.leerDatosArchivo(archivo);

        if (expresiones == null) {
            System.out.println("El archivo no pudo ser procesado.");
            return;
        }

        // se cambia la implementación del stack según sea el caso
        setStackImplementation(stackType);

        for (String expresion : expresiones) {
            String expresionPostfix = traductor.infixpaPostfix(expresion);
            int resultado = expresionEvaluar(expresionPostfix);
            System.out.println("\n- Expresión infix: " + expresion);
            System.out.println("- Expresión postfix: " + expresionPostfix);
            System.out.println("\n\nResultado : " + resultado);
            // System.out.println(" Resulatado de " + expresion + " : " + resultado);

        }
    }
    // -----------------------------------------------------------------------------------------

    // cambiar la implementación del stack
    public void setStackImplementation(String implementation) {
        if (implementation.equals("CustomStack")) {
            this.pila = new CustomStack<>();
        } else if (implementation.equals("Vector")) {
            this.pila = new VectorStack<>();
        } else if (implementation.equals("ArrayList")) {
            this.pila = new ImpArrayList<>();
        } else if (implementation.equals("Lista_Simple")) {
            // colocar el de simple
        } else if (implementation.equals("Lista_Double")) {
            Object pila = new ListaDoble<>();
        } else {
            throw new IllegalArgumentException("La implementación de stack no es válida. ");
        }
    }

    // -------------------------------

    public void showResultado(String expresion) {
        // System.out.println("\nPila | Operación: ");
        //
        int resultado = expresionEvaluar(expresion);
        //
        System.out.println(" Resulatado de " + expresion + " : " + resultado);
        //
    }

    // ---------------------------------------------------

    public int expresionEvaluar(String expresion) {

        String[] data = expresion.split(""); // Se dividen las lineas del .txt para que por cada espacio se analice la
                                              // siguiente inmediata entrada

        for (String datos : data) {

            if (isNumber(datos)) {
                pila.push(Integer.parseInt(datos));
            }

            // condición que ayuda a detectar errores del postfix, si hay más operandos para
            // los operadores
            else if (isOperator(datos)) {
                if (pila.size() > 2) {
                    System.out.println("Error, exceso de operandos para los operadores");
                    return 0;
                }

                int operando1 = pila.pop();
                int operando2 = pila.pop();

                switch (datos) {

                    case "+":

                        pila.push(operando1 + operando2);
                        break;

                    case "-":
                        pila.push(operando1 - operando2);

                        break;

                    case "/":
                        if (operando2 == 0) {
                            System.out.println("No es posible dividir entre cero");
                            return 0;
                        }

                        pila.push(operando2 / operando1);
                        break;

                    case "*":
                        pila.push(operando1 * operando2);

                        break;

                    default:
                        System.out.println("El operando no es válido");
                        return 0;
                }
            } else {
                System.out.println("Error del dato? ");
                return 0;
            }
        }

        // para determinar si es correcto el formato
        if (pila.size() != 1) {
            System.out.println("Error del formato.");
            return 0;
        }

        return pila.pop();

    }

    private boolean isNumber(String dato) {
        try {
            Integer.parseInt(dato);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean isOperator(String dato) {
        return dato.equals("-") || dato.equals("+") || dato.equals("*") || dato.equals("/");
    }

}
