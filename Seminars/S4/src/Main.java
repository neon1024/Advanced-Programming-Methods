import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List list = new ArrayList();

        list.add("asdajsd");
        list.add(Integer.valueOf(10));
        list.add(new Exception());

        List<Integer> listOfIntegers = new ArrayList<>();
        listOfIntegers.add(10);
        listOfIntegers.add(Integer.valueOf(12));

        list.remove(2);
    }
}
