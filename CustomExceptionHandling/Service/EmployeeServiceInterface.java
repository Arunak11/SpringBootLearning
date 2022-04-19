package CustomExceptionHandling.Service;

import CustomExceptionHandling.Entity.Employee;
import java.util.List;

public interface EmployeeServiceInterface {
    public Employee addEmployee(Employee employee);
    public List<Employee> getAllEmployee();
    public Employee getEmployeeById(int empId);
    public void deleteEmployeeById(int empId);

}
