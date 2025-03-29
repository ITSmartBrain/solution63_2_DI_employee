package solution.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import solution.domain.CompanyReport;
import solution.domain.Employee;
import solution.service.DepartmentService;
import solution.service.EmployeeService;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/company")
public class CompanyController {
    private final EmployeeService employeeService;
    private final DepartmentService departmentService;
    private final CompanyReport companyReport;

    public CompanyController(EmployeeService employeeService,
                             DepartmentService departmentService,
                             CompanyReport companyReport) {
        this.employeeService = employeeService;
        this.departmentService = departmentService;
        this.companyReport = companyReport;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        if (!departmentService.departmentExists(employee.getDepartment())) {
            departmentService.addDepartment(employee.getDepartment());
        }
        return employeeService.addEmployee(employee);
    }

    @GetMapping("/employees/department/{dept}")
    public List<Employee> getEmployeesByDepartment(@PathVariable String dept) {
        return employeeService.getEmployeesByDepartment(dept);
    }

    @GetMapping("/departments")
    public Set<String> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/report")
    public Map<String, Object> getCompanyReport() {
        return Map.of(
                "totalEmployees", companyReport.getTotalEmployees(),
                "departmentStats", companyReport.getDepartmentStats()
        );
    }
}
