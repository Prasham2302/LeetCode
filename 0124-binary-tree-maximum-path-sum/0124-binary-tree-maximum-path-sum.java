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
    int ans;
    public int maxPathSum(TreeNode root) {
        if(root == null){
            return 0;
        }
        ans = root.val;
        helper(root);
        return ans;
    }
    public int helper(TreeNode root){
        if(root == null){
            return 0;
        }
        ans = Math.max(root.val, ans);
        int left = helper(root.left);
        ans = Math.max(ans, root.val + left);
        int right = helper(root.right);
        ans = Math.max(ans, root.val + right);
        ans = Math.max(left + right + root.val, ans);
        return Math.max(Math.max(left + root.val, right + root.val), root.val);
    }
}