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
    TreeNode func(int[] preorder, int indPL, int indPH, int[] inorder, int indIL, int indIH, HashMap<Integer, Integer> hashmap){
        // base
        if(indPL > indPH || indIL > indIH) return null;

        TreeNode root = new TreeNode(preorder[indPL]);
        int inOrderRootInd = hashmap.get(root.val);
        int numsLeft = inOrderRootInd - indIL;

        root.left = func(preorder, indPL+1, indPL+numsLeft, inorder, indIL, inOrderRootInd-1, hashmap);
        root.right = func(preorder, indPL+numsLeft+1, indPH, inorder, inOrderRootInd+1, indIH, hashmap);

        return root;

    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            hashmap.put(inorder[i], i);
        }
        return func(preorder, 0, preorder.length, inorder, 0, inorder.length-1, hashmap);
    }
}