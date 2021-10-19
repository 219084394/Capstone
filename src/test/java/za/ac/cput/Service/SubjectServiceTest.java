package za.ac.cput.Service;

import org.hibernate.tool.schema.internal.exec.ScriptTargetOutputToFile;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.Entity.Subject;
import za.ac.cput.Factory.SubjectFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class SubjectServiceTest {
    @Autowired
    private SubjectService service;

    private static Subject subject = SubjectFactory.createSubject("RBT","ROBOTICS","12:00","10-12-2021");

    @Test
    void a_create() {
        Subject created = service.create(subject);
        //assertNotNull(created);
        assertEquals(created.getSubjectCode(),subject.getSubjectCode());
        System.out.println("Create: " + created);
    }

    @Test
    void b_read() {
        Subject read = service.read(subject.getSubjectCode());
        assertNotNull(read);
        //assertEquals(read.getSubjectCode(), subject.getSubjectCode());
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        Subject old = service.read("RBT");
        Subject updated = new Subject.SubjectBuilder().copy(old).setSubjectName("ROBOTICS2").build();
        assertNotNull(service.update(updated));
        System.out.println("Update: " + updated);
    }

    @Test
    //@Disabled
    void e_delete() {
        boolean success = service.delete("RBT");
        assertTrue(success);
        System.out.println("Delete: " + success);
    }

    @Test
    void getAll() {
        System.out.println("Show All:");
        System.out.println(service.getAll());
    }

    @Test
    @Disabled
    void getSubjectGivenDescription() {
    }
}