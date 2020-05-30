import java.util.Scanner;

public class Student {
    public String name;
    public String lastName;
    public long pesel;

    protected Scanner scanner = new Scanner(System.in);

    public void setName() {
        this.name = scanner.nextLine();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName() {
        this.lastName = scanner.nextLine();
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPesel() {
        this.pesel = scanner.nextLong();
    }

    public void setPesel(long pesel) {
        this.pesel = pesel;
    }
}
