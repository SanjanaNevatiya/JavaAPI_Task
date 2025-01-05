package Api.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Api.entity.Department;
import Api.entity.Employee;
import Api.entity.Role;
import Api.repository.DepartmentRepository;
import Api.repository.EmployeeRepository;
import Api.repository.RoleRepository;

@Service
public class EmployeeService {
    
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private RoleRepository roleRepository;

    /**
     * Add a new employee to the system.
     * Ensures that the department and role are valid before saving the employee.
     * 
     * @param employee Employee object to be added
     */
    @Transactional
    public void addEmployee(Employee employee) {
        if (employee == null) {
            throw new IllegalArgumentException("Employee cannot be null");
        }

        // Validate Department
        Department department = departmentRepository.findById(employee.getDepartment().getId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid Department ID"));

        // Validate Role
        Role role = roleRepository.findById(employee.getRole().getId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid Role ID"));

        // Set validated Department and Role
        employee.setDepartment(department);
        employee.setRole(role);

        // Save the Employee to the repository
        employeeRepository.save(employee);
    }

    /**
     * Get an employee by their ID.
     * 
     * @param id Employee ID
     * @return The employee with the given ID
     */
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Employee Not Found"));
    }
}
