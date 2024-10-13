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
    public int func(TreeNode root, int[] ans){
        if(root == null) return 0;

        int leftS = func(root.left, ans);
        int rightS = func(root.right, ans);

        leftS = leftS < 0 ? 0 : leftS;
        rightS = rightS < 0 ? 0 : rightS;
        ans[0] = Math.max(ans[0], leftS+rightS+root.val);
        return Math.max(leftS, rightS)+root.val;
    }
    public int maxPathSum(TreeNode root) {
        int[] ans = new int[1];
        ans[0] = Integer.MIN_VALUE;
        func(root, ans);
        return ans[0];
    }
}