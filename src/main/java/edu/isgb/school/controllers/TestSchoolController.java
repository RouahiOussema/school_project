package edu.isgb.school.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.isgb.school.entities.Address;
import edu.isgb.school.entities.Course;
import edu.isgb.school.entities.Instructor;
import edu.isgb.school.entities.School;
import edu.isgb.school.entities.Student;
import edu.isgb.school.services.SchoolService;

@RestController
@RequestMapping("/api")
public class TestSchoolController {

    @Autowired
    private SchoolService schoolService;



    @PostMapping("/schools")
    public School createSchool(@RequestBody School school) {
        return schoolService.createSchool(school, null, null, null);
    }

    @GetMapping("/schools/{id}")
    public School getSchool(@PathVariable Integer id) {
        return schoolService.getSchoolById(id);
    }



    @PostMapping("/students")
    public Student createStudent(@RequestBody Student student,
                                  @RequestParam(required = false) Integer schoolId) {
        Address address = student.getAddress();
        return schoolService.createStudent(student, address, schoolId);
    }


    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return schoolService.getAllStudents();
    }


    @PostMapping("/instructors")
    public Instructor createInstructor(@RequestBody Instructor instructor) {
        List<Course> courses = instructor.getCourses();
        return schoolService.createInstructor(instructor, courses);
    }


    @GetMapping("/instructors/{id}")
    public Instructor getInstructor(@PathVariable Integer id) {
        return schoolService.getInstructorById(id);
    }


    @GetMapping("/instructors")
    public List<Instructor> getInstructorsByName(@RequestParam String name) {
        return schoolService.getInstructorsByName(name);
    }



    @GetMapping("/courses/{id}")
    public Course getCourse(@PathVariable Integer id) {
        return schoolService.getCourseById(id);
    }


    @GetMapping("/instructors/{id}/courses")
    public List<Course> getCoursesByInstructor(@PathVariable Integer id) {
        return schoolService.getCoursesByInstructorId(id);
    }


    @PostMapping("/instructors/{id}/courses")
    public Instructor addCourse(@PathVariable Integer id, @RequestBody Course course) {
        return schoolService.addCourseToInstructor(id, course);
    }
}
