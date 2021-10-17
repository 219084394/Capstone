package za.ac.cput.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Entity.Subject;

import za.ac.cput.Repository.SubjectRepository;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SubjectService implements ISubjectService{
    private static SubjectService service = null;

    @Autowired
    private SubjectRepository repository;

    @Override
    public Subject create(Subject subject) {
        return this.repository.save(subject);
    }

    @Override
    public Subject read(String subCode) {
        return this.repository.findById(subCode).orElse(null);
    }

    @Override
    public Subject update(Subject subject) {
        if (this.repository.existsById(subject.getSubjectCode()))
            return this.repository.save(subject);
        return null;
    }

    @Override
    public boolean delete(String subCode) {
        this.repository.deleteById(subCode);
        if (this.repository.existsById(subCode))
            return false;
        else
            return true;
    }

    @Override
    public Set<Subject> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Subject getSubjectGivenDescription(String description) {
        return null;
    }

/*    @Override
    public Subject getSubjectGivenDescription(String description) {
        Subject s = null;
        Set<Subject> subjects = getAll();
        for (Subject subject : subjects) {
            if (subject.getDescription().equals(description)) {
                s = subject;
                break
            }

        }
    }*/
}
