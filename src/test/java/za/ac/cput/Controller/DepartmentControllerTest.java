package za.ac.cput.Controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import za.ac.cput.Entity.Department;
import za.ac.cput.Factory.DepartmentFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DepartmentControllerTest {

    private static Department department = DepartmentFactory.build("262s","Marketing", 223);
    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseURL = "http://localhost:8080/department";

    @Test
    void a_create(){
        String url = baseURL + "/create";
        ResponseEntity<Department> postResponse = restTemplate.postForEntity(url, department, Department.class);
        assertNotNull(postResponse);
        assertNotNull((postResponse).getBody());
        assertEquals(postResponse.getStatusCode(), HttpStatus.OK);
        department = postResponse.getBody();
        System.out.println("Saved data: " + department);
        assertEquals(department.getDepCode(), postResponse.getBody().getDepCode());
    }

    @Test
    void b_read(){
        String url = baseURL + "/read/" + department.getDepCode();
        System.out.println("URL: " + url);
        ResponseEntity<Department> response = restTemplate.getForEntity(url, Department.class);
        assertEquals(department.getDepCode(), response.getBody().getDepCode());
    }

    @Test
    void c_update(){
        Department updated = new Department.Builder().copy(department).setDepName("ITS").build();
        String url = baseURL + "/update";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + updated);
        ResponseEntity<Department> response = restTemplate.postForEntity(url, updated, Department.class);
        assertNotNull(response.getBody());
    }

    @Test
    void e_delete(){
        String url = baseURL + "/delete" + department.getDepCode();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }

    @Test
    void d_getAll(){
        String url = baseURL + "/getall";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show ALL: ");
        System.out.println(response);
        System.out.println(response.getBody());
    }

}