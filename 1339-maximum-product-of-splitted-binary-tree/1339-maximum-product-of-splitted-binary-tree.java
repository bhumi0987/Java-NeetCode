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
    int mod=(int)1e9+7;
    int sum;
    long product;
    public int solve1(TreeNode root){
        if(root==null){
            return 0;
        }
        int sum1=solve1(root.left)+solve1(root.right)+root.val;
        int ans=sum-sum1;
        product=Math.max(product,(long)sum1*ans);
        return sum1;
    }
    public int solve(TreeNode root){
        if(root==null){
            return 0;
        }
        return solve(root.left)+solve(root.right)+root.val;
    }
    public int maxProduct(TreeNode root) {
        sum=solve(root);
        product=0l;
        solve1(root);
        return (int)(product%mod);
    }
}