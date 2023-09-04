package pro.sky.homework28;

public class EmployeeAlreadyAddedException extends Exception{

    public EmployeeAlreadyAddedException(String message){
        super(message);
    }
}