package Relationships.Entity;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="sub_id")
    private int id;
    @Column(name = "sub_name")
    private String name;

    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinTable(name="enrolled_students",
            joinColumns = @JoinColumn(name="sub_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id"))
    private Set<Student> enrolledStudent = new HashSet<>();

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "teacher_ids" , referencedColumnName = "teacher_id")
    private Teacher teacher;

    public void assignTeacher(Teacher teacher){
        this.teacher = teacher;
    }

    public void enrollStudent(Student student){
        enrolledStudent.add(student);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Student> getEnrolledStudent() {
        return enrolledStudent;
    }

    public Teacher getTeacher() {
        return teacher;
    }
}
