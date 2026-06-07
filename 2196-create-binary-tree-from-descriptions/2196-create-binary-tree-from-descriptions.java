/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    public TreeNode createBinaryTree(int[][] descriptions) {

        Map<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> children = new HashSet<>();

        for (int[] d : descriptions) {

            int parent = d[0];
            int child = d[1];
            int isLeft = d[2];

            // Create nodes if not present
            map.putIfAbsent(parent, new TreeNode(parent));
            map.putIfAbsent(child, new TreeNode(child));

            TreeNode parentNode = map.get(parent);
            TreeNode childNode = map.get(child);

            // Connect nodes
            if (isLeft == 1) {
                parentNode.left = childNode;
            } else {
                parentNode.right = childNode;
            }

            // Mark child
            children.add(child);
        }

        // Root = node that never appeared as child
        for (int[] d : descriptions) {

            int parent = d[0];

            if (!children.contains(parent)) {
                return map.get(parent);
            }
        }

        return null;
    }
}