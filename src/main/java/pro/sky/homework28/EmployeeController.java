package pro.sky.homework28;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @ExceptionHandler
    public String handleException(Exception e){
        return e.getMessage();
    }

    private final EmployeeService employeeService;

    // инжектим EmployeeService в EmployeeController
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String employees(){
        return employeeService.employees();
    }

    @GetMapping(path = "/add")   // /employee/add?fullName=Ivan_Ivanov&passportNumber=3498
    public Employee addNewEmployee(@RequestParam("fullName") String fullName, @RequestParam("passportNumber") int passportNumber)
            throws EmployeeStorageIsFullException, EmployeeAlreadyAddedException {
        return employeeService.addNewEmployee(passportNumber, fullName);
    }

    @GetMapping(path = "/remove")    // /employee/remove?fullName=Ivan_Ivanov&passportNumber=3498
    public Employee removeEmployee(@RequestParam("fullName") String fullName, @RequestParam("passportNumber") int passportNumber)
            throws EmployeeNotFoundException {
        return employeeService.removeEmployee(passportNumber, fullName);
    }

    @GetMapping(path = "/find")  // /employee/find?passportNumber=3498
    public String findEmployee(@RequestParam("passportNumber") int passportNumber)
            throws EmployeeNotFoundException {
        return employeeService.findEmployee(passportNumber);
    }

}