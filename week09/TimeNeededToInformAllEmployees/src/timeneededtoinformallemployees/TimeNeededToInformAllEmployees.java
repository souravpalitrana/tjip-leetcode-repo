/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timeneededtoinformallemployees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Leetcode: 1376. Time Needed to Inform All Employees
 * Problem Link: https://leetcode.com/problems/time-needed-to-inform-all-employees/
 * @author souravpalit
 */
public class TimeNeededToInformAllEmployees {

    // TC: O(n) SC: O(n)
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> adjacencyMap = new HashMap<>();
        
        for (int i = 0; i < manager.length; i++) {
            adjacencyMap.putIfAbsent(manager[i], new ArrayList<Integer>());
            adjacencyMap.get(manager[i]).add(i);
        }
        
        return getPropagationTime(adjacencyMap, informTime, headID);
    }
    
    public int getPropagationTime(
        Map<Integer, List<Integer>> adjacencyMap,
        int[] informTime,
        int managerId
    ) {
        int maxTime = Integer.MIN_VALUE;
        
        if (adjacencyMap.containsKey(managerId)) {
            List<Integer> subordinates = adjacencyMap.get(managerId);
        
            for (int subordinate : subordinates) {
                maxTime = Math.max(maxTime, getPropagationTime(adjacencyMap, informTime, subordinate));
            }
        }
        
        return maxTime == Integer.MIN_VALUE ? informTime[managerId] : maxTime + informTime[managerId] ;
    }
    
}
