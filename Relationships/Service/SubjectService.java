package Relationships.Service;

import Relationships.Entity.Student;
import Relationships.Entity.Subject;
import Relationships.Entity.Teacher;
import Relationships.Repository.StudentRepository;
import Relationships.Repository.SubjectRepository;
import Relationships.Repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Service
public class SubjectService {
    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    TeacherRepository teacherRepository;

    public List<Subject> getAllSubjects() {
        List<Subject> allSubjects = new ArrayList<>();
        subjectRepository.findAll().forEach(allSubjects::add);
        return allSubjects;
    }


    public Subject saveSubjectDetails(Subject subject) {
        return subjectRepository.save(subject);
    }


    public Subject getSubjectById(int id) {
        return subjectRepository.findById(id).get();
    }


    public void deleteSubjectById(int id) {
        subjectRepository.deleteById(id);
    }

    public Subject enrollStudentToSubject(int subID,int studID){
        Subject subject = subjectRepository.findById(subID).get();
        Student student = studentRepository.findById(studID).get();
        subject.enrollStudent(student);
        return subjectRepository.save(subject);

    }

    public Subject assignTeacherToSubject(int subID,int teacherID){
        Subject subject = subjectRepository.findById(subID).get();
        Teacher teacher = teacherRepository.findById(teacherID).get();
        subject.assignTeacher(teacher);
        return subjectRepository.save(subject);
    }

    public List<Student> getEnrolledStudents(int subID){
        List<Student> enrolledStudent = subjectRepository.findBySubjectId(subID);
        return enrolledStudent;
    }
}

