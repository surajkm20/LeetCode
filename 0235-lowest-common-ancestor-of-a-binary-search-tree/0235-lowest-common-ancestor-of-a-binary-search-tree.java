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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // base
        if(root == null) return null;

        if((root.val == p.val ) || (root.val == q.val)){
            return root;
        }

        TreeNode lefth = null;
        if(root.val > p.val || root.val > q.val){
            lefth = lowestCommonAncestor(root.left, p, q);
        }

        TreeNode righth = null;
        if(root.val < p.val || root.val < q.val){
            righth = lowestCommonAncestor(root.right, p, q);
        }

        if(lefth != null && righth != null) return root;
        else if(lefth != null) return lefth;
        else if(righth != null) return righth;
        else return null;
    }
}