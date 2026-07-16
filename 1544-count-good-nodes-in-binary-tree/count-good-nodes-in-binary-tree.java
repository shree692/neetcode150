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
    public int goodNodes(TreeNode root) {
      return countr(root,root.val);  
    }
    private int countr(TreeNode root,int maxval){
      if(root == null) return 0;
      int count = 0;
      if(root.val >= maxval) count = 1;
      maxval = Math.max(maxval,root.val);
      count += countr(root.left,maxval);
      count += countr(root.right,maxval);
      return count;
    }
}
