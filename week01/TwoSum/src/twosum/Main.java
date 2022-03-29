/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twosum;

/**
 *
 * @author souravpalit
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int [] nums = {2,7,11,15};
        int target = 9;
        
        Solution towSumProblemSolution = new Solution();
        int [] result = towSumProblemSolution.twoSum(nums, target);
        printResult(result);
        
    }
    
    public static void printResult(int [] result) {
        System.out.print("[");
        for (Integer idx : result) {
            System.out.print(" " + idx + " ");
        }
        System.out.print("]");
    }
    
}
