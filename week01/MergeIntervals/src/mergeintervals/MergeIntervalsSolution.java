/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mergeintervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author souravpalit
 */
public class MergeIntervalsSolution {
    
    // At first sort the intervals in a ascending order so that when we 
    // try to merge interval we no that first interval will come before second
    // interval which will help us to merge by comparing first's interval end
    // and second interval's start. As sorted we don't need to do the vise versa
    // Time Complexity: O(nlogn) Space Complexity: O(n)
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int []>() {
            @Override
            public int compare(int[] first, int[] second) {
                return Integer.compare(first[0], second[0]);
            }
           
        });
        
        LinkedList<int []> mergedIntervalList = new LinkedList<int []>();
        mergedIntervalList.add(intervals[0]);
        int idx = 1;
        while (idx < intervals.length ) {
            int [] previousInterval = mergedIntervalList.getLast();
            int startOfCurrentInterval = intervals[idx][0];
            int endOfCurrentInterval = intervals[idx][1];
            int endOfPreviousInterval = previousInterval[1];
            
            if (endOfPreviousInterval >= startOfCurrentInterval) {
                // Whenn whole second interval is in the first interval
                // so in that case we have to take the first interval end
                // other wise second interval end. We can do that by taking
                // the max between the end of first and the second interval
                previousInterval[1] = Math.max(endOfPreviousInterval, endOfCurrentInterval);
            } else {
                mergedIntervalList.add(intervals[idx]);
            }
            
            idx++;
        }
        
        return mergedIntervalList.toArray(new int [mergedIntervalList.size()][]);
    }
    
}
