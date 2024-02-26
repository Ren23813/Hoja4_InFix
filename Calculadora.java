public class Calculadora {

    private static final Calculadora instance = new Calculadora();
    private Calculadora(){}
    public static Calculadora getInstance(){
        return instance;
    }


    public void showResultado(String expresion){
        System.out.println("\nPila | Operación: " );

        int resultado = expresionEvaluar( expresion);

        System.out.println( "   Resulatado de " +expresion + " : " + resultado);

    }

    public int expresionEvaluar(String expresion){
        CustomStack<Integer> pila = new CustomStack<>();
        
        String[] data = expresion.split(" ");   //Se dividen las lineas del .txt para que por cada espacio se analice la siguiente inmediata entrada

        for(String datos : data){

            if (isNumber(datos)){
                pila.push(Integer.parseInt(datos));
            }

            // condición que ayuda a detectar errores del postfix, si hay más operandos para los operadores
            else if (isOperator(datos)){
                if(pila.size() >2){
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
                        if (operando2 == 0){
                            System.out.println("No es posible dividir entre cero");
                            return 0;
                        }

                        pila.push(operando1 /operando2);
                        break;
                    
                    case "*":
                        pila.push(operando1* operando2);

                        break;


                    default:
                        System.out.println("El operando no es válido");
                        return 0;
                }
            }
            else{
                System.out.println("Error del dato? ");
                return 0;
            }
        }
        
        // para determinar si es correcto el formato 
        if(pila.size() != 1){
            System.out.println("Error del formato del archivo");
            return 0;
        }

        return pila.pop();
      
    }

    private boolean isNumber(String dato){
        try{
            Integer.parseInt(dato);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    private boolean isOperator(String dato){
        return dato.equals("-") ||  dato.equals("+")  || dato.equals("*") || dato.equals("/");
    }
    

}
