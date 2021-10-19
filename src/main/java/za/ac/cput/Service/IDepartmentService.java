package za.ac.cput.Service;

import za.ac.cput.Entity.Department;

import java.util.Set;

public interface IDepartmentService extends IService<Department, String>{
    Set<Department> getAll();
}
