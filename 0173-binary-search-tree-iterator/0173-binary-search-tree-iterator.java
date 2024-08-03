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
class BSTIterator {
    public void func(TreeNode root, ArrayList<Integer> sorted){
        if(root == null) return;

        func(root.left, sorted);
        sorted.add(root.val);
        func(root.right, sorted);
        return;
    }
    
    int[] a = new int[1];
    ArrayList<Integer> sorted = new ArrayList<>();
    public BSTIterator(TreeNode root) {
        func(root, sorted);
    }
    
    public int next() {
        return sorted.get(a[0]++);
    }
    
    public boolean hasNext() {
        if(a[0] >= sorted.size()) return false;
        return true;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */