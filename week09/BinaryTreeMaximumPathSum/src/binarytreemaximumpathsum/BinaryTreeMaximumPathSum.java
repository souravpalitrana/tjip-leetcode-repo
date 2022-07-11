/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarytreemaximumpathsum;

/**
 *
 * @author souravpalit
 */
public class BinaryTreeMaximumPathSum {

    // Time Complexity: O(n)
    // Space Complexity: Average Case: O(h) where h is the height, Worst Case O(n)
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
               
        
        return maxPathSumHelper(root).maxPathSum;
    }
    
    public NodeInfo maxPathSumHelper(TreeNode node) {
        if (node == null) {
            // We are adding root value with branch sum so it must be 0 when node
            // is null as we don't have any node. Again for maxPathSum it should
            // be Integer.MIN_VALUE because of we use 0 then in case of negative
            // value it will always give 0 as max path sum
            return new NodeInfo(0, Integer.MIN_VALUE);
        }
        
        NodeInfo leftInfo = maxPathSumHelper(node.left);
        NodeInfo rightInfo = maxPathSumHelper(node.right);
        
        int leftMaxPathAsBranch = Math.max(leftInfo.maxPathAsBranch + node.val, node.val);
        int rightMaxPathAsBranch = Math.max(rightInfo.maxPathAsBranch + node.val, node.val);
        int maxPathAsBranch = Math.max(leftMaxPathAsBranch, rightMaxPathAsBranch);
        int pathSum = Math.max(maxPathAsBranch, node.val + leftInfo.maxPathAsBranch + rightInfo.maxPathAsBranch);
        int maxPathSum = Math.max(pathSum, Math.max(leftInfo.maxPathSum, rightInfo.maxPathSum));
        
        return new NodeInfo(maxPathAsBranch, maxPathSum);
    }
    
    
    class NodeInfo {
        
        int maxPathAsBranch;
        int maxPathSum;
        
        public NodeInfo(int maxPathAsBranch, int maxPathSum) {
            this.maxPathAsBranch = maxPathAsBranch;
            this.maxPathSum = maxPathSum;
        }
                
    }
    
}
