import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class B {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("hi", "hello", "salute");

        // 1.
        words.stream().forEach(word -> System.out.println("  " + word));

        // 2.
        words.stream().forEach(System.out::println);

        // 3.
        // don't forget toList() when using map() in order to return the result as a list
        List<String> excitingWords = words.stream().map(word -> word + "!").toList();
        System.out.println(excitingWords);

        List<String> eyeWords = words.stream().map(word -> word.replace("i", "eye")).toList();
        System.out.println(eyeWords);

        List<String> upperCaseWords = words.stream().map(word -> word.toUpperCase()).toList();
        System.out.println();

        // 4.
        List<String> shortWords = words.stream().filter(word -> word.length() < 4).toList();
        System.out.println(shortWords);

        List<String> wordsWithB = words.stream().filter(word -> word.contains("b")).toList();
        System.out.println(wordsWithB);

        List<String> evenLengthWords = words.stream().filter(word -> (word.length() % 2) == 0).toList();
        System.out.println(evenLengthWords);

        // 5.
        words = words.stream().map(word -> word.toUpperCase()).toList().
                stream().filter(word -> word.length() < 4).toList().
                stream().filter(word -> word.contains("I")).toList();
        System.out.println(words.get(0));

        words = words.stream().map(word -> word.toUpperCase()).toList().
                stream().filter(word -> word.length() < 4 && word.contains("I")).toList();
        System.out.println(words.get(0));

        words = Arrays.asList("hi", "hello", "salute");

        // 6.
        String result = words.stream().reduce("", (a, b) -> a.toUpperCase() + b.toUpperCase());
        System.out.println(result);

        // 7.
        result = words.stream().map(word -> word.toUpperCase()).reduce("", (a, b) -> a + b);
        System.out.println(result);

        // 8.
        result = words.stream().reduce((a, b) -> a + "," + b).orElse("");
        System.out.println(result);

        // 9.
        int numberOfChars = words.stream().map(String::length).reduce(0, Integer::sum);
        System.out.println(numberOfChars);

        // 10.
        long hs = words.stream().filter(word -> word.contains("h")).count();
        System.out.println(hs);
    }
}
