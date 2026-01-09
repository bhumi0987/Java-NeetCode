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
    public int solve(TreeNode root){
        if(root==null){
            return 0;
        }
        return 1+Math.max(solve(root.left),solve(root.right));
    }
    public TreeNode solve1(TreeNode root,int max,int len){
        if(root==null){
            return null;
        }
        if(max-1==len){
            return root;
        }
        TreeNode left=solve1(root.left,max,len+1);
        TreeNode right=solve1(root.right,max,len+1);
        if(left!=null&&right!=null){
            return root;
        }
        return left!=null?left:right;
    }
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        int max=solve(root);
        return solve1(root,max,0);
    }
}