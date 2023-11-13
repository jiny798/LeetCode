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
    public static int maxValue = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxValue = 0;
        postOrder(root);
        return maxValue;
    }
    
    public int postOrder(TreeNode root){
        int left = 0;
        int right = 0;
        if(root.left != null){
            left += postOrder( root.left );
        }
        if(root.right != null){
            right += postOrder( root.right );
        }
        if(left+right > maxValue){
            maxValue = left+right;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        if(left > right){
            return left+1;
        }else{
            return right+1;
        }

        
    }
}