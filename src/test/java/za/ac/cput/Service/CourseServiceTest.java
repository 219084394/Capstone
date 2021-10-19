package za.ac.cput.Service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.Entity.Course;
import za.ac.cput.Factory.CourseFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class CourseServiceTest {
    @Autowired
    private CourseService service;

    private static Course course = CourseFactory.build("272S","AppDev");

    @Test
    void a_create(){
        Course created = service.create(course);
        assertEquals(created.getCourseCode(), course.getCourseCode());
        System.out.println("Create: " + created);
    }

    @Test
    void b_read(){
        Course read = service.read(course.getCourseCode());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update(){
        Course old = service.read("272S");
        Course updated = new Course.Builder().copy(old).setCourseName("INM").build();
        assertNotNull(service.update(updated));
        System.out.println("Update: " + updated);
    }

    @Test
    void e_delete(){
        boolean success = service.delete("272S");
        assertTrue(success);
        System.out.println("Delete: " + success);
    }

    @Test
    void d_getAll(){
        System.out.println("Show all: ");
        System.out.println(service.getAll());
    }

}