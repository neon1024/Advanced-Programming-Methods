import java.util.Arrays;
import java.util.List;

public class Practice {

    public void main(String[] args) {
        // 1.
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 14, 15);

        List<Integer> result = numbers.stream().filter(number -> (number % 2 == 0) || (number % 3 == 0)).toList();

        System.out.println(result);
    }
}
