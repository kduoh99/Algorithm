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
        if (root == null) return "";

        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        StringBuilder sb = new StringBuilder();
        sb.append("," + root.val);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();

            if (node.left != null) {
                q.offer(node.left);
                sb.append("," + node.left.val);
            } else {
                sb.append(",*");
            }

            if (node.right != null) {
                q.offer(node.right);
                sb.append("," + node.right.val);
            } else {
                sb.append(",*");
            }
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) return null;

        String[] nodes = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[1]));
        int idx = 2;

        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();

            if (!nodes[idx].equals("*")) {
                node.left = new TreeNode(Integer.parseInt(nodes[idx]));
                q.offer(node.left);
            }
            idx++;

            if (!nodes[idx].equals("*")) {
                node.right = new TreeNode(Integer.parseInt(nodes[idx]));
                q.offer(node.right);
            }
            idx++;
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));