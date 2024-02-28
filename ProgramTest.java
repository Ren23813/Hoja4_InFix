import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class ProgramTest {
    @Test
    public void sumaBienHecha(){
        Calculadora calculadora = Calculadora.getInstance();
        
        int comprobar = calculadora.expresionEvaluar("53+");
        assertEquals(comprobar,8);
    }
    @Test
    public void restaBienHecha(){
        Calculadora calculadora = Calculadora.getInstance();
        
        int comprobar = calculadora.expresionEvaluar("57-");
        assertEquals(comprobar,2);
    }

    @Test
    public void multiplicacionBienHecha(){
        Calculadora calculadora = Calculadora.getInstance();
        
        int comprobar = calculadora.expresionEvaluar("35*");
        assertEquals(comprobar,15);
    }
    @Test
    public void divisionBienHecha(){
        Calculadora calculadora = Calculadora.getInstance();
        
        int comprobar = calculadora.expresionEvaluar("28/");
        assertEquals(comprobar,4);
    }

    @Test
    public void sumaMalHecha(){
        Calculadora calculadora = Calculadora.getInstance();
        
        int comprobar = calculadora.expresionEvaluar("22+");
        assertEquals(comprobar,5);  //Se espera un error
    }

    @Test
    public void pruebaArrayList(){
        ImpArrayList arrayList = new ImpArrayList();
        Calculadora calculadora = Calculadora.getInstance();
        calculadora.setStackImplementation("ArrayList");
        int comprobar = calculadora.expresionEvaluar("54+");
        assertEquals(comprobar,9);
        
    }

    @Test
    public void pruebaVector(){
        VectorStack vectorStack  = new VectorStack<>();
        Calculadora calculadora = Calculadora.getInstance();
        calculadora.setStackImplementation("Vector");
        int comprobar = calculadora.expresionEvaluar("37+");
        assertEquals(comprobar,10);
        
    }

    @Test
    public void pruebaListaDoble(){
        ListaDoble listaDoble = new ListaDoble<>();
        Calculadora calculadora = Calculadora.getInstance();
        calculadora.setStackImplementation("Lista_Double");
        int comprobar = calculadora.expresionEvaluar("77+");
        assertEquals(comprobar,14);
        
    }

}
    