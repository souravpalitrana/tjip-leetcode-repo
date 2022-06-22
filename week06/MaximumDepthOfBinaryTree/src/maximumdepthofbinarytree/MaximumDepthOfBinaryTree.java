/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maximumdepthofbinarytree;

/**
 *
 * @author souravpalit
 */
public class MaximumDepthOfBinaryTree {

    // Time Complexity: O(n) 
    // Space Complexity: Average Case O(h) where h is the height of the binary 
    // tree. Worst case O(n)
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(
                1 + getMaxDepth(root.left, 1), 
                1 + getMaxDepth(root.right, 1)
        );
    }
    
    public int getMaxDepth(TreeNode root, int depth) {
        if (root == null) {
            return depth - 1;
        }
        
        return Math.max(
                getMaxDepth(root.left, depth + 1), 
                getMaxDepth(root.right, depth + 1)
        );
    }
}
