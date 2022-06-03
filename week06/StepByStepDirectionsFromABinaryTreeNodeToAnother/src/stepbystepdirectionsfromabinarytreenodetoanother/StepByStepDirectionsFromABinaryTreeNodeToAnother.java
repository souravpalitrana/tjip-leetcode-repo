/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stepbystepdirectionsfromabinarytreenodetoanother;

/**
 *
 * @author souravpalit
 */
public class StepByStepDirectionsFromABinaryTreeNodeToAnother {

    public String getDirections(TreeNode root, int startValue, int destValue) {
        findNode(root, startValue, destValue, "");
    }
    
    public boolean findNode(TreeNode root, int startValue, int destValue, String path) {
        if (root == null) {
            return false;
        }
        
        boolean isInLeft = findNode(root.left, startValue, destValue, "");
        boolean isInRight = findNode(root.right, startValue, destValue, "");
    }
    
    
}
