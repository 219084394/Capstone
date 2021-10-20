package za.ac.cput.Service;

/*StudentService.java
 *Class contains all Student Service code
 * @author: Anicka Schouw 217284183
 * October 2021
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Entity.Student;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class StudentService implements IStudentService {
    private static StudentService service = null;

    @Autowired
    private StudentRepository repository;


    @Override
    public Student create(Student student){
        return this.repository.save(student);
    }

    @Override
    public Student read(String studentNo){
        return this.repository.findById(studentNo).orElse(null);
    }

    @Override
    public Student update(Student student){
        if (this.repository.existsById(student.getStudentNo()))
        return this.repository.save(student);
        return null;
    }

    @Override
    public boolean delete(String studentNo){
        this.repository.deleteById(studentNo);
        if(this.repository.existsById(studentNo))
            return false;
        else
            return true;
    }

    @Override
    public Set<Student> getAll(){
        return this.repository.findALL().stream().collect(Collectors.toSet());
    }

    @Override
    public Student getStudentDescription(String description) {
        return null;
    }

    @Override
    public Student getStudentGivenDescription(String studentDescription){
        return null;
    }


    /*public Student getStudentGivenDescription(String studentDescription){
        Student s = null;
        Set<Student> studentss = getAll();
        for(Student student :studentss){
            if (student.getDescription().equals(studentDescription)){
                s = student;
                break;
            }
        }
        return s;
    }*/

}
