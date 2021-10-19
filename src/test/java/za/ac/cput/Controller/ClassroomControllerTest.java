package za.ac.cput.Controller;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import za.ac.cput.Entity.Classroom;
import za.ac.cput.Entity.Subject;
import za.ac.cput.Factory.ClassroomFactory;
import za.ac.cput.Factory.SubjectFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ClassroomControllerTest {

    private static Classroom classroom = ClassroomFactory.createClassroom("AH10");
    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseURL = "http://localhost:8080/classroom";

    @Test
    void a_create() {
        String url = baseURL + "/create";
        ResponseEntity<Classroom> postResponse = restTemplate.postForEntity(url, classroom, Classroom.class);
        assertNotNull(postResponse);
        assertNotNull((postResponse).getBody());
        assertEquals(postResponse.getStatusCode(), HttpStatus.OK);
        classroom = postResponse.getBody();
        System.out.println("Saved data: "+classroom);
        assertEquals(classroom.getClassCode(),postResponse.getBody().getClassCode());
    }

    @Test
    void b_read() {
        String url = baseURL + "/read/" + classroom.getClassCode();
        System.out.println("URL: " + url);
        ResponseEntity<Classroom> response = restTemplate.getForEntity(url, Classroom.class);
        assertEquals(classroom.getClassCode(), response.getBody().getClassCode());
    }

    @Test
    @Disabled
    void c_update() {
        Classroom updated = new Classroom.ClassBuilder().copy(classroom).setClassCode("AH06").build();
        String url = baseURL + "/update";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + updated);
        ResponseEntity<Classroom> response = restTemplate.postForEntity(url, updated, Classroom.class);
        assertNotNull(response.getBody());
    }

    @Test
    @Disabled
    void e_delete() {
        String url = baseURL + "/delete" + classroom.getClassCode();
        System.out.println("URL: " + url);
        restTemplate.delete(url);

     /*   boolean success = service.delete("RBT");
        assertTrue(success);
        System.out.println("Delete: " + success);*/
    }

    @Test
    void d_getAll() {
        String url = baseURL + "/getall";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show ALL:");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}