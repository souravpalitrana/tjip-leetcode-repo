/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minimumarearectangle;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author souravpalit
 */
public class MinimumAreaRectangleSolution {

    // Time Complexity: O(n^2) Space Complexity: O(n)
    // For each point we will try to find a potential upper right point which
    // is actuall diagonal point. If we find a diagonal point now we try to find
    // uppere left and bottom right point present or not(constant time hashmap)
    // if present calculate area and update minimum.
    public int minAreaRect(int[][] points) {
        Map<String, Point> pointMap = new HashMap<>();
        
        for (int [] point : points) {
            pointMap.put(getKey(point[0], point[1]), new Point(point[0], point[1]));
        }
        
        int minRectArea = Integer.MAX_VALUE;
        
        for (int [] point1 : points) {
            for (int [] point2 : points) {
                if (isInUpperRightCorner(point1, point2)) {
                    String upperLeft = getKey(point1[0], point2[1]);
                    String bottomRight = getKey(point2[0], point1[1]);
                    
                    if (pointMap.containsKey(upperLeft) && pointMap.containsKey(bottomRight)) {
                        int l = point2[0] - point1[0];
                        int w = point2[1] - point1[1];
                        minRectArea = Math.min(minRectArea, l * w);
                    }
                }
            }
        }
        
        
        return (minRectArea == Integer.MAX_VALUE) ? 0 : minRectArea;
    }
    
    public boolean isInUpperRightCorner(int [] point1, int [] point2) {
        return point2[0] > point1[0] && point2[1] > point1[1];
    }
    
    public String getKey(int x, int y) {
        return x + "-" + y;
    }
    
    class Point {
        
        int x;
        int y;
        
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
