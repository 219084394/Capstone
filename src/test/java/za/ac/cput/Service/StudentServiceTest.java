package za.ac.cput.Service;

/*StudentServiceTest.java
 *Class contains all Student Service Test code
 * @author: Anicka Schouw 217284183
 * October 2021
 */

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.Entity.Course;
import za.ac.cput.Entity.Student;
import za.ac.cput.Entity.Subject;
import za.ac.cput.Factory.StudentFactory;
import za.ac.cput.Factory.SubjectFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest

class StudentServiceTest {
    @Autowired
    private StudentService service;

    private static Student student = StudentFactory.build("217197284", "Ra'ees", "Abrahams", "217197284@mycput.ac.za");

    @Test
    void a_create(){
        Student created = service.create(student);
        assertEquals(created.getStudentNo(), student.getStudentNo());
        System.out.println("Create student: " + created);
    }

    @Test
    void b_read() {
        Student read = service.read(student.getStudentNo());
        assertNotNull(read);
        System.out.println("Read student: " + read);
    }

    @Test
    void c_update(){
        Student old = service.read("217284183");
        Student updated = new Student.StudentBuilder().copy(old).setStudentNo("217248183").build();
        assertNotNull(service.update(updated));
        System.out.println("Update student: " + updated);
    }

    @Test
    void e_delete(){
        boolean deleted = service.delete("217248183");
        assertTrue(deleted);
        System.out.println("Delete student : " + deleted);
    }

    @Test
    void getAll() {
        System.out.println("Show All:");
        System.out.println(service.getAll());
    }

    @Test
    @Disabled
    void getStudentGivenDescription() {
    }


}