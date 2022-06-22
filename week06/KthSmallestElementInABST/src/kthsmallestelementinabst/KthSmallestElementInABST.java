/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kthsmallestelementinabst;

/**
 *
 * @author souravpalit
 */
public class KthSmallestElementInABST {

    /**
     * Time Complexity: O(n)
     * Space Complexity: Average Complexity: O(h), Worst Complexity: O(n)
     * @param root
     * @param k
     * @return kth smallest value
     */
    public int kthSmallest(TreeNode root, int k) {
        NodeInfo nodeInfo = new NodeInfo(-1, k);
        findKthSmallest(root, nodeInfo);
        return nodeInfo.val;
    }

    public void findKthSmallest(TreeNode root, NodeInfo nodeInfo) {
        if (root == null || nodeInfo.k == 0) {
            return;
        }

        findKthSmallest(root.left, nodeInfo);

        if (nodeInfo.k != 0) {
            nodeInfo.k--;
            nodeInfo.val = root.val;
            
            if (nodeInfo.k == 0) {
                return;
            }

            findKthSmallest(root.right, nodeInfo);
        }

    }

    class NodeInfo {

        int val;
        int k;

        public NodeInfo(int val, int k) {
            this.val = val;
            this.k = k;
        }
    }
}
