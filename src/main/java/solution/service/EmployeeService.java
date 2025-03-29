package solution.service;

import org.springframework.stereotype.Service;
import solution.domain.CompanyReport;
import solution.domain.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private List<Employee> employees = new ArrayList<>();
    private final CompanyReport companyReport;

    public EmployeeService(CompanyReport companyReport) {
        this.companyReport = companyReport;
    }

    public Employee addEmployee(Employee employee) {
        employee.setId((long) (employees.size() + 1));
        employees.add(employee);
        companyReport.addEmployee(employee.getDepartment());
        return employee;
    }

    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employees);
    }

    public List<Employee> getEmployeesByDepartment(String department) {
        return employees.stream()
                .filter(e -> e.getDepartment().equalsIgnoreCase(department))
                .collect(Collectors.toList());
    }
}
