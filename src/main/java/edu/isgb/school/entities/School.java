package edu.isgb.school.entities;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_school")
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_school")
    private Integer idSchool;

    @Column(name = "cl_name_school")
    private String name;

    private Integer phone;

    // CODE FINAL : mappedBy remis
    @OneToMany(mappedBy = "school", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Department> departments = new ArrayList<>();

    @OneToMany(mappedBy = "school", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Student> students = new ArrayList<>();

    @OneToMany(mappedBy = "school", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Instructor> instructors = new ArrayList<>();//

    public School() {}
    public School(String name, Integer phone) { this.name = name; this.phone = phone; }

    public Integer getIdSchool() { return idSchool; }
    public void setIdSchool(Integer idSchool) { this.idSchool = idSchool; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Integer getPhone() { return phone; }
    public void setPhone(Integer phone) { this.phone = phone; }
    public List<Department> getDepartments() { return departments; }
    public void setDepartments(List<Department> d) { this.departments = d; }
    public List<Student> getStudents() { return students; }
    public void setStudents(List<Student> s) { this.students = s; }
    public List<Instructor> getInstructors() { return instructors; }
    public void setInstructors(List<Instructor> i) { this.instructors = i; }

}