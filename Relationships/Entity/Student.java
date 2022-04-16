package Relationships.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;
import java.util.HashSet;

@Entity
@Table

public class Student {
    @Id
    @Column(name="student_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name="student_name",length = 255,nullable = false,unique = false)
    private String name;
    @Column
    @Transient
    private int age;
    @Column(name="student_email",length = 255,nullable = false,unique = true)
    private String email;
    @Column(columnDefinition = "varchar(255) default 'active'")
    private String status = "active";
    @Column
    private int marks;

    @JsonIgnore
    @ManyToMany(mappedBy = "enrolledStudent")
    private Set<Subject> subjects = new HashSet<>();

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public int getMarks() {
        return marks;
    }
}
