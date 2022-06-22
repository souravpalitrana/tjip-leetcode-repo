/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package symmetrictree;

/**
 *
 * @author souravpalit
 */
public class SymmetricTree {

    // Time Complexity: O(n)
    // Space Complexity: Worst Case: O(n), Average Case: O(h) here h is the height
    public boolean isSymmetric(TreeNode root) {
       return isSymmetric(root, root);
    }
    
    public boolean isSymmetric(TreeNode node1, TreeNode node2) {
       if (node1 == null && node2 == null) {
           return true;
       } else if (node1 == null || node2 == null) {
           return false;
       }
       
       return (node1.val == node2.val) && 
               isSymmetric(node1.left, node2.right) && 
               isSymmetric(node1.right, node2.left);
    }
    
}
