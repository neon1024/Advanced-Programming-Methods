import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // 2.
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 14, 15);

        // a) keeps the numbers which are multiples of 3 or multiples of 2
        // TODO the type in filter() is not required
        List<Integer> multiples_of_3_or_2 = numbers.stream().filter((Integer i) -> i % 3 == 0 || i % 2 == 0).toList();

        System.out.println(multiples_of_3_or_2);

        // b)
        // TODO the type of the result of the filter(), map() etc is automatically deduced
        List<String> morphed_to_string = multiples_of_3_or_2.stream().map((Integer i) -> "A" + (i+1) + "B").toList();

        // TODO BONUS
        // instead of A(i+1)B we want i(i+1)AB
        // numbers.stream().map(i -> i + (i + 1) + "A" + "B") TODO WRONG
        // numbers.stream().map(i -> i + "" + (i + 1) + "A" + "B") TODO OK

        System.out.println(morphed_to_string);

        // c)
        String concatenated_strings = morphed_to_string.stream().collect(Collectors.joining());

        // TODO OR
        // morphed_to_string.stream().reduce("", String::concat); TODO "" is the collector, like a starting variable where the result is stored
        concatenated_strings = morphed_to_string.stream().reduce("", (a, b) -> a + "" + b);
        System.out.println(concatenated_strings);

        // 3.
        List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 14, 15, 16);

        // a)
        List<Integer> not_multiples_of_4 = numbers.stream().filter(number -> number % 4 != 0).toList();

        System.out.println(not_multiples_of_4);

        // b)
        List<Integer> to_succesor = not_multiples_of_4.stream().map(number -> number + 1).toList();

        System.out.println(to_succesor);

        // c)
        int sum = to_succesor.stream().filter(n -> n % 4 != 0).map(n -> n + 1).reduce(0, Integer::sum) % 2;
        // or
        sum = to_succesor.stream().filter(n -> n % 4 != 0).map(n -> n + 1).reduce(0, (a, b) -> a + b) % 2;

        // TODO Threads
        Thread thread = new Thread();
        Runnable runnable = () -> System.out.println("Inside thread");
        thread.run();  // serial
        thread.start();  // parallel
        thread.join();  // wait for the thread

        List<String> strings = new ArrayList<>();

        
    }
}
