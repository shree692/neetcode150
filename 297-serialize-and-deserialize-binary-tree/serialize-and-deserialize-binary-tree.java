/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
       StringBuilder sb = new StringBuilder();
       preorder(root,sb);
       return sb.toString();
    }
    private void preorder(TreeNode root,StringBuilder sb){
        if(root == null){
            sb.append("null,");
            return;
        }
        sb.append(root.val).append(",");
        preorder(root.left,sb);
        preorder(root.right,sb);

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return build(queue);
    }
    private TreeNode build(Queue<String> queue){
        String value = queue.poll();
        if(value.equals("null")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(value));
        root.left = build(queue);
        root.right = build(queue);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));