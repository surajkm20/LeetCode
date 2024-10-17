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
    public void convt(TreeNode root, int[] maxi){
        if(root == null) return;

        convt(root.right, maxi);
        root.val = root.val + maxi[0];
        maxi[0] = root.val;
        convt(root.left, maxi);
        return;
    }
    public TreeNode convertBST(TreeNode root) {
        int[] maxi = new int[1];
        maxi[0] = 0;
        convt(root, maxi);
        return root;
    }
}