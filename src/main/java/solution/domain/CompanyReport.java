package solution.domain;

import java.util.HashMap;
import java.util.Map;

public class CompanyReport {
    private Map<String, Integer> departmentEmployeeCount = new HashMap<>();
    private int totalEmployees;

    public void addEmployee(String department) {
        totalEmployees++;
        departmentEmployeeCount.put(department,
                departmentEmployeeCount.getOrDefault(department, 0) + 1);
    }

    public Map<String, Integer> getDepartmentStats() {
        return new HashMap<>(departmentEmployeeCount);
    }

    public int getTotalEmployees() {
        return totalEmployees;
    }
}
