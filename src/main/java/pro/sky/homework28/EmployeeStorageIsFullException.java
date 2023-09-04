package pro.sky.homework28;

public class EmployeeStorageIsFullException extends Exception{

    public EmployeeStorageIsFullException(String message){
        super(message);
    }
}