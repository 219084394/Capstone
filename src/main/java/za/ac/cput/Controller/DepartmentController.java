package za.ac.cput.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Entity.Department;
import za.ac.cput.Factory.DepartmentFactory;
import za.ac.cput.Service.DepartmentService;

import java.util.Set;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService service;

    @PostMapping(value = "/create")
    public Department department(@RequestBody Department department){
        Department newDepartment = DepartmentFactory.build(
                department.getDepCode(),
                department.getDepName(),
                department.getOfficeNo()
        );
        return service.create(newDepartment);
    }
    @GetMapping("/read/{id}")
    public Department read(@PathVariable String id){
        return service.read(id);
    }

    @PostMapping("/update")
    public Department update(@RequestBody Department department){
        return service.update(department);
    }
    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){
        return service.delete(id);
    }
    @GetMapping("/getall")
    public Set<Department> getAll(){
        return service.getAll();
    }
}
