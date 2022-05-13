/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package findduplicatesubtree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author souravpalit
 */
public class FindDuplicateSubtreeSolution {

    // Time Complexity: O(n^2) Space Complexity: O(n^2)
    // Tree serialize/deserialize technique. So we traverse the tree inorder
    // and for each node we will get a string representation and we store it
    // to hashmap if not seen previously. If seen that means we found a same
    // branch and we save it to answerr
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, Integer> branchSeen = new HashMap<>();
        List<TreeNode> result = new ArrayList<TreeNode>();

        inorderTraversal(root, branchSeen, result);

        return result;
    }

    public String inorderTraversal(
            TreeNode node,
            Map<String, Integer> branchSeen,
            List<TreeNode> result
    ) {
        if (node == null) {
            return "X,";
        }
        
        StringBuilder builder = new StringBuilder();

        String leftBranchHash = inorderTraversal(node.left, branchSeen, result);
        String rightBranchHash = inorderTraversal(node.right, branchSeen, result);

        builder.append(node.val);
        builder.append(",");
        builder.append(leftBranchHash);
        builder.append(rightBranchHash);
        
        String currentHash = builder.toString();
 
        branchSeen.put(currentHash, branchSeen.getOrDefault(currentHash, 0) + 1);
        
        if (branchSeen.get(currentHash) == 2) {
            result.add(node);
        }

        return currentHash;
    }

}
