/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constructbinarytreefrompreorderandinordertraversal;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode: 105. Construct Binary Tree from Preorder and Inorder Traversal
 * Problem Link: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * @author souravpalit
 */
public class Solution {
    
    Map<Integer, Integer> inorderIdxMap;
    int preorderIdx;;
    
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderIdxMap = new HashMap<>();
        preorderIdx = 0;
        
        for (int i = 0; i < inorder.length; i++) {
            inorderIdxMap.put(inorder[i], i);
        }
        
        return buildTree(preorder, 0, inorder.length - 1);
    }
    
    public TreeNode buildTree(int[] preorder, int low, int high) {
        if (low > high) {
            return null;
        }
        
        int mid = inorderIdxMap.get(preorder[preorderIdx]);
        TreeNode currentNode = new TreeNode(preorder[preorderIdx++]);
        currentNode.left = buildTree(preorder, low, mid - 1);
        currentNode.right = buildTree(preorder, mid + 1, high);
        return currentNode;
    }
}
