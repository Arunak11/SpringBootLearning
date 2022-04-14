package CRUDandGlobalException.Controller;

import CRUDandGlobalException.Entity.Employee;
import CRUDandGlobalException.Service.EmployeeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeServiceInterface employeeServiceInterface;

    @PostMapping("/save")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){

        Employee savedEmployee = employeeServiceInterface.addEmployee(employee);
        return new ResponseEntity<Employee>(savedEmployee, HttpStatus.CREATED);

    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees(){

        List <Employee> empList = employeeServiceInterface.getAllEmployee();
        return new ResponseEntity<List<Employee>>(empList,HttpStatus.OK);

    }

    @GetMapping("/emp/{empid}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("empid") int empId){

        Employee empDetail = employeeServiceInterface.getEmployeeById(empId);
        return new ResponseEntity<Employee>(empDetail,HttpStatus.OK);

    }

    @DeleteMapping("/delete/{empid}")
    public ResponseEntity<Void> deleteEmployeeById(@PathVariable("empid") int empId){

        employeeServiceInterface.deleteEmployeeById(empId);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);

    }

    @PutMapping("/update/{empid}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){

        Employee updatedEmployee = employeeServiceInterface.addEmployee(employee);
        return new ResponseEntity<Employee>(updatedEmployee, HttpStatus.CREATED);

    }
}

