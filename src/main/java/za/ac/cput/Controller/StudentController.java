package za.ac.cput.Controller;

/*StudentController.java
 *Class contains all Student Controller code
 * @author: Anicka Schouw 217284183
 * October 2021
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Entity.Student;
import za.ac.cput.Factory.StudentFactory;
import za.ac.cput.Service.StudentService;

import java.util.Set;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)

    public Student create(@RequestBody Student student){
        Student newS = StudentFactory.build(student.getStudentNo()
                ,student.getStFname()
                ,student.getStLname()
                ,student.getStEmail());
        return studentService.create(newS);
    }

    @GetMapping("/read")
    public Student read(@RequestBody Student student){
        return studentService.read(student.getStFname());
    }

    @PostMapping("/update")
    public Student update(@RequestBody Student student){
        return studentService.update(student);
    }

    @PostMapping("/delete")
    public String delete(@RequestBody Student student){
        if(studentService.delete(student.getStLname()))
            return "Has been deleted successfully!";
        else
            return "Unsuccessful deletion of item";
    }

    @GetMapping("/getall")
    public Set<Student> getAll(){
        return studentService.getAll();
    }
}
