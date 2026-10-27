package edu.isgb.school.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "t_department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_department")
    private Integer idDepartment;

    @Column(name = "cl_name")
    private String name;


    @ManyToOne
    @JoinColumn(name = "school_PK_school")
    private School school;

    public Department() {}
    public Department(String name) { this.name = name; }

    public Integer getIdDepartment() { return idDepartment; }
    public void setIdDepartment(Integer id) { this.idDepartment = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public School getSchool() { return school; }
    public void setSchool(School school) { this.school = school; }
}