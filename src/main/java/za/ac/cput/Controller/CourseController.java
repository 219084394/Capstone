package za.ac.cput.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Entity.Course;
import za.ac.cput.Factory.CourseFactory;
import za.ac.cput.Service.CourseService;

import java.util.Set;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService service;

    @PostMapping(value = "/create")
    public Course create(@RequestBody Course course){
        Course newCourse = CourseFactory.build(
                course.getCourseCode(),
                course.getCourseName());
        return service.create(newCourse);
    }
    @GetMapping("/read/{id}")
    public Course read(@PathVariable String id){
        return service.read(id);
    }

    @PostMapping("/update")
    public Course update(@RequestBody Course course){
        return service.update(course);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){
        return service.delete(id);
    }

    @GetMapping("/getall")
    public Set<Course> getAll() {
        return service.getAll();
    }
}
