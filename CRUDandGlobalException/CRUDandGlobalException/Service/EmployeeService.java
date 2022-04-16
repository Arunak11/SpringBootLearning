package CRUDandGlobalException.Service;

import CRUDandGlobalException.CustomException.BusinessException;
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
            throw  new BusinessException("601","Enter a valid employee name,It's empty");
        }
        try{
            Employee savedEmployee = employeeRepository.save(employee);
            return savedEmployee;
        }
        catch (IllegalArgumentException e){
            throw new BusinessException("602","Employee details is null");
        }
        catch (Exception e){
            throw new BusinessException("603","Something went wrong in the service layer while adding employee"+e.getMessage());
        }
    }

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> allEmployee = new ArrayList<>();

        try{
            employeeRepository.findAll().forEach(allEmployee::add);
        }
        catch (Exception e){
            throw new BusinessException("605","Something went wrong in the service layer while fetching all employee details"+e.getMessage());
        }
        if(allEmployee.isEmpty()){
            throw new BusinessException("604","No employee detail is present in the DB");
        }
        return allEmployee;
    }

    @Override
    public Employee getEmployeeById(int empId) {
        try{
            return employeeRepository.findById(empId).get();
        }
        catch (NoSuchElementException e){
            throw new BusinessException("606","Check your employee ID, the given ID is not in the DB");
        }
        catch (IllegalArgumentException e){
            throw new BusinessException("607","Enter a valid Emp ID, the given ID is null");
        }

    }

    @Override
    public void deleteEmployeeById(int empId) {
        try{
            employeeRepository.deleteById(empId);
        }
        catch (NoSuchElementException e){
            throw new BusinessException("608","Check your employee ID, the given ID is not in the DB");
        }
        catch (IllegalArgumentException e){
            throw new BusinessException("609","Enter a valid Emp ID, the given ID is null");
        }
    }

}
