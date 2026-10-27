package edu.isgb.school.entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_Student")
    private Integer idStudent;

    @Column(name = "cl_name_school")
    private String name;

    @Temporal(TemporalType.DATE)
    @Column(name = "cl_birthdate")
    private Date birthDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_PK_ADDRESS")
    private Address address;

    @ManyToOne
    @JoinColumn(name = "school_PK_school")
    private School school;

    public Student() {}
    public Student(String name, Date birthDate) { this.name = name; this.birthDate = birthDate; }

    public Integer getIdStudent() { return idStudent; }
    public void setIdStudent(Integer id) { this.idStudent = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Date getBirthDate() { return birthDate; }
    public void setBirthDate(Date birthDate) { this.birthDate = birthDate; }
    public Address getAddress() { return address; }
    public void setAddress(Address address) { this.address = address; }
    public School getSchool() { return school; }
    public void setSchool(School school) { this.school = school; }
}