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
class Pair{
    TreeNode node;
    int level;

    Pair(TreeNode node, int level){
        this.node = node;
        this.level = level;
    }
}
class Solution {
    public boolean check(TreeNode root, int topLevel, HashMap<Integer, Integer> hashmap){
        if((((topLevel+1) % 2 != 0) && root.val%2 != 0) || (((topLevel+1) % 2 == 0) && root.val%2 == 0)) {
            return false;
        }
        if(hashmap.containsKey(topLevel+1)){
            int prev = hashmap.get(topLevel+1);
            if(((topLevel+1) % 2 != 0 && prev <= root.val) || (((topLevel+1) % 2 == 0 && prev >= root.val))){
                return false;
            }
        }
        hashmap.put(topLevel+1, root.val);
        return true;
    }
    public boolean bfs(TreeNode root){
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));
        if(root.val%2 == 0) return false;

        while(!queue.isEmpty()){
            TreeNode topNode = queue.peek().node;
            int topLevel = queue.peek().level;
            queue.remove();


            if(topNode.left != null){
                if(check(topNode.left, topLevel, hashmap) == false){
                    return false;
                }
                queue.add(new Pair(topNode.left, topLevel+1));
            }

            if(topNode.right != null){
                if(check(topNode.right, topLevel, hashmap) == false){
                    return false;
                }
                queue.add(new Pair(topNode.right, topLevel+1));
            }
        }
        return true;
    }
    public boolean isEvenOddTree(TreeNode root) {
        return bfs(root);
    }
}