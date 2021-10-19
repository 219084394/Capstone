package za.ac.cput.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.Entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, String> {
}
