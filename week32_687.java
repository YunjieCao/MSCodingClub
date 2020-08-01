/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int ret = 0;
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        int left = solve(root.left, root.val);
        int right = solve(root.right, root.val);
        ret = Math.max(ret, left+right);
        return ret;
    }
    
    private int solve(TreeNode root, int target) {
        if (root == null) return 0;
        if (root.val == target) {
            int left = solve(root.left, target);
            int right = solve(root.right, target);
            ret = Math.max(ret, left + right);
            return 1 + Math.max(left, right);
        } else {
            int left = solve(root.left, root.val);
            int right = solve(root.right, root.val);
            ret = Math.max(ret, left+right);
            return 0;
        }
    }
}