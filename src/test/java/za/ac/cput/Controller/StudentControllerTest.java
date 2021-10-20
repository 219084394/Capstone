package za.ac.cput.Controller;

/*StudentControllerTest.java
 *Class contains all Student Controller Test code
 * @author: Anicka Schouw 217284183
 * October 2021
 */

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import za.ac.cput.Entity.Course;
import za.ac.cput.Entity.Student;
import za.ac.cput.Entity.Subject;
import za.ac.cput.Factory.StudentFactory;
import za.ac.cput.Factory.SubjectFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

class StudentControllerTest {
    private static Student student = StudentFactory.build("217284183","Anicka","Schouw","217284183@mycput.ac.za");
    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseURL = "http://localhost:8080/subject";

    @Test
    void a_create() {
        String url = baseURL + "/create";
        ResponseEntity<Student> postResponse = restTemplate.postForEntity(url, student, Student.class);
        assertNotNull(postResponse);
        assertNotNull((postResponse).getBody());
        assertEquals(postResponse.getStatusCode(), HttpStatus.OK);
        student = postResponse.getBody();
        System.out.println("Saved data: "+student);
        assertEquals(student.getStudentNo(),postResponse.getBody().getStudentNo());
    }

    @Test
    void b_read(){
        String url = baseURL + "/read/" + student.getStudentNo();
        System.out.println("URL: " + url);
        ResponseEntity<Student> response = restTemplate.getForEntity(url, Student.class);
        assertEquals(student.getStudentNo(), response.getBody().getStudentNo());
    }

    @Test
    void c_update() {
        Student updated = new Student.StudentBuilder().copy(student).setStLname("Abrahams").build();
        String url = baseURL + "/update";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + updated);
        ResponseEntity<Student> response = restTemplate.postForEntity(url, updated, Student.class);
        assertNotNull(response.getBody());
    }

    @Test
    void e_delete(){
        String url = baseURL + "/delete" + student.getStudentNo();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
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