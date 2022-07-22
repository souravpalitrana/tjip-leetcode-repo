/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courseschedule;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Leetcode: 207. Course Schedule
 * Problem Link: https://leetcode.com/problems/course-schedule/
 * @author souravpalit
 */
public class CourseSchedule {

    int VISITED = 1;
    int VISITING = 2;;
    int UNVISITED = 0;
    
    // TC: O(E + V) SC: O(E + V) where V is the number of course and E is the 
    // number of dependencies
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 1 || prerequisites.length == 0) {
            return true;
        }
        
        Map<Integer, Set<Integer>> adjacencyMap = new HashMap<>();
        Map<Integer, Integer> statusMap = new HashMap<>();
        
        for (int [] prerequisite : prerequisites) {    
            statusMap.put(prerequisite[0], UNVISITED);
            statusMap.put(prerequisite[1], UNVISITED);
            adjacencyMap.putIfAbsent(prerequisite[0], new HashSet<Integer>());
            adjacencyMap.get(prerequisite[0]).add(prerequisite[1]);
        }
        
        for(Map.Entry<Integer, Integer> entry: statusMap.entrySet()) {
            if (entry.getValue() == UNVISITED && 
                hasCycle(entry.getKey(), adjacencyMap, statusMap)) {
                return false;
            }
        }
        
        return true;
    }
    
    public boolean hasCycle(
        int current, 
        Map<Integer, Set<Integer>> adjacencyMap, 
        Map<Integer, Integer> statusMap
    ) {
        statusMap.put(current, VISITING);
        if (adjacencyMap.containsKey(current)) {
            Set<Integer> adjacents = adjacencyMap.get(current);
        
            for (int adjacent : adjacents) {
                if (statusMap.get(adjacent) == VISITING) {
                    return true;
                } else if (statusMap.get(adjacent) == UNVISITED && hasCycle(adjacent, adjacencyMap, statusMap)) {
                    return true;
                }
            }
        }
        
        statusMap.put(current, VISITED);
        return false;
    }
}
