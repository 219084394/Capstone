package za.ac.cput.Repository;

/*StudentRepository.java
 * IStudentRepository code
 * @author Anicka Schouw 217284183
 * October 2021
 */

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.Entity.Student;

@Repository
public interface StudentRepository extends JpaRepository <Student, String> {

}
