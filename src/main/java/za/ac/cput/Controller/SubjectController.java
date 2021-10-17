package za.ac.cput.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Entity.Subject;
import za.ac.cput.Factory.SubjectFactory;
import za.ac.cput.Service.SubjectService;

import java.util.Set;


@RestController
@RequestMapping("/subject")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    //@RequestMapping(value = "/create", method = RequestMethod.POST)
    @PostMapping("/create")
    public Subject create(@RequestBody Subject subject){
        Subject newSubject = SubjectFactory.createSubject(subject.getSubjectCode()
                ,subject.getSubjectName(),subject.getTime(),subject.getDate());
        return subjectService.create(newSubject);
    }

    @GetMapping("/read/{id}")
    public Subject read(@PathVariable String id){
        return subjectService.read(id);
    }

    @PostMapping("/update")
    public Subject update(@RequestBody Subject subject){
        return subjectService.update(subject);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){ return subjectService.delete(id);}

    @GetMapping("/getall")
    public Set<Subject> getAll(){
        return subjectService.getAll();
    }
}
