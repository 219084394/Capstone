package za.ac.cput.Service;

import za.ac.cput.Entity.Classroom;

import java.util.Set;

public interface IClassroomService extends IService<Classroom, String>{
    public Set<Classroom> getAll();
}
