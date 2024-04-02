import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Wildcard<Integer> w = new Wildcard<>(10);

        w.shout_out();

        Wildcard.shout_out("MrBeast");

        w.shout_out("MrBeast");

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);

        // List<Object> objects = numbers;  // COMPILE ERROR

        List<?> question_mark = numbers;

        ArrayList<A> a = new ArrayList<A>();
        a.add(new A());

        ArrayList<? super B> b = new ArrayList<>();
        b.add(new A());

        List<? super IOException> exceptions = new ArrayList<Exception>();
        exceptions.add(new Exception());
    }
}
