package anhnnth.codelean.empsecurity.rest;

import anhnnth.codelean.empsecurity.dao.EmployeeRepository;
import anhnnth.codelean.empsecurity.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeRepository repository;

    @Autowired
    public EmployeeRestController(EmployeeRepository theEmployeeRepository) {
        repository = theEmployeeRepository;
    }

    @GetMapping("/emp")
    List<Employee> all(){
        return repository.findAll();
    }

    @PostMapping("/emp")
    Employee newEmployee(@RequestBody Employee newEmployee) {
        return repository.save(newEmployee);
    }

    @GetMapping("/emp/{id}")
    Employee one(@PathVariable Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    @PutMapping("/emp/{id}")
    Employee updateEmp(@RequestBody Employee updateEmp, @PathVariable Integer id) {
        return repository.findById(id)
                .map(employee -> {
                    employee.setFirstName(updateEmp.getFirstName());
                    employee.setLastName(updateEmp.getLastName());
                    employee.setEmail(updateEmp.getEmail());
                    return repository.save(employee);
                    })
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    @DeleteMapping("emp/{id}")
    void deleteEmployee(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}
