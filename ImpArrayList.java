import java.util.ArrayList;

/**
 * ImpArrayList
 */
public class ImpArrayList <T> implements StackInterface <T> {

    ArrayList <T> arrayList1 = new ArrayList<>();
    private Calculadora calculator = Calculadora.getInstance();


    @Override
    public void push(T value) {
        arrayList1.add(value);
        }
    
    @Override
    public T pop() {
        T value = arrayList1.get(arrayList1.size()-1);
        arrayList1.remove(arrayList1.size()-1);
        return value;
    }

    @Override
    public int size() {
        return arrayList1.size();
    }
    @Override
    public boolean isEmpty() {
        return arrayList1.isEmpty();
    }



}