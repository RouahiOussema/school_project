package edu.isgb.school.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_course")
    private Integer idCourse;

    @Column(name = "name_course")
    private String name;


    @ManyToMany(mappedBy = "courses")
    @JsonIgnore
    private List<Instructor> instructors = new ArrayList<>();

    public Course() {}
    public Course(String name) { this.name = name; }

    public Integer getIdCourse() { return idCourse; }
    public void setIdCourse(Integer id) { this.idCourse = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public List<Instructor> getInstructors() { return instructors; }
    public void setInstructors(List<Instructor> instructors) { this.instructors = instructors; }
}