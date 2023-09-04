package pro.sky.homework28;

import java.util.Objects;

public class Employee {

    private final String fullName;
    private final int passportNumber;

    public Employee(int passportNumber, String fullName) {
        this.fullName = fullName;
        this.passportNumber = passportNumber;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "fullName='" + fullName + '\'' +
                ", passportNumber=" + passportNumber +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return passportNumber == employee.passportNumber && Objects.equals(fullName, employee.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, passportNumber);
    }

    public String getFullName() {
        return fullName;
    }

    public int getpassportNumber() {
        return passportNumber;
    }
}