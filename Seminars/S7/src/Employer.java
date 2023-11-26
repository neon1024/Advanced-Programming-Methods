public class Employer extends Person {
    private int numberOfEmployees;

    public Employer(String name, int age, String educationLevel, int numberOfEmployees) {
        super(name, age, educationLevel);
        this.numberOfEmployees = numberOfEmployees;
    }
}
