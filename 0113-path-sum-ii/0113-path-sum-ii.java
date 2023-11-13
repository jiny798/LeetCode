/**
 * Definition for a binary tree node.
 */


class Solution {
    // public class TreeNode {
    //   int val;
    //   TreeNode left;
    //   TreeNode right;
    //   TreeNode() {}
    //   TreeNode(int val) { this.val = val; }
    //   TreeNode(int val, TreeNode left, TreeNode right) {
    //       this.val = val;
    //       this.left = left;
    //       this.right = right;
    //   }
    // }
    public static List<List<Integer>> answer = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        answer = new ArrayList<>();
        if(root != null)
        preOrder(root,targetSum,new ArrayList<>());
        
        return answer;
    }
    
    public void preOrder(TreeNode root,int targetSum, List<Integer> list){
        list.add(root.val);
        // System.out.println(root.val);
        if(root.left != null){
            preOrder(root.left, targetSum - root.val, list);  // 2
        }
        
        if(root.right != null){
            preOrder(root.right, targetSum - root.val, list);
        }
        
        if(root.left == null && root.right == null){
            if(root.val == targetSum){
                List<Integer> newList = new ArrayList<>(list);
                answer.add(newList);
            }
        }
        list.remove(list.size()-1);        
    }

}