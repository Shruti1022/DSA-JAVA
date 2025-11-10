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
     private Map<Integer, Integer> inorderIndex; 
    private int preorderIndex;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        inorderIndex = new HashMap<>();
        preorderIndex = 0;

        for (int i = 0; i < inorder.length; i++) {
            inorderIndex.put(inorder[i], i);
        }

        return build(preorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int inLeft, int inRight) {

        if (inLeft > inRight) {
            return null;
        }

        int rootVal = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootVal);

        int inRootIndex = inorderIndex.get(rootVal);

        root.left = build(preorder, inLeft, inRootIndex - 1);
        root.right = build(preorder, inRootIndex + 1, inRight);

        return root;
        
    }
}