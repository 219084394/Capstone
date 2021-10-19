package za.ac.cput.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.Entity.Classroom;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, String> {
}
