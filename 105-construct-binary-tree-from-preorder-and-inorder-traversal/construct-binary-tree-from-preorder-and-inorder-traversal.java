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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> mp = new HashMap<>();
        for(int i = 0; i<inorder.length;i++){
            mp.put(inorder[i],i);
        }
        int[] prein = {0};
        return traverseroot(mp,preorder,prein,0,inorder.length-1);
    }
    static TreeNode traverseroot(Map<Integer,Integer> mp,int[] preorder,int[] prein,int left,int right){
        if(left>right) return null;
        int rootval = preorder[prein[0]];
        prein[0]++;
        TreeNode root = new TreeNode(rootval);
        int index = mp.get(rootval);

        root.left = traverseroot(mp,preorder,prein,left,index-1);
        root.right = traverseroot(mp,preorder,prein,index+1,right);

        return root;
    }
}