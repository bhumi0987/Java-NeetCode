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
    int ans=0;
    public void solve(TreeNode root,int sum){
        if(root==null){
            return;
        }
        if(root.left==null&&root.right==null){
            ans+=sum;
        }
        if(root.left!=null){
            solve(root.left,(sum<<1)|root.left.val);
        }
        if(root.right!=null){
            solve(root.right,(sum<<1)|root.right.val);
        }
    }
    public int sumRootToLeaf(TreeNode root) {
        solve(root,root.val);
        return ans;
    }
}