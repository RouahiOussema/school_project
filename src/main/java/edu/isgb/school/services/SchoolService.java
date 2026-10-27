package edu.isgb.school.services;

import edu.isgb.school.entities.*;
import edu.isgb.school.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SchoolService {


    @Autowired
    private SchoolRepository schoolRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private InstructorRepository instructorRepository;

    @Autowired
    private CourseRepository courseRepository;


    public School createSchool(School school,
                                List<Department> departments,
                                List<Student> students,
                                List<Instructor> instructors) {

        if (departments != null) {
            for (Department d : departments) {
                 d.setSchool(school);  //
            }
            school.setDepartments(departments);
        }

        if (students != null) {
            for (Student s : students) {
                s.setSchool(school);
            }
            school.setStudents(students);
        }

        if (instructors != null) {
            for (Instructor i : instructors) {
                 i.setSchool(school);//
            }
            school.setInstructors(instructors);
        }
        return schoolRepository.save(school);
    }


    public School getSchoolById(Integer id) {
        return schoolRepository.findById(id).orElse(null);
    }


    public Student createStudent(Student student, Address address, Integer schoolId) {
        student.setAddress(address);
        if (schoolId != null) {
            School school = schoolRepository.findById(schoolId).orElse(null);
            if (school != null) {
                student.setSchool(school);
            }
        }
        return studentRepository.save(student);
    }


    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }



    public Instructor createInstructor(Instructor instructor, List<Course> courses) {
        if (courses != null) {
            // Sauvegarder d'abord les courses
            List<Course> savedCourses = courseRepository.saveAll(courses);
            instructor.setCourses(savedCourses);
        }
        return instructorRepository.save(instructor);
    }

    public List<Instructor> getInstructorsByName(String name) {
        return instructorRepository.findByName(name);
    }


    public Instructor getInstructorById(Integer id) {
        return instructorRepository.findById(id).orElse(null);
    }


    public Course getCourseById(Integer id) {
        return courseRepository.findById(id).orElse(null);
    }


    public List<Course> getCoursesByInstructorId(Integer instructorId) {
        Instructor instructor = instructorRepository.findById(instructorId).orElse(null);
        if (instructor != null) {
            return instructor.getCourses();
        }
        return null;
    }


    public Instructor addCourseToInstructor(Integer instructorId, Course course) {
        Instructor instructor = instructorRepository.findById(instructorId).orElse(null);
        if (instructor != null) {
            Course savedCourse = courseRepository.save(course);
            instructor.getCourses().add(savedCourse);
            return instructorRepository.save(instructor);
        }
        return null;
    }
}
