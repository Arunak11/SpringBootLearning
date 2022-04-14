package CustomExceptionHandling.Controller;

import CustomExceptionHandling.CustomException.BusinessException;
import CustomExceptionHandling.CustomException.ControllerException;
import CustomExceptionHandling.Entity.Employee;
import CustomExceptionHandling.Service.EmployeeServiceInterface;
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
    public ResponseEntity<?> addEmployee(@RequestBody Employee employee){
        try{
            Employee savedEmployee = employeeServiceInterface.addEmployee(employee);
            return new ResponseEntity<Employee>(savedEmployee, HttpStatus.CREATED);
        }
        catch (BusinessException e){
            ControllerException ce = new ControllerException(e.getErrorCode(),e.getErrorMessage());
            return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
        }
        catch (Exception e){
            ControllerException ce = new ControllerException("611","Something went in the controller while adding employee details");
            return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllEmployees(){
        try{
            List <Employee> empList = employeeServiceInterface.getAllEmployee();
            return new ResponseEntity<List<Employee>>(empList,HttpStatus.OK);
        }
        catch (BusinessException e){
            ControllerException ce = new ControllerException(e.getErrorCode(),e.getErrorMessage());
            return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
        }
        catch (Exception e){
            ControllerException ce = new ControllerException("612","Something went in the controller while getting all employee details");
            return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/emp/{empid}")
    public ResponseEntity<?> getEmployeeById(@PathVariable("empid") int empId){
        try{
            Employee empDetail = employeeServiceInterface.getEmployeeById(empId);
            return new ResponseEntity<Employee>(empDetail,HttpStatus.OK);
        }
        catch (BusinessException e){
            ControllerException ce = new ControllerException(e.getErrorCode(),e.getErrorMessage());
            return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
        }
        catch (Exception e){
            ControllerException ce = new ControllerException("613","Something went in the controller while get the employee details");
            return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{empid}")
    public ResponseEntity<?> deleteEmployeeById(@PathVariable("empid") int empId){
        try{
            employeeServiceInterface.deleteEmployeeById(empId);
            return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
        }
        catch (BusinessException e){
            ControllerException ce = new ControllerException(e.getErrorCode(),e.getErrorMessage());
            return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
        }
        catch (Exception e){
            ControllerException ce = new ControllerException("614","Something went in the controller while deleting employee details");
            return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{empid}")
    public ResponseEntity<?> updateEmployee(@RequestBody Employee employee){
        try{
            Employee updatedEmployee = employeeServiceInterface.addEmployee(employee);
            return new ResponseEntity<Employee>(updatedEmployee, HttpStatus.CREATED);
        }
        catch (BusinessException e){
            ControllerException ce = new ControllerException(e.getErrorCode(),e.getErrorMessage());
            return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
        }
        catch (Exception e){
            ControllerException ce = new ControllerException("615","Something went in the controller while updating employee details");
            return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
        }
    }
}
