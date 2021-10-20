package za.ac.cput.Controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import za.ac.cput.Entity.Course;
import za.ac.cput.Factory.CourseFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CourseControllerTest {

    private static Course course = CourseFactory.build("372s","ADT");
    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseURL = "http://localhost:8080/course";

    @Test
    void a_create(){
        String url = baseURL + "/create";
        ResponseEntity<Course> postResponse = restTemplate.postForEntity(url, course, Course.class);
        assertNotNull(postResponse);
        assertNotNull((postResponse).getBody());
        assertEquals(postResponse.getStatusCode(), HttpStatus.OK);
        course = postResponse.getBody();
        System.out.println("Saved data: " + course);
        assertEquals(course.getCourseCode(), postResponse.getBody().getCourseCode());
    }

    @Test
    void b_read(){
        String url = baseURL + "/read/" + course.getCourseCode();
        System.out.println("URL: " + url);
        ResponseEntity<Course> response = restTemplate.getForEntity(url, Course.class);
        assertEquals(course.getCourseCode(), response.getBody().getCourseCode());
    }

    @Test
    void c_update(){
        Course updated = new Course.Builder().copy(course).setCourseName("ITS").build();
        String url = baseURL + "/update";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + updated);
        ResponseEntity<Course> response = restTemplate.postForEntity(url, updated, Course.class);
        assertNotNull(response.getBody());
    }

    @Test
    void e_delete(){
        String url = baseURL + "/delete" + course.getCourseCode();
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