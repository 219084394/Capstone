package za.ac.cput.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;
import za.ac.cput.Entity.Classroom;
import za.ac.cput.Repository.ClassroomRepository;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ClassroomService implements IClassroomService{
    private static ClassroomService service = null;

    @Autowired
    private ClassroomRepository repository;

    @Override
    public Classroom create(Classroom classroom) { return this.repository.save(classroom); }

    @Override
    public Classroom read(String classCode) { return this.repository.findById(classCode).orElse(null); }

    @Override
    public Classroom update(Classroom classroom) {
        if (this.repository.existsById(classroom.getClassCode()))
            return this.repository.save(classroom);
        return null;
    }

    @Override
    public boolean delete(String classCode) {
        this.repository.deleteById(classCode);
        if (this.repository.existsById(classCode))
            return false;
        else
            return true;
    }

    @Override
    public Set<Classroom> getAll() { return this.repository.findAll().stream().collect(Collectors.toSet()); }

}
