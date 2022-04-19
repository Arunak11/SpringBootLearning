package Relationships.Controller;

import Relationships.Entity.Student;
import Relationships.Entity.Subject;
import Relationships.Service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sun.security.provider.Sun;

import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    SubjectService subjectService;

    @PostMapping("/save")
    public ResponseEntity<Subject> saveSubject(@RequestBody Subject subject){
        Subject savedSubject= subjectService.saveSubjectDetails(subject);
        return new ResponseEntity<>(savedSubject, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Subject>> getAllSubjects(){
        List<Subject> allSubjects = subjectService.getAllSubjects();
        return new ResponseEntity<List<Subject>>(allSubjects,HttpStatus.OK);
    }

    @GetMapping("/all/{subjectID}")
    public ResponseEntity<Subject> getSubject(@PathVariable int subjectID){
        Subject oneSubject = subjectService.getSubjectById(subjectID);
        return new ResponseEntity<>(oneSubject,HttpStatus.OK);
    }

    @PutMapping("/update/{subjectID}")
    public ResponseEntity<Subject> updateSubject(@RequestBody Subject subject){
        Subject savedSubject = subjectService.saveSubjectDetails(subject);
        return new ResponseEntity<>(savedSubject,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{subjectID}")
    public ResponseEntity<Void> deleteSubject(@PathVariable int subjectID){
        subjectService.deleteSubjectById(subjectID);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{subID}/student/{studID}")
    public ResponseEntity<Subject> enrollStudentToSubject(@PathVariable int subID,@PathVariable int studID){
        Subject enrolled = subjectService.enrollStudentToSubject(subID,studID);
        return new ResponseEntity<>(enrolled,HttpStatus.OK);
    }

    @PutMapping("/{subID}/teacher/{teacherID}")
    public ResponseEntity<Subject> assignTeacherToSubject(@PathVariable int subID,@PathVariable int teacherID){
        Subject assigned = subjectService.assignTeacherToSubject(subID,teacherID);
        return new ResponseEntity<>(assigned,HttpStatus.OK);
    }

    @GetMapping("/{subID}/student")
    public ResponseEntity<List<Student>> getEnrolledStudents(@PathVariable int subID){
        List<Student> enrolledStudents = subjectService.getEnrolledStudents(subID);
        return new ResponseEntity<>(enrolledStudents,HttpStatus.OK);
    }
}
