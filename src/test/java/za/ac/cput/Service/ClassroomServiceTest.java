package za.ac.cput.Service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.Entity.Classroom;
import za.ac.cput.Factory.ClassroomFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class ClassroomServiceTest {
    @Autowired
    private ClassroomService service;

    private  static Classroom classroom = ClassroomFactory.createClassroom("AH10");

    @Test
    void a_create() {
        Classroom created = service.create(classroom);
        //assertNotNull(created);
        assertEquals(created.getClassCode(),classroom.getClassCode());
        System.out.println("Create: " + created);
    }

    @Test
    void b_read() {
        Classroom read = service.read(classroom.getClassCode());
        assertNotNull(read);
        //assertEquals(read.getClassCode(), classroom.getClassCode());
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        Classroom old = service.read("AH10");
        Classroom updated = new Classroom.ClassBuilder().copy(old).setClassCode("AH09").build();
        assertNotNull(service.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void e_delete() {
        boolean success = service.delete("AH09");
        assertTrue(success);
        System.out.println("Delete: " + success);
    }

    @Test
    void d_getAll() {
        System.out.println("Show All:");
        System.out.println(service.getAll());
    }
}