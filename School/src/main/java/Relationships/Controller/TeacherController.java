package Relationships.Controller;

import Relationships.Entity.Teacher;
import Relationships.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @PostMapping("/save")
    public ResponseEntity<Teacher> saveTeacher(@RequestBody Teacher teacher){
        Teacher savedTeacher = teacherService.saveTeacherDetails(teacher);
        return new ResponseEntity<>(savedTeacher, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Teacher>> getAllTeacher(){
        List<Teacher> allTeachers = teacherService.getAllTeachers();
        return new ResponseEntity<List<Teacher>>(allTeachers,HttpStatus.OK);
    }

    @GetMapping("/all/{teacherID}")
    public ResponseEntity<Teacher> getTeacher(@PathVariable int teacherID){
        Teacher oneTeacher = teacherService.getTeacherById(teacherID);
        return new ResponseEntity<>(oneTeacher,HttpStatus.OK);
    }

    @PutMapping("/update/{teacherID}")
    public ResponseEntity<Teacher> updateTeacher(@RequestBody Teacher teacher){
        Teacher savedTeacher = teacherService.saveTeacherDetails(teacher);
        return new ResponseEntity<>(savedTeacher,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{teacherID}")
    public ResponseEntity<Void> deleteTeacher(@PathVariable int teacherID){
        teacherService.deleteTeacherById(teacherID);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
