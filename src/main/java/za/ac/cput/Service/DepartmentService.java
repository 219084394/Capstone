package za.ac.cput.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Entity.Department;
import za.ac.cput.Repository.DepartmentRepository;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DepartmentService implements IDepartmentService {
    private static DepartmentService service = null;

    @Autowired
    private DepartmentRepository repository;

    @Override
    public Department create(Department department) {
        return this.repository.save(department);
    }

    @Override
    public Department read(String depCode) {
        return this.repository.findById(depCode).orElse(null);
    }

    @Override
    public Department update(Department department) {
        if(this.repository.existsById(department.getDepCode()))
            return this.repository.save(department);
        return null;
    }

    @Override
    public boolean delete(String depCode) {
        this.repository.deleteById(depCode);
        if(this.repository.existsById(depCode))
            return false;
        else
            return true;
    }

    @Override
    public Set<Department> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }
}
