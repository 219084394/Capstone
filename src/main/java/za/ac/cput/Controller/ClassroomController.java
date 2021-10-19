package za.ac.cput.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Entity.Classroom;
import za.ac.cput.Factory.ClassroomFactory;
import za.ac.cput.Service.ClassroomService;

import java.util.Set;

@RestController
@RequestMapping("/classroom")
public class ClassroomController {
    @Autowired
    private ClassroomService classroomService;

    @PostMapping("/create")
    public Classroom create(@RequestBody Classroom classroom){
        Classroom newClassroom = ClassroomFactory.createClassroom(classroom.getClassCode());
        return classroomService.create(newClassroom);
    }

    @GetMapping("/read/{id}")
    public Classroom read(@PathVariable String id) { return classroomService.read(id); }

    @PostMapping("/update")
    public Classroom update(@RequestBody Classroom classroom) { return classroomService.update(classroom); }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id) { return classroomService.delete(id); }

    @GetMapping("/getall")
    public Set<Classroom> getAll() {return classroomService.getAll();}

}
