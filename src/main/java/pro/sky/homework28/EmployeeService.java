package pro.sky.homework28;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeService {

    public Map<Integer, String> employees = new HashMap();
    private static final int MAX_SIZE = 10; // максимум сотрудников

    public String employees(){
        return "Список сотрудников:\n" + employees;
    }

    // метод для добавления сотрудника
    public Employee addNewEmployee(int passportNumber, String fullName)
            throws EmployeeStorageIsFullException, EmployeeAlreadyAddedException {

        Employee employee = new Employee(passportNumber, fullName);

        // проверка на наличие сотрудника перед добавлением
        if (employees.containsKey(passportNumber)){
            throw new EmployeeAlreadyAddedException("Ошибка! Сотрудник уже добавлен в список!");
        }

        // проверка на заполненность списка
        if (employees.size() == MAX_SIZE){
            throw new EmployeeStorageIsFullException("Ошибка! Список заполнен!");
        }

        // добавляем сотрудника, увеличиваем счетчик сотрудников
        employees.put(passportNumber, fullName);

        return employee;
    }

    // метод для удаления сотрудника
    public Employee removeEmployee(int passportNumber, String fullName) throws EmployeeNotFoundException {

        Employee employee = new Employee(passportNumber, fullName);

        // проверка на наличие сотрудника перед удалением
        if (!employees.containsKey(passportNumber)){
            throw new EmployeeNotFoundException("Ошибка! Сотрудник не найден!");
        }

        // удаляем сотрудника, уменьшаем счетчик
        employees.remove(passportNumber);

        return employee;
    }

    // метод для поиска сотрудника
    public String findEmployee(int passportNumber)
            throws EmployeeNotFoundException {

        // проверка на наличие сотрудника перед поиском
        if (!employees.containsKey(passportNumber)){
            throw new EmployeeNotFoundException("Ошибка! Сотрудник не найден!");
        }

        return employees.get(passportNumber);
    }
}