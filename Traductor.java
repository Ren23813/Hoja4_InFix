import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Traductor<T> {
    private String lista[] = null;

    private Map<Character, Integer> precedencia;

    public Traductor() {
        precedencia = new HashMap<>();
        precedencia.put('+', 1);
        precedencia.put('-', 1);
        precedencia.put('*', 2);
        precedencia.put('/', 2);
    }

    public String[] leerDatosArchivo(String archivo) {
        int contador = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String line;

            while ((line = br.readLine()) != null) {
                lista[contador] = line;
                contador += 1;

            }
            return lista;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public T Traducir(T lista[]) {
        return null;
    }

    public String infixpaPostfix(String expresion) {
        StringBuilder resultado = new StringBuilder();
        Stack<Character> operadores = new Stack<>();

        for (char caracter : expresion.toCharArray()) {
            if (esOperando(caracter)) {
                resultado.append(caracter);
            } else if (caracter == '(') {
                operadores.push(caracter);
            } else if (caracter == ')') {
                while (!operadores.isEmpty() && operadores.peek() != '(') {
                    resultado.append(operadores.pop());
                }
                operadores.pop(); // quita el simbol '('
            } else {
                // entonces operador
                while (!operadores.isEmpty()
                        && precedencia.getOrDefault(operadores.peek(), 0) >= precedencia.getOrDefault(caracter, 0)) {
                    resultado.append(operadores.pop());
                }
                operadores.push(caracter);
            }
        }

        // add los operadores que faltan
        while (!operadores.isEmpty()) {
            resultado.append(operadores.pop());
        }

        return resultado.toString();
    }

    private boolean esOperando(char caracter) {
        return Character.isLetterOrDigit(caracter);
    }
}
