package SpringBoot.AOP.SampleAOP.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import SpringBoot.AOP.SampleAOP.Repository.EmployeeRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import SpringBoot.AOP.SampleAOP.Entity.Employee;
import SpringBoot.AOP.SampleAOP.CustomException.EmptyInputException;
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    public Employee addEmployee(Employee employee) {
        if(employee.getName().isEmpty() || employee.getName().length()==0){
            throw new EmptyInputException("601","Enter a valid name, Input is empty");
        }
        Employee savedEmployee = employeeRepository.save(employee);
        return savedEmployee;

    }


    public List<Employee> getAllEmployee() {
        List<Employee> allEmployee = new ArrayList<>();
        employeeRepository.findAll().forEach(allEmployee::add);
        if(allEmployee.isEmpty()){
            throw new EmptyInputException("602","No employee details in the DB");
        }
        return allEmployee;
    }


    public Employee getEmployeeById(int empId) {

        return employeeRepository.findById(empId).get();

    }


    public void deleteEmployeeById(int empId) {

        employeeRepository.deleteById(empId);
    }

}
