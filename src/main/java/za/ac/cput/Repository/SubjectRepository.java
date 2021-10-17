package za.ac.cput.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.Entity.Subject;

import java.util.HashSet;
import java.util.Set;
@Repository
public interface SubjectRepository extends JpaRepository<Subject, String> {
}
