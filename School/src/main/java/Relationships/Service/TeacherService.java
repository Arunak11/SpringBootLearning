package Relationships.Service;

import Relationships.Entity.Teacher;
import Relationships.Repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService {
    @Autowired
    TeacherRepository teacherRepository;


    public List<Teacher> getAllTeachers() {
        List<Teacher> allTeachers = new ArrayList<>();
        teacherRepository.findAll().forEach(allTeachers::add);
        return allTeachers;
    }


    public Teacher saveTeacherDetails(Teacher teacher) {
        return teacherRepository.save(teacher);
    }


    public Teacher getTeacherById(int id) {
        return teacherRepository.findById(id).get();
    }


    public void deleteTeacherById(int id) {
        teacherRepository.deleteById(id);
    }
}


