/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uglynumberii;

/**
 *
 * @author souravpalit
 */
public class UglyNumberIISolution {

    // TLE because of checking all number is ugly or not and going forward
    // till nth ugly. However space complexity is O(1)
    public int nthUglyNumber(int n) {
        int count = 1;
        int number = 1;
        
        while (count < n) {
            number++;
            if (isUgly(number)) {
                count++;
            }
        }
        
        return number;
    }
    
    public boolean isUgly(int number) {
        number = maxDivide(number, 2);
        number = maxDivide(number, 3);
        number = maxDivide(number, 5);
        
        return number == 1;
    }
    
    public int maxDivide(int divisible, int divisor) {
        while (divisible % divisor == 0) {
            divisible = divisible / divisor;
        }
        
        return divisible;
    }
    
    // Time Complexity: O(n) Space Complexity: O(1)
    // We will multiply the prime factor with 2 3 and 5 and each time
    // take the minimum number and move forward
    public int nthUglyNumberFirstAlternate(int n) {
        int [] uglyNums = new int [n];
        uglyNums[0] = 1;
        
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        
        int factor2 = 2; 
        int factor3 = 3;
        int factor5 = 5;
        
        for (int i = 1; i < n; i++) {
            int uglyNum = Math.min(Math.min(factor2, factor3), factor5);
            uglyNums[i] = uglyNum;
            
            if (uglyNum == factor2) {
                i2++;
                factor2 = uglyNums[i2] * 2;
            }
            
            if (uglyNum == factor3) {
                i3++;
                factor3 = uglyNums[i3] * 3;
            }
            
            if (uglyNum == factor5) {
                i5++;
                factor5 = uglyNums[i5] * 5;
            }
        }
        
        return uglyNums[n - 1];
    }
    
}
