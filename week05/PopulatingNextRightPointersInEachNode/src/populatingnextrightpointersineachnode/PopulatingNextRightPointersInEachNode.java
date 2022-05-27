/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package populatingnextrightpointersineachnode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *
 * @author souravpalit
 */
public class PopulatingNextRightPointersInEachNode {

    // Time complexity: O(n) 
    // Space Complexity: O(n) for worst case recursion call stack
    public Node connect(Node root) {
        connectRight(root, null, false);
        return root;
    }

    private void connectRight(Node node, Node parent, boolean isLeftNode) {
        if (node == null) {
            return;
        }

        Node left = node.left;
        Node right = node.right;

        connectRight(left, node, true);

        if (parent == null) {
            node.next = null;
        } else if (isLeftNode) {
            node.next = parent.right;
        } else {
            if (parent.next != null) {
                node.next = parent.next.left;
            } else {
                node.next = null;
            }
        }

        connectRight(right, node, false);
    }
}
