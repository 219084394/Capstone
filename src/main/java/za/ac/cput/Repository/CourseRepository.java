package za.ac.cput.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.Entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, String> {
}
