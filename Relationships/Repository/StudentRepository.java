package Relationships.Repository;

import Relationships.Entity.Student;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface StudentRepository extends CrudRepository<Student,Integer> {
    public Student findByEmail(String email);

    @Query("SELECT u FROM Student u WHERE u.marks>470")
    public List<Student> findByMarks();

    @Query("SELECT s FROM Student s WHERE s.status = :status")

    public List<Student> findByStatus(@Param("status") String status);

    @Modifying
    @Query("DELETE FROM Student c WHERE c.name = :name")
    public void deleteByName(@Param("name") String name);


}
