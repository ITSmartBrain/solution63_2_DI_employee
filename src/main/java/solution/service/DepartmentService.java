package solution.service;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class DepartmentService {
    private final EmployeeService employeeService;
    private final Set<String> departments = new HashSet<>();

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public void addDepartment(String departmentName) {
        departments.add(departmentName);
    }

    public Set<String> getAllDepartments() {
        return new HashSet<>(departments);
    }

    public boolean departmentExists(String departmentName) {
        return departments.contains(departmentName);
    }
}
