/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productofarrayexceptself;

/**
 *
 * @author souravpalit
 */
public class ProductOfArrayExceptSelfSolution {
    
    // Time Complexity: O(n) Space Complexity: O(n) because of using extra
    // array except result array
    public int[] productExceptSelf(int[] nums) {
        int [] products = new int [nums.length];
        int [] leftProducts = new int [nums.length];
        int [] rightProducts = new int [nums.length];
        leftProducts[0] = 1;
        rightProducts[nums.length - 1] = 1;
        
        for (int i = 1; i < nums.length; i++) {
            leftProducts[i] = leftProducts[i - 1] * nums[i - 1];
        }
        
        for (int i = nums.length - 2; i >= 0; i--) {
            rightProducts[i] = rightProducts[i + 1] * nums[i + 1];
        }
        
        for (int i = 0; i < nums.length; i++) {
            products[i] = leftProducts[i] * rightProducts[i];
        }
        
        return products;
    }
    
    // Time Complexity: O(n) Space Complexity: O(n) because of using extra
    // array except result array
    public int[] productExceptSelfAlternate(int[] nums) {
        int [] products = new int [nums.length];
        products[0] = 1;
        
        for (int i = 1; i < nums.length; i++) {
            products[i] = products[i - 1] * nums[i - 1];
        }
        
        int rightProduct = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            products[i] = rightProduct * products[i];
            rightProduct *= nums[i];
        }
        
        return products;
    }
}
