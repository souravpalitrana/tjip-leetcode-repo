/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lowestcommonancestorofabinarytree;

/**
 *
 * @author souravpalit
 */
public class LowestCommonAncestorOfABinaryTree {

    private TreeNode loweestCommonAncestor = null;

    /**
     * Time Complexity: O(n) 
     * Space Complexity: Average Case: O(h), Worst Case:: O(n)
     * @param root node of the tree
     * @param p target node 1
     * @param q target node 2
     * @return lowest common ancestor
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findLowestCommonAncestor(root, p, q);
        return loweestCommonAncestor;
    }

    public boolean findLowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (loweestCommonAncestor != null || root == null) {
            return false;
        }

        boolean isInLeft = findLowestCommonAncestor(root.left, p, q);
        boolean isInRight = findLowestCommonAncestor(root.right, p, q);

        if (isInLeft && isInRight) {
            loweestCommonAncestor = root;
        } else if ((isInLeft || isInRight) && (root == p || root == q)) {
            loweestCommonAncestor = root;
        }

        boolean isCurrentNodeIsTarget = (root == p || root == q);

        return isInLeft || isInRight || isCurrentNodeIsTarget;
    }

}
