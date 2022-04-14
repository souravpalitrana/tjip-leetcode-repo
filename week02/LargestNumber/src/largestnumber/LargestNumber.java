/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package largestnumber;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author souravpalit
 */
public class LargestNumber {

    /**
     * @param args the command line arguments
     */
    
    private static class LargerNumberComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            String order1 = a + b;
            String order2 = b + a;
            System.out.println("a + b = " + order1 + "  b + a = " + order2);
           return order2.compareTo(order1);
        }
    }
    
    private static class LargerNumberComparator2 implements Comparator<Integer> {
        @Override
        public int compare(Integer a, Integer b) {
            return 1;
        }
    }
    
    public static void main(String[] args) {
        int a = 10;
        
        //String [] nums = {"3", "9", "5", "34", "30"};
        
        ///String [] nums = {"3", "9"};
        
        ///Arrays.sort(nums, new LargerNumberComparator());
        
        /*Arrays.sort(nums, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                String order1 = a + b;
                String order2 = b + a;
                int result = order2.compareTo(order1);
                System.out.println("a + b = " + order1 + "  b + a = " + order2 + "  Compare Result : " + result);
                return result;
                
            }
            
        });*/
        
        Integer [] nums = {3, 9, 5, 34, 30};
        int [] nums2 = {3, 9};
        Arrays.sort(nums, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                int prefixOfA = getFirstDigit(a);
                int prefixOfB = getFirstDigit(b);
                
                if (prefixOfA > prefixOfB) {
                    return -1;
                } else if (prefixOfA < prefixOfB) {
                    return 1;
                } else {
                    return (a > b) ? -1 : 1;
                }
            }
        });
        
        ///Arrays.sort(nums2, new LargerNumberComparator2());
        
        /*Arrays.sort(nums, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return -1;
            }
        });*/
        
        	
        
     
        
        System.out.println(getFirstDigit(a));
    }
    
    public static int getFirstDigit(int value) {
        if (value <= 9) {
            return value;
        }
        int digitCount = ((int) Math.log10(value));
        return (int) (value / Math.pow(10, digitCount));
    }
    
    public static int getLastDigit(int value) {
        if (value <= 9) {
            return value;
        }
        return value % 10;
    }
    
    public static int getDigitCount(int value) {
        if (value <= 9) {
            return 1;
        }
        return ((int) Math.log10(value)) + 1;
    }
    
}
