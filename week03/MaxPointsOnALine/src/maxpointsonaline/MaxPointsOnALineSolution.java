/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maxpointsonaline;

import java.util.HashMap;
import java.util.Map;
import javafx.util.Pair;

/**
 *
 * @author souravpalit
 */
public class MaxPointsOnALineSolution {

    // For each point we are going to calculate slope with all other point. If
    // slope is same that eans day lies on one line. So to do that we sotre the
    // slope in the hashmap with point count. One problem will occur as slope
    // value will be floating value so for the precision reason some slope will 
    // not match. So we are going to devide the deltaY and deltaX with the GCD 
    // of the deltaX and deltaY as a result the will be prime factor and now
    // instead of storing floating result we will store them as pair like
    // Pair(deltaX, deltaY) which will help us to match slope. For example if we
    // have deltax = 3 and deltaY = 2 so slope = deltaY / deltaX = 2 / 3 as gcd
    // of 2 and 3 is 1 and deltaY/gcd = 2 , deltaX/gcd = 3 so ultimately 2/3.
    // Now suppose we have a deltaY = 20 and deltaX = 30 and their gcd will be 10
    // now deltaX/gcd = 30/10 = 3 and deltaY/gcd = 20/10 = 2 so slope 2/3 which
    // is the same. Thats why we are using gcd here.
    // Time Complexity: O(n^2) Space Complexity: O(n)
    public int maxPoints(int[][] points) {
        if (points.length < 3) {
            return points.length;
        }
        
        int maxPoints = 1;
        
        for (int i = 0; i < points.length; i++) {
            maxPoints = Math.max(maxPoints, findMaxPoitsOnALine(points, i));
        }
        
        return maxPoints;
    }
    
    public int findMaxPoitsOnALine(int [][] points, int position) {
        Map<Pair, Integer> lineCounts = new HashMap<>();
        
        int x1 = points[position][0];
        int y1 = points[position][1];
        int maxPoints = 1;
        for (int i = position + 1; i < points.length; i++) {
            int x2 = points[i][0];
            int y2 = points[i][1];
            
            Pair slope = getSlope(x1, y1, x2, y2);
            lineCounts.put(slope, lineCounts.getOrDefault(slope, 1) + 1);
            maxPoints = Math.max(maxPoints, lineCounts.get(slope));
        }
        
        return maxPoints;
    }
    
    public Pair getSlope(int x1, int y1, int x2, int y2) {
        int deltaY = y2 - y1;
        int deltaX = x2 - x1;
        
        if (deltaY == 0) {
            return new Pair(Integer.MAX_VALUE, Integer.MAX_VALUE);
        } else if (deltaX == 0) {
            return new Pair(0, 0);
        }
        
        int gcd = getGCD(deltaX, deltaY);
        
        return new Pair(deltaX / gcd, deltaY / gcd);
    }
     
    
    public int getGCD(int devidend, int devisor) {
        if (devidend % devisor == 0) {
            return devisor;
        }
        
        return getGCD(devisor, devidend % devisor);
    }
    
}
