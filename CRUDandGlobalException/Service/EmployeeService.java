package CRUDandGlobalException.Service;


import CRUDandGlobalException.CustomException.EmptyInputException;
import CRUDandGlobalException.Entity.Employee;
import CRUDandGlobalException.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EmployeeService implements EmployeeServiceInterface{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee addEmployee(Employee employee) {
        if(employee.getName().isEmpty() || employee.getName().length()==0){
            throw new EmptyInputException("601","Enter a valid name, Input is empty");
        }
        Employee savedEmployee = employeeRepository.save(employee);
        return savedEmployee;

    }

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> allEmployee = new ArrayList<>();
        employeeRepository.findAll().forEach(allEmployee::add);
        if(allEmployee.isEmpty()){
            throw new EmptyInputException("602","No employee details in the DB");
        }
        return allEmployee;
    }

    @Override
    public Employee getEmployeeById(int empId) {

        return employeeRepository.findById(empId).get();

    }

    @Override
    public void deleteEmployeeById(int empId) {

        employeeRepository.deleteById(empId);
    }

}
