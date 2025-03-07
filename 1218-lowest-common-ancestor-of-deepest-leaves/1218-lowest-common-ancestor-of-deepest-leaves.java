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
    TreeNode ans;
    int maxDepth;
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        ans = null;
        maxDepth = 0;
        lca(root, 0);
        return ans;
    }
    public int lca(TreeNode root, int depth){
        maxDepth = Math.max(depth, maxDepth);
        if (root == null) {
            return depth;
        }
        int left = lca(root.left, depth+1);
        int right = lca(root.right, depth+1);
        if (left == right && maxDepth == left) {
            ans = root;
        }
        // System.out.println(root.val +" "+left+" "+right);
        return Math.max(left, right);
    }
}