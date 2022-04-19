package Relationships.Repository;

import Relationships.Entity.Student;
import Relationships.Entity.Teacher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface TeacherRepository extends CrudRepository<Teacher,Integer> {


}
