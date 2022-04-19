package Relationships.Service;

import Relationships.Entity.Student;
import Relationships.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService implements StudentServiceInterface{
    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        List<Student> allStudents = new ArrayList<>();
        studentRepository.findAll().forEach(allStudents::add);
        return allStudents;
    }

    @Override
    public Student saveStudentDetails(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(int id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public void deleteStudentById(int id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Student getStudentDetailsByEmail(String email) {
        Student details = studentRepository.findByEmail(email);
        return details;
    }

    @Override
    public List<Student> getStudentDetailsByMarks() {
        List<Student> studentList= studentRepository.findByMarks();
        return studentList;
    }

    @Override
    public List<Student> getStudentDetailsByStatus(String status) {
        List<Student> studentList = studentRepository.findByStatus(status);
        return studentList;
    }

    @Override
    public void deleteStudentByName(String name) {
        studentRepository.deleteByName(name);

    }
}

