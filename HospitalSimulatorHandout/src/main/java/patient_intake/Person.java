package patient_intake;

public class Person {
    protected String firstName = "";
    protected String lastName = "";
    protected int age;

    public Person(String firstName, String lastName, int age) {
        // COMPLETED: Stores the variables for firstName, LastName, and age
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }   
}