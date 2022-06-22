/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package findduplicatesubtree;

import java.util.List;

/**
 *
 * @author souravpalit
 */
public class FindDuplicateSubtree {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TreeNode root = null; 
        root = new TreeNode(1); 
        root.left = new TreeNode(2); 
        root.right = new TreeNode(3); 
        root.left.left = new TreeNode(4); 
        root.right.left = new TreeNode(2); 
        root.right.left.left = new TreeNode(4); 
        root.right.right = new TreeNode(4); 
        
        FindDuplicateSubtreeSolution solution = new FindDuplicateSubtreeSolution();
        List<TreeNode> result = solution.findDuplicateSubtrees(root);
        
        System.out.println(result);
    }
    
}
