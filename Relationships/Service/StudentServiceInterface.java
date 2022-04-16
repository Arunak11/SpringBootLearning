package Relationships.Service;

import Relationships.Entity.Student;
import java.util.List;

public interface StudentServiceInterface {
    public List<Student> getAllStudents();
    public Student saveStudentDetails(Student student);
    public Student getStudentById(int id);
    public void deleteStudentById(int id);
    public Student getStudentDetailsByEmail(String email);
    public List<Student> getStudentDetailsByMarks();
    public List<Student> getStudentDetailsByStatus(String status);
    public  void deleteStudentByName(String name);

}
