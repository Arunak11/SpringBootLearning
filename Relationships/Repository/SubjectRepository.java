package Relationships.Repository;

import Relationships.Entity.Student;
import Relationships.Entity.Subject;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends CrudRepository<Subject,Integer> {

    @Query("SELECT s from Student s INNER JOIN s.subjects e where e.id = :subID")
    public List<Student> findBySubjectId(@Param("subID")int subID);
}