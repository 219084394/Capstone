package za.ac.cput.Service;

/*IStudentService.java
 *Contains all IStudent Service code
 * @author: Anicka Schouw 217284183
 * October 2021
 */
import za.ac.cput.Entity.Student;
import java.util.Set;

public interface IStudentService extends IService<Student, String>{
    public Set<Student> getAll();
    public Student getStudentDescription(String description);


}
