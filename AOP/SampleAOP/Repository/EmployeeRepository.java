package SpringBoot.AOP.SampleAOP.Repository;

import org.springframework.stereotype.Repository;
import SpringBoot.AOP.SampleAOP.Entity.Employee;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Integer> {
}
