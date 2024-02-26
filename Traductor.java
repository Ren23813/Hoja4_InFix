import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Traductor <T> {
    private String lista [] = null;

        public String[] leerDatosArchivo(String archivo){
        int contador = 0;
        try(BufferedReader br = new BufferedReader(new FileReader(archivo))){
            String line;

            while ( (line = br.readLine()) != null ) {
                lista[contador] = line;
                contador += 1;
                
            }
            return lista;
        }
        catch (IOException e){
            e.printStackTrace();
            return null;
        }        
    }

    public T Traducir(T lista []){
        //agregar método para traducir 
        return null;
    }
}
