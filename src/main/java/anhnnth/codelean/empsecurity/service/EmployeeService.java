package anhnnth.codelean.empsecurity.service;
import anhnnth.codelean.empsecurity.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> findAll();
    public Employee findById(int theId);
    public void save(Employee theEmployee);
    public void deleteById(int theId);
    public List<Employee> searchByName(String theName);
}
