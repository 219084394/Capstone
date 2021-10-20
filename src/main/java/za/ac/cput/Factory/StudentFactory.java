package za.ac.cput.Factory;

/*StudentFactory.java
 * Student Factory code
 * @author Anicka Schouw 217284183
 * October 2021
 */

import za.ac.cput.Entity.Student;

public class StudentFactory {

    public static Student build(String studentNo, String stFname, String stLname, String stEmail){

        if(stFname.isEmpty() && stLname.isEmpty()){
            return null;
        }

        return new Student.StudentBuilder().setStudentNo(studentNo)
                .setStFname(stFname)
                .setStLname(stLname)
                .setStEmail(stEmail)
                .build();
    }

}
