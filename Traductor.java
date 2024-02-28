import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Traductor<T> {
    private List<String> lista;

    private Map<Character, Integer> precedencia;

    public Traductor() {
        precedencia = new HashMap<>();
        precedencia.put('+', 1);
        precedencia.put('-', 1);
        precedencia.put('*', 2);
        precedencia.put('/', 2);
    }

    public String[] leerDatosArchivo(String archivo) {
        List<String> lista = new ArrayList<>(); // Cambio: definir lista como ArrayList local

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String line;

            while ((line = br.readLine()) != null) {
                lista.add(line); // Agregar cada línea al ArrayList
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Convertir el ArrayList a un array de strings
        return lista.toArray(new String[0]);
    }

    public T Traducir(T lista[]) {
        return null;
    }

    public String infixpaPostfix(String expresion) {
        StringBuilder resultado = new StringBuilder();
        Stack<Character> operadores = new Stack<>();

        expresion = expresion.replaceAll("\\s+", "");

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
