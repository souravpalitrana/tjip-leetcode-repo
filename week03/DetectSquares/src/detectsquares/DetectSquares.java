/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package detectsquares;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author souravpalit
 */
public class DetectSquares {

    private Map<String, Point> points;
    
    public DetectSquares() {
        points = new HashMap<>();
    }
    
    public void add(int[] point) {
        String key = getKey(point[0], point[1]);
        if (points.containsKey(key)) {
            points.get(key).pointCount++;
        } else {
            points.put(key, new Point(point[0], point[1]));
        }
    }
    
    // Ignoring string conversion of a point as it is language specific
    // Time Complexity:: O(N^2) 
    // Space Complexity: O(1) ignoring stored point
    public int count(int[] qPoint) {
        int total = 0;
        
        for (Point point : points.values()) {
            int x2 = qPoint[0];
            int y2 = qPoint[1];
            int x4 = point.x;
            int y4 = point.y;
            
            // Checking for the same length in each side
            if (x2 == x4 || Math.abs(x4 - x2) != Math.abs(y4 - y2)) {
                continue;
            }
            
            String x4y2 = getKey(x4, y2);
            String x2y4 = getKey(x2, y4);
            
            
            if (points.containsKey(x4y2) && points.containsKey(x2y4)) {
                total += points.get(x2y4).pointCount * points.get(x4y2).pointCount * point.pointCount;
            }
            
        }
        
        return total;
    }
    
    public String getKey(int x, int y) {
        return x + "-" + y;
    }
    
    class Point {
        
        int x;
        int y;
        int pointCount = 1;
        
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
}
