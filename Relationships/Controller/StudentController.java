package Relationships.Controller;

import Relationships.Entity.Student;
import Relationships.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/save")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){
        Student savedStudent = studentService.saveStudentDetails(student);
        return new ResponseEntity<>(savedStudent,HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAllStudent(){
        List<Student> allStudents = studentService.getAllStudents();
        return new ResponseEntity<List<Student>>(allStudents,HttpStatus.OK);
    }

    @GetMapping("/all/{studID}")
    public ResponseEntity<Student> getStudent(@PathVariable int studID){
        Student oneStudent = studentService.getStudentById(studID);
        return new ResponseEntity<>(oneStudent,HttpStatus.OK);
    }

    @PutMapping("/update/{studID}")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student){
        Student savedStudent = studentService.saveStudentDetails(student);
        return new ResponseEntity<>(savedStudent,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{studID}")
    public ResponseEntity<Void> deleteStudent(@PathVariable int studID){
        studentService.deleteStudentById(studID);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/get-by-email/{email}")
    public ResponseEntity<Student> getStudentDetailsByEmail(@PathVariable String email){
        Student details =  studentService.getStudentDetailsByEmail(email);
        return new ResponseEntity<>(details,HttpStatus.OK);
    }

    @GetMapping("/get-by-marks")
    public ResponseEntity<List<Student>> getStudentDetailsByMarks(){
        List<Student> allDetails = studentService.getStudentDetailsByMarks();
        return new ResponseEntity<>(allDetails,HttpStatus.OK);
    }

    @GetMapping("/get-by-status/{status}")
    public ResponseEntity<List<Student>> getStudentDetailsByStatus(@PathVariable String status){
        List<Student> allDetails = studentService.getStudentDetailsByStatus(status);
        return new ResponseEntity<>(allDetails,HttpStatus.OK);
    }

    @DeleteMapping("/delete-by-name/{name}")
    public ResponseEntity<Void> deleteStudentByName(@PathVariable String name){
        studentService.deleteStudentByName(name);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

