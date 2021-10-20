package za.ac.cput.Service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.Entity.Department;
import za.ac.cput.Factory.DepartmentFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class DepartmentServiceTest {
    @Autowired
    private DepartmentService service;

    private static Department department = DepartmentFactory.build("626S","Drama","021-397-9643");

    @Test
    void a_create(){
        Department created = service.create(department);
        assertEquals(created.getDepCode(), department.getDepCode());
        System.out.println("Create: " + created);
    }

    @Test
    void b_read(){
        Department read = service.read(department.getDepCode());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update(){
        Department old = service.read("526S");
        Department updated = new Department.Builder().copy(old).setDepName("Business").build();
        assertNotNull(service.update(updated));
        System.out.println("Update: " + updated);
    }

    @Test
    //@Disabled
    void e_delete(){
        boolean success = service.delete("526S");
        assertTrue(success);
        System.out.println("Delete: " + success);
    }

    @Test
    void d_getAll(){
        System.out.println("Show all: ");
        System.out.println(service.getAll());
    }
}