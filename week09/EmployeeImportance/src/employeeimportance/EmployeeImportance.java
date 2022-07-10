/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeeimportance;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Leetcode: 690. Employee Importance
 * Problem Link: https://leetcode.com/problems/employee-importance/
 * @author souravpalit
 */
public class EmployeeImportance {

    // TC: O(N)  SC: O(N) where N is the number of employees
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> employeeMap = new HashMap<>();
       
        for (Employee employee : employees) {
            employeeMap.put(employee.id, employee);
        }
        
        return getTotalImportantce(id, employeeMap);
    }
    
    public int getTotalImportantce(int employeeId, Map<Integer, Employee> employeeMap) {
        if (employeeId == 0) {
            return 0;
        }
        
        Employee employee = employeeMap.get(employeeId);
        int imporance = employee.importance;
        
        for (Integer id : employee.subordinates) {
            imporance += getTotalImportantce(id, employeeMap);
        }
        
        return imporance;
    }
    
}
