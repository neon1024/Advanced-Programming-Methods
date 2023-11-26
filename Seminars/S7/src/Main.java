import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<? extends Person> persons = new ArrayList<>() {{
            add(new Person("Joe", 15, EducationLevel.HIGHSCHOOL)),
            add(new Employee("John", 20, EducationLevel.UNIVERSITY, 120000)),
            add(new Employer("Tim", 25, EducationLevel.UNIVERSITY, 250));
        }};
    }
}
