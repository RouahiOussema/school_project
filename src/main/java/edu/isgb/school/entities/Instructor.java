package edu.isgb.school.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_instructor")
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_Instructor")
    private Integer idInstructor;

    @Column(name = "name_Instructor")
    private String name;

    @ManyToOne
    @JoinColumn(name = "school_PK_school")
    private School school;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "t_instructor_t_course",
            joinColumns = @JoinColumn(name = "t_instructor_pk_Instructor"),
            inverseJoinColumns = @JoinColumn(name = "courses_pk_course")
    )
    private List<Course> courses = new ArrayList<>();

    public Instructor() {}
    public Instructor(String name) { this.name = name; }

    public Integer getIdInstructor() { return idInstructor; }
    public void setIdInstructor(Integer id) { this.idInstructor = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public School getSchool() { return school; }
    public void setSchool(School school) { this.school = school; }
    public List<Course> getCourses() { return courses; }
    public void setCourses(List<Course> courses) { this.courses = courses; }
}