public class Employee extends Person {
    private double wage;
    private double taxes;

    public Employee(String name, int age, String educationLevel, double wage, double taxes) {
        super(name, age, educationLevel);
        this.wage = wage;
        this.taxes = taxes;
    }
}
