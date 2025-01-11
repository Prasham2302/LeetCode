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
        int left = helper(root.left);
        int right = helper(root.right);
        ans = Math.max(ans, root.val + left + right);
        ans = Math.max(ans, Math.max(root.val + left, root.val+right));
        ans = Math.max(ans, root.val);
        return Math.max(root.val, Math.max(left + root.val, right + root.val));
        
    }
}