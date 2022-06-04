/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validatebinarysearchtree;

/**
 *
 * @author souravpalit
 */
public class ValidateBinarySearchTree {

    // Time Complexity: O(n)
    // Space Complexity: Average Case:: O(h) where h is the max height
    // Worst case: O(n)
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    public boolean isValidBST(TreeNode root, long min, long max) {
         if (root == null) {
             return true;
         }
         
         if (root.val <= min || root.val >= max) {
             return false;
         }
         
         return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }

}
