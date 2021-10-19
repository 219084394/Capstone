package za.ac.cput.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Entity.Course;
import za.ac.cput.Repository.CourseRepository;

import java.util.Set;
import java.util.stream.Collectors;

/*
   EntityFactory.java
   CourseService
   Author: Keenan Solomons (219264228)
   Date: 2 August 2021
*/

@Service
public class CourseService implements ICourseService{
    private static CourseService service = null;

    @Autowired
    private CourseRepository repository;

    @Override
    public Course create(Course course) {
        return this.repository.save(course);
    }

    @Override
    public Course read(String courseId) {
        return this.repository.findById(courseId).orElse(null);
    }

    @Override
    public Course update(Course course) {
        if(this.repository.existsById(course.getCourseCode()))
            return this.repository.save(course);
        return null;
    }

    @Override
    public boolean delete(String courseCode) {
        this.repository.deleteById(courseCode);
        if(this.repository.existsById(courseCode))
            return false;
        else
            return true;
    }

    @Override
    public Set<Course> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }
}
